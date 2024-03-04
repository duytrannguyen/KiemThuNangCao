package com.QiFeng_Milktea.ul;

import com.QiFeng_Milktea.Validate.labelValidate;
import com.QiFeng_Milktea.dao.NhanVienDAO;
import com.QiFeng_Milktea.entity.NhanVien;
import com.QiFeng_Milktea.utils.Auth;
import com.QiFeng_Milktea.utils.Excel;
import com.QiFeng_Milktea.utils.MsgBox;
import com.QiFeng_Milktea.utils.XDate;
import com.QiFeng_Milktea.utils.XImage;
import com.raven.form.MainForm;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhanVien extends javax.swing.JPanel {

    NhanVienDAO dao = new NhanVienDAO();

    int row = -1;
    JFileChooser filechooser = new JFileChooser();

    public QuanLyNhanVien() {
        initComponents();
        init();
        clearFrom();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien = new com.raven.suportSwing.TableColumn();
        scrollBarCustom1 = new com.raven.suportSwing.ScrollBarCustom();
        jPanel3 = new javax.swing.JPanel();
        txtSoDienThoai = new com.raven.suportSwing.TextField();
        txtTenNhanVien = new com.raven.suportSwing.TextField();
        txtEmail = new com.raven.suportSwing.TextField();
        jLabel3 = new javax.swing.JLabel();
        rdoNu = new com.raven.suportSwing.RadioButtonCustom();
        rdoQuanLy = new com.raven.suportSwing.RadioButtonCustom();
        rdoNhanVien = new com.raven.suportSwing.RadioButtonCustom();
        jLabel4 = new javax.swing.JLabel();
        txtNamSinh = new com.raven.suportSwing.TextField();
        txtMaNhanVien = new com.raven.suportSwing.TextField();
        txtMatKhau = new com.raven.suportSwing.PasswordField();
        btnThem = new com.raven.suportSwing.MyButton();
        lblBirth = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        btnSua = new com.raven.suportSwing.MyButton();
        btnXoa = new com.raven.suportSwing.MyButton();
        panelImage = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        btnMoi = new com.raven.suportSwing.MyButton();
        rdoNam = new com.raven.suportSwing.RadioButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnTimkiem = new com.raven.suportSwing.MyButton();
        btnload = new com.raven.suportSwing.MyButton();
        txtTiemKiem = new com.raven.suportSwing.TextField();
        lblSearch = new javax.swing.JLabel();
        myButton7 = new com.raven.suportSwing.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 1290, 20));
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 110, 70));

        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 40, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Email", "Số Điện thoại", "Giới Tính", "Ngày Sinh", "Chức Vụ", "Hình Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 160, 840, 560));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtSoDienThoai.setLabelText("Điện thoại");
        txtSoDienThoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusGained(evt);
            }
        });

        txtTenNhanVien.setLabelText("Tên   ");
        txtTenNhanVien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenNhanVienFocusGained(evt);
            }
        });

        txtEmail.setLabelText("Email");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
        });

        jLabel3.setText("Giới tính");

        buttonGroup2.add(rdoNu);
        rdoNu.setText("Nữ");

        buttonGroup1.add(rdoQuanLy);
        rdoQuanLy.setText("Quản lý");

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân Viên");

        jLabel4.setText("Vai trò");

        txtNamSinh.setLabelText("Ngày sinh");
        txtNamSinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamSinhFocusGained(evt);
            }
        });

        txtMaNhanVien.setLabelText("Username");
        txtMaNhanVien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaNhanVienFocusGained(evt);
            }
        });

        txtMatKhau.setLabelText("Password");
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
        });

        btnThem.setText("Thêm ");
        btnThem.setRadius(10);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lblBirth.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblBirth.setForeground(new java.awt.Color(255, 51, 51));

        lblName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 51, 51));

        lblPhone.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 51, 51));

        lblEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 51, 51));

        lblUser.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 51, 51));

        lblPass.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblPass.setForeground(new java.awt.Color(255, 51, 51));

        btnSua.setText("Sửa");
        btnSua.setRadius(10);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.setRadius(10);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(javax.swing.BorderFactory.createTitledBorder("Hình Ảnh"));
        panelImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelImageMouseClicked(evt);
            }
        });
        panelImage.setLayout(new java.awt.GridBagLayout());

        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        lblHinhAnh.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });
        panelImage.add(lblHinhAnh, new java.awt.GridBagConstraints());

        btnMoi.setText("Làm mới");
        btnMoi.setRadius(10);
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoNam);
        rdoNam.setText("Nam");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(lblUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51)
                                    .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(rdoQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNamSinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(panelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 510, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nhân Viên");

        btnTimkiem.setText("Tìm");
        btnTimkiem.setRadius(20);
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        btnload.setText("Làm Mới Bảng");
        btnload.setRadius(20);
        btnload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadActionPerformed(evt);
            }
        });

        txtTiemKiem.setLabelText("Tìm theo tên or mã");
        txtTiemKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTiemKiemFocusGained(evt);
            }
        });
        txtTiemKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiemKiemActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 51, 0));

        myButton7.setText("Xuất");
        myButton7.setRadius(20);
        myButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1050, 70));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1305, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked

    }//GEN-LAST:event_jLabel12MouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert1();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        timKiem();

    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadActionPerformed
        fillTable();
    }//GEN-LAST:event_btnloadActionPerformed

    private void txtTiemKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTiemKiemFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiemKiemFocusGained

    private void txtTiemKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiemKiemActionPerformed
        // TODO add your handling code here:
        //        fillSearch();
    }//GEN-LAST:event_txtTiemKiemActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        try {
            excelEmpolyee();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_myButton7ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        this.clearFrom();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblNhanVien.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void panelImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelImageMouseClicked
        if (evt.getClickCount() == 2) {
            this.chonAnh();
        }
    }//GEN-LAST:event_panelImageMouseClicked

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        //        choseImage();
        if (evt.getClickCount() == 2) {
            this.chonAnh();
        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void txtTenNhanVienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenNhanVienFocusGained
        lblName.setText("");
    }//GEN-LAST:event_txtTenNhanVienFocusGained

    private void txtNamSinhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamSinhFocusGained
        lblBirth.setText("");
    }//GEN-LAST:event_txtNamSinhFocusGained

    private void txtMaNhanVienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNhanVienFocusGained
        lblUser.setText("");
    }//GEN-LAST:event_txtMaNhanVienFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        lblEmail.setText("");
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        lblPass.setText("");
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtSoDienThoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusGained
        lblPhone.setText("");
    }//GEN-LAST:event_txtSoDienThoaiFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnMoi;
    private com.raven.suportSwing.MyButton btnSua;
    private com.raven.suportSwing.MyButton btnThem;
    private com.raven.suportSwing.MyButton btnTimkiem;
    private com.raven.suportSwing.MyButton btnXoa;
    private com.raven.suportSwing.MyButton btnload;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBirth;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblUser;
    private com.raven.suportSwing.MyButton myButton7;
    private javax.swing.JPanel panelImage;
    private com.raven.suportSwing.RadioButtonCustom rdoNam;
    private com.raven.suportSwing.RadioButtonCustom rdoNhanVien;
    private com.raven.suportSwing.RadioButtonCustom rdoNu;
    private com.raven.suportSwing.RadioButtonCustom rdoQuanLy;
    private com.raven.suportSwing.ScrollBarCustom scrollBarCustom1;
    private com.raven.suportSwing.TableColumn tblNhanVien;
    private com.raven.suportSwing.TextField txtEmail;
    private com.raven.suportSwing.TextField txtMaNhanVien;
    private com.raven.suportSwing.PasswordField txtMatKhau;
    private com.raven.suportSwing.TextField txtNamSinh;
    private com.raven.suportSwing.TextField txtSoDienThoai;
    private com.raven.suportSwing.TextField txtTenNhanVien;
    private com.raven.suportSwing.TextField txtTiemKiem;
    // End of variables declaration//GEN-END:variables
void init() {
        fillTable();
        updateStaus();
    }

    public void insert1() {
        try {
            if (labelValidate.checkEmpty(lblName, txtTenNhanVien, "Tên chưa nhập!!!") == false) {
                return;
            } else if (labelValidate.checkEmpty(lblBirth, txtNamSinh, "Ngày sinh chưa nhập!!!") == false) {
                return;
            } else if (checkDate() == false) {
                return;
            } else if (labelValidate.checkEmpty(lblUser, txtMaNhanVien, "Tài khoản chưa nhập!!!") == false) {
                return;
            } else if (checkUser(txtMaNhanVien.getText()) == true) {
                MsgBox.labelAlert(lblUser, txtMaNhanVien, "Trùng user");
                return;
            } else if (labelValidate.checkEmail(lblEmail, txtEmail, "") == false) {
                return;
            } else if (checkEmail(txtEmail.getText()) == true) {
                MsgBox.labelAlert(lblEmail, txtEmail, "Trùng email");
                return;
            } else if (labelValidate.checkPass(lblPass, txtMatKhau, "") == false) {
                return;
            } else if (labelValidate.checkPhoneNumber(lblPhone, txtSoDienThoai, "") == false) {
                return;
            } else if (checkPhoneNumber(txtSoDienThoai.getText()) == true) {
                MsgBox.labelAlert(lblPhone, txtSoDienThoai, "Trùng số điện thoại");
                return;
            } else {
                NhanVien nv = getFrom();
                dao.insert(nv);
                this.fillTable();
                this.clearFrom();
                MsgBox.alert(this, "Thêm mới thành công..^^..");
                this.fillTable();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.warring(this, "Thêm mới thất bại!!");
        }
    }

    public boolean checkDate() {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(txtNamSinh.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int years = Period.between(date, today).getYears();
        if (years < 18) {
            MsgBox.labelAlert(lblBirth, txtNamSinh, "Trên 18 tuổi");
            System.out.println(years);
            return false;
        }
        System.out.println(years);
        return true;
    }

    NhanVienDAO emDao = new NhanVienDAO();

    public boolean checkUser(String acc) {
        for (int i = 0; i < emDao.selectAll().size(); i++) {
            if (emDao.selectAll().get(i).getMaNV().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEmail(String acc) {
        for (int i = 0; i < emDao.selectAll().size(); i++) {
            if (emDao.selectAll().get(i).getEmail().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPhoneNumber(String acc) {
        for (int i = 0; i < emDao.selectAll().size(); i++) {
            if (emDao.selectAll().get(i).getSoDT().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    void update() {
        NhanVien nv = getFrom();
        String manv = new String(txtMaNhanVien.getText().trim());
        if (!manv.equals(nv.getMaNV())) {
            MsgBox.alert(this, "Mã nhân viên không tồn tại!");
        } else {
            try {
                if (labelValidate.checkEmpty(lblName, txtTenNhanVien, "Tên chưa nhập!!!") == false) {
                    return;
                } else if (labelValidate.checkEmpty(lblBirth, txtNamSinh, "Ngày sinh chưa nhập!!!") == false) {
                    return;
                } else if (checkDate() == false) {
                    return;
                } else if (labelValidate.checkEmpty(lblUser, txtMaNhanVien, "Tài khoản chưa nhập!!!") == false) {
                    return;
                } else if (labelValidate.checkUser(lblUser, txtMaNhanVien, "Mã nhân viên không tồn tại!!!") == false) {
                    return;
                } else if (labelValidate.checkEmail(lblEmail, txtEmail, "") == false) {
                    return;
                } else if (labelValidate.checkPass(lblPass, txtMatKhau, "") == false) {
                    return;
                } else if (labelValidate.checkPhoneNumber(lblPhone, txtSoDienThoai, "") == false) {
                    return;
                } else {

                    dao.update(nv);
                    this.fillTable();
                    MsgBox.alert(this, "Cập nhật thành công!");
                }
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại!");
            }
        }

    }

    void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa nhân viên!");
        } else {
            String manv = txtMaNhanVien.getText();
            if (manv.equals(Auth.user.getMaNV())) {
                MsgBox.alert(this, "Bạn không được xóa chính bạn!");
            } else if (MsgBox.cobfirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
                try {
                    dao.delete(manv);
                    this.fillTable();
                    this.clearFrom();
                    MsgBox.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xóa thất bại!");
                }
            }
        }
    }

    void clearFrom() {

        txtTenNhanVien.setText("");
        txtMaNhanVien.setText("");
        txtEmail.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        txtNamSinh.setText("");
        rdoNam.setSelected(true);
        rdoNhanVien.setSelected(true);
        txtMatKhau.setText("");

        lblHinhAnh.setText("");
        this.row = -1;
//        btnThem.setEnabled(true);

        this.updateStaus();
    }

    void edit() {
        String manv = (String) tblNhanVien.getValueAt(this.row, 0);
        NhanVien nv = dao.SelectbyID(manv);
        this.setFrom(nv);
        this.updateStaus();
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = dao.selectAll();//Dọc dữ liệu từ CSDL
            for (NhanVien nv : list) {
                Object[] row = {nv.getMaNV(), nv.getTenNV(), nv.getEmail(), nv.getSoDT(), nv.isGioiTinh() ? "Nam" : "Nữ", XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"), nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên", nv.getHinhAnh()};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "lỗi try vấn dữ liệu");
        }
    }

    void fillNhanVien() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            String key = txtTiemKiem.getText();
            List<NhanVien> list = dao.selectByKyword(key);//Dọc dữ liệu từ CSDL
            for (NhanVien nv : list) {
                Object[] row = {nv.getMaNV(), nv.getTenNV(), nv.getEmail(), nv.getSoDT(), nv.isGioiTinh() ? "Nam" : "Nữ", XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"), nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên", nv.getHinhAnh()};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "lỗi try vấn dữ liệu");
        }
    }

    void setFrom(NhanVien nv) {
        txtMaNhanVien.setText(nv.getMaNV());
        txtTenNhanVien.setText(nv.getTenNV());
        txtEmail.setText(nv.getEmail());
        txtSoDienThoai.setText(nv.getSoDT() + "");
        rdoNam.setSelected(nv.isGioiTinh());
        rdoNu.setSelected(!nv.isGioiTinh());
        txtMatKhau.setText(nv.getMatKhau());
        // Xử lý ngày sinh
        if (nv.getNgaySinh() != null) {
            txtNamSinh.setText(XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"));
        } else {
            txtNamSinh.setText(""); // Hoặc xử lý theo cách khác tùy theo yêu cầu
        }

        rdoQuanLy.setSelected(nv.isVaiTro());
        rdoNhanVien.setSelected(!nv.isVaiTro());

        if (nv.getHinhAnh() != null) {
            ImageIcon imageIcon = XImage.read(nv.getHinhAnh());
            Image image = imageIcon.getImage();
            lblHinhAnh.setToolTipText(nv.getHinhAnh());
            //set kích thước ảnh
            int width = 170; // Đặt chiều rộng mong muốn
            int height = 150; // Đặt chiều cao mong muốn
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            imageIcon.setImage(resizedImage);

            lblHinhAnh.setIcon(imageIcon);
        } else {
            lblHinhAnh.setText("NO AVATAR"); // Đã sửa "AVARTA" thành "AVATAR"
        }
    }

    NhanVien getFrom() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNhanVien.getText());
        nv.setTenNV(txtTenNhanVien.getText());
        nv.setEmail(txtEmail.getText());
        nv.setSoDT(txtSoDienThoai.getText());
        nv.setGioiTinh(rdoNam.isSelected());
        nv.setNgaySinh(XDate.toDate(txtNamSinh.getText(), "dd/MM/yyyy"));
        nv.setVaiTro(rdoQuanLy.isSelected());
        nv.setMatKhau(new String(txtMatKhau.getPassword()));

        // Xử lý hình ảnh
        if (lblHinhAnh.getToolTipText() != null && !lblHinhAnh.getToolTipText().isEmpty()) {
            nv.setHinhAnh(lblHinhAnh.getToolTipText());
        } else {
            nv.setHinhAnh("NO AVATAR"); // Đã sửa "AVARTA" thành "AVATAR"
        }

        return nv;
    }

    void updateStaus() {//Cập nhật trạng thái các nút
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblNhanVien.getRowCount() - 1);
        //Trạng thái from
//        txtMaNV.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);

    }

    private void timKiem() {
        this.fillNhanVien();
        this.clearFrom();
        this.row = -1;
        updateStaus();
    }

    void chonAnh() {
        if (filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = filechooser.getSelectedFile();
                XImage.save(file);
                ImageIcon icon = XImage.read(file.getName());
                Image img = ImageIO.read(file);
                lblHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(170, 110, Image.SCALE_DEFAULT)));
                lblHinhAnh.setToolTipText(file.getName());
//                System.out.println(file.getName());
            } catch (Exception e) {
                MsgBox.alert(this, "Lỗi khi chọn ảnh!");
            }
        }
    }

    public void excelEmpolyee() throws IOException {
        Excel.outExcel((DefaultTableModel) tblNhanVien.getModel());
    }

    boolean check() {
        NhanVien nv = getFrom();
        String maNV = txtMaNhanVien.getText();
        String tenNV = txtTenNhanVien.getText();
        String soDT = txtSoDienThoai.getText();
        String email = txtEmail.getText();
        String ngaySinh = txtNamSinh.getText();
        String matKhau = txtMatKhau.getPassword().toString();

        if (tenNV.trim().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập tên viên!");
            return false;
        }
        if (ngaySinh == null || ngaySinh.trim().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập ngày sinh!");
            return false;
        }
        try {
            XDate.toDate(ngaySinh, "dd/MM/yyyy");
        } catch (Exception e) {
            MsgBox.alert(this, "Ngày sinh không đúng định dạng 'dd/MM/yyyy'");
            return false;
        }

        if (maNV.trim().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập mã nhân viên!");
            return false;
        }
        if (dao.SelectbyID(nv.getMaNV()) != null) {
            MsgBox.alert(this, "Mã nhân viên đã tồn tại!");
        }
        if (email.trim().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập  email!");
            return false;
        }

        if (!email.matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            MsgBox.alert(this, "Email không đúng định dạng!");
            return false;
        }

        if (matKhau.trim().length() < 8) {
            MsgBox.alert(this, "Mật khẩu phải lớn hơn 8 ký tự!");
            return false;
        }
//        else if (!matKhau.matches("^(?=.*[A-Z])(?=.*[^A-Za-z0-9])(?=.{8,})$")) {
//            MsgBox.alert(this, "Mật khẩu phải có ít nhất 1 ký tự hoa và 1 ký tự đặc biệt và có độ dài ít nhất 8 ký tự!");
//            return false;
//        }

        if (soDT.trim().length() == 0) {
            MsgBox.alert(this, "vui lòng nhập số điện thoại!");
            return false;
        }

        if (!soDT.matches("^(09|03|02|06|07)+([0-9]{8})")) {
            MsgBox.alert(this, "SĐT không đúng định dạng!");
            return false;
        }

        return true;

    }

    boolean checkUpdate() {
        NhanVien nv = getFrom();
        String maNV = txtMaNhanVien.getText();
        String tenNV = txtTenNhanVien.getText();
        String soDT = txtSoDienThoai.getText();
        String email = txtEmail.getText();
        String ngaySinh = txtNamSinh.getText();

        // Thêm điều kiện kiểm tra mã nhân viên
        if (maNV.trim().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập mã nhân viên!");
            return false;
        }
        // Thêm điều kiện kiểm tra tên nhân viên
        if (tenNV.trim().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập tên nhân viên!");
            return false;
        }

        // Thêm điều kiện kiểm tra số điện thoại
        if (soDT.trim().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập số điện thoại!");
            return false;
        }

        // Thêm điều kiện kiểm tra email
        if (email.trim().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập email!");
            return false;
        }

        // Thêm điều kiện kiểm tra ngày sinh
        if (ngaySinh == null || ngaySinh.trim().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập ngày sinh!");
            return false;
        }

        // Thêm điều kiện kiểm tra định dạng ngày sinh
        try {
            XDate.toDate(ngaySinh, "dd/MM/yyyy");
        } catch (Exception e) {
            MsgBox.alert(this, "Ngày sinh không đúng định dạng 'dd/MM/yyyy'");
            return false;
        }

        // Thêm điều kiện kiểm tra định dạng email
        if (!email.matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            MsgBox.alert(this, "Email không đúng định dạng!");
            return false;
        }

        // Thêm điều kiện kiểm tra định dạng số điện thoại
        if (!soDT.matches("^(09|03|02|06|07)+([0-9]{8})")) {
            MsgBox.alert(this, "Số điện thoại không đúng định dạng!");
            return false;
        }

        return true;
    }

}
