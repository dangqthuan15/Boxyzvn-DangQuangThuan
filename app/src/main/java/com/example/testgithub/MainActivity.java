package com.example.testgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    AutoCompleteTextView auto;
    EditText edttk, edtmk,edttendangnhap,edtmatkhau;
    Button btndn, btndk,btnhuy,btndangki;
    String tk,mk;
//    String[] arrayThanhpho = {"Ha Noi","Da Nang","Ho Chi Minh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        auto = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,arrayThanhpho);
//        auto.setAdapter(arrayAdapter);
//        auto.setThreshold(1);
//        auto.setDropDownHeight(400);
//        edttk = findViewById(R.id.edttk);
//        edtmk = findViewById(R.id.edtmk);
//        btndn = findViewById(R.id.btndn);
//        btndk = findViewById(R.id.btndk);
        thuan();




        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edttk.getText().length() !=0 && edtmk.getText().length()!=0){
                    if (edttk.getText().toString().equals(tk) && edtmk.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this,Home.class);
                        startActivity(intent1);

                    }else  if(edttk.getText().toString().equals("thuan") && edtmk.getText().toString().equals("123")){
                        Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this,Home.class);
                        startActivity(intent1);
                    }else {
                        Toast.makeText(MainActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Mời bạn nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("abc");
                dialog.setCancelable(false);

                dialog.setContentView(R.layout.activity_signup);
                final EditText edttendangnhap = (EditText) dialog.findViewById(R.id.edttendangnhap);
                final EditText edtmatkhau = (EditText) dialog.findViewById(R.id.edtmatkhau);
                Button btnhuy = (Button) dialog.findViewById(R.id.btnhuy);
                Button btndangki = (Button) dialog.findViewById(R.id.btndangki);

                btndangki.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tk = edttendangnhap.getText().toString().trim();
                        mk = edtmatkhau.getText().toString().trim();

                        edttk.setText(tk);
                        edtmk.setText(mk);

                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });

    }


    private void thuan(){
        edttk = (EditText) findViewById(R.id.edttk);
        edtmk = (EditText) findViewById(R.id.edtmk);
        btndn = (Button) findViewById(R.id.btndn);
        btndk = (Button) findViewById(R.id.btndk);
    }

}