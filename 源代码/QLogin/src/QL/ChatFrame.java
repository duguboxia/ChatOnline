package QL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ChatFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	ChatFrame frame = new ChatFrame();
    	frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public ChatFrame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(5, 5));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblNewLabel.setPreferredSize(new Dimension(64, 64));
        panel.add(lblNewLabel, BorderLayout.WEST);

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_1 = new JLabel("张三丰");
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
        panel_1.add(lblNewLabel_1, BorderLayout.CENTER);

        JLabel lblNewLabel_2 = new JLabel("埋下一座城，关了所有灯");
        panel_1.add(lblNewLabel_2, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.9);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        contentPane.add(splitPane, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        splitPane.setRightComponent(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_2.add(panel_3, BorderLayout.NORTH);

        JButton btnNewButton_1 = new JButton("字体");
        panel_3.add(btnNewButton_1);

        JButton btnNewButton = new JButton("震屏");
        panel_3.add(btnNewButton);

        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_4.add(panel_5, BorderLayout.EAST);
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton button = new JButton("发 送");
        panel_5.add(button);

        JPanel panel_6 = new JPanel();
        panel_4.add(panel_6, BorderLayout.CENTER);
        panel_6.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_6.add(scrollPane_1, BorderLayout.CENTER);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        scrollPane_1.setViewportView(textArea);

        JScrollPane scrollPane = new JScrollPane();
        splitPane.setLeftComponent(scrollPane);
    }

}
