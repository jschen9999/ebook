package com.cornez.shippingcalculator;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class intro extends Activity {
    //DATA MODEL FOR SHIP ITEM
    //private ShipItem shipItem;
    ImageButton introhome;
    Button mybook;
    Button mylike;
    Button about;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    TextView name;

    public int iflogin;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // String s= tvShow.getText().toString();
        // outState.putString("SAVE",s);
    }

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        introhome=findViewById(R.id.introhome);
        introhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(intro.this,MyActivity.class);
                startActivity(intent);
            }
        });


        name=findViewById(R.id.name);

        try {
            mAuth = FirebaseAuth.getInstance();
            mUser = mAuth.getCurrentUser();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("userlogin").child(mUser.getUid());

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    name.setText(value);

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
        } catch (Exception e) {
            //  loginWithMailView();
        }


        name.setText("0");

        mybook=findViewById(R.id.mybook);
        mybook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().matches("0")){
                    Toast.makeText(intro.this,"請登入您的帳號",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.setClass(intro.this, bookcase.class);
                    startActivity(intent);
                }
            }
        });

        mylike=findViewById(R.id.mylike);
        mylike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().matches("0")){
                    Toast.makeText(intro.this,"請登入您的帳號",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.setClass(intro.this, Mylove.class);
                    startActivity(intent);
                }
            }
        });

        about=findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(intro.this,aboutus.class);
                startActivity(intent);
            }
        });
    }
}

