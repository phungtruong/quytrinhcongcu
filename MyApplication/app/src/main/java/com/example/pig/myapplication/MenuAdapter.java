package com.example.pig.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Pig on 12/8/2016.
 */

public class MenuAdapter extends ArrayAdapter<MonAn> {

    //int temp;
    Activity context = null;
    ArrayList<MonAn> myArray = null;
    int layoutID;

    public MenuAdapter(Activity context, int layoutID
                ,ArrayList<MonAn>myArray)
    {
        super(context, layoutID, myArray);
        this.context = context;
        this.myArray = myArray;
        this.layoutID = layoutID;
    }
    private View setUpView(View convertView, int position)
    {
        final TextView tvTen = (TextView)convertView.findViewById(R.id.tvTen);
        final TextView tvMota = (TextView)convertView.findViewById(R.id.tvMota);
        final TextView tvGia = (TextView)convertView.findViewById(R.id.tvGiaTien);
        final ImageView ivHinh = (ImageView)convertView.findViewById(R.id.ivHinh);
        final TextView tvSoLuong = (TextView)convertView.findViewById(R.id.tvNum);
        //final EditText edtSoluong = (Edit)
        final Button btnBovaogiohang = (Button)convertView.findViewById(R.id.btnChon);
        final ImageButton btnMinus = (ImageButton)convertView.findViewById(R.id.btnMinus);
        final ImageButton btnPlus = (ImageButton) convertView.findViewById(R.id.btnPlus);
        final MonAn m = myArray.get(position);
        tvTen.setText(m.getTen());
        tvMota.setText(m.getMoTa());
        tvGia.setText(m.getSoTien());
        ivHinh.setImageResource(m.getHinhAnh());

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(tvSoLuong.getText().toString());
                temp--;
                if(temp < 0)
                {
                    temp = 0;
                }
                tvSoLuong.setText(temp+"");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(tvSoLuong.getText().toString());
                temp++;
                tvSoLuong.setText(temp+"");
            }
        });
        btnBovaogiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
            }
        });
        return  convertView;
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
}
