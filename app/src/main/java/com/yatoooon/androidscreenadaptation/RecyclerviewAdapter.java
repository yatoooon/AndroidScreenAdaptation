package com.yatoooon.androidscreenadaptation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/2/27.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter {


    private TestRecyclerViewActivity testRecyclerViewActivity;

    public RecyclerviewAdapter(TestRecyclerViewActivity testRecyclerViewActivity) {
        this.testRecyclerViewActivity = testRecyclerViewActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(testRecyclerViewActivity).inflate(R.layout.test_px, parent, false);
        ScreenAdapterTools.getInstance().loadView(view);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
