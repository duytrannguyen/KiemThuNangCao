/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.entity;

import com.QiFeng_Milktea.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dongduy
 */
public class XuatBill {
    private String tenNV;
    private Date ngaytao;
    private String soHoaDon;
    private String tenKH;
    private String soDTKH;
    private String tenSP;
    private int soLuong;
    private float donGia;
    private String kichThuoc;
    private float thanhTien;
    private float tongTien;

    public XuatBill() {
    }

    public XuatBill(String tenNV, Date ngaytao, String soHoaDon, String tenKH, String soDTKH, String tenSP, int soLuong, float donGia, String kichThuoc, float thanhTien, float tongTien) {
        this.tenNV = tenNV;
        this.ngaytao = ngaytao;
        this.soHoaDon = soHoaDon;
        this.tenKH = tenKH;
        this.soDTKH = soDTKH;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.kichThuoc = kichThuoc;
        this.thanhTien = thanhTien;
        this.tongTien = tongTien;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(String soHoaDon) {
        this.soHoaDon = soHoaDon;
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

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    // Trong lớp XuatBill, thêm phương thức getItems() để trả về danh sách sản phẩm trong hóa đơn


    
    
}
