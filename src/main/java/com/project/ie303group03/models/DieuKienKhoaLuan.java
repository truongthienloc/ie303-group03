package com.project.ie303group03.models;

import java.util.Arrays;
import java.sql.SQLException;

public class DieuKienKhoaLuan extends DieuKienTotNghiep{
    private final String[] dsMaMonChuyenNganhDeXuat = {"IE201", "IE212", "IS217", "IS254", "IE221", "IE224", "IE309",
            "IE202", "IE203", "IS208", "IS336", "IE301", "IE302", "IE102",
            "IE204", "IE213", "IE353", "IS334", "IE303", "IE307",
            "IS251", "IS352", "IS351", "IE205", "IE304", "IE305"};

    public DieuKienKhoaLuan() {
        super();
    }

    public int tinhTongTCChuyenNganh(SinhVien sv) {
        int sum = 0;
        for(KetQuaHocTap kq : sv.getBangDiem()) {
            String loaiMH = kq.getMonHoc().getLoaiMH().getMaLoaiMH();
            if(loaiMH.equals("CN") || loaiMH.equals("CDTN") || loaiMH.equals("DA"))
                sum += kq.getMonHoc().getSoTinChi();
        }

        return sum;
    }

    public boolean xetDieuKien(SinhVien sv) {
        String log = "";
        int tongTinChiChuyenNganh = tinhTongTCChuyenNganh(sv);

        if(tongTinChiChuyenNganh < 24) {
            log = "Chưa tích lũy đủ tín chỉ chuyên ngành";
        }

        KetQuaHocTap kqDoAn = sv.getKetQuaHocTapFromBangDiem("IE207");
        if((kqDoAn == null || kqDoAn.getDiemTongKet() < 5f) && tongTinChiChuyenNganh - 2 < 24) {
                log += "\nBạn cần học môn đồ án (IE207) hoặc một môn chuyên ngành thay thế";
        }
        else {
            KetQuaHocTap khoaLuan = sv.getKetQuaHocTapFromBangDiem("IE505");
            if(khoaLuan == null || khoaLuan.getDiemTongKet() < 5f) {
                if(tongTinChiChuyenNganh - 26 < 10) {
                    log += "\nBạn cần làm KLTN(IE505) hoặc học 3 môn chuyên đề thay thế";
                }

            }
        }

        if(log.isEmpty())
            return true;

        setLog(log);
        return false;
    }
}
