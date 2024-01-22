package com.cornez.shippingcalculator;
import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Mylove extends Activity {
    ImageButton myloveclose;
    ImageButton myloveback;

    ListView lovelistview;
    ArrayList<book> myArrayList= new ArrayList<>();

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylove);
        myloveclose=findViewById(R.id.myloveclose);
        myloveclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Mylove.this,MyActivity.class);
                startActivity(intent);
            }
        });

        myloveback=findViewById(R.id.myloveback);
        myloveback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Mylove.this,intro.class);
                startActivity(intent);
            }
        });


        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        bookAdapter bookAdapter=new bookAdapter(this,R.layout.list_row,myArrayList);
        lovelistview=(ListView)findViewById(R.id.lovelistview);
        lovelistview.setAdapter(bookAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mRef = database.getReference(mUser.getUid()+"likelist");

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value=snapshot.getValue(String.class);
                if(value.matches("drawbook")){
                    myArrayList.add(new book(R.drawable.draw,"著色問題"));
                }
                else if(value.matches("backpackbook")){
                    myArrayList.add(new book(R.drawable.backpack,"背包問題"));
                }
                else if(value.matches("npbook")){
                    myArrayList.add(new book(R.drawable.np,"NP問題"));
                }
                else if(value.matches("npcbook")){
                    myArrayList.add(new book(R.drawable.npc,"NP-Complete問題"));
                }
                else if(value.matches("nphbook")){
                    myArrayList.add(new book(R.drawable.nph,"NP-Hard問題"));
                }
                else if(value.matches("shbook")){
                    myArrayList.add(new book(R.drawable.shortpath,"最短路徑長"));
                }
                else if(value.matches("groupbook")){
                    myArrayList.add(new book(R.drawable.group,"分團問題"));
                }
                else if(value.matches("vertexbook")){
                    myArrayList.add(new book(R.drawable.vertex,"頂點問題"));
                }
                else if(value.matches("debook")){
                    myArrayList.add(new book(R.drawable.de,"踩地雷"));
                }


                bookAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                bookAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lovelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name= bookAdapter.getItem(i).getName();

                if(name.matches("著色問題")){
                    Intent intent=new Intent(Mylove.this,drawbook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else if(name.matches("背包問題")){
                    Intent intent=new Intent(Mylove.this,backpackbook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else if(name.matches("NP問題")){
                    Intent intent=new Intent(Mylove.this,npbook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else if(name.matches("NP-Complete問題")){
                    Intent intent=new Intent(Mylove.this,npcbook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else if(name.matches("NP-Hard問題")){
                    Intent intent=new Intent(Mylove.this,nphardbook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else if(name.matches("最短路徑長")){
                    Intent intent=new Intent(Mylove.this,shortbook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else if(name.matches("分團問題")){
                    Intent intent=new Intent(Mylove.this,groupbook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else if(name.matches("頂點問題")){
                    Intent intent=new Intent(Mylove.this,vertex.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else if(name.matches("踩地雷")){
                    Intent intent=new Intent(Mylove.this,debook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }




            }
        });

    }
}