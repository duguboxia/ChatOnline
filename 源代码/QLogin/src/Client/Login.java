package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Login {
	
	
	public Login(String account,String password) {
		
		QLmain.account = account;
		QLmain.password = password;
		
		sendLogin();
//		System.out.println(account);
//		System.out.println(password);
			
	}
	
	// ��������
	public void sendLogin() {
		try {
			QLmain.pw.println(OrderType.BEGINE.orderValue); // 000 ��ʼָ��
			
			QLmain.pw.println(OrderType.SETAFFARI.orderValue + OrderType.LOAD.orderValue); // 001 ��¼
			
			QLmain.pw.println(OrderType.SETACCOUNT.orderValue + QLmain.account); // 002 �˺�
			
			QLmain.pw.println(OrderType.SETPASSWORD.orderValue + QLmain.password); // 003 ����
			
			QLmain.pw.println(OrderType.SUBMIT.orderValue); // 999 ����ָ��	
		
		} catch (Exception e) {
			System.out.println("PrintWriter ���͵�¼ָ��ʧ�ܣ�");
		}
		System.out.println(QLmain.account);
		System.out.println(QLmain.password);
	}
}
