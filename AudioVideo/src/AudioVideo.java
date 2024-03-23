import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.*;

public class AudioVideo extends JPanel implements ActionListener {

    private JButton playButton, stopButton;
    private JLabel statusLabel;
    private Clip audioClip;

    public AudioVideo() {
        // Create components
        playButton = new JButton("Play");
        stopButton = new JButton("Stop");
        statusLabel = new JLabel("Status: ");

        // Add action listeners
        playButton.addActionListener(this);
        stopButton.addActionListener(this);

        // Layout components
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.add(playButton);
        buttonPanel.add(stopButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("lo.wav"));
                audioClip = AudioSystem.getClip();
                audioClip.open(audioInputStream);
                audioClip.start();
                statusLabel.setText("Status: Playing audio");
            } catch (Exception ex) {
                ex.printStackTrace();
                statusLabel.setText("Status: Error playing audio");
            }
        } else if (e.getSource() == stopButton) {
            if (audioClip != null) {
                audioClip.stop();
                audioClip.setMicrosecondPosition(0);
                statusLabel.setText("Status: Audio stopped");
            }
        }
    }
}
