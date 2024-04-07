package com.poly.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QiFeng_Milktea.main.QuenMatKhau;
import com.raven.suportSwing.MyButton;

public class CheckPasswordTest {
	QuenMatKhau quenMatKhau = new QuenMatKhau();
	private MyButton btnReset;
	@BeforeMethod
	public void openQuenMK() {
		new Thread(new Runnable() {
			public void run() {
				quenMatKhau.setVisible(true);
				btnReset = quenMatKhau.getBtnReset();
			}
		}).start();
		sleep(1);
	}

	@AfterMethod
	public void closeQuenMK() {
		quenMatKhau.setVisible(false);
		sleep(2);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				quenMatKhau.setVisible(false);
			}
		});
		sleep(3);
	}

	public void sleep(int s) {
		try {
			TimeUnit.SECONDS.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void TC_QLTS_QUENMATKHAU_1() {
		// Tạo username và email hợp lệ
		String username = "DuyTND";
		String email = "duytrannguyen122@gmail.com";

		// Thiết lập giá trị cho txtUsername và txtEmail
		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);

		// Kiểm tra xem quenMatKhau.checkUser(username) và quenMatKhau.checkEmail(email)
		// trả về true
		// (Tạm thời giả định rằng hàm này đã được test trong các test case khác)
		Assert.assertTrue(quenMatKhau.checkUser(username));
		Assert.assertTrue(quenMatKhau.checkEmail(email));

		// Click vào nút "Gửi mã"
		quenMatKhau.btnSend.doClick();

		// Kiểm tra xem lblBell có được hiển thị hay không
		Assert.assertTrue(quenMatKhau.lblBell.isVisible());

		// Kiểm tra xem btnVerify có được enabled hay không
		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());

		// Kiểm tra xem txtVerify có được enabled hay không
		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());

	}

	@Test(priority = 2)
	public void TC_QLTS_QUENMATKHAU_2() {
		// Kiểm tra nút "Gửi mã" với username không hợp lệ
		String username = "DuyTND";
		String email = "duytrannguyen122@gmail.com";
		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);
		// Act
		quenMatKhau.btnSend.doClick();

		// Assert
		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
	}

	@Test(priority = 3)
	public void TC_QLTS_QUENMATKHAU_3() {
		// Kiểm tra nút "Gửi mã" với username là các ký tự viết hoa/thường
		String username = "duytnd";
		String email = "duytrannguyen122@gmail.com";
		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);
		// Act
		quenMatKhau.btnSend.doClick();

		// Assert
		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());

	}

	@Test(priority = 4)
	public void TC_QLTS_QUENMATKHAU_4() {
		// Kiểm tra nút "Gửi mã" với chữ cái đầu của email viết hoa
		String username = "DuyTND2322";
		String email = "duytrannguyen122@gmail.com";

		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);
		// Act
		quenMatKhau.btnSend.doClick();

		// Assert
		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
	}

	@Test(priority = 5)
	public void TC_QLTS_QUENMATKHAU_5() {
		// Kiểm tra nút "Gửi mã" với chữ cái đầu của email sai định dạng
		String username = "DuyTND2322";
		String email = "@uytrannguyen122@gmail.com";

		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);
		// Act
		quenMatKhau.btnSend.doClick();

		// Assert
		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());

	}

	@Test(priority = 6)
	public void TC_QLTS_QUENMATKHAU_6() {
		// Kiểm tra nút "Gửi mã" với username chứ các khoảng trắng đầu/ cuối
		String username = "            DuyTND2322          ";
		String email = "duytrannguyen122@gmail.com";

		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);
		// Act
		quenMatKhau.btnSend.doClick();

		// Assert
		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());

	}

	@Test(priority = 7)
	public void TC_QLTS_QUENMATKHAU_7_8() {
		// Kiểm tra nút "Gửi mã" với username để trống
		// Kiểm tra nút "Gửi mã" với email để trống
		String username = "";
		String email = "";
		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);
		// Act
		quenMatKhau.btnSend.doClick();

		// Assert
		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
	}

	@Test(priority = 8)
	public void TC_QLTS_QUENMATKHAU_9() {
		// Kiểm tra nút "Gửi mã" với email không hợp lệ
		String username = "DuyTND";
		String email = "duy122@gmail.com";
		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);
		// Act
		quenMatKhau.btnSend.doClick();

		// Assert
		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
	}

	@Test(priority = 9)
	public void TC_QLTS_QUENMATKHAU_10() {
		// Tạo mã xác minh ngẫu nhiên
		int correctCode = 123456;

		// Thiết lập giá trị cho randomCode và txtVerify
		quenMatKhau.randomCode = correctCode;
		quenMatKhau.txtVerify.setText(String.valueOf(correctCode));

		// Click vào nút "Xác minh"
		quenMatKhau.btnVerify.doClick();

		// Kiểm tra xem txtPassword có được enabled hay không
		Assert.assertTrue(quenMatKhau.txtPassword.isEnabled());

		// Kiểm tra xem txtVerifyPassword có được enabled hay không
		Assert.assertTrue(quenMatKhau.txtVerifyPassword.isEnabled());

		// Kiểm tra xem btnReset có được enabled hay không
		Assert.assertTrue(quenMatKhau.btnReset.isEnabled());
	}

	@Test(priority = 10)
	public void TC_QLTS_QUENMATKHAU_11() {
		String username = "DuyTND";
		String email = "duytrannguyen122@gmail.com";

		// Nhập mã sai vào username và email
		quenMatKhau.txtUsername.setText(username);
		quenMatKhau.txtEmail.setText(email);

		// Gửi mã
		quenMatKhau.btnSend.doClick();

		// Nhập sai mã
		quenMatKhau.txtVerify.setText("wrong_code");

		// Click vào nút "Xác minh"
		quenMatKhau.btnVerify.doClick();

		// Kiểm tra nếu dữ liệu trả về là "code verify không hợp lệ"
		Assert.assertEquals(quenMatKhau.lblVerify.getText(), "code verify không hợp lệ");
	}

	@Test(priority = 11)
	public void TC_QLTS_QUENMATKHAU_12() {
		QuenMatKhau quenMatKhau = new QuenMatKhau();

		// Enable the verify field and set the time label to 60
		quenMatKhau.txtVerify.setEnabled(true);
		quenMatKhau.lblTime.setText("60");

		// Wait for 61 seconds
		try {
			Thread.sleep(61000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Verify that the verify field is now disabled
		Assert.assertFalse(quenMatKhau.txtVerify.isEnabled());
	}
	
	@Test(priority = 1)
	public void TC_QLTS_QUENMATKHAU_13() {
        quenMatKhau.txtUsername.setText("DuyTND");
        quenMatKhau.txtEmail.setText("duytrannguyen122@gmail.com");
        quenMatKhau.sendCode(); // Send the verification code
        quenMatKhau.txtVerify.setText("123456"); // Enter the verification code
        quenMatKhau.txtPassword.setText("123456789");
        quenMatKhau.txtVerifyPassword.setText("123456789");

        // Click the "Xác minh" button to enable the "Xác nhận đổi mật khẩu" button
        quenMatKhau.btnVerify.doClick();

        // Click the "Xác nhận đổi mật khẩu" button
        MyButton btnReset = quenMatKhau.btnReset;
        btnReset.doClick();

        // Check that the alert message is displayed
        String alertMessage = quenMatKhau.lblMessage.toString();
        assertTrue(alertMessage.contains("Lấy lại mật khẩu thành công"));
		
	    
	}
	@Test(priority = 1)
	public void TC_QLTS_QUENMATKHAU_14() {
        quenMatKhau.txtUsername.setText("DuyTND");
        quenMatKhau.txtEmail.setText("duytrannguyen122@gmail.com");
        quenMatKhau.txtPassword.setText("dongduy122");
        
        quenMatKhau.txtPassword.setText("password1");
        quenMatKhau.txtVerifyPassword.setText("password2");
        // The "Xác nhận đổi mật khẩu" button should be disabled
        assertFalse(btnReset.isEnabled(), "Nên tắt BtnReset bằng các mật khẩu khác");
        // Set the same value for password and confirmation password
        quenMatKhau.txtVerifyPassword.setText("password1");
        // The "Xác nhận đổi mật khẩu" button should be enabled
        assertTrue(btnReset.isEnabled(), "BtnReset phải được kích hoạt với cùng mật khẩu");
	    
	}
	@Test(priority = 1)
	public void TC_QLTS_QUENMATKHAU_15() {
		//Kiểm tra nút "Xác nhận đổi mật khẩu" nhập mật khẩu mới dưới 6 ký tự
		quenMatKhau.txtUsername.setText("DuyTND");
        quenMatKhau.txtEmail.setText("duytrannguyen122@gmail.com");
        quenMatKhau.txtPassword.setText("dongduy122");

        // Set a short password (less than 6 characters)
        quenMatKhau.txtPassword.setText("12345");
        quenMatKhau.txtVerifyPassword.setText("12345");

        // The "Xác nhận đổi mật khẩu" button should be disabled
        assertFalse(btnReset.isEnabled(), "Mat khau ít hon 6 ky tu!");
    }
	    
	@Test(priority = 1)
	public void TC_QLTS_QUENMATKHAU_16() {
	    //Kiểm tra nút "Xác nhận đổi mật khẩu" nhập mật khẩu mới trên 10 ký tự
		quenMatKhau.txtUsername.setText("DuyTND");
        quenMatKhau.txtEmail.setText("duytrannguyen122@gmail.com");
        quenMatKhau.txtPassword.setText("dongduy122");

        // Set a long password (more than 10 characters)
        quenMatKhau.txtPassword.setText("12345678901");
        quenMatKhau.txtVerifyPassword.setText("12345678901");

        // The "Xác nhận đổi mật khẩu" button should be enabled
        assertTrue(btnReset.isEnabled(), "Mat khau qua 10 ky tu!");
	    
	}
//	@Test(priority = 1)
//	public void TC_QLTS_QUENMATKHAU_17() {
//	    // Arrange
//	    
//	}
//	@Test(priority = 1)
//	public void TC_QLTS_QUENMATKHAU_18() {
//	    // Arrange
//	    
//	}
//	@Test(priority = 1)
//	public void TC_QLTS_QUENMATKHAU_19() {
//	    // Arrange
//	    
//	}
//	@Test(priority = 1)
//	public void TC_QLTS_QUENMATKHAU_20() {
//	    // Arrange
//	    
//	}
}
