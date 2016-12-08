package com.example.pig.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMenu;
    MenuAdapter adapter = null;
    ArrayList<MonAn> menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"1", Toast.LENGTH_SHORT).show();
        menu = new ArrayList<MonAn>();
        for(int i = 0; i < 3; i++)
        {
            MonAn mon = new MonAn();
            mon.setHinhAnh(R.drawable.ic_launcher);
            mon.setID(i);
            mon.setMoTa("Đây là món ăn thúi nhất của nhà hàng chúng tôi");
            mon.setTen("Chicken" + i);
            menu.add(mon);
        }
        Toast.makeText(this,"2", Toast.LENGTH_SHORT).show();
        lvMenu = (ListView)findViewById(R.id.lvMenu);
        Toast.makeText(this,"3", Toast.LENGTH_SHORT).show();
        try
        {
            adapter = new MenuAdapter(this, R.id.customList, menu);
            lvMenu.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
