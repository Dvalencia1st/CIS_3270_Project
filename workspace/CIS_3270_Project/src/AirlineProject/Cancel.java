
package AirlineProject;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cancel extends JFrame implements ActionListener {

	FlowLayout fL = new FlowLayout();
	JLabel l1, l2, l3;
	JTextField txt1;
	JButton submitButton, resetButton;
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	int count;
	Font font, titleFont;
	
	MenuBar mbar;
	Menu m;
	MenuItem m1_1;

	Cancel() {
		
		mbar = new MenuBar();
		setMenuBar(mbar);
		m = new Menu("MainMenu");
		mbar.add(m);
		m1_1 = new MenuItem("GoBack to MainMenu");
		m.add(m1_1);
		
		setBackground(Color.red);
		font = new Font("TimesRoman", Font.BOLD, 20);
		setLayout(fL);

		l1 = new JLabel("PNR No");
		l1.setFont(font);
		add(l1);
		txt1 = new JTextField(20);
		add(txt1);

		submitButton = new JButton("Submit");
		resetButton = new JButton("Reset");
		add(submitButton);
		add(resetButton);

		submitButton.addActionListener(this);
		resetButton.addActionListener(this);
		addWindowListener(new TU());
		
		m1_1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == m1_1) {
			MainMenu m = new MainMenu();
			m.setBackground(Color.red);
			m.setTitle("Main Menu");
			m.setSize(400, 400);
			m.setVisible(true);
		}

		if (ae.getSource() == resetButton) {
			txt1.setText("");
		}

		if (ae.getSource() == submitButton) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_reservation","root","salmo911");

				ps = con.prepareStatement("select Flight_number,Date,Destination from ticket_number where idTicket_number=?");
				String pnrno = txt1.getText();
				ps.setInt(1, Integer.parseInt(pnrno));
				rs = ps.executeQuery();
				rs.next();

				System.out.println(rs.getString(1) + "" + rs.getString(2) + " " + rs.getString(3));

				ps = con.prepareStatement("delete from ticket_number where Departure=?");
				ps.setInt(1, Integer.parseInt(pnrno));
				count = ps.executeUpdate();
				con.close();
				txt1.setText("");

			}

			catch (Exception e) {
				System.out.println("Error : " + e);
			}

		}

	}

	class TU extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}

	/** Main method */
	  public static void main(String[] args) {
	    Cancel frame = new Cancel();
	    frame.setTitle("Cancel");
	    frame.setSize(600, 700);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	  }
}




