/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.QiFeng_Milktea.utils;

import com.QiFeng_Milktea.main.DangNhap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Dongduy
 */
public class JdbcHelper {
    private static String server1 = "localhost";
    private static String databaseName1 = "QiFeng_Milktea";
//    private static String server1 = DangNhap.server;
//    private static String databaseName1 = DangNhap.databaseName;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String connectionUrl = "jdbc:sqlserver://"+server1+":1433;"
            + "databaseName="+databaseName1+";"
            + "user=sa;password=dongduy122;"
            + "encrypt=true;trustServerCertificate=true;";
    public static Connection conn;

    //nạp driver
    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        conn = DriverManager.getConnection(connectionUrl);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = conn.prepareCall(sql);
        } else {
            pstmt = conn.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }

        return pstmt;
    }

    public static void update(String sql, Object... args) {
        try {
            PreparedStatement pstmt = getStmt(sql, args);
            try {
                pstmt.executeUpdate();
            } finally {
                pstmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Hàm thực hiện câu lệnh Select
    public static ResultSet query(String sql, Object... args) {
        try {
            PreparedStatement prmst = getStmt(sql, args);
            return prmst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = query(sql, args);
            if (rs.next()) {
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
