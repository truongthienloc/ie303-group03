package com.project.ie303group03.models;

public abstract class ChungChiNgoaiNgu {
    protected String maChungChi;
    protected int namCap;

    public ChungChiNgoaiNgu(String maChungChi, int namCap) {
        this.maChungChi = maChungChi;
        this.namCap = namCap;
    }

    public int getNamCap() {
        return this.namCap;
    }

    public String getMaChungChi() {
        return maChungChi;
    }

    public abstract int getSoNamHetHan();

    public Object getKetQua() {
        return "Unknown";
    }

    public abstract MaXetChungChi xetChungChi();
}
