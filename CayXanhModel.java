package com.example.bt_cuoiky;

public class CayXanhModel {
    String ten, casi, anh, loi;

    CayXanhModel(){

    }

    public CayXanhModel(String ten, String casi, String anh, String loi) {
        this.ten = ten;
        this.casi = casi;
        this.anh = anh;
        this.loi = loi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getLoi() {
        return loi;
    }

    public void setLoi(String loi) {
        this.loi = loi;
    }
}
