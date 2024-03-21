import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;

public class Graphics extends JPanel {

	public Graphics() {
		this.setBackground(Color.BLACK);
	}
	
	@Override
	protected void paintComponent(java.awt.Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		
		g2d.setFont(getFont());
		g2d.dispose();
	}
}
