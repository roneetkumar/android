package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare a widget

    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextName.setText("Hola");
    }

    public void show(View view){
        String name = " " +   editTextName.getText().toString();
        Toast.makeText(this,getString(R.string.nameString) + name,Toast.LENGTH_SHORT).show();
    }

    public void quit(View view){
        finish();
    }

}
