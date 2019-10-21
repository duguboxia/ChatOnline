package Client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import Client.Affari;
import Client.OrderType;
import Client.QLmain;
import QL.ClientGroupChatFrame;
import QL.QLinterface;
import QL.QLogin;;

public class MessageDeal extends Thread{
	
	private volatile boolean exit = false;
	public static Affari l = null;
	
	public void run(){
		while(!exit){
			
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			executeAffari();
			
		}
	}
	
	//处理模块
		private void executeAffari(){
			
			if(QLmain.affariList.isEmpty()){
//				System.out.println("等待ing......");
				return;
			}
			l = QLmain.affariList.poll();
			
			if( // 登录模块
					l.affari.equals(OrderType.LOADSUCCESS.orderValue) || 
					l.affari.equals(OrderType.LOADERROR1.orderValue) || 
					l.affari.equals(OrderType.LOADERROR2.orderValue) ||
					l.affari.equals(OrderType.LOADERROR3.orderValue)){
				
				System.out.println("登录模块打开");
				executeLoad();
			}else if( // 注册模块
					l.affari.equals(OrderType.REGISTERSUCCESS.orderValue) || 
					l.affari.equals(OrderType.REGISTERERROR.orderValue)){
				
				System.out.println("注册模块打开");
				exeuteRegister();
			}else if(l.affari.equals(OrderType.GETMESSAGE.orderValue)) {
				System.out.println("转发消息");
				if(l.to.equals("all")) {
					ReceiveMessageGroup();
				}else {
					ReceiveMessagePrivate();
				}
			}else if(l.affari.equals(OrderType.MIANRETURNFRIENDS.orderValue)) { //主界面 返回 昵称|好友列表 - 在线状态|(s -> c)
				
				mainReturnFriends();
				QLinterface.a();
				
			}else if(l.affari.equals(OrderType.MIANRETURNNEWS.orderValue)) { //主界面 返回 昵称消息 - visi|(s -> c)
				
				mainReturnNews();
				
			}
			
			l = null;
				
		}
		
		// 回复服务器 (c -> s)
		private void returnAffari(){
			
			l.pw.println(OrderType.BEGINE.orderValue);
			l.pw.println(OrderType.SETFROM.orderValue + l.from);
			l.pw.println(OrderType.SETTO.orderValue + l.to);
			l.pw.println(OrderType.SETAFFARI.orderValue+l.affari);
			for(int index = 0; index < l.content.size(); index++){
				l.pw.println(OrderType.SETCONTENT.orderValue + l.content.get(index));
			}
			l.pw.println(OrderType.SUBMIT.orderValue);
			return;
		}
		
		//	注册判断
		private void exeuteRegister(){
			
			if(l.affari.equals(OrderType.REGISTERSUCCESS.orderValue)){
				System.out.println("注册成功");
				JOptionPane.showMessageDialog(QLogin.contentRTPane, "注册成功,请重启登录框", "提示框",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
//				QLogin.contentRTPane.dispose();
			}else if(l.affari.equals(OrderType.REGISTERERROR.orderValue)){
				System.out.println("注册失败：账号重复");
				JOptionPane.showMessageDialog(QLogin.contentRTPane, "注册失败 -- 账号已被注册", "提示框",JOptionPane.WARNING_MESSAGE);  
			}else{
				System.out.println("注册判断未知命令:" + l.affari);
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "未知错误,请联系管理员", "提示框",JOptionPane.WARNING_MESSAGE);
			}
			returnAffari();
		}
		
		//	登录判断
		private void executeLoad(){
			if(l.affari.equals(OrderType.LOADSUCCESS.orderValue)) {
					System.out.println("登录成功");
					QLinterface mainInterface = new QLinterface();
					mainInterface.setVisible(true); 
					
					QLmain.QL.setVisible(false);
				
			}else if(l.affari.equals(OrderType.LOADERROR1.orderValue)) {
				System.out.println("登陆失败:账户不存在");
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "登录失败 -- 账户不存在", "提示框",JOptionPane.WARNING_MESSAGE);  
				System.exit(0);
			}else if(l.affari.equals(OrderType.LOADERROR2.orderValue)) {
				System.out.println("登陆失败:密码错误");
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "登录失败 -- 密码错误", "提示框",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}else if(l.affari.equals(OrderType.LOADERROR3.orderValue)) {
				System.out.println("登陆失败:重复登录");
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "登录失败 -- 重复登录", "提示框",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}else {
				System.out.println("登录判断未知命令:" + l.affari);
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "未知错误,请联系管理员", "提示框",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		// 整合 content
		private String andContent(List<String> content){
			
			StringBuffer str = new StringBuffer();
			for(int index = 0; index < content.size(); index++){
				str.append(content.get(index));
			}
			return str.substring(0);
		}
		
		//	转发消息 群聊
		private void ReceiveMessageGroup() {
			
			String msg;
			msg = this.andContent(l.content);
			try {
					QLmain.GroupChat.jtaChat.append("【灌水】" + " " + QLmain.account + "  " + time() + "\n" + msg + "\n\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
//		转发消息 私聊
		private void ReceiveMessagePrivate() {
				
				String msg;
				msg = this.andContent(l.content);
				try {
						QLmain.PrivateChat.areaChat.append("【1级】" + " " + QLmain.account + "  " + time() + "\n" + msg + "\n\n");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		// 接收 主界面 返回 昵称|好友列表 - 在线状态|(s -> c)
		private void mainReturnFriends() {
			System.out.println("主界面 回包1");
			dealmainReturnFriends();
			
			for(int i=0;i<QLinterface.ifOnline.size();i++) {
				QLinterface.l.add( "(" +QLinterface.acc.get(i) + QLinterface.ifOnline.get(i) + ")"+QLinterface.name.get(i));
	        }
			
			QLinterface.friends.add(QLinterface.l);
			QLinterface.friends.repaint();
			
		}
		
		// 接收 主界面 返回 昵称消息 - visi|(s -> c)
		private void mainReturnNews() {
			System.out.println("主界面 回包2");
//			dealmainReturnNews();
		}
		
		// Time
		private String time() {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datetime = sdf.format(c.getTime());
			return datetime;
		}
		
		
		// 拆接收 mainReturnFriends 的包 @符号
		private void dealmainReturnFriends() {
			for(int i=0;i<l.content.size();i++) {
				int flag = 0;
				System.out.println(l.content.get(i));
				QLinterface.acc.add(l.content.get(i).substring(0,2));
				for(int j=3;j<l.content.get(i).length();j++) {
					if(l.content.get(i).charAt(j) == '@') {
						QLinterface.acc.add(l.content.get(i).substring(3,j));
						flag = j+1;
						QLinterface.acc.add(l.content.get(i).substring(j,l.content.get(i).length()));
						//System.out.println(QLinterface.ifOnline.get(i));
						break;
					}
//					if(l.content.get(i).charAt(j) == '@') {
//						QLinterface.friendAccount[i] = l.content.get(i).substring(flag,j);
//						QLinterface.friendName[i] = l.content.get(i).substring(j+1,l.content.get(i).length());
//						System.out.println(QLinterface.friendAccount[i]);
//						System.out.println(QLinterface.friendName[i]);
//					}
				}
			}
		}
		
		// 拆接收 mainReturnNews 的包 @符号
		private void dealmainReturnNews() {
			for(int i=0;i<l.content.size();i++) {
				int flag = 0;
				for(int j=0;j<l.content.get(i).length();j++) {
					if(l.content.get(i).charAt(j) == '@') {
						flag = j;
						QLinterface.whoSendMe[QLinterface.noHaveRead] = l.content.get(i).substring(0,flag);
						QLinterface.whatSendMe[QLinterface.noHaveRead] = l.content.get(i).substring(flag+1,l.content.get(i).length());
						System.out.println(QLinterface.whoSendMe + " " + QLinterface.whatSendMe);
					}
				}
				QLinterface.noHaveRead++;
				
			}
		}
		
}
