import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Circle extends JPanel implements ActionListener {

    private int x, y, width, height;
    private double angle, scaleX, scaleY;
    private Timer timer;

    public Circle() {
        x = 100; 
        y = 200;


        angle = scaleX = scaleY = 0;
        
        timer = new Timer(15, this);
        timer.start();

        width = 40;
        height = 60;
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D d = (Graphics2D) g.create();
        
        d.translate(getWidth() / 2, getHeight() / 2);
        
        int centerX = -(width / 2);
        int centerY = -(height / 2);
        
        d.rotate(angle);
        d.scale(scaleX, scaleY);
        d.setColor(Color.red);
        d.fillOval(centerX, centerY, width, height);

        d.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        angle += Math.toRadians(8);
    	
        scaleX += 0.1;
        scaleY += 0.1;
    	
        repaint(); 
    }

}