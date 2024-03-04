/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.dao;

import com.QiFeng_Milktea.entity.HoaDonChiTiet;
import com.QiFeng_Milktea.entity.SanPham;
import com.QiFeng_Milktea.entity.XuatBill;
import com.QiFeng_Milktea.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dongduy
 */
public class BillDAO {

    String sql = "SELECT dbo.HoaDon.SoHoaDon, dbo.HoaDon.TongTien, dbo.HoaDon.NgayTao, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.KichThuoc, dbo.HoaDonChiTiet.DonGia, dbo.HoaDonChiTiet.ThanhTien, dbo.KhachHang.TenKH, \n"
            + "dbo.KhachHang.SoDT, dbo.NhanVien.TenNV, dbo.SanPham.TenSP, dbo.SanPham.GiaBan\n"
            + "FROM     dbo.HoaDon INNER JOIN\n"
            + "dbo.HoaDonChiTiet ON dbo.HoaDon.MaHD = dbo.HoaDonChiTiet.MaHD INNER JOIN\n"
            + "dbo.KhachHang ON dbo.HoaDon.MaKH = dbo.KhachHang.MaKH INNER JOIN\n"
            + "dbo.NhanVien ON dbo.HoaDon.MaNV = dbo.NhanVien.MaNV INNER JOIN\n"
            + "dbo.SanPham ON dbo.HoaDonChiTiet.MaSP = dbo.SanPham.MaSP\n"
            + " where HoaDon.MaHD = ?";
    String SELECT_BY_SOHD_SQL = "SELECT dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.KichThuoc, dbo.HoaDonChiTiet.DonGia, dbo.HoaDonChiTiet.ThanhTien, dbo.HoaDonChiTiet.MaSP\n"
            + "FROM     dbo.HoaDon INNER JOIN\n"
            + "dbo.HoaDonChiTiet ON dbo.HoaDon.MaHD = dbo.HoaDonChiTiet.MaHD INNER JOIN\n"
            + "dbo.SanPham ON dbo.HoaDonChiTiet.MaSP = dbo.SanPham.MaSP\n"
            + "WHERE HoaDon.MaHD = ?";

    public XuatBill SelectbyMaHD(Integer maHD) {
        List<XuatBill> list = selectbySql(sql, maHD);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
      public XuatBill SelectbysoHD(Integer soHD) {
        List<XuatBill> list = selectbySql(SELECT_BY_SOHD_SQL, soHD);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<XuatBill> SelectListByMaHD(Integer maHD) {
        List<XuatBill> billList = new ArrayList<>(); // Khởi tạo danh sách hóa đơn
        XuatBill bill = SelectbyMaHD(maHD);

        if (bill != null) {
            billList.add(bill); // Nếu hóa đơn tồn tại, thêm vào danh sách
        }

        return billList; // Trả về danh sách hóa đơn
    }
    public List<XuatBill> SelectListBySoHD(Integer soHD) {
        List<XuatBill> billList = new ArrayList<>(); // Khởi tạo danh sách hóa đơn
        XuatBill bill = SelectbysoHD(soHD);

        if (bill != null) {
            billList.add(bill); // Nếu hóa đơn tồn tại, thêm vào danh sách
        }

        return billList; // Trả về danh sách hóa đơn
    }

    public List<XuatBill> selectbySql(String sql, Object... args) {
        List<XuatBill> list = new ArrayList<XuatBill>();
        try {
            java.sql.ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                XuatBill entity = new XuatBill();
                entity.setSoHoaDon(rs.getString("SoHoaDon"));
                entity.setNgaytao(rs.getDate("Ngaytao"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setTenKH(rs.getString("TenKH"));
                entity.setSoDTKH(rs.getString("SoDT"));
                entity.setTenSP(rs.getString("TenSp"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setKichThuoc(rs.getString("KichThuoc"));
                entity.setDonGia(rs.getFloat("DonGia"));
                entity.setThanhTien(rs.getFloat("ThanhTien"));
                entity.setTongTien(rs.getFloat("TongTien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Dùng để xuất hóa đơn
    public List<HoaDonChiTiet> getChiTietHoaDonList(int maHD) {
        List<HoaDonChiTiet> chiTietHoaDonList = new ArrayList<>();
        try {
            // Thực hiện truy vấn CSDL để lấy chi tiết hóa đơn kèm tên sản phẩm
            String sql = "SELECT sp.TenSP,hdc.MaSP, hdc.SoLuong, hdc.KichThuoc, hdc.DonGia, hdc.ThanhTien FROM HoaDonChiTiet hdc JOIN SanPham sp ON hdc.MaSP = sp.MaSP WHERE hdc.MaHD = ?";
            java.sql.ResultSet rs = JdbcHelper.query(sql, maHD);

            // Duyệt kết quả truy vấn và thêm thông tin chi tiết hóa đơn vào danh sách
            while (rs.next()) {
                HoaDonChiTiet chiTiet = new HoaDonChiTiet();
//            SanPham sp = new SanPham();
//            sp.setTenSP(rs.getString("TenSP"));
                chiTiet.setMaSP(rs.getString("MaSP"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setKichThuoc(rs.getString("KichThuoc"));
                chiTiet.setDonGia(rs.getFloat("DonGia"));
                chiTiet.setThanhTien(rs.getFloat("ThanhTien"));
                chiTietHoaDonList.add(chiTiet);
//            chiTietHoaDonList.add(sp);
            }

            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return chiTietHoaDonList;
    }

}
