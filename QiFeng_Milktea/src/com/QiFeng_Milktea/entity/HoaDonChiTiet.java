/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.entity;

/**
 *
 * @author Dongduy
 */
public class HoaDonChiTiet {

    private int maHDCT;
    private int soLuong;
    private String kichThuoc;
    private float donGia;
    private float thanhTien;
    private int maHD;
    private String maSP;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHDCT, int soLuong, String kichThuoc, float donGia, float thanhTien, int maHD, String maSP) {
        this.maHDCT = maHDCT;
        this.soLuong = soLuong;
        this.kichThuoc = kichThuoc;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.maHD = maHD;
        this.maSP = maSP;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

}
