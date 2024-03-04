/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QiFeng_Milktea.bill;


import com.QiFeng_Milktea.dao.HoaDonDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.QiFeng_Milktea.utils.MsgBox;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CuongNP
 */
public class BLLHoaDon {
    public static int GetMaHDBySoHoaDon(String SoHoaDon){
        ResultSet rs = HoaDonDAO.getBySoHoaDon(SoHoaDon);
        try {
            if(rs.next()){
                return rs.getInt("MaHD");
            }
        } catch (SQLException ex) {
//            ThongBao.ThongBao("Lỗi lấy mã hóa đơn từ số hóa đơn", "Thông báo lỗi");

        }
        return -1;
    }
    
    
}
