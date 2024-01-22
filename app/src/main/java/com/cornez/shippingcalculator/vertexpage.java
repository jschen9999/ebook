package com.cornez.shippingcalculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class vertexpage extends Activity {
    ImageButton vertexclose;
    ImageButton vertexback;
    ImageButton like;
    ImageButton store;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton vertexbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertexpage);
        vertexclose=findViewById(R.id.vertexclose);
        vertexclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(vertexpage.this,MyActivity.class);
                startActivity(intent);
                Toast.makeText(vertexpage.this,"已加入我的最愛",Toast.LENGTH_SHORT).show();
            }
        });

        vertexbook=findViewById(R.id.vertexbook);
        vertexbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(vertexpage.this,vertex.class);
                startActivity(intent);
                Toast.makeText(vertexpage.this,"已加入我的書櫃",Toast.LENGTH_SHORT).show();
            }
        });

        vertexback=findViewById(R.id.vertexback);
        vertexback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(vertexpage.this,classlist.class);
                startActivity(intent);
            }
        });

        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        like=findViewById(R.id.vertexlike);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"likelist").child("8");
                myRef2.setValue("vertexbook");
            }
        });

        store=findViewById(R.id.vertexstore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"storelist").child("8");
                myRef2.setValue("vertexbook");
            }
        });
    }
}