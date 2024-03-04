/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dongduy
 */
public class XDate {

    static SimpleDateFormat formatter = new SimpleDateFormat();

    public static Date toDate(String date, String pattern) {
        try {
            formatter.applyPattern(pattern);
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Date date, String pattern) {
        formatter.applyPattern(pattern);
        return formatter.format(date);
    }

    public static Date now() {
        return new Date();
    }

    public static Date addDay(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
//Hàm đổi từ số sang chữ có định dạng 

    public static String DinhDangTien(double tien) {
        return NumberFormat.getNumberInstance().format(tien);
    }

    //Hàm chuyển từ chữ sang số để tính toán
    public static double ChuyenTien(String tien) {
        try {
            return NumberFormat.getNumberInstance().parse(tien).doubleValue();
        } catch (ParseException ex) {
//            GUI.frmHeThong.ThongBao("Thông báo", "Lỗi chuyển dữ liệu");

        }
        return 0;
    }

    public static int ChuyenSoLuong(String SoLuong) throws ParseException {
    return NumberFormat.getNumberInstance().parse(SoLuong).intValue();
}


}
