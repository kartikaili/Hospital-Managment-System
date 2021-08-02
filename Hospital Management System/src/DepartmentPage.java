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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DepartmentPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(518, 283, 214, 28);
		panel_2.add(textField);
		
		JLabel lblDeptDiscription = new JLabel("DEPT Discription");
		lblDeptDiscription.setForeground(new Color(0, 153, 255));
		lblDeptDiscription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeptDiscription.setBounds(369, 413, 139, 19);
		panel_2.add(lblDeptDiscription);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(518, 346, 214, 28);
		panel_2.add(textField_1);
		
		JLabel lblDeptName = new JLabel("DEPT Name");
		lblDeptName.setForeground(new Color(0, 153, 255));
		lblDeptName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeptName.setBounds(369, 355, 139, 19);
		panel_2.add(lblDeptName);
		
		JButton btnRemoveDepartment = new JButton("Remove Department");
		btnRemoveDepartment.setForeground(new Color(30, 144, 255));
		btnRemoveDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemoveDepartment.setBounds(480, 465, 207, 33);
		btnRemoveDepartment.setBorder(br);
		panel_2.add(btnRemoveDepartment);
		
		JButton btnUpdateDepartment = new JButton("Update Department");
		btnUpdateDepartment.setForeground(new Color(30, 144, 255));
		btnUpdateDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateDepartment.setBounds(731, 465, 207, 33);
		btnUpdateDepartment.setBorder(br);
		panel_2.add(btnUpdateDepartment);
		
		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(518, 404, 394, 28);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\D3 (1).jpg"));
		label.setBounds(0, 0, 1264, 681);
		panel.add(label);
	}
}
