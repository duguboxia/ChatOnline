package eg;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Affari {
	
	/*************************************************************
	 * 		
	 * 		事务类
	 * 		
	 * 		作者：  张文
	 * 		时间：  2019.1.5
	 * 		版本: 1.0
	 * 
	 * 		用于记录服务器该处理的事务信息。
	 * 
	 * **********************************************************/
	
	
	/***
	 * 		该条命令来至
	 * */
	
	public String from;
	public String to;
	public String affari;
	public PrintWriter clientsOut;
	public List<String> content = new ArrayList<String>();
	public Socket client = null;
	
 	public Affari(String from, String to,String affari,PrintWriter out){
		
		this.from = from;
		this.to = to;
		this.clientsOut = out;
		this.affari = affari;
		
	}
	
	public Affari(){}
	
	public void addContent(String str){
		content.add(str);
	}

	public void submit(){
		
		ServerFrame.affariList.add(this);
	}
}
