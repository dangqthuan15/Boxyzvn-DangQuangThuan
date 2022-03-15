package com.example.testgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class Signup extends AppCompatActivity {
    AutoCompleteTextView auto;
    Button btndangky;
    String[] arrayThanhpho = {"Ha Noi","Da Nang","Ho Chi Minh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auto = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,arrayThanhpho);
        auto.setAdapter(arrayAdapter);
        auto.setThreshold(1);
        auto.setDropDownHeight(400);
    }
}
