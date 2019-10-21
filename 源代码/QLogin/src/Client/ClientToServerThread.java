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
	public  int tag; // ��ʶ��
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String str;
	private String orderV;
	private Affari affari = null;
	
	public ClientToServerThread(int tag) {
		this.tag = tag;
		try {
			//��ȡ�����������
			out = new PrintWriter(QLmain.socket.getOutputStream(),true); // �ͻ���д��������
			in = new BufferedReader(new InputStreamReader(QLmain.socket.getInputStream())); // ������������ͻ���
		} catch (IOException e) {
			System.out.println("���ӷ���������");
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
			//�þ�   ����  
			selectOrder(orderV,str);
			System.out.println(orderV +"   " + str);
		}
	}
	
	// ������һ��ָ��
		private boolean getNextClientOrder(){
			
			try {
//				System.out.println("������");
				if(in.ready()){
					System.out.println("��������");
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
		 *			  ǰ��һ�󲨷�����Ϯ
		 *
		 */
		
		// һ������Ŀ�ʼ begin
		private boolean setBegine(){

			affari = new Affari();
			return true;
		}
		
		// һ������Ľ���(�ύ) submit
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
		
		// to ���͸�˭
		private boolean setTo(String account){
			
			if(affari == null){
				return false;
			}else{
				affari.to = account;
				return true;
			}
		}
		
		// from ����˭
		private boolean setFrom(String from){
			
			if(affari == null){
				return false;
			}else{
				affari.from = from;
				return true;
			}
		}
		
		// �������
		private boolean addContent(String content){
			
			if(affari == null){
				return false;
			}else{
				affari.addContent(content);
				return true;
			}
		}

		// c -> s ���
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
		
		
		/* ��Ҫ  ���� */
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
