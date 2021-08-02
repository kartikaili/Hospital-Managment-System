import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BedPage extends JFrame {

	private JPanel contentPane;
	private JTextField bed_no;
	private JTextField room_no;
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
			ResultSet rs=stmt.executeQuery("SELECT * FROM Bed_details ORDER BY Bed_No ASC");
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
					BedPage frame = new BedPage();
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
	public BedPage() {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 0, 1264, 73);
		panel.add(panel_1);
		
		JLabel lblBedDetails = new JLabel("BED DETAILS");
		lblBedDetails.setForeground(Color.WHITE);
		lblBedDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBedDetails.setBounds(10, 27, 381, 35);
		panel_1.add(lblBedDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(255, 255, 255, 200));
		panel_2.setBounds(0, 71, 1264, 610);
		panel.add(panel_2);
		
		JLabel lblBedNumber = new JLabel("Bed Number");
		lblBedNumber.setForeground(new Color(0, 153, 255));
		lblBedNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBedNumber.setBounds(224, 107, 107, 19);
		panel_2.add(lblBedNumber);
		
		bed_no = new JTextField();
		bed_no.setColumns(10);
		bed_no.setBounds(351, 100, 167, 28);
		panel_2.add(bed_no);
		
		JLabel lblCatagory = new JLabel("Catagory");
		lblCatagory.setForeground(new Color(0, 153, 255));
		lblCatagory.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCatagory.setBounds(553, 105, 107, 19);
		panel_2.add(lblCatagory);
		
		final JComboBox category = new JComboBox(new Object[]{});
		category.setModel(new DefaultComboBoxModel(new String[] {"ICU", "General ward", "Special ward"}));
		category.setFont(new Font("Tahoma", Font.PLAIN, 16));
		category.setBounds(680, 100, 167, 28);
		panel_2.add(category);
		
		room_no = new JTextField();
		room_no.setColumns(10);
		room_no.setBounds(1012, 100, 167, 28);
		panel_2.add(room_no);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setForeground(new Color(0, 153, 255));
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRoom.setBounds(885, 107, 107, 19);
		panel_2.add(lblRoom);
		
		JButton btnAddBed = new JButton("ADD BED");
		btnAddBed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String Bid=bed_no.getText().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from Bed_details where Bed_No='"+Bid+"'");
					if(rs_expt.next()){
						JOptionPane.showMessageDialog(null, "Reception ID already Exist");
					}else{
						String cat=(String) category.getItemAt(category.getSelectedIndex());
						String room=room_no.getText().trim();
						int s=stmt.executeUpdate("insert into Bed_details values('"+Bid+"','"+cat+"','"+room+"')");
						if(s==1){
							JOptionPane.showMessageDialog(null,"Record Inserted Sucessfully");
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null,"Record Insertion Unsuccefull");
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnAddBed.setForeground(new Color(30, 144, 255));
		btnAddBed.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddBed.setBounds(159, 232, 181, 33);
		btnAddBed.setBorder(br);
		panel_2.add(btnAddBed);
		
		JButton btnRemoveBed = new JButton("REMOVE BED");
		btnRemoveBed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String Bid=bed_no.getText().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from Bed_details where Bed_No='"+Bid+"'");
					if(rs_expt.next()){
						
						String cat=(String) category.getItemAt(category.getSelectedIndex());
						String room=room_no.getText().trim();
						int s=stmt.executeUpdate("delete from Bed_details where Bed_No='"+Bid+"'");
						if(s==1){
							JOptionPane.showMessageDialog(null,"Record Deleted Sucessfully");
							
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null,"Record Deletion Unsuccefull");
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "BED_ID Doesnot Exists");
					}
				}catch(Exception e){
					
				}
			}
		});
		btnRemoveBed.setForeground(new Color(30, 144, 255));
		btnRemoveBed.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemoveBed.setBounds(159, 316, 181, 33);
		btnRemoveBed.setBorder(br);
		panel_2.add(btnRemoveBed);
		
		JButton btnUpdateBed = new JButton("UPDATE BED");
		btnUpdateBed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					String Bid=bed_no.getText().trim();
					ResultSet rs_expt=stmt.executeQuery("select * from Bed_details where Bed_No='"+Bid+"'");
					if(rs_expt.next()){
						String cat=(String) category.getItemAt(category.getSelectedIndex());
						String room=room_no.getText().trim();
						int s=stmt.executeUpdate("update Bed_details set Bed_No='"+Bid+"', category='"+cat+"', room_no='"+room+"' where Bed_No='"+Bid+"'");
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
		btnUpdateBed.setForeground(new Color(30, 144, 255));
		btnUpdateBed.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateBed.setBounds(159, 390, 181, 33);
		btnUpdateBed.setBorder(br);
		panel_2.add(btnUpdateBed);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 195, 740, 238);
		scrollPane.setBorder(br);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int SelectedRow =table.getSelectedRow();
				DefaultTableModel tbl=(DefaultTableModel)table.getModel();
				bed_no.setText(tbl.getValueAt(SelectedRow, 0).toString());
				category.setSelectedItem(tbl.getValueAt(SelectedRow, 1).toString());
				room_no.setText(tbl.getValueAt(SelectedRow, 2).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Bed_ID", "Catagory", "Room"
			}
		));
		scrollPane.setViewportView(table);
		
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
		button_4.setBounds(1194, 0, 70, 57);
		panel_2.add(button_4);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\BEDDETAILS.png"));
		label_1.setBounds(24, 22, 167, 174);
		panel_2.add(label_1);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
			}
		});
		btnDisplay.setForeground(new Color(30, 144, 255));
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplay.setBorder(br);
		btnDisplay.setBounds(681, 455, 154, 32);
		panel_2.add(btnDisplay);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\bed (2).jpg"));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		panel.add(lblNewLabel);
	}
}
