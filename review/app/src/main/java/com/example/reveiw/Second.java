package com.example.reveiw;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.reveiw.model.Car;
import com.example.reveiw.model.CarFragment;

import java.util.ArrayList;

public class Second extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ImageView btnOpenClose;
    DrawerLayout drawerLayout;
    ListView listView;
    ArrayList<Car> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();

        String  brand = bundle.get("brand").toString();

        ArrayList<Car> list =  (ArrayList<Car>) bundle.getSerializable("list");

        listView = findViewById(R.id.listView);
        drawerLayout = findViewById(R.id.drawer);

    //Set the custom toolbar
        //1. To get the actual toolbar (we have to replace this predefined toolbar with our own)
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowTitleEnabled(false); //hide the title

        //2. Do a layout inflation : Convert xml file to a view object
        //We have a layout and convert it to view - inflation
        LayoutInflater li = LayoutInflater.from(this);
        View customToolbar = li.inflate(R.layout.custom_toolbar, null);

//        customToolbar.wi;

        //3. Attach the custom toolbar to our app
        mActionBar.setCustomView(customToolbar);
        mActionBar.setDisplayShowCustomEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); getSupportActionBar().setDisplayShowHomeEnabled(true);


        //Set Image button
        btnOpenClose = customToolbar.findViewById(R.id.btnOpenClose);
        btnOpenClose.setOnClickListener(this);

        fillSideBar(brand,list);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void fillSideBar(String tempBrand,  ArrayList<Car> list){

       // System.out.println(list);

        for (Car car : list){
           // System.out.println(tempBrand +  " + " + car.getBrand());

            if (tempBrand.equals(car.getBrand())){
                String model = car.getModel();
                String id = car.getId();
                Double price = car.getPrice();
                Integer year = car.getYear();
                String brand = car.getBrand();

                modelList.add(new Car(brand,id,model,price,year));
            }
        }

        ArrayAdapter<Car> countryAdapter = new ArrayAdapter<Car>(this,android.R.layout.simple_list_item_1, modelList);
        listView.setAdapter(countryAdapter);

        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //save the data to send
        Bundle bundle = new Bundle();
        bundle.putSerializable("car", modelList.get(position));

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
        setTitle(modelList.get(position).getModel());

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
