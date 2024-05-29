package com.project.ie303group03.models;

public class DieuKienTongTinChi extends DieuKienTotNghiep {
    static private final int SO_TIN_CHI_TOI_THIEU = 125;

    public DieuKienTongTinChi() {
        super();
    }

    public boolean xetDieuKien(SinhVien sv) {
        int sum = 0;
        for(KetQuaHocTap kq : sv.getBangDiem()) {
            if(kq.getDiemTongKet() > 5f || kq.getDiemTongKet() == -1f)
                sum += kq.getMonHoc().getSoTinChi();
        }

        if(sum < SO_TIN_CHI_TOI_THIEU) {
            setLog("Bạn chưa tích lũy đủ số tín chỉ (" + String.valueOf(sum) + "/125)");
            return false;
        }

        return true;
    }
}
