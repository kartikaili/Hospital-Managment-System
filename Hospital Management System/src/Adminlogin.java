import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;









import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Adminlogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	Connection conn = null;
	Statement stmt = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlogin frame = new Adminlogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Adminlogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1264, 681);
		contentPane.add(panel);
		
		JButton button = new JButton("");
		button.setOpaque(true);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mp=new MainPage();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Adminlogin.class.getResource("/Images/back (2).png")));
		button.setBounds(0, 126, 93, 59);
		
		panel.add(button);
		
		Border br=BorderFactory.createLineBorder(new Color(0,153,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(469, 234, 374, 373);
		panel_1.setBackground(new Color(255,255,255,200));
		panel_1.setLayout(null);
		panel_1.setOpaque(true);
		panel_1.setBorder(br);
		panel.add(panel_1);
		
		
		JLabel lblAdmin = new JLabel("ADMIN LOGIN");
		lblAdmin.setBackground(Color.WHITE);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAdmin.setForeground(new Color(0,153,255));
		lblAdmin.setBounds(88, 22, 194, 58);
		panel_1.add(lblAdmin);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\LOGIN.png"));
		label_1.setBounds(44, 120, 48, 48);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\icons8-password-48.png"));
		label_2.setBounds(44, 199, 48, 48);
		panel_1.add(label_2);
		
		username = new JTextField("Enter UserName");
		username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				username.setText(null);
			}
			
		});
		username.setBounds(102, 134, 194, 27);
		username.setBorder(br);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField("Enter Password");
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				password.setText(null);
			}
		});
		password.setColumns(10);
		password.setBorder(br);
		password.setBounds(102, 211, 194, 27);
		panel_1.add(password);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String us=username.getText().trim();
					String ps=password.getText().trim();
					ResultSet rs=stmt.executeQuery("Select * From admin where username='"+us+"' and password='"+ps+"'");
					if(rs.next()){
						//JOptionPane.showMessageDialog(null,"LOGIN Succesfull");
						Adminpage ap=new Adminpage();
						ap.setVisible(true);
						ap.setLocationRelativeTo(null);;
						dispose();
					}else{
						JOptionPane.showMessageDialog(null,"LOGIN UnSuccesfull");
					}
					
				}catch(Exception e){
					
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogin.setForeground(new Color(0,153,255));
		btnLogin.setBackground(UIManager.getColor("Button.highlight"));
		
		btnLogin.setBounds(130, 277, 101, 27);
		panel_1.add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\ADMINLOGIN (1).png"));
		label.setBounds(0, 0, 1264, 681);
		panel.add(label);
	}
}
