import javax.swing.JFrame;

public class Frame extends JFrame {

	Circle c;
	
	public Frame() {
		c = new Circle();
		this.add(c);
		this.setSize(700,700);
		this.setVisible(true);
		this.setTitle("Test");
	}

}
