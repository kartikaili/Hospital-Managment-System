import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javafx.scene.control.DatePicker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;


public class Doctor_Appointments extends JFrame {

	private JPanel contentPane;
	private JTextField did;
	private JTable table;

	/**
	 * Launch the application.
	 */
	Connection conn=null;
	Statement stmt=null;
	private JTextField pid;
	private JTable table_1;
	public void showTableData(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
			stmt = conn.createStatement();
			//PreparedStatement pst = conn.prepareStatement("SELECT * FROM Receptionist_details");
			ResultSet rs=stmt.executeQuery("select d_id,fname,lname,age,bld_grp,gender,MARITAL_STS,address,phone_no,city from dept ORDER BY D_ID ASC");
			//if(rs.next()){
				table.setModel(DbUtils.resultSetToTableModel(rs));
			//}
			//table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e){
			
		}
	}
	
	public void showpatienttable(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
			stmt = conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM patient_details ORDER BY P_ID ASC");
			table_1.setModel(DbUtils.resultSetToTableModel(rs));	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Appointments frame = new Doctor_Appointments();
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
	public Doctor_Appointments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280,720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1264, 681);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Doctors Appointment", new ImageIcon(Doctor_Appointments.class.getResource("/Images/add (5).png")), panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255,255,255,200));
		panel_2.setBounds(0, 0, 1259, 653);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("Doctor ID");
		label_1.setForeground(new Color(0, 153, 255));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		label_1.setBounds(268, 83, 151, 28);
		panel_2.add(label_1);
		
		did = new JTextField();
		did.setFont(new Font("Tahoma", Font.PLAIN, 16));
		did.setColumns(10);
		did.setBounds(435, 83, 350, 28);
		panel_2.add(did);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String id=did.getText().toUpperCase().trim();
					ResultSet rs=stmt.executeQuery("select * from dept where d_id='"+id+"'");
					if(rs.next()){
						try{
							ResultSet rs1=stmt.executeQuery("select d_id,fname,lname,age,bld_grp,gender,MARITAL_STS,address,phone_no,city from dept where d_id='"+id+"'");
							table.setModel(DbUtils.resultSetToTableModel(rs1));
							
						}catch(Exception e){
							e.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Doctor Id does not exist");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(481, 140, 185, 33);
		panel_2.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 257, 818, 278);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"D_ID", "FNAME", "LNAME", "AGE", "BLD_GRP", "GENDER", "MARITAL_STS", "ADDRESS", "PHONE_NO", "CITY"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNext.setForeground(new Color(30, 144, 255));
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNext.setBounds(821, 570, 185, 33);
		panel_2.add(btnNext);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
			}
		});
		btnDisplay.setForeground(new Color(30, 144, 255));
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplay.setBounds(481, 196, 185, 33);
		panel_2.add(btnDisplay);
		
		JLabel lblNewLabel000000000000000000000000000000000000 = new JLabel("");
		lblNewLabel000000000000000000000000000000000000.setIcon(new ImageIcon(Doctor_Appointments.class.getResource("/Images/historypic.jpg")));
		lblNewLabel000000000000000000000000000000000000.setBounds(0, 0, 1259, 653);
		panel.add(lblNewLabel000000000000000000000000000000000000);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Patient Appointments", new ImageIcon(Doctor_Appointments.class.getResource("/Images/add (5).png")), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255, 200));
		panel_3.setBounds(0, 0, 1259, 653);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPatientsId = new JLabel("Patients ID");
		lblPatientsId.setForeground(new Color(0, 153, 255));
		lblPatientsId.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPatientsId.setBounds(255, 75, 151, 28);
		panel_3.add(lblPatientsId);
		
		pid = new JTextField();
		pid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pid.setColumns(10);
		pid.setBounds(422, 75, 350, 28);
		panel_3.add(pid);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String id=pid.getText().toUpperCase().trim();
					ResultSet rs=stmt.executeQuery("select p_id from patient_details where P_ID='"+id+"'");
					if(rs.next()){
						try{
							ResultSet rs1=stmt.executeQuery("SELECT * FROM patient_details where P_ID='"+id+"'");
							table_1.setModel(DbUtils.resultSetToTableModel(rs1));
							
						}catch(Exception e){
							e.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Patient Id does not exist");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(468, 132, 185, 33);
		panel_3.add(button);
		
		JButton button_1 = new JButton("Display");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showpatienttable();
			}
		});
		button_1.setForeground(new Color(30, 144, 255));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(468, 188, 185, 33);
		panel_3.add(button_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(187, 249, 818, 278);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, "", null, null, null},
				},
				new String[] {
					"P_ID", "FNAME", "LNAME", "AGE", "BLOOD GROUP", "GENDER", "ADDRESS", "PH_NO", "CITY", "DATE"
				}
			));
		scrollPane_1.setViewportView(table_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Doctor_Appointments.class.getResource("/Images/historypic.jpg")));
		label.setBounds(0, 0, 1259, 653);
		panel_1.add(label);
	}
}
