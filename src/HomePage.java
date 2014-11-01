/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class HomePage extends JFrame
{
	// class variables (data fields)
	private MenuPanel northPanel = new MenuPanel();
	private JPanel centerPanel = new JPanel();
	private TitleDesign titlePanel = new TitleDesign();
	private JPanel content = new ContentPanel();

	// no-argument constructor
	public HomePage()
	{
		setLayout(new BorderLayout());

		northPanel.setPreferredSize (new Dimension (getXframe(), 33));
		centerPanel.setPreferredSize (new Dimension (getXframe(), getYframe()-33));
		
		centerPanel.setLayout (new BorderLayout());
		centerPanel.setBackground (Color.WHITE);
		centerPanel.add(titlePanel, BorderLayout.NORTH);
		centerPanel.add(content, BorderLayout.CENTER);

		// add component to the main frame
		getContentPane().add (northPanel, BorderLayout.NORTH);
		getContentPane().add (centerPanel, BorderLayout.CENTER);
	}
	

	//determine frame size
	//---------------------------------------------------------------------------------------------------------------------------
	protected static int getXframe()
	{
		int xFrame = 950; //(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.75);
		return xFrame;
	}

	protected static int getYframe()
	{
		int yFrame = 630; //(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.75);
		return yFrame;
	}
	//----------------------------------------------------------------------------------------------------------------------------
}