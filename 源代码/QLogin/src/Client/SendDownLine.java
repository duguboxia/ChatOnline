package Client;

public class SendDownLine {
	
	public SendDownLine() {
		
		try{
			
			QLmain.pw.println(OrderType.BEGINE.orderValue); // 000 ��ʼָ��
			
			QLmain.pw.println(OrderType.SETFROM.orderValue + QLmain.account); // 998 from
			
			QLmain.pw.println(OrderType.SETAFFARI.orderValue + OrderType.DOWNLINE.orderValue);// 105 ����
			
			QLmain.pw.println(OrderType.SUBMIT.orderValue); // 999 ����ָ��	
			
		}catch(Exception e) {
			System.out.println("�����������쳣");
		}
		
	}
}
