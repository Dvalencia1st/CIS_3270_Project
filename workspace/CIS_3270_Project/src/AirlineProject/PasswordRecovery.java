package AirlineProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;



public class PasswordRecovery extends JFrame implements ActionListener {
	
	FlowLayout fL = new FlowLayout(FlowLayout.CENTER, 250, 10);
	JTextField txt1, txt2, txt3, txt4;
	JLabel l1, l2, l3, l4, l5, l6;
	JButton submitButton, closeButton, getPasswordButton;
	Font font;
	Choice securityQuestion = new Choice();

	public PasswordRecovery() {
		
		setLayout(fL);
		font = new Font("Gadugi", Font.BOLD, 20);
		
		l1 = new JLabel("Username:");
		l1.setFont(font);
		add(l1);
		txt1 = new JTextField(20);
		add(txt1);
		
		l2 = new JLabel("Security Question:");
		l2.setFont(font);
		add(l2);
		add(securityQuestion);
		securityQuestion.add("What's your mother maiden name ");
		securityQuestion.add("What's your first car model");
		securityQuestion.add("What's your first university");
		securityQuestion.add("What's your first car model");
		securityQuestion.add("What's your first girlfriend name");
		
		l3 = new JLabel("Answer:");
		l3.setFont(font);
		add(l3);
		txt3 = new JTextField(20);
		add(txt3);
		
		
		l4 = new JLabel("Your Password is:");
		l4.setFont(font);
		add(l4);
		txt4 = new JTextField(20);
		add(txt4);
		

		submitButton = new JButton("Submit");
		closeButton = new JButton("Close");
		getPasswordButton = new JButton("Get password");
		
		add(submitButton);
		add(closeButton);
		add(getPasswordButton);
		
		submitButton.addActionListener(this);
		closeButton.addActionListener(this);
		getPasswordButton.addActionListener(this);

	}

	public int SearchUser(String a) {
		for (int i = 0; i < Login.s.size(); i++)
			if (a.equalsIgnoreCase(Login.s.get(i).UserName))
				return i;
		return -1;
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == getPasswordButton) {
			if (Login.s.get(SearchUser(txt1.getText())).Answer.equals(txt3.getText()))

				txt4.setText(Login.s.get(SearchUser(txt1.getText())).Password);

			else {
				MessageBox mb = new MessageBox(this, "Incorrect Answer");
				mb.setLocation(200, 200);
				mb.setVisible(true);

			}
		}

		if (ae.getSource() == closeButton) {
			setVisible(false);
			dispose();
		}
		if (ae.getSource() == submitButton) {
			if (SearchUser(txt1.getText()) > 0) {
				txt2.setText(Login.s.get(SearchUser(txt1.getText())).Questions);

			} else {
				MessageBox mb = new MessageBox(this, "Incorrect Usser name");
				mb.setLocation(200, 200);
				mb.setVisible(true);
			}
		}
		
		class W extends WindowAdapter {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();

			}
		}

	}
	
	public static void main(String[] args) {
		
		PasswordRecovery frame = new PasswordRecovery();
	    frame.setTitle("PasswordRecovery");
	    frame.setSize(600, 700);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}
