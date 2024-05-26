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

        for(int i = dsChungChi.size() - 1; i >= 0 ; i--) {
            ChungChiNgoaiNgu chungChi = dsChungChi.get(i);
            if(chungChi.xetChungChi() == MaXetChungChi.DAT) {
                if(chungChi instanceof ToeicSW) {
                    for(int j = i - 1; j >= 0; j--) {
                        if(dsChungChi.get(j) instanceof ToeicLR) {
                            if(dsChungChi.get(j).xetChungChi() == MaXetChungChi.DAT) {
                                isPass = true;
                                break;
                            }
                        }
                    }
                    setLog("Bạn còn thiếu chứng chỉ ToeicLR");
                }
                else if(chungChi instanceof ToeicLR) {
                    for(int j = i - 1; j >= 0; j--) {
                        if(dsChungChi.get(j) instanceof ToeicSW) {
                            if(dsChungChi.get(j).xetChungChi() == MaXetChungChi.DAT) {
                                isPass = true;
                                break;
                            }
                        }
                    }
                    setLog("Bạn còn thiếu chứng chỉ ToeicSW");
                } else {
                    isPass = true;
                }
            } else if(chungChi.xetChungChi() == MaXetChungChi.HET_HAN) {
                if(this.getLog().equals(""))
                    setLog("Chứng chỉ " + getTenChungChi(chungChi.getClass().getName()) + " quá thời hạn " + String.valueOf(chungChi.getSoNamHetHan()) + " năm");
            } else {
                if(this.getLog().equals(""))
                    setLogWhenFailed(chungChi);
            }

            if(isPass) {
                setLog("");
                break;
            }
        }

        return isPass;
    }

    private String getTenChungChi(String fullClassName) {
        int lastDotIndex = fullClassName.lastIndexOf(".");
        if(lastDotIndex == -1)
            return  fullClassName;
        return fullClassName.substring(lastDotIndex + 1);
    }

    private void setLogWhenFailed(ChungChiNgoaiNgu chungChi) {
        String ketQuaChungChi = "";
        String ketQuaTotNghiep = "";

        if(chungChi instanceof ToeicSW) {
            ketQuaChungChi = String.valueOf(ToeicSW.class.cast(chungChi).getDiem());
            ketQuaTotNghiep = String.valueOf(ToeicSW.DIEM_TOT_NGHIEP);
        } else if(chungChi instanceof ToeicLR) {
            ketQuaChungChi = String.valueOf(ToeicLR.class.cast(chungChi).getDiem());
            ketQuaTotNghiep = String.valueOf(ToeicLR.DIEM_TOT_NGHIEP);
        } else if(chungChi instanceof Ielts) {
            ketQuaChungChi = String.valueOf(Ielts.class.cast(chungChi).getDiem());
            ketQuaTotNghiep = String.valueOf(Ielts.DIEM_TOT_NGHIEP);
        } else if(chungChi instanceof Toefl) {
            ketQuaChungChi = String.valueOf(Toefl.class.cast(chungChi).getDiem());
            ketQuaTotNghiep = String.valueOf(Toefl.DIEM_TOT_NGHIEP);
        } else if (chungChi instanceof VNU_EPT) {
            ketQuaChungChi = String.valueOf(VNU_EPT.class.cast(chungChi).getDiem());
            ketQuaTotNghiep = String.valueOf((VNU_EPT.DIEM_TOT_NGHIEP));
        } else {
            ketQuaChungChi = Cambridge.class.cast(chungChi).getXepLoai();
            ketQuaTotNghiep = Cambridge.LOAI_TOT_NGHIEP;
        }

        this.setLog("Chứng chỉ " + getTenChungChi(chungChi.getClass().getName()) + " của bạn không đủ điểm (" + ketQuaChungChi  + "/" + ketQuaTotNghiep + ")");
    }
}
