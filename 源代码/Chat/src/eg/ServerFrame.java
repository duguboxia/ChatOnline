package eg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ChatServerDatabase.*;
import UI.ChatServer;
import eg.TListenerLink;


public class ServerFrame {

	
	/***********************************************************
	 * 		
	 * 		����� ��̨�봰�ڵĶԽ�
	 *		
	 *		�ԡ�����
	 *
	 *		1.0
	 *
	 ***********************************************************/
	
	TListenerLink tll = null;
	MessageDeal md = null;
	ChatServer cs = new ChatServer();
	
	public static StringBuffer str = null;
	public static volatile ArrayList<PrintWriter> clients = new ArrayList<PrintWriter>();;
	public static volatile ArrayList<String> accounts = new ArrayList<String>();
	public static volatile Queue<Affari> affariList = new LinkedList<Affari>();
	public static ExecutorService ets = Executors.newCachedThreadPool();
	public static ExecutorService massage = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerFrame serverFrame = new ServerFrame();
		LinkDataBase.Link();
		LinkDataBase.getStatement();
	}
	
	public ServerFrame(){

		cs.setVisible(true);
		addEvent();
	}
	
	// Ϊ��� ��ť ����¼�
	private void addEvent(){
		
		// ����������ť , ����˿�ʼ��ת��
		cs.jbt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				tll = new TListenerLink();
				md = new MessageDeal();
				LinkDataBase.modifyUserVisiAll();
				tll.start();
				md.start();
				cs.jbt1.setEnabled(false);
			}
		});
		
		// ���� ֹͣ��ť , ����˹رա�
		cs.jbt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
				try {
					tll.server.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tll.stop();
				md.stop();
				try {
					ets.awaitTermination(1,TimeUnit.MILLISECONDS);
					massage.awaitTermination(1, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cs.jbt1.setEnabled(true);
				ChatServer.addText("server �ѹر�");
			}
		});
		
		
	} 

	public static void addText(StringBuffer str){
		str.append(str);
	}
}
