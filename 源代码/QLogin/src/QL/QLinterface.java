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
	private int  windowWidth = 300;//���ڿ�
	private int  windowHeight = 600;//���ڸ�
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
		itfs.online();// ����
		itfs.start(); // �������
		
		System.out.println("InterfaceSend ������");
		
		//���ڱ���
		this.setTitle("��¼������");
		//���ڴ�С
		this.setSize(windowWidth, windowHeight);
		//�����Ƿ���Թرմ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//����Ĭ�Ͼ���
		this.setLocationRelativeTo(null);
		//���ô����Ƿ���Ըı䴰�ڴ�С
		this.setResizable(false);
		
		//ָ�����ֹ��������߽�
		this.setLayout(new BorderLayout());

		
		//�û���Ϣ���
		JPanel jpInfor = new JPanel();
		jpInfor.setBackground(Color.pink);
		jpInfor.setPreferredSize(new Dimension(300,100));
		jpInfor.setBorder(BorderFactory.createRaisedBevelBorder());//б��߿�͹
		this.add(jpInfor, BorderLayout.NORTH);//��
	
		//ͷ��ͼƬ
		ImageIcon headPic = new ImageIcon("res/defaultFace.png");
		headPic.setImage(headPic.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT ));
		
		//ͷ���ǩ
		JLabel jlAvatar = new JLabel(headPic);
		jpInfor.setLayout(null);
		jlAvatar.setBounds(10, 10, 80, 80);
		jpInfor.add(jlAvatar);	
		
		//�û�ǩ��
		String signature = "����һ��ǩ��";
		JLabel jlSignature = new JLabel(signature);
		jlSignature.setFont(new Font("΢���ź�",Font.PLAIN,12));
		jlSignature.setBounds(100,30,250,20);
		jpInfor.add(jlSignature);
		
		//ʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� EEEE");
		String s= sdf.format(date);
		JLabel jlDate = new JLabel(s);
		jlDate.setFont(new Font("΢���ź�",Font.PLAIN,12));
		jlDate.setBounds(100, 60, 200, 20);
		jpInfor.add(jlDate);
		
		// ˽�İ�ť
		JButton private1 = new JButton("˽��");
		private1.setBounds(230, 50, 70, 50);
		private1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QLmain.PrivateChat.setVisible(true);
			}
			
		});
		jpInfor.add(private1);
		
		
		//ѡ����
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.blue);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        
        //�������
        friends = new JPanel();
        friends.setBackground(Color.pink);
        tabbedPane.addTab("�����б�", null, friends, null);
        friends.setLayout(new GridLayout());//�����������Ϊ���񲼾ֹ�����
        
        //�����б�
//        String[] name = new String[] {"С��","����","����","����","����"};
//        String[] num = new String[] {"978964494","486453154","78912345","52134865","12345876"};
        
        //���б�����Ӻ���
        
        
      
        
        
        
        
        l.setFont(new Font("΢���ź�",Font.PLAIN,16));
        //�����ѡ
        l.setMultipleSelections(false);
        //�б�ѡ���л��ļ���
        l.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getSource());
			}
		});
       //�б���Ϊ�ļ���
        l.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("1");
			}
		});
        //�����¼�
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
         
        
        //Ⱥ�����
        JPanel jp = new JPanel();
        jp.setBackground(Color.white);
        tabbedPane.addTab("Ⱥ��", null, jp, null);
        
        //Ⱥ������ϵİ�ť
        JButton jbGroup = new JButton("����Ⱥ��");
        jbGroup.setBounds(10, 10, 100,50);
        jbGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				QLmain.GroupChat.setVisible(true);
				
			}
        	
        });
        jp.add(jbGroup);

        JButton group1 = new JButton();
        group1.setText("����");
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
