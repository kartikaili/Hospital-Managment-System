import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class View_Appointments_doctorsworkpage extends JFrame {

	private JPanel contentPane;
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
			ResultSet rs=stmt.executeQuery("select D_Name,PID,P_Name,APPOINTMENT_DATE,APT_TIME from Appointment ORDER BY D_Name ASC");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Appointments_doctorsworkpage frame = new View_Appointments_doctorsworkpage();
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
	public View_Appointments_doctorsworkpage() {
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
		
		JLabel lblViewAppointments = new JLabel("VIEW APPOINTMENTS");
		lblViewAppointments.setForeground(Color.WHITE);
		lblViewAppointments.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblViewAppointments.setBounds(486, 11, 278, 31);
		panel_1.add(lblViewAppointments);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Doctor_workpage dw=new Doctor_workpage();
				dw.setVisible(true);
				dw.setLocationRelativeTo(null);
				dw.setResizable(false);
			}
		});
		button.setIcon(new ImageIcon(View_Appointments_doctorsworkpage.class.getResource("/Images/back (2).png")));
		button.setForeground(new Color(0, 153, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.setBounds(0, 0, 63, 55);
		panel_1.add(button);
		
		JButton button_2 = new JButton("Display");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTableData();
			}
		});
		button_2.setForeground(new Color(30, 144, 255));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBounds(525, 194, 185, 33);
		panel.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 255, 818, 278);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Doctors Name", "Patient Name", "Appointment Date", "Appointment Time"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_Appointments_doctorsworkpage.class.getResource("/Images/pat.jpg")));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		panel.add(lblNewLabel);
	}
}
