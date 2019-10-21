package QL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Client.SendMessageGroup;


public class ClientGroupChatFrame extends JFrame{
	
	
	private  int windowWidth = 700;//窗口宽
	private  int windowHeight = 500;//窗口高
	public JTextArea jtaSend = new JTextArea();
	public JTextArea jtaChat = new JTextArea();
	
	public ClientGroupChatFrame() {
		
		//窗口标题
		this.setTitle("聊天室");
		//窗口大小
		this.setSize(windowWidth, windowHeight);
		//关闭
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//窗口居中
		this.setLocationRelativeTo(null);
		//窗口大小不可改变
		this.setResizable(false);
		
		//指定布局管理器
		this.setLayout(new BorderLayout());
		
		//聊天室
		JPanel jpRoom = new JPanel();
		jpRoom.setBackground(Color.blue);
		jpRoom.setPreferredSize(new Dimension(700,50));
		this.add(jpRoom, BorderLayout.NORTH);//北
		
		JLabel jlRoom = new JLabel("聊天室");
		jlRoom.setFont(new Font("微软雅黑",Font.PLAIN,24));
		jpRoom.setLayout(null);
		jlRoom.setBounds(30, 10, 200, 30);
		jpRoom.add(jlRoom);
		
		//聊天面板
		JPanel jpChat = new JPanel();
		//jpChat.setBackground(Color.YELLOW);
		jpChat.setPreferredSize(new Dimension(700,500));
		this.add(jpChat, BorderLayout.CENTER);//中
		
		//聊天界面框
		jtaChat.setBounds(50, 100, 450, 300);
		this.add(jtaChat);
		//聊天消息框自动换行
		jtaChat.setLineWrap(true);
		//聊天框不可编辑，只用来显示
		jtaChat.setEditable(false);
		//创建聊天消息框的滚动窗
		JScrollPane jspChat = new JScrollPane(jtaChat);
		 //设置滚动窗大小和位置
        jspChat.setBounds(50, 100, 450, 300);
		//设置滚动窗的水平滚动条属性:不出现
		jspChat.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 //设置滚动窗的垂直滚动条属性:需要时自动出现
		 jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 //添加聊天窗口的滚动窗
		 this.add(jspChat);
		
		//发送
		JPanel jpSend = new JPanel();
		jpSend.setBackground(Color.blue);
		jpSend.setPreferredSize(new Dimension(700,150));
		this.add(jpSend, BorderLayout.SOUTH);//南	
		
		//发送框
		jpSend.setLayout(null);
		jtaSend.setBounds(0, 0, 700, 150);
		jtaSend.setLineWrap(true);//自动换行
		jpSend.add(jtaSend);
		//发送按钮
		JButton jbSend = new JButton("发送");
		jbSend.setFont(new Font("微软雅黑",Font.PLAIN,12));
		jbSend.setBackground(Color.blue);
		jbSend.setBounds(600, 100, 60, 30);
		jtaSend.add(jbSend);
		
		jbSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SendMessageGroup().send();
				jtaSend.setText("");
			}
			
		});
		
	}
}
