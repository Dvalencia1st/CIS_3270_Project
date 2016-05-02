package Group_Project;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password extends Frame implements ActionListener {
	TextField t1, t2, t3, t4;
	Label l1, l2, l3, l4, l5, l6;
	Button b1, b2, b3, b4, b5;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1, f2;

	public Password() {

		setBackground(Color.red);
		f1 = new Font("TimesRoman", Font.BOLD, 20);
		f2 = new Font("TimesRoman", Font.BOLD, 15);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		setLayout(gbl);
		l1 = new Label("Input your Username", Label.CENTER);
		l1.setFont(f1);
		l2 = new Label("Your security questions is", Label.CENTER);
		l2.setFont(f1);
		l3 = new Label("Your answer is");
		l3.setFont(f1);
		l4 = new Label("Your Password is ");
		l4.setFont(f1);
		t1 = new TextField(20);
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);

		b3 = new Button("Submit");
		b3.setFont(f2);
		b4 = new Button("Close");
		b4.setFont(f2);
		b5 = new Button("Get password");
		b5.setFont(f2);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbl.setConstraints(l1, gbc);
		add(l1);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbl.setConstraints(t1, gbc);
		add(t1);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(b3, gbc);
		add(b3);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbl.setConstraints(l2, gbc);
		add(l2);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbl.setConstraints(t2, gbc);
		add(t2);

		gbc.gridx = 2;
		gbc.gridy = 8;
		gbl.setConstraints(b5, gbc);
		add(b5);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbl.setConstraints(l3, gbc);
		add(l3);

		gbc.gridx = 2;
		gbc.gridy = 6;
		gbl.setConstraints(t3, gbc);
		add(t3);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbl.setConstraints(l4, gbc);
		add(l4);

		gbc.gridx = 2;
		gbc.gridy = 10;
		gbl.setConstraints(t4, gbc);
		add(t4);

		gbc.gridx = 2;
		gbc.gridy = 12;
		gbl.setConstraints(b4, gbc);
		add(b4);

		b5.addActionListener(this);

		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public int SearchUser(String a) {
		for (int i = 0; i < Login.s.size(); i++)
			if (a.equalsIgnoreCase(Login.s.get(i).UserName))
				return i;
		return -1;
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b5) {
			if (Login.s.get(SearchUser(t1.getText())).Answer.equals(t3.getText()))

				t4.setText(Login.s.get(SearchUser(t1.getText())).Password);

			else {
				Message mg = new Message(this, "Incorrect Answer");
				mg.setLocation(200, 200);
				mg.setVisible(true);

			}
		}

		if (ae.getSource() == b4) {
			setVisible(false);
			dispose();
		}
		if (ae.getSource() == b3) {
			if (SearchUser(t1.getText()) > 0) {
				t2.setText(Login.s.get(SearchUser(t1.getText())).Questions);

			} else {
				Message mg = new Message(this, "Incorrect User name");
				mg.setLocation(200, 200);
				mg.setVisible(true);
			}
		}

	}

}
