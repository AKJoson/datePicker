package com.example.datepickdialog;

import android.util.TypedValue;

import com.example.MyApplication;

public class DimensionUtil {
    public static int dp2Px(float dpSize) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpSize, MyApplication.getContext().getResources().getDisplayMetrics());
    }

    public static int sp2Px(float dpSize) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dpSize, MyApplication.getContext().getResources().getDisplayMetrics());
    }
}
