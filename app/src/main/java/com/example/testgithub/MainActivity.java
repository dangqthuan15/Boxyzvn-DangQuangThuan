package com.example.testgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    EditText edttk, edtmk;
    Button btndn, btndk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edttk = findViewById(R.id.edttk);
        edtmk = findViewById(R.id.edtmk);
        btndn = findViewById(R.id.btndn);
        btndk = findViewById(R.id.btndk);

        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this,Home.class);
                startActivity(intent1);

            }
        });
//
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent();
                intent2.setClass(MainActivity.this,Signup.class);
                startActivity(intent2);
            }
        });
    }

}