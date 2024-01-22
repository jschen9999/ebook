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

public class np extends Activity {
    ImageButton npclose;
    ImageButton like;
    ImageButton store;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton npbook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_np);
        npclose=findViewById(R.id.npclose); //跳出np
        npclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(np.this,MyActivity.class);
                startActivity(intent);

            }
        });

        npbook=findViewById(R.id.npbook); //跳出np
        npbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(np.this,npbook.class);
                startActivity(intent);
            }
        });


        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        like=findViewById(R.id.nplike);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"likelist").child("3");
                myRef2.setValue("npbook");
                Toast.makeText(np.this,"已加入我的最愛",Toast.LENGTH_SHORT).show();
            }
        });

        store=findViewById(R.id.npstore);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database.getReference(mUser.getUid()+"storelist").child("3");
                myRef2.setValue("npbook");
                Toast.makeText(np.this,"已加入我的書櫃",Toast.LENGTH_SHORT).show();
            }
        });

    }
}