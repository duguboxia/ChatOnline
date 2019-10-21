package QL;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Client.Login;
import Client.Register;

public class QLogin extends JFrame{
	
	/**********************************************************************************
	 * QL 仿QQ登录界面
	 * 1.JLabel添加鼠标监听实现图片变化(多数) ps:1/5 日之后完全把所有JButton全换成了JLabel...
	 * 2.图片素材来源网络和实际软件扒取
	 * 3.去除了java自带边框 所以不可拖动窗口 ps:实现了实现了
	 * 
	 * @version v0.3
	 * @author 李宇蔚
	 * @框架搭建 王晓莉
	 * @time 2019.01.08
	 **********************************************************************************/
	
	private JLabel supper; // 用来判断是否打勾的参数
	private JLabel boxp; // 保存密码
	private JLabel boxl; // 自动登录
	private int x = 0;
	private int y = 0;
	
	public JPanel contentPane = new JPanel(); // 登录面板
	public static JPanel contentLGPane = new JPanel(); // 登陆等待面板
	public static JPanel contentRTPane = new JPanel(); // 注册面板
	
	JLabel arrowsRT = new JLabel();
	JLabel minimizeRT = new JLabel();
	JLabel closeRT = new JLabel();
	JPasswordField passwordRT = new JPasswordField();
	JTextField accountRT = new JTextField();
	JLabel stateRT = new JLabel();
	JLabel headPicRT = new JLabel();
	JLabel logoRT = new JLabel();
	JLabel backgroundRT = new JLabel();
	JLabel logintxtRT = new JLabel();
	JLabel loginRT = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
	
	JLabel arrowsLG = new JLabel();
	JLabel minimizeLG = new JLabel();
	JLabel closeLG = new JLabel();
	JLabel stateLG = new JLabel();
	JLabel headPicLG = new JLabel();
	JLabel logoLG = new JLabel();
	JLabel backgroundLG = new JLabel();
	JLabel logintxtLG = new JLabel();
	JLabel loginLG = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
	
	public QLogin() {
			
		
			// 北
			setUndecorated(true);//去除默认标题栏
			setSize(430, 330);//设置窗口大小
			setFocusable(true);//获取焦点，防止启动时焦点在输入qq号的窗口上
			this.setLocationRelativeTo(null);//窗口居中
				
			// 中
			// 登录面板
			contentPane.setBackground(new Color(235, 240, 250));
			contentPane.setLayout(null);
			// 登录等待面板
			contentLGPane.setBackground(new Color(235, 240, 250));
			contentLGPane.setLayout(null);
			// 注册面板
			contentRTPane.setBackground(new Color(235, 240, 250));
			contentRTPane.setLayout(null);
			
			setContentPane(contentPane);
			
			// 右上角 箭头按钮
			JLabel arrows = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_normal.png"));	
			arrows.setBounds(340,2,30,27);
			arrows.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// 点击
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					arrows.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					arrows.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					arrows.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					arrows.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_normal.png"));
				}
				
			});
			
			arrowsLG = arrows;
			arrowsRT = arrows;
			contentPane.add(arrows);
			
			
			// 右上角 最小化
			JLabel minimize = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_normal.png"));
			minimize.setBounds(370, -3, 30, 30);
			minimize.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// 点击
					QLogin.this.setExtendedState(JFrame.ICONIFIED); // 隐藏窗口
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					minimize.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					minimize.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_normal.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					minimize.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_highlight.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					minimize.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_normal.png"));
				}
				
			});
			
			minimizeLG = minimize;
			minimizeRT = minimize;
			contentPane.add(minimize);
			
			// 右上角 叉叉
			JLabel close = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_normal.png"));
			close.setBounds(400, 0, 30, 30);
			// 鼠标事件
			close.addMouseListener(new MouseListener() {
				
				@Override
				public void mousePressed(MouseEvent e) { 
					// 按下
					close.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_down.png"));
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					close.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_normal.png"));
				}
				
				public void mouseClicked(MouseEvent e) {
					// 点击
					System.exit(0);
				}
				
				public void mouseEntered(MouseEvent e) {
					// 移至
					close.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_highlight.png"));
				}
				
				public void mouseExited(MouseEvent e) {
					// 离开
					close.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_normal.png"));
				}
			});
			
			closeLG = close;
			closeRT = close;
			contentPane.add(close);
			
			
			// 小键盘图标
			JLabel keypad = new JLabel(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_normal.png"));
			keypad.setBounds(298, 228, 15, 16);
			// 小键盘事件
			keypad.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 点击
					}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					keypad.setIcon(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_down.png"));
					}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					keypad.setIcon(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_hover.png"));
					}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					keypad.setIcon(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_hover.png"));
					}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					keypad.setIcon(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_normal.png"));
					}
							
				});
			contentPane.add(keypad);
			
			// 密码框
			JPasswordField password = new JPasswordField("密码");
			password.setBounds(130, 225, 187, 27);
			password.setBorder(null);
			password.setOpaque(false);
			password.setEchoChar((char)0);
			password.setForeground(Color.gray);
			password.setFont(new Font("微软雅黑",Font.PLAIN,14));
			// 密码框事件 (动画)
			password.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移入
					supper.setIcon(new ImageIcon("res/LoginFrame/Editbk_bottom_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					supper.setIcon(new ImageIcon("res/LoginFrame/Editbk_normal.png"));
				}
				
			});
			// 密码框事件 (输入)
			password.addFocusListener(new FocusAdapter() {
				// 加密
				public void focusGained(FocusEvent e) {
					if(password.getText().equals("密码")) {
						password.setText(""); // 点击后框为空
						password.setForeground(Color.BLACK);
						password.setEchoChar("●".charAt(0));
						// 正则表达式 以字母开头，长度在6~18之间，只能包含字符、数字和下划线
//						password.setDocument(new MyRegExp("^[a-zA-Z]\\w{5,17}$")); 
						
					}
				}
				// 还原
				public void focusLost(FocusEvent e)
	            {
	            	if(password.getText().equals("")){
	            		password.setText("密码");
	            		password.setForeground(Color.gray);
	            		password.setEchoChar((char) 0);
	            	}
	            }
			});
			
			passwordRT = password;
			contentPane.add(password);
			
			// 账号框
			JTextField account = new JTextField("QQ号码/手机/邮箱");
			account.setBounds(130, 195, 187, 27);
			account.setBorder(null);
			account.setForeground(Color.GRAY);
			account.setFont(new Font("微软雅黑",Font.PLAIN,14));
			// 账号框事件 (动画)
			account.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移入
					supper.setIcon(new ImageIcon("res/LoginFrame/Editbk_top_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					supper.setIcon(new ImageIcon("res/LoginFrame/Editbk_normal.png"));
				}
			});
			// 账号框事件 (输入)
			account.addFocusListener(new FocusAdapter() {
				// 加密
				public void focusGained(FocusEvent e) {
					if(account.getText().equals("QQ号码/手机/邮箱")) {
						account.setText(""); // 点击后框为空
						account.setForeground(Color.BLACK);
//						account.setDocument(new MyRegExp("^[A-Za-z0-9]+$")); // 正则表达式 限制输入大小写字母数字
					}
				}
				// 还原
				public void focusLost(FocusEvent e)
	            {
	            	if(account.getText().equals("")){
	            		account.setText("QQ号码/手机/邮箱");
	            		account.setForeground(Color.gray);
	            	}
	            }
			});
			
			accountRT = account;
			contentPane.add(account);

						
			
			//登陆状态图标（未设置点击事件）
			JLabel state = new JLabel(new ImageIcon("res/LoginFrame/status/imonline.png"));
			state.setOpaque(false);
			state.setBorder(null);
			state.setBounds(100, 261, 15, 15);
			contentPane.add(state);
			
			stateRT = state;
			JLabel stateLG = state;
			
			// 左下角添加QQ号按钮
			JLabel addqqIco =new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_normal.png")); 
			addqqIco.setBounds(12, 295, 25, 25);
			addqqIco.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					// 点击
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					addqqIco.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					addqqIco.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					addqqIco.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					addqqIco.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_normal.png"));
				}
			});
			contentPane.add(addqqIco);

			
			// 右下角二维码登录
			JLabel QRcod = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_normal_breath.png"));
			QRcod.setBounds(395, 295, 25, 25);
			QRcod.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// 点击
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					QRcod.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_normal_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					QRcod.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					QRcod.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 离开
					QRcod.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_normal_breath.png"));
				}
				
			});
			contentPane.add(QRcod);

			
			// 设置头像图片大小
			ImageIcon headImage = new ImageIcon("res/head2.jpg");
			headImage.setImage(headImage.getImage().getScaledInstance(82, 82,Image.SCALE_DEFAULT ));
			
			// 加入头像图片到标签
			JLabel headPic = new JLabel(headImage);
			headPic.setBounds(30, 195, 82, 82);
			contentPane.add(headPic);
			
			headPicRT = headPic;
			headPicLG = headPic;
			
			
			// 注册账号
			JLabel register = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/zhuce.png"));
			register.setBounds(330, 202, 50, 12);
			register.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// 点击
					
					contentPane.setVisible(false);
					// 添加组件到注册面板
					contentRTPane.add(arrowsRT);
					contentRTPane.add(minimizeRT);
					contentRTPane.add(closeRT);
					contentRTPane.add(passwordRT);
					contentRTPane.add(accountRT);
					contentRTPane.add(stateRT);
					contentRTPane.add(headPicRT);
					contentRTPane.add(supper);
					contentRTPane.add(logoRT);
					contentRTPane.add(backgroundRT);
					logintxtRT.setText("注   册");
					contentRTPane.add(logintxtRT);
					loginRT.setBounds(125, 285, 195, 30);
					loginRT.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							// 点击
							System.out.println("注册事件触发");
							String accountSend = account.getText().toString(); // 获取输入账号
							String passwordStrSend = password.getText().toString(); // 获取输入密码
							Register register = new Register(accountSend,passwordStrSend);
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// 按下
							loginRT.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_down.png"));
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// 弹起
							loginRT.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// 移至
							loginRT.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// 移出
							loginRT.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
						}
						
					});
					contentRTPane.add(loginRT);
					
					setContentPane(contentRTPane);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					register.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/zhuce_press.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					register.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/zhuce_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					register.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/zhuce_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					register.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/zhuce.png"));
				}
				
			});
			contentPane.add(register);
			
			// 找回密码
			JLabel retrievePassword = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/mima.png"));
			retrievePassword.setBounds(330, 230, 50, 12);
			retrievePassword.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					retrievePassword.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/mima_press.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					retrievePassword.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/mima_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移入
					retrievePassword.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/mima_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					retrievePassword.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/mima.png"));
				}
				
			});
			contentPane.add(retrievePassword);
			
			// 账号密码框 动画效果(图)
			supper = new JLabel(new ImageIcon("res/LoginFrame/Editbk_normal.png"));
			supper.setBounds(123, 193, 198, 61);
			contentPane.add(supper);
			
			// 记住密码 JPanel
			JPanel remenberPassword = new JPanel();
			remenberPassword.setBounds(122,258,72,18);
			remenberPassword.setLayout(null); // 取消自动居中
			remenberPassword.setOpaque(false);// 取消面板底色
			remenberPassword.addMouseListener(new MouseListener() {
				int flag = -1; //flag = 1 勾 -1 叉
				@Override
				public void mouseClicked(MouseEvent e) {
					// 点击
					flag *= -1;
					if(flag == 1) {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					}else {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					if(flag == 1) {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_pushed1.png"));
					}else {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_down.png"));
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					if(flag == 1) {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					}else {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
					}
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					if(flag == 1)
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					else
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					if(flag == 1)
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_normal1.png"));
					else
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_normal.png"));
				}
				
			});
			contentPane.add(remenberPassword);
			// 勾选框
			boxp = new JLabel(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_normal.png"));
			boxp.setBounds(0, 0, 20, 20);
			remenberPassword.add(boxp);
			// 记住密码 文字
			JLabel rmbtxt = new JLabel("记住密码");
			rmbtxt.setBounds(23, 0, 55, 20);
			rmbtxt.setFont(new Font("微软雅黑",Font.PLAIN,12));
			rmbtxt.setForeground(Color.GRAY);
			remenberPassword.add(rmbtxt);
			
			// 自动登录 JPanel
			JPanel autoLogin = new JPanel();
			autoLogin.setBounds(253,260,72,18);
			autoLogin.setLayout(null); // 取消自动居中
			autoLogin.setOpaque(false);// 取消面板底色
			autoLogin.addMouseListener(new MouseListener() {
				int flag = -1; //flag2 = 1 勾 -1 叉
				@Override
				public void mouseClicked(MouseEvent e) {
					// 点击
					flag *= -1;
					if(flag == 1) {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					}else {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					if(flag == 1) {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_pushed1.png"));
					}else {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_down.png"));
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					if(flag == 1) {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					}else {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
					}
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					if(flag == 1)
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					else
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					if(flag == 1)
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_normal1.png"));
					else
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_normal.png"));
				}
				
			});
			contentPane.add(autoLogin);
			// 勾选框
			boxl = new JLabel(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_normal.png"));
			boxl.setBounds(0, 0, 17, 17);
			autoLogin.add(boxl);
			//复选框对应文字
			JLabel rpw = new JLabel("自动登录");
			rpw.setFont(new Font("微软雅黑", Font.PLAIN, 12));
			rpw.setForeground(Color.gray);
			rpw.setBounds(17, 0, 55, 17);
			autoLogin.add(rpw);
			
			// logo
			JLabel logo = new JLabel(new ImageIcon("res/LoginFrame/logo-banner.png")); // 高仿QQ logo
//			JLabel logo = new JLabel(new ImageIcon("res/LoginFrame/logo.png")); // QL logo
			logo.setBounds(150, 65, 130, 70);
			contentPane.add(logo);
			
			logoRT = logo;
			logoLG = logo;
			
			// 背景图
			JLabel background = new JLabel(new ImageIcon("res/LoginFrame/bk.jpg"));
			background.setSize(430,182);
			contentPane.add(background);
			
			backgroundRT = background;
			backgroundLG = background;
			
			
			
			// 登录Label
			JLabel logintxt = new JLabel("登   录");
			logintxt.setBounds(125, 285, 195, 30);
			logintxt.setFont(new Font("微软雅黑",Font.PLAIN,12));
			logintxt.setForeground(new Color(255,255,255));
			logintxt.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(logintxt);
			
			logintxtRT = logintxt;
			logintxtLG = logintxt;
			
			
			
			// 登录按钮 Label
			JLabel login = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
			login.setBounds(125, 285, 195, 30);
			// 登录事件
			login.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// 点击
					System.out.println("登录事件触发");
					
					contentPane.setVisible(false);
					// 添加组件到注册面板
					contentLGPane.add(arrowsLG);
					contentLGPane.add(minimizeLG);
					contentLGPane.add(closeLG);
					stateLG.setBounds(247, 261, 15, 15);
					contentLGPane.add(stateLG);
					headPicLG.setBounds(180, 195, 82, 82);
					contentLGPane.add(headPicLG);
					contentLGPane.add(logoLG);
					contentLGPane.add(backgroundLG);
					logintxtLG.setText("取   消");
					contentLGPane.add(logintxtLG);
					loginLG.setBounds(125, 285, 195, 30);
					loginLG.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							// 点击
							System.exit(0);
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// 按下
							loginLG.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_down.png"));
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// 弹起
							loginLG.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// 移至
							loginLG.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// 移出
							loginLG.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
						}
						
					});
					contentLGPane.add(loginLG);
					
					setContentPane(contentLGPane);
					
					String accountSend = account.getText().toString(); // 获取输入账号
					String passwordStrSend = password.getText().toString(); // 获取输入密码
					Login login = new Login(accountSend,passwordStrSend);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// 按下
					login.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// 弹起
					login.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// 移至
					login.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// 移出
					login.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
				}
				
			});
			contentPane.add(login);
			
			//蓝色背景图片添加鼠标拖动功能
			background.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x = e.getX();// 记录鼠标按下时的坐标
					y = e.getY();
				}
			});
			background.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					int xOnScreen = e.getXOnScreen();
					int yOnScreen = e.getYOnScreen();
					int x1 = xOnScreen - x;
					int y1 = yOnScreen - y;
					QLogin.this.setLocation(x1, y1);// 设置拖拽后，窗口的位置
				}
			});
			
	}
	
}
