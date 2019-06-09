package com.chris.widget.sample.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chris.widget.R;
import com.chris.widget.sample.pages.BlankActivity;
import com.chris.widget.sample.pages.ProgressBarActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvMain;
    private List<MainItem> dataList = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        setTitle("自定义控件");
        mockDataList();
        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new MainAdapter(this.dataList);
        rvMain.setAdapter(adapter);
    }

    /**
     * 模拟数据
     */
    private void mockDataList() {
        dataList.add(new MainItem("进度条", R.mipmap.icon_main_item, ProgressBarActivity.class));


        for (int i = 0; i < 10; i++) {
            dataList.add(new MainItem("测试标题", R.mipmap.ic_launcher, BlankActivity.class));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                break;
            default:
                break;
        }
    }
}
