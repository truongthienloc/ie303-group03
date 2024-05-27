package com.project.ie303group03.models;

import com.project.ie303group03.controllers.SinhVienController;

public class MainTest {
    public static void main(String[] args) {
       SinhVienController controller = new SinhVienController();
        controller.initData();
        controller.xetTotNghiep();
    }
}
