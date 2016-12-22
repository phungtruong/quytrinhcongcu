package com.example.pig.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pig on 12/21/2016.
 */

public class CardAdapter extends ArrayAdapter<GioHang> {
    private Context context;
    private int layoutID;
    private ArrayList<GioHang> listGioHang;
    public CardAdapter(Context context, int layoutID, ArrayList<GioHang> listGioHang)
    {
        super(context, layoutID, listGioHang);
        this.context = context;
        this.layoutID = layoutID;
        this.listGioHang = listGioHang;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutID, null);
        }
        convertView = setUpView(convertView, position);
        return convertView;
    }

    private View setUpView(View convertView, int position) {
        final TextView tvTen = (TextView) convertView.findViewById(R.id.tvTen);
        final TextView tvSoluong = (TextView) convertView.findViewById(R.id.tvSoluong);
        final TextView tvGiatien = (TextView) convertView.findViewById(R.id.tvGiatien);
        final GioHang gioHang = listGioHang.get(position);
        tvTen.setText(gioHang.getTen());
        tvSoluong.setText("Số lượng: " + gioHang.getSoLuong()+"");
        tvGiatien.setText(gioHang.getGiaTien()+" VNĐ");
        return convertView;
    }
}
