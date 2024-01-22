package com.cornez.shippingcalculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class aboutus extends Activity {
    ImageButton aboutusclose;
    ImageButton aboutusback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        aboutusclose=findViewById(R.id.aboutusclose);
        aboutusclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(aboutus.this,MyActivity.class);
                startActivity(intent);
            }
        });

        aboutusback=findViewById(R.id.aboutusback);
        aboutusback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(aboutus.this,intro.class);
                startActivity(intent);
            }
        });
    }
}