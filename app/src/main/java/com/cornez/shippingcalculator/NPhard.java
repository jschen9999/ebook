package com.cornez.shippingcalculator;
import android.os.Bundle;
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

public class NPhard extends Activity {
    ImageButton nphardclose;
    ImageButton like;
    ImageButton store;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    ImageButton nphbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nphard);
        nphardclose=findViewById(R.id.nphardclose); //跳出np
        nphardclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(NPhard.this,MyActivity.class);
                startActivity(intent);
            }
        });

        nphbook=findViewById(R.id.nphbook); //跳出np
        nphbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(NPhard.this,nphardbook.class);
                startActivity(intent);
            }
        });


        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        like=findViewById(R.id.nphardlike);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"likelist").child("5");
                myRef2.setValue("nphbook");
                Toast.makeText(NPhard.this,"已加入我的最愛",Toast.LENGTH_SHORT).show();
            }
        });

        store=findViewById(R.id.nphardstore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"storelist").child("5");
                myRef2.setValue("nphbook");
                Toast.makeText(NPhard.this,"已加入我的書櫃",Toast.LENGTH_SHORT).show();

            }
        });
    }
}