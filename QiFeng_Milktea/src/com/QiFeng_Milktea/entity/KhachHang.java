/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.entity;

/**
 *
 * @author Dongduy
 */
public class KhachHang {
    private int maKH;
    private String tenKH;
    private String soDTKH;
    private String diaChi;
    private boolean gioiTinh;

    public KhachHang() {
    }

    public KhachHang(int maKH, String tenKH, String soDTKH, String diaChi, boolean gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDTKH = soDTKH;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }



    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoDTKH() {
        return soDTKH;
    }

    public void setSoDTKH(String soDTKH) {
        this.soDTKH = soDTKH;
    }



    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

   
    
}
