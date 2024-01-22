package com.cornez.shippingcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class Classification extends Activity {
    ImageButton npclassficationclose;
    Button draw;
    Button landmine;
    Button path;
    Button backpack;
    Button subgroup;
    Button vertex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        npclassficationclose=findViewById(R.id.npclassficationclose);
        npclassficationclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Classification.this,MyActivity.class);
                startActivity(intent);
            }
        });

        draw=findViewById(R.id.draw);
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Classification.this,drawpage.class);
                startActivity(intent);
            }
        });

        landmine=findViewById(R.id.landmine);
        landmine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Classification.this,landmine.class);
                startActivity(intent);
            }
        });

        path=findViewById(R.id.path);
        path.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Classification.this,pathpage.class);
                startActivity(intent);
            }
        });

        backpack=findViewById(R.id.backpack);
        backpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Classification.this,backpackpage.class);
                startActivity(intent);
            }
        });

        subgroup=findViewById(R.id.subgroup);
        subgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Classification.this,subgrouppage.class);
                startActivity(intent);
            }
        });
        vertex=findViewById(R.id.vertex);
        vertex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Classification.this,vertexpage.class);
                startActivity(intent);
            }
        });
    }
}