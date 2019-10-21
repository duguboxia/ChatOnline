package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import eg.Server;

public class ClientGroupChatFrame extends JFrame {

	int windowWidth = 800;// ���ڿ�
	int windowHeight = 600;// ���ڸ�

	JTextField jtfPort, jtfUser;// �˿ں�������û��������

	JLabel jlUser, jlPort, jlUserName;// �û��б��˿ںţ��û���

	public JTextArea jtaChat, jtaUser, jtaSend; // ���������û��б�򣬷�����Ϣ��

	public JButton btnSend, btnStart, btnClose;// ���Ͱ�ť��������ť��ֹͣ��ť

	public static void main(String[] ages) {

		new ClientGroupChatFrame().setVisible(true);
	}

	public ClientGroupChatFrame() {
		// ���ñ���
		this.setTitle("������");
		// ���ô��ڴ�С
		this.setSize(windowWidth, windowHeight);
		// �����Ƿ���Թرմ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ����Ĭ�Ͼ���
		this.setLocationRelativeTo(null);
		// ���ô����Ƿ���Ըı䴰�ڴ�С
		this.setResizable(false);

		JPanel jp = new JPanel();
		this.add(jp);
		jp.setLayout(null);
		jp.setBackground(Color.LIGHT_GRAY);

		// ��������
		jtaChat = new JTextArea();
		jtaChat.setBounds(50, 100, 450, 300);
		jtaChat.setLineWrap(true);
		jp.add(jtaChat);

		// �û��б�
		jlUser = new JLabel("�û��б�:");
		jlUser.setBounds(550, 60, 100, 50);
		jp.add(jlUser);

		// �û��б��
		jtaUser = new JTextArea();
		jtaUser.setBounds(550, 100, 150, 300);
		jp.add(jtaUser);

		// ��Ϣ���Ϳ�
		jtaSend = new JTextArea();
		jtaSend.setBounds(50, 450, 600, 100);
		jp.add(jtaSend);

		// ���Ͱ�ť
		btnSend = new JButton("����");
		btnSend.setBounds(670, 470, 100, 50);
		jp.add(btnSend);

	}
}
