package Client;

import QL.ClientGroupChatFrame;

public class SendMessageGroup {
	
	public SendMessageGroup() {
			
			
			
	}
	
	public void send() {
		
		try{
			
			QLmain.pw.println(OrderType.BEGINE.orderValue); // 000 开始指令
			
			QLmain.pw.println(OrderType.SETFROM.orderValue + QLmain.account); // 998 from
			
			QLmain.pw.println(OrderType.SETTO.orderValue + "all"); // 997 to

			QLmain.pw.println(OrderType.SETAFFARI.orderValue + OrderType.SENDMESSAGE.orderValue);
			
			QLmain.pw.println(OrderType.SETCONTENT.orderValue + QLmain.GroupChat.jtaSend.getText().toString()); //  内容
			
			QLmain.pw.println(OrderType.SUBMIT.orderValue); // 999 结束指令	
			
//			System.out.println(QLmain.GroupChat.jtaSend.getText().toString());
			
		}catch(Exception e) {
			System.out.println("发送消息请求发送异常");
		}
		
	}
	
}
