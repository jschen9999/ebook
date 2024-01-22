package com.cornez.shippingcalculator;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.widget.RadioGroup;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;


public class MyActivity extends Activity {
    //DATA MODEL FOR SHIP ITEM
    //private ShipItem shipItem;
    ImageButton account;
    ImageButton row;
    ImageButton listbu;
    ImageButton report;
    TextView person;
    TextView login;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    public int iflogin=0;

    private  ViewPager viewPager;
    private SlideAdapter myadapter;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // String s= tvShow.getText().toString();
       // outState.putString("SAVE",s);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        person=findViewById(R.id.person);
        login=findViewById(R.id.login);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        myadapter=new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();




        account=findViewById(R.id.account);  //登入
        row=findViewById(R.id.row); //classlist
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                person.getText().toString().matches("歡迎訪客")
                if( person.getText().toString().matches("歡迎訪客")) {
//                    login.setText("1");
                    startActivity(new Intent(MyActivity.this, output.class));
                }else{
                    new AlertDialog.Builder(MyActivity.this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitle("登出")
                        .setMessage("確定登出")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef2 = database.getReference("login").child(mUser.getUid());
                                myRef2.setValue("0");

                                mAuth = FirebaseAuth.getInstance();
                                mAuth.signOut();
                                person.setText("歡迎訪客");
                                iflogin=0;
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .setCancelable(false)
                        .show();

                }
            }
        });

        row=findViewById(R.id.row); //classlist
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MyActivity.this,classlist.class);
                startActivity(intent);
            }
        });

        report=findViewById(R.id.report); //classlist
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MyActivity.this,report.class);
                startActivity(intent);
            }
        });

        listbu=findViewById(R.id.listbu); //classlist
        listbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setClass(MyActivity.this,intro.class);
                startActivity(intent);
            }
        });

        //while login


        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("username").child(mUser.getUid());

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    Log.d(TAG, "Value is: " + value);
                    if (value.matches("null")) {
                        person.setText("歡迎訪客");
                    } else {
                        person.setText("歡迎" + value);
                    }
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



//
//        Bundle bundle = this.getIntent().getExtras();
//        if (bundle != null) {
//            String result = bundle.getString("userlogin");
//            if(result.matches("1")){
//                iflogin=1;
//            }
//            //
//
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
//            DatabaseReference myRef = database.getReference("username").child(mUser.getUid());
//
//            myRef.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    // This method is called once with the initial value and again
//                    // whenever data at this location is updated.
//                    String value = dataSnapshot.getValue(String.class);
//                    Log.d(TAG, "Value is: " + value);
//                    person.setText("歡迎"+value);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError error) {
//                    // Failed to read value
//                    Log.w(TAG, "Failed to read value.", error.toException());
//                }
//            });
//        }
    }
}
