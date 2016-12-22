package com.example.pig.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    private ListView lvCart;
    private TextView tvTongtien;
    ArrayList<GioHang> listGiohang;
    private CardAdapter adapter;
    public static CartFragment getnewInstance()
    {
        CartFragment f = new CartFragment();
        return f;
    }
    public ArrayList<GioHang> getListGiohang() {
        return listGiohang;
    }

    public CardAdapter getAdapter() {
        return adapter;
    }
    public void caculateMoney()
    {
        if(tvTongtien != null)
        {
            if(listGiohang != null && listGiohang.size() > 0)
            {
                int tongTien = 0;
                for(int i = 0; i < listGiohang.size(); i++)
                {
                    tongTien += listGiohang.get(i).getGiaTien() * listGiohang.get(i).getSoLuong();
                }
                tvTongtien.setText("Tổng số tiền: " + tongTien + " VNĐ");
            }

        }

    }
    public void setListGiohang(ArrayList<GioHang> listGiohang) {

        this.listGiohang.clear();
        this.listGiohang.addAll(listGiohang);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        tvTongtien = (TextView) v.findViewById(R.id.tvTongtien);
        //Do something here
        listGiohang = new ArrayList<>();

        adapter = new CardAdapter(getActivity(), R.layout.custom_listview_cart, listGiohang);
        lvCart = (ListView) v.findViewById(R.id.lvCart);
        lvCart.setAdapter(adapter);
        return v;
    }
}
