package com.project.ie303group03.models;

public class DieuKienMonHocKhac extends DieuKienTotNghiep{
    public DieuKienMonHocKhac() {
        super();
    }

    public boolean xetDieuKien(SinhVien sv) {
        String resultLog = "";
       KetQuaHocTap kq1 = sv.getKetQuaHocTapFromBangDiem("PE012");
       KetQuaHocTap kq2 = sv.getKetQuaHocTapFromBangDiem("ME001");

       if(kq1 == null || kq1.getDiemTongKet() < 5f) {
           resultLog = "Bạn chưa có chứng chỉ GDTC. Mã môn PE012";
       }

       if(kq2 == null || kq2.getDiemTongKet() < 5f) {
           resultLog += "\n" + "Bạn chưa có chứng chỉ GDQP. Mã môn ME001";
       }

       if(resultLog.isEmpty()) {
           return true;
       }

       setLog(resultLog);
        return false;
    }
}
