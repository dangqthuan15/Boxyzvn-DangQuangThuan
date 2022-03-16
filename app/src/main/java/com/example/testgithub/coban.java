package com.example.testgithub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

public class coban extends AppCompatActivity {
    EditText edta,edtb,edtkq;
    Button btncong, btntru, btnnhan, btnchia, btnclear;
    TabHost tabhostcoban;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coban);
        addControl();
        addEvents();


    }
    public void  addEvents(){
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a + b;
                edtkq.setText(c + "");
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a - b;
                edtkq.setText(c + "");
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a * b;
                edtkq.setText(c + "");
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a / b;
                edtkq.setText(c + "");
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edta.setText("");
                edtb.setText("");
                edtkq.setText("");
            }
        });

    }

    public void addControl(){
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtkq = findViewById(R.id.edtkq);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnnhan = findViewById(R.id.btnnhan);
        btnchia = findViewById(R.id.btnchia);
        btnclear = findViewById(R.id.btnclear);
        tabhostcoban = findViewById(R.id.tabhostcoban);
        tabhostcoban.setup();
        createTab();

    }
    public void createTab(){
        //tạo tab1
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabhostcoban.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Các bài giảng");
        tabhostcoban.addTab(tabSpec1);

        //tạo tab2
        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabhostcoban.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Bảng tính");

        tabhostcoban.addTab(tabSpec2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cơ Bản");
        return super.onCreateOptionsMenu(menu);
    }
}