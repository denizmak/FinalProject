import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EagleImageA extends JPanel{
	public EagleImageA() 
	{
		setBackground(Color.WHITE);
	}  

	//private ImageIcon imageIcon = new ImageIcon("bin/eagle.jpg");
	//private Image image = imageIcon.getImage();

	Image image = null;
	
	@Override /** Draw image on the panel */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			image = ImageIO.read (ResourceLoader.load ("logo.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(image, 0,0, getWidth(), getHeight(), this);
	}
}