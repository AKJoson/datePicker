package com.example.datepickdialog;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.testdatabinding.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class NormalPickerImp implements View.OnClickListener {

    protected BottomSheetDialog mPopupWindow;

    private AppCompatActivity mActivity;
    private TextView textCancel;
    private TextView textCenterStamp;
    private TextView textConfirm;
    private WheelView wheelViewYear;
    private WheelView wheelViewMonth;
    private WheelView wheelViewDay;
    private Calendar mCalendar = Calendar.getInstance();
    private List<Integer> days;
    private List<Integer> years;
    private List<Integer> months;


    public NormalPickerImp(AppCompatActivity activity, OnConfirmListener listener) {
        onConfirmListener = listener;
        mActivity = activity;
        mCalendar.set(Calendar.HOUR_OF_DAY, 0);
        mCalendar.set(Calendar.SECOND, 0);
        mCalendar.set(Calendar.MINUTE, 0);
        days = new ArrayList<>(31);
        years = new ArrayList<>(31);
        months = new ArrayList<>(12);
        int startYear = mCalendar.get(Calendar.YEAR) - 90;
        for (int i = 1; i <= 90; i++) {
            if (i <= 12) {
                months.add(i);
            }
            if (i < 32) {
                days.add(i);
            }
            years.add(startYear + i);
        }
    }

    public void showFromBottom() {
        if (mPopupWindow == null) {
            mPopupWindow = new BottomSheetDialog(mActivity);
            View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_date_pick, null, false);
            textCancel = view.findViewById(R.id.text_cancel);
            textCenterStamp = view.findViewById(R.id.text_center_stamp);
            textConfirm = view.findViewById(R.id.text_confirm);
            wheelViewYear = view.findViewById(R.id.wheel_view_one);
            wheelViewMonth = view.findViewById(R.id.wheel_view_two);
            wheelViewDay = view.findViewById(R.id.wheel_view_three);
            initWheelListener();
            mPopupWindow.setContentView(view);
            textCancel.setOnClickListener(this);
            textConfirm.setOnClickListener(this);
        }
        wheelViewYear.setItems(years);
        wheelViewMonth.setItems(months);
        wheelViewDay.setItems(days);
        mPopupWindow.show();
    }

    private void initWheelListener() {
        wheelViewYear.setOnItemSelectListener(new WheelView.OnItemSelectListener() {
            @Override
            public void onSelected(int index) {
                mCalendar.set(Calendar.YEAR, years.get(index));
                updateDays();
            }
        });
        wheelViewMonth.setOnItemSelectListener(new WheelView.OnItemSelectListener() {
            @Override
            public void onSelected(int index) {
                mCalendar.set(Calendar.MONTH, index);
                updateDays();
            }
        });
        wheelViewDay.setOnItemSelectListener(new WheelView.OnItemSelectListener() {
            @Override
            public void onSelected(int index) {
                mCalendar.set(Calendar.DAY_OF_MONTH, index + 1);
            }
        });
    }

    private void updateDays() {
        mCalendar.set(Calendar.DAY_OF_MONTH, 1);
        mCalendar.roll(Calendar.DAY_OF_MONTH, -1);
        int max = mCalendar.get(Calendar.DAY_OF_MONTH);
        wheelViewDay.setItems(days.subList(0, max));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_cancel:
                mPopupWindow.dismiss();
                break;
            case R.id.text_center_stamp:
                break;
            case R.id.text_confirm:
                mPopupWindow.dismiss();
                if (onConfirmListener != null)
                    onConfirmListener.onConfirm(mCalendar.getTime());
                break;
        }
    }

    public interface OnConfirmListener {
        void onConfirm(Date date);
    }

    OnConfirmListener onConfirmListener;
}

