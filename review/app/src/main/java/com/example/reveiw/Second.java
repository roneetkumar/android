package com.example.reveiw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.reveiw.model.Car;
import com.example.reveiw.model.CarFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;





public class Second extends AppCompatActivity implements ValueEventListener, AdapterView.OnItemClickListener, View.OnClickListener {

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Cars");
    ImageButton btnOpenClose;
    DrawerLayout drawerLayout;
    ListView listView;
    ArrayList<Car> list = new ArrayList<>();
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle=getIntent().getExtras();
        data = bundle.get("data").toString();

        listView = findViewById(R.id.listView);
        drawerLayout = findViewById(R.id.drawer);

        myRef.addValueEventListener(this);

        //2. Do a layout inflation : Convert xml file to a view object
        //We have a layout and convert it to view - inflation
        LayoutInflater li = LayoutInflater.from(this);
        View customToolbar = li.inflate(R.layout.custom_toolbar, null);

        //Set Image button
        btnOpenClose = customToolbar.findViewById(R.id.btnOpenClose);
        btnOpenClose.setOnClickListener(this);

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()){

            String brand = ds.child("brand").getValue().toString();

            if (brand.equals(data)){
                String model = ds.child("model").getValue().toString();
                String id = ds.child("id").getValue().toString();
                Double price = Double.valueOf(ds.child("price").getValue().toString());
                Integer year = Integer.valueOf(ds.child("year").getValue().toString());

                list.add(new Car(id,brand,model,price,year));
            }
        }

        ArrayAdapter<Car> countryAdapter = new ArrayAdapter<Car>(this,android.R.layout.simple_list_item_1, list);
        listView.setAdapter(countryAdapter);



        listView.setOnItemClickListener(this);


        //Set the custom toolbar
        //1. To get the actual toolbar (we have to replace this predefined toolbar with our own)
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowTitleEnabled(false); //hide the title

        //2. Do a layout inflation : Convert xml file to a view object
        //We have a layout and convert it to view - inflation
        LayoutInflater li = LayoutInflater.from(this);
        View customToolbar = li.inflate(R.layout.custom_toolbar, null);

        //3. Attach the custom toolbar to our app
        mActionBar.setCustomView(customToolbar);
        mActionBar.setDisplayShowCustomEnabled(true);

        //Set Image button
        btnOpenClose = customToolbar.findViewById(R.id.btnOpenClose);
        btnOpenClose.setOnClickListener(this);

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //save the data to send
        Bundle bundle = new Bundle();
        bundle.putSerializable("car",list.get(position));

        //steps of sending the data to the Fragment

        //1, Attach the data to the countryFragment class
        CarFragment carFragment = new CarFragment();
        carFragment.setArguments(bundle);

        //2. Reference the FragmentManager
        android.app.FragmentManager fragmentManager = getFragmentManager();

        //3. Replace the linear layout by the Fragment (fragment_country.xml)
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_ui, carFragment);
        fragmentTransaction.commit();

        //4. Assign a title to the fragments
        setTitle(list.get(position).getModel());

        //5. Close the drawer layout

        drawerLayout.closeDrawer(listView);




    }

    @Override
    public void onClick(View v) {
        if (drawerLayout.isDrawerOpen(listView)){
            drawerLayout.closeDrawer(listView);
        }
        else
        {
            drawerLayout.openDrawer(listView);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
