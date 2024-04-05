package com.poly.test;

import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QiFeng_Milktea.main.QuenMatKhau;

public class CheckPasswordTest {
	QuenMatKhau quenMatKhau = new QuenMatKhau();

	@BeforeMethod
	public void openQuenMK() {
		new Thread(new Runnable() {
			public void run() {
				quenMatKhau.setVisible(true);
			}
		}).start();
		sleep(1);
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

	}

//	@Test(priority = 2)
//	public void TC_QLTS_QUENMATKHAU_2() {
//		// Kiểm tra nút "Gửi mã" với username không hợp lệ
//		String username = "DuyTND2322";
//		String email = "duytrannguyen122@gmail.com";
//		// Thiết lập giá trị cho txtUsername và txtEmail
//		quenMatKhau.txtUsername.setText(username);
//		quenMatKhau.txtEmail.setText(email);
//
//		// Kiểm tra xem quenMatKhau.checkUser(username) và quenMatKhau.checkEmail(email)
//		// trả về true
//		// (Tạm thời giả định rằng hàm này đã được test trong các test case khác)
//		Assert.assertTrue(quenMatKhau.checkUser(username));
//		Assert.assertTrue(quenMatKhau.checkEmail(email));
//
//		// Click vào nút "Gửi mã"
//		quenMatKhau.btnSend.doClick();
//
//		// Kiểm tra xem lblBell có được hiển thị hay không
//		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
//
//		// Kiểm tra xem btnVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
//
//		// Kiểm tra xem txtVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
//
//	}
//
//	@Test(priority = 3)
//	public void TC_QLTS_QUENMATKHAU_3() {
//		// Kiểm tra nút "Gửi mã" với username là các ký tự viết hoa/thường
//		String username = "duytnd";
//		String email = "duytrannguyen122@gmail.com";
//
//		// Thiết lập giá trị cho txtUsername và txtEmail
//		quenMatKhau.txtUsername.setText(username);
//		quenMatKhau.txtEmail.setText(email);
//
//		// Kiểm tra xem quenMatKhau.checkUser(username) và quenMatKhau.checkEmail(email)
//		// trả về true
//		// (Tạm thời giả định rằng hàm này đã được test trong các test case khác)
//		Assert.assertTrue(quenMatKhau.checkUser(username));
//		Assert.assertTrue(quenMatKhau.checkEmail(email));
//
//		// Click vào nút "Gửi mã"
//		quenMatKhau.btnSend.doClick();
//
//		// Kiểm tra xem lblBell có được hiển thị hay không
//		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
//
//		// Kiểm tra xem btnVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
//
//		// Kiểm tra xem txtVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
//
//	}
//
//	@Test(priority = 4)
//	public void TC_QLTS_QUENMATKHAU_4() {
//		// Kiểm tra nút "Gửi mã" với chữ cái đầu của email viết hoa
//		String username = "DuyTND2322";
//		String email = "duytrannguyen122@gmail.com";
//
//		// Thiết lập giá trị cho txtUsername và txtEmail
//		quenMatKhau.txtUsername.setText(username);
//		quenMatKhau.txtEmail.setText(email);
//
//		// Kiểm tra xem quenMatKhau.checkUser(username) và quenMatKhau.checkEmail(email)
//		// trả về true
//		// (Tạm thời giả định rằng hàm này đã được test trong các test case khác)
//		Assert.assertTrue(quenMatKhau.checkUser(username));
//		Assert.assertTrue(quenMatKhau.checkEmail(email));
//
//		// Click vào nút "Gửi mã"
//		quenMatKhau.btnSend.doClick();
//
//		// Kiểm tra xem lblBell có được hiển thị hay không
//		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
//
//		// Kiểm tra xem btnVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
//
//		// Kiểm tra xem txtVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
//
//	}
//
//	@Test(priority = 5)
//	public void TC_QLTS_QUENMATKHAU_5() {
//		// Kiểm tra nút "Gửi mã" với chữ cái đầu của email sai định dạng
//		String username = "DuyTND2322";
//		String email = "@uytrannguyen122@gmail.com";
//
//		// Thiết lập giá trị cho txtUsername và txtEmail
//		quenMatKhau.txtUsername.setText(username);
//		quenMatKhau.txtEmail.setText(email);
//
//		// Kiểm tra xem quenMatKhau.checkUser(username) và quenMatKhau.checkEmail(email)
//		// trả về true
//		// (Tạm thời giả định rằng hàm này đã được test trong các test case khác)
//		Assert.assertTrue(quenMatKhau.checkUser(username));
//		Assert.assertTrue(quenMatKhau.checkEmail(email));
//
//		// Click vào nút "Gửi mã"
//		quenMatKhau.btnSend.doClick();
//
//		// Kiểm tra xem lblBell có được hiển thị hay không
//		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
//
//		// Kiểm tra xem btnVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
//
//		// Kiểm tra xem txtVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
//
//	}
//
//	@Test(priority = 6)
//	public void TC_QLTS_QUENMATKHAU_6() {
//		// Kiểm tra nút "Gửi mã" với username chứ các khoảng trắng đầu/ cuối
//		String username = "            DuyTND2322          ";
//		String email = "duytrannguyen122@gmail.com";
//
//		// Thiết lập giá trị cho txtUsername và txtEmail
//		quenMatKhau.txtUsername.setText(username);
//		quenMatKhau.txtEmail.setText(email);
//
//		// Kiểm tra xem quenMatKhau.checkUser(username) và quenMatKhau.checkEmail(email)
//		// trả về true
//		// (Tạm thời giả định rằng hàm này đã được test trong các test case khác)
//		Assert.assertTrue(quenMatKhau.checkUser(username));
//		Assert.assertTrue(quenMatKhau.checkEmail(email));
//
//		// Click vào nút "Gửi mã"
//		quenMatKhau.btnSend.doClick();
//
//		// Kiểm tra xem lblBell có được hiển thị hay không
//		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
//
//		// Kiểm tra xem btnVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
//
//		// Kiểm tra xem txtVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
//
//	}
//
//	@Test(priority = 7)
//	public void TC_QLTS_QUENMATKHAU_7_8() {
//		// Kiểm tra nút "Gửi mã" với username để trống
//		// Kiểm tra nút "Gửi mã" với email để trống
//		String username = "";
//		String email = "";
//
//		// Thiết lập giá trị cho txtUsername và txtEmail
//		quenMatKhau.txtUsername.setText(username);
//		quenMatKhau.txtEmail.setText(email);
//
//		// Kiểm tra xem quenMatKhau.checkUser(username) và quenMatKhau.checkEmail(email)
//		// trả về true
//		// (Tạm thời giả định rằng hàm này đã được test trong các test case khác)
//		Assert.assertTrue(quenMatKhau.checkUser(username));
//		Assert.assertTrue(quenMatKhau.checkEmail(email));
//
//		// Click vào nút "Gửi mã"
//		quenMatKhau.btnSend.doClick();
//
//		// Kiểm tra xem lblBell có được hiển thị hay không
//		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
//
//		// Kiểm tra xem btnVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
//
//		// Kiểm tra xem txtVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
//
//	}
//	@Test(priority = 8)
//	public void TC_QLTS_QUENMATKHAU_9() {
//		//Kiểm tra nút "Gửi mã" với email không hợp lệ
//		String username = "DuyTND";
//		String email = "duy122@gmail.com";
//
//		// Thiết lập giá trị cho txtUsername và txtEmail
//		quenMatKhau.txtUsername.setText(username);
//		quenMatKhau.txtEmail.setText(email);
//
//		// Kiểm tra xem quenMatKhau.checkUser(username) và quenMatKhau.checkEmail(email)
//		// trả về true
//		// (Tạm thời giả định rằng hàm này đã được test trong các test case khác)
//		Assert.assertTrue(quenMatKhau.checkUser(username));
//		Assert.assertTrue(quenMatKhau.checkEmail(email));
//
//		// Click vào nút "Gửi mã"
//		quenMatKhau.btnSend.doClick();
//
//		// Kiểm tra xem lblBell có được hiển thị hay không
//		Assert.assertTrue(quenMatKhau.lblBell.isVisible());
//
//		// Kiểm tra xem btnVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.btnVerify.isEnabled());
//
//		// Kiểm tra xem txtVerify có được enabled hay không
//		Assert.assertTrue(quenMatKhau.txtVerify.isEnabled());
//
//	}
//	
//	@Test(priority = 9)
//	public void TC_QLTS_QUENMATKHAU_10() {
//		// Tạo mã xác minh ngẫu nhiên
//        int correctCode = 123456;
//
//        // Thiết lập giá trị cho randomCode và txtVerify
//        quenMatKhau.randomCode = correctCode;
//        quenMatKhau.txtVerify.setText(String.valueOf(correctCode));
//
//        // Click vào nút "Xác minh"
//        quenMatKhau.btnVerify.doClick();
//
//        // Kiểm tra xem txtPassword có được enabled hay không
//        Assert.assertTrue(quenMatKhau.txtPassword.isEnabled());
//
//        // Kiểm tra xem txtVerifyPassword có được enabled hay không
//        Assert.assertTrue(quenMatKhau.txtVerifyPassword.isEnabled());
//
//        // Kiểm tra xem btnReset có được enabled hay không
//        Assert.assertTrue(quenMatKhau.btnReset.isEnabled());
//	}
}
