package com.example.testgithub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class coban extends AppCompatActivity {
    EditText edta,edtb,edtkq,edtsearch;
    Button btncong, btntru, btnnhan, btnchia, btnclear, btnlichsu,btntao;
    TabHost tabhostcoban;
    TextView txtlichsu;
    String lichsu= "";
    String title,des;
    String [] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coban);
        btntao = findViewById(R.id.btntao);
        listView = findViewById(R.id.listview);
        edtsearch = findViewById(R.id.edtsearch);
        initList();

        edtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coban.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        addControl();
        addEvents();
        btntao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thuan = new Intent(coban.this,MainActivity1.class);
                startActivity(thuan);

//                final Dialog dialog = new Dialog(coban.this);
//                dialog.setTitle("abc");
//                dialog.setCancelable(false);
//
//                dialog.setContentView(R.layout.activity_thembaiviet);
//                final EditText edttitle = (EditText) dialog.findViewById(R.id.edttitle);
//                final EditText edtdes = (EditText) dialog.findViewById(R.id.edtdes);
//                Button btnthem = (Button) dialog.findViewById(R.id.btnthem);
//                Button btnxoa = (Button) dialog.findViewById(R.id.btnxoa);
//                Button btnsua = (Button) dialog.findViewById(R.id.btnsua);
//
//
//                btnthem.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        title = edttitle.getText().toString().trim();
//                        des = edtdes.getText().toString().trim();
//
//
//                        edttitle.setText(title);
//                        edtdes.setText(des);
//
//                        dialog.cancel();
//                    }
//                });
//
//                btnxoa.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.cancel();
//                    }
//                });
//                btnsua.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.cancel();
//                    }
//                });
//                dialog.show();


            }
        });
    }
    public void onPause(){
        super.onPause();
        SharedPreferences mypre = getSharedPreferences("mysave",MODE_PRIVATE);
        SharedPreferences.Editor myedit = mypre.edit();
        myedit.putString("ls",lichsu);
        myedit.commit();
    }

    public void  addEvents(){

        SharedPreferences mypre = getSharedPreferences("mysave",MODE_PRIVATE);
        lichsu = mypre.getString("ls","");
        txtlichsu.setText(lichsu);
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a + b;
                edtkq.setText(c + "");
                lichsu = a + " + " + b + " = " +c;
                txtlichsu.setText(lichsu);
                lichsu += "\n";

            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a - b;
                edtkq.setText(c + "");
                lichsu = a + " - " + b + " = " +c;
                txtlichsu.setText(lichsu);
                lichsu += "\n";
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a * b;
                edtkq.setText(c + "");
                lichsu = a + " * " + b + " = " +c;
                txtlichsu.setText(lichsu);
                lichsu += "\n";
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a / b;
                edtkq.setText(c + "");
                lichsu = a + " / " + b + " = " +c;
                txtlichsu.setText(lichsu);
                lichsu += "\n";
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edta.setText("");
                edtb.setText("");
                edtkq.setText("");
                txtlichsu.setText("");

            }
        });
        btnlichsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btntao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent them = new Intent(coban.this,thembaiviet.class);
                startActivity(them);
            }
        });

    }


    public void addControl(){
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtkq = findViewById(R.id.edtkq);
        txtlichsu = findViewById(R.id.txtlichsu);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnnhan = findViewById(R.id.btnnhan);
        btnchia = findViewById(R.id.btnchia);
        btnclear = findViewById(R.id.btnclear);
        btnlichsu = findViewById(R.id.btnls);
        tabhostcoban = findViewById(R.id.tabhostcoban);
        tabhostcoban.setup();
        createTab();


    }
    public void createTab(){
        //tạo tab1
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabhostcoban.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Tài liệu");
        tabhostcoban.addTab(tabSpec1);

        //tạo tab2
        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabhostcoban.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Máy tính");
        tabhostcoban.addTab(tabSpec2);

    }
    public void initList() {
        items = new String[]{"Không", "Có", "Cái", "Gì", "Để", "Search", "Đâu"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cơ Bản");
        return super.onCreateOptionsMenu(menu);
    }


}