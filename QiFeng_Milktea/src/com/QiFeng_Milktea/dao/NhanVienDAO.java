/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.NhanVien;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends QiFeng_MikteaDAO<NhanVien, String> {

    String INSERT_SQL = "insert into NhanVien(MaNV,TenNV,Email,SoDT,GioiTinh,NgaySinh,VaiTro,MatKhau,Hinh) values (?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "update NhanVien set TenNV =?,Email =?,SoDT =?,GioiTinh =?,NgaySinh =?,VaiTro =?,MatKhau =?,Hinh =? where MaNV = ?";
    String UPDATEMK_SQL = "update NhanVien set MatKhau = ? where MaNV = ?";
    String UPDATE_ThoiGiankhoa_SQL = "update NhanVien set ThoiGianKhoa = ? where MaNV = ?";
    String DELETE_SQL = "delete from NhanVien where MaNV = ?";
    String UPDATETT_SQL = "update NhanVien set TenNV =?,Email =?,SoDT =?,GioiTinh =?,NgaySinh =?,VaiTro =? where MaNV = ?";
    String SELECT_ALL_SQL = "select * from NhanVien";
    String SELECT_BY_ID_SQL = "select * from NhanVien where MaNV = ?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaNV(), entity.getTenNV(),
                entity.getEmail(), entity.getSoDT(), entity.isGioiTinh(),
                entity.getNgaySinh(), entity.isVaiTro(), entity.getMatKhau(), entity.getHinhAnh());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenNV(),
                entity.getEmail(), entity.getSoDT(), entity.isGioiTinh(),
                entity.getNgaySinh(), entity.isVaiTro(), entity.getMatKhau(), entity.getHinhAnh(), entity.getMaNV());
    }

    public void updateMK(NhanVien entity) {
        JdbcHelper.update(UPDATEMK_SQL, entity.getMatKhau(), entity.getMaNV());
    }

    public void updateTT(NhanVien entity) {
        JdbcHelper.update(UPDATETT_SQL, entity.getTenNV(),
                entity.getEmail(), entity.getSoDT(), entity.isGioiTinh(),
                entity.getNgaySinh(), entity.isVaiTro(), entity.getMaNV());
    }

    public void updateThoiGianKhia(NhanVien entity) {
        JdbcHelper.update(UPDATE_ThoiGiankhoa_SQL, entity.getThoiGianKhoa(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien SelectbyID(String id) {
        List<NhanVien> list = selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectbySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setEmail(rs.getString("Email"));
                entity.setSoDT(rs.getString("SoDT"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setHinhAnh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien> selectByKyword(String kyword) {
        String sql = "select * from nhanVien where TenNV like ?";
        return this.selectbySql(sql, "%" + kyword + "%");
    }

}
