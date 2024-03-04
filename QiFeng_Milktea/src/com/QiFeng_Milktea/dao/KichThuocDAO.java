/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.KichThuocSP;
import com.QiFeng_Milktea.entity.SizeSP;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dongduy
 */
public class KichThuocDAO extends QiFeng_MikteaDAO<KichThuocSP, Integer> {

    String INSERT_SQL = "insert into KichThuocSP(Gia,MaSize,MaSP) values (?,?,?)";
    String UPDATE_SQL = "update KichthuocSP set Gia =?,MaSize =?,MaSP =? where MaKichThuoc = ?";
    String DELETE_SQL = "delete from KichthuocSP where MaKichThuoc = ?";
    String SELECT_ALL_SQL = "select * from KichthuocSP";
    String SELECT_BY_ID_SQL = "select * from KichthuocSP where MaKichThuoc = ?";

    @Override
    public void insert(KichThuocSP entity) {
        JdbcHelper.update(INSERT_SQL, entity.getGia(), entity.getMaSize(), entity.getMaSp());
    }

    @Override
    public void update(KichThuocSP entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getGia(), entity.getMaSize(), entity.getMaSp(), entity.getMaKichThuoc());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<KichThuocSP> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public KichThuocSP SelectbyID(Integer id) {
        List<KichThuocSP> list = selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KichThuocSP> selectbySql(String sql, Object... args) {
List<KichThuocSP> list = new ArrayList<KichThuocSP>();
        try {
            java.sql.ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KichThuocSP entity = new KichThuocSP();
                entity.setMaKichThuoc(rs.getInt("MaKichThuoc"));
                entity.setGia(rs.getFloat("Gia"));
                entity.setMaSize(rs.getInt("MaSize"));
                entity.setMaSp(rs.getString("MaSP"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }

}
