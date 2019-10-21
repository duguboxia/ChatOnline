package eg;

import java.net.*;
import java.io.*;
import java.util.*;

import UI.ChatServer;
import eg.ServerFrame;

/*************************************************
 * 		服务端监听 连接请求 线程
 * 		
 * 		略....
 * 
 *************************************************/

public class TListenerLink extends Thread{

	private int port = 2233;// 端口
	public ServerSocket server;// 服务器套接字
	
	public TListenerLink() {
		
		port = Integer.parseInt(ChatServer.jtf2.getText());
		try {
			ServerFrame.clients = new ArrayList<PrintWriter>();// 客户端数组
			server = new ServerSocket(port);
			ChatServer.addText("server 创建成功");
		} catch (Exception e) {
			ChatServer.addText("public Server run error!");
		}
	}

	public void run(){
		
		while(true){
			try {
				Thread.sleep(100);
				Socket client = this.server.accept();
				ServerFrame.ets.execute(new ServiceToClientThread(client,0));
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
	
}
