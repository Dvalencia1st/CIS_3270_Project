package Group_Project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Checking extends Frame implements ActionListener {
	Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	TextField t1, t2, t3, t4, t5;
	Choice c;
	Button b1, b2;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	int count;
	Font f;

	Checking() {
		setBackground(Color.cyan);
		f = new Font("TimesRoman", Font.BOLD, 20);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		setLayout(gbl);
		l1 = new Label("");
		l4 = new Label("");
		l5 = new Label("");
		l6 = new Label("");
		l7 = new Label("");
		l2 = new Label("Travel Date");
		l2.setFont(f);
		l3 = new Label("Flight No");
		l3.setFont(f);
		l8 = new Label("First Class Seats");
		l8.setFont(f);
		l9 = new Label("Business Class Seats");
		l9.setFont(f);
		l10 = new Label("Economy Class Seats");
		l10.setFont(f);
		l11 = new Label("");
		l12 = new Label("");
		t1 = new TextField(20);
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);
		t5 = new TextField(20);
		c = new Choice();
		b1 = new Button("Submit");
		b2 = new Button("Reset");
		

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbl.setConstraints(l1, gbc);
		add(l1);

		c.add("Al - NY : 1011");
		c.add("AL - WI : 2011");
		c.add("AL - KS : 3011");
		c.add("AL - MK : 4011");
		c.add("AL - OH : 5011");
		c.add("AL - LA : 6011");
		c.add("AL - VG : 7011");
		c.add("AL - DL : 8011");
		c.add("AL - AR : 9011");
		c.add("AL - BS : 1011");
		c.add("AL - TM : 1111");
		c.add("AL - FT : 1211");

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbl.setConstraints(c, gbc);
		add(c);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbl.setConstraints(l4, gbc);
		add(l4);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(l5, gbc);
		add(l5);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbl.setConstraints(l2, gbc);
		add(l2);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbl.setConstraints(t1, gbc);
		add(t1);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbl.setConstraints(l3, gbc);
		add(l3);

		gbc.gridx = 2;
		gbc.gridy = 6;
		gbl.setConstraints(t2, gbc);
		add(t2);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbl.setConstraints(l6, gbc);
		add(l6);

		gbc.gridx = 2;
		gbc.gridy = 8;
		gbl.setConstraints(l7, gbc);
		add(l7);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbl.setConstraints(b1, gbc);
		add(b1);

		gbc.gridx = 2;
		gbc.gridy = 10;
		gbl.setConstraints(b2, gbc);
		add(b2);

		gbc.gridx = 0;
		gbc.gridy = 12;
		gbl.setConstraints(l11, gbc);
		add(l11);

		gbc.gridx = 2;
		gbc.gridy = 12;
		gbl.setConstraints(l12, gbc);
		add(l12);

		gbc.gridx = 0;
		gbc.gridy = 14;
		gbl.setConstraints(l8, gbc);
		add(l8);

		gbc.gridx = 2;
		gbc.gridy = 14;
		gbl.setConstraints(t3, gbc);
		add(t3);

		gbc.gridx = 0;
		gbc.gridy = 16;
		gbl.setConstraints(l9, gbc);
		add(l9);

		gbc.gridx = 2;
		gbc.gridy = 16;
		gbl.setConstraints(t4, gbc);
		add(t4);

		gbc.gridx = 0;
		gbc.gridy = 18;
		gbl.setConstraints(l10, gbc);
		add(l10);

		gbc.gridx = 2;
		gbc.gridy = 18;
		gbl.setConstraints(t5, gbc);
		add(t5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		addWindowListener(new W());
		
	


	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {

			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_reservation", "root",
						"salmo911");

				Statement stmt = con.createStatement();
				ps = con.prepareStatement("Select * from Ticket_number where TravelDate=? and FlightNo=?");
				ps.setString(1, t1.getText());
				ps.setString(2, t2.getText());
				rs = ps.executeQuery();
				rs.next();
				t3.setText(Integer.toString(rs.getInt(3)));
				t4.setText(Integer.toString(rs.getInt(4)));
				t5.setText(Integer.toString(rs.getInt(5)));
				con.close();
			} catch (Exception e) {
				System.out.println("2 Error : " + e);
			}
		}

		if (ae.getSource() == b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		}
	

	class W extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}
	}
	public static void main(String args[]) {

		Checking c = new Checking();
		c.setSize(600, 700);
		c.setVisible(true);
		c.setTitle("Check passenger");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

