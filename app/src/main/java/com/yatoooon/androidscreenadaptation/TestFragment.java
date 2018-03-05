package com.yatoooon.androidscreenadaptation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/2/27.
 */

public class TestFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_dp, container, false);
        ScreenAdapterTools.getInstance().loadView((ViewGroup) view);
        return view;
    }
}
