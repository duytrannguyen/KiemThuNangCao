/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ThongKeDAO {

    private final JdbcHelper dbHelper;

    public ThongKeDAO(JdbcHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<Object[]> getTenSanPhamTheoNgay() {
        String sql = "SELECT sp.TenSP AS TenSanPham, hd.NgayTao AS NgayXuatHoaDon "
                + "FROM SanPham sp "
                + "JOIN HoaDonChiTiet hdct ON sp.MaSP = hdct.MaSP "
                + "JOIN HoaDon hd ON hdct.MaHD = hd.MaHD "
                + "GROUP BY sp.TenSP, hd.NgayTao";
        String[] cols = {"TenSanPham", "NgayXuatHoaDon"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getSoLuongSanPham() {
        String sql = "SELECT sp.TenSP AS TenSanPham, hd.NgayTao AS NgayXuatHoaDon, "
                + "SUM(hdct.SoLuong) AS SoLuongBan "
                + "FROM SanPham sp "
                + "JOIN HoaDonChiTiet hdct ON sp.MaSP = hdct.MaSP "
                + "JOIN HoaDon hd ON hdct.MaHD = hd.MaHD "
                + "GROUP BY sp.TenSP, hd.NgayTao";
        String[] cols = {"TenSanPham", "NgayXuatHoaDon", "SoLuongBan"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getTongTienMoiHoaDon() {
        String sql = "SELECT sp.TenSP AS TenSanPham, hd.NgayTao AS NgayXuatHoaDon, "
                + "SUM(hdct.SoLuong * hdct.DonGia) AS TongTien "
                + "FROM SanPham sp "
                + "JOIN HoaDonChiTiet hdct ON sp.MaSP = hdct.MaSP "
                + "JOIN HoaDon hd ON hdct.MaHD = hd.MaHD "
                + "GROUP BY sp.TenSP, hd.NgayTao";
        String[] cols = {"TenSanPham", "NgayXuatHoaDon", "TongTien"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getLichSu() {
        String sql = "SELECT dbo.HoaDon.MaHD, dbo.HoaDon.SoHoaDon, dbo.HoaDon.TongTien, dbo.HoaDon.NgayTao, sum( dbo.HoaDonChiTiet.SoLuong) AS SoLuong, dbo.KhachHang.TenKH, dbo.NhanVien.TenNV\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + " dbo.HoaDonChiTiet ON dbo.HoaDon.MaHD = dbo.HoaDonChiTiet.MaHD INNER JOIN\n"
                + " dbo.KhachHang ON dbo.HoaDon.MaKH = dbo.KhachHang.MaKH INNER JOIN\n"
                + " dbo.NhanVien ON dbo.HoaDon.MaNV = dbo.NhanVien.MaNV\n"
                + "group by dbo.HoaDon.MaHD, dbo.HoaDon.SoHoaDon, dbo.HoaDon.TongTien, dbo.HoaDon.NgayTao,  SoLuong,\n"
                + "dbo.KhachHang.TenKH, dbo.NhanVien.TenNV";
        String[] cols={"MaHD", "SoHoaDon", "TongTien", "NgayTao",  "SoLuong","TenKH", "TenNV"};
        return getListOfArray(sql, cols);
    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            try (ResultSet rs = dbHelper.query(sql, args)) {
                while (rs.next()) {
                    Object[] vals = new Object[cols.length];
                    for (int i = 0; i < cols.length; i++) {
                        vals[i] = rs.getObject(cols[i]);
                    }
                    list.add(vals);
                }
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
