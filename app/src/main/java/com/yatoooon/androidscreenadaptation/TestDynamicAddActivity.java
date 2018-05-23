package com.yatoooon.androidscreenadaptation;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/5/23.
 */

public class TestDynamicAddActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamicadd);

        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());

        final Button button = findViewById(R.id.bt_addview);
        final RelativeLayout relativeLayout = findViewById(R.id.rl_addview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.setVisibility(View.GONE);

                TextView textView = creatTextView(400, RelativeLayout.ALIGN_PARENT_LEFT);
                TextView textView1 = creatTextView(600, RelativeLayout.ALIGN_PARENT_RIGHT);

                relativeLayout.addView(textView);
                relativeLayout.addView(textView1);

            }
        });

    }

    private TextView creatTextView(int width, int ALIGN_PARENT) {

        TextView textView = new TextView(TestDynamicAddActivity.this);
        textView.setBackgroundColor(Color.rgb(204, 204, 204));
        textView.setText("Hello World!");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width, RelativeLayout.LayoutParams.MATCH_PARENT);
        lp.addRule(ALIGN_PARENT);
        lp.setMargins(20, 20, 20, 20);
        textView.setPadding(50, 50, 50, 50);
        textView.setLayoutParams(lp);


        ScreenAdapterTools.getInstance().loadView(textView);
        return textView;


    }
}
