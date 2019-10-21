package Client;

public class InterfaceSend extends Thread{
	
	public InterfaceSend() {
		
		
	}
	
	public void online() {
		
			// 上线
			try{
					
				QLmain.pw.println(OrderType.BEGINE.orderValue); // 000 开始指令
				
				QLmain.pw.println(OrderType.SETFROM.orderValue + QLmain.account); // 998 from
			
				QLmain.pw.println(OrderType.SETAFFARI.orderValue + OrderType.ONLINE.orderValue);// 101 下线
					
				QLmain.pw.println(OrderType.SUBMIT.orderValue); // 999 结束指令	
					
			}catch(Exception e) {
				System.out.println("上线请求发送异常");
			}
	}
	
	
	public void run() {
		
		while(true) {
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 心跳检测 在线状态		
			QLmain.pw.println(OrderType.UPDATE.orderValue); // 888  每隔一秒发送请求
//			System.out.println("心跳检测");
		}
		
		
	}
	
	
	
}
