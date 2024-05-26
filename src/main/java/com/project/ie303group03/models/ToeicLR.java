package com.project.ie303group03.models;
import java.time.LocalDate;

public class ToeicLR extends ChungChiNgoaiNgu{
    private int diem;
    private int soNamHetHan;
    static private final int DIEM_TOT_NGHIEP = 450;

    public ToeicLR(String maChungChi, int namCap, int diem, int soNamHetHan) {
        super(maChungChi,namCap);
        this.diem = diem;
        this.soNamHetHan = soNamHetHan;
    }

    @Override
    public boolean xetChungChi() {
        int currentYear = Integer.valueOf(LocalDate.now().getYear());

        if(currentYear - this.namCap > this.soNamHetHan)
            return MaXetChungChi.HET_HAN;
        else if(this.diem < this.DIEM_TOT_NGHIEP) {
            return MaXetChungChi.KHONG_DU_DIEM;
        }

        return MaXetChungChi.DAT;
    }
}
