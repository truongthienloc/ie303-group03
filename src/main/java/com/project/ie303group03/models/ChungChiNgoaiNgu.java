package com.project.ie303group03.models;

public abstract class ChungChiNgoaiNgu {
    String maChungChi;
    int namCap;

    public ChungChiNgoaiNgu(String maChungChi, int namCap) {
        this.maChungChi = maChungChi;
        this.namCap = namCap;
    }

    public int getNamCap() {
        return this.namCap;
    }

    public abstract int getSoNamHetHan();

    public abstract MaXetChungChi xetChungChi();
}
