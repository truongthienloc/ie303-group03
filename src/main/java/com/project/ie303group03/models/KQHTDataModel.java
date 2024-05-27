package com.project.ie303group03.models;

public class KQHTDataModel {
    public final String maMonHoc;
    public final String tenMonHoc;
    public final int soTinChi;
    public final float diem;

    public KQHTDataModel(String maMonHoc, String tenMonHoc, int soTinChi, float diem) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
        this.diem = diem;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public float getDiem() {
        return diem;
    }

    static public KQHTDataModel fromKetQuaHocTap(KetQuaHocTap kqht) {
        String maMonHoc = kqht.getMonHoc().getMaMH();
        String tenMonHoc = kqht.getMonHoc().getTenMH();
        int soTinChi = kqht.getMonHoc().getSoTinChi();
        float diem = kqht.getDiemTongKet();
        return new KQHTDataModel(maMonHoc, tenMonHoc, soTinChi, diem);
    }
}
