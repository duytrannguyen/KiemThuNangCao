/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.KhachHang;
import com.QiFeng_Milktea.entity.MaLoaiSP;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dongduy
 */
public class KhachHangDAO extends QiFeng_MikteaDAO<KhachHang, Integer> {

    String INSERT_SQL = "INSERT INTO KhachHang (TenKH, GioiTinh, SoDT, Diachi) values (?,?,?,?)";
    String UPDATE_SQL = "update KhachHang set TenKH =?, GioiTinh =?, SoDT =?, Diachi =? where MaKH = ?";
    String DELETE_SQL = "delete from KhachHang where MaKH = ?";
    String SELECT_ALL_SQL = "select * from KhachHang";
    String SELECT_BY_ID_SQL = "select * from KhachHang where MaKH = ?";
    String SELECT_BY_TEN_SQL = "select * from KhachHang where TenKH like ? or SoDT like ?";
    String SELECT_BY_SoDT_SQL = "select * from KhachHang where SoDT like ?";

    @Override
    public void insert(KhachHang entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTenKH(), entity.isGioiTinh(), entity.getSoDTKH(), entity.getDiaChi());
    }

    @Override
    public void update(KhachHang entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenKH(), entity.isGioiTinh(), entity.getSoDTKH(), entity.getDiaChi(), entity.getMaKH());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang SelectbyID(Integer id) {
        List<KhachHang> list = selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
   public List<KhachHang> selectByTenKH(String kyword) {
        
        return this.selectbySql(SELECT_BY_TEN_SQL, "%" + kyword + "%","%" + kyword + "%");
    }
    public List<KhachHang> selectBySoDTKH(String SoDTKH) {
        
        return this.selectbySql(SELECT_BY_SoDT_SQL, "%" + SoDTKH + "%");
    }

    @Override
    public List<KhachHang> selectbySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setTenKH(rs.getString("TenKH"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setSoDTKH(rs.getString("SoDT"));
                entity.setDiaChi(rs.getString("Diachi"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
