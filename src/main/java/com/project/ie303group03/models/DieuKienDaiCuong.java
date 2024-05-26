package com.project.ie303group03.models;

import java.util.ArrayList;

public class DieuKienDaiCuong extends DieuKienTotNghiep {
    private DanhSachMonHoc dsMonHocDC = null;

    public DieuKienDaiCuong(DanhSachMonHoc dsMonHocDC) {
        super();
        this.dsMonHocDC = dsMonHocDC;
    }

    public boolean xetDieuKien(SinhVien sv) {
       String log = "";
       ArrayList<MonHoc> dsDC = this.dsMonHocDC.getMonHocByType("ĐC");
       ArrayList<KetQuaHocTap> kqht = sv.getBangDiem();
       for (MonHoc y: dsDC ) {
        for (KetQuaHocTap i : kqht)
           {

               if (y.getMaMH().equals(i.getMonHoc().getMaMH()) && (i.getDiemTongKet() >= 5 || i.getDiemTongKet() == -1))
               {
                    continue;
               }
               else if (i.getDiemTongKet() < 5){
                    log += "\n" +  (i.getMonHoc().getMaMH()) + "dưới 5 điểm";
               }
               else {
                   log += "\nBạn còn thiếu môn " +  y.getMaMH();
               }
           }
       }
       this.setLog(log);
       return (this.getLog()).isEmpty();
    }

}
