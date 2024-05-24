package com.project.ie303group03.controllers;

import com.project.ie303group03.models.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class SinhVienController {
    private SinhVien sinhVien;
    private String[] logs;

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
        ArrayList<ChungChiNgoaiNgu> dsChungChiNgoaiNgu = new ArrayList<ChungChiNgoaiNgu>();
        dsChungChiNgoaiNgu.add(toeicLR);
        //....


        // tạo môn học
        KetQuaHocTap kq1 = new KetQuaHocTap(dsmh.getMonHocById(("IT001")), 9f);
        //.....
        ArrayList<KetQuaHocTap> bangDiem = new ArrayList<>();

        // điểm rèn luyện
        int diemRenLuyen = 100;

//        this.sinhVien = new SinhVien(maSV, hoTen, bangDiem, dsChungChiNgoaiNgu);
    }
}
