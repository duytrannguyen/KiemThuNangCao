package com.QiFeng_Milktea.ul;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import com.QiFeng_Milktea.utils.JdbcHelper;
import com.QiFeng_Milktea.utils.XDate;

import java.util.Date;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.text.ParseException;
import javax.swing.RowFilter;

public class BaoCaoThongKe extends javax.swing.JPanel {

    public BaoCaoThongKe() {
        initComponents();
        fillDanhSPBR();
    }

    void fillDanhSPBR() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Tên Sản Phẩm");
            model.addColumn("Ngày Bán");
            model.addColumn("Số Lượng");
            model.addColumn("Kích Thước");
            model.addColumn("Tổng Tiền");

            double totalTongTien = 0; // Biến lưu trữ tổng tiền
            String sql = "SELECT dbo.HoaDon.NgayTao, dbo.SanPham.TenSP, sum(dbo.HoaDonChiTiet.SoLuong) as soluong, sum (dbo.HoaDonChiTiet.ThanhTien) as thanhtien, dbo.HoaDonChiTiet.KichThuoc\n"
                    + "FROM     dbo.HoaDon INNER JOIN\n"
                    + " dbo.HoaDonChiTiet ON dbo.HoaDon.MaHD = dbo.HoaDonChiTiet.MaHD INNER JOIN\n"
                    + " dbo.SanPham ON dbo.HoaDonChiTiet.MaSP = dbo.SanPham.MaSP \n"
                    + "	group by dbo.HoaDon.NgayTao, dbo.SanPham.TenSP, soluong,  thanhtien, dbo.HoaDonChiTiet.KichThuoc  ";
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("TenSP"),
                    XDate.toString(rs.getDate("NgayTao"), "dd-MM-yyyy"),
                    rs.getInt("SoLuong"),
                    rs.getString("KichThuoc"),
                    rs.getFloat("ThanhTien")
                });
                double tien = rs.getDouble("ThanhTien");
                totalTongTien += tien;
            }
            tblRevenue.setModel(model);
            lbTong.setText(XDate.DinhDangTien(TinhTien()) + "VNĐ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double TinhTien() {
        double tongTien = 0;
        for (int i = 0; i < tblRevenue.getRowCount(); i++) {
            tongTien += Float.parseFloat(tblRevenue.getValueAt(i, 4).toString());
        }
        return tongTien;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRevenue = new com.raven.suportSwing.TableColumn();
        scrollBarCustom1 = new com.raven.suportSwing.ScrollBarCustom();
        jLabel6 = new javax.swing.JLabel();
        lbTong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jdcTuNgay = new com.toedter.calendar.JDateChooser();
        jdcDenNgay = new com.toedter.calendar.JDateChooser();
        btnSreach = new com.raven.suportSwing.MyButton();
        btnLoad = new com.raven.suportSwing.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("THỐNG KÊ DOANH THU");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tblRevenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Ngày bán", "Số lượng", "Kích thước", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRevenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRevenueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRevenue);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setText("Tổng Doanh Thu:");

        lbTong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTong.setText("0đ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbTong))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Đến Ngày:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Từ Ngày:");

        btnSreach.setText("Tìm");
        btnSreach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSreach.setRadius(20);
        btnSreach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSreachActionPerformed(evt);
            }
        });

        btnLoad.setText("Tải lại bảng");
        btnLoad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLoad.setRadius(20);
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSreach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jdcTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(429, 429, 429)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(569, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblRevenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRevenueMouseClicked

    }//GEN-LAST:event_tblRevenueMouseClicked

    private void btnSreachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSreachActionPerformed
        // TODO add your handling code here:
        Date tuNgay = jdcTuNgay.getDate();
        Date denNgay = jdcDenNgay.getDate();
        filterByDate(tuNgay, denNgay);
    }//GEN-LAST:event_btnSreachActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        fillDanhSPBR();    
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnLoad;
    private com.raven.suportSwing.MyButton btnSreach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdcDenNgay;
    private com.toedter.calendar.JDateChooser jdcTuNgay;
    private javax.swing.JLabel lbTong;
    private com.raven.suportSwing.ScrollBarCustom scrollBarCustom1;
    private com.raven.suportSwing.TableColumn tblRevenue;
    // End of variables declaration//GEN-END:variables

    private void filterByDate(Date tuNgay, Date denNgay) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblRevenue.getModel());
        tblRevenue.setRowSorter(sorter);

        RowFilter<TableModel, Integer> dateFilter = new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String ngayBanStr = tblRevenue.getValueAt(entry.getIdentifier(), 1).toString();
                try {
                    Date ngayBan = sdf.parse(ngayBanStr);
                    return ngayBan.after(tuNgay) && ngayBan.before(denNgay);

                } catch (ParseException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
        sorter.setRowFilter(dateFilter);
        lbTong.setText(XDate.DinhDangTien(TinhTien()) + "VNĐ");
    }

}