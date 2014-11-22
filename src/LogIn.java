import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogIn extends JPanel
{	
	protected JButton login = new JButton ("Login");
	protected JTextField usrName = new JTextField ("User Name");
	protected JPasswordField passWrd= new JPasswordField ("Password");
	protected JPanel accessLogIn = new JPanel();
	protected EagleImage eagle = new EagleImage();
	//private DatabaseManager db = new DatabaseManager("bin/Users.txt");
	private String userLevel;


	public LogIn()
	{
		setLayout(new BorderLayout());

		add(accessLogIn, BorderLayout.NORTH);
		add(eagle, BorderLayout.CENTER);

		accessLogIn.add(usrName);
		accessLogIn.add(passWrd);
		accessLogIn.add(login);

		accessLogIn.setBackground(Color.white);

		//set buttons color
		login.setBackground(Color.white);
		login.setForeground(Color.BLUE);
		login.setContentAreaFilled(false);
		login.setOpaque(true);
	}

	
	/**
	 * @return userLevel
	 */
	public String getUserLevel()
	{
		return userLevel;
	}

	public void setUserLevel (String userLevel)
	{
		this.userLevel = userLevel;
	}
}


class EagleImage extends JPanel
{
	Image image = null;

	public EagleImage() 
	{
		setBackground(Color.WHITE);
	}  

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