import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;


public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setTitle("Hospital Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1274, 691);
		panel.setLayout(null);
		panel.setOpaque(true);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\SBI\\Main Project\\Hospital Management System\\src\\admin.png"));
		lblNewLabel.setBounds(215, 273, 128, 157);
		panel.add(lblNewLabel);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Adminlogin al=new Adminlogin();
				al.setVisible(true);
				al.setLocationRelativeTo(null);;
				dispose();
			}
		});
		
		btnAdmin.setOpaque(true);
		btnAdmin.setForeground(new Color(0, 153, 255));
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdmin.setBackground(UIManager.getColor("Button.highlight"));
		btnAdmin.setBounds(225, 441, 118, 36);
		panel.add(btnAdmin);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\SBI\\Main Project\\Hospital Management System\\src\\receptionist.png"));
		label_1.setBounds(471, 273, 128, 157);
		panel.add(label_1);
		
		JButton btnReceptionlist = new JButton("RECEPTIONIST");
		btnReceptionlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnReceptionlist.setForeground(new Color(0, 153, 255));
		btnReceptionlist.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReceptionlist.setBackground(Color.WHITE);
		btnReceptionlist.setOpaque(true);
		btnReceptionlist.setBounds(452, 441, 157, 36);
		panel.add(btnReceptionlist);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\SBI\\Main Project\\Hospital Management System\\src\\doctor (4).png"));
		label_2.setBounds(713, 273, 128, 157);
		panel.add(label_2);
		
		JButton btnDoctor = new JButton("DOCTOR");
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDoctor.setOpaque(true);
		
		btnDoctor.setForeground(new Color(0, 153, 255));
		btnDoctor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoctor.setBackground(Color.WHITE);
		btnDoctor.setBounds(723, 441, 118, 36);
		panel.add(btnDoctor);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Hospital MAnagement System\\Images\\pharmacy.png"));
		label_3.setBounds(938, 273, 128, 157);
		panel.add(label_3);
		
		JButton btnPharmacy = new JButton("PHARMACY");
		btnPharmacy.setOpaque(true);
		btnPharmacy.setForeground(new Color(0, 153, 255));
		btnPharmacy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPharmacy.setBackground(Color.WHITE);
		btnPharmacy.setBounds(938, 441, 118, 36);
		panel.add(btnPharmacy);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\SBI\\Main Project\\Hospital Management System\\src\\hmbackground.png"));
		label.setBounds(0, 0, 1274, 691);
		panel.add(label);
	}
}
