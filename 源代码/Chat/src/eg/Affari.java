package eg;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Affari {
	
	/*************************************************************
	 * 		
	 * 		������
	 * 		
	 * 		���ߣ�  ����
	 * 		ʱ�䣺  2019.1.5
	 * 		�汾: 1.0
	 * 
	 * 		���ڼ�¼�������ô����������Ϣ��
	 * 
	 * **********************************************************/
	
	
	/***
	 * 		������������
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
