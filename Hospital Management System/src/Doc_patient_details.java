import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JTextArea;


public class Doc_patient_details extends JFrame {

	private JPanel contentPane;
	private JTextField P_id1;
	private JTextField fname1;
	private JTextField lname1;
	private JTextField age1;
	private JTextField address1;
	private JTextField phno1;
	private JTextField city1;
	private JTextField pdate1;

	/**
	 * Launch the application.
	 */
	Connection conn=null;
	Statement stmt=null;
	
	String arr[]=new String[100];
	private JTextField refid;
	private JTextField dose;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doc_patient_details frame = new Doc_patient_details();
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
	public Doc_patient_details() {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 0, 1264, 55);
		panel.add(panel_1);
		
		JLabel label = new JLabel("PATIENT DETAILS");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(504, 11, 224, 31);
		panel_1.add(label);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Doctor_workpage dw=new Doctor_workpage();
				dw.setVisible(true);
				dw.setLocationRelativeTo(null);
				dw.setResizable(false);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Doc_patient_details.class.getResource("/Images/back (2).png")));
		button.setForeground(new Color(0, 153, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.setBounds(0, 0, 63, 55);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(255, 255, 255, 200));
		panel_2.setBounds(0, 53, 1264, 628);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("Patient ID");
		label_1.setForeground(new Color(0, 153, 255));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(10, 11, 107, 29);
		panel_2.add(label_1);
		
		P_id1 = new JTextField();
		P_id1.setColumns(10);
		P_id1.setBounds(133, 11, 201, 43);
		panel_2.add(P_id1);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setForeground(new Color(0, 153, 255));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(16, 91, 107, 19);
		panel_2.add(label_2);
		
		fname1 = new JTextField();
		fname1.setColumns(10);
		fname1.setBounds(139, 88, 167, 28);
		panel_2.add(fname1);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setForeground(new Color(0, 153, 255));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(316, 91, 107, 19);
		panel_2.add(label_3);
		
		lname1 = new JTextField();
		lname1.setColumns(10);
		lname1.setBounds(443, 88, 167, 28);
		panel_2.add(lname1);
		
		JLabel label_4 = new JLabel("Age");
		label_4.setForeground(new Color(0, 153, 255));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(16, 138, 107, 19);
		panel_2.add(label_4);
		
		age1 = new JTextField();
		age1.setColumns(10);
		age1.setBounds(139, 135, 167, 28);
		panel_2.add(age1);
		
		JLabel label_5 = new JLabel("Blood Group");
		label_5.setForeground(new Color(0, 153, 255));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(16, 191, 107, 19);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Gender");
		label_6.setForeground(new Color(0, 153, 255));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(26, 244, 107, 19);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Address");
		label_7.setForeground(new Color(0, 153, 255));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(21, 295, 107, 19);
		panel_2.add(label_7);
		
		address1 = new JTextField();
		address1.setColumns(10);
		address1.setBounds(144, 292, 348, 28);
		panel_2.add(address1);
		
		JLabel label_8 = new JLabel("Phone Number");
		label_8.setForeground(new Color(0, 153, 255));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(0, 408, 120, 19);
		panel_2.add(label_8);
		
		phno1 = new JTextField();
		phno1.setColumns(10);
		phno1.setBounds(143, 399, 167, 28);
		panel_2.add(phno1);
		
		JLabel label_9 = new JLabel("City");
		label_9.setForeground(new Color(0, 153, 255));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(10, 457, 107, 19);
		panel_2.add(label_9);
		
		city1 = new JTextField();
		city1.setColumns(10);
		city1.setBounds(143, 454, 167, 28);
		panel_2.add(city1);
		
		JLabel label_10 = new JLabel("Date");
		label_10.setForeground(new Color(0, 153, 255));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(21, 354, 107, 19);
		panel_2.add(label_10);
		
		pdate1 = new JTextField();
		pdate1.setColumns(10);
		pdate1.setBounds(144, 345, 167, 28);
		pdate1.setEditable(false);
		panel_2.add(pdate1);
		
		JLabel label_11 = new JLabel("Patient Type");
		label_11.setForeground(new Color(0, 153, 255));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(10, 515, 107, 19);
		panel_2.add(label_11);
		
		final JComboBox pt_bedno = new JComboBox(new Object[]{});
		pt_bedno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pt_bedno.setBounds(143, 566, 167, 28);
		panel_2.add(pt_bedno);
		
		final JComboBox pt_type = new JComboBox(new Object[]{});
		pt_type.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String vl=(String) pt_type.getItemAt(pt_type.getSelectedIndex());
				if(vl.equals("ICU")){
					pt_bedno.removeAllItems();
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
						conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
						stmt = conn.createStatement();
						ResultSet rs=stmt.executeQuery("select Bed_NO from Bed_details where category='"+vl+"' order by Bed_NO asc");
						while(rs.next()){
							pt_bedno.addItem(rs.getString(1));
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}else if(vl.equals("General ward")){
					pt_bedno.removeAllItems();
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
						conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
						stmt = conn.createStatement();
						ResultSet rs=stmt.executeQuery("select Bed_NO from Bed_details where category='"+vl+"' order by Bed_NO asc");
						while(rs.next()){
							pt_bedno.addItem(rs.getString(1));
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}else if(vl.equals("Special ward")){
					pt_bedno.removeAllItems();
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
						conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
						stmt = conn.createStatement();
						ResultSet rs=stmt.executeQuery("select Bed_NO from Bed_details where category='"+vl+"' order by Bed_NO asc");
						while(rs.next()){
							pt_bedno.addItem(rs.getString(1));
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					pt_type.removeAllItems();
				}
			}
		});
		
		pt_type.setModel(new DefaultComboBoxModel(new String[] {"ICU", "Special ward", "General ward"}));
		pt_type.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pt_type.setBackground(Color.WHITE);
		pt_type.setBounds(143, 510, 167, 29);
		panel_2.add(pt_type);
		
		JLabel label_12 = new JLabel("Bed No");
		label_12.setForeground(new Color(0, 153, 255));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_12.setBounds(15, 571, 120, 19);
		panel_2.add(label_12);
		
		final JComboBox bldgrp1 = new JComboBox(new Object[]{});
		bldgrp1.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bldgrp1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bldgrp1.setBackground(Color.WHITE);
		bldgrp1.setBounds(143, 186, 167, 29);
		panel_2.add(bldgrp1);
		
		final JComboBox gdr1 = new JComboBox(new Object[]{});
		gdr1.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gdr1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr1.setBounds(143, 239, 167, 28);
		panel_2.add(gdr1);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setBounds(325, 345, 167, 28);
		panel_2.add(dateChooser);
		
final JComboBox name = new JComboBox(new Object[]{});
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
			stmt = conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select TABLET_NAME from PHARMACY order by REF_ID asc");
			while(rs.next()){
				name.addItem(rs.getString(1));	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		name.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
					String vl=(String) name.getItemAt(name.getSelectedIndex());
					//name.getItemAt(name.getSelectedIndex()).toString())
					
					
						try{
							Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
							conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
							stmt = conn.createStatement();
							ResultSet rs=stmt.executeQuery("select * from PHARMACY where TABLET_NAME='"+vl+"'");
							if(rs.next()){
								
								refid.setText(rs.getString(2));
								dose.setText(rs.getString(3));
								
							}
							
						}catch(Exception e){
							e.printStackTrace();
						}
					
				
			}
		});
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name.setBackground(Color.WHITE);
		name.setBounds(933, 101, 167, 29);
		panel_2.add(name);
		
		refid = new JTextField();
		refid.setColumns(10);
		refid.setBounds(933, 157, 167, 28);
		refid.setEditable(false);
		panel_2.add(refid);
		
		dose = new JTextField();
		dose.setColumns(10);
		dose.setBounds(933, 217, 167, 28);
		dose.setEditable(false);
		panel_2.add(dose);
		
		final JComboBox dd1 = new JComboBox(new Object[]{});
		dd1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		dd1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dd1.setBackground(Color.WHITE);
		dd1.setBounds(933, 268, 167, 29);
		panel_2.add(dd1);
		
		Border br=BorderFactory.createLineBorder(new Color(0,153,255));
		final JTextArea disc = new JTextArea();
		disc.setBounds(817, 354, 243, 200);
		disc.setBorder(br);
		panel_2.add(disc);
		
		JButton button_3 = new JButton("Update Patient");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String pid=P_id1.getText().toUpperCase().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from patient_details where P_ID='"+pid+"'");
					if(rs_expt.next()){
						String fname=fname1.getText().trim();
						String lname=lname1.getText().trim();
						String Age=age1.getText().trim();
						String bld_grp=(String) bldgrp1.getItemAt(bldgrp1.getSelectedIndex());
						String gendr=(String) gdr1.getItemAt(gdr1.getSelectedIndex());
						String adrs=address1.getText();
						long phno=Long.parseLong(phno1.getText());
						String cty=city1.getText();
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						String pdate=sdf.format(dateChooser.getDate());
						String ptype=(String) pt_type.getItemAt(pt_type.getSelectedIndex());
						String pbed=(String) pt_bedno.getItemAt(pt_bedno.getSelectedIndex());
						
						String name1=(String) name.getItemAt(name.getSelectedIndex());
						String rid=refid.getText().trim();
						int dose1=Integer.parseInt(dose.getText().trim());
						int dd=Integer.valueOf(dd1.getItemAt(dd1.getSelectedIndex()).toString());
						String disc1=disc.getText();
						
						ResultSet rs_expt1=stmt.executeQuery("select * from  patient_medicinal_prisc where PID='"+pid+"' and TABLET_NAME='"+name1+"'");
						if(rs_expt1.next()){
							JOptionPane.showMessageDialog(null,"Medicine "+name1+" is already assigned to Patient "+fname);
						}else{
							int result_upt=stmt.executeUpdate("update patient_details set FNAME='"+fname+"', LNAME='"+lname+"',AGE='"+Age+"', BLD_GRP='"+bld_grp+"', GENDER='"+gendr+"',ADDRESS='"+adrs+"', PHONE_NO='"+phno+"', CITY='"+cty+"',P_DATE=TO_DATE('"+pdate+"','DD-MM-YYYY'),PATIENT_TYPE='"+ptype+"', PATIENT_BEDNO='"+pbed+"' where P_ID='"+pid+"'");
							int res=stmt.executeUpdate("insert into patient_medicinal_prisc values('"+pid+"','"+name1+"','"+rid+"','"+dose1+"','"+dd+"','"+disc1+"')");
							if(result_upt==1 && res==1){
								JOptionPane.showMessageDialog(null, "Records Updated");
								
							}else{
								JOptionPane.showMessageDialog(null, "Records not Updated");
							}
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Records not Found");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button_3.setForeground(new Color(30, 144, 255));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBounds(848, 584, 185, 33);
		panel_2.add(button_3);
		
		JButton btnSearchPatient = new JButton("Search Patient");
		btnSearchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String id=P_id1.getText().trim();
					ResultSet rs_expt1=stmt.executeQuery("select * from patient_details where P_ID='"+id+"'");
					if(rs_expt1.next()){
						fname1.setText(rs_expt1.getString(2));
						lname1.setText(rs_expt1.getString(3));
						age1.setText(rs_expt1.getString(4));
						bldgrp1.setSelectedItem(rs_expt1.getString(5));
						gdr1.setSelectedItem(rs_expt1.getString(6));
						address1.setText(rs_expt1.getString(7));
						String st=String.valueOf(rs_expt1.getLong(8)).trim();
						phno1.setText(st);
						city1.setText(rs_expt1.getString(9));
						
						pt_type.setSelectedItem(rs_expt1.getString(11));
						String bedno=rs_expt1.getString(11);
						if(bedno.equals("ICU")){
							pt_bedno.removeAllItems();
							try{
								Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
								conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
								stmt = conn.createStatement();
								ResultSet rs=stmt.executeQuery("select Bed_NO from Bed_details where category='"+bedno+"'");
								while(rs.next()){
									pt_bedno.addItem(rs.getString(1));
								}
								pt_bedno.setSelectedItem(rs_expt1.getString(12));
							}catch(Exception e){
								e.printStackTrace();
							}
						}else if(bedno.equals("General ward")){
							pt_bedno.removeAllItems();
							try{
								Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
								conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
								stmt = conn.createStatement();
								ResultSet rs=stmt.executeQuery("select Bed_NO from Bed_details where category='"+bedno+"'");
								while(rs.next()){
									pt_bedno.addItem(rs.getString(1));
								}
								pt_bedno.setSelectedItem(rs_expt1.getString(12));
							}catch(Exception e){
								e.printStackTrace();
							}
						}
						else if(bedno.equals("Special ward")){
							pt_bedno.removeAllItems();
							try{
								Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
								conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
								stmt = conn.createStatement();
								ResultSet rs=stmt.executeQuery("select Bed_NO from Bed_details where category='"+bedno+"'");
								while(rs.next()){
									pt_bedno.addItem(rs.getString(1));
								}
								pt_bedno.setSelectedItem(rs_expt1.getString(12));
							}catch(Exception e){
								e.printStackTrace();
							}
						}
						ResultSet rs1=stmt.executeQuery("select TO_CHAR(P_DATE,'DD-MM-YYYY') from patient_details where P_ID='"+id+"'");
						rs1.next();
						pdate1.setText(rs1.getString(1));
					}else{
						JOptionPane.showMessageDialog(null," Record Not Found");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnSearchPatient.setForeground(new Color(30, 144, 255));
		btnSearchPatient.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearchPatient.setBounds(386, 14, 185, 33);
		panel_2.add(btnSearchPatient);
		
		JLabel lblMedicinePrisciption = new JLabel("MEDICINE PRISCIPTION");
		lblMedicinePrisciption.setForeground(Color.GREEN);
		lblMedicinePrisciption.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMedicinePrisciption.setBounds(768, 23, 332, 31);
		panel_2.add(lblMedicinePrisciption);
		
		JLabel lblNameOfTablet = new JLabel("Name of Tablet");
		lblNameOfTablet.setForeground(new Color(0, 153, 255));
		lblNameOfTablet.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNameOfTablet.setBounds(775, 106, 132, 19);
		panel_2.add(lblNameOfTablet);
		
		
		JLabel lblRefId = new JLabel("Ref ID");
		lblRefId.setForeground(new Color(0, 153, 255));
		lblRefId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRefId.setBounds(775, 160, 107, 19);
		panel_2.add(lblRefId);
		
		
		JLabel lblDosemg = new JLabel("Dose(mg)");
		lblDosemg.setForeground(new Color(0, 153, 255));
		lblDosemg.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDosemg.setBounds(775, 220, 107, 19);
		panel_2.add(lblDosemg);
		
		JLabel lblDailiDose = new JLabel("Daily Dose");
		lblDailiDose.setForeground(new Color(0, 153, 255));
		lblDailiDose.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDailiDose.setBounds(775, 278, 107, 19);
		panel_2.add(lblDailiDose);
		
		JLabel lblDiscriptionAndDetails = new JLabel("Discription and Details");
		lblDiscriptionAndDetails.setForeground(new Color(0, 153, 255));
		lblDiscriptionAndDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiscriptionAndDetails.setBounds(817, 335, 201, 19);
		panel_2.add(lblDiscriptionAndDetails);
		

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Doc_patient_details.class.getResource("/Images/patientbackground1.jpg")));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		panel.add(lblNewLabel);
	}
}
