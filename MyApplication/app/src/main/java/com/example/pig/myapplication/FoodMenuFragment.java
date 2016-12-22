package com.example.pig.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class FoodMenuFragment extends Fragment {


    ListView lvMenu;
    MenuAdapter adapter = null;
    ArrayList<MonAn> menu;

    public MenuAdapter getAdapter() {
        return adapter;
    }

    public static FoodMenuFragment getnewInstance()
    {
        FoodMenuFragment f = new FoodMenuFragment();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_food_menu, container, false);
        //Tạo menu demo
        DemoMenu d = new DemoMenu(getActivity());
        d.createDemoMenu();
        menu = new ArrayList<MonAn>();
        menu = d.getDemoMenu();

        //Lấy ID listview
        //Tạo MenuAdapter
        //Gắn menu_adapter vào listview
        lvMenu = (ListView)v.findViewById(R.id.lvMenu);
        adapter = new MenuAdapter(getActivity(), R.layout.custom_listview, menu);
        lvMenu.setAdapter(adapter);
        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        FoodOrderDatabaseHelper dt = FoodOrderDatabaseHelper.getInstance(getActivity());
        if(dt != null)
        {
            dt.close();
        }
    }
}
