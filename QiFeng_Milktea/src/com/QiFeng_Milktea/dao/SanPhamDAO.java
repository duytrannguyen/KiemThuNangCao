/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.SanPham;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Dongduy
 */
public class SanPhamDAO extends QiFeng_MikteaDAO<SanPham, String> {

    String INSERT_SQL = "INSERT INTO SanPham (MaSP, TenSP, GiaNhap, GiaBan,  MaLoai) values (?,?,?,?,?)";
    String UPDATE_SQL = "update SanPham set TenSP =?,GiaNhap =?,GiaBan =?,MaLoai =? where MaSP = ?";
    String DELETE_SQL = "delete from SanPham where MaSP = ?";
    String SELECT_ALL_SQL = "select * from SanPham";
    String SELECT_BY_ID_SQL = "select * from SanPham where MaSP = ?";
    String SELECT_BY_TEN_SQL = "select * from SanPham where TenSP like ?";

    @Override
    public void insert(SanPham entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaSP(), entity.getTenSP(), entity.getGiaNhap(), entity.getGiaBan(),  entity.getMaLoai());
    }

    @Override
    public void update(SanPham entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenSP(), entity.getGiaNhap(), entity.getGiaBan(),  entity.getMaLoai(), entity.getMaSP());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham SelectbyID(String id) {
        List<SanPham> list = selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectbySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SanPham entity = new SanPham();
                entity.setMaSP(rs.getString("MaSP"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setGiaNhap(rs.getFloat("GiaNhap"));
                entity.setGiaBan(rs.getFloat("GiaBan"));
                entity.setMaLoai(rs.getInt("MaLoai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<SanPham> selectByKeywordSanPham(String tenSP) {
        
        return this.selectbySql(SELECT_BY_TEN_SQL, "%" + tenSP + "%");

    }

    public static ResultSet Search(String TenLoai) {
        String sql = "select sp.MaSP, sp.TenSP,sp.GiaBan from SanPham sp inner join LoaiSP loai\n"
                + "                on sp.Maloai = loai.MaLoai where loai.TenLoai LIKE N'%" + TenLoai + "%'";
        return JdbcHelper.query(sql, TenLoai);
    }
}
