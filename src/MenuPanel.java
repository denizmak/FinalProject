/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 * @author Deni
 *MenuPanel class creates a JPanel that consists SportsMenu instance (accessible to all users) along with
 *different JMenuItems accessible to the specific user type(s) in order to provide required application
 *functionalities. Also, JMenuItems added to the JPanel in this class are registers with listener, and events 
 *are handled by overriding actionPerformed method for each JMenuItem.
 */
public class MenuPanel extends JPanel implements ActionListener
{
	// class variables (data fields)
	private SportsMenu menu = new SportsMenu();
	JMenuItem reserveField = new JMenuItem ("Reserve A Field");
	JMenuItem myReservations = new JMenuItem ("My Reservations");
	JMenuItem reservations = new JMenuItem ("Reservations");
	JMenuItem intramural = new JMenuItem ("Intramural Sports");
	JMenuItem subscription = new JMenuItem ("Subscription");
	private JButton logInButton = new JButton ("Log In");
	private JButton logOutButton = new JButton ("Log Out");
	private ListenA user = new ListenA();
	

	/**
	 * No-argument constructor. It creates a JPanel consisting of SportsMenu instance, ListenA instance,
	 * JMenuItem instances and JButton instances. Constructor also displays the item in specific order
	 * (design) decided by the team.
	 */
	public MenuPanel()
	{
		setLayout (new FlowLayout (FlowLayout.LEFT, 7,1));
		setBackground (Color.WHITE);
		logInButton.setForeground (Color.BLUE);
		logOutButton.setForeground (Color.RED);

		add (menu);

		/* If - else statement is choosing which JMenuItems to display along with SportsMenu instance based 
		 * on what kind of user is signed in (admin, student, regular user)
		 */
		if (user.getUserLevel().compareTo("user") == 0)
		{
			add (reserveField);
			add (myReservations);
			add (intramural);
			add (subscription);
			add(Box.createHorizontalStrut(111));
			add (logOutButton);
		}

		else if (user.getUserLevel().compareTo("admin") == 0)
		{
			add (reservations);
			add (subscription);
			add(Box.createHorizontalStrut(466));
			add (logOutButton);
		}

		else 
		{
			add(Box.createHorizontalStrut(752));
			add (logInButton);
		}

		// Register listener with the buttons
		reserveField.addActionListener (this);
		myReservations.addActionListener (this);
		intramural.addActionListener (this);
		subscription.addActionListener (this);
		reservations.addActionListener (this);
		logOutButton.addActionListener (this);
		logInButton.addActionListener (this);
	}

	
	// handle events by overriding actionPerformed method
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == logOutButton)
		{
		}
		
		if (e.getSource() == logInButton)
		{
			UserLoginA login = new UserLoginA();
			JFrame frame = new JFrame ("Log In");
			frame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
			frame.setSize(new Dimension (333, 222));
			frame.setLocationRelativeTo(null);
			frame.setLayout(new BorderLayout());
			frame.add (login);
			frame.setVisible (true);
		}

		else if (e.getSource() == reserveField)
		{
			ReserveAFieldGUI frame = new ReserveAFieldGUI();
			frame.createAndShowGUI();
			
		}

		else if (e.getSource() == myReservations)
		{
			MyReservationGUI frame = new MyReservationGUI();
			frame.createAndShowGUI();
		}

		else if (e.getSource() == intramural)
		{
		}

		else if (e.getSource() == subscription)
		{
			SubscriptionPanel frame = new SubscriptionPanel();
			frame.setVisible(true);
		}

		else if (e.getSource() == reservations)
		{
		}
	}
}