package hey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.awt.SystemColor;

public class StudentManagementSystem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JLabel lblNewLabel_1_3;
	private JButton btnNewButton_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	private JTextField sf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagementSystem frame = new StudentManagementSystem();
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
	public StudentManagementSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1035, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// start coding here 
				
				loadData();
				
				
			}//add action listener
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(51, 204, 102));
		btnNewButton.setBounds(340, 489, 134, 39);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setBounds(512, 143, 486, 385);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setForeground(new Color(204, 0, 0));
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.ITALIC, 30));
		lblNewLabel.setBounds(235, 11, 628, 52);
		contentPane.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setToolTipText("");
		t1.setBackground(SystemColor.control);
		t1.setBounds(146, 150, 189, 32);
		contentPane.add(t1);
		t1.setColumns(10);
		
		
		t2 = new JTextField();
		t2.setBackground(SystemColor.control);
		t2.setColumns(10);
		t2.setBounds(146, 233, 189, 32);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setBackground(SystemColor.control);
		t3.setColumns(10);
		t3.setBounds(146, 301, 189, 32);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setBackground(SystemColor.control);
		t4.setColumns(10);
		t4.setBounds(146, 374, 189, 32);
		contentPane.add(t4);
		
		JLabel lblNewLabel_1 = new JLabel("Roll No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(31, 143, 105, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fname");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(31, 223, 105, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Lname");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(31, 291, 105, 39);
		contentPane.add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("Marks");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(31, 367, 105, 39);
		contentPane.add(lblNewLabel_1_3);
		
		btnNewButton_3 = new JButton("Insert");
		btnNewButton_3.setBackground(new Color(32, 178, 170));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rollno=t1.getText();
				String Fname=t2.getText();
				String Lname=t3.getText();
				int marks=Integer.parseInt(t4.getText());
				
				String q="insert into students values(?,?,?,?)";
				
				Connection conn=DbConn.getConn();
				
				try {
					PreparedStatement ps =conn.prepareStatement(q);
					
					ps.setString(1, rollno);
					ps.setString(2,Fname);
					ps.setString(3,Lname);
					ps.setInt(4,marks);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(lblNewLabel_1_2, "Data Inserted Successfully");
					
					loadData();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(31, 457, 105, 43);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            
				
			   String q="update students set fname=?,lname=?,marks=?  where rollno=?";
				
				
				
//				String q="insert into students values(?,?,?,?)";
				
				Connection conn=DbConn.getConn();
				
				try {
					PreparedStatement ps =conn.prepareStatement(q);
					
					ps.setString(1, t2.getText());
					ps.setString(2,t3.getText());
					ps.setInt(3,Integer.parseInt(t4.getText()));
					ps.setString(4,t1.getText());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Updated Data Successfully");
					
					loadData();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(165, 457, 105, 43);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q="delete from students  where rollno=?";
				
//				DELETE FROM table_name WHERE condition;
				
//				String q="insert into students values(?,?,?,?)";
				
				Connection conn=DbConn.getConn();
				
				try {
					PreparedStatement ps =conn.prepareStatement(q);
					
//					ps.setString(1, t2.getText());
//					ps.setString(2,t3.getText());
//					ps.setInt(3,Integer.parseInt(t4.getText()));
					ps.setString(1,t1.getText());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Deleted Data Successfully");
					
					loadData();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(31, 531, 105, 43);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_4 = new JButton("Print");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(165, 531, 105, 43);
		contentPane.add(btnNewButton_4);
		
		sf = new JTextField();
		sf.setBackground(SystemColor.control);
		sf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				
				//code goes here 
				
				String key=sf.getText();
				
				//create query for each search into table
				
				String q="Select * from students where fname=?";
				
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					ps.setString(1, key);
					ResultSet rs=ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		sf.setBounds(769, 89, 210, 32);
		contentPane.add(sf);
		sf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Search Here");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(654, 86, 105, 32);
		contentPane.add(lblNewLabel_2);
		
		JButton btnShutdown = new JButton("ShutDown");
		btnShutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String es=JOptionPane.showInputDialog("Enter Samay: ");
				
				try {
					Runtime.getRuntime().exec("ShutDown  -s -t "+es);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
						
			}
		});
		btnShutdown.setForeground(Color.WHITE);
		btnShutdown.setBackground(new Color(255, 0, 0));
		btnShutdown.setBounds(845, 535, 134, 39);
		contentPane.add(btnShutdown);
	}

	private void loadData() {
		String q="Select * from students";
		
		Connection conn=DbConn.getConn();
		
		try {
			Statement stmt =conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(q);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
