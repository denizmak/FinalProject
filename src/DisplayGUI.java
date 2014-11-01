/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DisplayGUI extends JFrame implements ActionListener
{
	//data fields
	private JButton close = new JButton ("Close");
	private JButton save = new JButton ("Save");
	private JPanel buttons = new JPanel();
	private JTextArea text;
	private String s;
	private ListenA user = new ListenA();
	private JScrollPane scroll;
	
	String path = null;
	
	// no-argument constructor
	public DisplayGUI ()
	{
		
	}
	
	//constructor with String argument
	public DisplayGUI (String s)
	{ 
		this.s = s;
		String line = "";
		StringBuilder readText = new StringBuilder();

		try 
		{
			//Scanner fileScanner = new Scanner (new File ("src/" + s +".txt"));
			Scanner fileScanner = new Scanner (ResourceLoader.load ("" + s +".txt"));
			path = ResourceLoader.getPath();
			
			while (fileScanner.hasNextLine())
			{ 
				line = fileScanner.nextLine(); 
				readText.append (line + "\n");
			}
		}
		catch (Exception e)
		{
			System.out.println("The file does not exists!");
		}

		
		String stringToDisplay = readText.toString();
		text = new JTextArea (stringToDisplay);


		text.setBackground (Color.WHITE);
		
		save.setFont (new Font ("Times New Roman", Font.BOLD, 17));
		close.setFont (new Font ("Times New Roman", Font.BOLD, 17));
		
		buttons.setBackground(Color.WHITE);
		
		scroll = new JScrollPane(text);
		
		
		if (user.getUserLevel().compareTo("admin") == 0)	
			{
				text.setEditable (true);
				buttons.add(save);
			}
		
		else		text.setEditable (false);
		
		
		buttons.add(close);

		setLayout (new BorderLayout());
		setSize (999, 555);
		setLocationRelativeTo (null);
		setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
		setTitle ("ERAU Eagles");
		setResizable (false);
		
		add (scroll, BorderLayout.CENTER);
		add (buttons, BorderLayout.SOUTH);

		// Register listener with the buttons
		close.addActionListener (this);
		save.addActionListener (this);
	}


	// handle events by overriding actionPerformed method
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == close)
		{
			setVisible(false);
		}
		
		else if (e.getSource() == save)
		{
			writeToFile (text.getText());
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------

		public void writeToFile (String text)
		{	
			// write to a file
			try 
			{
				Writer writer = new FileWriter ("bin/" + path, false);

				writer.write (text);
				writer.flush();
				writer.close();
			} 
			catch (IOException e)
			{
				System.out.println ("Error! File does exist!");
			}  
		}
		//-----------------------------------------------------------------------------------------------------------------
}