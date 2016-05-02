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

public class Admin extends JFrame implements ActionListener {
	
	
	/*data fields for the text fields, labels, fonts, buttons, choice object for the drop down menu
	Also creates buttons and assigns them their titles**/
	public static String b;
	FlowLayout fL;
	JTextField txtField1, txtField2;
	JLabel l1, l2;
	Choice toFrom = new Choice();
	JButton submitButton = new JButton("Submit");
	JButton resetButton = new JButton("Reset");
	Connection conn;
	PreparedStatement pS;
	Statement stment;
	ResultSet rS;
	Font font;
	
	// declares menu items/variables
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
		
		//creates font object 
		
		font = new Font("Gadugi", Font.BOLD, 18);
		fL = new FlowLayout(FlowLayout.CENTER, 250, 10);
		
		//sets layout to flow layout
		setLayout(fL);
		
		//adds the toFrom drop down menu choices
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
	    
	    //creates the labels and adds the text fields

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
			m.setTitle("Main Menu");
			m.setSize(400, 400);
			m.setVisible(true);

		}
		
		if (ae.getSource() == submitButton) {
			Login.s.get(SearchFname(txtField2.getText())).book = txtField2.getText();
			b = txtField2.getText();

		}

		if (ae.getSource() == resetButton)

		{
			txtField1.setText("");
			txtField2.setText("");
	
		}

	}

	class W extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}
	
	/* The main methods sets the size and title **/

	public static void main(String args[]) {

		CreatePassenger frame = new CreatePassenger();
		frame.setSize(600, 900);
		frame.setVisible(true);
		frame.setTitle("Create Passenger");

	}
}
