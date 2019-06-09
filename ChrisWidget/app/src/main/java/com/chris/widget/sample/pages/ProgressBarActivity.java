package com.chris.widget.sample.pages;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chris.widget.R;
import com.chris.widget.view.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private TextView tvValue;
    private ProgressBar pbTest;
    private int progress = 0;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
        }
    };

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            pbTest.setProgress(progress++);
            tvValue.setText("" + pbTest.getProgress());
            if (progress > 100) {
                removeCallbacks(mRunnable);
                progress = 0;
                return;
            }
            postDelayed(mRunnable, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_progress_bar);
        initView();
    }

    private void initView() {
        setTitle("进度条测试");
        btnStart = findViewById(R.id.btn_start);
        tvValue = findViewById(R.id.tv_value);
        pbTest = findViewById(R.id.pb_test);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                mRunnable.run();
                break;
            default:
                break;
        }
    }
}
