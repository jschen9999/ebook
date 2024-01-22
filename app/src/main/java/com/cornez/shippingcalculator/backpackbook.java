package com.cornez.shippingcalculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class backpackbook extends Activity {
    ImageButton nphbookclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpackbook);
        nphbookclose=findViewById(R.id.nphbookclose);
        nphbookclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(backpackbook.this,MyActivity.class);
                startActivity(intent);
            }
        });
    }
}