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

	int windowWidth = 800;// 窗口宽
	int windowHeight = 600;// 窗口高

	JTextField jtfPort, jtfUser;// 端口号输入框，用户名输入框

	JLabel jlUser, jlPort, jlUserName;// 用户列表，端口号，用户名

	public JTextArea jtaChat, jtaUser, jtaSend; // 聊天界面框，用户列表框，发送消息框

	public JButton btnSend, btnStart, btnClose;// 发送按钮，启动按钮，停止按钮

	public static void main(String[] ages) {

		new ClientGroupChatFrame().setVisible(true);
	}

	public ClientGroupChatFrame() {
		// 设置标题
		this.setTitle("聊天室");
		// 设置窗口大小
		this.setSize(windowWidth, windowHeight);
		// 设置是否可以关闭窗口
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 设置默认居中
		this.setLocationRelativeTo(null);
		// 设置窗口是否可以改变窗口大小
		this.setResizable(false);

		JPanel jp = new JPanel();
		this.add(jp);
		jp.setLayout(null);
		jp.setBackground(Color.LIGHT_GRAY);

		// 聊天界面框
		jtaChat = new JTextArea();
		jtaChat.setBounds(50, 100, 450, 300);
		jtaChat.setLineWrap(true);
		jp.add(jtaChat);

		// 用户列表
		jlUser = new JLabel("用户列表:");
		jlUser.setBounds(550, 60, 100, 50);
		jp.add(jlUser);

		// 用户列表框
		jtaUser = new JTextArea();
		jtaUser.setBounds(550, 100, 150, 300);
		jp.add(jtaUser);

		// 消息发送框
		jtaSend = new JTextArea();
		jtaSend.setBounds(50, 450, 600, 100);
		jp.add(jtaSend);

		// 发送按钮
		btnSend = new JButton("发送");
		btnSend.setBounds(670, 470, 100, 50);
		jp.add(btnSend);

	}
}
