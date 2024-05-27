package com.project.ie303group03.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DanhSachMonHoc {
   private ArrayList<MonHoc> dsMonHoc = new ArrayList<>();

    public DanhSachMonHoc() throws SQLException {
        String sql = "SELECT mh.MAMH, mh.TENMH, lm.MALOAI, lm.TENLOAI, kh.MAKHOA, kh.TENKHOA, mh.SOTC FROM MONHOC mh, LOAIMH lm, KHOA kh WHERE mh.MALOAI = lm.MALOAI AND mh.MAKHOA = kh.MAKHOA";
        ResultSet results = SQLServer.getServerInstance().select(sql);
        while(results.next()) {
            String maMH = results.getString("MAMH");
            String tenMH = results.getString("TENMH");
            String maLoai = results.getString("MALOAI");
            String tenLoai = results.getString("TENLOAI");
            String maKhoa = results.getString("MAKHOA");
            String tenKhoa = results.getString("TENKHOA");
            int soTinChi = Integer.valueOf(results.getString("SOTC"));
            Khoa khoa = new Khoa(maKhoa,tenKhoa);
            LoaiMonHoc loaiMon = new LoaiMonHoc(maLoai,tenLoai);
            MonHoc mh = new MonHoc(maMH,tenMH,soTinChi,khoa,loaiMon);
            this.dsMonHoc.add(mh);
        }
        SQLServer.getServerInstance().closeConnection();
    }

    public ArrayList<MonHoc> getDsMonHoc() {
        return this.dsMonHoc;
    }

    public MonHoc getMonHocById(String id) {
        for (MonHoc mh : this.dsMonHoc) {
            if (mh.getMaMH().equals(id))
                return mh;
        }
        return null;
    }

    public ArrayList<MonHoc> getMonHocByType(String type) {
        ArrayList<MonHoc> results = new ArrayList<>();
        for (MonHoc mh : this.dsMonHoc) {
            if (mh.getLoaiMH().getMaLoaiMH().equals(type))
                results.add(mh);
        }
        return results;
    }
    public ArrayList<MonHoc> getMonHocByKhoa (String makhoa) {
        ArrayList<MonHoc> results = new ArrayList<>();
        for (MonHoc mh : this.dsMonHoc) {
            if (mh.getKhoa().getMaKhoa().equals(makhoa))
                results.add(mh);
        }
        return results;
    }
}
