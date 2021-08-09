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
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;


public class ReceptionistPage extends JFrame {

	private JPanel contentPane;
	private JTextField R_id;
	private JTextField fname;
	private JTextField lname;
	private JTextField age;
	private JTextField address;
	private JTextField ph_no;
	private JTextField city;
	private JTextField R_date;
	private JPasswordField password;
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
			ResultSet rs=stmt.executeQuery("select * from Receptionist_details ORDER BY R_ID ASC");
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
					ReceptionistPage frame = new ReceptionistPage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.showTableData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReceptionistPage() {
		//initComponents();
		//showTableData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280,720);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Border br=BorderFactory.createLineBorder(new Color(0,153,255));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1264, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,153, 255));
		panel_2.setBounds(0, 0, 1264, 73);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblReceptionistDetails = new JLabel("RECEPTIONIST DETAILS");
		lblReceptionistDetails.setForeground(Color.WHITE);
		lblReceptionistDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblReceptionistDetails.setBounds(10, 27, 381, 35);
		panel_2.add(lblReceptionistDetails);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 71, 1264, 610);
		panel_3.setBackground(new Color(255,255,255,200));
		panel_3.setOpaque(true);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 11, 150, 150);
		panel_3.add(label_1);
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\RECETIONISTDETAILS.png"));
		
		JLabel lblReceptionistId = new JLabel("Receptionist  ID");
		lblReceptionistId.setForeground(new Color(0, 153, 255));
		lblReceptionistId.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblReceptionistId.setBounds(160, 24, 202, 29);
		panel_3.add(lblReceptionistId);
		
		R_id = new JTextField();
		R_id.setColumns(10);
		R_id.setBounds(372, 29, 246, 28);
		panel_3.add(R_id);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setForeground(new Color(0, 153, 255));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(160, 95, 107, 19);
		panel_3.add(label_2);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(283, 92, 167, 28);
		panel_3.add(fname);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setForeground(new Color(0, 153, 255));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(506, 99, 107, 19);
		panel_3.add(label_3);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(633, 92, 167, 28);
		panel_3.add(lname);
		
		JLabel label_4 = new JLabel("Age");
		label_4.setForeground(new Color(0, 153, 255));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(160, 158, 107, 19);
		panel_3.add(label_4);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(283, 155, 167, 28);
		panel_3.add(age);
		
		JLabel label_5 = new JLabel("Gender");
		label_5.setForeground(new Color(0, 153, 255));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(506, 158, 107, 19);
		panel_3.add(label_5);
		
		
		
		JLabel label_6 = new JLabel("Address");
		label_6.setForeground(new Color(0, 153, 255));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(160, 213, 107, 19);
		panel_3.add(label_6);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(283, 210, 516, 28);
		panel_3.add(address);
		
		JLabel label_7 = new JLabel("Phone Number");
		label_7.setForeground(new Color(0, 153, 255));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(160, 269, 120, 19);
		panel_3.add(label_7);
		
		ph_no = new JTextField();
		ph_no.setColumns(10);
		ph_no.setBounds(283, 266, 167, 28);
		panel_3.add(ph_no);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(633, 266, 167, 28);
		panel_3.add(city);
		
		R_date = new JTextField();
		R_date.setColumns(10);
		R_date.setBounds(283, 353, 167, 28);
		R_date.setEditable(false);
		panel_3.add(R_date);
		
		JLabel lblSearch = new JLabel("DATE");
		lblSearch.setForeground(new Color(0, 153, 255));
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearch.setBounds(160, 328, 107, 19);
		panel_3.add(lblSearch);
		
		JLabel label_9 = new JLabel("City");
		label_9.setForeground(new Color(0, 153, 255));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(506, 273, 107, 19);
		panel_3.add(label_9);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 153, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(506, 332, 107, 19);
		panel_3.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(633, 325, 167, 28);
		panel_3.add(password);
		
		final JComboBox gdr = new JComboBox(new Object[]{});
		gdr.setModel(new DefaultComboBoxModel(new String[] {"--SELECT--", "Male", "Female"}));
		gdr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gdr.setBounds(633, 153, 167, 28);
		panel_3.add(gdr);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setBounds(283, 325, 167, 28);
		panel_3.add(dateChooser);
		
		JButton btnAddRecp = new JButton("Add RECP");
		btnAddRecp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String rid=R_id.getText().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from Receptionist_details where R_ID='"+rid+"'");
					if(rs_expt.next()){
						JOptionPane.showMessageDialog(null, "Reception ID already Exist");
					}else{
						
					String Fname=fname.getText().trim();
					String Lname=lname.getText().trim();
					String Age=age.getText().trim();
					String gendr=(String) gdr.getItemAt(gdr.getSelectedIndex());
					String adrs=address.getText();
					long phno=Long.parseLong(ph_no.getText());
					String cty=city.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String pdate=sdf.format(dateChooser.getDate());
					//String pdate=R_date.getText().trim();
					String pass=new String(password.getPassword());
					
					int RP_insert=stmt.executeUpdate("insert into Receptionist_details values('"+rid+"','"+Fname+"','"+Lname+"','"+Age+"','"+gendr+"','"+adrs+"','"+phno+"','"+cty+"', TO_DATE('"+pdate+"','DD-MM-YYYY'),'"+pass+"')");
					if(RP_insert==1){
						JOptionPane.showMessageDialog(null,"Record Inserted Sucessfully");
						showTableData();
						/*try{
							Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
							conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
							stmt = conn.createStatement();
							
							ResultSet rs_expt1=stmt.executeQuery("select * from Receptionist_details");
							while(rs_expt1.next()){
								String id_tbl=rs_expt1.getString("R_ID");
								String fname_tbl=rs_expt1.getString("FNAME");
								String lname_tbl=rs_expt1.getString("LNAME");
								String age_tbl=rs_expt1.getString("AGE");
								
								String gdr_tbl=rs_expt1.getString("GENDER");
								
								String address_tbl=rs_expt1.getString("ADDRESS");
								String ph_no_tbl=String.valueOf(rs_expt1.getLong("PHONE_NO")).trim();
								
								String city_tbl=rs_expt1.getString("CITY");
								String password_tbl=rs_expt1.getString("R_PASSWORD");
								//ResultSet rs1=stmt.executeQuery("select TO_CHAR(R_DATE,'DD-MM-YYYY') from Receptionist_details where R_ID='"+id_tbl+"'");
								//rs1.next();
								//String R_date_tbl=rs1.getString(1);
								
								System.out.println(id_tbl+" "+fname_tbl);
								String tbData[]={id_tbl,fname_tbl,lname_tbl,age_tbl,gdr_tbl,address_tbl,ph_no_tbl,city_tbl,password_tbl};
								DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
								tblmodel.addRow(tbData);
								
							}
						}
						catch(Exception e){
							e.printStackTrace();
						}*/
					}else{
						JOptionPane.showMessageDialog(null,"Record Inserted UnSucessfully");
					}
				}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnAddRecp.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\adduser.png"));
		btnAddRecp.setForeground(new Color(30, 144, 255));
		btnAddRecp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddRecp.setBounds(160, 408, 181, 33);
		btnAddRecp.setBorder(br);
		panel_3.add(btnAddRecp);
		
		JButton btnRemoveRecp = new JButton("Remove RECP");
		btnRemoveRecp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String rid=R_id.getText().trim();
					
					int RP_dlt=stmt.executeUpdate("delete from Receptionist_details where R_ID='"+rid+"'");
					if(RP_dlt==1){
						JOptionPane.showMessageDialog(null,"Record Deleted Sucessfully");
						showTableData();
					}else{
						JOptionPane.showMessageDialog(null,"Record Deletion UnSucessfully");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnRemoveRecp.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\DELETESMALL.png"));
		btnRemoveRecp.setForeground(new Color(30, 144, 255));
		btnRemoveRecp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemoveRecp.setBounds(160, 492, 181, 33);
		btnRemoveRecp.setBorder(br);
		panel_3.add(btnRemoveRecp);
		
		JButton btnUpdateRecp = new JButton("Update RECP");
		btnUpdateRecp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String rid=R_id.getText().trim();
					String Fname=fname.getText().trim();
					String Lname=lname.getText().trim();
					String Age=age.getText().trim();
					String gendr=(String) gdr.getItemAt(gdr.getSelectedIndex());
					String adrs=address.getText();
					long phno=Long.parseLong(ph_no.getText());
					String cty=city.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String rdate=sdf.format(dateChooser.getDate());
					//String rdate=R_date.getText().trim();
					String pass=new String(password.getPassword());
					
					int RP_insert=stmt.executeUpdate("update Receptionist_details set FNAME='"+Fname+"', LNAME='"+Lname+"',AGE='"+Age+"',GENDER='"+gendr+"',ADDRESS='"+adrs+"', PHONE_NO='"+phno+"', CITY='"+cty+"',R_DATE=TO_DATE('"+rdate+"','DD-MM-YYYY'), R_Password='"+pass+"' where R_ID='"+rid+"'");
					if(RP_insert==1){
						JOptionPane.showMessageDialog(null,"Record Updated Sucessfully");
						showTableData();
					}else{
						JOptionPane.showMessageDialog(null,"Record Updation UnSucessfull");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnUpdateRecp.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\UPDATESMALL.png"));
		btnUpdateRecp.setForeground(new Color(30, 144, 255));
		btnUpdateRecp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateRecp.setBounds(160, 566, 181, 33);
		btnUpdateRecp.setBorder(br);
		panel_3.add(btnUpdateRecp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 408, 867, 191);
		scrollPane.setBorder(br);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"RECP ID", "FName", "LName", "Age", "Gender", "Address", "Ph No", "City", "Password"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(76);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JLabel label_8 = new JLabel("");
		label_8.setOpaque(true);
		label_8.setBackground(Color.WHITE);
		label_8.setBounds(900, 92, 204, 222);
		label_8.setBorder(br);
		panel_3.add(label_8);
		
		JButton button_3 = new JButton("BROWSE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setForeground(new Color(30, 144, 255));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_3.setBounds(920, 325, 161, 33);
		button_3.setBorder(br);
		panel_3.add(button_3);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminpage ap=new Adminpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button.setBounds(1194, 0, 70, 57);
		panel_3.add(button);
		button.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\back (2).png"));
		
		JButton button_1 = new JButton("SEARCH");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String id=R_id.getText().trim();
					ResultSet rs_expt1=stmt.executeQuery("select * from Receptionist_details where R_ID='"+id+"'");
					if(rs_expt1.next()){
						fname.setText(rs_expt1.getString(2));
						lname.setText(rs_expt1.getString(3));
						age.setText(rs_expt1.getString(4));
						
						gdr.setSelectedItem(rs_expt1.getString(5));
						address.setText(rs_expt1.getString(6));
						String st=String.valueOf(rs_expt1.getLong(7)).trim();
						ph_no.setText(st);
						city.setText(rs_expt1.getString(8));
						password.setText(rs_expt1.getString(10));
						ResultSet rs1=stmt.executeQuery("select TO_CHAR(R_DATE,'DD-MM-YYYY') from Receptionist_details where R_ID='"+id+"'");
						rs1.next();
						R_date.setText(rs1.getString(1));
					}else{
						JOptionPane.showMessageDialog(null," Record Not Found");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button_1.setForeground(new Color(30, 144, 255));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(653, 24, 161, 33);
		panel_3.add(button_1);
		

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\back1.jpg"));
		label.setBounds(0, 0, 1264, 681);
		panel.add(label);
	}
}
