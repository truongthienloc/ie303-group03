package com.project.ie303group03.models;

public class DieuKienDiemRenLuyen extends DieuKienTotNghiep{
    static private final int DIEM_REN_LUYEN_TOI_THIEU = 50;

    public DieuKienDiemRenLuyen() {
        super();
    }

    public boolean xetDieuKien(SinhVien sv) {
        if(sv.getDiemRenLuyen() <= DIEM_REN_LUYEN_TOI_THIEU) {
            setLog("Điểm rèn luyện dưới 50 không đủ để tốt nghiệp");
            return false;
        }

        return true;
    }
}
