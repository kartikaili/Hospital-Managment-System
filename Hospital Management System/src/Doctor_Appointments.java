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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Doctor_Appointments extends JFrame {

	private JPanel contentPane;
	private JTextField did;
	private JTable table;

	/**
	 * Launch the application.
	 */
	Connection conn=null;
	Statement stmt=null;
	String id1;
	private JTextField pid;
	private JTable table_1;
	String P_ID1;
	String P_Name1;
	String D_ID1;
	String D_Name1;
	private JTable table_2;
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
	public void showAppointmenttable(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
			stmt = conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from appointment order by did,pid");
			
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			
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
					frame.showAppointmenttable();
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int SelectedRow =table.getSelectedRow();
				DefaultTableModel tbl=(DefaultTableModel)table.getModel();
				D_ID1=tbl.getValueAt(SelectedRow, 0).toString();
				String D_FName=tbl.getValueAt(SelectedRow, 1).toString();
				String D_Lname=tbl.getValueAt(SelectedRow, 2).toString();
				D_Name1=D_FName+" "+D_Lname;
			}
		});
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
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recpt_workpage ap=new Recpt_workpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(Doctor_Appointments.class.getResource("/Images/back (2).png")));
		button_2.setForeground(new Color(0, 153, 255));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_2.setBounds(0, 0, 63, 55);
		panel_2.add(button_2);
		
		JLabel lblNewLabel000000000000000000000000000000000000 = new JLabel("");
		lblNewLabel000000000000000000000000000000000000.setIcon(new ImageIcon(Doctor_Appointments.class.getResource("/Images/historypic.jpg")));
		lblNewLabel000000000000000000000000000000000000.setBounds(0, 0, 1259, 653);
		panel.add(lblNewLabel000000000000000000000000000000000000);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Patient Appointments", new ImageIcon(Doctor_Appointments.class.getResource("/Images/add (5).png")), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255, 200));
		panel_3.setBounds(0, 0, 1259, 617);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPatientsId = new JLabel("Patients ID");
		lblPatientsId.setForeground(new Color(0, 153, 255));
		lblPatientsId.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPatientsId.setBounds(252, 33, 151, 28);
		panel_3.add(lblPatientsId);
		
		pid = new JTextField();
		pid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pid.setColumns(10);
		pid.setBounds(419, 33, 350, 28);
		panel_3.add(pid);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setBounds(257, 422, 185, 33);
		panel_3.add(dateChooser);
		
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
		button.setBounds(797, 31, 185, 33);
		panel_3.add(button);
		
		JButton button_1 = new JButton("Display");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showpatienttable();
			}
		});
		button_1.setForeground(new Color(30, 144, 255));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(476, 89, 185, 33);
		panel_3.add(button_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(174, 133, 818, 278);
		panel_3.add(scrollPane_1);
		
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int SelectedRow =table_1.getSelectedRow();
				DefaultTableModel tbl=(DefaultTableModel)table_1.getModel();
				P_ID1=tbl.getValueAt(SelectedRow, 0).toString();
				String P_FName=tbl.getValueAt(SelectedRow, 1).toString();
				String P_Lname=tbl.getValueAt(SelectedRow, 2).toString();
				P_Name1=P_FName+" "+P_Lname;
			}
		});
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, "", null, null, null},
				},
				new String[] {
					"P_ID", "FNAME", "LNAME", "AGE", "BLOOD GROUP", "GENDER", "ADDRESS", "PH_NO", "CITY", "DATE"
				}
			));
		scrollPane_1.setViewportView(table_1);
		
		JLabel label_2 = new JLabel("Date");
		label_2.setForeground(new Color(0, 153, 255));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(174, 422, 73, 33);
		panel_3.add(label_2);
		
		final JComboBox time = new JComboBox();
		time.setModel(new DefaultComboBoxModel(new String[] {"Choose Time", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM"}));
		time.setBounds(816, 422, 180, 28);
		panel_3.add(time);
		
		JLabel lblTime = new JLabel("Appointment Time");
		lblTime.setForeground(new Color(0, 153, 255));
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTime.setBounds(646, 422, 157, 33);
		panel_3.add(lblTime);
		
		JButton btnCreateAppointment = new JButton("Create Appointment");
		btnCreateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String D_ID2=D_ID1;
					String P_ID2=P_ID1;
					String D_Name2=D_Name1;
					String P_Name2=P_Name1;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String Appoint_date = sdf.format(dateChooser.getDate());
					String Appoint_time=(String) time.getItemAt(time.getSelectedIndex());
					
					ResultSet rs_expt=stmt.executeQuery("select * from appointment where PID='"+P_ID2+"'");
					if(rs_expt.next()){
						JOptionPane.showMessageDialog(null, "Patirnt already have an appointment with a doctor");
					}else{
						int appointment=stmt.executeUpdate("insert into Appointment values('"+D_ID2+"','"+D_Name2+"','"+P_ID2+"','"+P_Name2+"',TO_DATE('"+Appoint_date+"','YYYY-MM-DD'),'"+Appoint_time+"')");
						if(appointment==1){
							JOptionPane.showMessageDialog(null, "Patient "+P_Name2+" has been Appointed to "+D_Name2+" on "+Appoint_date+" at "+Appoint_time+"");
							showAppointmenttable();
						}else{
							JOptionPane.showMessageDialog(null, "Patirnt not Appointed");
						}
					}
						
				}catch(SQLException e){
					JOptionPane.showMessageDialog(null, "Plese Select Doctor and patient both");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnCreateAppointment.setForeground(new Color(30, 144, 255));
		btnCreateAppointment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreateAppointment.setBounds(420, 504, 257, 33);
		panel_3.add(btnCreateAppointment);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		button_3.setIcon(new ImageIcon(Doctor_Appointments.class.getResource("/Images/back (2).png")));
		button_3.setForeground(new Color(0, 153, 255));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_3.setBounds(0, 0, 63, 55);
		panel_3.add(button_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Doctor_Appointments.class.getResource("/Images/historypic.jpg")));
		label.setBounds(0, 0, 1259, 653);
		panel_1.add(label);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("View Appointments", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 56, 1259, 561);
		panel_5.setBackground(new Color(255,255,255,200));
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(64, 61, 818, 371);
		panel_5.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					int SelectedRow =table_2.getSelectedRow();
					DefaultTableModel tbl=(DefaultTableModel)table_2.getModel();
					//id=(String) tbl.getValueAt(SelectedRow, 0);
					id1=(String) tbl.getValueAt(SelectedRow, 2);
					
					
			}
		});
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Doctor ID", "Doctor Name", "Pateint Id", "Patient Name", "Appointment Date", "Appointment Date"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JButton btnDisplayAppointments = new JButton("Display Appointments");
		btnDisplayAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAppointmenttable();
			}
		});
		btnDisplayAppointments.setForeground(new Color(30, 144, 255));
		btnDisplayAppointments.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplayAppointments.setBounds(916, 64, 257, 33);
		panel_5.add(btnDisplayAppointments);
		
		JButton btnDeleteAppointments = new JButton("Delete Appointments");
		btnDeleteAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					ResultSet rs_expt=stmt.executeQuery("select * from appointment where PID='"+id1+"'");
					if(rs_expt.next()){
						int rs2=stmt.executeUpdate("delete from appointment where PID='"+id1+"' ");
						if(rs2==1){
							JOptionPane.showMessageDialog(null, "Appointment deleted");
							showAppointmenttable();
						}else{
							JOptionPane.showMessageDialog(null, "Appointment not deleted");
						}
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnDeleteAppointments.setForeground(new Color(30, 144, 255));
		btnDeleteAppointments.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteAppointments.setBounds(916, 183, 257, 33);
		panel_5.add(btnDeleteAppointments);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(0, 153, 255));
		panel_6.setBounds(0, 1, 1259, 55);
		panel_4.add(panel_6);
		
		JLabel lblPatientAppointmentsDetails = new JLabel("PATIENT APPOINTMENTS DETAILS");
		lblPatientAppointmentsDetails.setForeground(Color.WHITE);
		lblPatientAppointmentsDetails.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPatientAppointmentsDetails.setBounds(432, 11, 438, 31);
		panel_6.add(lblPatientAppointmentsDetails);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		button_4.setIcon(new ImageIcon(Doctor_Appointments.class.getResource("/Images/back (2).png")));
		button_4.setForeground(new Color(0, 153, 255));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_4.setBounds(0, 0, 63, 55);
		panel_6.add(button_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Doctor_Appointments.class.getResource("/Images/historypic.jpg")));
		lblNewLabel.setBounds(0, 0, 1259, 617);
		panel_4.add(lblNewLabel);
	}
}
