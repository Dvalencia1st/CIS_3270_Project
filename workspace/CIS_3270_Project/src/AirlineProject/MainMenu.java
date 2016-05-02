package AirlineProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class MainMenu extends JFrame implements ActionListener {
	MenuBar mbar;
	public static boolean admin;
	Menu m1, m2, m3, m4;
	MenuItem m1_1, m1_2, m2_1, m2_2, m2_3, m3_1, m3_2, m4_1, m4_2;

	public MainMenu() {

		mbar = new MenuBar();
		setMenuBar(mbar);
		m1 = new Menu("Booking");
		mbar.add(m1);
		m1_1 = new MenuItem("Reservation");
		m1.add(m1_1);
		m1_2 = new MenuItem("Cancellation");
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
			Login.s.get(CreatePassenger.SearchFname(CreatePassenger.b)).book = "";
			MessageBox mb = new MessageBox(this, "Cancellation complete");
			mb.setLocation(200, 200);
			mb.setVisible(true);

		}

		if (ae.getSource() == m2_2) {
			MessageBox wr = new MessageBox(this, "Incorrect");
			wr.setSize(800, 400);
			wr.setVisible(true);
			wr.setTitle("Pending List");

		}
		if (ae.getSource() == m3_1) {
			System.exit(0);

		}
		if (ae.getSource() == m3_2) {
			dispose();
			Login L = new Login();

			L.setSize(900, 600);
			L.setVisible(true);
			L.setTitle("Login Page");

		}

	}

	public static void main(String args[]) {
		
		MainMenu m = new MainMenu();
		m.setBackground(Color.red);
		m.setTitle("Main Menu");
		m.setSize(400, 400);
		m.setVisible(true);

	}

	class M extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}

}

