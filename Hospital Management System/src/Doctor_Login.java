import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Doctor_Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	Connection conn=null;
	Statement stmt=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Login frame = new Doctor_Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Doctor_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280,720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1264, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mp=new MainPage();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Doctor_Login.class.getResource("/Images/back (2).png")));
		button.setOpaque(true);
		button.setBounds(0, 129, 93, 59);
		panel.add(button);
		
		Border br=BorderFactory.createLineBorder(new Color(0,153,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(true);
		panel_1.setBackground(new Color(255, 255, 255, 200));
		panel_1.setBounds(439, 210, 374, 373);
		panel_1.setBorder(br);
		panel.add(panel_1);
		
		JLabel lblDoctorLogin = new JLabel("DOCTOR LOGIN");
		lblDoctorLogin.setForeground(new Color(0, 153, 255));
		lblDoctorLogin.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDoctorLogin.setBackground(Color.WHITE);
		lblDoctorLogin.setBounds(72, 21, 241, 58);
		panel_1.add(lblDoctorLogin);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Doctor_Login.class.getResource("/Images/LOGIN.png")));
		label_2.setBounds(44, 120, 48, 48);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Doctor_Login.class.getResource("/Images/PASSWORD.png")));
		label_3.setBounds(44, 199, 48, 48);
		panel_1.add(label_3);
		
		username = new JTextField("");
		username.setColumns(10);
		username.setBounds(102, 134, 194, 27);
		panel_1.add(username);
		
		JButton button_1 = new JButton("LOGIN");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String us=username.getText().toUpperCase().trim();
					String ps=new String(password.getPassword());
					ResultSet rs=stmt.executeQuery("Select * From dept where D_ID='"+us+"' and PASSWORD='"+ps+"'");
					if(rs.next()){
						//JOptionPane.showMessageDialog(null,"LOGIN Succesfull");
						Doctor_workpage ap=new Doctor_workpage();
						ap.setVisible(true);
						ap.setLocationRelativeTo(null);;
						dispose();
					}else{
						JOptionPane.showMessageDialog(null,"LOGIN UnSuccesfull");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button_1.setForeground(new Color(0, 153, 255));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(130, 277, 109, 27);
		button_1.setBorder(br);
		panel_1.add(button_1);
		
		password = new JPasswordField();
		password.setBounds(102, 210, 194, 27);
		panel_1.add(password);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Doctor_Login.class.getResource("/Images/recept.back.png")));
		label.setBounds(0, 0, 1264, 681);
		panel.add(label);
	}
}
