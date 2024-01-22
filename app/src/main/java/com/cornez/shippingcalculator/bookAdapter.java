package com.cornez.shippingcalculator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class bookAdapter extends ArrayAdapter<book>{

    private Context mContext;
    private int mResourse;


    public bookAdapter(@NonNull Context context, int resource, @NonNull ArrayList<book> objects) {
        super(context, resource, objects);

        this.mContext=context;
        this.mResourse=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        convertView=layoutInflater.inflate(mResourse,parent,false);


        ImageView imageView=convertView.findViewById(R.id.image);
        TextView txtbook=convertView.findViewById(R.id.txtbook);

        imageView.setImageResource(getItem(position).getImage());
        txtbook.setText(getItem(position).getName());


        return convertView;
    }

}
