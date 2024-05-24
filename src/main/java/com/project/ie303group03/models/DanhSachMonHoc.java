package com.project.ie303group03.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DanhSachMonHoc {
   private ArrayList<MonHoc> dsMonHoc = new ArrayList<>();

    public DanhSachMonHoc() throws SQLException {
//        String sql = "SELECT * FROM MONHOC mh, KHOA k, LOAIMONHOC lmh WHERE mh....";
//        ResultSet results = SQLServer.getServerInstance().query(sql);
        System.out.println("Load mon hoc");
    }

    public MonHoc getMonHocById(String id) {
        for (MonHoc mh : this.dsMonHoc) {
            if (mh.getMaMH().equals(id))
                return mh;
        }
        return null;
    }
}
