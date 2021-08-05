import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Recpt_patient_page extends JFrame {

	private JPanel contentPane;
	private JTextField P_id1;
	private JTextField fname1;
	private JTextField lname1;
	private JTextField age1;
	private JTextField address1;
	private JTextField phno1;
	private JTextField city1;
	private JTextField pdate1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	Connection conn=null;
	Statement stmt=null;
	
	public void showTableData(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
			stmt = conn.createStatement();
			//PreparedStatement pst = conn.prepareStatement("SELECT * FROM Receptionist_details");
			ResultSet rs=stmt.executeQuery("SELECT * FROM patient_details ORDER BY P_ID ASC");
			//if(rs.next()){
				table.setModel(DbUtils.resultSetToTableModel(rs));
			//}
			//table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e){
			
		}
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recpt_patient_page frame = new Recpt_patient_page();
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
	public Recpt_patient_page() {
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
		panel_1.setBounds(0, 0, 1264, 55);
		panel_1.setBackground(new Color(0,153, 255));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPatientDetails = new JLabel("PATIENT DETAILS");
		lblPatientDetails.setForeground(Color.WHITE);
		lblPatientDetails.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPatientDetails.setBounds(504, 11, 224, 31);
		panel_1.add(lblPatientDetails);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recpt_workpage rp=new Recpt_workpage();
				rp.setVisible(true);
				rp.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(Recpt_patient_page.class.getResource("/Images/back (2).png")));
		button_1.setForeground(new Color(0, 153, 255));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_1.setBounds(0, 0, 63, 55);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 53, 1264, 628);
		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(255, 255, 255, 200));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("Patient ID");
		label_1.setForeground(new Color(0, 153, 255));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(10, 11, 107, 29);
		panel_2.add(label_1);
		
		P_id1 = new JTextField();
		P_id1.setColumns(10);
		P_id1.setBounds(133, 11, 167, 28);
		panel_2.add(P_id1);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setForeground(new Color(0, 153, 255));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(330, 15, 107, 19);
		panel_2.add(label_2);
		
		fname1 = new JTextField();
		fname1.setColumns(10);
		fname1.setBounds(453, 12, 167, 28);
		panel_2.add(fname1);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setForeground(new Color(0, 153, 255));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(649, 18, 107, 19);
		panel_2.add(label_3);
		
		lname1 = new JTextField();
		lname1.setColumns(10);
		lname1.setBounds(766, 11, 167, 28);
		panel_2.add(lname1);
		
		JLabel label_4 = new JLabel("Age");
		label_4.setForeground(new Color(0, 153, 255));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(10, 68, 107, 19);
		panel_2.add(label_4);
		
		age1 = new JTextField();
		age1.setColumns(10);
		age1.setBounds(133, 65, 167, 28);
		panel_2.add(age1);
		
		JLabel label_5 = new JLabel("Blood Group");
		label_5.setForeground(new Color(0, 153, 255));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(326, 69, 107, 19);
		panel_2.add(label_5);
		
		
		
		JLabel label_6 = new JLabel("Gender");
		label_6.setForeground(new Color(0, 153, 255));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(643, 68, 107, 19);
		panel_2.add(label_6);
		
		
		
		JLabel label_7 = new JLabel("Address");
		label_7.setForeground(new Color(0, 153, 255));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(10, 123, 107, 19);
		panel_2.add(label_7);
		
		address1 = new JTextField();
		address1.setColumns(10);
		address1.setBounds(133, 120, 507, 28);
		panel_2.add(address1);
		
		JLabel label_8 = new JLabel("Phone Number");
		label_8.setForeground(new Color(0, 153, 255));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(330, 183, 120, 19);
		panel_2.add(label_8);
		
		phno1 = new JTextField();
		phno1.setColumns(10);
		phno1.setBounds(473, 174, 167, 28);
		panel_2.add(phno1);
		
		JLabel label_9 = new JLabel("City");
		label_9.setForeground(new Color(0, 153, 255));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(649, 177, 107, 19);
		panel_2.add(label_9);
		
		city1 = new JTextField();
		city1.setColumns(10);
		city1.setBounds(776, 174, 167, 28);
		panel_2.add(city1);
		
		JLabel label_10 = new JLabel("Date");
		label_10.setForeground(new Color(0, 153, 255));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(10, 183, 107, 19);
		panel_2.add(label_10);
		
		pdate1 = new JTextField();
		pdate1.setColumns(10);
		pdate1.setBounds(133, 174, 167, 28);
		panel_2.add(pdate1);
		
		JLabel label_11 = new JLabel("Patient Type");
		label_11.setForeground(new Color(0, 153, 255));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(10, 247, 107, 19);
		panel_2.add(label_11);
		
		JComboBox comboBox_2 = new JComboBox(new Object[]{});
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(133, 242, 167, 29);
		panel_2.add(comboBox_2);
		
		JLabel label_12 = new JLabel("Bed No");
		label_12.setForeground(new Color(0, 153, 255));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_12.setBounds(355, 247, 120, 19);
		panel_2.add(label_12);
		
		JComboBox comboBox_3 = new JComboBox(new Object[]{});
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_3.setBounds(483, 242, 167, 28);
		panel_2.add(comboBox_3);
		
		final JComboBox bldgrp1 = new JComboBox(new Object[]{});
		bldgrp1.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bldgrp1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bldgrp1.setBackground(Color.WHITE);
		bldgrp1.setBounds(453, 64, 167, 29);
		panel_2.add(bldgrp1);
		
		final JComboBox gdr1 = new JComboBox(new Object[]{});
		gdr1.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gdr1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr1.setBounds(766, 65, 167, 28);
		panel_2.add(gdr1);
		
		JButton button = new JButton("ADD Patient");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String pid=P_id1.getText().toUpperCase().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from patient_details where P_ID='"+pid+"'");
					if(rs_expt.next()){
						JOptionPane.showMessageDialog(null, "patient ID already Exist");
					}else{
						String fname=fname1.getText().trim();
						String lname=lname1.getText().trim();
						String Age=age1.getText().trim();
						String bld_grp=(String) bldgrp1.getItemAt(bldgrp1.getSelectedIndex());
						String gendr=(String) gdr1.getItemAt(gdr1.getSelectedIndex());
						String adrs=address1.getText();
						long phno=Long.parseLong(phno1.getText());
						String cty=city1.getText();
						String pdate=pdate1.getText().trim();
						//DD-MM-YYYY
						int patient_insert=stmt.executeUpdate("insert into patient_details values('"+pid+"','"+fname+"','"+lname+"','"+Age+"','"+bld_grp+"','"+gendr+"','"+adrs+"','"+phno+"','"+cty+"', TO_DATE('"+pdate+"','YYYY-MM-DD'))");
						if(patient_insert==1){
							JOptionPane.showMessageDialog(null,"Record Inserted Sucessfully");
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null,"Record Inserted UnSucessfully");
						}
					}
					
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon(Recpt_patient_page.class.getResource("/Images/adduser.png")));
		button.setSelectedIcon(null);
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(1031, 43, 185, 33);
		panel_2.add(button);
		
		JButton btnRemovePatient = new JButton("Remove Patient");
		btnRemovePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String id_dlt=P_id1.getText().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from patient_details where P_ID='"+id_dlt+"'");
					if(rs_expt.next()){
						
						int rs2=stmt.executeUpdate("delete from patient_details where P_ID='"+id_dlt+"'");
						if(rs2==1){
							JOptionPane.showMessageDialog(null, "Record Deleted Succesfully");
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null, "Record not deleted");
						}
					}else{
						JOptionPane.showMessageDialog(null, "patient ID does not Exist");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnRemovePatient.setIcon(new ImageIcon(Recpt_patient_page.class.getResource("/Images/DELETESMALL.png")));
		btnRemovePatient.setForeground(new Color(30, 144, 255));
		btnRemovePatient.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemovePatient.setBounds(1031, 127, 185, 33);
		panel_2.add(btnRemovePatient);
		
		JButton btnUpdatePatient = new JButton("Update Patient");
		btnUpdatePatient.addActionListener(new ActionListener() {
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
						String pdate=pdate1.getText().trim();
						int result_upt=stmt.executeUpdate("update patient_details set FNAME='"+fname+"', LNAME='"+lname+"',AGE='"+Age+"', BLD_GRP='"+bld_grp+"', GENDER='"+gendr+"',ADDRESS='"+adrs+"', PHONE_NO='"+phno+"', CITY='"+cty+"',P_DATE=TO_DATE('"+pdate+"','YYYY-MM-DD') where P_ID='"+pid+"'");
						if(result_upt==1){
							JOptionPane.showMessageDialog(null, "Records Updated");
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null, "Records not Updated");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Records not Found");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnUpdatePatient.setIcon(new ImageIcon(Recpt_patient_page.class.getResource("/Images/UPDATESMALL.png")));
		btnUpdatePatient.setForeground(new Color(30, 144, 255));
		btnUpdatePatient.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdatePatient.setBounds(1031, 210, 185, 33);
		panel_2.add(btnUpdatePatient);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 359, 867, 218);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int SelectedRow =table.getSelectedRow();
				DefaultTableModel tbl=(DefaultTableModel)table.getModel();
				P_id1.setText(tbl.getValueAt(SelectedRow, 0).toString());
				fname1.setText(tbl.getValueAt(SelectedRow, 1).toString()); //setSelectedItem
				lname1.setText(tbl.getValueAt(SelectedRow, 2).toString());
				age1.setText(tbl.getValueAt(SelectedRow, 3).toString());
				bldgrp1.setSelectedItem(tbl.getValueAt(SelectedRow, 4).toString());
				gdr1.setSelectedItem(tbl.getValueAt(SelectedRow, 5).toString());
				address1.setText(tbl.getValueAt(SelectedRow, 6).toString());
				phno1.setText(tbl.getValueAt(SelectedRow, 7).toString());
				city1.setText(tbl.getValueAt(SelectedRow, 8).toString());
				pdate1.setText(tbl.getValueAt(SelectedRow, 9).toString());
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, "", null, null, null},
			},
			new String[] {
				"P_ID", "FNAME", "LNAME", "AGE", "BLOOD GROUP", "GENDER", "ADDRESS", "PH_NO", "CITY", "DATE"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnDisplaypatients = new JButton("Display patients");
		btnDisplaypatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
			}
		});
		btnDisplaypatients.setForeground(new Color(30, 144, 255));
		btnDisplaypatients.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplaypatients.setBounds(952, 362, 185, 33);
		panel_2.add(btnDisplaypatients);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Recpt_patient_page.class.getResource("/Images/patientbackground1.jpg")));
		label.setBounds(0, 0, 1264, 681);
		panel.add(label);
	}
}
