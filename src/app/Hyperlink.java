package app;
/*
 * Brandon Antosh
 * SE 300 - Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 11/22/14
 */


/**
 * Creates a clickable hyperlink that opens in the default browser.
 * @author Brandon Antosh
 */
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;


public class Hyperlink extends JLabel
{
	//private JLabel link;
	/**
	 * Default constructor with parameterized data
	 * @param name - name attached to link
	 * @param url - web site that opens
	 */
	public Hyperlink(String name, final String url)
	{
		setText(name);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					Desktop.getDesktop().browse(new URI(url));
				}
				catch (URISyntaxException | IOException ex)
				{
					System.out.println("URL error");
				}
			}
		});
	}
	
	
	//----------------------------------------------------------------------------------------------------------------
	//updated by D.Z.
	/**
	 * No-argument constructor for forgotten username/password
	 */
	public Hyperlink()
	{
		setText ("Forgot username/password");
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					Desktop.getDesktop().browse (new URI ("http://myaccount.erau.edu"));
				}
				catch (URISyntaxException | IOException ex)
				{
					System.out.println("URL error");
				}
			}
		});
	}
	//----------------------------------------------------------------------------------------------------------------
 
}