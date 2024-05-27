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

    public KetQuaHocTap getKetQuaHocTapFromBangDiem(String id) {
        for (KetQuaHocTap kq : this.bangDiem) {
            if (kq.getMonHoc().getMaMH().equals(id)) {
                return kq;
            }
        }
        return null;
    }

    public float tinhDiemTrungBinh() {
        float tongDiem = 0;
        int tongSoTinChi = 0;

        for(KetQuaHocTap kq : this.bangDiem) {
            // trường hợp được miễn môn học
            if(kq.getDiemTongKet() == -1) {
                continue;
            }

            tongDiem = tongDiem + kq.getDiemTongKet()*kq.getMonHoc().getSoTinChi();
            tongSoTinChi += kq.getMonHoc().getSoTinChi();
        }

        return (float)tongDiem/tongSoTinChi;
    }

}
