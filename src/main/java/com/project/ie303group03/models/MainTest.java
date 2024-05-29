package com.project.ie303group03.models;

import com.project.ie303group03.controllers.SinhVienController;

import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) throws SQLException {
       SinhVienController controller = new SinhVienController();
        controller.initData();
        controller.xetTotNghiep();
        controller.luuKetQuaXetTotNghiep();
    }
}
