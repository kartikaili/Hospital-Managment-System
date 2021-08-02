import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;


public class Patientpage extends JFrame {

	private JPanel contentPane;
	private JTextField P_id1;
	private JTextField fname1;
	private JTextField lname1;
	private JTextField age1;
	private JTextField address1;
	private JTextField phno1;
	private JTextField city1;
	private JTextField pdate1;
	private JTextField P_id2;
	private JTextField fname2;
	private JTextField lname2;
	private JTextField age2;
	private JTextField address2;
	private JTextField phno2;
	private JTextField city2;
	private JTextField pdate2;
	private JTextField P_id3;
	private JTextField fname3;
	private JTextField lname3;
	private JTextField age3;
	private JTextField address3;
	private JTextField phno3;
	private JTextField city3;
	private JTextField pdate3;

	/**
	 * Launch the application.
	 */
	Connection conn=null;
	Statement stmt=null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patientpage frame = new Patientpage();
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
	public Patientpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Border br=BorderFactory.createLineBorder(new Color(0,153,255));
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1264, 681);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Patient", new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\add (5).png"), panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(true);
		panel_3.setBackground(new Color(255, 255, 255, 200));
		panel_3.setBounds(121, 0, 1138, 617);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(30, 144, 255));
		panel_4.setBounds(0, 31, 1138, 57);
		panel_3.add(panel_4);
		
		JLabel lblAddPatient = new JLabel("ADD Patient");
		lblAddPatient.setForeground(Color.WHITE);
		lblAddPatient.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddPatient.setBounds(10, 11, 184, 35);
		panel_4.add(lblAddPatient);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminpage ap=new Adminpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\back (2).png"));
		button.setBounds(1068, 0, 70, 57);
		panel_4.add(button);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setForeground(new Color(0, 153, 255));
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPatientId.setBounds(10, 124, 107, 29);
		panel_3.add(lblPatientId);
		
		P_id1 = new JTextField();
		P_id1.setColumns(10);
		P_id1.setBounds(133, 124, 167, 28);
		panel_3.add(P_id1);
		
		JLabel label_5 = new JLabel("First Name");
		label_5.setForeground(new Color(0, 153, 255));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(10, 191, 107, 19);
		panel_3.add(label_5);
		
		fname1 = new JTextField();
		fname1.setColumns(10);
		fname1.setBounds(133, 188, 167, 28);
		panel_3.add(fname1);
		
		JLabel label_6 = new JLabel("Last Name");
		label_6.setForeground(new Color(0, 153, 255));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(356, 195, 107, 19);
		panel_3.add(label_6);
		
		lname1 = new JTextField();
		lname1.setColumns(10);
		lname1.setBounds(483, 188, 167, 28);
		panel_3.add(lname1);
		
		JLabel label_7 = new JLabel("Age");
		label_7.setForeground(new Color(0, 153, 255));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(10, 254, 107, 19);
		panel_3.add(label_7);
		
		age1 = new JTextField();
		age1.setColumns(10);
		age1.setBounds(133, 251, 167, 28);
		panel_3.add(age1);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(133, 510, 167, 29);
		panel_3.add(comboBox);
		
		JLabel lblPatientType = new JLabel("Patient Type");
		lblPatientType.setForeground(new Color(0, 153, 255));
		lblPatientType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPatientType.setBounds(10, 515, 107, 19);
		panel_3.add(lblPatientType);
		
		JLabel label_9 = new JLabel("Gender");
		label_9.setForeground(new Color(0, 153, 255));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(10, 305, 107, 19);
		panel_3.add(label_9);
		
		String gender[]={"--SELECT--","Male","Female"};
		final JComboBox gdr1 = new JComboBox(gender);
		gdr1.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "Male", "Female"}));
		gdr1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr1.setBounds(133, 302, 167, 28);
		panel_3.add(gdr1);
		
		JLabel label_10 = new JLabel("Address");
		label_10.setForeground(new Color(0, 153, 255));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(10, 358, 107, 19);
		panel_3.add(label_10);
		
		address1 = new JTextField();
		address1.setColumns(10);
		address1.setBounds(133, 355, 507, 28);
		panel_3.add(address1);
		
		JLabel label_11 = new JLabel("Phone Number");
		label_11.setForeground(new Color(0, 153, 255));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(10, 412, 120, 19);
		panel_3.add(label_11);
		
		phno1 = new JTextField();
		phno1.setColumns(10);
		phno1.setBounds(133, 403, 167, 28);
		panel_3.add(phno1);
		
		JLabel label_12 = new JLabel("City");
		label_12.setForeground(new Color(0, 153, 255));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_12.setBounds(356, 412, 107, 19);
		panel_3.add(label_12);
		
		city1 = new JTextField();
		city1.setColumns(10);
		city1.setBounds(483, 409, 167, 28);
		panel_3.add(city1);
		
		JLabel lblBedNo = new JLabel("Bed No");
		lblBedNo.setForeground(new Color(0, 153, 255));
		lblBedNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBedNo.setBounds(355, 515, 120, 19);
		panel_3.add(lblBedNo);
		
		JComboBox comboBox_2 = new JComboBox(new Object[]{});
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(483, 510, 167, 28);
		panel_3.add(comboBox_2);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 153, 255));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(10, 463, 107, 19);
		panel_3.add(lblDate);
		
		pdate1 = new JTextField();
		pdate1.setColumns(10);
		pdate1.setBounds(133, 454, 167, 28);
		panel_3.add(pdate1);
		
		String bloodgrp[]={"A","A+","B","B+","AB","AB-","O+","O-"};
		final JComboBox bldgrp1 = new JComboBox(bloodgrp);
		bldgrp1.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bldgrp1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bldgrp1.setBackground(Color.WHITE);
		bldgrp1.setBounds(483, 244, 167, 29);
		panel_3.add(bldgrp1);
		
		JButton btnAddPatient = new JButton("ADD Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String pid=P_id1.getText().trim();
					String fname=fname1.getText().trim();
					String lname=lname1.getText().trim();
					String Age=age1.getText().trim();
					String bld_grp=(String) bldgrp1.getItemAt(bldgrp1.getSelectedIndex());
					String gendr=(String) gdr1.getItemAt(gdr1.getSelectedIndex());
					String adrs=address1.getText();
					long phno=Long.parseLong(phno1.getText());
					String cty=city1.getText();
					String pdate=pdate1.getText().trim();
					
					int patient_insert=stmt.executeUpdate("insert into patient_details values('"+pid+"','"+fname+"','"+lname+"','"+Age+"','"+bld_grp+"','"+gendr+"','"+adrs+"','"+phno+"','"+cty+"', TO_DATE('"+pdate+"','DD-MM-YYYY'))");
					if(patient_insert==1){
						JOptionPane.showMessageDialog(null,"Record Inserted Sucessfully");
					}else{
						JOptionPane.showMessageDialog(null,"Record Inserted UnSucessfully");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnAddPatient.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\adduser.png"));
		btnAddPatient.setForeground(new Color(30, 144, 255));
		btnAddPatient.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddPatient.setBounds(703, 450, 185, 33);
		btnAddPatient.setBorder(br);
		panel_3.add(btnAddPatient);
		
		JButton button_2 = new JButton("CLEAR");
		button_2.setBorder(br);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setForeground(new Color(30, 144, 255));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBounds(944, 450, 161, 33);
		panel_3.add(button_2);
		
		JLabel label_16 = new JLabel("");
		label_16.setOpaque(true);
		label_16.setBackground(Color.WHITE);
		label_16.setBorder(br);
		label_16.setBounds(820, 124, 204, 222);
		panel_3.add(label_16);
		
		JButton button_3 = new JButton("BROWSE");
		button_3.setForeground(new Color(30, 144, 255));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBounds(840, 358, 161, 33);
		button_3.setBorder(br);
		panel_3.add(button_3);
		
		JLabel label_3 = new JLabel("Blood Group");
		label_3.setForeground(new Color(0, 153, 255));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(356, 249, 107, 19);
		panel_3.add(label_3);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\899156.jpg"));
		label.setBounds(0, 0, 1259, 653);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Delete Patient", new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\removeuser.png"), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setOpaque(true);
		panel_5.setBackground(new Color(255, 255, 255, 200));
		panel_5.setBounds(121, 0, 1138, 617);
		panel_1.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(30, 144, 255));
		panel_6.setBounds(0, 31, 1138, 57);
		panel_5.add(panel_6);
		
		JLabel lblDeletePatient = new JLabel("Delete Patient");
		lblDeletePatient.setForeground(Color.WHITE);
		lblDeletePatient.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDeletePatient.setBounds(10, 11, 184, 35);
		panel_6.add(lblDeletePatient);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminpage ap=new Adminpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\back (2).png"));
		button_1.setBounds(1068, 0, 70, 57);
		panel_6.add(button_1);
		
		JLabel label_8 = new JLabel("Patient ID");
		label_8.setForeground(new Color(0, 153, 255));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_8.setBounds(10, 124, 107, 29);
		panel_5.add(label_8);
		
		P_id2 = new JTextField();
		P_id2.setColumns(10);
		P_id2.setBounds(133, 124, 167, 28);
		panel_5.add(P_id2);
		
		JLabel label_13 = new JLabel("First Name");
		label_13.setForeground(new Color(0, 153, 255));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_13.setBounds(10, 191, 107, 19);
		panel_5.add(label_13);
		
		fname2 = new JTextField();
		fname2.setColumns(10);
		fname2.setBounds(133, 188, 167, 28);
		panel_5.add(fname2);
		
		JLabel label_14 = new JLabel("Last Name");
		label_14.setForeground(new Color(0, 153, 255));
		label_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_14.setBounds(356, 195, 107, 19);
		panel_5.add(label_14);
		
		lname2 = new JTextField();
		lname2.setColumns(10);
		lname2.setBounds(483, 188, 167, 28);
		panel_5.add(lname2);
		
		JLabel label_15 = new JLabel("Age");
		label_15.setForeground(new Color(0, 153, 255));
		label_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_15.setBounds(10, 254, 107, 19);
		panel_5.add(label_15);
		
		age2 = new JTextField();
		age2.setColumns(10);
		age2.setBounds(133, 251, 167, 28);
		panel_5.add(age2);
		
		JComboBox comboBox_4 = new JComboBox(new Object[]{});
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(133, 510, 167, 29);
		panel_5.add(comboBox_4);
		
		JLabel label_17 = new JLabel("Patient Type");
		label_17.setForeground(new Color(0, 153, 255));
		label_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_17.setBounds(10, 515, 107, 19);
		panel_5.add(label_17);
		
		JLabel label_18 = new JLabel("Gender");
		label_18.setForeground(new Color(0, 153, 255));
		label_18.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_18.setBounds(10, 305, 107, 19);
		panel_5.add(label_18);
		
		final JComboBox gdr2 = new JComboBox(gender);
		gdr2.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "Male", "Female"}));
		gdr2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr2.setBounds(133, 302, 167, 28);
		panel_5.add(gdr2);
		
		JLabel label_19 = new JLabel("Address");
		label_19.setForeground(new Color(0, 153, 255));
		label_19.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_19.setBounds(10, 358, 107, 19);
		panel_5.add(label_19);
		
		address2 = new JTextField();
		address2.setColumns(10);
		address2.setBounds(133, 355, 507, 28);
		panel_5.add(address2);
		
		JLabel label_20 = new JLabel("Phone Number");
		label_20.setForeground(new Color(0, 153, 255));
		label_20.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_20.setBounds(10, 412, 120, 19);
		panel_5.add(label_20);
		
		phno2 = new JTextField();
		phno2.setColumns(10);
		phno2.setBounds(133, 403, 167, 28);
		panel_5.add(phno2);
		
		JLabel label_21 = new JLabel("City");
		label_21.setForeground(new Color(0, 153, 255));
		label_21.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_21.setBounds(356, 412, 107, 19);
		panel_5.add(label_21);
		
		city2 = new JTextField();
		city2.setColumns(10);
		city2.setBounds(483, 409, 167, 28);
		panel_5.add(city2);
		
		JLabel label_22 = new JLabel("Bed No");
		label_22.setForeground(new Color(0, 153, 255));
		label_22.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_22.setBounds(355, 515, 120, 19);
		panel_5.add(label_22);
		
		JComboBox comboBox_6 = new JComboBox(new Object[]{});
		comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_6.setBounds(483, 510, 167, 28);
		panel_5.add(comboBox_6);
		
		JLabel label_23 = new JLabel("Date");
		label_23.setForeground(new Color(0, 153, 255));
		label_23.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_23.setBounds(10, 463, 107, 19);
		panel_5.add(label_23);
		
		pdate2 = new JTextField();
		pdate2.setColumns(10);
		pdate2.setBounds(133, 454, 167, 28);
		panel_5.add(pdate2);
		
		JButton btnDeletePatient = new JButton("Delete Patient");
		btnDeletePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String id_dlt=P_id2.getText().trim();
					int rs2=stmt.executeUpdate("delete from patient_details where P_ID='"+id_dlt+"'");
					if(rs2==1){
						JOptionPane.showMessageDialog(null, "Record Deleted Succesfully");
					}else{
						JOptionPane.showMessageDialog(null, "Record not deleted");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnDeletePatient.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\DELETESMALL.png"));
		btnDeletePatient.setForeground(new Color(30, 144, 255));
		btnDeletePatient.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeletePatient.setBounds(820, 373, 207, 33);
		btnDeletePatient.setBorder(br);
		panel_5.add(btnDeletePatient);
		
		
		final JComboBox bldgrp2 = new JComboBox(bloodgrp);
		bldgrp2.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bldgrp2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bldgrp2.setBackground(Color.WHITE);
		bldgrp2.setBounds(483, 244, 167, 29);
		panel_5.add(bldgrp2);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String id=P_id2.getText().trim();
					ResultSet rs_expt1=stmt.executeQuery("select * from patient_details where P_ID='"+id+"'");
					if(rs_expt1.next()){
						fname2.setText(rs_expt1.getString(2));
						lname2.setText(rs_expt1.getString(3));
						age2.setText(rs_expt1.getString(4));
						bldgrp2.setSelectedItem(rs_expt1.getString(5));
						gdr2.setSelectedItem(rs_expt1.getString(6));
						address2.setText(rs_expt1.getString(7));
						String st=String.valueOf(rs_expt1.getLong(8)).trim();
						phno2.setText(st);
						city2.setText(rs_expt1.getString(9));
						ResultSet rs1=stmt.executeQuery("select TO_CHAR(P_DATE,'DD-MM-YYYY') from patient_details where P_ID='"+id+"'");
						rs1.next();
						pdate2.setText(rs1.getString(1));
					}else{
						JOptionPane.showMessageDialog(null," Record Not Found");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(356, 120, 161, 33);
		btnSearch.setBorder(br);
		panel_5.add(btnSearch);
		
		JLabel label_24 = new JLabel("");
		label_24.setOpaque(true);
		label_24.setBackground(Color.WHITE);
		label_24.setBounds(820, 124, 204, 222);
		label_24.setBorder(br);
		panel_5.add(label_24);
		
		JLabel label_25 = new JLabel("Blood Group");
		label_25.setForeground(new Color(0, 153, 255));
		label_25.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_25.setBounds(356, 249, 107, 19);
		panel_5.add(label_25);
		
		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\899156.jpg"));
		label_1.setBounds(0, 0, 1259, 617);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update Patient", new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\updateuser (2).png"), panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setOpaque(true);
		panel_7.setBackground(new Color(255, 255, 255, 200));
		panel_7.setBounds(121, 0, 1138, 617);
		panel_2.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(30, 144, 255));
		panel_8.setBounds(0, 31, 1138, 57);
		panel_7.add(panel_8);
		
		JLabel lblUpdatePatient = new JLabel("Update Patient");
		lblUpdatePatient.setForeground(Color.WHITE);
		lblUpdatePatient.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUpdatePatient.setBounds(10, 11, 219, 35);
		panel_8.add(lblUpdatePatient);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminpage ap=new Adminpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button_4.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\back (2).png"));
		button_4.setBounds(1068, 0, 70, 57);
		panel_8.add(button_4);
		
		JLabel label_26 = new JLabel("Patient ID");
		label_26.setForeground(new Color(0, 153, 255));
		label_26.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_26.setBounds(10, 124, 107, 29);
		panel_7.add(label_26);
		
		P_id3 = new JTextField();
		P_id3.setColumns(10);
		P_id3.setBounds(133, 124, 167, 28);
		panel_7.add(P_id3);
		
		JLabel label_27 = new JLabel("First Name");
		label_27.setForeground(new Color(0, 153, 255));
		label_27.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_27.setBounds(10, 191, 107, 19);
		panel_7.add(label_27);
		
		fname3 = new JTextField();
		fname3.setColumns(10);
		fname3.setBounds(133, 188, 167, 28);
		panel_7.add(fname3);
		
		JLabel label_28 = new JLabel("Last Name");
		label_28.setForeground(new Color(0, 153, 255));
		label_28.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_28.setBounds(356, 195, 107, 19);
		panel_7.add(label_28);
		
		lname3 = new JTextField();
		lname3.setColumns(10);
		lname3.setBounds(483, 188, 167, 28);
		panel_7.add(lname3);
		
		JLabel label_29 = new JLabel("Age");
		label_29.setForeground(new Color(0, 153, 255));
		label_29.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_29.setBounds(10, 254, 107, 19);
		panel_7.add(label_29);
		
		age3 = new JTextField();
		age3.setColumns(10);
		age3.setBounds(133, 251, 167, 28);
		panel_7.add(age3);
		
		JComboBox comboBox_8 = new JComboBox(new Object[]{});
		comboBox_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_8.setBackground(Color.WHITE);
		comboBox_8.setBounds(133, 510, 167, 29);
		panel_7.add(comboBox_8);
		
		JLabel label_30 = new JLabel("Patient Type");
		label_30.setForeground(new Color(0, 153, 255));
		label_30.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_30.setBounds(10, 515, 107, 19);
		panel_7.add(label_30);
		
		JLabel label_31 = new JLabel("Gender");
		label_31.setForeground(new Color(0, 153, 255));
		label_31.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_31.setBounds(10, 305, 107, 19);
		panel_7.add(label_31);
		
		
		
		JLabel label_32 = new JLabel("Address");
		label_32.setForeground(new Color(0, 153, 255));
		label_32.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_32.setBounds(10, 358, 107, 19);
		panel_7.add(label_32);
		
		address3 = new JTextField();
		address3.setColumns(10);
		address3.setBounds(133, 355, 507, 28);
		panel_7.add(address3);
		
		JLabel label_33 = new JLabel("Phone Number");
		label_33.setForeground(new Color(0, 153, 255));
		label_33.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_33.setBounds(10, 412, 120, 19);
		panel_7.add(label_33);
		
		phno3 = new JTextField();
		phno3.setColumns(10);
		phno3.setBounds(133, 403, 167, 28);
		panel_7.add(phno3);
		
		JLabel label_34 = new JLabel("City");
		label_34.setForeground(new Color(0, 153, 255));
		label_34.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_34.setBounds(356, 412, 107, 19);
		panel_7.add(label_34);
		
		city3 = new JTextField();
		city3.setColumns(10);
		city3.setBounds(483, 409, 167, 28);
		panel_7.add(city3);
		
		JLabel label_35 = new JLabel("Bed No");
		label_35.setForeground(new Color(0, 153, 255));
		label_35.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_35.setBounds(355, 515, 120, 19);
		panel_7.add(label_35);
		
		JComboBox comboBox_10 = new JComboBox(new Object[]{});
		comboBox_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_10.setBounds(483, 510, 167, 28);
		panel_7.add(comboBox_10);
		
		JLabel label_36 = new JLabel("Date");
		label_36.setForeground(new Color(0, 153, 255));
		label_36.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_36.setBounds(10, 463, 107, 19);
		panel_7.add(label_36);
		
		pdate3 = new JTextField();
		pdate3.setColumns(10);
		pdate3.setBounds(133, 454, 167, 28);
		panel_7.add(pdate3);
		
		final JComboBox bldgrp3 = new JComboBox(bloodgrp);
		bldgrp3.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bldgrp3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bldgrp3.setBackground(Color.WHITE);
		bldgrp3.setBounds(483, 244, 167, 29);
		panel_7.add(bldgrp3);
		
		final JComboBox gdr3 = new JComboBox(gender);
		gdr3.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "Male", "Female"}));
		gdr3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr3.setBounds(133, 302, 167, 28);
		panel_7.add(gdr3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String pid=P_id3.getText().trim();
					String fname=fname3.getText().trim();
					String lname=lname3.getText().trim();
					String Age=age3.getText().trim();
					String bld_grp=(String) bldgrp3.getItemAt(bldgrp3.getSelectedIndex());
					String gendr=(String) gdr3.getItemAt(gdr3.getSelectedIndex());
					String adrs=address3.getText();
					long phno=Long.parseLong(phno3.getText());
					String cty=city3.getText();
					String pdate=pdate3.getText().trim();
					int result_upt=stmt.executeUpdate("update patient_details set FNAME='"+fname+"', LNAME='"+lname+"',AGE='"+Age+"', BLD_GRP='"+bld_grp+"', GENDER='"+gendr+"',ADDRESS='"+adrs+"', PHONE_NO='"+phno+"', CITY='"+cty+"',P_DATE=TO_DATE('"+pdate+"','DD-MM-YYYY') where P_ID='"+pid+"'");
					if(result_upt==1){
						JOptionPane.showMessageDialog(null, "Records Updated");
					}else{
						JOptionPane.showMessageDialog(null, "Records not Updated");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\UPDATESMALL.png"));
		btnUpdate.setForeground(new Color(30, 144, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(850, 405, 144, 33);
		btnUpdate.setBorder(br);
		panel_7.add(btnUpdate);
		
		
		
		JButton button_6 = new JButton("SEARCH");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String id=P_id3.getText().trim();
					ResultSet rs_expt1=stmt.executeQuery("select * from patient_details where P_ID='"+id+"'");
					if(rs_expt1.next()){
						fname3.setText(rs_expt1.getString(2));
						lname3.setText(rs_expt1.getString(3));
						age3.setText(rs_expt1.getString(4));
						bldgrp3.setSelectedItem(rs_expt1.getString(5));
						gdr3.setSelectedItem(rs_expt1.getString(6));
						address3.setText(rs_expt1.getString(7));
						String st=String.valueOf(rs_expt1.getLong(8)).trim();
						phno3.setText(st);
						city3.setText(rs_expt1.getString(9));
						ResultSet rs1=stmt.executeQuery("select TO_CHAR(P_DATE,'DD-MM-YYYY') from patient_details where P_ID='"+id+"'");
						rs1.next();
						pdate3.setText(rs1.getString(1));
					}else{
						JOptionPane.showMessageDialog(null," Record Not Found");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button_6.setForeground(new Color(30, 144, 255));
		button_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_6.setBounds(356, 120, 161, 33);
		button_6.setBorder(br);
		panel_7.add(button_6);
		
		JLabel label_37 = new JLabel("");
		label_37.setOpaque(true);
		label_37.setBackground(Color.WHITE);
		label_37.setBounds(820, 124, 204, 222);
		label_37.setBorder(br);
		panel_7.add(label_37);
		
		JLabel label_38 = new JLabel("Blood Group");
		label_38.setForeground(new Color(0, 153, 255));
		label_38.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_38.setBounds(356, 249, 107, 19);
		panel_7.add(label_38);
		
		
		
		JButton button_5 = new JButton("BROWSE");
		button_5.setForeground(new Color(30, 144, 255));
		button_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_5.setBounds(840, 351, 161, 33);
		button_5.setBorder(br);
		panel_7.add(button_5);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 1259, 617);
		label_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\899156.jpg"));
		panel_2.add(label_2);
	}
}
