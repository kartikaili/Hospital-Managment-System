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


public class Doctor_workpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_workpage frame = new Doctor_workpage();
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
	public Doctor_workpage() {
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
		
		JButton btnAppointment = new JButton("APPOINTMENTS");
		btnAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View_Appointments_doctorsworkpage va=new View_Appointments_doctorsworkpage();
				va.setVisible(true);
				va.setLocationRelativeTo(null);
				va.setResizable(false);
				dispose();
			}
		});
		btnAppointment.setForeground(new Color(30, 144, 255));
		btnAppointment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAppointment.setBounds(175, 260, 227, 44);
		btnAppointment.setBorder(br);
		panel.add(btnAppointment);
		
		JButton btnPatientDetails = new JButton("PATIENT DETAILS");
		btnPatientDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Doc_patient_details dp=new Doc_patient_details();
				dp.setVisible(true);
				dp.setLocationRelativeTo(null);
				dp.setResizable(false);
				dispose();
			}
		});
		btnPatientDetails.setForeground(new Color(30, 144, 255));
		btnPatientDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPatientDetails.setBounds(175, 326, 227, 44);
		btnPatientDetails.setBorder(br);
		panel.add(btnPatientDetails);
		
		JButton button_2 = new JButton("LOGOUT");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Doctor_Login dl=new Doctor_Login();
				dl.setVisible(true);
				dl.setLocationRelativeTo(null);
				dl.setResizable(false);
			}
		});
		button_2.setForeground(new Color(30, 144, 255));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBounds(215, 406, 141, 39);
		button_2.setBorder(br);
		panel.add(button_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Doctor_workpage.class.getResource("/Images/drback.jpg")));
		label.setBounds(0, 0, 1264, 681);
		panel.add(label);
	}

}
