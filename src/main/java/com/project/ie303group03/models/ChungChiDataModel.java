package com.project.ie303group03.models;

public class ChungChiDataModel {
    private String maChungChi;
    private Object ketQua;

    static public ChungChiDataModel fromChungChiNgoaiNgu(ChungChiNgoaiNgu ccnn) {
//        if (ccnn instanceof Cambridge cam) {
//            return new ChungChiDataModel(cam.getMaChungChi(), cam.getXepLoai());
//        }
//        if (ccnn instanceof Ielts ielts) {
//            return new ChungChiDataModel(ielts.getMaChungChi(), ielts.getDiem());
//        }
//        ToeicLR other = (ToeicLR) ccnn;
//        return new ChungChiDataModel(other.getMaChungChi(), other.getDiem());

        return new ChungChiDataModel(ccnn.getMaChungChi(), ccnn.getKetQua());
    }
    public ChungChiDataModel(String maChungChi, Object ketQua) {
        this.maChungChi = maChungChi;
        this.ketQua = ketQua;
    }

    public void setMaChungChi(String maChungChi) {
        this.maChungChi = maChungChi;
    }

    public void setKetQua(Object ketQua) {
        this.ketQua = ketQua;
    }

    public String getMaChungChi() {
        return maChungChi;
    }

    public Object getKetQua() {
        return ketQua;
    }
}
