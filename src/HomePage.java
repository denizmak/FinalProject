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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	private MenuPanel northPanel = new MenuPanel ("user");
	private JPanel centerPanel = new JPanel();
	private TitleDesign titlePanel = new TitleDesign();
	private JPanel content = new ContentPanel();
	private LogIn login = new LogIn();
	private DLList list = new DLList();


	/**
	 * No-argument constructor. It adds all instances created in the class to the frame using border layout
	 * in a pattern that is going to be visible to the user later on. 
	 */
	public HomePage()
	{
		parseInputFile("data/Users.txt");

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
			
			login.setVisible (true);
			login.login.addActionListener(this);
			login.username.addKeyListener(this);
			login.password.addKeyListener(this);
		}

		if (e.getSource() == login.login)
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

		User user = list.getUser(login.username.getText());
		String password = "";
		char[] letters = login.password.getPassword();
		for (int i = 0; i < letters.length; i++) password += letters[i];

		if (user != null)
		{
			//if (login.username.getText().compareTo("zmakd@my.erau.edu") == 0 && password.compareTo("zmakd") == 0)
			if (user.getUsername().compareTo(login.username.getText()) == 0 
					&& user.getPassword().compareTo(password) == 0)
			{
				login.setVisible (false);
				getContentPane().remove(northPanel);
				northPanel = new MenuPanel(user.getUserLevel());
				getContentPane().add(northPanel, BorderLayout.NORTH);
				revalidate();
				northPanel.logOutButton.addActionListener (this);
				login.username.setText("Username");
				login.password.setText("Password");
			}

			else
			{
				JTextField message = new JTextField ("Incorrect username or password!");
				message.setBackground(Color.YELLOW);
				message.setOpaque(true);
				message.setForeground(Color.BLUE);
				JOptionPane.showMessageDialog (login, message, "Warning!", JOptionPane.WARNING_MESSAGE);
			}
		}

		else
		{
			JTextField message = new JTextField ("Incorrect username or password!");
			message.setBackground(Color.YELLOW);
			message.setOpaque(true);
			message.setForeground(Color.BLUE);
			JOptionPane.showMessageDialog (login, message, "Warning!", JOptionPane.WARNING_MESSAGE);
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

	private void parseInputFile (String file)
	{
		//Create a file input stream
		User user;
		String instr;

		try 
		{
			//Create input reader
			BufferedReader in = new BufferedReader(new FileReader(file));
			while (in.ready())
			{
				instr = in.readLine();

				//Try to parse the user using the appropriate movie constructor.  If it fails, an exception is caught
				try
				{
					user = new User(instr);
					list.addUser(user);
				} 

				catch (InvalidUserException e) 
				{
					System.out.println("Invalid user string " + instr + " in file " + file);
				}
			}	
		}

		catch (IOException io) 
		{
			System.err.println("Error in Parsing file.");
			io.printStackTrace();	
		}
	}

}