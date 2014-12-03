package app;

/**
 * @author Kay
 * @version 1.0
 * @created 16-Oct-2014 6:31:26 PM
 * @last_edited 12-Nov-2014 10:38:34 AM
 */

import javax.swing.*;

import java.awt.BorderLayout;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * GUI for myReservation using BorderLayout
 * created JPanels for each section and add them to BorderLayout
 */

public class AdminReservationGUI extends JFrame{

	//Initialize the two buttons
	JButton exit = new JButton("Exit");						
	JButton approve = new JButton("Approve");
	JButton reject = new JButton("Reject");
	JPanel header = new JPanel();
	JPanel body = new JPanel();
	JPanel button = new JPanel();
	JTextArea text;
	
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
		
		pane.setBackground(Color.WHITE);
		JLabel Reservation = new JLabel("Incoming Reservation(s)");		//Title for myReservation file
		Reservation.setFont(new Font("Calibri", Font.BOLD, 16));
		header.add(Reservation);
		header.setBackground(Color.WHITE);

		/**
		 * Adds exit and Cancel buttons and align them in BoxLayout
		 */
		approve.setAlignmentX(LEFT_ALIGNMENT);
		reject.setAlignmentX(CENTER_ALIGNMENT);
		exit.setAlignmentX(RIGHT_ALIGNMENT);
		button.add(approve);
		button.add(reject);
		button.add(exit);
		button.setBackground(Color.WHITE);
		
		pane.add(header, BorderLayout.NORTH);
		pane.add(button, BorderLayout.SOUTH);
		
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
		frame.setBackground(Color.WHITE);
		//Set up the content pane.
		frame.addComponentsToPane(frame.getContentPane());
		//Display the window.
		//frame.pack();					
		frame.setVisible(true);
	}

	
}//end myReservationGUI