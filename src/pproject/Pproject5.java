package pproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Pproject5 {

	private JFrame frame;
	private JButton btnBack;
	private JTabbedPane table;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void Searchh() {
		DefaultTableModel dtm;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
			        System.out.println("Connected Successfully");
					Pproject5 window = new Pproject5();
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
	public Pproject5() {
		initialize();
	}
    public void fillcombo2() {
    	try {
    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
            System.out.println("Connected Successfully");
    		String query = "select * from Cosmetics";
			PreparedStatement pst = connection.prepareStatement(query);
    		ResultSet rs= pst.executeQuery();
    		while(rs.next()) {
    			comboBox_2.addItem(rs.getString("NameC"));
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
		frame.setBounds(100, 100, 575, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Products");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(166, 32, 141, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Cosmetics Name :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(42, 102, 115, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginSuccessfull f = new LoginSuccessfull();
	            f. Window2();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(195, 174, 93, 23);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 208, 483, 20);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("Table From Database");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Brand");
		lblNewLabel_5.setBounds(208, 238, 54, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setBounds(20, 238, 54, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(" Name");
		lblNewLabel_7.setBounds(95, 238, 73, 15);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Type");
		lblNewLabel_9.setBounds(294, 238, 64, 15);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Price");
		lblNewLabel_10.setBounds(400, 238, 62, 15);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(8, 254, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(82, 254, 106, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(198, 254, 74, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(282, 254, 102, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(394, 254, 112, 21);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("fill comboBox to search");
		lblNewLabel_8.setFont(new Font("SimSun", Font.BOLD, 12));
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setBounds(250, 73, 174, 15);
		frame.getContentPane().add(lblNewLabel_8);
		
		 comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
		              System.out.println("Connected Successfully");
					String query = "select * from Cosmetics where NameC= ?";
					PreparedStatement pstt=connection.prepareStatement(query);
					pstt.setString(1,(String) comboBox_2.getSelectedItem());
					ResultSet rs= pstt.executeQuery();
					while(rs.next()) {
						textField.setText(rs.getString("ID"));
						textField_3.setText(rs.getString("NameC"));
						textField_4.setText(rs.getString("Brand"));
						textField_5.setText(rs.getString("Type"));
						textField_6.setText(rs.getString("Price"));
					}
					pstt.close();
				}catch(Exception b) {
					b.printStackTrace();
				}
				
				
			}
		});
		comboBox_2.setBounds(179, 98, 137, 23);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cosmetic Shop");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_2_1.setBounds(20, 10, 148, 28);
		frame.getContentPane().add(lblNewLabel_2_1);
		fillcombo2();
	}
}
