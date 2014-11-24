/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @author Deni
 *HomePage class creates instances of MenuPanel, ContentPanel, TitleDesign classes, and JPanel instances.
 *All instances are added to the frame in specific layout that is going to be visible to the user (final design).  
 */
public class HomePage extends JFrame implements ActionListener, KeyListener
{
	// data fields
	private MenuPanel northPanel = new MenuPanel("student");
	private JPanel centerPanel = new JPanel();
	private TitleDesign titlePanel = new TitleDesign();
	private JPanel content = new ContentPanel();
	private JFrame frame = new JFrame ("Log In");
	private LogIn user = new LogIn();

	/**
	 * No-argument constructor. It adds all instances created in the class to the frame using border layout
	 * in a pattern that is going to be visible to the user later on. 
	 */
	public HomePage()
	{
		setLayout(new BorderLayout());

		northPanel.setPreferredSize (new Dimension (950, 33));
		centerPanel.setPreferredSize (new Dimension (950, 630-33));

		centerPanel.setLayout (new BorderLayout());
		centerPanel.setBackground (Color.WHITE);
		centerPanel.add(titlePanel, BorderLayout.NORTH);
		centerPanel.add(content, BorderLayout.CENTER);

		// add component to the main frame
		getContentPane().add (northPanel, BorderLayout.NORTH);
		getContentPane().add (centerPanel, BorderLayout.CENTER);

		//set properties of the frame
		setSize (950, 630);
		setLocationRelativeTo (null);
		setResizable (false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle ("ERAU Eagles Fun Club Application");

		//register listener with log in button
		northPanel.logInButton.addActionListener(this);
		northPanel.logOutButton.addActionListener(this);
	}

	// handle events by overriding actionPerformed method
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == northPanel.logInButton)
		{
			frame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
			frame.setSize(new Dimension (333, 222));
			frame.setLocationRelativeTo(null);
			frame.add (user);
			frame.setVisible (true);
			user.login.addActionListener(this);
			user.username.addKeyListener(this);
			user.password.addKeyListener(this);
		}

		if (e.getSource() == user.login)
		{
			verification();
		}

		else if (e.getSource() == northPanel.logOutButton)
		{
			getContentPane().remove(northPanel);
			northPanel = new MenuPanel("");
			getContentPane().add(northPanel, BorderLayout.NORTH);
			northPanel.logInButton.addActionListener (this);
			revalidate();
		}
	}

	public void verification()
	{
		String password = "";
		char[] letters = user.password.getPassword();
		for (int i = 0; i < letters.length; i++) password += letters[i];


		if (user.username.getText().compareTo("zmakd@my.erau.edu") == 0 
				&& password.compareTo("zmakd") == 0)
		{
			frame.setVisible (false);
			getContentPane().remove(northPanel);
			northPanel = new MenuPanel("student");
			getContentPane().add(northPanel, BorderLayout.NORTH);
			revalidate();
			northPanel.logOutButton.addActionListener (this);
		}

		else if (user.username.getText().compareTo("jafers@erau.edu") == 0 
				&& password.compareTo("jafers") == 0)
		{
			frame.setVisible (false);
			getContentPane().remove(northPanel);
			northPanel = new MenuPanel("admin");
			getContentPane().add(northPanel, BorderLayout.NORTH);
			revalidate();
			northPanel.logOutButton.addActionListener (this);
		}


		else if (user.username.getText().compareTo("almuhanf@my.erau.edu") == 0 
				&& password.compareTo("almuhanf") == 0)
		{
			frame.setVisible (false);
			getContentPane().remove(northPanel);
			northPanel = new MenuPanel("student");
			getContentPane().add(northPanel, BorderLayout.NORTH);
			revalidate();
			northPanel.logOutButton.addActionListener (this);
		}

		else if (user.username.getText().compareTo("antoshb@my.erau.edu") == 0 
				&& password.compareTo("antoshb") == 0)
		{
			frame.setVisible (false);
			getContentPane().remove(northPanel);
			northPanel = new MenuPanel("student");
			getContentPane().add(northPanel, BorderLayout.NORTH);
			revalidate();
			northPanel.logOutButton.addActionListener (this);
		}


		else if (user.username.getText().compareTo("khinep@my.erau.edu") == 0 
				&& password.compareTo("khinep") == 0)
		{
			frame.setVisible (false);
			getContentPane().remove(northPanel);
			northPanel = new MenuPanel("student");
			getContentPane().add(northPanel, BorderLayout.NORTH);
			revalidate();
			northPanel.logOutButton.addActionListener (this);
		}


		else if (user.username.getText().compareTo("mcknighs3@my.erau.edu") == 0 
				&& password.compareTo("mcknighs3") == 0)
		{
			frame.setVisible (false);
			getContentPane().remove(northPanel);
			northPanel = new MenuPanel("student");
			getContentPane().add(northPanel, BorderLayout.NORTH);
			revalidate();
			northPanel.logOutButton.addActionListener (this);
		}

		else
		{
			JTextField message = new JTextField ("Incorrect username or password!");
			message.setBackground(Color.YELLOW);
			message.setOpaque(true);
			message.setForeground(Color.BLUE);
			JOptionPane.showMessageDialog (frame, message, "Warning!", JOptionPane.WARNING_MESSAGE);
		}
	}

	@Override
	public void keyTyped(KeyEvent k) 
	{
	}

	@Override
	public void keyPressed(KeyEvent y) 
	{
		if (y.getKeyCode() == KeyEvent.VK_ENTER) verification();
	}

	@Override
	public void keyReleased(KeyEvent i) 
	{
	}
}