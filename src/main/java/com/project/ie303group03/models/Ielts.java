package com.project.ie303group03.models;

import java.time.LocalDate;

public class Ielts extends ChungChiNgoaiNgu{
    private float diem;
    private int soNamHetHan;
    static private final float DIEM_TOT_NGHIEP = 4.5f;

    public Ielts(String maChungChi, int namCap, float diem, int soNamHetHan) {
        super(maChungChi, namCap);
        this.diem = diem;
        this.soNamHetHan = soNamHetHan;
    }

    public MaXetChungChi xetChungChi() {
        int currentYear = Integer.valueOf(LocalDate.now().getYear());

        if(currentYear - this.namCap > this.soNamHetHan)
            return MaXetChungChi.HET_HAN;
        else if(this.diem < this.DIEM_TOT_NGHIEP) {
            return MaXetChungChi.KHONG_DU_DIEM;
        }

        return MaXetChungChi.DAT;
    }
}
