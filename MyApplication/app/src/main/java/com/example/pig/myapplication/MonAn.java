package com.example.pig.myapplication;

/**
 * Created by Pig on 12/7/2016.
 */

//Class đại diện cho từng món ăn trong menu
public class MonAn {
    private int ID; 
    private String ten; // tên món ăn
    private String moTa; // Mô tả cho món ăn
    private int hinhAnh; // id hình ảnh
    private String soTien; //Giá của món ăn

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }
}
