package com.example.testgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText edttk, edtmk,edttendangnhap,edtmatkhau;
    Button btndn, btndk,btnhuy,btndangki;
    ImageView imganh,imgvietnam;
    TextView txtchitiet,txtchao,txt1,txt2;
    String tk,mk,taikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thuan();
        txtchao = findViewById(R.id.txtchao);
        String chao = txtchao.getText().toString().trim();
        txt1 = findViewById(R.id.txt1);
        String one = txt1.getText().toString().trim();
        txt2 = findViewById(R.id.txt2);
        String two = txt2.getText().toString().trim();

        imganh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("en");

            }
        });

        imgvietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("vi");

            }
        });

        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taikhoan = edttk.getText().toString().trim();
                if (edttk.getText().length() !=0 && edtmk.getText().length()!=0){
                    if (edttk.getText().toString().equals(tk) && edtmk.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity.this,chao+" "+tk,Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this,Home.class);
                        startActivity(intent1);

                    }else
                    if (edttk.getText().toString().equals("thuan") && edtmk.getText().toString().equals("123")){
                        Toast.makeText(MainActivity.this,chao+" "+taikhoan,Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this,Home.class);
                        startActivity(intent1);
                    }else {
                        Toast.makeText(MainActivity.this,""+one,Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,""+two,Toast.LENGTH_SHORT).show();
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


        txtchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ct = new Intent();
                ct.setClass(MainActivity.this,Detail.class);
                startActivity(ct);

            }
        });
    }

    public void change(String language){
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        Intent thaydoi = new Intent(MainActivity.this,MainActivity.class);
        startActivity(thaydoi);
    }


    private void thuan(){
        edttk = (EditText) findViewById(R.id.edttk);
        edtmk = (EditText) findViewById(R.id.edtmk);
        btndn = (Button) findViewById(R.id.btndn);
        btndk = (Button) findViewById(R.id.btndk);
        imganh = (ImageView) findViewById(R.id.imganh);
        imgvietnam = (ImageView) findViewById(R.id.imgvietnam);
        txtchitiet = (TextView) findViewById(R.id.txtchitiet);

    }

}