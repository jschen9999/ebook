package com.cornez.shippingcalculator;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class register extends Activity {

    TextView alreadyHaveaccount;
    EditText inputemail,inputpassword,inputconformpassword;
    Button btnregister;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton loghome;
    EditText inputname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        alreadyHaveaccount=findViewById(R.id.alreadyHaveaccount);

        loghome=findViewById(R.id.loghome);
        loghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(register.this,MyActivity.class);
                startActivity(intent);
            }
        });

        inputemail=findViewById(R.id.regemailedit);
        inputpassword=findViewById(R.id.regpasswordedit);
        inputconformpassword=findViewById(R.id.reregpasswordedit);
        btnregister=findViewById(R.id.regbtn);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        inputname=findViewById(R.id.regaccountedit);




        alreadyHaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this,output.class));
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perforAuth();
            }
        });

    }
    private void perforAuth(){
        String email=inputemail.getText().toString();
        String password=inputpassword.getText().toString();
        String repassword=inputconformpassword.getText().toString();

        if(!email.matches(emailpattern)){
            inputemail.setError("Enter Connext Email");
        }else if(password.isEmpty()||password.length()<6){
            inputpassword.setError("Enter Proper Password");
        }else if(!password.equals(repassword)){
            inputconformpassword.setError("Password Not match Both field");
        }else{
            progressDialog.setMessage("Please Wait While Registration");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();


                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("username").child(mUser.getUid());
                        myRef.setValue(inputname.getText().toString());

                        DatabaseReference myRef2 = database.getReference("login").child(mUser.getUid());
                        myRef2.setValue("1");

                        sendUserToNextActivity();
                        Toast.makeText(register.this,"Registaration Successful",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(register.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity(){
        Intent intent=new Intent(register.this,MyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        bundle.putString("userlogin", "1");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}