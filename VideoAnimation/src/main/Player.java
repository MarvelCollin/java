package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Player extends JPanel {
    private BufferedImage[] frames;
    private int currentFrameIndex = 0;

    public Player(String[] imagePaths) {
        frames = new BufferedImage[imagePaths.length];
        try {
            for (int i = 0; i < imagePaths.length; i++) {
                frames[i] = ImageIO.read(new File(imagePaths[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[currentFrameIndex];
    }

    public void updateAnimation() {
        currentFrameIndex = (currentFrameIndex + 1) % frames.length;
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