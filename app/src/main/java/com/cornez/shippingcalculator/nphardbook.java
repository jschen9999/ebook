package com.cornez.shippingcalculator;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class nphardbook extends Activity {
    ImageButton nphbookclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nphardbook);
        nphbookclose=findViewById(R.id.nphbookclose); //跳出np
        nphbookclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(nphardbook.this,MyActivity.class);
                startActivity(intent);
            }
        });

    }
}