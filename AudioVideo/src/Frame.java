import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private AudioVideo audioPlayer;

    public Frame() {
        setTitle("Java Audio Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        audioPlayer = new AudioVideo();

        setLayout(new BorderLayout());
        add(audioPlayer, BorderLayout.CENTER);
    }

    public void start() {
        setVisible(true);
    }
}
