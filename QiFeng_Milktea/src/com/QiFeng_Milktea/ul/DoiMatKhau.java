package com.QiFeng_Milktea.ul;

import com.QiFeng_Milktea.Validate.Validate;
import com.QiFeng_Milktea.Validate.labelValidate;
import java.awt.event.ActionListener;
import com.QiFeng_Milktea.dao.NhanVienDAO;
import com.QiFeng_Milktea.entity.NhanVien;
import com.QiFeng_Milktea.utils.MsgBox;
import java.awt.Color;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

public class DoiMatKhau extends javax.swing.JPanel {

    NhanVienDAO dao = new NhanVienDAO();

    public DoiMatKhau() {
        initComponents();
        lbAlertPassword.setText("");
        lbAlertUsername.setText("");
        lbNewPassword.setText("");
        lbNewPassword2.setText("");

        txtTenDangNhap.setEditable(false);
        txtMatKhau.grabFocus();

        loadChangePasswordInfo();
    }

    public boolean DoiMatKhau() {
        String userName = txtTenDangNhap.getText();
        String oldPassword = new String(txtMatKhau.getPassword());
        String newPassword = new String(txtNewMK02.getPassword());
        String confirmPassword = new String(txtNewMK3.getPassword());

        txtTenDangNhap.setBackground(Color.white);
        txtMatKhau.setBackground(Color.white);
        txtNewMK02.setBackground(Color.white);
        txtNewMK3.setBackground(Color.white);

        try {
            // Kiểm tra trống
            if (Validate.checkEmpty(lbAlertPassword, txtMatKhau, "Không được để trống mật khẩu cũ!") == false
                    && Validate.checkEmpty(lbNewPassword, txtNewMK02, "Không được để trống mật khẩu mới!") == false
                    && Validate.checkEmpty(lbNewPassword2, txtNewMK3, "Không được để trống xác nhận mật khẩu mới!") == false) {
                return false;

            } else if (Validate.checkEmpty(lbAlertPassword, txtMatKhau, "Không được để trống mật khẩu cũ!") == false) {
                return false;
            } else if (labelValidate.checkPass(lbNewPassword, txtNewMK02, "") == false) {
                return false;
            } else if (labelValidate.checkPass(lbNewPassword2, txtNewMK3, "") == false) {
                return false;
            }

            // Kiểm tra đúng tài khoản và mật khẩu cũ
            NhanVien account = dao.SelectbyID(userName);
            if (account == null) {
                JOptionPane.showMessageDialog(txtTenDangNhap, "Username không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                String passwordSystem = account.getMatKhau();
                if (!oldPassword.equals(passwordSystem)) {
                    JOptionPane.showMessageDialog(txtMatKhau, "Mật khẩu cũ không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            // Kiểm tra mật khẩu mới và xác nhận mật khẩu mới
            if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(txtMatKhau, "Mật khẩu mới không khớp với xác nhận mật khẩu mới!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Cập nhật mật khẩu mới vào cơ sở dữ liệu
            account.setMatKhau(newPassword);
            dao.update(account);
            MsgBox.alert(this, "Đổi mật khẩu thành công!");

            //Clear form
            txtMatKhau.setText("");
            txtNewMK02.setText("");
            txtNewMK3.setText("");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
        return true;
    }

    public void addEventLogin(ActionListener event) {
        btnDangNhap.addActionListener(event);
    }

    private void loadChangePasswordInfo() {
        Preferences preferences = Preferences.userRoot().node("com.raven.main.DangNhap");
        String username = preferences.get("username", "");

        txtTenDangNhap.setText(username);
        txtMatKhau.setText("");  // Đảm bảo mật khẩu cũ được xóa
        txtNewMK02.setText("");
        txtNewMK3.setText("");

        // Bạn có thể thêm mã khác tùy thuộc vào cách bạn muốn xử lý việc hiển thị thông tin
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNewPassword = new javax.swing.JLabel();
        lbAlertUsername = new javax.swing.JLabel();
        txtTenDangNhap = new com.raven.suportSwing.TextField();
        txtMatKhau = new com.raven.suportSwing.PasswordField();
        txtNewMK02 = new com.raven.suportSwing.PasswordField();
        btnDangNhap = new com.raven.suportSwing.MyButton();
        lbAlertPassword = new javax.swing.JLabel();
        lbNewPassword2 = new javax.swing.JLabel();
        txtNewMK3 = new com.raven.suportSwing.PasswordField();
        jLabel1 = new javax.swing.JLabel();
        lblmoMat = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbNewPassword.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        lbNewPassword.setForeground(new java.awt.Color(255, 51, 0));
        lbNewPassword.setText("jLabel1");

        lbAlertUsername.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        lbAlertUsername.setForeground(new java.awt.Color(255, 51, 0));
        lbAlertUsername.setText("jLabel1");

        txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTenDangNhap.setLabelText("Tài Khoản");
        txtTenDangNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusGained(evt);
            }
        });
        txtTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhapActionPerformed(evt);
            }
        });

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMatKhau.setLabelText("Mật Khẩu Cũ");
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
        });
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        txtNewMK02.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNewMK02.setLabelText("Mật Khẩu Mới");
        txtNewMK02.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNewMK02FocusGained(evt);
            }
        });
        txtNewMK02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewMK02ActionPerformed(evt);
            }
        });

        btnDangNhap.setText("Xác nhận");
        btnDangNhap.setBorderColor(new java.awt.Color(51, 153, 255));
        btnDangNhap.setColorClick(new java.awt.Color(255, 102, 204));
        btnDangNhap.setColorOver(new java.awt.Color(51, 153, 255));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        lbAlertPassword.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        lbAlertPassword.setForeground(new java.awt.Color(255, 51, 0));
        lbAlertPassword.setText("jLabel1");

        lbNewPassword2.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        lbNewPassword2.setForeground(new java.awt.Color(255, 51, 0));
        lbNewPassword2.setText("jLabel1");

        txtNewMK3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNewMK3.setLabelText("Xác Nhận Mật Khẩu Mới");
        txtNewMK3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNewMK3FocusGained(evt);
            }
        });
        txtNewMK3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewMK3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ĐỔI MẬT KHẨU");

        lblmoMat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblmoMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/see2424.png"))); // NOI18N
        lblmoMat.setText("Hiện mặt khẩu");
        lblmoMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmoMatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewMK3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbAlertUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbAlertPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNewMK02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbNewPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDangNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblmoMat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAlertUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAlertPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtNewMK02, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtNewMK3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNewPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmoMat, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenDangNhapFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDangNhapFocusGained
        lbAlertUsername.setText("");
    }//GEN-LAST:event_txtTenDangNhapFocusGained

    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        lbAlertPassword.setText("");
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        DoiMatKhau();

    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtNewMK02FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewMK02FocusGained
        lbNewPassword.setText("");
    }//GEN-LAST:event_txtNewMK02FocusGained

    private void txtNewMK02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewMK02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewMK02ActionPerformed

    private void txtNewMK3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewMK3FocusGained
        lbNewPassword2.setText("");
    }//GEN-LAST:event_txtNewMK3FocusGained

    private void txtNewMK3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewMK3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewMK3ActionPerformed
    private boolean isPasswordVisible = false;
    private void lblmoMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmoMatMouseClicked
        if (isPasswordVisible) {
            // Nếu mật khẩu đang hiển thị, ẩn nó đi
            txtMatKhau.setEchoChar('\u2022'); // Sử dụng ký tự ẩn mật khẩu (●)
            txtNewMK02.setEchoChar('\u2022'); // Sử dụng ký tự ẩn mật khẩu (●)
            txtNewMK3.setEchoChar('\u2022'); // Sử dụng ký tự ẩn mật khẩu (●)
            isPasswordVisible = false;
        } else {
            // Nếu mật khẩu đang ẩn, hiển thị nó
            txtMatKhau.setEchoChar((char) 0); // Hiển thị mật khẩu
            txtNewMK02.setEchoChar((char) 0); // Hiển thị mật khẩu
            txtNewMK3.setEchoChar((char) 0); // Hiển thị mật khẩu

            isPasswordVisible = true;
        }
    }//GEN-LAST:event_lblmoMatMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbAlertPassword;
    private javax.swing.JLabel lbAlertUsername;
    private javax.swing.JLabel lbNewPassword;
    private javax.swing.JLabel lbNewPassword2;
    private javax.swing.JLabel lblmoMat;
    private com.raven.suportSwing.PasswordField txtMatKhau;
    private com.raven.suportSwing.PasswordField txtNewMK02;
    private com.raven.suportSwing.PasswordField txtNewMK3;
    private com.raven.suportSwing.TextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
