import javax.swing.JFrame;

public class Frame extends JFrame {

    private AudioVideo audioPlayer;

    public Frame() {
    	audioPlayer = new AudioVideo();
    	setTitle("Java Audio Player");
        setSize(400, 200);	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
