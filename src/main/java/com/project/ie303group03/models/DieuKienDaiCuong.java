package com.project.ie303group03.models;

import java.util.ArrayList;

public class DieuKienDaiCuong extends DieuKienTotNghiep {
    private ArrayList<MonHoc> dsMonHocDC = null;

    public DieuKienDaiCuong(DanhSachMonHoc dsmh) {
        super();
        this.dsMonHocDC = dsmh.getMonHocByType("DC");
    }

    public boolean xetDieuKien(SinhVien sv) {
       String log = "";
//       ArrayList<KetQuaHocTap> kqht = sv.getBangDiem();
        for(MonHoc mh : dsMonHocDC) {
            if(mh.getMaMH().equals("ME001"))
                continue;

            KetQuaHocTap kq = sv.getKetQuaHocTapFromBangDiem(mh.getMaMH());
            if(kq == null) {
                log += "\n" + "Bạn còn thiếu môn đại cương " + mh.getMaMH();
            } else if(kq.getDiemTongKet() < 5f && kq.getDiemTongKet() >= 0) {
                log += "\n" + "Điểm môn " + mh.getMaMH() + " chưa đủ 5 điểm";
            }
        }

       this.setLog(log);
       return this.getLog().isEmpty();
    }

}
