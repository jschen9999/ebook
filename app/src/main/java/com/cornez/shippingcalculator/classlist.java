package com.cornez.shippingcalculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
public class classlist extends Activity {
    ImageButton classlistclose;
    ListView listView;
    String[] values = new String[]{
            "np",
            "nphard",
            "npcomplete",
            "npproblem-著色問題",
            "npproblem-踩地雷",
            "npproblem-最短路徑",
            "npproblem-背包問題",
            "npproblem-分團問題",
            "npproblem-頂點問題"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classlist);

        classlistclose=findViewById(R.id.classlistclose); //退出
        classlistclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(classlist.this,MyActivity.class);
                startActivity(intent);
            }
        });
        listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(classlist.this , R.layout.simple_list_item_2 ,values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,np.class);
                    startActivity(intent);
                }
                if(i==1){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,NPhard.class);
                    startActivity(intent);
                }
                if(i==2){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,NPcomplete.class);
                    startActivity(intent);
                }
                if(i==3){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,drawpage.class);
                    startActivity(intent);
                }
                if(i==4){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,landmine.class);
                    startActivity(intent);
                }
                if(i==5){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,pathpage.class);
                    startActivity(intent);
                }
                if(i==6){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,backpackpage.class);
                    startActivity(intent);
                }
                if(i==7){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,subgrouppage.class);
                    startActivity(intent);
                }
                if(i==8){
                    Intent intent=new Intent();
                    intent.setClass(classlist.this,vertexpage.class);
                    startActivity(intent);
                }
            }
        });

    }
}