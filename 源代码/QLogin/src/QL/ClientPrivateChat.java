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
	
	public JTextArea areaSend = new JTextArea();//发送框
	public JTextArea areaChat = new JTextArea();
	private  int windowWidth = 700;//窗口宽
	private  int windowHeight = 500;//窗口高
	String user = "123";
	String Num = "123";
	
	public ClientPrivateChat() {
		
				//设置标题
				this.setTitle("与"+user+"("+Num+")"+"聊天中...");
				this.setFont(new Font("微软雅黑",Font.PLAIN,12));
				//设置窗口大小
				this.setSize(windowWidth, windowHeight);
				//设置是否可以关闭窗口
				this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				//设置默认居中
				this.setLocationRelativeTo(null);
				//设置窗口是否可以改变窗口大小
				this.setResizable(false);
			
				//设置布局管理器 为边界布局管理器
				BorderLayout bl = new BorderLayout();
				this.setLayout(bl);		

				
				//顶部面板 显示用户的信息等等
				JPanel jpInfor = new JPanel();
				jpInfor.setBackground(Color.blue);
				jpInfor.setPreferredSize(new Dimension(700,100));
				this.add(jpInfor, BorderLayout.NORTH);//北
				jpInfor.setLayout(null);//将用户信息面板的布局管理器设置为空
				
				JLabel jlUser = new JLabel(user+"("+Num+")");
				jlUser.setFont(new Font("微软雅黑",Font.PLAIN,20));
				jlUser.setBounds(100,40,250,50);
				jpInfor.add(jlUser);
				
				//	//头像图片
				ImageIcon headPic = new ImageIcon("/images/pic1.gif");
				headPic.setImage(headPic.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT ));
				
				//头像标签
				JLabel jlAvatar = new JLabel(headPic);
				jpInfor.setLayout(null);
				jlAvatar.setBounds(10, 10, 80, 80);
				jpInfor.add(jlAvatar);	
				
				String signature = "这是签名";
				JLabel jlSignature = new JLabel(signature);
				jlSignature.setFont(new Font("微软雅黑",Font.PLAIN,12));
				jlSignature.setBounds(100,20,250,20);
				jpInfor.add(jlSignature);
				
				
				//聊天框
				areaChat.setPreferredSize(new Dimension(500,300));
				areaChat.setLineWrap(true);//聊天消息框自动换行
				areaChat.setEditable(false);//聊天框不可编辑，只用来显示
				this.add(areaChat,BorderLayout.WEST);//西
				
				//创建聊天消息框的滚动窗
				JScrollPane jspChat = new JScrollPane(areaChat);
		       //设置滚动窗的水平滚动条属性:不出现
		        jspChat.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		        //设置滚动窗的垂直滚动条属性:需要时自动出现
		        jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		        this.add(jspChat);
		        
		        
		        
		        
		        
		      //不知道什么面板
				JPanel jpList = new JPanel();
				jpList.setBorder(BorderFactory.createRaisedBevelBorder());
				jpList.setPreferredSize(new Dimension(200,300));//面板宽高
				this.add(jpList,BorderLayout.EAST);//东
				
				//图片秀
				ImageIcon Pic = new ImageIcon("/images/image1.gif");
				Pic.setImage(Pic.getImage().getScaledInstance(180, 250,Image.SCALE_DEFAULT ));
				//图片秀标签
				JLabel jlImages = new JLabel(Pic);
				jpList.setLayout(null);
				jlImages.setBounds(10, 10, 180, 250);
				jpList.add(jlImages);
	
				
				
				
				//组合边框
//				Border b1 = BorderFactory.createLineBorder(Color.blue, 2);
//				Border b2 = BorderFactory.createEtchedBorder();
//				jpSend.setBorder(BorderFactory.createCompoundBorder(b1, b2));
				//发送框
				areaSend.setPreferredSize(new Dimension(700,100));
				this.add(areaSend, BorderLayout.SOUTH);//南
				
				//发送按钮
				JButton buttonSend = new JButton("发送");
				areaSend.setLayout(null);
				buttonSend.setBounds(620, 50, 60, 30);
				buttonSend.setBackground(Color.blue);
				buttonSend.setFont(new Font("微软雅黑",Font.PLAIN,12));
				areaSend.add(buttonSend);
				
				//发送按钮单击事件
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
