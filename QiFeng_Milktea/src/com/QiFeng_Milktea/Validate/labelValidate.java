package com.QiFeng_Milktea.Validate;

import com.QiFeng_Milktea.utils.MsgBox;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class labelValidate {

    public static boolean checkEmpty(JLabel lbl, JTextField txtString, String mess) {
        if (txtString.getText().trim().isEmpty()) {
            MsgBox.labelAlert(lbl, txtString, mess);
            return false;
        }
        return true;

    }

    public static boolean checkEmptyTextArea(JLabel lbl, JTextArea txtString, String mess) {
        if (txtString.getText().trim().isEmpty()) {
            MsgBox.labelAlertTextArea(lbl, txtString, mess);
            return false;
        }
        return true;

    }

    public static boolean checkNumber(JLabel lbl, JTextField txtString, String mess) {
        boolean check = true;
        try {
            double number = Double.parseDouble(txtString.getText());
            if (number < 0) {
                MsgBox.labelAlert(lbl, txtString, mess);
                check = false;
            } else {
                check = true;
            }
        } catch (Exception e) {
            MsgBox.labelAlert(lbl, txtString, "Lương không hợp lệ!!!");
            check = false;
        }
        return check;
    }

    public static boolean checkEmail(JLabel lbl, JTextField field, String sb) {
        boolean flag = true;
        if (!checkEmpty(lbl, field, "Email chưa nhập!!!")) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\w+@\\w+(\\.\\w+){1,2}");
        Matcher matcher = pattern.matcher(field.getText());
        if (!matcher.find()) {
            MsgBox.labelAlert(lbl, field, "Email không hợp lệ không hợp lệ\n");
            flag = false;
        }
        return flag;
    }

    public static boolean checkPhoneNumber(JLabel lbl, JTextField field, String sb) {
        boolean flag = true;
        if (!checkEmpty(lbl, field, "Số điện thoại chưa nhập!!!")) {
            return false;
        }

        Pattern pattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})");
        Matcher matcher = pattern.matcher(field.getText());
        if (!matcher.find()) {
            MsgBox.labelAlert(lbl, field, "Số điện thoại không hợp lệ \n");
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    public static boolean checkPass(JLabel lbl, JTextField field, String sb) {

        boolean flag = true;
        if (!checkEmpty(lbl, field, "Mật khẩu chưa nhập!!!")) {
            return false;
        }

        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).+$");
        Matcher matcher = pattern.matcher(field.getText());
        if (!matcher.find()) {
            MsgBox.labelAlert(lbl, field, "Mật khẩu phải chứa ít nhất một chữ cái và một số");
            flag = false;
        }
        // Kiểm tra độ dài mật khẩu
        if (field.getText().length() > 10) {
            MsgBox.labelAlert(lbl, field, "Mật khẩu không được quá 10 ký tự");
            flag = false;
        }

        return flag;

    }

    public static boolean checkUser(JLabel lbl, JTextField txtString, String mess) {
        boolean userExists = maNVTonTai(txtString.getText().trim());
        if (!userExists) {
            MsgBox.labelAlert(lbl, txtString, mess);
            return false;
        }
        return true;
    }

    private static boolean maNVTonTai(String maNV) {

        return !maNV.isEmpty();
    }
    
    
    
     //Khách hàng

    public static boolean checkName(JLabel lbl, JTextField txtString, String sb) {
        boolean flag = true;
        if (!checkEmpty(lbl, txtString, "Tên chưa nhập!!!")) {
            return false;
        }

        String name = txtString.getText().trim();

        // Check length
        if (name.length() > 50) {
            MsgBox.labelAlert(lbl, txtString, "Tên không được quá 50 ký tự");
            return false;
        }

        // Check for special characters and numbers
        if (!name.matches("^[\\p{L}\\s]+$")) {
            MsgBox.labelAlert(lbl, txtString, "Tên không được chứa ký tự đặc biệt hoặc số");
            return false;
        }

        return true;
    }
    
      public static boolean checkAddress(JLabel lbl, JTextField txtString, String mess) {
        boolean flag = true;
        if (!checkEmpty(lbl, txtString, "Địa chỉ chưa nhập!!!")) {
            return false;
        }

        String address = txtString.getText().trim();

        // Check length
        if (address.length() > 100) {
            MsgBox.labelAlert(lbl, txtString, "Địa chỉ không được quá 100 ký tự");
            return false;
        }

        // Check for special characters
        if (!address.matches("^[\\p{L}0-9\\s,.-]+$")) {
            MsgBox.labelAlert(lbl, txtString, "Địa chỉ không được chứa ký tự đặc biệt không mong muốn");
            return false;
        }

        return true;
    }


    // ... (existing code)
}
