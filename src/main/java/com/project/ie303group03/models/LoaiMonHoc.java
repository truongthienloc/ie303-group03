package com.project.ie303group03.models;

public class LoaiMonHoc {
    private String maLoaiMH;
    private String tenLoaiMH;

    public LoaiMonHoc(String maLoaiMH, String tenLoaiMH) {
        this.maLoaiMH = maLoaiMH;
        this.tenLoaiMH = tenLoaiMH;
    }

    public String getMaLoaiMH() {
        return this.maLoaiMH;
    }

    public String getTenLoaiMH() {
        return this.tenLoaiMH;
    }
}
