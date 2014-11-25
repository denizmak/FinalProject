/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


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
	private JMenuItem reserveField = new JMenuItem ("Reserve A Field");
	private JMenuItem myReservations = new JMenuItem ("My Reservations");
	private JMenuItem reservations = new JMenuItem ("Reservations");
	private JMenuItem intramural = new JMenuItem ("Intramural Sports");
	private JMenuItem subscription = new JMenuItem ("Subscription");
	protected JButton logInButton = new JButton ("Log In");
	protected JButton logOutButton = new JButton ("Log Out");
	protected static String userLevel;
	

	/**
	 * No-argument constructor. It creates a JPanel consisting of SportsMenu instance, ListenA instance,
	 * JMenuItem instances and JButton instances. Constructor also displays the item in particular order
	 * (design) specified by the team.
	 */
	public MenuPanel (String s)
	{
		userLevel = s;
		setLayout (new FlowLayout (FlowLayout.LEFT, 7,1));
		setBackground (Color.WHITE);
		logInButton.setForeground (Color.BLUE);
		logOutButton.setForeground (Color.RED);

		add (menu);

		/* If - else statement is choosing which JMenuItems to display along with SportsMenu instance based 
		 * on what kind of user is signed in (admin, student, regular user)
		 */
		if (userLevel.compareTo("student") == 0)
		{
			add (reserveField);
			add (myReservations);
			add (intramural);
			add (subscription);
			add(Box.createHorizontalStrut(111));
			add (logOutButton);
		}

		else if (userLevel.compareTo("admin") == 0)
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
	}


	// handle events by overriding actionPerformed method
	public void actionPerformed (ActionEvent e)
	{	
		if (e.getSource() == reserveField)
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
			JTextField message = new JTextField ("Coming soon!");
			message.setBackground(Color.BLUE);
			message.setOpaque(true);
			message.setForeground(Color.YELLOW);
			JOptionPane.showMessageDialog (null, message, "Info!", JOptionPane.INFORMATION_MESSAGE);
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