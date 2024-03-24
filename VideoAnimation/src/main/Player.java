package main;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Player extends JPanel {
	private BufferedImage[] frames;
	private int currentIndex = 0;
	
	
    public Player(String[] imagePaths) {
    	frames = new BufferedImage[imagePaths.length];
    	
    	try {
			for(int i = 0; i < imagePaths.length; i++) {
				frames[i] = ImageIO.read(new File(imagePaths[i]));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public BufferedImage getCurrentFrame(){ 
    	return frames[currentIndex];
    }
    
    public void updateAnimation() {
    	currentIndex = (currentIndex + 1) % frames.length;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        BufferedImage currentFrame = getCurrentFrame();
        
        int x = (getWidth() - currentFrame.getWidth()) / 2;
        int y = (getHeight() - currentFrame.getHeight()) / 2;
        
        g.drawImage(currentFrame, x, y, currentFrame.getWidth() * 4, currentFrame.getHeight() * 4, this);

    }
}