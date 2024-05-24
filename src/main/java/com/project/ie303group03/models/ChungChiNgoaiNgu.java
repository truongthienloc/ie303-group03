package com.project.ie303group03.models;

abstract class ChungChiNgoaiNgu {
    String maChungChi;
    int namCap;

    ChungChiNgoaiNgu(String maChungChi, int namCap) {
        this.maChungChi = maChungChi;
        this.namCap = namCap;
    }

    public abstract  MaXetChungChi xetChungChi();
}
