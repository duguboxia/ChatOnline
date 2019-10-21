package HaveAbandon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class interface2 extends JDialog {
    
//    public static void main(String args[]) {
//        
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JDialog.setDefaultLookAndFeelDecorated(true);
//        
//        try {
//            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//        } catch (ClassNotFoundException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } catch (InstantiationException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } catch (IllegalAccessException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        } catch (UnsupportedLookAndFeelException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//        
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    interface2 dialog = new interface2();
//                    dialog.addWindowListener(new WindowAdapter() {
//                        public void windowClosing(WindowEvent e) {
//                            System.exit(0);
//                        }
//                    });
//                    dialog.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    public interface2() {
        super();
        setTitle("主界面");
        setBounds(1500, 100, 300, 600);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);

        //头像图片
      	ImageIcon headPic = new ImageIcon("res/head2.jpg");
      	headPic.setImage(headPic.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT ));
        
        final JLabel label = new JLabel(headPic);
        panel.add(label, BorderLayout.WEST);
        label.setPreferredSize(new Dimension(74,74));

        final JPanel panel_1 = new JPanel();
        panel_1.setLayout(new BorderLayout());
        panel.add(panel_1, BorderLayout.CENTER);

        final JLabel advancingSwiftLabel = new JLabel();
        advancingSwiftLabel.setText("小红");
        panel_1.add(advancingSwiftLabel, BorderLayout.CENTER);

        final JLabel signature = new JLabel();
        signature.setText("莹草真可爱！");
        signature.setBounds(200,30,250,20);
        panel_1.add(signature, BorderLayout.SOUTH);

        final JPanel panel_2 = new JPanel();
        panel_2.setLayout(new BorderLayout());
        getContentPane().add(panel_2, BorderLayout.SOUTH);

        final JPanel panel_3 = new JPanel();
        final FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_3.setLayout(flowLayout);
        panel_2.add(panel_3);

        final JButton button = new JButton();
        panel_3.add(button);
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setText("设置");

        final JButton button_1 = new JButton();
        panel_3.add(button_1);
        button_1.setText("查找");

        final JPanel panel_4 = new JPanel();
        panel_2.add(panel_4, BorderLayout.EAST);

        final JButton button_2 = new JButton();
        panel_4.add(button_2);
        button_2.setText("退出");

        final JTabbedPane tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        final JPanel panel_5 = new JPanel();
        tabbedPane.addTab("好友列表", null, panel_5, null);

        final JPanel panel_6 = new JPanel();
        tabbedPane.addTab("群聊", null, panel_6, null);

        final JPanel panel_7 = new JPanel();
        tabbedPane.addTab("聊天记录", null, panel_7, null);
        final FlowLayout flowLayout_1 = new FlowLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        
    }

}