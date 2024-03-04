/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.HoaDon;
import com.QiFeng_Milktea.entity.HoaDonChiTiet;
import com.QiFeng_Milktea.entity.XuatBill;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dongduy
 */
public class HoaDonCTDAO extends QiFeng_MikteaDAO<HoaDonChiTiet, Integer> {

    String INSERT_SQL = "INSERT INTO HoaDonChiTiet (SoLuong, KichThuoc, DonGia, ThanhTien, MaHD, MaSP) values (?,?,?,?,?,?)";
    String UPDATE_SQL = "update HoaDonChiTiet set  SoLuong =?, KichThuoc =?, DonGia =?, ThanhTien =?, MaHD =?, MaSP =?,  where MaHDCT = ?";
    String DELETE_SQL = "delete from HoaDonChiTiet where MaHDCT = ?";
    String SELECT_ALL_SQL = "select * from HoaDonChiTiet";
    String SELECT_BY_ID_SQL = "select * from HoaDonChiTiet where MaHDCT = ?";

   

    @Override
    public void insert(HoaDonChiTiet entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSoLuong(), entity.getKichThuoc(),
                entity.getDonGia(), entity.getThanhTien(), entity.getMaHD(),
                entity.getMaSP());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getSoLuong(), entity.getKichThuoc(),
                entity.getDonGia(), entity.getThanhTien(), entity.getMaHD(),
                entity.getMaSP(), entity.getMaHDCT());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDonChiTiet SelectbyID(Integer id) {
        List<HoaDonChiTiet> list = selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

//    public HoaDonChiTiet SelectbySOHD(String SoHD) {
//        List<HoaDonChiTiet> list = selectbySql(SELECT_BY_SOHD_SQL, SoHD);
//        if (list.isEmpty()) {
//            return null;
//        }
//        return list.get(0);
//    }
   

    @Override
    public List<HoaDonChiTiet> selectbySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<HoaDonChiTiet>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaHDCT(rs.getInt("MaHDCT"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setKichThuoc(rs.getString("KichThuoc"));
                entity.setDonGia(rs.getFloat("DonGia"));
                entity.setMaHD(rs.getInt("MaHD"));
                entity.setMaSP(rs.getString("MaSP"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<XuatBill> SelectListByMaHD(int MaHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
