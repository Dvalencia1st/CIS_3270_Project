package AirlineProject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class CreatePassenger extends JFrame implements ActionListener {
	
	public static String b;
	FlowLayout fL;
	JTextField txtField1, txtField2, txtField3, txtField4, txtField5, txtField6, txtField7, txtField8, txtField9, txtField10;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	Choice toFrom = new Choice();
	JButton submitButton = new JButton("Submit");
	JButton resetButton = new JButton("Reset");
	JButton gtButton = new JButton("Get Ticket");
	Connection conn;
	PreparedStatement pS;
	Statement stment;
	ResultSet rS;
	int count;
	Font font;
	
	MenuBar mbar;
	Menu m;
	MenuItem m1_1;

	CreatePassenger() {
		
		mbar = new MenuBar();
		setMenuBar(mbar);
		m = new Menu("MainMenu");
		mbar.add(m);
		m1_1 = new MenuItem("GoBack to MainMenu");
		m.add(m1_1);
		
		font = new Font("Gadugi", Font.BOLD, 18);
		fL = new FlowLayout(FlowLayout.CENTER, 250, 10);
		setLayout(fL);
		
		add(toFrom);
	    toFrom.add("Atlanta, GA - Abilene, TX : 1011");
	    toFrom.add("Atlanta, GA - Bakersfield, CA : 2011");
	    toFrom.add("Atlanta, GA - Ithaca, NY : 3011");
	    toFrom.add("Atlanta, GA - Toronto, ON : 4011");
	    toFrom.add("Atlanta, GA - Seattle, WA : 5011");
	    toFrom.add("Atlanta, GA - Washington DC : 6011");
	    toFrom.add("Atlanta, GA - Oakland, CA : 7011");
	    toFrom.add("Atlanta, GA - Fresno, CA : 8011");
	    toFrom.add("Atlanta, GA - Greensboro, NC : 9011");
	    toFrom.add("Atlanta, GA - Cincinnati, OH : 1011");
	    toFrom.add("Atlanta, GA - Chicago, IL : 1111");
	    toFrom.add("Atlanta, GA - San Jose, CA : 1211");

		l1 = new JLabel("Flight No");
		l1.setFont(font);
		add(l1);
		txtField1 = new JTextField(20);
		add(toFrom);
		    
		l2 = new JLabel("Travel Date");
	    l2.setFont(font);
	    add(l2);
	    txtField2 = new JTextField(20);
	    add(txtField2);
	    
	    l3 = new JLabel("First Name");
	    l3.setFont(font);
	    add(l3);
	    txtField3 = new JTextField(20);
	    add(txtField3);
	    
	    l4 = new JLabel("Last Name");
	    l4.setFont(font);
	    add(l4);
	    txtField4 = new JTextField(20);
	    add(txtField4);
	    
	    l7 = new JLabel("Address");
	    l7.setFont(font);
	    add(l7);
	    txtField7 = new JTextField(20);
	    add(txtField7);
	    
	    l8 = new JLabel("Phone");
	    l8.setFont(font);
	    add(l8);
	    txtField8 = new JTextField(20);
	    add(txtField8);
	    
	    l9 = new JLabel("Class");
	    l9.setFont(font);
	    add(l9);
	    txtField9 = new JTextField(20);
	    add(txtField9);
	    
	    l10 = new JLabel("Status");
	    l10.setFont(font);
	    add(l10);
	    txtField10 = new JTextField(20);
	    add(txtField10);


		add(resetButton);
		add(submitButton);

		resetButton.addActionListener(this);
		submitButton.addActionListener(this);
		
		addWindowListener((WindowListener) new W());
		
		m1_1.addActionListener(this);

	}
	public static int SearchFname(String a) {
		for (int i = 0; i < Login.s.size(); i++)
			if (a.equals(Login.s.get(i).Fname))
				return i;
		return -1;
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == m1_1) {
			MainMenu m = new MainMenu();
			m.setBackground(Color.red);
			m.setTitle("Main Menu");
			m.setSize(400, 400);
			m.setVisible(true);

		}
		
		if (ae.getSource() == submitButton) {
			Login.s.get(SearchFname(txtField2.getText())).book = txtField10.getText();
			b = txtField2.getText();

		}

		if (ae.getSource() == resetButton)

		{
			txtField1.setText("");
			txtField2.setText("");
			txtField3.setText("");
			txtField4.setText("");
			txtField5.setText("");
			txtField6.setText("");
			txtField7.setText("");
			txtField8.setText("");
			txtField9.setText("");
			txtField10.setText("");

		}

	}

	class W extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}

	public static void main(String args[]) {

		CreatePassenger v = new CreatePassenger();
		v.setSize(600, 900);
		v.setVisible(true);
		v.setTitle("Create Passenger");

	}
}
