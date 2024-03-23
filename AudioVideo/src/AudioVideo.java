import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class AudioVideo extends JPanel implements ActionListener {

    private JButton playButton, stopButton;
    private Clip audioClip;

    public AudioVideo() {
        playButton = new JButton("Play");
        stopButton = new JButton("Stop");

        playButton.addActionListener(this);
        stopButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playButton);
        buttonPanel.add(stopButton);

        add(buttonPanel);
        
        File file = new File("hi.wav");
        
        try {
        	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        	audioClip = AudioSystem.getClip();
        	audioClip.open(audioStream);
		} catch (Exception e) {
			
		}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	   if (e.getSource() == playButton) {
               try {
                   audioClip.start();

                   playButton.setEnabled(false);
                   
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           } else if(e.getSource() == stopButton) {
        	   audioClip.stop();
        	   playButton.setEnabled(true);
           }
    }

}