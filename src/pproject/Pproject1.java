package pproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane; 
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JPasswordField;
public class Pproject1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String DatabaseURL="jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb";
		try {
			Connection conn = DriverManager.getConnection(DatabaseURL);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pproject1 window = new Pproject1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pproject1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.add(Pproject2);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setBounds(0, 0, 434, 21);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 21, 89, 72);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(136, 48, 120, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(21, 103, 89, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(textField.Text = ) {
				String DatabaseURL="jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb";
				String user=textField.getText();
				String pass=passwordField.getText();
				
				try {
					String chk="Select * from LoginDb where UserName=? and Password=?";
					Connection conn = DriverManager.getConnection(DatabaseURL);
					PreparedStatement pst=conn.prepareStatement(chk);
					pst.setString(1, user);
					pst.setString(2, pass);
					ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						String password =rs.getString("Password");
						if(pass.equals(password)) {
							LoginSuccessfull f = new LoginSuccessfull();
				            f. Window2();
						}else {
							JOptionPane.showMessageDialog(null, "Invalid Password","Login Error", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Invalid Username Or Password","Login Error", JOptionPane.ERROR_MESSAGE);
					}
				}catch(SQLException ex) {
					ex.printStackTrace();
				}					
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(223, 167, 120, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, 
                        "No New User SignUp", 
                        "TITLE", 
                        JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBounds(47, 167, 146, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 103, 120, 22);
		frame.getContentPane().add(passwordField);
	}
}
