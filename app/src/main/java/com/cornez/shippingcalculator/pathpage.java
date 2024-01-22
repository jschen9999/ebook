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

public class pathpage extends Activity {
    ImageButton pathclose;
    ImageButton pathback;
    ImageButton like;
    ImageButton store;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton shbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pathpage);
        pathclose=findViewById(R.id.pathclose);
        pathclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(pathpage.this,MyActivity.class);
                startActivity(intent);
            }
        });

        shbook=findViewById(R.id.shbook);
        shbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(pathpage.this,shortbook.class);
                startActivity(intent);
            }
        });


        pathback=findViewById(R.id.pathback);
        pathback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(pathpage.this,classlist.class);
                startActivity(intent);
            }
        });

        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        like=findViewById(R.id.pathlike);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"likelist").child("6");
                myRef2.setValue("shbook");
                Toast.makeText(pathpage.this,"已加入我的最愛",Toast.LENGTH_SHORT).show();
            }
        });

        store=findViewById(R.id.pathstore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"storelist").child("6");
                myRef2.setValue("shbook");
                Toast.makeText(pathpage.this,"已加入我的書櫃",Toast.LENGTH_SHORT).show();
            }
        });
    }
}