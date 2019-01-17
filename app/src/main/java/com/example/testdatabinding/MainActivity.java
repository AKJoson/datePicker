package com.example.testdatabinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //first ways
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        ViewModel viewModel = new ViewModel();
//        viewModel.setName("Name01");
//        binding.setViewmodel(viewModel);
        //second ways
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        ViewModel viewModel = new ViewModel(this);
        //binding.testview.setTextViewModel(viewModel.textData);
        binding.setViewmodel(viewModel);
        setContentView(binding.getRoot());
    }

}
