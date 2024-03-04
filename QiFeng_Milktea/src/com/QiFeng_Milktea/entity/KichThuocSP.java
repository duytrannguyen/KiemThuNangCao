/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.entity;

/**
 *
 * @author Dongduy
 */
public class KichThuocSP {
 private int maKichThuoc;
 private float gia;
 private String maSp;
 private int maSize;

    public KichThuocSP() {
    }

    public KichThuocSP(int maKichThuoc, float gia, String maSp, int maSize) {
        this.maKichThuoc = maKichThuoc;
        this.gia = gia;
        this.maSp = maSp;
        this.maSize = maSize;
    }

   

    public int getMaKichThuoc() {
        return maKichThuoc;
    }

    public void setMaKichThuoc(int maKichThuoc) {
        this.maKichThuoc = maKichThuoc;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
    }
 
}
