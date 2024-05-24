package com.project.ie303group03.models;

import  java.util.ArrayList;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private ArrayList<ChungChiNgoaiNgu> dsChungChiNgoaiNgu;
    private ArrayList<KetQuaHocTap> bangDiem;
    private int diemRenLuyen;

    public SinhVien(String maSV, String hoTen, ArrayList<ChungChiNgoaiNgu> dsChungChiNgoaiNgu, ArrayList<KetQuaHocTap> bangDiem, int diemRenLuyen) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.bangDiem = bangDiem;
        this.dsChungChiNgoaiNgu = dsChungChiNgoaiNgu;
        this.diemRenLuyen = diemRenLuyen;
    }

    public String getMaSV() {
        return this.maSV;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public int getDiemRenLuyen() {
        return this.diemRenLuyen;
    }

    public ArrayList<ChungChiNgoaiNgu> getDsChungChiNgoaiNgu() {
        return this.dsChungChiNgoaiNgu;
    }

    public ArrayList<KetQuaHocTap> getBangDiem() {
        return this.bangDiem;
    }
}
