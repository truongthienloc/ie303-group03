package com.project.ie303group03.models;

import java.util.HashMap;

public class MonHoc {
    private String maMH;
    private String tenMH;
    private int soTinChi;
    private HashMap<String, String> khoa;
    private  HashMap<String, String> loaiMH;

    public MonHoc(String maMH, String tenMH, int soTinChi, HashMap<String, String> khoa, HashMap<String, String> loaiMH) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soTinChi = soTinChi;
        this.khoa = khoa;
        this.loaiMH = loaiMH;
    }

    public String getMaMH() {
        return this.maMH;
    }

    public String getTenMH() {
        return this.tenMH;
    }

    public int getSoTinChi() {
        return this.soTinChi;
    }

    public HashMap<String, String> getKhoa() {
        return  this.khoa;
    }

    public HashMap<String,String> getLoaiMH() {
        return this.loaiMH;
    }
}
