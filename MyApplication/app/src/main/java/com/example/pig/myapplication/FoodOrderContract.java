package com.example.pig.myapplication;

import android.provider.BaseColumns;

/**
 * Created by Pig on 12/13/2016.
 */
/*
    - Lớp dùng để chứa tất cả các tables/columns...

    - Không thể tạo đối tượng từ lớp này
*/
public final class FoodOrderContract {
    private FoodOrderContract(){}

    //Table FoodMenu
    public static class FoodMenu
    {
        public static final String TABLE_NAME = "FoodMenu";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_TEN_MON_AN = "TenMonAn";
        public static final String COLUMN_NAME_SO_LUONG = "SoLuong";
        public static final String COLUMN_NAME_GIA_TIEN = "GiaTien";
        public static final String COLUMN_NAME_MO_TA = "MoTa";
        public static final String COLUMN_NAME_HINH_ANH = "HinhAnh"; // ID number of this image from Drawable folder
    }

}
