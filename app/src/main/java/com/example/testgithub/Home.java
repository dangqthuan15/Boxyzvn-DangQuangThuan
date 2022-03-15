package com.example.testgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {
    FloatingActionButton fabadd, fabuser, fabsetting;
    Animation rotate_open,rotate_close,from_bottom,to_bottom;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fabadd = (FloatingActionButton) findViewById(R.id.fabadd);
        fabuser = (FloatingActionButton) findViewById(R.id.fabuser);
        fabsetting = (FloatingActionButton) findViewById(R.id.fabsetting);

        rotate_open = AnimationUtils.loadAnimation(this,R.anim.rotate_open_ani);
        rotate_close = AnimationUtils.loadAnimation(this,R.anim.rotate_close_ani);

        from_bottom = AnimationUtils.loadAnimation(this,R.anim.from_bottom_ani);
        to_bottom = AnimationUtils.loadAnimation(this,R.anim.to_bottom_ani);

        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });
        fabuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this,"cc",Toast.LENGTH_SHORT).show();
            }
        });
        fabsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this,"cl",Toast.LENGTH_SHORT).show();

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