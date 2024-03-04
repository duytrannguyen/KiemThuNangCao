/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.HoaDon;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Dongduy
 */
public class HoaDonDAO extends QiFeng_MikteaDAO<HoaDon, String> {

    String INSERT_SQL = "INSERT INTO HoaDon (SoHoaDon, TongTien, NgayTao, MaKH, MaNV) values (?,?,?,?,?)";
    String UPDATE_SQL = "update HoaDon set  SoHoaDon =? ,TongTien =?, NgayTao =?,MaKH =?, MaNV =? where MaHD = ?";
    String DELETE_SQL = "delete from HoaDon where MaHD = ?";
    String SELECT_ALL_SQL = "select * from HoaDon";
    String SELECT_BY_ID_SQL = "select * from HoaDon where MaHD = ?";
    
    @Override
    public void insert(HoaDon entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSoHD(), entity.getTongTien(),
                entity.getNgayTao(), entity.getMaKH(), entity.getMaNV());
    }

    @Override
    public void update(HoaDon entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getSoHD(), entity.getTongTien(),
                entity.getNgayTao(), entity.getMaKH(), entity.getMaNV(), entity.getMaHD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon SelectbyID(String id) {
        List<HoaDon> list = selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
   

    @Override
    public List<HoaDon> selectbySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getInt("MaHD"));
                entity.setSoHD(rs.getString("SoHoaDon"));
                entity.setTongTien(rs.getFloat("TongTien"));
                entity.setNgayTao(rs.getDate("NgayTao"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet countSoHoaDon(String SoHoaDon) {
        String cauTruyVan = "select COUNT(*) from HoaDon where SoHoaDon like ?";
        return JdbcHelper.query(cauTruyVan, "%" + SoHoaDon + "%");
    }

    public static ResultSet getBySoHoaDon(String SoHoaDon) {
        String cauTruyVan = "select * from HoaDon where SoHoaDon like ?";
        return JdbcHelper.query(cauTruyVan, "%" + SoHoaDon + "%");
    }

}
