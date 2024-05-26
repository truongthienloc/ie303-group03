package com.project.ie303group03.models;
import  java.util.ArrayList;

public class DieuKienAnhVan extends DieuKienTotNghiep{
    public DieuKienAnhVan() {
        super();
    }

    public boolean xetDieuKien(SinhVien sv) {
        ArrayList<ChungChiNgoaiNgu> dsChungChi = sv.getDsChungChiNgoaiNgu();
        boolean isPass = false;

        if(dsChungChi.isEmpty()) {
            this.setLog("Bạn chưa có chứng chỉ ngoại ngữ");
            return isPass;
        }

        for(int i = dsChungChi.size(); i >= 0 ; i--) {
            ChungChiNgoaiNgu chungChi = dsChungChi.get(i);
            if(chungChi.xetChungChi()) {
                if(chungChi instanceof ToeicSW) {
                    for(int j = i - 1; j >= 0; j--) {
                        if(dsChungChi.get(j) instanceof ToeicLR) {
                            if(dsChungChi.get(j).xetChungChi()) {
                                isPass = true;
                                break;
                            }
                        }
                    }
                }
                else if(chungChi instanceof ToeicLR) {
                    for(int j = i - 1; j >= 0; j--) {
                        if(dsChungChi.get(j) instanceof ToeicSW) {
                            if(dsChungChi.get(j).xetChungChi()) {
                                isPass = true;
                                break;
                            }
                        }
                    }
                } else {
                    isPass = true;
                }
            }

            if(isPass) {
                setLog("");
                break;
            }
        }

        return isPass;
    }
}
