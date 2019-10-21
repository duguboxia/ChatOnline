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
	 * QL ��QQ��¼����
	 * 1.JLabel���������ʵ��ͼƬ�仯(����) ps:1/5 ��֮����ȫ������JButtonȫ������JLabel...
	 * 2.ͼƬ�ز���Դ�����ʵ�������ȡ
	 * 3.ȥ����java�Դ��߿� ���Բ����϶����� ps:ʵ����ʵ����
	 * 
	 * @version v0.3
	 * @author ����ε
	 * @��ܴ ������
	 * @time 2019.01.08
	 **********************************************************************************/
	
	private JLabel supper; // �����ж��Ƿ�򹴵Ĳ���
	private JLabel boxp; // ��������
	private JLabel boxl; // �Զ���¼
	private int x = 0;
	private int y = 0;
	
	public JPanel contentPane = new JPanel(); // ��¼���
	public static JPanel contentLGPane = new JPanel(); // ��½�ȴ����
	public static JPanel contentRTPane = new JPanel(); // ע�����
	
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
			
		
			// ��
			setUndecorated(true);//ȥ��Ĭ�ϱ�����
			setSize(430, 330);//���ô��ڴ�С
			setFocusable(true);//��ȡ���㣬��ֹ����ʱ����������qq�ŵĴ�����
			this.setLocationRelativeTo(null);//���ھ���
				
			// ��
			// ��¼���
			contentPane.setBackground(new Color(235, 240, 250));
			contentPane.setLayout(null);
			// ��¼�ȴ����
			contentLGPane.setBackground(new Color(235, 240, 250));
			contentLGPane.setLayout(null);
			// ע�����
			contentRTPane.setBackground(new Color(235, 240, 250));
			contentRTPane.setLayout(null);
			
			setContentPane(contentPane);
			
			// ���Ͻ� ��ͷ��ť
			JLabel arrows = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_normal.png"));	
			arrows.setBounds(340,2,30,27);
			arrows.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// ���
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					arrows.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					arrows.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					arrows.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					arrows.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/aio_setting_white_normal.png"));
				}
				
			});
			
			arrowsLG = arrows;
			arrowsRT = arrows;
			contentPane.add(arrows);
			
			
			// ���Ͻ� ��С��
			JLabel minimize = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_normal.png"));
			minimize.setBounds(370, -3, 30, 30);
			minimize.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// ���
					QLogin.this.setExtendedState(JFrame.ICONIFIED); // ���ش���
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					minimize.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					minimize.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_normal.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					minimize.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_highlight.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					minimize.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_mini_normal.png"));
				}
				
			});
			
			minimizeLG = minimize;
			minimizeRT = minimize;
			contentPane.add(minimize);
			
			// ���Ͻ� ���
			JLabel close = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_normal.png"));
			close.setBounds(400, 0, 30, 30);
			// ����¼�
			close.addMouseListener(new MouseListener() {
				
				@Override
				public void mousePressed(MouseEvent e) { 
					// ����
					close.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_down.png"));
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					close.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_normal.png"));
				}
				
				public void mouseClicked(MouseEvent e) {
					// ���
					System.exit(0);
				}
				
				public void mouseEntered(MouseEvent e) {
					// ����
					close.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_highlight.png"));
				}
				
				public void mouseExited(MouseEvent e) {
					// �뿪
					close.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/btn_close_normal.png"));
				}
			});
			
			closeLG = close;
			closeRT = close;
			contentPane.add(close);
			
			
			// С����ͼ��
			JLabel keypad = new JLabel(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_normal.png"));
			keypad.setBounds(298, 228, 15, 16);
			// С�����¼�
			keypad.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// ���
					}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					keypad.setIcon(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_down.png"));
					}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					keypad.setIcon(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_hover.png"));
					}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					keypad.setIcon(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_hover.png"));
					}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					keypad.setIcon(new ImageIcon("res/LoginFrame/PasswordEdit_Keybd/keyboard_normal.png"));
					}
							
				});
			contentPane.add(keypad);
			
			// �����
			JPasswordField password = new JPasswordField("����");
			password.setBounds(130, 225, 187, 27);
			password.setBorder(null);
			password.setOpaque(false);
			password.setEchoChar((char)0);
			password.setForeground(Color.gray);
			password.setFont(new Font("΢���ź�",Font.PLAIN,14));
			// ������¼� (����)
			password.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					supper.setIcon(new ImageIcon("res/LoginFrame/Editbk_bottom_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					supper.setIcon(new ImageIcon("res/LoginFrame/Editbk_normal.png"));
				}
				
			});
			// ������¼� (����)
			password.addFocusListener(new FocusAdapter() {
				// ����
				public void focusGained(FocusEvent e) {
					if(password.getText().equals("����")) {
						password.setText(""); // ������Ϊ��
						password.setForeground(Color.BLACK);
						password.setEchoChar("��".charAt(0));
						// ������ʽ ����ĸ��ͷ��������6~18֮�䣬ֻ�ܰ����ַ������ֺ��»���
//						password.setDocument(new MyRegExp("^[a-zA-Z]\\w{5,17}$")); 
						
					}
				}
				// ��ԭ
				public void focusLost(FocusEvent e)
	            {
	            	if(password.getText().equals("")){
	            		password.setText("����");
	            		password.setForeground(Color.gray);
	            		password.setEchoChar((char) 0);
	            	}
	            }
			});
			
			passwordRT = password;
			contentPane.add(password);
			
			// �˺ſ�
			JTextField account = new JTextField("QQ����/�ֻ�/����");
			account.setBounds(130, 195, 187, 27);
			account.setBorder(null);
			account.setForeground(Color.GRAY);
			account.setFont(new Font("΢���ź�",Font.PLAIN,14));
			// �˺ſ��¼� (����)
			account.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					supper.setIcon(new ImageIcon("res/LoginFrame/Editbk_top_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					supper.setIcon(new ImageIcon("res/LoginFrame/Editbk_normal.png"));
				}
			});
			// �˺ſ��¼� (����)
			account.addFocusListener(new FocusAdapter() {
				// ����
				public void focusGained(FocusEvent e) {
					if(account.getText().equals("QQ����/�ֻ�/����")) {
						account.setText(""); // ������Ϊ��
						account.setForeground(Color.BLACK);
//						account.setDocument(new MyRegExp("^[A-Za-z0-9]+$")); // ������ʽ ���������Сд��ĸ����
					}
				}
				// ��ԭ
				public void focusLost(FocusEvent e)
	            {
	            	if(account.getText().equals("")){
	            		account.setText("QQ����/�ֻ�/����");
	            		account.setForeground(Color.gray);
	            	}
	            }
			});
			
			accountRT = account;
			contentPane.add(account);

						
			
			//��½״̬ͼ�꣨δ���õ���¼���
			JLabel state = new JLabel(new ImageIcon("res/LoginFrame/status/imonline.png"));
			state.setOpaque(false);
			state.setBorder(null);
			state.setBounds(100, 261, 15, 15);
			contentPane.add(state);
			
			stateRT = state;
			JLabel stateLG = state;
			
			// ���½����QQ�Ű�ť
			JLabel addqqIco =new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_normal.png")); 
			addqqIco.setBounds(12, 295, 25, 25);
			addqqIco.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					// ���
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					addqqIco.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					addqqIco.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					addqqIco.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					addqqIco.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/switch_single_normal.png"));
				}
			});
			contentPane.add(addqqIco);

			
			// ���½Ƕ�ά���¼
			JLabel QRcod = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_normal_breath.png"));
			QRcod.setBounds(395, 295, 25, 25);
			QRcod.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// ���
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					QRcod.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_normal_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					QRcod.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					QRcod.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �뿪
					QRcod.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/corner_right_normal_breath.png"));
				}
				
			});
			contentPane.add(QRcod);

			
			// ����ͷ��ͼƬ��С
			ImageIcon headImage = new ImageIcon("res/head2.jpg");
			headImage.setImage(headImage.getImage().getScaledInstance(82, 82,Image.SCALE_DEFAULT ));
			
			// ����ͷ��ͼƬ����ǩ
			JLabel headPic = new JLabel(headImage);
			headPic.setBounds(30, 195, 82, 82);
			contentPane.add(headPic);
			
			headPicRT = headPic;
			headPicLG = headPic;
			
			
			// ע���˺�
			JLabel register = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/zhuce.png"));
			register.setBounds(330, 202, 50, 12);
			register.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// ���
					
					contentPane.setVisible(false);
					// ��������ע�����
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
					logintxtRT.setText("ע   ��");
					contentRTPane.add(logintxtRT);
					loginRT.setBounds(125, 285, 195, 30);
					loginRT.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							// ���
							System.out.println("ע���¼�����");
							String accountSend = account.getText().toString(); // ��ȡ�����˺�
							String passwordStrSend = password.getText().toString(); // ��ȡ��������
							Register register = new Register(accountSend,passwordStrSend);
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// ����
							loginRT.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_down.png"));
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// ����
							loginRT.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// ����
							loginRT.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// �Ƴ�
							loginRT.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
						}
						
					});
					contentRTPane.add(loginRT);
					
					setContentPane(contentRTPane);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					register.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/zhuce_press.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					register.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/zhuce_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					register.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/zhuce_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					register.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/zhuce.png"));
				}
				
			});
			contentPane.add(register);
			
			// �һ�����
			JLabel retrievePassword = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/mima.png"));
			retrievePassword.setBounds(330, 230, 50, 12);
			retrievePassword.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					retrievePassword.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/mima_press.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					retrievePassword.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/mima_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					retrievePassword.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/mima_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					retrievePassword.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/mima.png"));
				}
				
			});
			contentPane.add(retrievePassword);
			
			// �˺������ ����Ч��(ͼ)
			supper = new JLabel(new ImageIcon("res/LoginFrame/Editbk_normal.png"));
			supper.setBounds(123, 193, 198, 61);
			contentPane.add(supper);
			
			// ��ס���� JPanel
			JPanel remenberPassword = new JPanel();
			remenberPassword.setBounds(122,258,72,18);
			remenberPassword.setLayout(null); // ȡ���Զ�����
			remenberPassword.setOpaque(false);// ȡ������ɫ
			remenberPassword.addMouseListener(new MouseListener() {
				int flag = -1; //flag = 1 �� -1 ��
				@Override
				public void mouseClicked(MouseEvent e) {
					// ���
					flag *= -1;
					if(flag == 1) {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					}else {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					if(flag == 1) {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_pushed1.png"));
					}else {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_down.png"));
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					if(flag == 1) {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					}else {
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
					}
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					if(flag == 1)
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					else
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					if(flag == 1)
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_normal1.png"));
					else
						boxp.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_normal.png"));
				}
				
			});
			contentPane.add(remenberPassword);
			// ��ѡ��
			boxp = new JLabel(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_normal.png"));
			boxp.setBounds(0, 0, 20, 20);
			remenberPassword.add(boxp);
			// ��ס���� ����
			JLabel rmbtxt = new JLabel("��ס����");
			rmbtxt.setBounds(23, 0, 55, 20);
			rmbtxt.setFont(new Font("΢���ź�",Font.PLAIN,12));
			rmbtxt.setForeground(Color.GRAY);
			remenberPassword.add(rmbtxt);
			
			// �Զ���¼ JPanel
			JPanel autoLogin = new JPanel();
			autoLogin.setBounds(253,260,72,18);
			autoLogin.setLayout(null); // ȡ���Զ�����
			autoLogin.setOpaque(false);// ȡ������ɫ
			autoLogin.addMouseListener(new MouseListener() {
				int flag = -1; //flag2 = 1 �� -1 ��
				@Override
				public void mouseClicked(MouseEvent e) {
					// ���
					flag *= -1;
					if(flag == 1) {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					}else {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					if(flag == 1) {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_pushed1.png"));
					}else {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_down.png"));
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					if(flag == 1) {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					}else {
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
					}
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					if(flag == 1)
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_highlight1.png"));
					else
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_highlight.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					if(flag == 1)
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/Checkbox_tick_normal1.png"));
					else
						boxl.setIcon(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_normal.png"));
				}
				
			});
			contentPane.add(autoLogin);
			// ��ѡ��
			boxl = new JLabel(new ImageIcon("res/LoginFrame/CheckBox/CheckBox_normal.png"));
			boxl.setBounds(0, 0, 17, 17);
			autoLogin.add(boxl);
			//��ѡ���Ӧ����
			JLabel rpw = new JLabel("�Զ���¼");
			rpw.setFont(new Font("΢���ź�", Font.PLAIN, 12));
			rpw.setForeground(Color.gray);
			rpw.setBounds(17, 0, 55, 17);
			autoLogin.add(rpw);
			
			// logo
			JLabel logo = new JLabel(new ImageIcon("res/LoginFrame/logo-banner.png")); // �߷�QQ logo
//			JLabel logo = new JLabel(new ImageIcon("res/LoginFrame/logo.png")); // QL logo
			logo.setBounds(150, 65, 130, 70);
			contentPane.add(logo);
			
			logoRT = logo;
			logoLG = logo;
			
			// ����ͼ
			JLabel background = new JLabel(new ImageIcon("res/LoginFrame/bk.jpg"));
			background.setSize(430,182);
			contentPane.add(background);
			
			backgroundRT = background;
			backgroundLG = background;
			
			
			
			// ��¼Label
			JLabel logintxt = new JLabel("��   ¼");
			logintxt.setBounds(125, 285, 195, 30);
			logintxt.setFont(new Font("΢���ź�",Font.PLAIN,12));
			logintxt.setForeground(new Color(255,255,255));
			logintxt.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(logintxt);
			
			logintxtRT = logintxt;
			logintxtLG = logintxt;
			
			
			
			// ��¼��ť Label
			JLabel login = new JLabel(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
			login.setBounds(125, 285, 195, 30);
			// ��¼�¼�
			login.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// ���
					System.out.println("��¼�¼�����");
					
					contentPane.setVisible(false);
					// ��������ע�����
					contentLGPane.add(arrowsLG);
					contentLGPane.add(minimizeLG);
					contentLGPane.add(closeLG);
					stateLG.setBounds(247, 261, 15, 15);
					contentLGPane.add(stateLG);
					headPicLG.setBounds(180, 195, 82, 82);
					contentLGPane.add(headPicLG);
					contentLGPane.add(logoLG);
					contentLGPane.add(backgroundLG);
					logintxtLG.setText("ȡ   ��");
					contentLGPane.add(logintxtLG);
					loginLG.setBounds(125, 285, 195, 30);
					loginLG.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							// ���
							System.exit(0);
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// ����
							loginLG.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_down.png"));
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// ����
							loginLG.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// ����
							loginLG.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// �Ƴ�
							loginLG.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
						}
						
					});
					contentLGPane.add(loginLG);
					
					setContentPane(contentLGPane);
					
					String accountSend = account.getText().toString(); // ��ȡ�����˺�
					String passwordStrSend = password.getText().toString(); // ��ȡ��������
					Login login = new Login(accountSend,passwordStrSend);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// ����
					login.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_down.png"));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// ����
					login.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// ����
					login.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_hover.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// �Ƴ�
					login.setIcon(new ImageIcon("res/LoginFrame/Btn_Login/button_login_normal.png"));
				}
				
			});
			contentPane.add(login);
			
			//��ɫ����ͼƬ�������϶�����
			background.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x = e.getX();// ��¼��갴��ʱ������
					y = e.getY();
				}
			});
			background.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					int xOnScreen = e.getXOnScreen();
					int yOnScreen = e.getYOnScreen();
					int x1 = xOnScreen - x;
					int y1 = yOnScreen - y;
					QLogin.this.setLocation(x1, y1);// ������ק�󣬴��ڵ�λ��
				}
			});
			
	}
	
}
