package com.example.pig.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.pig.myapplication.R.id.lvMenu;

public class MainActivity extends AppCompatActivity {

    ArrayList<MonAn> menu;
    ListView lvMenu;
    MenuAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tạo menu demo
        DemoMenu d = new DemoMenu(this);
        d.createDemoMenu();
        menu = new ArrayList<MonAn>();
        menu = d.getDemoMenu();

        //Lấy ID listview
        //Tạo MenuAdapter
        //Gắn menu_adapter vào listview
        lvMenu = (ListView)findViewById(R.id.lvMenu);
        adapter = new MenuAdapter(this, R.layout.custom_listview, menu);
        lvMenu.setAdapter(adapter);
    }

}
