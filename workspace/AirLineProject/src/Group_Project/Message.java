package Group_Project;
import java.awt.*;
import java.awt.event.*;

public class Message extends Dialog implements ActionListener {
	GridBagLayout gbl;
	GridBagConstraints gbc;
	FlowLayout F;
	Button b1;
	Label l;
	Font f1, f2;

	Message(Frame fm, String a) {
		super(fm, true);
		setBackground(Color.magenta);
		f1 = new Font("Times Roman", Font.BOLD, 20);
		f2 = new Font("Times Roman", Font.BOLD, 15);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		setLayout(gbl);
		l = new Label(a, Label.CENTER);
		l.setFont(f1);
		b1 = new Button("  OK  ");
		b1.setFont(f2);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbl.setConstraints(l, gbc);
		add(l);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbl.setConstraints(b1, gbc);
		add(b1);

		setSize(550, 200);
		setTitle("Message Box");
		b1.addActionListener(this);
		addWindowListener(new Z());
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			setVisible(false);
			dispose();

		}
	}

	class Z extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();

		}
	}
}



