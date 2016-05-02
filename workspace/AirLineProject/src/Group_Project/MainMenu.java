package Group_Project;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;

public class MainMenu extends Frame implements ActionListener {
	MenuBar mbar;
	public static boolean ad;
	Menu m, m1, m2, m3, m4;
	MenuItem m1_1, m1_2, m2_1, m2_2, m2_3, m3_1, m3_2,  m4_1, m4_2;
	
	Register r;
	Login li;
	Label l1;
	Button b1, b2;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1;

	public MainMenu() {
		setBackground(Color.cyan);
		f1 = new Font("TimesRoman", Font.BOLD, 20);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		setLayout(new FlowLayout());	
		
		li = new Login();		
		b1 = new Button("Login");
		add(b1);
		r = new Register();
		b2 = new Button("Register");
		add(b2);
		
		l1 = new Label("For further options, please use the menu bar");
		add(l1);		
		l1.setFont(f1);
		
		mbar = new MenuBar();
		setMenuBar(mbar);
		m1 = new Menu("Bookings");
		mbar.add(m1);
		m1_1 = new MenuItem("Reservation");
		m1.add(m1_1);
		m1_2 = new MenuItem("Cancel");
		m1.add(m1_2);
		
		m2 = new Menu("Reports");
		mbar.add(m2);
		m2_1 = new MenuItem("Confirmed Passengers");
		m2.add(m2_1);
		m2_2 = new MenuItem("Pending");
		m2.add(m2_2);
		m2_3 = new MenuItem("Report");
		m2.add(m2_3);
		if (Login.a) {
			m4 = new Menu("Admin");
			mbar.add(m4);
			m4_1 = new MenuItem("Add flight to data");
			m4.add(m4_1);
			m4_2 = new MenuItem("Remove flight from data");
			m4.add(m4_2);

		}
		m3 = new Menu("Close");
		mbar.add(m3);
		m3_2 = new MenuItem("Log out");
		m3.add(m3_2);
		m3_1 = new MenuItem("Close");
		m3.add(m3_1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		m1_1.addActionListener(this);
		m1_2.addActionListener(this);
		m2_1.addActionListener(this);
		m2_2.addActionListener(this);
		m2_3.addActionListener(this);
		m3_1.addActionListener(this);
		m3_2.addActionListener(this);
		addWindowListener(new M());
	}


	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == m1_1) {
			Reservation r = new Reservation();
			r.setSize(800, 400);
			r.setVisible(true);
			r.setTitle("Reservation Screen");

		}
		if (ae.getSource() == m1_2) {
			Login.s.get(Create.SearchFname(Create.b)).book = "";
			Message mg = new Message(this, "Cancellation complete");
			mg.setLocation(200, 200);
			mg.setVisible(true);

		}

		if (ae.getSource() == m2_2) {
			Message in = new Message(this, "Incorrect");
			in.setSize(800, 400);
			in.setVisible(true);
			in.setTitle("Pending List");

		}
		if (ae.getSource() == m3_1) {
			System.exit(0);

		}
		if (ae.getSource() == b1) {
			Login L = new Login();
			L.setSize(900, 600);
			L.setVisible(true);
			L.setTitle("Login Page");

		}
		if (ae.getSource() == b2) {
			Register r = new Register();
			r.setSize(1000, 1000);
			r.setVisible(true);
			r.setTitle("User Screen");
		}
	}

	

	public static void main(String args[]) {
		MainMenu m = new MainMenu();
		m.setBackground(Color.white);		
		m.setSize(600, 600);
		m.setVisible(true);
		m.setTitle("Main Menu");

	}

	class M extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}

}
