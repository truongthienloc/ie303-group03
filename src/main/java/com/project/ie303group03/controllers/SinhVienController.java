package com.project.ie303group03.controllers;

import com.project.ie303group03.models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class SinhVienController {
    private SinhVien sinhVien;
    private String[] logs;

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void initData() {
        // tao ds mon hoc
        DanhSachMonHoc dsmh = null;
        try {
            dsmh = new DanhSachMonHoc();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // tạo thông tin cá nhân
        String maSV = "21520984";
        String hoTen = "Tran Dinh Khanh";

        // Khởi tạo chứng chỉ ngoại ngữ
        ToeicLR toeicLR = new ToeicLR("toeicLR", 2024 ,800, 2);
        ToeicSW toiecSW = new ToeicSW("toiecSW", 2024, 320, 2);

        ArrayList<ChungChiNgoaiNgu> dsChungChiNgoaiNgu = new ArrayList<ChungChiNgoaiNgu>();
        dsChungChiNgoaiNgu.add(toeicLR);
        dsChungChiNgoaiNgu.add(toiecSW);
        //....


        // tạo môn học
        ArrayList<KetQuaHocTap> bangDiem = new ArrayList<>();

        KetQuaHocTap kq1 = new KetQuaHocTap(dsmh.getMonHocById("IE104"), 9.4f);
        bangDiem.add(kq1);

        KetQuaHocTap kq2 = new KetQuaHocTap(dsmh.getMonHocById("IE224"), 8.9f);
        bangDiem.add(kq2);

        KetQuaHocTap kq3 = new KetQuaHocTap(dsmh.getMonHocById("IS207"), 9.5f);
        bangDiem.add(kq3);

        KetQuaHocTap kq4 = new KetQuaHocTap(dsmh.getMonHocById("SE104"), 9f);
        bangDiem.add(kq4);

        KetQuaHocTap kq5 = new KetQuaHocTap(dsmh.getMonHocById("SS010"), 9f);
        bangDiem.add(kq5);

        KetQuaHocTap kq6 = new KetQuaHocTap(dsmh.getMonHocById("IE101"), 7.5f);
        bangDiem.add(kq6);

        KetQuaHocTap kq7 = new KetQuaHocTap(dsmh.getMonHocById("IE103"), 8.6f);
        bangDiem.add(kq7);

        KetQuaHocTap kq8 = new KetQuaHocTap(dsmh.getMonHocById("IE105"), 9.1f);
        bangDiem.add(kq8);

        KetQuaHocTap kq9 = new KetQuaHocTap(dsmh.getMonHocById("IT007"), 9.9f);
        bangDiem.add(kq9);

        KetQuaHocTap kq10 = new KetQuaHocTap(dsmh.getMonHocById("PE012"), 9f);
        bangDiem.add(kq10);

        KetQuaHocTap kq11 = new KetQuaHocTap(dsmh.getMonHocById("SS008"), 8.5f);
        bangDiem.add(kq11);

        KetQuaHocTap kq12 = new KetQuaHocTap(dsmh.getMonHocById("IT004"), 8.8f);
        bangDiem.add(kq12);

        KetQuaHocTap kq13 = new KetQuaHocTap(dsmh.getMonHocById("IT005"), 8.6f);
        bangDiem.add(kq13);

        KetQuaHocTap kq14 = new KetQuaHocTap(dsmh.getMonHocById("IT012"), 9.3f);
        bangDiem.add(kq14);

        KetQuaHocTap kq15 = new KetQuaHocTap(dsmh.getMonHocById("MA005"), 9.9f);
        bangDiem.add(kq15);

        KetQuaHocTap kq16 = new KetQuaHocTap(dsmh.getMonHocById("SS003"), 7.5f);
        bangDiem.add(kq16);

        KetQuaHocTap kq17 = new KetQuaHocTap(dsmh.getMonHocById("SS009"), 9.3f);
        bangDiem.add(kq17);

        KetQuaHocTap kq18 = new KetQuaHocTap(dsmh.getMonHocById("IT002"), 9.2f);
        bangDiem.add(kq18);

        KetQuaHocTap kq19 = new KetQuaHocTap(dsmh.getMonHocById("IT003"), 9.1f);
        bangDiem.add(kq19);

        KetQuaHocTap kq20 = new KetQuaHocTap(dsmh.getMonHocById("MA004"), 9.8f);
        bangDiem.add(kq20);

        KetQuaHocTap kq21 = new KetQuaHocTap(dsmh.getMonHocById("SS004"), 9.7f);
        bangDiem.add(kq21);

        KetQuaHocTap kq22 = new KetQuaHocTap(dsmh.getMonHocById("SS007"), 8f);
        bangDiem.add(kq22);

        KetQuaHocTap kq23 = new KetQuaHocTap(dsmh.getMonHocById("ENG02"), 8.1f);
        bangDiem.add(kq23);

        KetQuaHocTap kq24 = new KetQuaHocTap(dsmh.getMonHocById("IE005"), 9.7f);
        bangDiem.add(kq24);

        KetQuaHocTap kq25 = new KetQuaHocTap(dsmh.getMonHocById("IT001"), 9.1f);
        bangDiem.add(kq25);

        KetQuaHocTap kq26 = new KetQuaHocTap(dsmh.getMonHocById("MA003"), 9.2f);
        bangDiem.add(kq26);

        KetQuaHocTap kq27 = new KetQuaHocTap(dsmh.getMonHocById("MA006"), 9.8f);
        bangDiem.add(kq27);

        KetQuaHocTap kq28 = new KetQuaHocTap(dsmh.getMonHocById("SS006"), 8f);
        bangDiem.add(kq28);



        // điểm rèn luyện
        int diemRenLuyen = 100;

        this.sinhVien = new SinhVien(maSV, hoTen, dsChungChiNgoaiNgu, bangDiem, diemRenLuyen);
    }

    public void print() {
        for(KetQuaHocTap kq: this.sinhVien.getBangDiem()) {
            System.out.println(kq.getMonHoc().getTenMH() + "---" + kq.getDiemTongKet());
        }
    }
}
