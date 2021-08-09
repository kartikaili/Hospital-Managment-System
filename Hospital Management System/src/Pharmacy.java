import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Pharmacy extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField refid;
	private JTextField dose;
	private JTextField st_adv;
	private JTextField price;
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
			ResultSet rs=stmt.executeQuery("select * from pharmacy order by TABLET_NAME ASC");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pharmacy frame = new Pharmacy();
					frame.setVisible(true);
					frame.showTableData();
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
	public Pharmacy() {
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
		panel_1.setBounds(0, 0, 1264, 681);
		panel_1.setBackground(new Color(255,255,255,200));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMedicineDetails = new JLabel("MEDICINE DETAILS");
		lblMedicineDetails.setForeground(new Color(0, 153, 255));
		lblMedicineDetails.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblMedicineDetails.setBounds(415, 28, 348, 31);
		panel_1.add(lblMedicineDetails);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Pharmacy.class.getResource("/Images/capsule.png")));
		label_1.setBounds(271, 0, 87, 80);
		panel_1.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 199, 765, 258);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int SelectedRow =table.getSelectedRow();
				DefaultTableModel tbl=(DefaultTableModel)table.getModel();
				name.setText(tbl.getValueAt(SelectedRow, 0).toString());
				refid.setText(tbl.getValueAt(SelectedRow, 1).toString());
				dose.setText(tbl.getValueAt(SelectedRow, 2).toString());
				price.setText(tbl.getValueAt(SelectedRow, 5).toString());
				st_adv.setText(tbl.getValueAt(SelectedRow, 6).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNameOfTablet = new JLabel("Name of Tablet");
		lblNameOfTablet.setForeground(new Color(0, 153, 255));
		lblNameOfTablet.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNameOfTablet.setBounds(807, 104, 132, 19);
		panel_1.add(lblNameOfTablet);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(955, 101, 167, 28);
		panel_1.add(name);
		
		JLabel lblRefId = new JLabel("Ref# ID");
		lblRefId.setForeground(new Color(0, 153, 255));
		lblRefId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRefId.setBounds(832, 154, 107, 19);
		panel_1.add(lblRefId);
		
		refid = new JTextField();
		refid.setColumns(10);
		refid.setBounds(955, 151, 167, 28);
		panel_1.add(refid);
		
		JLabel lblDosemg = new JLabel("Dose(mg)");
		lblDosemg.setForeground(new Color(0, 153, 255));
		lblDosemg.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDosemg.setBounds(832, 202, 107, 19);
		panel_1.add(lblDosemg);
		
		dose = new JTextField();
		dose.setColumns(10);
		dose.setBounds(955, 199, 167, 28);
		panel_1.add(dose);
		
		JLabel lblStorageAdvice = new JLabel("Storage Advice");
		lblStorageAdvice.setForeground(new Color(0, 153, 255));
		lblStorageAdvice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStorageAdvice.setBounds(807, 262, 132, 19);
		panel_1.add(lblStorageAdvice);
		
		st_adv = new JTextField();
		st_adv.setColumns(10);
		st_adv.setBounds(955, 259, 167, 28);
		panel_1.add(st_adv);
		
		JLabel lblPricePerTab = new JLabel("Price");
		lblPricePerTab.setForeground(new Color(0, 153, 255));
		lblPricePerTab.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPricePerTab.setBounds(832, 422, 107, 19);
		panel_1.add(lblPricePerTab);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(955, 419, 167, 28);
		panel_1.add(price);
		
		JLabel lblIssuueDate = new JLabel("Issuue Date");
		lblIssuueDate.setForeground(new Color(0, 153, 255));
		lblIssuueDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIssuueDate.setBounds(832, 323, 107, 19);
		panel_1.add(lblIssuueDate);
		
		JLabel lblExpairyDate = new JLabel("Expairy Date");
		lblExpairyDate.setForeground(new Color(0, 153, 255));
		lblExpairyDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExpairyDate.setBounds(832, 371, 107, 19);
		panel_1.add(lblExpairyDate);
		
		final JDateChooser i_date = new JDateChooser();
		i_date.setBackground(Color.WHITE);
		i_date.setBounds(955, 314, 167, 28);
		panel_1.add(i_date);
		
		final JDateChooser e_date = new JDateChooser();
		e_date.setBackground(Color.WHITE);
		e_date.setBounds(955, 362, 167, 28);
		panel_1.add(e_date);
		
		JButton btnAddMedicine = new JButton("ADD MEDICINE");
		btnAddMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String name1=name.getText().toUpperCase().trim();
					String refid1=refid.getText().toUpperCase().trim();
					ResultSet rs=stmt.executeQuery("select * from pharmacy where TABLET_NAME='"+name1+"' OR REF_ID='"+refid1+"'");
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Medicine "+name1+" or "+refid1+" is already present");
					}else{
						
						int dose1=Integer.parseInt(dose.getText().trim());
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						String idate=sdf.format(i_date.getDate()); 
						String edate=sdf.format(e_date.getDate()); 
						
						int price1=Integer.parseInt(price.getText().trim());
						String st=st_adv.getText().toUpperCase().trim();
						int s=stmt.executeUpdate("insert into PHARMACY values('"+name1+"','"+refid1+"','"+dose1+"',TO_DATE('"+idate+"','DD-MM-YYYY'),TO_DATE('"+edate+"','DD-MM-YYYY'),'"+price1+"','"+st+"')");
						if(s==1){
							JOptionPane.showMessageDialog(null, "Records Inserted");
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null, "Records not Inserted");
						}
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnAddMedicine.setForeground(new Color(30, 144, 255));
		btnAddMedicine.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddMedicine.setBounds(870, 483, 227, 44);
		panel_1.add(btnAddMedicine);
		
		JButton btnRemoveMedicine = new JButton("REMOVE MEDICINE");
		btnRemoveMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String name1=name.getText().toUpperCase().trim();
					String refid1=refid.getText().toUpperCase().trim();
					ResultSet rs=stmt.executeQuery("select * from pharmacy where TABLET_NAME='"+name1+"' OR REF_ID='"+refid1+"'");
					if(rs.next()){
						//JOptionPane.showMessageDialog(null, "Medicine "+name1+" or "+refid1+" is already present");
						int rs2=stmt.executeUpdate("delete from pharmacy where TABLET_NAME='"+name1+"' OR REF_ID='"+refid1+"'");
						if(rs2==1){
							JOptionPane.showMessageDialog(null, "Record Deleted Succesfully");
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null, "Record not deleted");
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Medicine "+name1+" or "+refid1+" not present");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnRemoveMedicine.setForeground(new Color(30, 144, 255));
		btnRemoveMedicine.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemoveMedicine.setBounds(870, 550, 227, 44);
		panel_1.add(btnRemoveMedicine);
		
		JButton btnUpdateMedicine = new JButton("UPDATE MEDICINE");
		btnUpdateMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
					stmt = conn.createStatement();
					
					String name1=name.getText().toUpperCase().trim();
					String refid1=refid.getText().toUpperCase().trim();
					ResultSet rs=stmt.executeQuery("select * from pharmacy where TABLET_NAME='"+name1+"' OR REF_ID='"+refid1+"'");
					if(rs.next()){
						int dose1=Integer.parseInt(dose.getText().trim());
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						String idate=sdf.format(i_date.getDate()); 
						String edate=sdf.format(e_date.getDate()); 
						
						int price1=Integer.parseInt(price.getText().trim());
						String st=st_adv.getText().toUpperCase().trim();
						int s=stmt.executeUpdate("update PHARMACY set DOSE='"+dose1+"',ISSUE_DATE=TO_DATE('"+idate+"','DD-MM-YYYY'),EXPIRY_DATE=TO_DATE('"+edate+"','DD-MM-YYYY'),PRICE='"+price1+"',STORAGE_ADVICE='"+st+"' where TABLET_NAME='"+name1+"' OR REF_ID='"+refid1+"' ");
						if(s==1){
							JOptionPane.showMessageDialog(null, "Records Updated");
							
							showTableData();
						}else{
							JOptionPane.showMessageDialog(null, "Records not Updated");
						}
						
					}else{
						
						JOptionPane.showMessageDialog(null, "Medicine "+name1+" or "+refid1+" is not availablet");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnUpdateMedicine.setForeground(new Color(30, 144, 255));
		btnUpdateMedicine.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateMedicine.setBounds(870, 615, 227, 44);
		panel_1.add(btnUpdateMedicine);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mp=new MainPage();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				mp.setResizable(false);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Pharmacy.class.getResource("/Images/back (2).png")));
		button.setBounds(0, 0, 70, 57);
		panel_1.add(button);
		
		JButton btnDisplayAll = new JButton("Display All");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
			}
		});
		btnDisplayAll.setForeground(new Color(30, 144, 255));
		btnDisplayAll.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplayAll.setBounds(317, 144, 227, 44);
		panel_1.add(btnDisplayAll);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pharmacy.class.getResource("/Images/medbackground_1.jpg")));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		panel.add(lblNewLabel);
	}
}
