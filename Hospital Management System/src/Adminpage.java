import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Adminpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminpage frame = new Adminpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Adminpage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1361, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1368, 691);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(325, 171, 226, 238);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\DOCTORDETAILS (2).png"));
		label.setBounds(30, 0, 160, 177);
		panel_1.add(label);
		
		JButton btnNewButton_1 = new JButton("DOCTOR DETAILS");
		btnNewButton_1.setForeground(new Color(0,153,255));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Doctorspage dp=new Doctorspage();
				dp.setVisible(true);
				dp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(42, 188, 148, 39);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(586, 171, 226, 238);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\patientdetals.png"));
		label_1.setBounds(28, 0, 160, 177);
		panel_2.add(label_1);
		
		JButton btnPatientDetails_1 = new JButton("PATIENT DETAILS");
		btnPatientDetails_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Patientpage pp=new Patientpage();
				pp.setVisible(true);
				pp.setLocationRelativeTo(null);;
				dispose();
			}
		});
		btnPatientDetails_1.setOpaque(true);
		btnPatientDetails_1.setForeground(new Color(0, 153, 255));
		btnPatientDetails_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPatientDetails_1.setBounds(38, 188, 148, 39);
		panel_2.add(btnPatientDetails_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(852, 171, 226, 238);
		panel.add(panel_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\RECETIONISTDETAILS.png"));
		label_2.setBounds(35, 0, 160, 177);
		panel_3.add(label_2);
		
		JButton btnPatientDetails = new JButton("RECEPTIONIST DETAILS");
		btnPatientDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReceptionistPage rp=new ReceptionistPage();
				rp.setVisible(true);
				rp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnPatientDetails.setOpaque(true);
		btnPatientDetails.setForeground(new Color(0, 153, 255));
		btnPatientDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPatientDetails.setBounds(24, 188, 181, 39);
		panel_3.add(btnPatientDetails);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(461, 443, 226, 238);
		panel.add(panel_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\BEDDETAILS.png"));
		label_3.setBounds(32, 0, 160, 177);
		panel_4.add(label_3);
		
		JButton btnBedAvailibility = new JButton("BED AVAILIBILITY");
		btnBedAvailibility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BedPage bp=new BedPage();
				bp.setVisible(true);
				bp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnBedAvailibility.setOpaque(true);
		btnBedAvailibility.setForeground(new Color(0, 153, 255));
		btnBedAvailibility.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBedAvailibility.setBounds(42, 188, 148, 39);
		panel_4.add(btnBedAvailibility);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminlogin al=new Adminlogin();
				al.setVisible(true);
				al.setLocationRelativeTo(null);;
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(0,153, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\LOGOUT (2).png"));
		btnNewButton.setBounds(0, 123, 63, 39);
		panel.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(736, 443, 226, 238);
		panel.add(panel_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\department.png"));
		label_4.setBounds(30, 0, 160, 177);
		panel_5.add(label_4);
		
		JButton btnDepartmentDetails = new JButton("DEPARTMENT DETAILS");
		btnDepartmentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepartmentPage dp=new DepartmentPage();
				dp.setVisible(true);
				dp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnDepartmentDetails.setOpaque(true);
		btnDepartmentDetails.setForeground(new Color(0, 153, 255));
		btnDepartmentDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDepartmentDetails.setBounds(30, 188, 174, 39);
		panel_5.add(btnDepartmentDetails);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\adminpanel.png"));
		lblNewLabel.setBounds(0, 0, 1368, 691);
		panel.add(lblNewLabel);
	}
}
