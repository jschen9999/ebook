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

public class subgrouppage extends Activity {
    ImageButton subgroupclose;
    ImageButton subgroupback;
    ImageButton like;
    ImageButton store;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton groupbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subgrouppage);
        subgroupclose=findViewById(R.id.subgroupclose);
        subgroupclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(subgrouppage.this,MyActivity.class);
                startActivity(intent);
            }
        });

        groupbook=findViewById(R.id.groupbook);
        groupbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(subgrouppage.this,groupbook.class);
                startActivity(intent);
            }
        });

        subgroupback=findViewById(R.id.subgroupback);
        subgroupback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(subgrouppage.this,classlist.class);
                startActivity(intent);
            }
        });

        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        like=findViewById(R.id.subgrouplike);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"likelist").child("7");
                myRef2.setValue("groupbook");
                Toast.makeText(subgrouppage.this,"已加入我的最愛",Toast.LENGTH_SHORT).show();
            }
        });

        store=findViewById(R.id.subgroupstore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"storelist").child("7");
                myRef2.setValue("groupbook");
                Toast.makeText(subgrouppage.this,"已加入我的書櫃",Toast.LENGTH_SHORT).show();
            }
        });
    }
}