package com.project.ie303group03.models;

abstract public class DieuKienTotNghiep {
    protected String log;

    public DieuKienTotNghiep() {
        this.log = "";
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String message) {
        this.log = message;
    }

    public abstract boolean xetDieuKien(SinhVien sv);
}
