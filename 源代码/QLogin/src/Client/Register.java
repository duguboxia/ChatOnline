package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Register {

	
	public Register(String account,String password) {
		QLmain.account = account;
		QLmain.password = password;
		
		sendLogin();
		System.out.println(account);
		System.out.println(password);
	}
	
	// ∑¢ÀÕ’À√‹
		public void sendLogin() {
			try {
				QLmain.pw.println(OrderType.BEGINE.orderValue); // 000 ø™ º÷∏¡Ó
				
				QLmain.pw.println(OrderType.SETAFFARI.orderValue + OrderType.REGISTER.orderValue);// 004 ◊¢≤·
				
				QLmain.pw.println(OrderType.SETACCOUNT.orderValue + QLmain.account); // 002 ’À∫≈
				
				QLmain.pw.println(OrderType.SETPASSWORD.orderValue + QLmain.password); // 003 √‹¬Î
				
				QLmain.pw.println(OrderType.SUBMIT.orderValue); // 999 Ω· ¯÷∏¡Ó
				
			} catch (Exception e) {
				System.out.println("PrintWriter ∑¢ÀÕ◊¢≤·÷∏¡Ó ß∞‹£°");
			}
		}
	
}
