package com.example.testgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Student1 extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    FloatingActionButton fabadd, fabuser, fabsetting;
    Animation rotate_open,rotate_close,from_bottom,to_bottom;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student1);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);


        fabadd = (FloatingActionButton) findViewById(R.id.fabadd);
        fabuser = (FloatingActionButton) findViewById(R.id.fabuser);
        fabsetting = (FloatingActionButton) findViewById(R.id.fabsetting);

        rotate_open = AnimationUtils.loadAnimation(this,R.anim.rotate_open_ani);
        rotate_close = AnimationUtils.loadAnimation(this,R.anim.rotate_close_ani);

        from_bottom = AnimationUtils.loadAnimation(this,R.anim.from_bottom_ani);
        to_bottom = AnimationUtils.loadAnimation(this,R.anim.to_bottom_ani);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent two = new Intent();
                two.setClass(Student1.this,coban.class);
                startActivity(two);
            }
        });

        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
        fabuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Student1.this,"user",Toast.LENGTH_SHORT).show();
            }
        });
        fabsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Student1.this,"setting",Toast.LENGTH_SHORT).show();

            }
        });


    }
    private void animateFab() {
        if (isOpen) {
            fabadd.startAnimation(to_bottom);
            fabuser.startAnimation(rotate_open);
            fabsetting.startAnimation(rotate_open);
            fabuser.setClickable(true);
            fabsetting.setClickable(true);
            isOpen=false;

        }
        else{
            fabadd.startAnimation(from_bottom);
            fabuser.startAnimation(rotate_close);
            fabsetting.startAnimation(rotate_close);
            fabuser.setClickable(false);
            fabsetting.setClickable(false);
            isOpen=true;
        }

    }
}