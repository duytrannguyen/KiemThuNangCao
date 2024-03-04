package com.QiFeng_Milktea.main;

import com.QiFeng_Milktea.Validate.Validate;
import java.awt.event.ActionListener;
import com.QiFeng_Milktea.dao.NhanVienDAO;
import com.QiFeng_Milktea.entity.NhanVien;
import com.QiFeng_Milktea.utils.Auth;
import com.QiFeng_Milktea.utils.JdbcHelper;
import com.QiFeng_Milktea.utils.MsgBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class DangNhap extends javax.swing.JPanel {


    int row = 1;

    NhanVienDAO dao = new NhanVienDAO();
    public static String server;
    public static String databaseName;

    public DangNhap() {
        initComponents();
        lbAlertPassword.setText("");
        lbAlertUsername.setText("");
        txtTenDangNhap.grabFocus();
        loadLoginInfo();
        pnKetNoi.setVisible(false);
//        btnDangNhap.setEnabled(false);
    }

    public void backLogin() {
        txtTenDangNhap.grabFocus();
    }

    public boolean DangNhap() {
        String userName = txtTenDangNhap.getText();
        String passWord = new String(txtMatKhau.getPassword());
        NhanVienDAO uDao = new NhanVienDAO();
        txtTenDangNhap.setBackground(Color.white);
        txtMatKhau.setBackground(Color.white);
        try {
            //Bắt lỗi để trống
            if (Validate.checkEmpty(lbAlertUsername, txtTenDangNhap, "Không được để trống Username!") == false
                    && Validate.checkEmpty(lbAlertPassword, txtMatKhau, "Không được để trống password!") == false) {
                return false;
            } else if (Validate.checkEmpty(lbAlertUsername, txtTenDangNhap, "Không được để trống username!") == false) {
                return false;
            } else if (Validate.checkEmpty(lbAlertPassword, txtMatKhau, "Không được để trống password!") == false) {
                return false;
            } else {
                login();
            }

            //Bắt lỗi sai tài khoản mật khẩu
            NhanVien account = dao.SelectbyID(userName);
            if (account == null) {    //nếu user sai
                JOptionPane.showMessageDialog(btnDangNhap, "Username hoặc password không đúng!", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                String passwordSystem = account.getMatKhau();
                if (passWord.equals(passwordSystem)) {
                    MsgBox.alert(this, "Đăng nhập thành công!");
                    NhanVien user = uDao.SelectbyID(account.getMaNV());
                    Auth.user = user;
                    new Main().setVisible(true);
                    this.setVisible(false);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(btnDangNhap, "Username hoặc password không đúng!", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
        return true;

    }

    public void login() {
        txtTenDangNhap.grabFocus();
    }

    void ketNoi() {
        btnKetNoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server = txtHost.getText();
                databaseName = txtDatabase.getText();

                try {
                    // Kết nối đến cơ sở dữ liệu khi nút được nhấn
                    JdbcHelper.conn = DriverManager.getConnection(JdbcHelper.connectionUrl);
                    JOptionPane.showMessageDialog(null, "Kết nối thành công đến cơ sở dữ liệu!");
//                    btnDangNhap.setEnabled(true);
                } catch (Exception ex) {
//                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Lỗi khi kết nối đến cơ sở dữ liệu! ");
                }
            }
        });

    }

    public void addEventRegister(ActionListener event) {
        cmdRegister.addActionListener(event);
    }

    public void addEventLogin(ActionListener event) {
        btnDangNhap.addActionListener(event);
    }

    void kethuc() {
        if (MsgBox.cobfirm(this, "Bạn muốn kết thúc ứng dụng?")) {
            System.exit(0);
        }
    }

    private void savePassCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý sự kiện khi người dùng tích vào ô "Lưu mật khẩu"
        if (savePassCheckBox.isSelected()) {
            // Lưu tên đăng nhập và mật khẩu vào Preferences
            saveLoginInfo(txtTenDangNhap.getText(), new String(txtMatKhau.getPassword()));
        } else {
            // Nếu không được tích, xóa thông tin đã lưu
            clearLoginInfo();
        }
    }

    private void saveLoginInfo(String username, String password) {
        Preferences preferences = Preferences.userRoot().node("com.raven.main.DangNhap");
        preferences.put("username", username);
        preferences.put("password", password);
    }

    private void clearLoginInfo() {
        Preferences preferences = Preferences.userRoot().node("com.raven.main.DangNhap");
        preferences.remove("username");
        preferences.remove("password");
    }

    private void loadLoginInfo() {
        Preferences preferences = Preferences.userRoot().node("com.raven.main.DangNhap");
        String username = preferences.get("username", "");
        String password = preferences.get("password", "");

        txtTenDangNhap.setText(username);
        txtMatKhau.setText(password);
        savePassCheckBox.setSelected(!username.isEmpty() && !password.isEmpty());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lbAlertUsername = new javax.swing.JLabel();
        lbAlertPassword = new javax.swing.JLabel();
        txtTenDangNhap = new com.raven.suportSwing.TextField();
        txtMatKhau = new com.raven.suportSwing.PasswordField();
        btnDangNhap = new com.raven.suportSwing.MyButton();
        cmdRegister = new com.raven.suportSwing.MyButton();
        savePassCheckBox = new javax.swing.JCheckBox();
        lblmoMat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnKetNoi = new javax.swing.JPanel();
        txtHost = new com.raven.suportSwing.TextField();
        btnKetNoi = new com.raven.suportSwing.MyButton();
        txtDatabase = new com.raven.suportSwing.TextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(69, 68, 68));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đăng Nhập");

        lbAlertUsername.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbAlertUsername.setForeground(new java.awt.Color(255, 51, 0));
        lbAlertUsername.setText("jLabel1");

        lbAlertPassword.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbAlertPassword.setForeground(new java.awt.Color(255, 51, 0));
        lbAlertPassword.setText("jLabel1");

        txtTenDangNhap.setText("admin");
        txtTenDangNhap.setLabelText("Usename");
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

        txtMatKhau.setText("1234567");
        txtMatKhau.setLabelText("Password");
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

        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.setBorderColor(new java.awt.Color(51, 153, 255));
        btnDangNhap.setColorClick(new java.awt.Color(255, 102, 204));
        btnDangNhap.setColorOver(new java.awt.Color(51, 153, 255));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        cmdRegister.setText("Quên Mật Khẩu");
        cmdRegister.setBorderColor(new java.awt.Color(51, 153, 255));
        cmdRegister.setColorClick(new java.awt.Color(255, 102, 204));
        cmdRegister.setColorOver(new java.awt.Color(51, 153, 255));
        cmdRegister.setContentAreaFilled(true);
        cmdRegister.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        savePassCheckBox.setText("Lưu mật khẩu");

        lblmoMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/see2424.png"))); // NOI18N
        lblmoMat.setText("Hiện mặt khẩu");
        lblmoMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmoMatMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kết nối database");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        pnKetNoi.setBackground(new java.awt.Color(255, 255, 255));

        txtHost.setLabelText("Host");

        btnKetNoi.setText("Xác nhận");
        btnKetNoi.setBorderColor(new java.awt.Color(51, 153, 255));
        btnKetNoi.setColorClick(new java.awt.Color(255, 102, 204));
        btnKetNoi.setColorOver(new java.awt.Color(51, 153, 255));
        btnKetNoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoiActionPerformed(evt);
            }
        });

        txtDatabase.setLabelText("Database");

        javax.swing.GroupLayout pnKetNoiLayout = new javax.swing.GroupLayout(pnKetNoi);
        pnKetNoi.setLayout(pnKetNoiLayout);
        pnKetNoiLayout.setHorizontalGroup(
            pnKetNoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtHost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKetNoi, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
            .addComponent(txtDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnKetNoiLayout.setVerticalGroup(
            pnKetNoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKetNoiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKetNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAlertUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbAlertPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(savePassCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblmoMat, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnKetNoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAlertUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAlertPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savePassCheckBox)
                    .addComponent(lblmoMat))
                .addGap(30, 30, 30)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(cmdRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnKetNoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        savePassCheckBoxActionPerformed(evt);

    }//GEN-LAST:event_btnDangNhapActionPerformed
    private boolean isPasswordVisible = false;
    private void lblmoMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmoMatMouseClicked
        if (isPasswordVisible) {
            // Nếu mật khẩu đang hiển thị, ẩn nó đi
            txtMatKhau.setEchoChar('\u2022'); // Sử dụng ký tự ẩn mật khẩu (●)
            isPasswordVisible = false;
        } else {
            // Nếu mật khẩu đang ẩn, hiển thị nó
            txtMatKhau.setEchoChar((char) 0); // Hiển thị mật khẩu
            isPasswordVisible = true;
        }
    }//GEN-LAST:event_lblmoMatMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        clickJLabel1();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnKetNoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoiActionPerformed
        // TODO add your handling code here:
        ketNoi();
    }//GEN-LAST:event_btnKetNoiActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked
    private void clickJLabel1() {
        if (row == -1) {
            pnKetNoi.setVisible(true);
            row = 1;
        } else if (row == 1) {
            pnKetNoi.setVisible(false);
            row = -1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.suportSwing.MyButton btnDangNhap;
    private com.raven.suportSwing.MyButton btnKetNoi;
    private com.raven.suportSwing.MyButton cmdRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbAlertPassword;
    private javax.swing.JLabel lbAlertUsername;
    private javax.swing.JLabel lblmoMat;
    private javax.swing.JPanel pnKetNoi;
    private javax.swing.JCheckBox savePassCheckBox;
    private com.raven.suportSwing.TextField txtDatabase;
    private com.raven.suportSwing.TextField txtHost;
    private com.raven.suportSwing.PasswordField txtMatKhau;
    private com.raven.suportSwing.TextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
