/**
 * Deni Zmak
 * SE 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author Deni
 * This class creates a JPanel which displays application title and ERAU logos on each side of the title. 
 */
public class TitleDesign extends JPanel
{
	//data fields
	private JLabel title = new JLabel ("ERAU Eagles Fan App", JLabel.CENTER);
	private Image logo;

	/**
	 * No-argument constructor. It creates a JPanel with specific size, and components in it (such as
	 * JLabel and Image item(s)).
	 */
	public TitleDesign()
	{
		setLayout (new BorderLayout());
		setPreferredSize(new Dimension (getWidth(), 99));
		setBackground (Color.WHITE);

		title.setFont (new Font ("Times New Roman", Font.ITALIC + Font.BOLD, 27));

		add(title);
	}


	//Paint the images by overriding paintComponent method
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		try
		{
			logo = ImageIO.read (new File ("data/logo.gif"));
		}
		catch (Exception e) 
		{
			System.err.println("Error! No image found!");
			e.printStackTrace();	
		}

		g.drawImage (logo, 144, 20, 133, 66, this);
		g.drawImage (logo, 688, 20, 133, 66, this);
	}
}