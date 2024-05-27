package com.project.ie303group03.models;

import java.util.ArrayList;

public class DieuKienCSN extends DieuKienTotNghiep {
    private ArrayList<MonHoc> dsMonHocCSN = null;
    static private final int TC_CSN = 19;
    public DieuKienCSN(DanhSachMonHoc dsmh) {
        super();
        this.dsMonHocCSN = dsmh.getMonHocByType("CSN");
    }

    @Override
    public boolean xetDieuKien(SinhVien sv) {
       ArrayList<MonHoc> notStudy = new ArrayList<>();
       String log = "";
       int total = 0;
       for (MonHoc mh: dsMonHocCSN) {
           KetQuaHocTap kq = sv.getKetQuaHocTapFromBangDiem(mh.getMaMH());
           if (kq != null) {
               total += kq.getMonHoc().getSoTinChi();
           }
           else {
               notStudy.add(mh);
           }
       }
       if (total < TC_CSN){
           log += "\nBạn đã tích lũy được " + total + "tín chỉ cơ sở ngành.\nBạn cần tích lũy tối thiểu 19 tín chỉ cơ sở ngành.\nSau đây là các môn bạn chưa học:";
           for (MonHoc notYet : notStudy) {
               log += "\n+ Môn " + notYet.getMaMH() + "\tSố TC: " + notYet.getSoTinChi();
           }
           this.setLog(log);
           return false;
       }
       return true;
    }
}
