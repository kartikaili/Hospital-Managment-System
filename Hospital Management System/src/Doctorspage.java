import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Doctorspage extends JFrame {

	private JPanel contentPane;
	private JTextField D_ID;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField age;
	private JTextField address;
	private JTextField ph_no;
	private JTextField city;
	private JTextField jng_date;
	private JTextField textField_8;
	private JTextField age2;
	private JTextField address2;
	private JTextField phno2;
	private JTextField city2;
	private JTextField jng_date2;
	private JTextField textField_14;
	private JTextField fname2;
	private JTextField lname2;
	private JTextField D_ID1;
	private JTextField username;
	private JTextField D_ID2;
	private JTextField fname1;
	private JTextField lname1;
	private JTextField age1;
	private JTextField address1;
	private JTextField phno1;
	private JTextField city1;
	private JTextField jng_date1;
	private JTextField textField_27;
	private JTextField username1;
	private JPasswordField password1;
	private JTextField username2;
	private JLabel docimg;
	private JPasswordField password2;

	/**
	 * Launch the application.
	 */
	Connection conn=null;
	Statement stmt=null;
	String s;
	private JPasswordField password;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctorspage frame = new Doctorspage();
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
	
	public Doctorspage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1264, 681);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Doctors", new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\add (5).png"), panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(true);
		panel_3.setBackground(new Color(255, 255, 255, 200));
		panel_3.setBounds(121, 0, 1138, 617);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(30, 144, 255));
		panel_6.setBounds(0, 31, 1138, 57);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_3 = new JLabel("ADD Doctors");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_3.setBounds(10, 11, 184, 35);
		panel_6.add(label_3);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminpage ap=new Adminpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\back (2).png"));
		button_2.setBounds(1068, 0, 70, 57);
		panel_6.add(button_2);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoctorId.setForeground(new Color(0,153, 255));
		lblDoctorId.setBounds(10, 124, 107, 29);
		panel_3.add(lblDoctorId);
		
		D_ID = new JTextField();
		D_ID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		D_ID.setBounds(133, 124, 167, 28);
		panel_3.add(D_ID);
		D_ID.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(0,153, 255));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstName.setBounds(10, 191, 107, 19);
		panel_3.add(lblFirstName);
		
		Fname = new JTextField();
		Fname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Fname.setColumns(10);
		Fname.setBounds(133, 188, 167, 28);
		panel_3.add(Fname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(0, 153, 255));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(356, 195, 107, 19);
		panel_3.add(lblLastName);
		
		Lname = new JTextField();
		Lname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Lname.setColumns(10);
		Lname.setBounds(483, 188, 167, 28);
		panel_3.add(Lname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(0, 153, 255));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(10, 254, 107, 19);
		panel_3.add(lblAge);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age.setColumns(10);
		age.setBounds(133, 251, 167, 28);
		panel_3.add(age);
		
		String bloodgrp[]={"A","A+","B","B+","AB","AB-","O+","O-"};
		final JComboBox bldgrp = new JComboBox(bloodgrp);
		bldgrp.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bldgrp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bldgrp.setBackground(new Color(255, 255, 255));
		bldgrp.setBounds(483, 249, 167, 29);
		panel_3.add(bldgrp);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setForeground(new Color(0, 153, 255));
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBloodGroup.setBounds(356, 254, 107, 19);
		panel_3.add(lblBloodGroup);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 153, 255));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(10, 305, 107, 19);
		panel_3.add(lblGender);
		
		String gender[]={"--SELECT--","Male","Female"};
		final JComboBox gdr = new JComboBox(gender);
		gdr.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "Male", "Female"}));
		gdr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr.setBounds(133, 302, 167, 28);
		panel_3.add(gdr);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setForeground(new Color(0, 153, 255));
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdress.setBounds(10, 358, 107, 19);
		panel_3.add(lblAdress);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		address.setColumns(10);
		address.setBounds(133, 355, 507, 28);
		panel_3.add(address);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(0, 153, 255));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoneNumber.setBounds(10, 412, 120, 19);
		panel_3.add(lblPhoneNumber);
		
		ph_no = new JTextField();
		ph_no.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ph_no.setColumns(10);
		ph_no.setBounds(133, 403, 167, 28);
		panel_3.add(ph_no);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(new Color(0, 153, 255));
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCity.setBounds(356, 412, 107, 19);
		panel_3.add(lblCity);
		
		city = new JTextField();
		city.setFont(new Font("Tahoma", Font.PLAIN, 16));
		city.setColumns(10);
		city.setBounds(483, 409, 167, 28);
		panel_3.add(city);
		
		JLabel lblMaritialStatus = new JLabel("Maritial Status");
		lblMaritialStatus.setForeground(new Color(0, 153, 255));
		lblMaritialStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaritialStatus.setBounds(356, 305, 120, 19);
		panel_3.add(lblMaritialStatus);
		
		String maritial[]={"--SELECT--","Single","Married"};
		final JComboBox mrt_sts = new JComboBox(maritial);
		mrt_sts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mrt_sts.setBounds(483, 300, 167, 28);
		panel_3.add(mrt_sts);
		
		JLabel lblJoiningDate = new JLabel("Joining Date");
		lblJoiningDate.setForeground(new Color(0, 153, 255));
		lblJoiningDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJoiningDate.setBounds(10, 463, 107, 19);
		panel_3.add(lblJoiningDate);
		
		
		jng_date = new JTextField("dd-mm-yyyy");
		jng_date.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				jng_date.setText(null);
			}
		});
		jng_date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jng_date.setColumns(10);
		jng_date.setBounds(133, 454, 167, 28);
		panel_3.add(jng_date);
		
		JLabel lblVisitTiming = new JLabel("Visit Timing");
		lblVisitTiming.setForeground(new Color(0, 153, 255));
		lblVisitTiming.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVisitTiming.setBounds(356, 463, 107, 19);
		panel_3.add(lblVisitTiming);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBounds(483, 454, 167, 28);
		panel_3.add(textField_8);
		
		Border br=BorderFactory.createLineBorder(new Color(0,153,255));
		
		JButton btnAddDoctor = new JButton("ADD Doctor");
		btnAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String D_id=D_ID.getText().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from dept where D_ID='"+D_id+"'");
					if(rs_expt.next()){
						JOptionPane.showMessageDialog(null, "DOctor ID already Exist");
					}else{
						
					
					String fname=Fname.getText().trim();
					String lname=Lname.getText().trim();
					String Age=age.getText().trim();
					String bld_grp=(String) bldgrp.getItemAt(bldgrp.getSelectedIndex());
					String gendr=(String) gdr.getItemAt(gdr.getSelectedIndex());
					String mrtsts=(String) mrt_sts.getItemAt(mrt_sts.getSelectedIndex());
					String adrs=address.getText();
					long phno=Long.parseLong(ph_no.getText());
					String cty=city.getText();
					
					String jdate=jng_date.getText().trim();
					//Date d=Date.valueOf(jdate);
					
					String usname=username.getText();
					String pass=new String(password.getPassword());
					int s=stmt.executeUpdate("insert into dept(D_ID,FNAME,LNAME,AGE,BLD_GRP,GENDER,MARITAL_STS,ADDRESS,PHONE_NO,CITY,USENAME,PASSWORD,JOINING_DATE) values('"+D_id+"','"+fname+"','"+lname+"','"+Age+"','"+bld_grp+"','"+gendr+"','"+mrtsts+"','"+adrs+"','"+phno+"','"+cty+"','"+usname+"','"+pass+"',TO_DATE('"+jdate+"','DD-MM-YYYY'))");
					
					/*File file = new File(s);
					FileInputStream fin=new FileInputStream(new File(s));
					PreparedStatement ps=conn.prepareStatement("insert into docimge values(?,?)"); 
					ps.setString(1, D_id);
					System.out.println(fin);
					System.out.println(file.length());
					//ps.setBinaryStream(2,fin,fin.available());
					ps.setBinaryStream(2,fin,(int)file.length());
			
					ps.executeUpdate();*/
					if(s==1){
						JOptionPane.showMessageDialog(null,"Record Inserted Sucessfully");
					}else{
						JOptionPane.showMessageDialog(null, "Error");
					}
					
					}
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null,"Fields Should not be Empty");
				}
				catch(Exception e){
					
					e.printStackTrace();
					
				}
			}
			
		});
		btnAddDoctor.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\adduser.png"));
		btnAddDoctor.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddDoctor.setForeground(new Color(30, 144, 255));
		btnAddDoctor.setBorder(br);
		btnAddDoctor.setBounds(200, 544, 161, 33);
		panel_3.add(btnAddDoctor);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				D_ID.setText(null);
				Fname.setText(null);
				Lname.setText(null);
				age.setText(null);
				bldgrp.setSelectedIndex(0);;
				gdr.setSelectedIndex(0);
				mrt_sts.setSelectedIndex(0);
				address.setText(null);
				ph_no.setText(null);
				city.setText(null);
				jng_date.setText(null);
			}
		});
		btnClear.setForeground(new Color(30, 144, 255));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBorder(br);
		btnClear.setBounds(417, 544, 161, 33);
		panel_3.add(btnClear);
		
		docimg = new JLabel("");
		docimg.setBackground(SystemColor.textHighlightText);
		docimg.setOpaque(true);
		docimg.setBounds(820, 124, 204, 222);
		docimg.setBorder(br);
		panel_3.add(docimg);
		
		
		
		JButton btnBrowse = new JButton("BROWSE");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser("d:");
		        //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		        fileChooser.addChoosableFileFilter(filter);
		        int result = fileChooser.showSaveDialog(null);
		        if(result == JFileChooser.APPROVE_OPTION){
		            File selectedFile = fileChooser.getSelectedFile();
		            String path = selectedFile.getAbsolutePath();
		            docimg.setIcon(ResizeImage(path));
		           s = path;
		        }
		        else if(result == JFileChooser.CANCEL_OPTION){
		            System.out.println("No Data");
		        }
			}
		});
		
		btnBrowse.setForeground(new Color(30, 144, 255));
		btnBrowse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBrowse.setBounds(840, 358, 161, 33);
		btnBrowse .setBorder(br);
		panel_3.add(btnBrowse);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(0, 153, 255));
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setBounds(744, 434, 107, 19);
		panel_3.add(lblUserName);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setColumns(10);
		username.setBounds(875, 425, 167, 28);
		panel_3.add(username);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 153, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(744, 486, 107, 19);
		panel_3.add(lblPassword);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(875, 483, 167, 28);
		panel_3.add(password);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\899156.jpg"));
		label.setBounds(0, 0, 1259, 617);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Delete Doctor", new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\removeuser.png"), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(true);
		panel_4.setBackground(new Color(255, 255, 255, 200));
		panel_4.setBounds(121, 0, 1138, 617);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(30, 144, 255));
		panel_7.setBounds(0, 37, 1138, 57);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblDeleteDoctors = new JLabel("Delete Doctors");
		lblDeleteDoctors.setBounds(10, 11, 202, 35);
		lblDeleteDoctors.setForeground(Color.WHITE);
		lblDeleteDoctors.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_7.add(lblDeleteDoctors);
		
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
		panel_7.add(button_4);
		
		JLabel label_17 = new JLabel("Doctor ID");
		label_17.setForeground(new Color(0, 153, 255));
		label_17.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_17.setBounds(10, 133, 107, 29);
		panel_4.add(label_17);
		
		D_ID2 = new JTextField();
		D_ID2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		D_ID2.setColumns(10);
		D_ID2.setBounds(133, 133, 167, 28);
		panel_4.add(D_ID2);
		
		JLabel label_18 = new JLabel("First Name");
		label_18.setForeground(new Color(0, 153, 255));
		label_18.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_18.setBounds(10, 200, 107, 19);
		panel_4.add(label_18);
		
		fname1 = new JTextField();
		fname1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fname1.setColumns(10);
		fname1.setBounds(133, 197, 167, 28);
		panel_4.add(fname1);
		
		JLabel label_19 = new JLabel("Last Name");
		label_19.setForeground(new Color(0, 153, 255));
		label_19.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_19.setBounds(356, 204, 107, 19);
		panel_4.add(label_19);
		
		lname1 = new JTextField();
		lname1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lname1.setColumns(10);
		lname1.setBounds(483, 197, 167, 28);
		panel_4.add(lname1);
		
		JLabel label_20 = new JLabel("Age");
		label_20.setForeground(new Color(0, 153, 255));
		label_20.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_20.setBounds(10, 263, 107, 19);
		panel_4.add(label_20);
		
		age1 = new JTextField();
		age1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age1.setColumns(10);
		age1.setBounds(133, 260, 167, 28);
		panel_4.add(age1);
		
		final JComboBox bldgrp1 = new JComboBox(new Object[]{"A","A+","B","B+","AB","AB-","O+","O-"});
		bldgrp1.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bldgrp1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bldgrp1.setBackground(Color.WHITE);
		bldgrp1.setBounds(483, 258, 167, 29);
		panel_4.add(bldgrp1);
		
		JLabel label_21 = new JLabel("Blood Group");
		label_21.setForeground(new Color(0, 153, 255));
		label_21.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_21.setBounds(356, 263, 107, 19);
		panel_4.add(label_21);
		
		JLabel label_22 = new JLabel("Gender");
		label_22.setForeground(new Color(0, 153, 255));
		label_22.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_22.setBounds(10, 314, 107, 19);
		panel_4.add(label_22);
		
		
		final JComboBox gdr1 = new JComboBox(new Object[]{"--SELECT--","Male","Female"});
		gdr1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr1.setBounds(133, 311, 167, 28);
		panel_4.add(gdr1);
		
		JLabel label_23 = new JLabel("Address");
		label_23.setForeground(new Color(0, 153, 255));
		label_23.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_23.setBounds(10, 367, 107, 19);
		panel_4.add(label_23);
		
		address1 = new JTextField();
		address1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		address1.setColumns(10);
		address1.setBounds(133, 364, 507, 28);
		panel_4.add(address1);
		
		JLabel label_24 = new JLabel("Phone Number");
		label_24.setForeground(new Color(0, 153, 255));
		label_24.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_24.setBounds(10, 421, 120, 19);
		panel_4.add(label_24);
		
		phno1 = new JTextField();
		phno1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phno1.setColumns(10);
		phno1.setBounds(133, 412, 167, 28);
		panel_4.add(phno1);
		
		JLabel label_25 = new JLabel("City");
		label_25.setForeground(new Color(0, 153, 255));
		label_25.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_25.setBounds(356, 421, 107, 19);
		panel_4.add(label_25);
		
		city1 = new JTextField();
		city1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		city1.setColumns(10);
		city1.setBounds(483, 418, 167, 28);
		panel_4.add(city1);
		
		JLabel label_26 = new JLabel("Maritial Status");
		label_26.setForeground(new Color(0, 153, 255));
		label_26.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_26.setBounds(356, 314, 120, 19);
		panel_4.add(label_26);
		
		final JComboBox mrt_sts1 = new JComboBox(new Object[]{"--SELECT--","Single","Married"});
		mrt_sts1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mrt_sts1.setBounds(483, 309, 167, 28);
		panel_4.add(mrt_sts1);
		
		JLabel label_27 = new JLabel("Joining Date");
		label_27.setForeground(new Color(0, 153, 255));
		label_27.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_27.setBounds(10, 472, 107, 19);
		panel_4.add(label_27);
		
		jng_date1 = new JTextField();
		jng_date1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jng_date1.setColumns(10);
		jng_date1.setBounds(133, 463, 167, 28);
		panel_4.add(jng_date1);
		
		JLabel label_28 = new JLabel("Visit Timing");
		label_28.setForeground(new Color(0, 153, 255));
		label_28.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_28.setBounds(356, 472, 107, 19);
		panel_4.add(label_28);
		
		textField_27 = new JTextField();
		textField_27.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_27.setColumns(10);
		textField_27.setBounds(483, 463, 167, 28);
		panel_4.add(textField_27);
		
		Border brd=BorderFactory.createLineBorder(new Color(0,153,255));
		JButton btnDeleteDoctor = new JButton("Delete Doctor");
		btnDeleteDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String id_dlt=D_ID2.getText().trim();
					int rs2=stmt.executeUpdate("delete from dept where D_ID='"+id_dlt+"'");
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
		btnDeleteDoctor.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\DELETESMALL.png"));
		btnDeleteDoctor.setForeground(new Color(30, 144, 255));
		btnDeleteDoctor.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteDoctor.setBounds(313, 558, 194, 33);
		btnDeleteDoctor.setBorder(brd);
		panel_4.add(btnDeleteDoctor);
		
		JLabel label_29 = new JLabel("");
		label_29.setOpaque(true);
		label_29.setBackground(Color.WHITE);
		label_29.setBounds(820, 133, 204, 222);
		label_29.setBorder(br);
		panel_4.add(label_29);
		
		JButton button_3 = new JButton("BROWSE");
		button_3.setForeground(new Color(30, 144, 255));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBounds(840, 367, 161, 33);
		button_3.setBorder(brd);
		panel_4.add(button_3);
		
		JLabel label_30 = new JLabel("User Name");
		label_30.setForeground(new Color(0, 153, 255));
		label_30.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_30.setBounds(744, 443, 107, 19);
		panel_4.add(label_30);
		
		username1 = new JTextField();
		username1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username1.setColumns(10);
		username1.setBounds(875, 434, 167, 28);
		panel_4.add(username1);
		
		JLabel label_31 = new JLabel("Password");
		label_31.setForeground(new Color(0, 153, 255));
		label_31.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_31.setBounds(744, 495, 107, 19);
		panel_4.add(label_31);
		
		password1 = new JPasswordField();
		password1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password1.setBounds(875, 496, 167, 28);
		panel_4.add(password1);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					System.out.println("dat base Connected");
					String id=D_ID2.getText().trim();
					ResultSet rs_expt1=stmt.executeQuery("select * from dept where D_ID='"+id+"'");
					if(rs_expt1.next()){
						
					
					ResultSet rs=stmt.executeQuery("select * from dept where D_ID='"+id+"'");
					System.out.println(rs.next());
					fname1.setText(rs.getString(2));
					lname1.setText(rs.getString(3));
					age1.setText(rs.getString(4));
					bldgrp1.setSelectedItem(rs.getString(5));
					gdr1.setSelectedItem(rs.getString(6));
					mrt_sts1.setSelectedItem(rs.getString(7));
					address1.setText(rs.getString(8));
					String st=String.valueOf(rs.getLong(9)).trim();
					phno1.setText(st);
					city1.setText(rs.getString(10));
					username1.setText(rs.getString(11));
					password1.setText(rs.getString(12));
					ResultSet rs1=stmt.executeQuery("select TO_CHAR(Joining_date,'DD-MM-YYYY') from dept where D_ID='"+id+"'");
					rs1.next();
					jng_date1.setText(rs1.getString(1));
					}
					else{
						JOptionPane.showMessageDialog(null," Record Not Found");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(346, 129, 161, 33);
		btnSearch.setBorder(br);
		panel_4.add(btnSearch);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\899156.jpg"));
		label_1.setBounds(0, 0, 1259, 617);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update Doctors", new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\updateuser (2).png"), panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setOpaque(true);
		panel_5.setBackground(new Color(255, 255, 255, 200));
		panel_5.setBounds(121, 0, 1138, 617);
		panel_2.add(panel_5);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(30, 144, 255));
		panel_8.setBounds(0, 40, 1138, 57);
		panel_5.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblUpdateDoctors = new JLabel("Update Doctors");
		lblUpdateDoctors.setBounds(10, 11, 202, 35);
		lblUpdateDoctors.setForeground(Color.WHITE);
		lblUpdateDoctors.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_8.add(lblUpdateDoctors);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminpage ap=new Adminpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button_5.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\back (2).png"));
		button_5.setBounds(1068, 0, 70, 57);
		panel_8.add(button_5);
		
		JLabel label_4 = new JLabel("Last Name");
		label_4.setForeground(new Color(0, 153, 255));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(356, 201, 107, 19);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("Age");
		label_5.setForeground(new Color(0, 153, 255));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(10, 260, 107, 19);
		panel_5.add(label_5);
		
		age2 = new JTextField();
		age2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age2.setColumns(10);
		age2.setBounds(133, 257, 167, 28);
		panel_5.add(age2);
		
		final JComboBox bldgrp2 = new JComboBox(new Object[]{});
		bldgrp2.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		bldgrp2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bldgrp2.setBackground(Color.WHITE);
		bldgrp2.setBounds(483, 255, 167, 29);
		panel_5.add(bldgrp2);
		
		JLabel label_6 = new JLabel("Blood Group");
		label_6.setForeground(new Color(0, 153, 255));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(356, 260, 107, 19);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel("Gender");
		label_7.setForeground(new Color(0, 153, 255));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(10, 311, 107, 19);
		panel_5.add(label_7);
		
		final JComboBox gdr2 = new JComboBox(new Object[]{"--SELECT--","Male","Female"});
		gdr2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr2.setBounds(133, 308, 167, 28);
		panel_5.add(gdr2);
		
		JLabel label_8 = new JLabel("Address");
		label_8.setForeground(new Color(0, 153, 255));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(10, 364, 107, 19);
		panel_5.add(label_8);
		
		address2 = new JTextField();
		address2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		address2.setColumns(10);
		address2.setBounds(133, 361, 507, 28);
		panel_5.add(address2);
		
		JLabel label_9 = new JLabel("Phone Number");
		label_9.setForeground(new Color(0, 153, 255));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(10, 418, 120, 19);
		panel_5.add(label_9);
		
		phno2 = new JTextField();
		phno2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phno2.setColumns(10);
		phno2.setBounds(133, 409, 167, 28);
		panel_5.add(phno2);
		
		JLabel label_10 = new JLabel("City");
		label_10.setForeground(new Color(0, 153, 255));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(356, 418, 107, 19);
		panel_5.add(label_10);
		
		city2 = new JTextField();
		city2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		city2.setColumns(10);
		city2.setBounds(483, 415, 167, 28);
		panel_5.add(city2);
		
		JLabel label_11 = new JLabel("Maritial Status");
		label_11.setForeground(new Color(0, 153, 255));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(356, 311, 120, 19);
		panel_5.add(label_11);
		
		final JComboBox mrt_sts2 = new JComboBox(new Object[]{"--SELECT--","Single","Married"});
		mrt_sts2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mrt_sts2.setBounds(483, 306, 167, 28);
		panel_5.add(mrt_sts2);
		
		JLabel label_12 = new JLabel("Joining Date");
		label_12.setForeground(new Color(0, 153, 255));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_12.setBounds(10, 469, 107, 19);
		panel_5.add(label_12);
		
		jng_date2 = new JTextField();
		jng_date2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jng_date2.setColumns(10);
		jng_date2.setBounds(133, 460, 167, 28);
		panel_5.add(jng_date2);
		
		JLabel label_13 = new JLabel("Visit Timing");
		label_13.setForeground(new Color(0, 153, 255));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_13.setBounds(356, 469, 107, 19);
		panel_5.add(label_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_14.setColumns(10);
		textField_14.setBounds(483, 460, 167, 28);
		panel_5.add(textField_14);
		
		JButton btnUpdateDoctor = new JButton("Update Doctor");
		btnUpdateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String id_upt=D_ID1.getText().trim();
					
					String fname_upt=fname2.getText().trim();
					String lname_upt=lname2.getText().trim();
					String Age_upt=age2.getText().trim();
					String bld_grp_upt=(String) bldgrp.getItemAt(bldgrp2.getSelectedIndex());
					String gendr_upt=(String) gdr.getItemAt(gdr2.getSelectedIndex());
					String mrtsts_upt=(String) mrt_sts.getItemAt(mrt_sts2.getSelectedIndex());
					String adrs_upt=address2.getText();
					long phno_upt=Long.parseLong(phno2.getText());
					String cty_upt=city2.getText();
					
					String jdate_upt=jng_date2.getText().trim();
					
					
					String usname_upt=username2.getText();
					String pass_upt=new String(password2.getPassword());
					//stmt.executeUpdate("insert into dept(D_ID,FNAME,LNAME,AGE,BLD_GRP,GENDER,MARITAL_STS,ADDRESS,PHONE_NO,CITY,USENAME,PASSWORD,JOINING_DATE) values('"+D_id+"','"+fname+"','"+lname+"','"+Age+"','"+bld_grp+"','"+gendr+"','"+mrtsts+"','"+adrs+"','"+phno+"','"+cty+"','"+usname+"','"+pass+"',TO_DATE('"+jdate+"','DD-MM-YYYY'))");
					int result_upt=stmt.executeUpdate("update dept set FNAME='"+fname_upt+"', LNAME='"+lname_upt+"',AGE='"+Age_upt+"', BLD_GRP='"+bld_grp_upt+"', GENDER='"+gendr_upt+"', MARITAL_STS='"+mrtsts_upt+"',ADDRESS='"+adrs_upt+"', PHONE_NO='"+phno_upt+"', CITY='"+cty_upt+"',USENAME='"+usname_upt+"',PASSWORD='"+pass_upt+"',JOINING_DATE=TO_DATE('"+jdate_upt+"','DD-MM-YYYY') where D_ID='"+ id_upt+"'");
					if(result_upt==1){
						JOptionPane.showMessageDialog(null, "Records Updated");
					}else{
						JOptionPane.showMessageDialog(null, "Records not Updated");
					}
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null,"Fields Should not be Empty");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnUpdateDoctor.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\UPDATESMALL.png"));
		btnUpdateDoctor.setForeground(new Color(30, 144, 255));
		btnUpdateDoctor.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateDoctor.setBounds(171, 550, 196, 33);
		btnUpdateDoctor.setBorder(br);
		panel_5.add(btnUpdateDoctor);
		
		JButton button_1 = new JButton("CLEAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				D_ID1.setText(null);
				fname2.setText(null);
				lname2.setText(null);
				age2.setText(null);
				bldgrp2.setSelectedIndex(0);;
				gdr2.setSelectedIndex(0);
				mrt_sts2.setSelectedIndex(0);
				address2.setText(null);
				phno2.setText(null);
				city2.setText(null);
				jng_date2.setText(null);
				
			}
		});
		button_1.setForeground(new Color(30, 144, 255));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(417, 550, 161, 33);
		button_1.setBorder(br);
		panel_5.add(button_1);
		
		fname2 = new JTextField();
		fname2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fname2.setColumns(10);
		fname2.setBounds(133, 194, 167, 28);
		panel_5.add(fname2);
		
		lname2 = new JTextField();
		lname2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lname2.setColumns(10);
		lname2.setBounds(483, 194, 167, 28);
		panel_5.add(lname2);
		
		JLabel label_14 = new JLabel("First Name");
		label_14.setForeground(new Color(0, 153, 255));
		label_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_14.setBounds(10, 197, 107, 19);
		panel_5.add(label_14);
		
		D_ID1 = new JTextField();
		D_ID1.setColumns(10);
		D_ID1.setBounds(133, 130, 167, 28);
		panel_5.add(D_ID1);
		
		JLabel label_15 = new JLabel("Doctor ID");
		label_15.setForeground(new Color(0, 153, 255));
		label_15.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_15.setBounds(10, 130, 107, 29);
		panel_5.add(label_15);
		
		JButton button = new JButton("BROWSE");
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(855, 379, 161, 33);
		button.setBorder(br);
		panel_5.add(button);
		
		JLabel label_32 = new JLabel("User Name");
		label_32.setForeground(new Color(0, 153, 255));
		label_32.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_32.setBounds(759, 455, 107, 19);
		panel_5.add(label_32);
		
		username2 = new JTextField();
		username2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username2.setColumns(10);
		username2.setBounds(890, 446, 167, 28);
		panel_5.add(username2);
		
		JLabel label_33 = new JLabel("Password");
		label_33.setForeground(new Color(0, 153, 255));
		label_33.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_33.setBounds(759, 507, 107, 19);
		panel_5.add(label_33);
		
		password2 = new JPasswordField();
		password2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password2.setBounds(890, 508, 167, 28);
		panel_5.add(password2);
		
		final JLabel docimg1 = new JLabel("");
		docimg1.setOpaque(true);
		docimg1.setBackground(Color.WHITE);
		docimg1.setBounds(835, 145, 204, 222);
		docimg1.setBorder(br);
		panel_5.add(docimg1);
		
		JButton button_6 = new JButton("SEARCH");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					System.out.println("dat base Connected");
					// PreparedStatement pst = conn.prepareStatement( "select IMAGE from docimge where D_ID=?");
			          //  pst.setString(1,D_ID1.getText().trim());
					String sam=D_ID1.getText().trim();
			           ResultSet rs=stmt.executeQuery("select * from docimge where D_ID='"+sam+"'");
			           System.out.println(rs.next());
			           ///if(rs.next()){
			        	   //byte[]imagedata =rs.getBytes("IMAGE");
			        	   Blob blob =rs.getBlob(2);
			        	   
			        	  // byte barr[]=imagedata.getBytes(2,(int)imagedata.length());
			              // ImageIcon pat=new ImageIcon(barr);
			        	   ImageIcon imageIcon = new ImageIcon( blob.getBytes( 2, (int) blob.length() ) );
			        	   System.out.println(blob.getBytes( 2, (int) blob.length() ));
			               docimg1.setIcon(imageIcon);
			         // }
			           //else{
			            //    JOptionPane.showMessageDialog(null,"No Specific Id Found");
			          // }
				}catch(Exception e){
					e.printStackTrace();
				}*/
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					System.out.println("dat base Connected");
					String id_update=D_ID1.getText().trim();
					ResultSet rs3=stmt.executeQuery("select * from dept where D_ID='"+id_update+"'");
					System.out.println(rs3.next());
					fname2.setText(rs3.getString(2));
					lname2.setText(rs3.getString(3));
					age2.setText(rs3.getString(4));
					bldgrp2.setSelectedItem(rs3.getString(5));
					gdr2.setSelectedItem(rs3.getString(6));
					mrt_sts2.setSelectedItem(rs3.getString(7));
					address2.setText(rs3.getString(8));
					String st=String.valueOf(rs3.getLong(9)).trim();
					phno2.setText(st);
					city2.setText(rs3.getString(10));
					username2.setText(rs3.getString(11));
					password2.setText(rs3.getString(12));
					ResultSet rs4=stmt.executeQuery("select TO_CHAR(Joining_date,'DD-MM-YYYY') from dept where D_ID='"+id_update+"'");
					rs4.next();
					jng_date2.setText(rs4.getString(1));
					
					
				}
				catch(SQLException  e){
					JOptionPane.showMessageDialog(null,"Provide Doctor ID");
				}
				catch(NumberFormatException  e){
					JOptionPane.showMessageDialog(null,"Fields Should not be Empty");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button_6.setForeground(new Color(30, 144, 255));
		button_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_6.setBounds(341, 125, 161, 33);
		button_6.setBorder(br);
		panel_5.add(button_6);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\899156.jpg"));
		label_2.setBounds(0, 0, 1259, 617);
		panel_2.add(label_2);
		
	}
	public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(docimg.getWidth(), docimg.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
}
