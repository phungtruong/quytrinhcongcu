package com.example.pig.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pig on 12/13/2016.
 */

/*
    - Đây là class không thể tạo thực thể

    - Dùng hàm getInstance() để lấy ra đối tượng của class

*/
public class FoodOrderDatabaseHelper extends SQLiteOpenHelper {
    private static FoodOrderDatabaseHelper instance;        //singleton
    //Constants
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodOrder.db";
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String INTEGER_TYPE = " INTEGER";

    //Chuỗi SQL dùng để tạo table Food Menu
    private static final String SQL_CREATE_FOOD_MENU =
            "CREATE TABLE " + FoodOrderContract.FoodMenu.TABLE_NAME + " (" +
                    FoodOrderContract.FoodMenu.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    FoodOrderContract.FoodMenu.COLUMN_NAME_TEN_MON_AN + TEXT_TYPE + COMMA_SEP +
                    FoodOrderContract.FoodMenu.COLUMN_NAME_MO_TA + TEXT_TYPE + COMMA_SEP +
                    FoodOrderContract.FoodMenu.COLUMN_NAME_HINH_ANH + INTEGER_TYPE + COMMA_SEP +
                    FoodOrderContract.FoodMenu.COLUMN_NAME_GIA_TIEN + TEXT_TYPE + COMMA_SEP +
                    FoodOrderContract.FoodMenu.COLUMN_NAME_SO_LUONG + INTEGER_TYPE + " )";

    //Private constructor
    private FoodOrderDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Hàm lấy trả về đối tượng  FoodOrderDatabaseHelper
    //Hàm này sẽ được gọi thông qua tên class (không gọi từ thực thể của class này)
    public static FoodOrderDatabaseHelper getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new FoodOrderDatabaseHelper(context);
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_FOOD_MENU);
    }

    //i => old versionn number
    //i1 => new version number
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onUpgrade(sqLiteDatabase, i, i1);
    }

    //Hàm dùng để thêm một dòng dữ liệu vào table Food Menu
    public long insertDataToFoodMenu(String tenMonAn, int hinhAnh, int soLuong, String giaTien, String moTa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FoodOrderContract.FoodMenu.COLUMN_NAME_TEN_MON_AN, tenMonAn);
        values.put(FoodOrderContract.FoodMenu.COLUMN_NAME_HINH_ANH, hinhAnh);
        values.put(FoodOrderContract.FoodMenu.COLUMN_NAME_GIA_TIEN, giaTien);
        values.put(FoodOrderContract.FoodMenu.COLUMN_NAME_SO_LUONG, soLuong);
        values.put(FoodOrderContract.FoodMenu.COLUMN_NAME_MO_TA, moTa);
        long newRowId = db.insert(FoodOrderContract.FoodMenu.TABLE_NAME, null, values);
        //db.close();
        return newRowId;
    }


    public Cursor readDataFromFoodMeu()
    {

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                FoodOrderContract.FoodMenu.COLUMN_NAME_ID,
                FoodOrderContract.FoodMenu.COLUMN_NAME_TEN_MON_AN,
                FoodOrderContract.FoodMenu.COLUMN_NAME_HINH_ANH,
                FoodOrderContract.FoodMenu.COLUMN_NAME_GIA_TIEN,
                FoodOrderContract.FoodMenu.COLUMN_NAME_SO_LUONG,
                FoodOrderContract.FoodMenu.COLUMN_NAME_MO_TA
        };

        Cursor c = db.query(
                FoodOrderContract.FoodMenu.TABLE_NAME,      // the table to query
                projection,                                 // The columns to return
                "",                                       // The columns for the WHERE clause
                null,                                       // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                null                                        // The sort order
        );
        //db.close();
        return c;
    }
}
