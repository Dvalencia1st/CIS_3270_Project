package AirlineProject;p

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;


public class Login extends JFrame implements ActionListener {
	
	public static ArrayList<User> s = new ArrayList<User>();

	public static boolean a;
	JTextField txtField1, txtField2;
	JLabel l1, l2, l3, l4, l5, l6;
	JButton pRButton, submitButton, closeButton, regButton;
	FlowLayout fL;

	Font font;

	public Login() {
		
		User b = new User("b", "b", "b", "b", "b", "b", "b", "b", "b", true, "b");
		s.add(b);
		User a = new User("a", "a", "a", "a", "a", "a", "a", "a", "a", false, "a");
		s.add(a);

	
		font = new Font("Gadugi", Font.BOLD, 28);
		fL = new FlowLayout(FlowLayout.CENTER, 250, 10);
		setLayout(fL);
	    
		l1 = new JLabel("Username");
		l1.setFont(font);
		add(l1);
		txtField1 = new JTextField(20);
		add(txtField1);
		
		l2 = new JLabel("Password");
		l2.setFont(font);
		add(l2);
		txtField2 = new JTextField(20);
		add(txtField2);
		

		pRButton = new JButton("Password Recovery");
		submitButton = new JButton("Submit");
		closeButton = new JButton("Close");
		regButton = new JButton("Register");
		
		add(pRButton);
		add(submitButton);
		add(closeButton);
		add(regButton);

		

		regButton.addActionListener(this);
		pRButton.addActionListener(this);
		submitButton.addActionListener(this);
		regButton.addActionListener(this);
	}

	public static int SearchUser(String a) {
		for (int i = 0; i < s.size(); i++)
			if (a.equals(s.get(i).UserName))
				return i;
		return -1;
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == pRButton) {
			PasswordRecovery p = new PasswordRecovery();
			p.setSize(1000, 600);
			p.setVisible(true);
			p.setTitle("Password Recovery");
		}

		if (ae.getSource() == regButton) {
			Registration r = new Registration();
			r.setSize(1000, 600);
			r.setVisible(true);
			r.setTitle("Create User Screen");

		}

		if (ae.getSource() == closeButton) {
			setVisible(false);
			dispose();
		}
		if (ae.getSource() == submitButton) {
			if (SearchUser(txtField1.getText()) >= 0 && txtField2.getText().equals(s.get(SearchUser(txtField1.getText())).Password)) {
				if (s.get(SearchUser(txtField1.getText())).admin) {
					a = true;
					MainMenu m = new MainMenu();
					setVisible(false);
					m.setSize(600, 400);
					m.setVisible(true);
					m.setTitle("Main Menu");
					m.setBackground(Color.blue);

				}

				else {
					a = false;
					MainMenu m = new MainMenu();
					setVisible(false);
					m.setSize(400, 400);
					m.setVisible(true);
					m.setTitle("Main Menu");
					m.setBackground(Color.green);
				}
			} else {

				MessageBox mb = new MessageBox(this, "Incorrect User name or password");
				mb.setLocation(200, 200);
				mb.setVisible(true);
			}
			class Driver {
				  
				Driver(){
					

				    // Establish a connection
				 try { 
				Class.forName("com.mysql.jdbc.Driver");
				         
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_reservation", "root", "salmo911");
				         // Create a statement
				         Statement statement = connection.createStatement();

				         // Execute a statement
				         ResultSet resultSet = statement.executeQuery("select * from ticket_number"); 

				         // Iterate through the result and print the student names
				         while (resultSet.next()) {
				        System.out.println(resultSet.getString("id")+ "," +resultSet.getString("last_name") + ", " + resultSet.getString("first_name") + ", " + resultSet.getString("email"));
				    }
				  
				}
				 catch (Exception exc) {
				 exc.printStackTrace();
				 }
				  }
				}

		}

	}
	
	public static void main(String[] args) {
		
		Login frame = new Login();
	    frame.setTitle("Login");
	    frame.setSize(600, 700);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}
