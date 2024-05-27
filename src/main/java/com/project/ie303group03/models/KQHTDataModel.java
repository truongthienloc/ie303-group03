package com.project.ie303group03.models;

public class KQHTDataModel {
    public final String maMonHoc;
    public final String tenMonHoc;
    public final int soTinChi;
    public final String diem;

    public KQHTDataModel(String maMonHoc, String tenMonHoc, int soTinChi, String diem) {
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

    public String getDiem() {
        return diem;
    }

    static public KQHTDataModel fromKetQuaHocTap(KetQuaHocTap kqht) {
        String maMonHoc = kqht.getMonHoc().getMaMH();
        String tenMonHoc = kqht.getMonHoc().getTenMH();
        int soTinChi = kqht.getMonHoc().getSoTinChi();
        float diem = kqht.getDiemTongKet();
        String strDiem = String.valueOf(diem);
        if (diem < 0) {
            strDiem = "Miễn";
        }
        return new KQHTDataModel(maMonHoc, tenMonHoc, soTinChi, strDiem);
    }
}
