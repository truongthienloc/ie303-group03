package com.project.ie303group03.models;

public class DieuKienTongTinChi extends DieuKienTotNghiep {
    static private final int SO_TIN_CHI_TOI_THIEU = 125;

    public DieuKienTongTinChi() {
        super();
    }

    public boolean xetDieuKien(SinhVien sv) {
        int sum = 0;
        for(KetQuaHocTap kq : sv.getBangDiem()) {
            if(kq.getDiemTongKet() > 5 || kq.getDiemTongKet() == -1)
                sum += kq.getMonHoc().getSoTinChi();
        }

        if(sum < SO_TIN_CHI_TOI_THIEU) {
            setLog("Bạn chưa tích lũy đủ 125 tín chỉ");
            return false;
        }

        return true;
    }
}
