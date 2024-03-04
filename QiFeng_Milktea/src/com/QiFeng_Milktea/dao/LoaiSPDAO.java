/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.MaLoaiSP;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dongduy
 */
public class LoaiSPDAO extends QiFeng_MikteaDAO<MaLoaiSP, Integer> {

    String INSERT_SQL = "insert into LoaiSP(TenLoai) values (?)";
    String UPDATE_SQL = "update LoaiSP set TenLoai =? where MaLoai = ?";
    String DELETE_SQL = "delete from LoaiSP where MaLoai = ?";
    String SELECT_ALL_SQL = "select * from LoaiSP";
    String SELECT_TENLOAI_SQL = "select loai.MaLoai from SanPham sp inner join LoaiSP loai "
            + "on sp.Maloai = loai.MaLoai where sp.Tenloai= ?";
    String SELECT_BY_ID_SQL = "select * from LoaiSP where MaLoai = ?";
    String SELECT_BY_TEN_SQL = "SELECT MaLoai FROM LoaiSP WHERE TenLoai = ?";

    @Override
    public void insert(MaLoaiSP entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTenLoai());
    }

    @Override
    public void update(MaLoaiSP entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenLoai(), entity.getMaLoai());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<MaLoaiSP> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public MaLoaiSP SelectbyID(Integer id) {
        List<MaLoaiSP> list = selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<MaLoaiSP> selectbySql(String sql, Object... args) {
        List<MaLoaiSP> list = new ArrayList<MaLoaiSP>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                MaLoaiSP entity = new MaLoaiSP();
                entity.setMaLoai(rs.getInt("MaLoai"));
                entity.setTenLoai(rs.getString("TenLoai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaLoaiSP> selectSanPham(String maSP) {

        return this.selectbySql(SELECT_TENLOAI_SQL, maSP);
    }

//    public List<MaLoaiSP> selectByKyword(String keyword) {
//        String sql = "select sp.TenSP from SanPham sp inner join LoaiSP loai\n"
//                + "on sp.Maloai = loai.MaLoai where loai.TenLoai LIKE N'%" + keyword + "%'";
//        return this.selectbySql(sql, "%" + keyword + "%");
//    }
    public List<MaLoaiSP> selectByTen(String keyword) {

        return this.selectbySql(SELECT_BY_TEN_SQL, keyword);
    }
     public List<MaLoaiSP> selectByKeyword(String tenLoai) {
        String sql = "select sp.MaSP, sp.TenSP,sp.GiaBan,sp.SoLuong from SanPham sp inner join LoaiSP loai\n" +
"                on sp.Maloai = loai.MaLoai where loai.TenLoai = ? ";
        return this.selectbySql(sql, tenLoai );

    }
}
