/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.SizeSP;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Dongduy
 */
public class SizeDAO extends QiFeng_MikteaDAO<SizeSP, Integer> {

    String INSERT_SQL = "insert into Size(TenSize) values (?)";
    String UPDATE_SQL = "update Size set TenSize =? where MaSize = ?";
    String DELETE_SQL = "delete from Size where MaSize = ?";
    String SELECT_ALL_SQL = "select * from Size";
    String SELECT_BY_ID_SQL = "select * from Size where MaSize = ?";

    @Override
    public void insert(SizeSP entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTenSize());
    }

    @Override
    public void update(SizeSP entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenSize(), entity.getMaSize());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SizeSP> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public SizeSP SelectbyID(Integer id) {
        List<SizeSP> list = selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SizeSP> selectbySql(String sql, Object... args) {
        List<SizeSP> list = new ArrayList<SizeSP>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SizeSP entity = new SizeSP();
                entity.setMaSize(rs.getInt("MaSize"));
                entity.setTenSize(rs.getString("TenSize"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
