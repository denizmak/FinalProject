/*
 * Deni Zmak
 * SE 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/25/14 - Edited by Brandon Antosh on 11/22/14 (Bio's option)
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**DisplayGUI class creates a frame and displays a JTextField within the frame that consists schedule or
 * roaster data. It reads the data from a file and write it into the JTextField which is later on displayed in
 * the frame additional to the main frame. If the log in feature recognize the user as admin, the text is
 * editable. Once the admin makes the changes and clicks the save button, the edited version of the text
 * is directly saved to the original database file. This way, when the user reads the file again, the updated
 * file is displayed.
 * @author Deni
 */
public class DisplayGUI extends JFrame implements ActionListener
{
	//data fields
	private JButton close = new JButton ("Close");
	private JButton save = new JButton ("Save");
	private JPanel buttons = new JPanel();
	static JPanel bioPanel = new JPanel();
	private JTextArea text;
	private JScrollPane scroll;
	String path = null;
	
	
	// no-argument constructor
	public DisplayGUI ()
	{
	}
	
	/** Constructor with String argument. It reads the text from the file in the database, writes the text
	 * to the JTextField and displays the JTextField within the frame. Also, the constructor sets the frame
	 * properties such as size, location, etc.
	 * @param path - name of the JMenuItem which is associated with the file to read from
	 */
	public DisplayGUI (String path)
	{ 
		this.path = path;
		String line = "";
		StringBuilder readText = new StringBuilder();
		
		//--------------------------------------------------------------------------------------------------------------
		//updated by B.A.
		bioPanel.setLayout(new BoxLayout(bioPanel, BoxLayout.Y_AXIS));
		
		if (path.compareTo("bio") < 4 && MenuPanel.userLevel.compareTo("admin") != 0)	
		{
			try 
			{
				Scanner fileScanner = new Scanner (new File ("data/" + path +".txt"));		
				
				while(fileScanner.hasNextLine())
				{
					line = fileScanner.nextLine(); 
					String[] seperatedInput = line.split(";");
					
					bioPanel.add(new Hyperlink(seperatedInput[1], seperatedInput[2]));
					bioPanel.add(Box.createRigidArea(new Dimension(20,0)));
				}
				
				fileScanner.close();
				
			} 
			catch (Exception e)
			{
				System.out.println ("The file does not exists!");
			}

			bioPanel.setBackground (Color.WHITE);
			
			save.setFont (new Font ("Times New Roman", Font.BOLD, 17));
			close.setFont (new Font ("Times New Roman", Font.BOLD, 17));
			
			buttons.setBackground(Color.WHITE);
			
			scroll = new JScrollPane(bioPanel);
			
			setSize (200, 555);
		}
		//-------------------------------------------------------------------------------------------------------------
		else
		{
			try 
			{
				Scanner fileScanner = new Scanner (new File ("data/" + path +".txt")); 
				
				while (fileScanner.hasNextLine())
				{ 
					line = fileScanner.nextLine(); 
					readText.append (line + "\n");
				}
			}
			catch (Exception e)
			{
				System.out.println ("The file does not exists!");
			}
	
			
			String stringToDisplay = readText.toString();
			text = new JTextArea (stringToDisplay);
	
	
			text.setBackground (Color.WHITE);
			
			save.setFont (new Font ("Times New Roman", Font.BOLD, 17));
			close.setFont (new Font ("Times New Roman", Font.BOLD, 17));
			
			buttons.setBackground(Color.WHITE);
			
			scroll = new JScrollPane(text);
		
			setSize (999, 555);

			if (MenuPanel.userLevel.compareTo("admin") == 0)	
				{
					text.setEditable (true);
					buttons.add(save);
				}
			
			else		text.setEditable (false);
		}
		
		buttons.add(close);

		setLayout (new BorderLayout());
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
		/**writeToFile method allows to admin to save the edited changes in the roster and/or schedule 
		 * files for all the sports. Method reads the text from the JTextField and writes the complete text 
		 * over the text in the database document such that when the user reads the file again, the program
		 * displays the updated file.
		 * @param text
		 */
		public void writeToFile (String text)
		{	
			// write to a file
			try 
			{
				Writer writer = new FileWriter ("data/" + path + ".txt", false);

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