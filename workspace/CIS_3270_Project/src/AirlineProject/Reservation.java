package AirlineProject;
// Declaring imports
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Reservation extends JFrame implements ActionListener {
	
	MenuBar mbar;
	Menu m;
	MenuItem m1_1;
	
	FlowLayout fL = new FlowLayout(FlowLayout.CENTER, 50, 10);
	JButton checkAButton, createPButton, checkBookingButton;
	JLabel l1, l2, l3, title;
	JTextField t1, t2;
	Font font, titleFont;
	
        // Reservation method
	Reservation() {
		mbar = new MenuBar();
		setMenuBar(mbar);
		m = new Menu("MainMenu");
		mbar.add(m);
		m1_1 = new MenuItem("GoBack to MainMenu");
		m.add(m1_1);
		
		font = new Font("Gadugi", Font.BOLD, 18);
		titleFont = new Font("Gadugi", Font.BOLD, 30);
		fL = new FlowLayout(FlowLayout.CENTER, 250, 10);
		setLayout(fL);
		
		checkAButton = new JButton(" Check Availability ");
		createPButton = new JButton(" Create Passenger ");
		checkBookingButton = new JButton(" Check Booking ");
		
		title = new JLabel("Reservations");
		title.setFont(titleFont);
		add(title);

		l1 = new JLabel("");
		l2 = new JLabel("");

		
		add(checkAButton);
		add(createPButton);
		add(checkBookingButton);

		add(l1);
		add(l2);

		checkAButton.addActionListener(this);
		createPButton.addActionListener(this);
		checkBookingButton.addActionListener(this);
		addWindowListener(new W());
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == m1_1) {
			MainMenu m = new MainMenu();
			m.setBackground(Color.red);
			m.setTitle("Main Menu");
			m.setSize(400, 400);
			m.setVisible(true);

		}
		if (ae.getSource() == checkAButton) {

			CheckAvailability m = new CheckAvailability();

			m.setSize(800, 400);
			m.setVisible(true);
			m.setTitle(" Check Availability Screen ");
		}
		if (ae.getSource() == createPButton) {

			CreatePassenger v = new CreatePassenger();

			v.setSize(400, 500);
			v.setVisible(true);
			v.setTitle(" Create Passenger Screen ");
		}

		if (ae.getSource() == checkBookingButton) {
			if (Login.s.get(CreatePassenger.SearchFname(CreatePassenger.b)).book.length() > 2) {
			MessageBox mb = new MessageBox(this, Login.s.get(CreatePassenger.SearchFname(CreatePassenger.b)).book + " Confirmed");
			mb.setLocation(200, 200);
			mb.setVisible(true);
			}
			else {
				MessageBox mb = new MessageBox(this, "No Booking");
				mb.setLocation(200, 200);
				mb.setVisible(true);
			}

		}

	}

	class W extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}
	
	public static void main(String[] args) {
		
	    Reservation frame = new Reservation();
	    frame.setTitle("Reservation");
	    frame.setSize(300, 400);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	  }
	}


