package com.QiFeng_Milktea.bill;

import com.QiFeng_Milktea.dao.BillDAO;
import com.QiFeng_Milktea.dao.SanPhamDAO;
import com.QiFeng_Milktea.entity.HoaDon;
import com.QiFeng_Milktea.entity.HoaDonChiTiet;
import com.QiFeng_Milktea.entity.SanPham;
import com.QiFeng_Milktea.entity.XuatBill;
import com.QiFeng_Milktea.utils.XDate;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class XuatHoaDon extends javax.swing.JFrame {

    SanPhamDAO spdao = new SanPhamDAO();

    public XuatHoaDon() {
        initComponents();
        setLocationRelativeTo(this);
        XuatHoaDon(2);

    }

    public void XuatHoaDon(int MaHD) {
//        int maHD = 17;
        BillDAO dao = new BillDAO(); // Khởi tạo đối tượng BillDAO
        List<XuatBill> list = dao.SelectListByMaHD(MaHD); // Lấy hóa đơn từ CSDL
        for (XuatBill bill : list) {
            String html = "<html>";
//            html += " <img src='logo_trasua.png' alt='' width='250' height='250'>";
            html += "<h2 style='text-align: center;'>QiFeng_Milktea</h2>";
            html += "<p style='font-weight: normal;'>ĐC: 266 Đường 30/4, phường Hưng Lợi, quận Ninh Kiều, TP.Cần Thơ<br></p>";
            html += "<p style='font-weight: normal;'>SĐT: 0374 989 264<br></p>";
            //thông tin đơn
//        html += "<table style='font-weight: normal;'>";
            html += "<tr>";
            html += "<tr>";
            html += "<th style='font-weight: left;'>Mã Hoá Đơn:</th>";
            html += "<td >" + bill.getSoHoaDon() + "</td>";
            html += "<th style='margin-left: -30px; font-weight: normal;'>Tên khách hàng:</th>";
            html += "<td>" + bill.getTenKH() + "</td>";
//        html += "<tr>";
            html += "<tr>";
            html += "<th style='font-weight: normal;'>Ngày tạo:</th>";
            html += "<td>" + XDate.toString(bill.getNgaytao(), "dd-MM-yyy") + "</td>";
            html += "<th style='margin-left: 20px; font-weight: normal;'>Số điện Thoại:</th>";
            html += "<td>" + bill.getSoDTKH() + "</td>";
            html += "</tr>";
            html += "<th style='font-weight: normal;'>Nhân viên:</th>";
            html += "<td>" + bill.getTenNV() + "</td>";
//        html += "<p style='font-weight: normal;'>Nhân Viên: " + hd.getTenNV() + "</p>";
            html += "</table>";

            //chi tiết đơn
            html += "<br>";
            html += "<div style='text-align: center;'>THÔNG TIN HOÁ ĐƠN</div><br/>";
            html += "<div style='text-align: center;font-weight: normal;'>- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - </div><br/>";
            html += "<div style='text-align: center;'>";
            html += "<table style='max-width: 50%;'>";
            html += "<tr>"
                    + "<th style='font-weight: normal;'>Tên Sản Phẩm</th>"
                    + "<th style='font-weight: normal;'>Số lượng</th>"
                    + "<th style='font-weight: normal;'>Kích thước</th>"
                    + "<th style='font-weight: normal;'>Đơn Giá</th>"
                    + "<th style='font-weight: normal;'>Thành Tiền</th>"
                    + "</tr>";
            //dùng để tạo vòng lặp xuất nhìu sản phẩm
            for (HoaDonChiTiet item : dao.getChiTietHoaDonList(MaHD)) {
                SanPham sp = spdao.SelectbyID(item.getMaSP());
                html += "<tr>";
                html += "<td style='text-align:left;font-weight: normal;'>" + sp.getTenSP() + "</td>";
                html += "<td style='text-align:center;font-weight: normal;'>" + item.getSoLuong() + "</td>";
                html += "<td style='text-align:center;font-weight: normal;'>" + item.getKichThuoc() + "</td>";
                html += "<td style='text-align:center;font-weight: normal;'>" + XDate.DinhDangTien(item.getDonGia()) + "</td>";
                html += "<td style='text-align:center;font-weight: normal;'>" + XDate.DinhDangTien(item.getThanhTien()) + "</td>";
                html += "</tr>";
            }
            html += "</table>";
            html += "</div>";
            ////add tong bill
            html += "<div style='text-align: center;font-weight: normal;'>- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - </div><br/>";
            html += "Tổng Tiền : " + XDate.DinhDangTien(bill.getTongTien()) + " VNĐ" + "<br>";
            html += "<table style='font-weight: normal;'>";
            html += "</table>";
            html += "<div style='text-align: center;font-weight: normal;'>- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - </div><br/>";
            html += "<h7 style='text-align: center;'>CHÚC BẠN DÙNG NGON MIỆNG VÀ CÀM ƠN BẠN ĐÃ ỦNG HỘ!<br></h7> ";
            html += "</html> ";
            lblhoadon.setText(html);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblhoadon = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();
        btnInHD = new javax.swing.JButton();
        txtForm = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhoadon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblhoadon.setText("jLabel1");
        lblhoadon.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblhoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 400, 470));

        btnHuy.setText("HUỶ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        getContentPane().add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 590, 149, -1));

        btnInHD.setText("IN HOÁ ĐƠN");
        btnInHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHDActionPerformed(evt);
            }
        });
        getContentPane().add(btnInHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 149, -1));

        txtForm.setBackground(new java.awt.Color(255, 255, 255));
        txtForm.setOpaque(true);
        getContentPane().add(txtForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnInHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHDActionPerformed
        FilePrintClicked(lblhoadon);
    }//GEN-LAST:event_btnInHDActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                XuatHoaDon xuatHD = new XuatHoaDon();
                xuatHD.setVisible(true);
            }
        });
    }

    public void FilePrintClicked(JLabel label) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics g, PageFormat format, int pagenum) throws PrinterException {
                if (pagenum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2d = (Graphics2D) g;
                g2d.translate(format.getImageableX(), format.getImageableY());
                float pageWidth = (float) format.getImageableWidth();
                float pageHeight = (float) format.getImageableHeight();
                float imageHeight = (float) label.getHeight();
                float imageWidth = (float) label.getWidth();
                float scaleFactor = Math.min((float) pageWidth / (float) imageWidth, (float) pageHeight / (float) imageHeight);
                int scaledWidth = (int) (((float) imageWidth) * scaleFactor);
                int scaledHeight = (int) (((float) imageHeight) * scaleFactor);
                // Tạo BufferedImage với chế độ màu TYPE_INT_ARGB
                BufferedImage image = new BufferedImage(label.getWidth(), label.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D gg = image.createGraphics();
                // Vẽ JLabel lên BufferedImage
                label.paint(gg);
                // Vẽ BufferedImage lên trang in
                g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = job.printDialog();
        if (returningResult) {
            try {
                job.print();
                dispose();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(this, "Không Thể In!");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnInHD;
    private javax.swing.JLabel lblhoadon;
    private javax.swing.JLabel txtForm;
    // End of variables declaration//GEN-END:variables
}
