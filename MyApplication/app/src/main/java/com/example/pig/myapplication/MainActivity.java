package com.example.pig.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int FRAGMENT_COUNT = 2;
    TextView tvTitle;
    ViewPager mPaper;
    MyPaperViewAdapter mAdapter;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dùng để ẩn action bar
        ActionBar ac = getSupportActionBar();
        ac.hide();
        tvTitle = (TextView) findViewById(R.id.tvtitle);
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tabMenu");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("THỰC ĐƠN");
        tabHost.addTab(tabSpec);

        mAdapter = new MyPaperViewAdapter(getSupportFragmentManager());
        mPaper = (ViewPager)findViewById(R.id.paper);
        mPaper.setAdapter(mAdapter);
    }

}
