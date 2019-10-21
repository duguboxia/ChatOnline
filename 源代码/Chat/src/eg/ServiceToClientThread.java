package eg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import UI.ChatServer;

import ChatServerDatabase.LinkDataBase;
import eg.OrderType;


public class ServiceToClientThread implements Runnable{
	
	private volatile boolean exit = false;
	public  int tag, update = -1000; // 标识符
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String str;
	private String orderV;
	private Affari affari = null;
	private Socket client;
	
	public ServiceToClientThread(Socket client,int tag){
		
		this.client = client;
		this.tag = tag;
		try {
			//获取输入输出对象
			out = new PrintWriter(client.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));	
		} catch (IOException e) {
			ChatServer.addText("链接服务器出错");
			e.printStackTrace();
		}
	}
	
	public void run(){
		
		ChatServer.addText(tag + "");
		while(!exit){
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(!getNextClientOrder()){
				try {
					Thread.sleep(10);
					if(update >= 400){
						forceDownLine();
					}else{
						update++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(update >= 400){
				forceDownLine();
			}else{
				update++;
			}
			//裁决   审判  
			selectOrder(orderV,str);
			if(!orderV.equals("888"))
				ChatServer.addText(orderV +"   " + str);
		}
	}
	
	// 给出下一条指令
	private boolean getNextClientOrder(){
		
		try {
			
			if(in.ready()){
				//ChatServer.addText("发来请求");
				Thread.sleep(25);
				str = in.readLine();
				//ChatServer.addText(str);
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
	
	
	/*********************************************************
	 * 
	 * 		对于下面方法  有新封装一个类的打算。。。。。
	 * 
	 *********************************************************/

	private boolean setBegine(){

		affari = new Affari();
		return true;
	}
	
	private boolean submit(){
		
		if (affari == null){
			return false;
		}else{
			setclientsOut();
			affari.clientsOut = out;
			affari.submit();
			affari = null;
			return true;
		}
	}

	private boolean setTo(String account){
		
		if(affari == null){
			return false;
		}else{
			affari.to = account;
			return true;
		}
	}
	
	private boolean setFrom(String from){
		
		if(affari == null){
			return false;
		}else{
			affari.from = from;
			return true;
		}
	}
	
	private boolean addContent(String content){
		
		if(affari == null){
			return false;
		}else{
			affari.addContent(content);
			return true;
		}
	}

	private boolean setclientsOut(){
		
		if(affari == null){
			return false;
		}else{
			affari.clientsOut = this.out;
			return true;
		}
	}

	private boolean setAffariType(String affari){
		
		if(this.affari == null){
			return false;
		}else{
			this.affari.affari = affari;
			return true;
		}
	}
	
	/* 重要 */
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
		}else if(order.equals(OrderType.UPDATE.orderValue)){
			System.out.println("update " + client.getInetAddress());
			update = 0;
		}
		
	}

 	/* 强制下线 */
 	private void forceDownLine(){
 
 		//LinkDataBase.modifyUserVisiForAccount(findAccountWithOut(out), 1);
 		Affari downInlne = new Affari();
 		downInlne.affari = OrderType.DOWNLINE.orderValue;
 		downInlne.addContent("被动");
 		downInlne.from = findAccountWithOut(out);
 		if(downInlne.from != null){
 			downInlne.submit();
 			downInlne.client = this.client;
 			this.exit = true;
 		}else{
 			this.update = 0;
 		}
 		
 	}
 	
 	//更具out找账户
 	private String findAccountWithOut(PrintWriter out){
 		for(int index = 0 ; index < ServerFrame.clients.size(); index++){
 			if(ServerFrame.clients.get(index) == out){
 				return ServerFrame.accounts.get(index);
 			}
 		}
 		return null;
 	}

 	
 	
}
