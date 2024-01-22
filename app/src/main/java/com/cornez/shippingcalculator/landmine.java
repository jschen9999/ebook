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

public class landmine extends Activity {
    ImageButton landclose;
    ImageButton landback;
    ImageButton like;
    ImageButton store;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton debook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmine);
        landclose=findViewById(R.id.landclose);
        landclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(landmine.this,MyActivity.class);
                startActivity(intent);
            }
        });

        debook=findViewById(R.id.debook);
        debook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(landmine.this,debook.class);
                startActivity(intent);
            }
        });

        landback=findViewById(R.id.landback);
        landback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(landmine.this,classlist.class);
                startActivity(intent);
            }
        });

        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        like=findViewById(R.id.landlike);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"likelist").child("9");
                myRef2.setValue("landbook");
                Toast.makeText(landmine.this,"已加入我的最愛",Toast.LENGTH_SHORT).show();
            }
        });

        store=findViewById(R.id.landstore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"storelist").child("9");
                myRef2.setValue("debook");
                Toast.makeText(landmine.this,"已加入我的書櫃",Toast.LENGTH_SHORT).show();
            }
        });
    }
}