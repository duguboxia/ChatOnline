package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Client.QLmain;;

public class Affari {
	/*************************************************************
	 * 		
	 * 		������
	 * 		
	 * 		���ߣ�  ����ε
	 * 		ʱ�䣺  2019.1.8
	 * 		�汾: 1.0
	 * 
	 * 		���ڼ�¼�ͻ��˴������Է�������������Ϣ��
	 * 
	 * **********************************************************/
	
	public String from; // ����
	public String to; // ���͸�
	public String affari; // �¼�����
	public PrintWriter pw; 
	public List<String> content = new ArrayList<String>(); // �¼�����
	
	public Affari(String from, String to,String affari,PrintWriter out){
		
		this.from = from;
		this.to = to;
		this.pw = out;
		this.affari = affari;
		
	}
	
	public Affari() {}
	
	public void addContent(String str) {
		content.add(str); // ��������
	}
	
	public void submit(){ // �ύ���� **
		
		QLmain.affariList.add(this);
	}
}
