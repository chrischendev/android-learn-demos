package com.chris.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chris.widget.view.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.tv_value)
    TextView tvValue;
    @BindView(R.id.pb_test)
    ProgressBar pbTest;

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
            if (progress >= 100) {
                removeCallbacks(mRunnable);
            }
            pbTest.setProgress(progress++);
            tvValue.setText("" + pbTest.getProgress());
            postDelayed(mRunnable, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //tvValue.setText("开始");
    }

    @OnClick(R.id.btn_start)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                mRunnable.run();
                break;
            default:
                break;
        }

    }
}
