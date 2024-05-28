package com.project.ie303group03.models;

public class KetQuaHocTap {
    private MonHoc monHoc;
    private float diemTongKet;

    public KetQuaHocTap(MonHoc monHoc, float diemTongKet) {
        this.monHoc = monHoc;
        this.diemTongKet = diemTongKet;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public float getDiemTongKet() {
        return diemTongKet;
    }
}
