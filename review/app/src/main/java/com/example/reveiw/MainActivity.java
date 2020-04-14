package com.example.reveiw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.reveiw.model.Car;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, ValueEventListener  {

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Cars");

    ArrayList<Car> list = new ArrayList<>();
    ArrayAdapter<String> carArrayAdapter;
    ArrayList<String> brandList = new ArrayList<>();

    ImageView imageView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView3);

        brandList.add("Select Brand");

        myRef.addValueEventListener(this);

        spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        carArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, brandList);

        carArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(carArrayAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String brand = String.valueOf(spinner.getSelectedItem());

        if(brand != "Select Brand"){
            Intent intent= new Intent(MainActivity.this, Second.class);
            intent.putExtra("brand", brand);
            intent.putExtra("list", (Serializable) list);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()){

            if (!ds.getKey().equals("Img")){
                String brand = ds.child("brand").getValue().toString();
                String model = ds.child("model").getValue().toString();
                String id = ds.child("id").getValue().toString();
                Double price = Double.valueOf(ds.child("price").getValue().toString());
                Integer year = Integer.valueOf(ds.child("year").getValue().toString());

                if(!brandList.contains(brand)){
                    brandList.add(brand);
                }

                list.add(new Car(brand,id,model,price,year));
            }else{
                Picasso.get().load(ds.getValue().toString()).into(imageView);
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
