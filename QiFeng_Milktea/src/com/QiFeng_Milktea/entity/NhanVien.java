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
public class NhanVien {

    private String maNV;
    private String tenNV;
    private String email;
    private String soDT;
    private boolean gioiTinh;
    private Date ngaySinh;
    private boolean vaiTro;
    private String matKhau;
    private String hinhAnh;
    private long thoiGianKhoa;
    private int soLanSai;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String email, String soDT, boolean gioiTinh, Date ngaySinh, boolean vaiTro, String matKhau, String hinhAnh, long thoiGianKhoa, int soLanSai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.email = email;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
        this.hinhAnh = hinhAnh;
        this.thoiGianKhoa = thoiGianKhoa;
        this.soLanSai = soLanSai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public long getThoiGianKhoa() {
        return thoiGianKhoa;
    }

    public void setThoiGianKhoa(long thoiGianKhoa) {
        this.thoiGianKhoa = thoiGianKhoa;
    }

    public int getSoLanSai() {
        return soLanSai;
    }

    public void setSoLanSai(int soLanSai) {
        this.soLanSai = soLanSai;
    }

    @Override
    public String toString() {
        return "NhanVien [maNV=" + this.maNV + ", tenNV=" + this.tenNV + ", soLanSai=" + this.soLanSai + ", thoiGianKhoa=" + this.thoiGianKhoa + "]";
    }

}
