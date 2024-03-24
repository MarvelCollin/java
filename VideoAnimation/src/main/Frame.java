package main;

import java.awt.Color;
import javax.swing.JFrame;

public class Frame extends JFrame implements Runnable {
	private Player player;
	private static final int DELAY = 100;
	
    public Frame() {
        String[] imagePaths = {"walk_right1.png", "walk_right2.png"};
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setBackground(Color.black);
        
        player = new Player(imagePaths);
        
        add(player);
        setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
        
    }


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(DELAY);
			} catch (Exception e) {
				// TODO: handle exception
			}
			player.updateAnimation();
			
			repaint();
		}
		
	}

}