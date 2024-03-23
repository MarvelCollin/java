import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Circle extends JPanel implements ActionListener {

    private int x, y, width, height, speedX, speedY;
    private Timer timer;

    public Circle() {
        x = 100; 
        y = 200;

        speedX = 5;
        speedY = 1;

        timer = new Timer(15, this);
        timer.start();

        width = height = 40;
        restitutionCoefficient = 0.9;
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.red);
        g2d.fillOval(x, y, width, height);

        g2d.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        x += speedX;

        speedY += 1;
        y += speedY;

        if (x + speedX < 0 || x + speedX + width >= getWidth()) {
            speedX *= -1;
            x += speedX * 2;
        }
        
        if (y + height >= getHeight()) {
            y = getHeight() - height; 
            speedY *= -0.9;
            
            if (Math.abs(speedY) == 0) { 
                timer.stop();
            }
        }
        
        repaint(); 
    }

}