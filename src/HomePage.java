/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author Deni
 *HomePage class creates instances of MenuPanel, ContentPanel, TitleDesign classes, and JPanel instances.
 *All instances are added to the frame in specific layout that is goint to be visible to the user (final design).  
 */
public class HomePage extends JFrame
{
	// data fields
	private MenuPanel northPanel = new MenuPanel();
	private JPanel centerPanel = new JPanel();
	private TitleDesign titlePanel = new TitleDesign();
	private JPanel content = new ContentPanel();

	/**
	 * No-argument constructor. It adds all instances created in the class to the frame using border layout
	 * in a pattern that is goint to be visible to the user later on. 
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
	}
}