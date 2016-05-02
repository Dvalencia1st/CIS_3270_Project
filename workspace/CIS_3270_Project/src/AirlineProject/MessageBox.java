package AirlineProject;

import java.awt.*;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class MessageBox extends Dialog implements ActionListener {
	FlowLayout fL = new FlowLayout(FlowLayout.CENTER, 250, 10);
	JButton button1;
	JLabel labelName;
	Font font, font1;

	MessageBox(Frame fm, String a) {
		super(fm, true);
		setLayout(fL);
		font = new Font("Times Roman", Font.BOLD, 20);
		font1 = new Font("Times Roman", Font.BOLD, 40);
		
		labelName = new JLabel(a, Label.CENTER);
		labelName.setFont(font);
		button1 = new JButton("  OK  ");
		button1.setFont(font1);
		
		
		add(button1);
		
		setSize(550, 200);
		setTitle("Message Box");
		button1.addActionListener(this);
		addWindowListener(new WA());
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == button1) {
			setVisible(false);
			dispose();

		}
	}

	class WA extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}
} 



