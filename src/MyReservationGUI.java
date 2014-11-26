
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
 * GUI for myReservation using BoxLayout
 * Considered a lot of other layouts but BoxLayout turned out to be suitable because we are 
 * stacking one component to another vertically
 */

public class MyReservationGUI extends JFrame{

	//Initialize the two buttons
	JButton exit = new JButton("Exit");						
	JButton cancel = new JButton("Cancel My Reservation(s)");
	boolean update = false;
	boolean reset = false;
	JPanel header = new JPanel();
	JPanel body = new JPanel();
	JPanel button = new JPanel();
	JPanel body2 = new JPanel();
	JTextArea text;
	JTextArea text2;
	
	//myReservationGUI constructor
	public MyReservationGUI(){
		super();
		setResizable(false);			// The frame is not resizeable
	}

	/**
	 * function to add components to the BoxLayout
	 * @param pane = a container that contains BoxLayout
	 */

	public void addComponentsToPane(final Container pane){

//		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));		//Stack up components vertically
//		header.setPreferredSize(new Dimension(500,500));
		
		JLabel Reservation = new JLabel("My Reservation(s)");		//Title for myReservation file
		Reservation.setFont(new Font("Calibri", Font.BOLD, 16));
		header.add(Reservation);
		

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

//		body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));	
		String stringToDisplay = readText.toString();
		text = new JTextArea (stringToDisplay);
		text.setBackground(null);
		body.add(text);
		

		/**
		 * Adds exit and Cancel buttons and align them in BoxLayout
		 */
		cancel.setAlignmentX(LEFT_ALIGNMENT);
		exit.setAlignmentX(RIGHT_ALIGNMENT);
		button.add(cancel);
		button.add(exit);
		button.setAlignmentY(BOTTOM_ALIGNMENT);
		


		/**
		 *  Add listener for exit button 
		 *  Once clicked, the frame will be hidden, the program will still be running
		 */

		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);		
			}
		});	

		/**
		 *  Add listener for cancel button 
		 *  Once the button is clicked, the data from JComboBox is deleted except the title
		 *  Before the data are to be deleted, the program display a JOptionPane box that asks 
		 *  for confirmation from user. 
		 *  Once the user say yes, all the data from ReservationData.txt file are wiped out
		 *  When the user checks MyReservation page again next time, the data will not be there
		 *  TODO: Fix the above function. Data should be gone once the user clicks yes. Not when 
		 *  the user reruns the program
		 *  choice = to store the answer from the user for cancellation, which will then be
		 *  compared with YES_OPTION to delete the data 
		 */

		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String title =  "Number" + "\t" + "Year" +"\t" + "Month" + "\t " + "Day" + "\t" +
						"Time" + "\t" + "Field" + "\t\t" + "Field Type";

				String option = JOptionPane.showInputDialog("Please choose which reservation you want to cancel"
						        + "(i.e.input a reservation number).");
				int optint = Integer.parseInt(option);
			
				deleteData("bin/ReservationData.txt", title, optint);
				
/** The below is an attempt to rewrite the file so that the user will be able to see the updated
 *  file after cancelling the reservation(s) but it doesn't work
 */
//				update = true;
//				
//				while(update == true){
//					String line2 = "";			
//					String stringToDisplay2 = "";
//					StringBuilder readText2 = new StringBuilder();
//			
//					try{
//						File infile2 = new File("bin/ReservationData.txt");
//						Scanner fileScanner2 = new Scanner (infile2);
//			
//						while (fileScanner2.hasNextLine()){
//							line2 = fileScanner2.nextLine();
//							readText2.append(line2+"\n");
//			
//						}
//						stringToDisplay2 = readText2.toString();
//						text2 = new JTextArea (stringToDisplay2);
//						text2.setBackground(null);
//						//System.out.println(stringToDisplay2);
//						update = false;
//						fileScanner2.close();
//			
//					}
//					catch (Exception f)
//					{
//						f.printStackTrace();
//					}
//				} // while
				
			}// actionPerformed
		});// actionListener
		pane.add(header, BorderLayout.NORTH);
		pane.add(body, BorderLayout.WEST);
		pane.add(button, BorderLayout.SOUTH);

}// addComponentsToPane

	/**
	 * deleteData function which reads the data from file, disregards the title and deletes all
	 * other data
	 * The function converts the original file as a temp file to store data temporarily which
	 * will then be renamed to the original file's name(.txt) once the writing data process is
	 * complete
	 */
	public void deleteData(String file, String lineToMaintain, int option){
		int compare = 0;
		int numNew = 0;
		String numnum = null;
		String line = null;
		String rest = null;
		
		try{
			File inFile = new File(file);
			//Construct the new file that will later be renamed to the original filename. 
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));	     

	        
			//Read from the original file and write to the new 
			//unless content matches data to be removed.
			while ((line = br.readLine()) != null) {
				String patternString = ("^\\d{1}.*");   // Search for first digit of the sentence
				Pattern pattern = Pattern.compile(patternString);
		    	Matcher matcher = pattern.matcher(line);  // check to see if the line matches the pattern
		    	boolean matches = matcher.matches();
		        
		        if (matches){
		        	String[] result = line.split("\t", 2);
		            String num = result[0];
		            rest = result[1];
		            compare = Integer.parseInt(num);
		        }
		       
		       
				if (line.trim().startsWith(lineToMaintain))
					pw.println(line); 

				else if(compare != option){
					if(compare > option){
						numNew = compare - 1;
						numnum = String.valueOf(numNew);
						pw.println(numnum+ "\t"+ rest);
					}
					else
						pw.println(line);
				}
				pw.flush();
			}
			
			pw.close();
			br.close();

			//Delete the original file
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			} 
			//Rename the new file to the filename the original file had
			if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");
			  
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

		
	/**
	 *  The function that calls the layout and add it to the frame.
	 *  The Frame dimension is set by trial and error to be in the center of display.
	 *  Dimension vary from computer to computer
	 */

	public static void createAndShowGUI() {

		//Create and set up the window.
		MyReservationGUI frame = new MyReservationGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //TODO HIDE_ON_CLOSE
		frame.setSize(new Dimension(888, 555));  //TODO 888,555 to run on Deni's com
		frame.setLocationRelativeTo(null);
		//Set up the content pane.
		frame.addComponentsToPane(frame.getContentPane());
		//Display the window.
		//frame.pack();					// TODO comment
		frame.setVisible(true);
	}
	

	/**
	 *  Main function that calls GUI display which includes the frames and functions
	 * @param args
	 */
	 
	 public static void main(String[] args) {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	createAndShowGUI();
		           }
		    });
			
	 }

}//end myReservationGUI