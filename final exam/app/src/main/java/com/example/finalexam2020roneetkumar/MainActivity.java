package com.example.finalexam2020roneetkumar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.finalexam2020roneetkumar.model.Client;
import com.example.finalexam2020roneetkumar.model.Fragment_Client;

import java.util.ArrayList;


//RONEET KUMAR

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listview;
    DrawerLayout drawerLayout;
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<String> clientNames = new ArrayList<>();

    ArrayAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listviewC_Roneet);

        drawerLayout = findViewById(R.id.drawer_Roneet);

        clients = FileManagement.readFile(this,"clients.txt");

        System.out.println(clients);

        for (Client client : clients){
            clientNames.add(client.getName());
        }

        listAdapter = new ArrayAdapter<String>(this,R.layout.list_view_item,clientNames);

        listview.setAdapter(listAdapter);

        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("client", clients.get(position));

        Fragment_Client client_fragment = new Fragment_Client();
        client_fragment.setArguments(bundle);

        android.app.FragmentManager fragmentManager = getFragmentManager();

        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_ui, client_fragment);
        fragmentTransaction.commit();

        drawerLayout.closeDrawer(listview);
    }
}
