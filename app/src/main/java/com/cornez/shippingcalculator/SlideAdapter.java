package com.cornez.shippingcalculator;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter{
    Context context;
    LayoutInflater inflater;

    public int[] lst_images={
            R.drawable.np,
            R.drawable.nph,
            R.drawable.npc,
            R.drawable.draw,
            R.drawable.de,
            R.drawable.shortpath,
            R.drawable.backpack,
            R.drawable.group,
            R.drawable.vertex
    };
    public String[] lst_title={
            "np",
            "nphard",
            "npcomplete",
            "著色問題",
            "踩地雷",
            "最短路徑",
            "背包問題",
            "分團問題",
            "頂點問題"
    };

    public int[] lst_backgroundcolor ={
        Color.rgb(253,245,230),
        Color.rgb(255,193,193),
        Color.rgb(135,206,235),
        Color.rgb(155,205,155),
        Color.rgb(171,130,255),
        Color.rgb(255,114,86),
        Color.rgb(255,130,171),
        Color.rgb(228,221,130),
        Color.rgb(92,172,238)
    };

    public SlideAdapter(Context context){
        this.context=context;
    }


    @Override
    public int getCount()
    {
        return lst_title.length;
    }


    @Override
    public boolean isViewFromObject(View view,Object object)
    {
        return (view==(LinearLayout)object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide=(LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide=(ImageView) view.findViewById(R.id.slideimg);
        TextView txttile=(TextView) view.findViewById(R.id.txttitle);
        txttile.setText(lst_title[position]);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
