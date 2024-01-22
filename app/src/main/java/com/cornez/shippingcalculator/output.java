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


public class output extends Activity {

    TextView createnewaccount;
    EditText inputemail,inputpassword;
    Button btnlogin;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton loghome;
    TextView forget;

    TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        createnewaccount=findViewById(R.id.createnewaccount);

        loghome=findViewById(R.id.loghome);
        loghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(output.this,MyActivity.class);
                startActivity(intent);
            }
        });

        inputemail=findViewById(R.id.logemailedit);
        inputpassword=findViewById(R.id.logpasswordedit);
        btnlogin=findViewById(R.id.loginbtn);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        forget=findViewById(R.id.forget);



        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(output.this,register.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perforlogin();
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(output.this,forgetpassword.class));
            }
        });

    }


    private void perforlogin(){
        String email=inputemail.getText().toString();
        String password=inputpassword.getText().toString();

        if(!email.matches(emailpattern)){
            inputemail.setError("Enter Connext Email");
        }else if(password.isEmpty()||password.length()<6){
            inputpassword.setError("Enter Proper Password");
        }else{
            progressDialog.setMessage("Please Wait While Login ...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            login=findViewById(R.id.login);

           mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       progressDialog.dismiss();
                       FirebaseDatabase database = FirebaseDatabase.getInstance();
                       DatabaseReference myRef2 = database.getReference("login").child(mUser.getUid());
                       myRef2.setValue("1");

                       login.setText("1");

                       sendUserToNextActivity();
                       Toast.makeText(output.this,"Login Successful",Toast.LENGTH_SHORT).show();
                   }else
                   {
                       progressDialog.dismiss();
                       Toast.makeText(output.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                   }
               }
           });
        }
    }

    private void sendUserToNextActivity(){
        Intent intent=new Intent(output.this,MyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        bundle.putString("userlogin", "1");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
