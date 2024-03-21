package main;

import javax.swing.JFrame;

public class Frame extends JFrame {

	Shape s;
	
	public Frame() {
		s = new Shape();
		this.add(s);
		this.setSize(700,700);
		this.setVisible(true);
	}

}
