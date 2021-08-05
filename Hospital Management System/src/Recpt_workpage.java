import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Recpt_workpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recpt_workpage frame = new Recpt_workpage();
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
	public Recpt_workpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280,720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Border br=BorderFactory.createLineBorder(new Color(0,153,255));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1264, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCreateAppointment = new JButton("CREATE APPOINTMENT");
		btnCreateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCreateAppointment.setForeground(new Color(30, 144, 255));
		btnCreateAppointment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreateAppointment.setBounds(132, 247, 227, 44);
		btnCreateAppointment.setBorder(br);
		panel.add(btnCreateAppointment);
		
		JButton btnDoctorDetails = new JButton("DOCTOR DETAILS");
		btnDoctorDetails.setForeground(new Color(30, 144, 255));
		btnDoctorDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDoctorDetails.setBounds(132, 313, 227, 44);
		btnDoctorDetails.setBorder(br);
		panel.add(btnDoctorDetails);
		
		JButton btnBedDetails = new JButton("PATIENTS DETAILS");
		btnBedDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recpt_patient_page rp=new Recpt_patient_page();
				rp.setVisible(true);
				rp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnBedDetails.setForeground(new Color(30, 144, 255));
		btnBedDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBedDetails.setBounds(132, 392, 227, 39);
		btnBedDetails.setBorder(br);
		panel.add(btnBedDetails);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recpt_work rp=new Recpt_work();
				rp.setVisible(true);
				rp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnLogout.setForeground(new Color(30, 144, 255));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(179, 465, 141, 39);
		btnLogout.setBorder(br);
		panel.add(btnLogout);
		
		JLabel lblBedDetails = new JLabel("");
		lblBedDetails.setIcon(new ImageIcon(Recpt_workpage.class.getResource("/Images/recback.jpg")));
		lblBedDetails.setBounds(0, 0, 1264, 681);
		panel.add(lblBedDetails);
	}
}
