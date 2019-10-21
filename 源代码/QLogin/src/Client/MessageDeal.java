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
	
	//����ģ��
		private void executeAffari(){
			
			if(QLmain.affariList.isEmpty()){
//				System.out.println("�ȴ�ing......");
				return;
			}
			l = QLmain.affariList.poll();
			
			if( // ��¼ģ��
					l.affari.equals(OrderType.LOADSUCCESS.orderValue) || 
					l.affari.equals(OrderType.LOADERROR1.orderValue) || 
					l.affari.equals(OrderType.LOADERROR2.orderValue) ||
					l.affari.equals(OrderType.LOADERROR3.orderValue)){
				
				System.out.println("��¼ģ���");
				executeLoad();
			}else if( // ע��ģ��
					l.affari.equals(OrderType.REGISTERSUCCESS.orderValue) || 
					l.affari.equals(OrderType.REGISTERERROR.orderValue)){
				
				System.out.println("ע��ģ���");
				exeuteRegister();
			}else if(l.affari.equals(OrderType.GETMESSAGE.orderValue)) {
				System.out.println("ת����Ϣ");
				if(l.to.equals("all")) {
					ReceiveMessageGroup();
				}else {
					ReceiveMessagePrivate();
				}
			}else if(l.affari.equals(OrderType.MIANRETURNFRIENDS.orderValue)) { //������ ���� �ǳ�|�����б� - ����״̬|(s -> c)
				
				mainReturnFriends();
				QLinterface.a();
				
			}else if(l.affari.equals(OrderType.MIANRETURNNEWS.orderValue)) { //������ ���� �ǳ���Ϣ - visi|(s -> c)
				
				mainReturnNews();
				
			}
			
			l = null;
				
		}
		
		// �ظ������� (c -> s)
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
		
		//	ע���ж�
		private void exeuteRegister(){
			
			if(l.affari.equals(OrderType.REGISTERSUCCESS.orderValue)){
				System.out.println("ע��ɹ�");
				JOptionPane.showMessageDialog(QLogin.contentRTPane, "ע��ɹ�,��������¼��", "��ʾ��",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
//				QLogin.contentRTPane.dispose();
			}else if(l.affari.equals(OrderType.REGISTERERROR.orderValue)){
				System.out.println("ע��ʧ�ܣ��˺��ظ�");
				JOptionPane.showMessageDialog(QLogin.contentRTPane, "ע��ʧ�� -- �˺��ѱ�ע��", "��ʾ��",JOptionPane.WARNING_MESSAGE);  
			}else{
				System.out.println("ע���ж�δ֪����:" + l.affari);
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "δ֪����,����ϵ����Ա", "��ʾ��",JOptionPane.WARNING_MESSAGE);
			}
			returnAffari();
		}
		
		//	��¼�ж�
		private void executeLoad(){
			if(l.affari.equals(OrderType.LOADSUCCESS.orderValue)) {
					System.out.println("��¼�ɹ�");
					QLinterface mainInterface = new QLinterface();
					mainInterface.setVisible(true); 
					
					QLmain.QL.setVisible(false);
				
			}else if(l.affari.equals(OrderType.LOADERROR1.orderValue)) {
				System.out.println("��½ʧ��:�˻�������");
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "��¼ʧ�� -- �˻�������", "��ʾ��",JOptionPane.WARNING_MESSAGE);  
				System.exit(0);
			}else if(l.affari.equals(OrderType.LOADERROR2.orderValue)) {
				System.out.println("��½ʧ��:�������");
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "��¼ʧ�� -- �������", "��ʾ��",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}else if(l.affari.equals(OrderType.LOADERROR3.orderValue)) {
				System.out.println("��½ʧ��:�ظ���¼");
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "��¼ʧ�� -- �ظ���¼", "��ʾ��",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}else {
				System.out.println("��¼�ж�δ֪����:" + l.affari);
				JOptionPane.showMessageDialog(QLogin.contentLGPane, "δ֪����,����ϵ����Ա", "��ʾ��",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		// ���� content
		private String andContent(List<String> content){
			
			StringBuffer str = new StringBuffer();
			for(int index = 0; index < content.size(); index++){
				str.append(content.get(index));
			}
			return str.substring(0);
		}
		
		//	ת����Ϣ Ⱥ��
		private void ReceiveMessageGroup() {
			
			String msg;
			msg = this.andContent(l.content);
			try {
					QLmain.GroupChat.jtaChat.append("����ˮ��" + " " + QLmain.account + "  " + time() + "\n" + msg + "\n\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
//		ת����Ϣ ˽��
		private void ReceiveMessagePrivate() {
				
				String msg;
				msg = this.andContent(l.content);
				try {
						QLmain.PrivateChat.areaChat.append("��1����" + " " + QLmain.account + "  " + time() + "\n" + msg + "\n\n");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		// ���� ������ ���� �ǳ�|�����б� - ����״̬|(s -> c)
		private void mainReturnFriends() {
			System.out.println("������ �ذ�1");
			dealmainReturnFriends();
			
			for(int i=0;i<QLinterface.ifOnline.size();i++) {
				QLinterface.l.add( "(" +QLinterface.acc.get(i) + QLinterface.ifOnline.get(i) + ")"+QLinterface.name.get(i));
	        }
			
			QLinterface.friends.add(QLinterface.l);
			QLinterface.friends.repaint();
			
		}
		
		// ���� ������ ���� �ǳ���Ϣ - visi|(s -> c)
		private void mainReturnNews() {
			System.out.println("������ �ذ�2");
//			dealmainReturnNews();
		}
		
		// Time
		private String time() {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datetime = sdf.format(c.getTime());
			return datetime;
		}
		
		
		// ����� mainReturnFriends �İ� @����
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
		
		// ����� mainReturnNews �İ� @����
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
