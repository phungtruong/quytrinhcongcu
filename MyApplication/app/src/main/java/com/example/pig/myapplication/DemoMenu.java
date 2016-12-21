package com.example.pig.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Pig on 12/13/2016.
 */
//Lớp này dùng để tự động insert một vài dữ liệu demo
public class DemoMenu {
    private boolean isDatabaseCreated;
    private Context context;
    FoodOrderDatabaseHelper dtHelper;
    public DemoMenu(Context context)
    {
        this.context = context;
        File database = context.getApplicationContext().getDatabasePath(FoodOrderDatabaseHelper.DATABASE_NAME);
        if(database.exists())
        {
            isDatabaseCreated = true;
        }
        dtHelper = FoodOrderDatabaseHelper.getInstance(context);
    }
    public void createDemoMenu()
    {
        if(!isDatabaseCreated)
        {
            if(dtHelper.insertDataToFoodMenu("Gà nướng",
                    R.drawable.ganuong, 12, "150.000 VNĐ",
                    "Đây là món ăn ngon nhất của nhà hàng chúng tôi.") == -1)
            {
                Toast.makeText(context, "Có lỗi xẩy ra khi insert data", Toast.LENGTH_SHORT).show();
                return;
            }
            if(dtHelper.insertDataToFoodMenu("Rau muống xào",
                    R.drawable.raumuongxao, 12, "10.000 VNĐ",
                    "Đây là món ăn ngon nhất của nhà hàng chúng tôi.") == -1)
            {
                Toast.makeText(context, "Có lỗi xẩy ra khi insert data", Toast.LENGTH_SHORT).show();
                return;
            }
            if(dtHelper.insertDataToFoodMenu("Heo quay",
                    R.drawable.heoquay, 12, "150.000 VNĐ",
                    "Đây là món ăn ngon nhất của nhà hàng chúng tôi.") == -1)
            {
                Toast.makeText(context, "Có lỗi xẩy ra khi insert data", Toast.LENGTH_SHORT).show();
                return;
            }
            if(dtHelper.insertDataToFoodMenu("Thịt kho",
                    R.drawable.thitkho, 12, "20.000 VNĐ",
                    "Đây là món ăn ngon nhất của nhà hàng chúng tôi.") == -1)
            {
                Toast.makeText(context, "Có lỗi xẩy ra khi insert data", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
    public ArrayList<MonAn> getDemoMenu()
    {
        ArrayList<MonAn> lMonAn = null;
        Cursor c = dtHelper.readDataFromFoodMeu();
        if(c!= null)
        {

            lMonAn = new ArrayList<>();
            boolean isNotEmpty = c.moveToFirst();
            while (isNotEmpty)
            {
                MonAn m = new MonAn();
                m.setTen(c.getString(c.getColumnIndex(FoodOrderContract.FoodMenu.COLUMN_NAME_TEN_MON_AN)));
                m.setHinhAnh(c.getInt(c.getColumnIndex(FoodOrderContract.FoodMenu.COLUMN_NAME_HINH_ANH)));
                m.setSoTien(c.getString(c.getColumnIndex(FoodOrderContract.FoodMenu.COLUMN_NAME_GIA_TIEN)));
                m.setMoTa(c.getString(c.getColumnIndex(FoodOrderContract.FoodMenu.COLUMN_NAME_MO_TA)));
                lMonAn.add(m);
                isNotEmpty = c.moveToNext();
            }
            c.close();
        }

        return lMonAn;
    }
}
