package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Shape extends JPanel {

	public Shape() {
		this.setBackground(Color.blue);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D d = (Graphics2D) g.create();
		
		Font f = new Font("Arial", Font.BOLD, 30);
		d.setFont(f);
		
		d.setColor(Color.red);
		d.drawString("asjdas", 500, 500);
		
		d.fillOval(100, 100, 30, 30);
		
		d.setColor(Color.black);
		d.fillRect(200, 200, 40, 40);
		d.drawRect(300, 300, 40, 40);
		
		d.dispose();
	}

}
