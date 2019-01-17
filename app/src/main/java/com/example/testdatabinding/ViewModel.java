package com.example.testdatabinding;

import android.databinding.BaseObservable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.datepickdialog.NormalPickerImp;
import com.example.datepickdialog.TimeUtils;

import java.util.Date;

public class ViewModel extends BaseObservable {

    public String name;

    private AppCompatActivity activity;


    public ViewModel(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void onclick(View view) {
        new NormalPickerImp(activity, new NormalPickerImp.OnConfirmListener() {
            @Override
            public void onConfirm(Date date) {
                String format = TimeUtils.format("dd-MM-YYYY", date);
                Toast.makeText(activity, format, Toast.LENGTH_SHORT).show();
            }
        }).showFromBottom();
    }

}
