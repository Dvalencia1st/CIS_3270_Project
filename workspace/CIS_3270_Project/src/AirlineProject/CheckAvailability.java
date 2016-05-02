package AirlineProject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class CheckAvailability extends JFrame implements ActionListener {
	
	
	// declare the flowlayout, fonts, text labels and text fields. 
	//Create the button objectsand choice object for the dropdown menu
	FlowLayout fL;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JTextField txtField2, txtField3, txtField4, txtField5, txtField6;
	JButton submitButton = new JButton("Submit");
	JButton resetButton = new JButton("Reset");
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	int count;
	Font font;
	Choice toFrom = new Choice();
	
	MenuBar mbar;
	Menu m;
	MenuItem m1_1;
	
	public CheckAvailability() {	
		
		// create the menu bar
		
		mbar = new MenuBar();
		setMenuBar(mbar);
		m = new Menu("MainMenu");
		mbar.add(m);
		m1_1 = new MenuItem("GoBack to MainMenu");
		m.add(m1_1);
	//Set the font styles, size, and 
	//Set the layout 
	font = new Font("Gadugi", Font.BOLD, 18);
	fL = new FlowLayout(FlowLayout.CENTER, 250, 10);
	setLayout(fL);
    

    // Add labels and text fields to the frame
    //Set the font of the label to the "font"
    l1 = new JLabel("To/From");
    l1.setFont(font);
    add(l1);
    
    //add the toFrom choice object for the drop down menu
    add(toFrom);
    toFrom.add("Al - NY : 1011");
    toFrom.add("AL - WI : 2011");
    toFrom.add("AL - KS : 3011");
    toFrom.add("AL - MK : 4011");
    toFrom.add("AL - OH : 5011");
    toFrom.add("AL - LA : 6011");
    toFrom.add("AL - VG : 7011");
    
    toFrom.add("AL - DL : 8011");
    toFrom.add("AL - AR : 9011");
    toFrom.add("AL - BS : 1011");
    toFrom.add("AL - TM : 1111");
    toFrom.add("AL - FT : 1211");
   
    
    l2 = new JLabel("Travel Date");
    l2.setFont(font);
    add(l2);
    txtField2 = new JTextField(20);
    add(txtField2);
    
    l3 = new JLabel("Flight No");
    l3.setFont(font);
    add(l3);
    txtField3 = new JTextField(20);
    add(txtField3);
    
    l4 = new JLabel("First Class");
    l4.setFont(font);
    add(l4);
    txtField4 = new JTextField(20);
    add(txtField4);
    
    l5 = new JLabel("Business Class");
    l5.setFont(font);
    add(l5);
    txtField5 = new JTextField(20);
    add(txtField5);
    
    l6 = new JLabel("First Class");
    l6.setFont(font);
    add(l6);
    txtField6 = new JTextField(20);
    add(txtField6);
    
    //add the submit and reset buttons 
    //uses the implements ActionListener to process the event of hitting the buttons
    add(submitButton);
    add(resetButton);
    submitButton.addActionListener(this);
    resetButton.addActionListener(this);
    
    //allows us to interact with GUI
    addWindowListener(new W());
	
	m1_1.addActionListener(this);
	
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == m1_1) {
			MainMenu m = new MainMenu();
			m.setTitle("Main Menu");
			m.setSize(400, 400);
			m.setVisible(true);

		}
		if (ae.getSource() == submitButton) {

			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AirlineSystem", "root",
						"123123");

				Statement stmt = con.createStatement();
				ps = con.prepareStatement("Select * from Reservation where TravelDate=? and FlightNo=?");
				ps.setString(1, txtField2.getText());
				ps.setString(2, txtField3.getText());
				rs = ps.executeQuery();
				rs.next();
				txtField4.setText(Integer.toString(rs.getInt(3)));
				txtField5.setText(Integer.toString(rs.getInt(4)));
				txtField6.setText(Integer.toString(rs.getInt(5)));
				con.close();
			} catch (Exception e) {
				System.out.println("2 Error : " + e);
			}
		}

		if (ae.getSource() == resetButton) {
			txtField2.setText("");
			txtField3.setText("");
			txtField4.setText("");
			txtField5.setText("");
			txtField6.setText("");
		}
	}

	class W extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}

	
	

    
	

  /** Main method that sets the size of the whole frame and titles it. 
  */
  public static void main(String[] args) {
    CheckAvailability frame = new CheckAvailability();
    frame.setTitle("Check");
    frame.setSize(600, 700);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

   
        
    
  }



}

