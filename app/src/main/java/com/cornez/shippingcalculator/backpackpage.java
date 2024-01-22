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

public class backpackpage extends Activity {
    ImageButton backpackclose;
    ImageButton backpackback;
    ImageButton like;
    ImageButton store;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton backpackbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpackpage);
        backpackclose=findViewById(R.id.backpackclose);
        backpackclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(backpackpage.this,MyActivity.class);
                startActivity(intent);
            }
        });

        backpackbook=findViewById(R.id.backpackbook);
        backpackbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(backpackpage.this,backpackbook.class);
                startActivity(intent);
            }
        });

        backpackback=findViewById(R.id.backpackback);
        backpackback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(backpackpage.this,classlist.class);
                startActivity(intent);
            }
        });


        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        like=findViewById(R.id.backpacklike);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"likelist").child("2");
                myRef2.setValue("backpackbook");
                Toast.makeText(backpackpage.this,"已加入我的最愛",Toast.LENGTH_SHORT).show();
            }
        });

        store=findViewById(R.id.backpackstore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"storelist").child("2");
                myRef2.setValue("backpackbook");
                Toast.makeText(backpackpage.this,"已加入我的書櫃",Toast.LENGTH_SHORT).show();

            }
        });
    }
}