package Group_Project;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register extends Frame implements ActionListener {

	TextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t19;
	Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l19;
	Choice c;
	Button b1, b2, b3;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	Reservation re;
	
	int count;
	Font f, f1;

	Register() {
		setBackground(Color.lightGray);
		f = new Font("TimesRoman", Font.BOLD, 30);
		f1 = new Font("TimesRoman", Font.BOLD, 50);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		setLayout(gbl);
		l10 = new Label("REGISTRATION PAGE");
		l10.setFont(f1);
		l15 = new Label("User Name");
		l15.setFont(f);
		l8 = new Label("Pasword");
		l8.setFont(f);
		l9 = new Label("Confirm password");
		l9.setFont(f);
		l1 = new Label("Admin code");
		l1.setFont(f);
		l2 = new Label("First Name");
		l2.setFont(f);
		l3 = new Label("Last Name");
		l3.setFont(f);
		l4 = new Label("Email Address");
		l4.setFont(f);
		l17 = new Label("Your Security Question");
		l17.setFont(f);
		l5 = new Label("Your answer");
		l5.setFont(f);
		l6 = new Label("Address");
		l6.setFont(f);
		l7 = new Label("Phone");
		l7.setFont(f);
		l19 = new Label("SSN");
		l19.setFont(f);

		c = new Choice();

		t15 = new TextField(20);
		t10 = new TextField(20);
		t8 = new TextField(20);
		t8.setEchoChar('*');
		t9 = new TextField(20);
		t9.setEchoChar('*');
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);
		t5 = new TextField(20);
		t6 = new TextField(20);
		t7 = new TextField(20);
		t1 = new TextField(20);
		t1.setEchoChar('*');
		t19 = new TextField(20);
		t19.setEchoChar('*');

		c.add("What's your current school ");
		c.add("What's your first car model");
		c.add("What's your first pet name");
		c.add("What's your best friend's name");
		c.add("What's your sibling name");

		re = new Reservation();
		b1 = new Button("Submit");
		//add(b1);

		b3 = new Button("Close");

		l11 = new Label("");
		l12 = new Label("");
		l13 = new Label("");
		l14 = new Label("");

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbl.setConstraints(l10, gbc);
		add(l10);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbl.setConstraints(l13, gbc);
		add(l13);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(l14, gbc);
		add(l14);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbl.setConstraints(l15, gbc);
		add(l15);

		gbc.gridx = 2;
		gbc.gridy = 6;
		gbl.setConstraints(t15, gbc);
		add(t15);

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
		gbl.setConstraints(l17, gbc);
		add(l17);

		gbc.gridx = 2;
		gbc.gridy = 14;
		gbl.setConstraints(c, gbc);
		add(c);

		gbc.gridx = 0;
		gbc.gridy = 16;
		gbl.setConstraints(l5, gbc);
		add(l5);

		gbc.gridx = 2;
		gbc.gridy = 16;
		gbl.setConstraints(t5, gbc);
		add(t5);

		gbc.gridx = 0;
		gbc.gridy = 18;
		gbl.setConstraints(l6, gbc);
		add(l6);

		gbc.gridx = 2;
		gbc.gridy = 18;
		gbl.setConstraints(t6, gbc);
		add(t6);

		gbc.gridx = 0;
		gbc.gridy = 20;
		gbl.setConstraints(l7, gbc);
		add(l7);

		gbc.gridx = 2;
		gbc.gridy = 20;
		gbl.setConstraints(t7, gbc);
		add(t7);

		gbc.gridx = 0;
		gbc.gridy = 22;
		gbl.setConstraints(l8, gbc);
		add(l8);

		gbc.gridx = 2;
		gbc.gridy = 22;
		gbl.setConstraints(t8, gbc);
		add(t8);

		gbc.gridx = 0;
		gbc.gridy = 24;
		gbl.setConstraints(l9, gbc);
		add(l9);

		gbc.gridx = 2;
		gbc.gridy = 24;
		gbl.setConstraints(t9, gbc);
		add(t9);

		gbc.gridx = 0;
		gbc.gridy = 26;
		gbl.setConstraints(l1, gbc);
		add(l1);

		gbc.gridx = 2;
		gbc.gridy = 26;
		gbl.setConstraints(t1, gbc);
		add(t1);

		gbc.gridx = 0;
		gbc.gridy = 28;
		gbl.setConstraints(l11, gbc);
		add(l11);

		gbc.gridx = 2;
		gbc.gridy = 28;
		gbl.setConstraints(l12, gbc);
		add(l12);

		gbc.gridx = 0;
		gbc.gridy = 30;
		gbl.setConstraints(l19, gbc);
		add(l19);

		gbc.gridx = 2;
		gbc.gridy = 30;
		gbl.setConstraints(t19, gbc);
		add(t19);

		gbc.gridx = 0;
		gbc.gridy = 32;
		gbl.setConstraints(b1, gbc);
		add(b1);

		gbc.gridx = 2;
		gbc.gridy = 32;
		gbl.setConstraints(b3, gbc);
		add(b3);

		b1.addActionListener(this);

		b3.addActionListener(this);
		addWindowListener(new W());
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b3) {
			setVisible(false);
			dispose();
		}
		
		
		if (ae.getSource() == b1) {
			Reservation re = new Reservation();
			re.setBackground(Color.green);		
			re.setSize(600, 600);
			re.setVisible(true);
			re.setTitle("Reservation");
		}
			

			/*boolean ad;
			if (t1.getText().equals("1111"))
				ad = true;
			else
				ad = false;
			User a = new User(t2.getText(), t3.getText(), t4.getText(), c.getSelectedItem(), t5.getText(), t6.getText(),
					t7.getText(), t15.getText(), t9.getText(), ad, t19.getText(), "");
			if (t8.getText().equals(t9.getText()))
				if (Search(a))
					Login.s.add(a);
				else {
					Message mg = new Message(this, "User already exist");
					mg.setLocation(200, 200);
					mg.setVisible(true);
				}
			else {
				Message mg = new Message(this, "Password doesn't match with Confirmed Password");
				mg.setLocation(200, 200);
				mg.setVisible(true);
			}*/

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

		Register r = new Register();
		r.setSize(1000, 1000);
		r.setVisible(true);
		r.setTitle("User Screen");

	}

}
