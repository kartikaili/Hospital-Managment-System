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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DepartmentPage extends JFrame {

	private JPanel contentPane;
	private JTextField d_no;
	private JTextField d_name;
	private JTextField d_disc;
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
			ResultSet rs=stmt.executeQuery("SELECT * FROM Department_details ORDER BY dept_no ASC");
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
					DepartmentPage frame = new DepartmentPage();
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
	public DepartmentPage() {
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
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\department.png"));
		label_1.setBounds(0, 0, 160, 169);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(155, 44, 1109, 61);
		panel.add(panel_1);
		
		JLabel lblDepartmentDetails = new JLabel("DEPARTMENT DETAILS");
		lblDepartmentDetails.setForeground(Color.WHITE);
		lblDepartmentDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDepartmentDetails.setBounds(10, 11, 381, 35);
		panel_1.add(lblDepartmentDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(255, 255, 255, 200));
		panel_2.setBounds(155, 103, 1109, 578);
		panel.add(panel_2);
		
		JLabel lblDeptNumber = new JLabel("DEPT Number");
		lblDeptNumber.setForeground(new Color(0, 153, 255));
		lblDeptNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeptNumber.setBounds(369, 286, 139, 19);
		panel_2.add(lblDeptNumber);
		
		d_no = new JTextField();
		d_no.setColumns(10);
		d_no.setBounds(518, 283, 214, 28);
		panel_2.add(d_no);
		
		JLabel lblDeptDiscription = new JLabel("DEPT Discription");
		lblDeptDiscription.setForeground(new Color(0, 153, 255));
		lblDeptDiscription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeptDiscription.setBounds(369, 413, 139, 19);
		panel_2.add(lblDeptDiscription);
		
		d_name = new JTextField();
		d_name.setColumns(10);
		d_name.setBounds(518, 346, 214, 28);
		panel_2.add(d_name);
		
		JLabel lblDeptName = new JLabel("DEPT Name");
		lblDeptName.setForeground(new Color(0, 153, 255));
		lblDeptName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeptName.setBounds(369, 355, 139, 19);
		panel_2.add(lblDeptName);
		
		JButton btnRemoveDepartment = new JButton("Remove Department");
		btnRemoveDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String did=d_no.getText().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from Department_details where dept_no='"+did+"'");
					if(rs_expt.next()){
						
						String dname=d_name.getText().trim();
						String ddisc=d_disc.getText().trim();
						int s=stmt.executeUpdate("delete from Department_details where dept_no='"+did+"'");
						if(s==1){
							JOptionPane.showMessageDialog(null,"Record Deleted Sucessfully");
							showTableData();
							d_no.setText(null);
							d_name.setText(null);
							d_disc.setText(null);
						}else{
							JOptionPane.showMessageDialog(null,"Record Deletion Unsuccefull");
							d_no.setText(null);
							d_name.setText(null);
							d_disc.setText(null);
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "BED_ID Doesnot Exists");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnRemoveDepartment.setForeground(new Color(30, 144, 255));
		btnRemoveDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemoveDepartment.setBounds(480, 465, 207, 33);
		btnRemoveDepartment.setBorder(br);
		panel_2.add(btnRemoveDepartment);
		
		JButton btnUpdateDepartment = new JButton("Update Department");
		btnUpdateDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String did=d_no.getText().trim().toUpperCase();
					ResultSet rs_expt=stmt.executeQuery("select * from Department_details where dept_no='"+did+"'");
					if(rs_expt.next()){
						String dname=d_name.getText().trim();
						String ddisc=d_disc.getText().trim();
						int s=stmt.executeUpdate("update Department_details set DEPT_NO='"+did+"', DEPT_NAME='"+dname+"', DEPT_DISCRIPTION='"+ddisc+"' where dept_no='"+did+"'");
						if(s==1){
							JOptionPane.showMessageDialog(null,"Record Updated Sucessfully");
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null,"Record Updation Unsuccefull");
						}
					}else{
						JOptionPane.showMessageDialog(null,"Record not found");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnUpdateDepartment.setForeground(new Color(30, 144, 255));
		btnUpdateDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateDepartment.setBounds(731, 465, 207, 33);
		btnUpdateDepartment.setBorder(br);
		panel_2.add(btnUpdateDepartment);
		
		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String did=d_no.getText().trim().toUpperCase();
					ResultSet rs_expt=stmt.executeQuery("select * from Department_details  where dept_no='"+did+"'");
					if(rs_expt.next()){
						JOptionPane.showMessageDialog(null, "Department Number already Exist");
					}
					else{
						String dname=d_name.getText().trim();
						String ddisc=d_disc.getText().trim();
						int s=stmt.executeUpdate("insert into Department_details values('"+did+"','"+dname+"','"+ddisc+"')");
						if(s==1){
							JOptionPane.showMessageDialog(null,"Record Inserted Sucessfully");
							showTableData();
							d_no.setText(null);
							d_name.setText(null);
							d_disc.setText(null);
						}else{
							JOptionPane.showMessageDialog(null,"Record Insertion Unsuccefull");
							d_no.setText(null);
							d_name.setText(null);
							d_disc.setText(null);
						}
					}
				}catch(SQLException e1){
					JOptionPane.showMessageDialog(null,"Fields Should not be Empty");
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Fields Should not be Empty");
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnAddDepartment.setForeground(new Color(30, 144, 255));
		btnAddDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddDepartment.setBounds(239, 465, 181, 33);
		btnAddDepartment.setBorder(br);
		panel_2.add(btnAddDepartment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 27, 938, 238);
		scrollPane.setBorder(br);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int SelectedRow =table.getSelectedRow();
				DefaultTableModel tbl=(DefaultTableModel)table.getModel();
				d_no.setText(tbl.getValueAt(SelectedRow, 0).toString());
				d_name.setText(tbl.getValueAt(SelectedRow, 1).toString());
				d_disc.setText(tbl.getValueAt(SelectedRow, 2).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"D_No", "Department Name", "Department Discription"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(1194, 0, 70, 57);
		panel_2.add(button_3);
		
		d_disc = new JTextField();
		d_disc.setBounds(518, 404, 394, 28);
		panel_2.add(d_disc);
		d_disc.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminpage ap=new Adminpage();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);;
				dispose();
			}
		});
		button.setBounds(1039, 0, 70, 57);
		panel_2.add(button);
		button.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\back (2).png"));
		
		JButton btnDisplayDepartments = new JButton("Display Departments");
		btnDisplayDepartments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
			}
		});
		btnDisplayDepartments.setForeground(new Color(30, 144, 255));
		btnDisplayDepartments.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplayDepartments.setBounds(85, 279, 207, 32);
		panel_2.add(btnDisplayDepartments);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\D3 (1).jpg"));
		label.setBounds(0, 0, 1264, 681);
		panel.add(label);
	}
}
