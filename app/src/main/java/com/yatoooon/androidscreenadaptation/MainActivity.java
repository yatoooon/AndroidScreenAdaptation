package com.yatoooon.androidscreenadaptation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btActivity = findViewById(R.id.bt_activity);
        Button btFragment = findViewById(R.id.bt_fragment);
        Button btRecyclerview = findViewById(R.id.bt_recyclerview);
        Button btCustomview = findViewById(R.id.bt_customview);
        Button btDynamicAddView = findViewById(R.id.bt_dynamicaddview);
        btActivity.setOnClickListener(this);
        btFragment.setOnClickListener(this);
        btRecyclerview.setOnClickListener(this);
        btCustomview.setOnClickListener(this);
        btCustomview.setOnClickListener(this);
        btDynamicAddView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_activity:
                intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_fragment:
                intent = new Intent(this, TestFragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_recyclerview:
                intent = new Intent(this, TestRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_customview:
                intent = new Intent(this, TestCustomViewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_dynamicaddview:
                intent = new Intent(this, TestDynamicAddActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
