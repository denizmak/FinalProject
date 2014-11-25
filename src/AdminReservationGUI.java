
/**
 * @author Kay
 * @version 1.0
 * @created 23-Nov-2014 6:31:26 PM
 * @last_edited 24-Nov-2014 10:38:34 AM
 */

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/** 
 * GUI for AdminReservationGUI using BoxLayout
 * Considered a lot of other layouts but BoxLayout turned out to be suitable because we are 
 * stacking one component to another vertically
 */

public class AdminReservationGUI extends JFrame{

	//Initialize the two buttons
	JButton exit = new JButton("Exit");						
	JButton reject = new JButton("Reject the Reservation(s)");
	JButton approve = new JButton("Approve the Reservation(s)");

	//myReservationGUI constructor
	public AdminReservationGUI(){
		super();
		setResizable(false);			// The frame is not resizeable
	}

	/**
	 * function to add components to the BoxLayout
	 * @param pane = a container that contains BoxLayout
	 */

	public void addComponentsToPane(final Container pane){

		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));		//Stack up components vertically
		pane.setPreferredSize(new Dimension(500,500));

		JLabel Reservation = new JLabel("Incoming Reservation(s)");		//Title for myReservation file
		Reservation.setFont(new Font("Calibri", Font.BOLD, 16));
		pane.add(Reservation);

		/**
		 * Reading data from ReservationData.txt file 
		 * @Sting line = line which stores the data from reading (go to new line when one line is ended)
		 * @StringBuilder readText = the StringBuilder that combines all lines together
		 */
		String line = "";						 
		StringBuilder readText = new StringBuilder();

		try{
			Scanner fileScanner = new Scanner (new File("data/ReservationData.txt"));

			while (fileScanner.hasNextLine()){
				line = fileScanner.nextLine();
				readText.append(line+"\n");
			}
			fileScanner.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		/**
		 * Display the string built using JTextArea
		 */

		String stringToDisplay = readText.toString();
		JTextArea text = new JTextArea (stringToDisplay);

		text.setBackground(Color.WHITE);
		pane.add(text);							//Add the strings to the pane

		/**
		 * Adds exit and Cancel buttons and align them in BoxLayout
		 */
		JPanel button = new JPanel();
		reject.setAlignmentX(LEFT_ALIGNMENT);
		approve.setAlignmentX(CENTER_ALIGNMENT);
		exit.setAlignmentX(RIGHT_ALIGNMENT);
		button.add(reject);
		button.add(approve);
		button.add(exit);
		button.setAlignmentY(BOTTOM_ALIGNMENT);
		pane.add(button);


		/**
		 *  Add listener for exit button 
		 *  Once clicked, the frame will be hidden, the program will still be running
		 */

		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);		
			}
		});
	}
	
	/**
	 *  The function that calls the layout and add it to the frame.
	 *  The Frame dimension is set by trial and error to be in the center of display.
	 *  Dimension vary from computer to computer
	 */

	public static void createAndShowGUI() {

		//Create and set up the window.
		AdminReservationGUI frame = new AdminReservationGUI();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(new Dimension(888, 555));  //TODO 888,555 to run on Deni's com
		frame.setLocationRelativeTo(null);
		//Set up the content pane.
		frame.addComponentsToPane(frame.getContentPane());
		//Display the window.
		//frame.pack();					// TODO comment
		frame.setVisible(true);
	}
}//end AdminReservationGUI