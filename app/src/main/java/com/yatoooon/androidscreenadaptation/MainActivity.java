package com.yatoooon.androidscreenadaptation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dp);
        App.screenAdapterTools.getInstance().loadView((ViewGroup)getWindow().getDecorView());

    }
}
