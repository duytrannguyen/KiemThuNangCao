
package com.QiFeng_Milktea.ul;

import com.QiFeng_Milktea.dao.NhanVienDAO;
import com.QiFeng_Milktea.Validate.Validate;
import com.QiFeng_Milktea.entity.NhanVien;
import com.QiFeng_Milktea.utils.Auth;
import com.QiFeng_Milktea.utils.MsgBox;
import com.QiFeng_Milktea.utils.XDate;


public class ThongTinCaNhan extends javax.swing.JPanel {

    public ThongTinCaNhan() {
        initComponents();
        setOpaque(false);
        txtCode.setEditable(false);     
        txtRole.setEditable(false);
        txtPhoneNumber.setEditable(false);
        txtEmail.setEditable(false);
        edit();
    }
    NhanVienDAO mDao = new NhanVienDAO();

    public boolean checkEmail(String acc) {
        for (int i = 0; i < mDao.selectAll().size(); i++) {
            if (mDao.selectAll().get(i).getEmail().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPhoneNumber(String acc) {
        for (int i = 0; i < mDao.selectAll().size(); i++) {
            if (mDao.selectAll().get(i).getSoDT().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public void setForm(NhanVien m) {
     
        txtCode.setText(m.getMaNV()+ "");
        txtDoB.setText(XDate.toString(m.getNgaySinh(), "dd-MM-yyyy"));
        txtName.setText(m.getTenNV());
        txtPhoneNumber.setText(m.getSoDT());
        txtRole.setText(m.isVaiTro() ? "Trưởng phòng" : "Nhân viên");
        radiMale.setSelected(m.isGioiTinh());
        radiFeMale.setSelected(!m.isGioiTinh());
        txtEmail.setText(m.getEmail());
    }

    NhanVien getForm() {
        NhanVien m = new NhanVien();
        m.setNgaySinh(XDate.toDate(txtDoB.getText(), "dd-MM-yyyy"));
        m.setEmail(txtEmail.getText());
        m.setGioiTinh(radiMale.isSelected());
        m.setTenNV(txtName.getText());
        m.setSoDT(txtPhoneNumber.getText());
        return m;
    }

    public void edit() {
        String MaNV = Auth.user.getMaNV();
        NhanVien m = mDao.SelectbyID(MaNV);
        setForm(m);
    }

    public void update() {

        try {
            if (!Validate.checkEmpty(lblName, txtName, "Không bỏ trống họ tên")) {
                return;
            } else if (!Validate.checkEmpty(lblDoB, txtDoB, "Không bỏ trống ngày sinh")) {
                return;
            } else {
                NhanVien m = getForm();
                String MaNV = Auth.user.getMaNV();
                m.setMaNV(MaNV);
                mDao.updateTT(m);
                MsgBox.alert(this, "Cập nhật Thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new com.raven.suportSwing.TextField();
        txtPhoneNumber = new com.raven.suportSwing.TextField();
        txtDoB = new com.raven.suportSwing.TextField();
        txtRole = new com.raven.suportSwing.TextField();
        txtName = new com.raven.suportSwing.TextField();
        radiMale = new com.raven.suportSwing.RadioButtonCustom();
        radiFeMale = new com.raven.suportSwing.RadioButtonCustom();
        jLabel2 = new javax.swing.JLabel();
        btnAddEmployee = new com.raven.suportSwing.MyButton();
        txtEmail = new com.raven.suportSwing.TextField();
        lblName = new javax.swing.JLabel();
        lblDoB = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();

        dateChooser1.setTextRefernce(txtDoB);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("THÔNG TIN CÁ NHÂN");

        txtCode.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCode.setLabelText("Mã Nhân Viên");

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPhoneNumber.setLabelText("Số điện thoại");

        txtDoB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtDoB.setLabelText("Ngày sinh");

        txtRole.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtRole.setLabelText("Chức vụ");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtName.setLabelText("Họ Tên");

        buttonGroup1.add(radiMale);
        radiMale.setText("Nam");
        radiMale.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        buttonGroup1.add(radiFeMale);
        radiFeMale.setText("Nữ");
        radiFeMale.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Giới tính");

        btnAddEmployee.setText("Sửa");
        btnAddEmployee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddEmployee.setRadius(10);
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEmail.setLabelText("Email");

        lblName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 0, 0));

        lblDoB.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblDoB.setForeground(new java.awt.Color(255, 0, 0));

        lblPhoneNumber.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblPhoneNumber.setForeground(new java.awt.Color(255, 0, 0));

        lblEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addGap(300, 300, 300))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(250, 250, 250))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(200, 200, 200)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDoB, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(lblPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(radiMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(radiFeMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(radiMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radiFeMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(txtDoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed

        update();
    }//GEN-LAST:event_btnAddEmployeeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnAddEmployee;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDoB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoneNumber;
    private com.raven.suportSwing.RadioButtonCustom radiFeMale;
    private com.raven.suportSwing.RadioButtonCustom radiMale;
    private com.raven.suportSwing.TextField txtCode;
    private com.raven.suportSwing.TextField txtDoB;
    private com.raven.suportSwing.TextField txtEmail;
    private com.raven.suportSwing.TextField txtName;
    private com.raven.suportSwing.TextField txtPhoneNumber;
    private com.raven.suportSwing.TextField txtRole;
    // End of variables declaration//GEN-END:variables
}
