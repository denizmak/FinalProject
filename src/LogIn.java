/*
 * Deni Zmak
 * SE 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 11/21/14
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogIn extends JFrame
{	
	protected JButton login = new JButton ("Login");
	protected JTextField username = new JTextField ("User Name");
	protected JPasswordField password= new JPasswordField ("Password");
	protected JPanel accessLogIn = new JPanel();
	protected EagleImage eagle = new EagleImage();


	public LogIn()
	{
		setLayout(new BorderLayout());

		accessLogIn.setBackground(Color.white);

		//set buttons color
		login.setBackground(Color.white);
		login.setForeground(Color.BLUE);
		login.setContentAreaFilled(false);
		login.setOpaque(true);
		login.setToolTipText("Click to log in");
		
		
		//username.setOpaque(true);
		username.setToolTipText("Please enter your username.");
		password.setToolTipText("Please enter your password.");
		
		accessLogIn.setLayout(new GridLayout (1, 4));
		accessLogIn.add(username, BorderLayout.CENTER);
		accessLogIn.add(password, BorderLayout.CENTER);
		accessLogIn.add(login, BorderLayout.EAST);
		
		username.setHorizontalAlignment(JTextField.CENTER);
		username.setSelectedTextColor(Color.YELLOW);
		username.setSelectionColor(Color.BLUE);
		
		password.setHorizontalAlignment(JPasswordField.CENTER);
		password.setSelectedTextColor(Color.YELLOW);
		password.setSelectionColor(Color.BLUE);
		
		
		add(accessLogIn, BorderLayout.NORTH);
		add(eagle, BorderLayout.CENTER);
		
		setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
		setSize (new Dimension (444, 272));
		setLocationRelativeTo (null);
		setResizable (false);
	}
}

//--------------------------------------------------------------------------------------------------------------
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
			image = ImageIO.read (new File ("data/logo.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.drawImage(image, 0,0, getWidth(), getHeight(), this);
	}
}