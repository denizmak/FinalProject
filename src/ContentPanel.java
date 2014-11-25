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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 * @author Deni
 *ContentPanel class creates JPanle with displayed campus map that occupies majority of the panel area.
 *Besides the map, panel also provides JMenuItems on the bottom of the panel, which are, when pressed,
 *repainting the map and highlighting the field(s) associated with the menu item. JMenuItem are also 
 *registered with listeners in this class and event for each JMenuItem is handled separately by repainting 
 *the image. The map is drawn in the JPanel by overriding  paintComponent method.
 */
public class ContentPanel extends JPanel implements ActionListener
{
	//data fields
	private JPanel mapOption = new JPanel();
	
	private Image map;
	private String image = "map.jpg";

	private JMenuItem baseball = new JMenuItem ("Baseball");
	private JMenuItem softball = new JMenuItem ("Softball");
	private JMenuItem basketball = new JMenuItem ("Basketball");
	private JMenuItem tennis = new JMenuItem ("Tennis");
	private JMenuItem soccer = new JMenuItem ("Soccer");
	private JMenuItem volleyball = new JMenuItem ("Volleyball");
	private JMenuItem trackField = new JMenuItem ("Track & Field");
	private JMenuItem intramural = new JMenuItem ("Intramural");
	private JButton exitButton = new JButton ("Exit");

	//private MenuPanel menu = new MenuPanel();


	/**
	 * No-argument constructor. It creates JPanel that consist a campus map along with JMenuItems, which
	 * when pressed, repaint the map area drawing the map associated with the JMenuItem selected. 
	 * Within the constructor each JMenuItem is registered with listener. 
	 */
	public ContentPanel()
	{
		setLayout (new BorderLayout());
		setBackground (Color.WHITE);

		mapOption.setPreferredSize (new Dimension (getWidth(), 25));
		mapOption.setLayout (new FlowLayout (FlowLayout.LEFT, 0,0));
		mapOption.setBackground (Color.WHITE);


		exitButton.setFont (new Font ("Times New Roman", Font.BOLD, 15));

		mapOption.add(baseball);
		mapOption.add(softball);
		mapOption.add(basketball);
		mapOption.add(soccer);
		mapOption.add(tennis);
		mapOption.add(trackField);
		mapOption.add(volleyball);
		mapOption.add(intramural);

		mapOption.add(exitButton);

		add (mapOption, BorderLayout.SOUTH);


		// Register listener with the buttons
		baseball.addActionListener (this);
		softball.addActionListener (this);
		basketball.addActionListener (this);
		soccer.addActionListener (this);
		tennis.addActionListener (this);
		trackField.addActionListener (this);
		volleyball.addActionListener (this);
		intramural.addActionListener(this);
		exitButton.addActionListener (this);
	}


	// Paint the images by overriding paintComponent method
	protected void paintComponent(Graphics g)
	{
		try
		{
			map = ImageIO.read (ResourceLoader.load (image));
		}
		catch (Exception e) 
		{
			System.err.println("Error! No image found!");
			e.printStackTrace();	
		}
		super.paintComponent(g);

		g.drawImage (map, 147, 2, 666, 444, this);
	}


	// handle events by overriding actionPerformed method
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == exitButton)
		{
			System.exit (1);
		}

		/*
		else if (e.getSource() == menu.subscription)
		{
		}
		*/

		else if (e.getSource() == baseball)
		{
			if (image.compareTo("baseball.png") == 0)
			{
				image = "map.jpg";
				repaint();
			}

			else
			{
				image = "baseball.png";
				repaint();
			}
		}

		else if (e.getSource() == softball)
		{
			if (image.compareTo("softball.png") == 0)
			{
				image = "map.jpg";
				repaint();
			}

			else
			{
				image = "softball.png";
				repaint();
			}
		}

		else if (e.getSource() == basketball)
		{
			if (image.compareTo("basketball.png") == 0)
			{
				image = "map.jpg";
				repaint();
			}

			else
			{
				image = "basketball.png";
				repaint();
			}
		}

		else if (e.getSource() == soccer)
		{
			if (image.compareTo("soccer.png") == 0)
			{
				image = "map.jpg";
				repaint();
			}

			else
			{
				image = "soccer.png";
				repaint();
			}
		}

		else if (e.getSource() == tennis)
		{
			if (image.compareTo("tennis.png") == 0)
			{
				image = "map.jpg";
				repaint();
			}

			else
			{
				image = "tennis.png";
				repaint();
			}
		}

		else if (e.getSource() == trackField)
		{
			if (image.compareTo("trackField.png") == 0)
			{
				image = "map.jpg";
				repaint();
			}

			else
			{
				image = "trackField.png";
				repaint();
			}
		}

		else if (e.getSource() == volleyball)
		{
			if (image.compareTo("basketball.png") == 0)
			{
				image = "map.jpg";
				repaint();
			}

			else
			{
				image = "basketball.png";
				repaint();
			}
		}

		else if (e.getSource() == intramural)
		{
			if (image.compareTo("intramural.png") == 0)
			{
				image = "map.jpg";
				repaint();
			}

			else
			{
				image = "intramural.png";
				repaint();
			}
		}
	}
}