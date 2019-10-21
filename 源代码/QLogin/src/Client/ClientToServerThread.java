package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Client.Affari;
import Client.OrderType;

public class ClientToServerThread extends Thread{
	
	private volatile boolean exit = false;
	public  int tag; // 标识符
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String str;
	private String orderV;
	private Affari affari = null;
	
	public ClientToServerThread(int tag) {
		this.tag = tag;
		try {
			//获取输入输出对象
			out = new PrintWriter(QLmain.socket.getOutputStream(),true); // 客户端写给服务器
			in = new BufferedReader(new InputStreamReader(QLmain.socket.getInputStream())); // 服务器输出给客户端
		} catch (IOException e) {
			System.out.println("链接服务器出错");
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println(tag);
		while(!exit){
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(!getNextClientOrder()){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//裁决   审判  
			selectOrder(orderV,str);
			System.out.println(orderV +"   " + str);
		}
	}
	
	// 给出下一条指令
		private boolean getNextClientOrder(){
			
			try {
//				System.out.println("接收中");
				if(in.ready()){
					System.out.println("发来请求");
					Thread.sleep(1);
					str = in.readLine();
//					System.out.println(str);
					orderV = str.substring(0, 3);
					str = str.substring(3, str.length());
					return true;
				}	
			} catch (IOException  e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		/*
		 * 
		 *			  前方一大波方法来袭
		 *
		 */
		
		// 一句事务的开始 begin
		private boolean setBegine(){

			affari = new Affari();
			return true;
		}
		
		// 一句事务的结束(提交) submit
		private boolean submit(){
			
			if (affari == null){
				return false;
			}else{
				setclientsOut();
				affari.submit();
				affari = null;
				return true;
			}
		}
		
		// to 发送给谁
		private boolean setTo(String account){
			
			if(affari == null){
				return false;
			}else{
				affari.to = account;
				return true;
			}
		}
		
		// from 来自谁
		private boolean setFrom(String from){
			
			if(affari == null){
				return false;
			}else{
				affari.from = from;
				return true;
			}
		}
		
		// 添加内容
		private boolean addContent(String content){
			
			if(affari == null){
				return false;
			}else{
				affari.addContent(content);
				return true;
			}
		}

		// c -> s 输出
		private boolean setclientsOut(){
			
			if(affari == null){
				return false;
			}else{
				affari.pw = this.out;
				return true;
			}
		}
		
		// ?
		private boolean setAffariType(String affari){
			
			if(this.affari == null){
				return false;
			}else{
				this.affari.affari = affari;
				return true;
			}
		}
		
		
		/* 重要  接收 */
	 	private void selectOrder(String order, String str){
			
			if(order.equals(OrderType.BEGINE.orderValue)){
				this.setBegine();
			}else if(order.equals(OrderType.SUBMIT.orderValue)){
				this.submit();
			}else if(order.equals(OrderType.SETAFFARI.orderValue)){
				setAffariType(str);
			}else if(order.equals(OrderType.SETACCOUNT.orderValue)){
				this.addContent(str);
			}else if(order.equals(OrderType.SETPASSWORD.orderValue)){
				this.addContent(str);
			}else if(order.equals(OrderType.SETFROM.orderValue)){
				this.setFrom(str);
			}else if(order.equals(OrderType.SETTO.orderValue)){
				this.setTo(str);
			}else if(order.equals(OrderType.SETCONTENT.orderValue)){
				this.addContent(str);
			}
			
		}
}
