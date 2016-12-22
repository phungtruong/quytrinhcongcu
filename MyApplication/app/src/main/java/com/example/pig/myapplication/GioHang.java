package com.example.pig.myapplication;

/**
 * Created by Pig on 12/21/2016.
 */

public class GioHang {
    private int ID;
    private String ten;
    private int soLuong;
    private String soTien;
    private int giaTien;

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public GioHang(int ID, String ten, int soLuong, int giaTien) {
        this.ID = ID;
        this.ten = ten;
        this.soLuong = soLuong;
        this.soTien = soTien;
        this.giaTien = giaTien;
    }

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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }
}
