package com.cornez.shippingcalculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
public class drawbook extends Activity {
    ImageButton npcbookclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawbook);
        npcbookclose=findViewById(R.id.npcbookclose);
        npcbookclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(drawbook.this,MyActivity.class);
                startActivity(intent);
            }
        });
    }
}