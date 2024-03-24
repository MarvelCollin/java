import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AudioVideo {
	private static final String VIDEO_PATH = "lol.mp4";	
	private static final int FPS = 24; 
    private static final int FRAME_COUNT = 120; 
	
    public AudioVideo() {
    	 JFrame videoFrame = new JFrame("Video Playback");
         videoFrame.setSize(640, 480);
         videoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         JLabel videoLabel = new JLabel();
         videoFrame.add(videoLabel);

         videoFrame.setVisible(true);

         for (int i = 0; i < FRAME_COUNT; i++) {
             try {
                 String imagePath = VIDEO_PATH + File.separator + "frame_" + i + ".jpg";
                 ImageIcon imageIcon = new ImageIcon(imagePath);
                 Image image = imageIcon.getImage().getScaledInstance(640, 480, Image.SCALE_DEFAULT);
                 videoLabel.setIcon(new ImageIcon(image));
                 videoFrame.repaint();

                 Thread.sleep(1000 / FPS); 
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    	
    }
    

}