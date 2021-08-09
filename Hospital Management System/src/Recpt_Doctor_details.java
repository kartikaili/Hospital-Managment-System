import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;


public class Recpt_Doctor_details extends JFrame {

	private JPanel contentPane;
	private JTextField dname;
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
			ResultSet rs=stmt.executeQuery("select d_id,fname,lname,age,bld_grp,gender,MARITAL_STS,address,phone_no,city from dept ORDER BY D_ID ASC");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recpt_Doctor_details frame = new Recpt_Doctor_details();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public Recpt_Doctor_details() {
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
		panel_1.setBounds(0, 52, 1264, 629);
		panel_1.setBackground(new Color(255,255,255,200));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDoctorName = new JLabel("Doctor First Name");
		lblDoctorName.setForeground(new Color(0, 153, 255));
		lblDoctorName.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDoctorName.setBounds(228, 83, 238, 28);
		panel_1.add(lblDoctorName);
		
		dname = new JTextField();
		dname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dname.setColumns(10);
		dname.setBounds(482, 83, 350, 28);
		panel_1.add(dname);
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String id=dname.getText().trim();
					ResultSet rs=stmt.executeQuery("select * from dept where fname='"+id+"'");
					if(rs.next()){
						try{
							ResultSet rs1=stmt.executeQuery("select d_id,fname,lname,age,bld_grp,gender,MARITAL_STS,address,phone_no,city from dept where fname='"+id+"'");
							table.setModel(DbUtils.resultSetToTableModel(rs1));
							
						}catch(Exception e){
							e.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Doctor Name does not exist");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button_1.setForeground(new Color(30, 144, 255));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(528, 140, 185, 33);
		panel_1.add(button_1);
		
		JButton btnDisplayAllDoctor = new JButton("Display All Doctor Details");
		btnDisplayAllDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
			}
		});
		btnDisplayAllDoctor.setForeground(new Color(30, 144, 255));
		btnDisplayAllDoctor.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplayAllDoctor.setBounds(495, 193, 248, 33);
		panel_1.add(btnDisplayAllDoctor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 249, 818, 278);
		panel_1.add(scrollPane);
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 153, 255));
		panel_2.setBounds(0, 0, 1264, 55);
		panel.add(panel_2);
		
		JLabel lblDoctorDetails = new JLabel("DOCTOR DETAILS");
		lblDoctorDetails.setForeground(Color.WHITE);
		lblDoctorDetails.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDoctorDetails.setBounds(504, 11, 224, 31);
		panel_2.add(lblDoctorDetails);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recpt_workpage ap=new Recpt_workpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Recpt_Doctor_details.class.getResource("/Images/back (2).png")));
		button.setForeground(new Color(0, 153, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.setBounds(0, 0, 63, 55);
		panel_2.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Recpt_Doctor_details.class.getResource("/Images/backgroundpatiennt.png")));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		panel.add(lblNewLabel);
	}
}
