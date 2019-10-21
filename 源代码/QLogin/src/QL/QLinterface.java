package QL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Client.InterfaceSend;
import Client.MessageDeal;
import Client.QLmain;
import Client.SendDownLine;

public class QLinterface extends JFrame{
	
	public static List l = new List();
	private int  windowWidth = 300;//窗口宽
	private int  windowHeight = 600;//窗口高
	public static int friendsNum = 0;
	public static int noHaveRead = 0;
	public static java.util.List<String> ifOnline = new ArrayList<String>();
	public static java.util.List<String> acc= new ArrayList<String>();
	public static java.util.List<String> name= new ArrayList<String>();
	public static String[] whoSendMe = new String[100];
	public static String[] whatSendMe = new String[100];
	public static JPanel friends = null;
	
	public QLinterface() {
		
		InterfaceSend itfs = new InterfaceSend();
		itfs.online();// 上线
		itfs.start(); // 心跳检测
		
		System.out.println("InterfaceSend 已运行");
		
		//窗口标题
		this.setTitle("登录主界面");
		//窗口大小
		this.setSize(windowWidth, windowHeight);
		//设置是否可以关闭窗口
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置默认居中
		this.setLocationRelativeTo(null);
		//设置窗口是否可以改变窗口大小
		this.setResizable(false);
		
		//指定布局管理器：边界
		this.setLayout(new BorderLayout());

		
		//用户信息面板
		JPanel jpInfor = new JPanel();
		jpInfor.setBackground(Color.pink);
		jpInfor.setPreferredSize(new Dimension(300,100));
		jpInfor.setBorder(BorderFactory.createRaisedBevelBorder());//斜面边框凸
		this.add(jpInfor, BorderLayout.NORTH);//北
	
		//头像图片
		ImageIcon headPic = new ImageIcon("res/defaultFace.png");
		headPic.setImage(headPic.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT ));
		
		//头像标签
		JLabel jlAvatar = new JLabel(headPic);
		jpInfor.setLayout(null);
		jlAvatar.setBounds(10, 10, 80, 80);
		jpInfor.add(jlAvatar);	
		
		//用户签名
		String signature = "这是一条签名";
		JLabel jlSignature = new JLabel(signature);
		jlSignature.setFont(new Font("微软雅黑",Font.PLAIN,12));
		jlSignature.setBounds(100,30,250,20);
		jpInfor.add(jlSignature);
		
		//时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 EEEE");
		String s= sdf.format(date);
		JLabel jlDate = new JLabel(s);
		jlDate.setFont(new Font("微软雅黑",Font.PLAIN,12));
		jlDate.setBounds(100, 60, 200, 20);
		jpInfor.add(jlDate);
		
		// 私聊按钮
		JButton private1 = new JButton("私聊");
		private1.setBounds(230, 50, 70, 50);
		private1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QLmain.PrivateChat.setVisible(true);
			}
			
		});
		jpInfor.add(private1);
		
		
		//选项卡面板
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.blue);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        
        //好友面板
        friends = new JPanel();
        friends.setBackground(Color.pink);
        tabbedPane.addTab("好友列表", null, friends, null);
        friends.setLayout(new GridLayout());//好友面板设置为网格布局管理器
        
        //好友列表
//        String[] name = new String[] {"小红","张文","逗逗","德令","川川"};
//        String[] num = new String[] {"978964494","486453154","78912345","52134865","12345876"};
        
        //往列表里添加好友
        
        
      
        
        
        
        
        l.setFont(new Font("微软雅黑",Font.PLAIN,16));
        //允许多选
        l.setMultipleSelections(false);
        //列表选项切换的监听
        l.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getSource());
			}
		});
       //列表行为的监听
        l.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("1");
			}
		});
        //单击事件
        l.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
         
        
        //群聊面板
        JPanel jp = new JPanel();
        jp.setBackground(Color.white);
        tabbedPane.addTab("群聊", null, jp, null);
        
        //群聊面板上的按钮
        JButton jbGroup = new JButton("加入群聊");
        jbGroup.setBounds(10, 10, 100,50);
        jbGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				QLmain.GroupChat.setVisible(true);
				
			}
        	
        });
        jp.add(jbGroup);

        JButton group1 = new JButton();
        group1.setText("下线");
        group1.setBounds(193, 2, 100, 40);
        jpInfor.add(group1);
        
        group1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SendDownLine();
			}
        	
        });
        

//        final FlowLayout flowLayout_1 = new FlowLayout();
//        flowLayout_1.setAlignment(FlowLayout.RIGHT);
	}
	
	public static void a() {
		for(int i=0;i<MessageDeal.l.content.size();i++) {
        	l.add(MessageDeal.l.content.get(i));
        }
	}
	
}
