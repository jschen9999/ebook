package com.cornez.shippingcalculator;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ScrollView;

public class ScrollMyVew extends ScrollView {
    public static final int maxHeight = 500; // 100dp

    public ScrollMyVew(Context context) {
        super(context);
    }
    // default constructors

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(dpToPx(getResources(),maxHeight), MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    private int dpToPx(Resources res, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,res.getDisplayMetrics());
    }
}
