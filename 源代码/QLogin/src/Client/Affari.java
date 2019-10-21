package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Client.QLmain;;

public class Affari {
	/*************************************************************
	 * 		
	 * 		事务类
	 * 		
	 * 		作者：  李宇蔚
	 * 		时间：  2019.1.8
	 * 		版本: 1.0
	 * 
	 * 		用于记录客户端处理来自服务器的事务信息。
	 * 
	 * **********************************************************/
	
	public String from; // 来自
	public String to; // 传送给
	public String affari; // 事件类型
	public PrintWriter pw; 
	public List<String> content = new ArrayList<String>(); // 事件内容
	
	public Affari(String from, String to,String affari,PrintWriter out){
		
		this.from = from;
		this.to = to;
		this.pw = out;
		this.affari = affari;
		
	}
	
	public Affari() {}
	
	public void addContent(String str) {
		content.add(str); // 增加内容
	}
	
	public void submit(){ // 提交事务 **
		
		QLmain.affariList.add(this);
	}
}
