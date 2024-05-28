package com.project.ie303group03.models;

import java.util.ArrayList;
import java.util.Arrays;

public class DieuKienCN extends DieuKienTotNghiep{
    private ArrayList<MonHoc> dsMonHocCN = null;
    static private final int TC_CN = 24;

    public DieuKienCN (DanhSachMonHoc dsmh) {
        super();
        this.dsMonHocCN = dsmh.getMonHocByType("CN");
    }

    @Override
    public boolean xetDieuKien(SinhVien sv) {
        ArrayList<MonHoc> notStudy = new ArrayList<>();
        String[] dsCN = {"IE201", "IE212", "IS217", "IS254", "IE221", "IE224", "IE309",
                         "IE202", "IE203", "IS208", "IS336", "IE301", "IE302", "IE102",
                         "IE204", "IE213", "IE353", "IS334", "IE303", "IE307",
                         "IS251", "IS352", "IS351", "IE205", "IE304", "IE305"};
        String log = "";
        int totalInner = 0;
        int totalOuter = 0;
        for (MonHoc mh: dsMonHocCN) {
            KetQuaHocTap kq = sv.getKetQuaHocTapFromBangDiem(mh.getMaMH());
            if (kq == null) {
                notStudy.add(mh);
            }
            else {
                if (kq.getDiemTongKet() >= 5f) {
                    if (Arrays.asList(dsCN).contains(kq.getMonHoc().getMaMH())) {
                        totalInner += mh.getSoTinChi();
                    } else {
                        totalOuter += mh.getSoTinChi();
                    }
                }
            }
        }

        if (totalOuter > 12) totalOuter = 12;
        int sum = totalInner + totalOuter;

        if (sum < 24)
        {
            log += "\nBạn cần tích lũy tối thiểu 24 tín chỉ chuyên ngành \nBạn đã tích lũy được " + String.valueOf(sum) + " tín chỉ chuyên ngành.";
            log += "\nTrong đó có: \n+ " + String.valueOf(totalInner) + " tín chỉ trong các mục 1.3.3.1 & 1.3.3.2 & 1.3.3.3 & 1.3.3.3 trang student.";
            log += "\n+ " + String.valueOf(totalOuter) + " tín chỉ trong mục 1.3.3.5 trang student .";
            log += "\n *** Lưu ý: Số tín chỉ ở mục 1.3.3.5 chỉ được tích lũy tối thiểu 12 tín chỉ " +
                        "\n    Nếu bạn học nhiều hơn 12 tín chỉ thì vẫn chỉ được tính 12 tín chỉ tích lũy ***";

            log += "\n ======== Các môn học còn lại trong ngành";
            for (MonHoc mh : notStudy)
            {
                if ( Arrays.asList(dsCN).contains(mh.getMaMH()) )
                    log += "\n + " + mh.getMaMH() + "\t Số TC: " + mh.getSoTinChi();
            }

            log += "\n ========= Các môn học trong khoa ";
            for (MonHoc mh : notStudy)
            {
                if (mh.getKhoa().getMaKhoa().equals("KTTT"))
                    log += "\n + " + mh.getMaMH() + "\t Số TC: " + mh.getSoTinChi();
            }

            this.setLog(log);
            return false;
        }

        return true;
    }
}
