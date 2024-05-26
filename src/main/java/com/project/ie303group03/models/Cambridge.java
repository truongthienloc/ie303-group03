package com.project.ie303group03.models;

public class Cambridge extends ChungChiNgoaiNgu{
    private String xepLoai;
    static public final String LOAI_TOT_NGHIEP = "PET";

    Cambridge(String maChungChi, int namCap, String xepLoai) {
        super(maChungChi, namCap);
        this.xepLoai = xepLoai;
    }

    public String getXepLoai() {
        return this.xepLoai;
    }

    @Override
    public int getSoNamHetHan() {
        return 0;
    }

    @Override
    public MaXetChungChi xetChungChi() {
        if(this.xepLoai.equals(this.LOAI_TOT_NGHIEP))
            return  MaXetChungChi.DAT;
        return MaXetChungChi.KHONG_DU_DIEM;
    }
}
