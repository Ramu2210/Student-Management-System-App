package hey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import hey.DbConn;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginForm {

	private JFrame frmWelcomeToSms;
	private JTextField uf;
	private JPasswordField pf;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmWelcomeToSms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginForm() {
		initialize();
	}


	private void initialize() {
		frmWelcomeToSms = new JFrame();
		frmWelcomeToSms.getContentPane().setForeground(Color.BLACK);
		frmWelcomeToSms.setTitle("Welcome to SMS");
		frmWelcomeToSms.getContentPane().setBackground(new Color(169, 169, 169));
		frmWelcomeToSms.setBounds(100, 100, 835, 527);
		frmWelcomeToSms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToSms.getContentPane().setLayout(null);
		
		uf = new JTextField();
		uf.setBounds(412, 92, 344, 34);
		frmWelcomeToSms.getContentPane().add(uf);
		uf.setColumns(10);
		
		pf = new JPasswordField();
		pf.setBounds(412, 226, 339, 34);
		frmWelcomeToSms.getContentPane().add(pf);
		
		JLabel lblNewLabel = new JLabel("Enter UserName");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(412, 48, 306, 34);
		frmWelcomeToSms.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setForeground(Color.BLACK);
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterPassword.setBounds(412, 182, 306, 34);
		frmWelcomeToSms.getContentPane().add(lblEnterPassword);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String user = uf.getText();
			String pass = String.valueOf(pf.getPassword());
			
//this will show password & username credantial	//	System.out.println(user+" "+ pass);
			
			String q = "Select * from users where username = ? and pass = ?";
			
			try {
				PreparedStatement ps = DbConn.getConn().prepareStatement(q);
				ps.setString(1, user);
				ps.setString(2, pass);
				
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(btnNewButton, "Succesfully login");
				StudentManagementSystem frame = new StudentManagementSystem();
				frame.setVisible(true);
			
			}else {
				JOptionPane.showMessageDialog(btnNewButton, "Invalid Username or Password");
			}
				
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(473, 341, 203, 63);
		frmWelcomeToSms.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\reshm\\Desktop\\download.jpeg"));
		lblNewLabel_1.setBounds(76, 86, 209, 318);
		frmWelcomeToSms.getContentPane().add(lblNewLabel_1);
	}
}