package com.yatoooon.androidscreenadaptation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by yatoooon on 2018/2/27.
 */

public class TestRecyclerViewActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_test);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_test);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(this);
        recyclerView.setAdapter(recyclerviewAdapter);
    }
}
