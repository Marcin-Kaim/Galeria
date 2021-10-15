package com.example.galeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    int kolejnosc = 0;
    int images[] = {R.drawable.kot1, R.drawable.kot2, R.drawable.kot3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.next);
        Button prev = (Button) findViewById(R.id.prev);
        Switch sw = (Switch) findViewById(R.id.switch1);

        zmien(kolejnosc);

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(kolejnosc < images.length-1) {
                    kolejnosc++;
                }
                else
                {
                    kolejnosc=0;
                }
                zmien(kolejnosc);
            }
        });
        prev.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(kolejnosc > 0) {
                    kolejnosc--;
                }
                else
                {
                    kolejnosc=images.length-1;
                }
                zmien(kolejnosc);
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                zmientlo(b);
            }
        }); // Troche jak button tylko że przekazuje dodatkowo stan switcha w typie true/false
    } // fajnie klika tak btw

    public void zmien(int zm)
    {
        ImageView iv = (ImageView) findViewById(R.id.imageView4);
        iv.setImageResource(images[zm]);
    }

    public void zmientlo(boolean b)
    {
        View layout1 = findViewById(R.id.layout);
        if(b == true)
        {
            layout1.setBackgroundResource(R.color.tlo_niebieski);
        }
        else
        {
            layout1.setBackgroundResource(R.color.tlo_zielony);
        }
    }
}