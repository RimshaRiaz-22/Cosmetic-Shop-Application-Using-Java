package pproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;

public class Pproject2 {
	/**
	 * For Image Browse.
	 */
	
	private JFrame frame;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void AdmForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");//Establishing Connection
		              System.out.println("Connected Successfully");
					Pproject2 window = new Pproject2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					 System.out.println("Error in connection");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	public Pproject2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 400, 522, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cosmetic Shop");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel.setBounds(83, 28, 148, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Cosmetic");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(152, 56, 136, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Name :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(23, 114, 102, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Select Type :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(23, 150, 76, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Select Brand :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(23, 186, 97, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("Face Products :");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(23, 211, 76, 15);
		frame.getContentPane().add(lblNewLabel_9);
		
		table_1 = new JTable();
		table_1.setBounds(10, 612, 212, -54);
		frame.getContentPane().add(table_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 111, 259, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//PProject//Database.accdb");
		              System.out.println("Connected Successfully");
		              PreparedStatement preparedStatement=connection.prepareStatement("insert into   Cosmetics(NameC,Brand,Type,Price) Values(?,?,?,?)");
		              preparedStatement.setString(1,textField_1.getText());
		              preparedStatement.setString(2,(String) comboBox_1.getSelectedItem());
		              preparedStatement.setString(3,(String) comboBox.getSelectedItem());
		              preparedStatement.setString(4,textField_2.getText());
		              preparedStatement.executeUpdate();
		              System.out.println("Data inserted successfully");
		              JOptionPane.showMessageDialog(null, 
		                        "Cosmetic Item Added Successfully", 
		                        "TITLE", 
		                        JOptionPane.WARNING_MESSAGE);
					}catch(SQLException | ClassNotFoundException ex) {
					ex.printStackTrace();	}
			}
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(281, 318, 93, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to fill another Form?", "Swing Tester",
	                      JOptionPane.YES_NO_OPTION,
	                      JOptionPane.QUESTION_MESSAGE);
	                   if(result == JOptionPane.YES_OPTION){
	                	   Pproject2 f = new Pproject2();
		       	            f. AdmForm();
		       	            
	                	   
	                	  
	                   }else if (result == JOptionPane.NO_OPTION){
	                	   LoginSuccessfull f = new LoginSuccessfull();
		   		            f. Window2();
	                   }else {
	                	   
	                   }
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBounds(103, 319, 93, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("SimSun", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Face", "Hand", "Foot", "Lips", "Hairs"}));
		comboBox.setBounds(103, 146, 259, 23);
		frame.getContentPane().add(comboBox);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Huda", "Rivaaj", "Mac", "Olivia", "Myebelline", "SwissMiss"}));
		comboBox_1.setFont(new Font("SimSun", Font.BOLD, 13));
		comboBox_1.setBounds(103, 182, 259, 23);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Hand products :");
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_9_1.setBounds(23, 247, 97, 15);
		frame.getContentPane().add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_4 = new JLabel("Price :");
		lblNewLabel_4.setBounds(23, 272, 54, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 272, 259, 21);
		frame.getContentPane().add(textField_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(124, 208, 115, 22);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(124, 244, 115, 22);
		frame.getContentPane().add(spinner_1);
	}
}
