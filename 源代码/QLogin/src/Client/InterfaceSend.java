package Client;

public class InterfaceSend extends Thread{
	
	public InterfaceSend() {
		
		
	}
	
	public void online() {
		
			// ����
			try{
					
				QLmain.pw.println(OrderType.BEGINE.orderValue); // 000 ��ʼָ��
				
				QLmain.pw.println(OrderType.SETFROM.orderValue + QLmain.account); // 998 from
			
				QLmain.pw.println(OrderType.SETAFFARI.orderValue + OrderType.ONLINE.orderValue);// 101 ����
					
				QLmain.pw.println(OrderType.SUBMIT.orderValue); // 999 ����ָ��	
					
			}catch(Exception e) {
				System.out.println("�����������쳣");
			}
	}
	
	
	public void run() {
		
		while(true) {
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ������� ����״̬		
			QLmain.pw.println(OrderType.UPDATE.orderValue); // 888  ÿ��һ�뷢������
//			System.out.println("�������");
		}
		
		
	}
	
	
	
}
