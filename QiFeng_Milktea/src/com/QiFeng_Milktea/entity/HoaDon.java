/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.entity;

import java.util.Date;

/**
 *
 * @author Dongduy
 */
public class HoaDon {

    private int maHD;
    private String SoHD;
    private String maNV;
    private double tongTien;
    private Date ngayTao;
    private int maKH;

    public HoaDon() {
    }

    public HoaDon(int maHD, String SoHD, String maNV, double tongTien, Date ngayTao, int maKH) {
        this.maHD = maHD;
        this.SoHD = SoHD;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.maKH = maKH;
    }

    

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getSoHD() {
        return SoHD;
    }

    public void setSoHD(String SoHD) {
        this.SoHD = SoHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

}
