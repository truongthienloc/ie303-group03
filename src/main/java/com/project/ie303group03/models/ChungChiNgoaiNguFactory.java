package com.project.ie303group03.models;

public class ChungChiNgoaiNguFactory {
    public ChungChiNgoaiNguFactory() {

    }

    public ChungChiNgoaiNgu createChungChiNgoaiNgu(String maChungChi, int namCap, Object ketQua, int soNamHetHan) {
        ChungChiNgoaiNgu result = null;
        try {
            switch (maChungChi.toLowerCase()) {
                case "ielts":
                    result = new Ielts(maChungChi.toUpperCase(), namCap, (float)ketQua, soNamHetHan);
                    break;
                case "toefl":
                    result = new Toefl(maChungChi.toUpperCase(), namCap, (int)(float)ketQua, soNamHetHan);
                    break;
                case "toeiclr":
                    result = new ToeicLR(maChungChi.toUpperCase(), namCap, (int)(float)ketQua, soNamHetHan);
                    break;
                case "toeicsw":
                    result = new ToeicSW(maChungChi.toUpperCase(), namCap, (int)(float)ketQua, soNamHetHan);
                    break;
                case "vnu_ept":
                    result = new VNU_EPT(maChungChi.toUpperCase(), namCap, (int)(float)ketQua, soNamHetHan);
                    break;
                case "cambridge":
                    result = new Cambridge(maChungChi.toUpperCase(), namCap, (String)ketQua);
                    break;

                default:
                    break;
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }


        return result;
    }
}
