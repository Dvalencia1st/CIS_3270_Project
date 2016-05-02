package AirlineProject;
package edu.gsu.cis.reservation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;

import javax.swing.*;

public class Registration extends JFrame implements ActionListener {

	FlowLayout fL = new FlowLayout();
	JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt19;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14,l15, l16, l17, l18, l19;
	Choice securityQuestion = new Choice();;
	JButton submitButton = new JButton("Submit");
	JButton closeButton = new JButton("Close");
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	int count;
	Font font, titleFont;
	

	MenuBar mbar;
	Menu m;
	MenuItem m1_1;

	Registration() {
		
		mbar = new MenuBar();
		setMenuBar(mbar);
		m = new Menu("MainMenu");
		mbar.add(m);
		m1_1 = new MenuItem("GoBack to MainMenu");
		m.add(m1_1);
		
		font = new Font("TimesRoman", Font.BOLD, 20);
		titleFont = new Font("TimesRoman", Font.BOLD, 40);
		fL = new FlowLayout(FlowLayout.CENTER, 250, 10);
		setLayout(fL);
		
		l1 = new JLabel("REGISTRATION PAGE");
		l1.setFont(titleFont);
		add(l1);
	
		
		l2 = new JLabel("User Name");
		l2.setFont(font);
		add(l2);
		txt2 = new JTextField(20);
		add(txt2);
		
		l3 = new JLabel("Password");
		l3.setFont(font);
		add(l3);
		txt3 = new JTextField(20);
		add(txt3);
		
		l4 = new JLabel("Confirm Password");
		l4.setFont(font);
		add(l4);
		txt4 = new JTextField(20);
		add(txt4);
		
		l5 = new JLabel("Admin Code");
		l5.setFont(font);
		add(l5);
		txt5 = new JTextField(20);
		add(txt5);

		l6 = new JLabel("First Name");
		l6.setFont(font);
		add(l6);
		txt6 = new JTextField(20);
		add(txt6);
		
		l7 = new JLabel("Last Name");
		l7.setFont(font);
		add(l7);
		txt7 = new JTextField(20);
		add(txt7);
		
		l8 = new JLabel("Email Address");
		l8.setFont(font);
		add(l8);
		txt8 = new JTextField(20);
		add(txt8);
		
		l9 = new JLabel("Security Question");
		l9.setFont(font);
		add(l9);
		add(securityQuestion);
		securityQuestion.add("What's your mother maiden name ");
		securityQuestion.add("What's your first car model");
		securityQuestion.add("What's your first university");
		securityQuestion.add("What's your first car model");
		securityQuestion.add("What's your first girlfriend name");
		
		l10 = new JLabel("Security Question Answer");
		l10.setFont(font);
		add(l10);
		txt10 = new JTextField(20);
		add(txt10);
		
		l11 = new JLabel("Address");
		l11.setFont(font);
		add(l11);
		txt11 = new JTextField(20);
		add(txt11);
		
		l12 = new JLabel("Phone");
		l12.setFont(font);
		add(l12);
		txt12 = new JTextField(20);
		add(txt12);
		
		l13 = new JLabel("SSN");
		l13.setFont(font);
		add(l13);
		txt13 = new JTextField(20);
		add(txt13);
		
		submitButton = new JButton("Submit");
		closeButton = new JButton("close");
		
		add(submitButton);
		add(closeButton);
	

		submitButton.addActionListener(this);

		closeButton.addActionListener(this);
		
		addWindowListener((WindowListener) new W());
		
		m1_1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == m1_1) {
			MainMenu m = new MainMenu();
			m.setBackground(Color.red);
			m.setTitle("Main Menu");
			m.setSize(400, 400);
			m.setVisible(true);

		}
		if (ae.getSource() == closeButton) {
			setVisible(false);
			dispose();
		}
		
		
		if (ae.getSource() == submitButton) {

			boolean admin1;
			if (txt12.getText().equals("2016"))
				admin1 = true;
			else
				admin1 = false;
			User a = new User(txt6.getText(), txt7.getText(), txt8.getText(), securityQuestion.getSelectedItem(), txt10.getText(), txt11.getText(),
					txt12.getText(), txt2.getText(), txt3.getText(), admin1, txt13.getText());
			if (txt3.getText().equals(txt4.getText()))
				if (Search(a))
					Login.s.add(a);
				else {
					MessageBox mb = new MessageBox(this, "User already exist");
					mb.setLocation(200, 200);
					mb.setVisible(true);
				}
			else {
				MessageBox mb = new MessageBox(this, "Password doesn't match with Confirmed Password");
				mb.setLocation(200, 200);
				mb.setVisible(true);
			}
 
		}
	}

	public boolean Search(User a) {
		for (int i = 0; i < Login.s.size(); i++)

			if (Login.s.get(i).UserName.equals(a.UserName))
				return false;
		return true;

	}

	class W extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(true);
			dispose();

		}
	}

	public static void main(String args[]) {

		Registration r = new Registration();
		r.setSize(700, 1000);
		r.setVisible(true);
		r.setTitle("User Screen");

	}
}


