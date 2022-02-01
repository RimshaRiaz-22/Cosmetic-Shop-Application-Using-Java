package pproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

import org.hsqldb.ClientConnection;

import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;


public class Pproject4 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void Upd() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
		        System.out.println("Connected Successfully");
					Pproject4 window = new Pproject4();
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
	public Pproject4() {
		initialize();
	}
	//ComboBox fill items from Database
    public void fillcombo() {
    	try {
    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
            System.out.println("Connected Successfully");
    		String query = "select * from Cosmetics";
			PreparedStatement pst = connection.prepareStatement(query);
    		ResultSet rs= pst.executeQuery();
    		while(rs.next()) {
    			comboBox.addItem(rs.getString("ID"));
    		}
    	}catch(Exception a) {
    		a.printStackTrace();
    	}
    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Products :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(124, 26, 141, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type  :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(32, 91, 93, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Brand:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(32, 116, 93, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Name:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(32, 141, 93, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
	            System.out.println("Connected Successfully");
	    		String query = "Update Cosmetics set Type='"+textField.getText()+"',Brand='"+textField_1.getText()+"',NameC='"+textField_2.getText()+"'where ID='"+comboBox.getSelectedItem()+ "' ";
				PreparedStatement pst = connection.prepareStatement(query);
	    		pst.executeUpdate();
	    		
	    		JOptionPane.showMessageDialog(null, "Products Updated Succesfully");
				}catch(Exception h) {
					h.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(225, 243, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Click Update to make changes in your products.");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(lblNewLabel_4.getFont().deriveFont(lblNewLabel_4.getFont().getStyle() | Font.ITALIC));
		lblNewLabel_4.setBounds(71, 287, 338, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(169, 88, 118, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 113, 118, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 138, 118, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginSuccessfull f = new LoginSuccessfull();
	            f. Window2();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(58, 243, 93, 23);
		frame.getContentPane().add(btnBack);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			//fill text fields from combo box selected data
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
		              System.out.println("Connected Successfully");
					String query = "select * from Cosmetics where ID= ?";
					PreparedStatement pstt=connection.prepareStatement(query);
					pstt.setString(1,(String) comboBox.getSelectedItem());
					ResultSet rs= pstt.executeQuery();
					while(rs.next()) {
						textField.setText(rs.getString("Type"));
						textField_1.setText(rs.getString("Brand"));
						textField_2.setText(rs.getString("NameC"));
					}
					pstt.close();
				}catch(Exception b) {
					b.printStackTrace();
				}
				
			}
		});
		comboBox.setBounds(169, 59, 118, 23);
		frame.getContentPane().add(comboBox);
		 fillcombo();
		
		JLabel lblNewLabel_5 = new JLabel("Cosmetics ID :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(35, 66, 90, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("select ID to search");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(305, 63, 104, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cosmetic Shop");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_2_1.setBounds(22, 0, 148, 28);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(169, 169, 118, 22);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_3_1 = new JLabel(" Face Products:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(32, 172, 93, 15);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(" Face Products:");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3_1_1.setBounds(32, 208, 93, 15);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(169, 205, 118, 22);
		frame.getContentPane().add(spinner_1);
	}
}
