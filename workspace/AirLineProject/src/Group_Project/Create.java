package Group_Project;

package edu.gsu.cis.reservation;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Create extends Frame implements ActionListener {
	public static String b;
	TextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
	Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17;
	Choice c;
	Button b1, b2, b3;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	int count;
	Font f;

	Create() {
		setBackground(Color.lightGray);
		f = new Font("TimesRoman", Font.BOLD, 20);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		setLayout(gbl);

		l15 = new Label("Flight No");
		l15.setFont(f);
		l1 = new Label("Travel Date");
		l1.setFont(f);
		l2 = new Label("FName");
		l2.setFont(f);
		l3 = new Label("LName");
		l3.setFont(f);
		l4 = new Label("Age");
		l4.setFont(f);
		l5 = new Label("Gender");
		l5.setFont(f);
		l6 = new Label("Address");
		l6.setFont(f);
		l7 = new Label("Phone");
		l7.setFont(f);
		l8 = new Label("Class");
		l8.setFont(f);
		l9 = new Label("Status");
		l9.setFont(f);

		t10 = new TextField(20);
		t1 = new TextField(20);
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);
		t5 = new TextField(20);
		t6 = new TextField(20);
		t7 = new TextField(20);
		t8 = new TextField(20);
		t9 = new TextField(20);

		c = new Choice();

		b1 = new Button("Submit");
		b2 = new Button("Reset");
		b3 = new Button("Get Ticket");

		l10 = new Label("");
		l11 = new Label("");
		l12 = new Label("");
		l13 = new Label("");
		l14 = new Label("");

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbl.setConstraints(l10, gbc);
		add(l10);

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
		gbl.setConstraints(l13, gbc);
		add(l13);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(l14, gbc);
		add(l14);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbl.setConstraints(l15, gbc);
		add(l15);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbl.setConstraints(t10, gbc);
		add(t10);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbl.setConstraints(l1, gbc);
		add(l1);

		gbc.gridx = 2;
		gbc.gridy = 6;
		gbl.setConstraints(t1, gbc);
		add(t1);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbl.setConstraints(l2, gbc);
		add(l2);

		gbc.gridx = 2;
		gbc.gridy = 8;
		gbl.setConstraints(t2, gbc);
		add(t2);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbl.setConstraints(l3, gbc);
		add(l3);

		gbc.gridx = 2;
		gbc.gridy = 10;
		gbl.setConstraints(t3, gbc);
		add(t3);

		gbc.gridx = 0;
		gbc.gridy = 12;
		gbl.setConstraints(l4, gbc);
		add(l4);

		gbc.gridx = 2;
		gbc.gridy = 12;
		gbl.setConstraints(t4, gbc);
		add(t4);

		gbc.gridx = 0;
		gbc.gridy = 14;
		gbl.setConstraints(l5, gbc);
		add(l5);

		gbc.gridx = 2;
		gbc.gridy = 14;
		gbl.setConstraints(t5, gbc);
		add(t5);

		gbc.gridx = 0;
		gbc.gridy = 16;
		gbl.setConstraints(l6, gbc);
		add(l6);

		gbc.gridx = 2;
		gbc.gridy = 16;
		gbl.setConstraints(t6, gbc);
		add(t6);

		gbc.gridx = 0;
		gbc.gridy = 18;
		gbl.setConstraints(l7, gbc);
		add(l7);

		gbc.gridx = 2;
		gbc.gridy = 18;
		gbl.setConstraints(t7, gbc);
		add(t7);

		gbc.gridx = 0;
		gbc.gridy = 20;
		gbl.setConstraints(l8, gbc);
		add(l8);

		gbc.gridx = 2;
		gbc.gridy = 20;
		gbl.setConstraints(t8, gbc);
		add(t8);

		gbc.gridx = 0;
		gbc.gridy = 22;
		gbl.setConstraints(l9, gbc);
		add(l9);

		gbc.gridx = 2;
		gbc.gridy = 22;
		gbl.setConstraints(t9, gbc);
		add(t9);

		gbc.gridx = 0;
		gbc.gridy = 24;
		gbl.setConstraints(l11, gbc);
		add(l11);

		gbc.gridx = 2;
		gbc.gridy = 24;
		gbl.setConstraints(l12, gbc);
		add(l12);

		gbc.gridx = 0;
		gbc.gridy = 26;
		gbl.setConstraints(b1, gbc);
		add(b1);

		gbc.gridx = 2;
		gbc.gridy = 26;
		gbl.setConstraints(b2, gbc);
		add(b2);


		b1.addActionListener(this);
		b2.addActionListener(this);
		addWindowListener(new W());

	}
	public static int SearchFname(String a) {
		for (int i = 0; i < Login.s.size(); i++)
			if (a.equals(Login.s.get(i).Fname))
				return i;
		return -1;
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			Login.s.get(SearchFname(t2.getText())).book = t10.getText();
			b = t2.getText();

		}

		if (ae.getSource() == b2)

		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			t10.setText("");

		}

	}

	class W extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}

	public static void main(String args[]) {

		Create v = new Create();
		v.setSize(600, 700);
		v.setVisible(true);
		v.setTitle("Create Passenger Screen");

	}
}



