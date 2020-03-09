package com.example.exampractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.exampractice.model.Person;

import java.io.Serializable;

public class Data extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();


        Person p1 = (Person) intent.getSerializableExtra("DATA");


        Toast.makeText(this, p1.getName(), Toast.LENGTH_SHORT).show();
    }
}
