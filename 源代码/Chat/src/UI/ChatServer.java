package UI;

import java.awt.Color;
import java.awt.Container;

import java.awt.Font;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;


public class ChatServer extends JFrame{
	
	//��������
	public JButton jbt1;
	public JButton jbt2;
	public JTextField jtf1;
	public static JTextArea jta;
	public static JTextField jtf2;
	public JTable jte;
	public JScrollPane jsp1;//��������
	public JScrollPane jsp2;//�ı��������
	public JLabel jl1;
	public JLabel jl2;
	
	public ChatServer() {
		
		this.setTitle("����-�����");//������
		this.setSize(800, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);//��������
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c=this.getContentPane();//�������
		c.setBackground(Color.green);//���ñ���
		c.setLayout(null);
		
		//����������������͡�ֹͣ��ť��
		jbt1=new JButton("����");
		jbt1.setBounds(50, 200, 100, 50);
		jbt1.setFont(new Font("΢���ź�",Font.BOLD,14));
		c.add(jbt1);
		jbt2=new JButton("ֹͣ");
		jbt2.setBounds(250, 200, 100, 50);
		jbt2.setFont(new Font("΢���ź�",Font.BOLD,14));
		c.add(jbt2);
		
		//��������JLabel���
		try {
			ServerSocket server = new ServerSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jl1=new JLabel("������IP��ַ��");
		jl1.setBounds(50,10,150,100);
		jl1.setFont(new Font("����",Font.BOLD,14));
		c.add(jl1);
		jtf1=new JTextField();
		jtf1.setBounds(150,50,200,20);
		try {
			jtf1.setText(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(jtf1);
	
		jl2=new JLabel("�������Ķ˿�:");
		jl2.setBounds(50,50,150,100);
		jl2.setFont(new Font("����",Font.BOLD,14));
		c.add(jl2);
		jtf2=new JTextField();
		jtf2.setBounds(150,90,200,20);
		jtf2.setText("2233");
		c.add(jtf2);
		
		//���������ı��򲢼��������
		jsp2=new JScrollPane(jta);
		jta=new JTextArea();
		jsp2.setBounds(390,10,360,250);
		c.add(jsp2);
		jta.setBounds(390,10,360,250);
		//�Զ�����
		jta.setLineWrap(true);
		jta.setSelectionEnd(jta.getText().length()-1);
		jsp2.setViewportView(jta);
		
	}
	
	public static void addText(String str){
		jta.append(str+"\n");
		jta.setSelectionEnd(jta.getText().length()-1);
	}
}
