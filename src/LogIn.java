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


public class LogIn extends JPanel implements ActionListener
{	
	protected JButton log = new JButton ("Login");
	protected JTextField usrName = new JTextField ("User Name");
	protected JPasswordField passWrd= new JPasswordField ("Password");
	protected JPanel accessLogIn = new JPanel();
	protected EagleImage eagle = new EagleImage();
	//private DatabaseManager db = new DatabaseManager("bin/Users.txt");
	private String userLevel = "student";


	public LogIn()
	{
		setLayout(new BorderLayout());

		add(accessLogIn, BorderLayout.NORTH);
		add(eagle, BorderLayout.CENTER);

		accessLogIn.add(usrName);
		accessLogIn.add(passWrd);
		accessLogIn.add(log);

		accessLogIn.setBackground(Color.white);

		//set buttons color
		log.setBackground(Color.white);
		log.setForeground(Color.BLUE);
		log.setContentAreaFilled(false);
		log.setOpaque(true);

		// Register listener with the buttons
		log.addActionListener (this);
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == log)
		{
			/*
			if (usrName.getText().compareTo("zmakd") == 0) //&& passWrd.getText().compareTo("zmakd") == 0)
			{
				userLevel = "student";
				HomePage home = new HomePage();
				home.refreshMenu("student");
			}
			 */
			System.out.println ("The user level is: " + this.userLevel);
		}	
	}

	/**
	 * @return userLevel
	 */
	public String getUserLevel()
	{
		return userLevel;
	}
	
	public void setUserLevel(String userLevel)
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