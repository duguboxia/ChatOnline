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
	
	//声明变量
	public JButton jbt1;
	public JButton jbt2;
	public JTextField jtf1;
	public static JTextArea jta;
	public static JTextField jtf2;
	public JTable jte;
	public JScrollPane jsp1;//表格滚动条
	public JScrollPane jsp2;//文本框滚动条
	public JLabel jl1;
	public JLabel jl2;
	
	public ChatServer() {
		
		this.setTitle("聊天-服务端");//窗口名
		this.setSize(800, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);//不可拉动
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c=this.getContentPane();//创建面板
		c.setBackground(Color.green);//设置背景
		c.setLayout(null);
		
		//设置组件“启动”和“停止按钮”
		jbt1=new JButton("启动");
		jbt1.setBounds(50, 200, 100, 50);
		jbt1.setFont(new Font("微软雅黑",Font.BOLD,14));
		c.add(jbt1);
		jbt2=new JButton("停止");
		jbt2.setBounds(250, 200, 100, 50);
		jbt2.setFont(new Font("微软雅黑",Font.BOLD,14));
		c.add(jbt2);
		
		//设置两个JLabel组件
		try {
			ServerSocket server = new ServerSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jl1=new JLabel("服务器IP地址：");
		jl1.setBounds(50,10,150,100);
		jl1.setFont(new Font("黑体",Font.BOLD,14));
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
	
		jl2=new JLabel("服务器的端口:");
		jl2.setBounds(50,50,150,100);
		jl2.setFont(new Font("黑体",Font.BOLD,14));
		c.add(jl2);
		jtf2=new JTextField();
		jtf2.setBounds(150,90,200,20);
		jtf2.setText("2233");
		c.add(jtf2);
		
		//创建多行文本框并加入滚动条
		jsp2=new JScrollPane(jta);
		jta=new JTextArea();
		jsp2.setBounds(390,10,360,250);
		c.add(jsp2);
		jta.setBounds(390,10,360,250);
		//自动换行
		jta.setLineWrap(true);
		jta.setSelectionEnd(jta.getText().length()-1);
		jsp2.setViewportView(jta);
		
	}
	
	public static void addText(String str){
		jta.append(str+"\n");
		jta.setSelectionEnd(jta.getText().length()-1);
	}
}
