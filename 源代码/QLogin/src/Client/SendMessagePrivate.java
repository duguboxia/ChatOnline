package Client;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SendMessagePrivate {
	
//	String account = "";
//	
	public SendMessagePrivate() {
		QLmain.PrivateChat.areaChat.append("【1级】" + " " + QLmain.account + "  " + time() + "\n" + QLmain.GroupChat.jtaSend.getText().toString());
	}
	
	// Time
				private String time() {
					Calendar c = Calendar.getInstance();
					SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String datetime = sdf.format(c.getTime());
					return datetime;
				}
	
	
	public void send() {
		
		try{
			
			QLmain.pw.println(OrderType.BEGINE.orderValue); // 000 开始指令
			
			QLmain.pw.println(OrderType.SETFROM.orderValue + QLmain.account); // 998 from
			
			QLmain.pw.println(OrderType.SETTO.orderValue + "123"); // 997 to 目标好友账号

			QLmain.pw.println(OrderType.SETAFFARI.orderValue + OrderType.SENDMESSAGE.orderValue);
			
			QLmain.pw.println(OrderType.SETCONTENT.orderValue + QLmain.PrivateChat.areaSend.getText().toString()); //  内容
			
			QLmain.pw.println(OrderType.SUBMIT.orderValue); // 999 结束指令	
			
			
		}catch(Exception e) {
			System.out.println("发送消息请求发送异常");
		}
		
	}
	
}
