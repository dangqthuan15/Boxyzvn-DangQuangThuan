package com.example.testgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Detail extends AppCompatActivity {
    ViewFlipper flipper;
    Animation in,out;
    Button btntien,btnlui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        btnlui = findViewById(R.id.btntien);
        btntien = findViewById(R.id.btnlui);
        in = AnimationUtils.loadAnimation(this,R.anim.anim_in_chitiet);
        out = AnimationUtils.loadAnimation(this,R.anim.anim_out_chitiet);
        flipper.setInAnimation(in);
        flipper.setOutAnimation(out);
        flipper.setFlipInterval(5000);
        flipper.setAutoStart(true);

        btntien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flipper.isAutoStart()){
                    flipper.stopFlipping();
                    flipper.showNext();
                    flipper.startFlipping();
                    flipper.setAutoStart(true);
                }

            }
        });

        btnlui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flipper.isAutoStart()){
                    flipper.stopFlipping();
                    flipper.showPrevious();
                    flipper.startFlipping();
                    flipper.setAutoStart(true);
                }
            }
        });
    }
}