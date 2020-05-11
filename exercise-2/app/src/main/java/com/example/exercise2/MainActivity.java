package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

    }

    private void add(View view){
        //int tempRes =  Integer.parseInt(this.num1.getText().toString()) + Integer.parseInt(this.num2.getText().toString());
        //TextView result = findViewById(R.id.result);

        //result.setText("hello");
    }

}
