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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class report extends Activity {
    ImageButton loghome;
    EditText regaccountedit;
    Button regbtn;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        loghome=findViewById(R.id.loghome); //classlist
        regaccountedit=findViewById(R.id.regaccountedit);
        regbtn=findViewById(R.id.regbtn);

        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        loghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(report.this,MyActivity.class);
                startActivity(intent);
            }
        });
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(report.this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitle("User Comments")
                        .setMessage("確定送出意見")
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("comment").child(mUser.getUid());
                                myRef.setValue(regaccountedit.getText().toString());

                                Toast.makeText(report.this,"Send Successfully!!!",Toast.LENGTH_LONG);
                                Intent intent=new Intent();
                                intent.setClass(report.this,MyActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .setCancelable(false)
                        .show();


            }
        });
    }
}