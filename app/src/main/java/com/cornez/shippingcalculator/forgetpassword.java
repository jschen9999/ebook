
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


public class forgetpassword extends Activity {


    EditText inputemail;
    Button btnreset;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ImageButton loghome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loghome=findViewById(R.id.loghome);
        loghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(forgetpassword.this,MyActivity.class);
                startActivity(intent);
            }
        });

        inputemail=findViewById(R.id.resetemailedit);
        btnreset=findViewById(R.id.resetbtn);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();





        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perforAuth();
            }
        });
    }
    private void perforAuth(){
        String email=inputemail.getText().toString();


        if(!email.matches(emailpattern)){
            inputemail.setError("Enter Connext Email");
        }else{
            progressDialog.setMessage("Please Wait While Sent Reset Message");
            progressDialog.setTitle("Reset Password");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(forgetpassword.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(forgetpassword.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }
    }

    private void sendUserToNextActivity(){
        Intent intent=new Intent(forgetpassword.this,output.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}