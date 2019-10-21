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
	
	
	private  int windowWidth = 700;//���ڿ�
	private  int windowHeight = 500;//���ڸ�
	public JTextArea jtaSend = new JTextArea();
	public JTextArea jtaChat = new JTextArea();
	
	public ClientGroupChatFrame() {
		
		//���ڱ���
		this.setTitle("������");
		//���ڴ�С
		this.setSize(windowWidth, windowHeight);
		//�ر�
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//���ھ���
		this.setLocationRelativeTo(null);
		//���ڴ�С���ɸı�
		this.setResizable(false);
		
		//ָ�����ֹ�����
		this.setLayout(new BorderLayout());
		
		//������
		JPanel jpRoom = new JPanel();
		jpRoom.setBackground(Color.blue);
		jpRoom.setPreferredSize(new Dimension(700,50));
		this.add(jpRoom, BorderLayout.NORTH);//��
		
		JLabel jlRoom = new JLabel("������");
		jlRoom.setFont(new Font("΢���ź�",Font.PLAIN,24));
		jpRoom.setLayout(null);
		jlRoom.setBounds(30, 10, 200, 30);
		jpRoom.add(jlRoom);
		
		//�������
		JPanel jpChat = new JPanel();
		//jpChat.setBackground(Color.YELLOW);
		jpChat.setPreferredSize(new Dimension(700,500));
		this.add(jpChat, BorderLayout.CENTER);//��
		
		//��������
		jtaChat.setBounds(50, 100, 450, 300);
		this.add(jtaChat);
		//������Ϣ���Զ�����
		jtaChat.setLineWrap(true);
		//����򲻿ɱ༭��ֻ������ʾ
		jtaChat.setEditable(false);
		//����������Ϣ��Ĺ�����
		JScrollPane jspChat = new JScrollPane(jtaChat);
		 //���ù�������С��λ��
        jspChat.setBounds(50, 100, 450, 300);
		//���ù�������ˮƽ����������:������
		jspChat.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 //���ù������Ĵ�ֱ����������:��Ҫʱ�Զ�����
		 jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 //������촰�ڵĹ�����
		 this.add(jspChat);
		
		//����
		JPanel jpSend = new JPanel();
		jpSend.setBackground(Color.blue);
		jpSend.setPreferredSize(new Dimension(700,150));
		this.add(jpSend, BorderLayout.SOUTH);//��	
		
		//���Ϳ�
		jpSend.setLayout(null);
		jtaSend.setBounds(0, 0, 700, 150);
		jtaSend.setLineWrap(true);//�Զ�����
		jpSend.add(jtaSend);
		//���Ͱ�ť
		JButton jbSend = new JButton("����");
		jbSend.setFont(new Font("΢���ź�",Font.PLAIN,12));
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
