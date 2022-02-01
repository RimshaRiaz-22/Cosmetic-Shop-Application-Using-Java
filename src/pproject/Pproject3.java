package pproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


public class Pproject3 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void Del() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
			        System.out.println("Connected Successfully");
					Pproject3 window = new Pproject3();
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
	public Pproject3() {
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
		
		JLabel lblNewLabel = new JLabel("Delete Info :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(134, 48, 143, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cosmetic ID :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(40, 78, 93, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try
			    {
			    	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
		            System.out.println("Connected Successfully");
		            Statement statement = conn.createStatement();
		            statement.executeUpdate("DELETE FROM Cosmetics WHERE ID=" + textField.getText() + "");  
		            JOptionPane.showMessageDialog(null, "Record deleted...");  
		            statement.close();  
		            conn.close();  
		       
			    }
			    catch (Exception excep)
			    {
			      System.err.println("Got an exception! ");
			    }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(243, 165, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Click Delete to Delete Item of selected Name ");
		lblNewLabel_3.setFont(new Font("SimSun", Font.ITALIC, 12));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(119, 120, 271, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginSuccessfull f = new LoginSuccessfull();
	            f. Window2();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(52, 165, 93, 23);
		frame.getContentPane().add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(145, 89, 117, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cosmetic Shop");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_2.setBounds(29, 10, 148, 28);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
