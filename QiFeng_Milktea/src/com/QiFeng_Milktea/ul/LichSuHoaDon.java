package com.QiFeng_Milktea.ul;

import com.QiFeng_Milktea.bill.XuatHoaDon;
import com.QiFeng_Milktea.dao.BillDAO;
import com.QiFeng_Milktea.dao.HoaDonCTDAO;
import com.QiFeng_Milktea.dao.HoaDonDAO;
import com.QiFeng_Milktea.dao.SanPhamDAO;
import com.QiFeng_Milktea.entity.HoaDonChiTiet;
import com.QiFeng_Milktea.entity.SanPham;
import com.QiFeng_Milktea.entity.XuatBill;
import com.QiFeng_Milktea.utils.JdbcHelper;
import com.QiFeng_Milktea.utils.MsgBox;
import com.QiFeng_Milktea.utils.XDate;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class LichSuHoaDon extends javax.swing.JPanel {

    int row = -1;
    HoaDonCTDAO hdct = new HoaDonCTDAO();
    SanPhamDAO spdao = new SanPhamDAO();
    BillDAO bdao = new BillDAO();
    HoaDonDAO hddao = new HoaDonDAO();

    public LichSuHoaDon() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngGioiTinh = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        scrollBarCustom1 = new com.raven.suportSwing.ScrollBarCustom();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new com.raven.suportSwing.TextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdcNgayDau = new com.toedter.calendar.JDateChooser();
        jdcNgayCuoi = new com.toedter.calendar.JDateChooser();
        btnTimKiem = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new com.raven.suportSwing.TableColumn();
        btnLoad = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnClear = new com.raven.suportSwing.MyButton();
        btnInHD = new com.raven.suportSwing.MyButton();
        lblAdress = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        scrollBarCustom2 = new com.raven.suportSwing.ScrollBarCustom();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtNgayThanhToan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNV = new javax.swing.JTextField();
        txtKH = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Tìm kiếm");

        txtTimKiem.setLabelText("Tìm theo mã hóa đơn");
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel3.setText("Từ:");

        jLabel4.setText("Đến:");

        jdcNgayCuoi.setDoubleBuffered(false);

        btnTimKiem.setText("Tìm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jButton2.setText("Lọc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Số hóa đơn", "Tên Sản Phẩm", "Ngày thanh toán", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        btnLoad.setText("Load");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jdcNgayDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdcNgayCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem)
                        .addComponent(btnLoad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addComponent(jdcNgayDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jdcNgayCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Chi tiết sản phẩm ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btnClear.setLabel("Xóa form");
        btnClear.setRadius(20);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnInHD.setText("In hóa đơn ");
        btnInHD.setRadius(20);
        btnInHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHDActionPerformed(evt);
            }
        });

        lblAdress.setForeground(new java.awt.Color(225, 0, 0));

        lblPhoneNumber.setForeground(new java.awt.Color(225, 0, 0));

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Kích thước", "Giá tiền", "Số Lượng", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCTSP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollBarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollBarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(lblPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Lịch sử thanh toán");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        jLabel5.setText("Ngày thanh toán:");

        jLabel6.setText("Tên khách hàng");

        txtMaHD.setEnabled(false);

        txtNgayThanhToan.setEnabled(false);

        jLabel7.setText("Nhân viên:");

        jLabel8.setText("Mã hóa đơn:");

        txtNV.setEnabled(false);

        txtKH.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayThanhToan)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNV))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clean();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnInHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHDActionPerformed
        // TODO add your handling code here:
        int SoHD = (int) tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 2);
        XuatHoaDon xhd = new XuatHoaDon();
        xhd.XuatHoaDon(SoHD);
        xhd.setVisible(true);
    }//GEN-LAST:event_btnInHDActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        if (evt.getClickCount() == 1) {
            this.row = tblHoaDon.getSelectedRow();
//            this.edit();
            int SoHD = (int) tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 2);
            fillSP(SoHD);
        }
//        txtMaSP.setEditable(false);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Date tuNgay = jdcNgayDau.getDate();
        Date denNgay = jdcNgayDau.getDate();
        filterByDate(tuNgay, denNgay);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String soHoa = txtTimKiem.getText();
        filTimKiem(soHoa);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        txtTimKiem.setText("");
        fillTable();
        
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnClear;
    private com.raven.suportSwing.MyButton btnInHD;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup btngGioiTinh;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcNgayCuoi;
    private com.toedter.calendar.JDateChooser jdcNgayDau;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblPhoneNumber;
    private com.raven.suportSwing.ScrollBarCustom scrollBarCustom1;
    private com.raven.suportSwing.ScrollBarCustom scrollBarCustom2;
    private javax.swing.JTable tblCTSP;
    private com.raven.suportSwing.TableColumn tblHoaDon;
    private javax.swing.JTextField txtKH;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNV;
    private javax.swing.JTextField txtNgayThanhToan;
    private com.raven.suportSwing.TextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
void init() {
        fillTable();
        updateStaus();
//        fillSP("");

    }
//SanPhamDAO spdao = new SanPhamDAO();

    void fillTable() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Số thứ tự");
            model.addColumn("Số hóa đơn");
            model.addColumn("Mã hóa đơn");
            // model.addColumn("Tên sản phẩm");
            model.addColumn("Ngày thanh toán");
            model.addColumn("Số lượng");
            model.addColumn("Tổng tiền");

            String sql = "SELECT ROW_NUMBER() OVER (ORDER BY HoaDon.SoHoaDon) AS 'Số thứ tự', HoaDon.SoHoaDon, HoaDon.MaHD, HoaDon.NgayTao, SUM(HoaDonChiTiet.SoLuong) AS SoLuong, HoaDon.TongTien\n"
                    + "FROM HoaDon\n"
                    + "INNER JOIN HoaDonChiTiet ON HoaDon.MaHD = HoaDonChiTiet.MaHD\n"
                    + "INNER JOIN SanPham ON HoaDonChiTiet.MaSP = SanPham.MaSP\n"
                    + "GROUP BY HoaDon.SoHoaDon, HoaDon.MaHD, HoaDon.NgayTao, HoaDon.TongTien";

            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("Số thứ tự"),
                    rs.getString("SoHoaDon"),
                    rs.getInt("MaHD"),
                    // rs.getString("TenSP"),
                    XDate.toString(rs.getDate("NgayTao"), "dd-MM-yyyy"),
                    rs.getInt("SoLuong"),
                    XDate.DinhDangTien(rs.getFloat("TongTien"))
                });
            }
            tblHoaDon.setModel(model);
        } catch (Exception e) {
            // Handle the exception according to your requirements
        }
    }

    void fillSP(int SoHD) {
        DefaultTableModel model = (DefaultTableModel) tblCTSP.getModel();
        model.setRowCount(0); // Clear the table model before populating new data
        try {
            BillDAO dao = new BillDAO(); // Khởi tạo đối tượng BillDAO
            List<XuatBill> list = dao.SelectListByMaHD(SoHD); // Lấy hóa đơn từ CSDL
            for (XuatBill bill : list) {
                for (HoaDonChiTiet item : dao.getChiTietHoaDonList(SoHD)) {
                    SanPham sp = spdao.SelectbyID(item.getMaSP());
                    Object[] row = {sp.getTenSP(), item.getKichThuoc(), XDate.DinhDangTien(item.getDonGia()), item.getSoLuong(), XDate.DinhDangTien(item.getThanhTien())};
                    model.addRow(row);
                    txtMaHD.setText(bill.getSoHoaDon());
                    txtNV.setText(bill.getTenNV());
                    txtKH.setText(bill.getTenKH());
                    txtNgayThanhToan.setText(XDate.toString(bill.getNgaytao(), "dd-MM-yyyy"));
                }
            }
        } catch (Exception e) {
            // Log the exception and display a specific error message
            e.printStackTrace(); // Log the exception for troubleshooting
            MsgBox.alert(this, "Error occurred while retrieving data: " + e.getMessage());
        }
    }

    void clean() {
        DefaultTableModel model = (DefaultTableModel) tblCTSP.getModel();
        model.setRowCount(0);
        txtMaHD.setText("");
        txtNV.setText("");
        txtKH.setText("");
        txtNgayThanhToan.setText("");

    }

    private void filterByDate(Date tuNgay, Date denNgay) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  // Use the correct date format for parsing
            String tuNgayStr = sdf.format(tuNgay);
            String denNgayStr = sdf.format(denNgay);

            TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblHoaDon.getModel());
            tblHoaDon.setRowSorter(sorter);

            RowFilter<TableModel, Integer> dateFilter = new RowFilter<TableModel, Integer>() {
                @Override
                public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                    try {
                        String ngayBanStr = tblHoaDon.getValueAt(entry.getIdentifier(), 3).toString();
                        Date ngayBan = sdf.parse(ngayBanStr);
                        return !ngayBan.before(sdf.parse(tuNgayStr)) && !ngayBan.after(sdf.parse(denNgayStr));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return false;  // Return false on parsing errors
                    }
                }
            };
            sorter.setRowFilter(dateFilter);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle the exception according to your requirements
        }
    }

    void updateStaus() {//Cập nhật trạng thái các nút
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblHoaDon.getRowCount() - 1);
        //Trạng thái from

        btnInHD.setEnabled(!edit);
//        btnSua.setEnabled(edit);
//        btnXoa.setEnabled(edit);

    }

   private void filTimKiem(String SoHoaDon) {
    try {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblHoaDon.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> soHoaDonFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
                String soHoaDonStr = entry.getStringValue(1);
                return soHoaDonStr.equals(SoHoaDon);
            }
        };
        sorter.setRowFilter(soHoaDonFilter);
    } catch (Exception ex) {
        ex.printStackTrace();
        // Xử lý ngoại lệ theo nhu cầu cụ thể của bạn
    }
}


}
