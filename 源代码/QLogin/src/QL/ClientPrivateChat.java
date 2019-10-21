package QL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Client.QLmain;
import Client.SendMessagePrivate;

public class ClientPrivateChat extends JFrame{
	
	public JTextArea areaSend = new JTextArea();//���Ϳ�
	public JTextArea areaChat = new JTextArea();
	private  int windowWidth = 700;//���ڿ�
	private  int windowHeight = 500;//���ڸ�
	String user = "123";
	String Num = "123";
	
	public ClientPrivateChat() {
		
				//���ñ���
				this.setTitle("��"+user+"("+Num+")"+"������...");
				this.setFont(new Font("΢���ź�",Font.PLAIN,12));
				//���ô��ڴ�С
				this.setSize(windowWidth, windowHeight);
				//�����Ƿ���Թرմ���
				this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				//����Ĭ�Ͼ���
				this.setLocationRelativeTo(null);
				//���ô����Ƿ���Ըı䴰�ڴ�С
				this.setResizable(false);
			
				//���ò��ֹ����� Ϊ�߽粼�ֹ�����
				BorderLayout bl = new BorderLayout();
				this.setLayout(bl);		

				
				//������� ��ʾ�û�����Ϣ�ȵ�
				JPanel jpInfor = new JPanel();
				jpInfor.setBackground(Color.blue);
				jpInfor.setPreferredSize(new Dimension(700,100));
				this.add(jpInfor, BorderLayout.NORTH);//��
				jpInfor.setLayout(null);//���û���Ϣ���Ĳ��ֹ���������Ϊ��
				
				JLabel jlUser = new JLabel(user+"("+Num+")");
				jlUser.setFont(new Font("΢���ź�",Font.PLAIN,20));
				jlUser.setBounds(100,40,250,50);
				jpInfor.add(jlUser);
				
				//	//ͷ��ͼƬ
				ImageIcon headPic = new ImageIcon("/images/pic1.gif");
				headPic.setImage(headPic.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT ));
				
				//ͷ���ǩ
				JLabel jlAvatar = new JLabel(headPic);
				jpInfor.setLayout(null);
				jlAvatar.setBounds(10, 10, 80, 80);
				jpInfor.add(jlAvatar);	
				
				String signature = "����ǩ��";
				JLabel jlSignature = new JLabel(signature);
				jlSignature.setFont(new Font("΢���ź�",Font.PLAIN,12));
				jlSignature.setBounds(100,20,250,20);
				jpInfor.add(jlSignature);
				
				
				//�����
				areaChat.setPreferredSize(new Dimension(500,300));
				areaChat.setLineWrap(true);//������Ϣ���Զ�����
				areaChat.setEditable(false);//����򲻿ɱ༭��ֻ������ʾ
				this.add(areaChat,BorderLayout.WEST);//��
				
				//����������Ϣ��Ĺ�����
				JScrollPane jspChat = new JScrollPane(areaChat);
		       //���ù�������ˮƽ����������:������
		        jspChat.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		        //���ù������Ĵ�ֱ����������:��Ҫʱ�Զ�����
		        jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		        this.add(jspChat);
		        
		        
		        
		        
		        
		      //��֪��ʲô���
				JPanel jpList = new JPanel();
				jpList.setBorder(BorderFactory.createRaisedBevelBorder());
				jpList.setPreferredSize(new Dimension(200,300));//�����
				this.add(jpList,BorderLayout.EAST);//��
				
				//ͼƬ��
				ImageIcon Pic = new ImageIcon("/images/image1.gif");
				Pic.setImage(Pic.getImage().getScaledInstance(180, 250,Image.SCALE_DEFAULT ));
				//ͼƬ���ǩ
				JLabel jlImages = new JLabel(Pic);
				jpList.setLayout(null);
				jlImages.setBounds(10, 10, 180, 250);
				jpList.add(jlImages);
	
				
				
				
				//��ϱ߿�
//				Border b1 = BorderFactory.createLineBorder(Color.blue, 2);
//				Border b2 = BorderFactory.createEtchedBorder();
//				jpSend.setBorder(BorderFactory.createCompoundBorder(b1, b2));
				//���Ϳ�
				areaSend.setPreferredSize(new Dimension(700,100));
				this.add(areaSend, BorderLayout.SOUTH);//��
				
				//���Ͱ�ť
				JButton buttonSend = new JButton("����");
				areaSend.setLayout(null);
				buttonSend.setBounds(620, 50, 60, 30);
				buttonSend.setBackground(Color.blue);
				buttonSend.setFont(new Font("΢���ź�",Font.PLAIN,12));
				areaSend.add(buttonSend);
				
				//���Ͱ�ť�����¼�
				buttonSend.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SendMessagePrivate smsp = new SendMessagePrivate();
						smsp.send();
						QLmain.PrivateChat.areaChat.append(QLmain.PrivateChat.areaSend.getText().toString() + "\n");
						areaSend.setText("");
					}
				});
				
				
				
				
				
		
	}
	
	
	
}
