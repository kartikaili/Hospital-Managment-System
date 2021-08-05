import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Recpt_work extends JFrame {

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
					Recpt_work frame = new Recpt_work();
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
	public Recpt_work() {
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
		
		Border br=BorderFactory.createLineBorder(new Color(0,153,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(true);
		panel_1.setBorder(br);
		panel_1.setBackground(new Color(255, 255, 255, 200));
		panel_1.setBounds(439, 211, 374, 373);
		panel.add(panel_1);
		
		JLabel lblReceptionistLogin = new JLabel("RECEPTIONIST LOGIN");
		lblReceptionistLogin.setForeground(new Color(0, 153, 255));
		lblReceptionistLogin.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblReceptionistLogin.setBackground(Color.WHITE);
		lblReceptionistLogin.setBounds(44, 22, 296, 58);
		panel_1.add(lblReceptionistLogin);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Recpt_work.class.getResource("/Images/LOGIN.png")));
		label_1.setBounds(44, 120, 48, 48);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Recpt_work.class.getResource("/Images/PASSWORD.png")));
		label_2.setBounds(44, 199, 48, 48);
		panel_1.add(label_2);
		
		username = new JTextField("");
		username.setColumns(10);
		username.setBounds(102, 134, 194, 27);
		panel_1.add(username);
		
		JButton button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String us=username.getText().trim();
					String ps=new String(password.getPassword());
					ResultSet rs=stmt.executeQuery("Select * From Receptionist_details where R_ID='"+us+"' and R_PASSWORD='"+ps+"'");
					if(rs.next()){
						//JOptionPane.showMessageDialog(null,"LOGIN Succesfull");
						Recpt_workpage ap=new Recpt_workpage();
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
		button.setForeground(new Color(0, 153, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBackground(Color.WHITE);
		button.setBounds(130, 277, 109, 27);
		button.setBorder(br);
		panel_1.add(button);
		
		password = new JPasswordField();
		password.setBounds(102, 210, 194, 27);
		panel_1.add(password);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mp=new MainPage();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(Recpt_work.class.getResource("/Images/back (2).png")));
		button_1.setOpaque(true);
		button_1.setBounds(0, 130, 93, 59);
		panel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Recpt_work.class.getResource("/Images/recept.back.png")));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		panel.add(lblNewLabel);
	}
	
}
