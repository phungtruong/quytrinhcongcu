package com.example.pig.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<GioHang> listGioHang;
    public static final String LIST_GIO_HANG = "listGioHang";
    public static final int FRAGMENT_COUNT = 2;
    TextView tvTitle;
    ViewPager mPaper;
    MyPaperViewAdapter mAdapter;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listGioHang = new ArrayList<>();

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

        tabSpec = tabHost.newTabSpec("tabCart");
        tabSpec.setContent(R.id.tab2);

        tabSpec.setIndicator("GIỎ HÀNG");
        tabHost.addTab(tabSpec);
        //tabHost.setCurrentTab(1);
        mAdapter = new MyPaperViewAdapter(getSupportFragmentManager());
        mPaper = (ViewPager)findViewById(R.id.paper);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(final String s) {
                if(s.equals("tabMenu"))
                {
                    mPaper.setCurrentItem(0);
                }
                else if(s.equals("tabCart"))
                {
                    mPaper.setCurrentItem(1);
                    listGioHang = mAdapter.getFoodMenuFragment().getAdapter().getListGioHang();
                    CartFragment c = mAdapter.getCartFragment();
                    c.setListGiohang(listGioHang);
                    //Toast.makeText(MainActivity.this, c.getListGiohang().size() + "", Toast.LENGTH_SHORT).show();
                    c.getAdapter().notifyDataSetChanged();
                    c.caculateMoney();
                }
            }
        });

        TextView tv =  (TextView)tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        tv.setTextColor(Color.parseColor("#ffffff"));
        tv =  (TextView)tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        tv.setTextColor(Color.parseColor("#ffffff"));


        mPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                tabHost.setCurrentTab(position);
                if(position == 0)
                {
                    tvTitle.setText("Thực đơn hôm nay");
                }
                else if(position == 1)
                {
                    tvTitle.setText("Giỏ hàng của bạn");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPaper.setAdapter(mAdapter);

    }

}
