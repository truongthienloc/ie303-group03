package com.project.ie303group03.models;

public class Cambridge extends ChungChiNgoaiNgu{
    private String xepLoai;
    static private String LOAI_TOT_NGHIEP = "PET";

    Cambridge(String maChungChi, int namCap, String xepLoai) {
        super(maChungChi, namCap);
        this.xepLoai = xepLoai;
    }

    @Override
    public MaXetChungChi xetChungChi() {
        if(this.xepLoai.equals(this.LOAI_TOT_NGHIEP))
            return  MaXetChungChi.DAT;
        return MaXetChungChi.KHONG_DU_DIEM;
    }
}
