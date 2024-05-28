package com.project.ie303group03.models;

import java.util.ArrayList;

public class DieuKienCSNN extends DieuKienTotNghiep {
    private ArrayList<MonHoc> dsMonHocCSNN = null;

    public DieuKienCSNN(DanhSachMonHoc dsmh) {
        super();
        this.dsMonHocCSNN = dsmh.getMonHocByType("CSNN");
    }

    @Override
    public boolean xetDieuKien(SinhVien sv) {
        String log = "";
        for (MonHoc mh : dsMonHocCSNN) {
            KetQuaHocTap kq = sv.getKetQuaHocTapFromBangDiem(mh.getMaMH());
            if (kq == null) {
                log += "\nBạn còn thiếu môn cơ sở nhóm ngành " + mh.getMaMH();
            } else if (kq.getDiemTongKet() < 5f) {
                log += "\n Điểm môn " + mh.getMaMH() + " chưa đủ 5 điểm";
            }
        }
        this.setLog(log);
        return this.getLog().isEmpty();
    }
}
