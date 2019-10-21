package eg;

import java.net.*;
import java.io.*;
import java.util.*;

import UI.ChatServer;
import eg.ServerFrame;

/*************************************************
 * 		����˼��� �������� �߳�
 * 		
 * 		��....
 * 
 *************************************************/

public class TListenerLink extends Thread{

	private int port = 2233;// �˿�
	public ServerSocket server;// �������׽���
	
	public TListenerLink() {
		
		port = Integer.parseInt(ChatServer.jtf2.getText());
		try {
			ServerFrame.clients = new ArrayList<PrintWriter>();// �ͻ�������
			server = new ServerSocket(port);
			ChatServer.addText("server �����ɹ�");
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
