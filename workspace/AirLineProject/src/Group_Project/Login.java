package Group_Project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Login extends Frame implements ActionListener {
	public static ArrayList<User> s = new ArrayList<User>();

	public static boolean a;
	TextField t1, t2;
	Label l1, l2, l3, l4, l5, l6;
	Button b1, b2, b3, b4, b5;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1, f2;

	public Login() {
		User b = new User("b", "b", "b", "b", "b", "b", "b", "b", "b", true, "b", "b");
		s.add(b);
		User a = new User("a", "a", "a", "a", "a", "a", "a", "a", "a", false, "a", "b");
		s.add(a);

		setBackground(Color.cyan);
		f1 = new Font("TimesRoman", Font.BOLD, 40);
		f2 = new Font("TimesRoman", Font.BOLD, 40);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		setLayout(gbl);
		l1 = new Label("Username", Label.CENTER);
		l1.setFont(f1);
		l2 = new Label("Password", Label.CENTER);
		l2.setFont(f1);

		t1 = new TextField(15);
		t2 = new TextField(15);
		t2.setEchoChar('*');

		b1 = new Button("Password Recovery");
		b1.setFont(f2);
		b3 = new Button("Submit");
		b3.setFont(f2);
		b4 = new Button(" Close ");
		b4.setFont(f2);
		b5 = new Button("Register");
		b5.setFont(f2);


		gbc.gridx = 0;
		gbc.gridy = 0;
		gbl.setConstraints(l1, gbc);
		add(l1);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbl.setConstraints(t1, gbc);
		add(t1);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbl.setConstraints(l2, gbc);
		add(l2);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(t2, gbc);
		add(t2);

		gbc.gridx = 2;
		gbc.gridy = 6;
		gbl.setConstraints(b3, gbc);
		add(b3);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbl.setConstraints(b1, gbc);
		add(b1);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbl.setConstraints(b4, gbc);
		add(b4);

		gbc.gridx = 2;
		gbc.gridy = 10;
		gbl.setConstraints(b5, gbc);
		add(b5);

		b5.addActionListener(this);
		b1.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public static int SearchUser(String a) {
		for (int i = 0; i < s.size(); i++)
			if (a.equals(s.get(i).UserName))
				return i;
		return -1;
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			Password p = new Password();
			p.setSize(1000, 600);
			p.setVisible(true);
			p.setTitle("Password Recovery");
		}

		if (ae.getSource() == b5) {
			Register r = new Register();
			r.setSize(1000, 600);
			r.setVisible(true);
			r.setTitle("Create User Screen");

		}

		if (ae.getSource() == b4) {
			setVisible(false);
			dispose();
		}
		if (ae.getSource() == b3) {
			if (SearchUser(t1.getText()) >= 0 && t2.getText().equals(s.get(SearchUser(t1.getText())).Password)) {
				if (s.get(SearchUser(t1.getText())).admin) {
					a = true;
					MainMenu m = new MainMenu();
					setVisible(false);
					m.setSize(600, 400);
					m.setVisible(true);
					m.setTitle("Main Menu");
					m.setBackground(Color.cyan);

				}

				else {
					a = false;
					MainMenu m = new MainMenu();
					setVisible(false);
					m.setSize(400, 400);
					m.setVisible(true);
					m.setTitle("Main Menu");
					m.setBackground(Color.cyan);
				}
			} else {

				Message mg = new Message(this, "The user name or password is incorrect ");
				mg.setLocation(200, 200);
				mg.setVisible(true);
			}
		}

	}
	public static void main(String args[]) {

		Login L = new Login();

		L.setSize(900, 600);
		L.setVisible(true);
		L.setTitle("Login Screen");
	}

}
