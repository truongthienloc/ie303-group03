package com.project.ie303group03.models;

public class MonHoc {
    private String maMH;
    private String tenMH;
    private int soTinChi;
    private Khoa khoa;
    private LoaiMonHoc loaiMH;

    public MonHoc(String maMH, String tenMH, int soTinChi, Khoa khoa, LoaiMonHoc loaiMH) {
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

    public Khoa getKhoa() {
        return this.khoa;
    }

    public LoaiMonHoc getLoaiMH() {
        return this.loaiMH;
    }
}
