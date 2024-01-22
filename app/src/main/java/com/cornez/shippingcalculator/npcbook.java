package com.cornez.shippingcalculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class npcbook extends Activity {
    ImageButton npcbookclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npcbook);
        npcbookclose=findViewById(R.id.npcbookclose); //跳出np
        npcbookclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(npcbook.this,MyActivity.class);
                startActivity(intent);
            }
        });
    }
}