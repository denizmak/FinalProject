 /**
 * @author Kay
 * @version 1.0
 * @created 16-Oct-2014 6:31:26 PM
 * @last_edited 12-Nov-2014 10:38:34 AM
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.StandardOpenOption;

/**
 *  GUI class for reserve a field using GridBagLayout
 *  Considered a lot of other types of layout but GridBagLayout turned 
 *  out to be the most suitable one because we needed to add multiple components to the pane
 */

public class ReserveAFieldGUI extends JFrame{
		
	final static boolean shouldFill = true; 
	int classification = 0;					//Temp. int. to determine between students and admin (student = 0, admin = 1)
	
	// Create RerserveAField constructor
	public ReserveAFieldGUI(){
		super();
		setResizable(false);				//The ReserveAField GUI frame is not resizable
	}
	
/**
 * function to add components to the GridBagLayout
 * @param pane = a container that contains GridBagLayout
 */
	public void addComponentsToPane(final Container pane){
		// Set up GridbagLayout for the GUI
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();  //Set up constraints for the layout(Used for placing components in the GridBag)
		
		if(shouldFill){
			c.fill = GridBagConstraints.HORIZONTAL;       //Resize the component horizontally to fill up the grid
		}
		
		//Initializing variables for JComboBox
		String[] yearString = {"2014", "2015", "2016"};
		String[] monthString = {"January", "February", "March", "April", "May", "June", "July", 
				                "August", "September", "October", "November", "December"};
		String[] dayString = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14",
			"15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		
		String[] hourString = {"08", "09","10","11","12","13","14","15","16","17","18","19","20","21","22"};
		
		String[] minuteString = {"00","15","30","45"};
		
		String[] fieldString = {"Soccer Field", "MultiPurpose", "Tennis Court", "Softball Court"};
		
		String[] typeString = {"Full Field", "Half Field"};
	
		//Set up title for Reserve A Field GUI page
		JLabel title = new JLabel("ERAU Reserve A Field");
		title.setFont(new Font("Calibri", Font.BOLD, 20));  //Make the tile bold and create slightly larger font than body text
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;									//Specify how to distribute each horizontal space
		c.gridx = 1;										//The placement of component in horizontal direction((0,0) starting from the left corner)
		c.gridy = 0;										//The placement of component in vertical direction(0 being the first row)
		c.insets = new Insets(50,50,0,0);					//Specify the spacings between each row and column
		pane.add(title,c);									//Add JLabel to the pane 
		
		//JLabels to ask for user input
		//Add JLabels, JButtons and JComboBox to the pane
		JLabel date = new JLabel("Choose the date for your reservation:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(date,c);
		
		final JComboBox yearList = new JComboBox(yearString);
		yearList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1.0;
		pane.add(yearList, c);
		
		
		final JComboBox monthList = new JComboBox(monthString);
		monthList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 1.0;
		pane.add(monthList, c);
		
		final JComboBox dayList = new JComboBox(dayString);
		dayList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 1.0;
		pane.add(dayList, c);
		
		JLabel time = new JLabel("Choose the time for your reservation:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.insets = new Insets(60,50,0,0);
		c.gridx = 0;
		c.gridy = 2;
		pane.add(time,c);
		
		final JComboBox hourList = new JComboBox(hourString);
		hourList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1.0;
		pane.add(hourList, c);
		
		final JComboBox minuteList = new JComboBox(minuteString);
		minuteList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 1.0;
		pane.add(minuteList, c);
		
		JLabel chooseField = new JLabel("Choose the field you wish to reserve:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(chooseField,c);
		
		final JComboBox fieldList = new JComboBox(fieldString);
		fieldList.setSelectedIndex(0);
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 1.0;
		pane.add(fieldList, c);
		
		JLabel typeField = new JLabel("Choose full field or half field:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(typeField,c);
		
		final JComboBox typeList = new JComboBox(typeString);
		typeList.setSelectedIndex(0);
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 1.0;
		pane.add(typeList, c);
		
		if(classification == 1){						// Approve Button can only be seen by admin
			JButton approve = new JButton("Approve");
			c.weightx = 0.5;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx =  0;
			c.gridy = 5;
			c.gridwidth = 1;
			pane.add(approve, c);
		}
		
		// Create Button for Submit
		final JButton submit = new JButton("Submit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		pane.add(submit, c);
		
		// Create Button for exit
	    final JButton exit = new JButton("Exit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 5;
		pane.add(exit, c);
		
	/**
	 *  Add listener for submit button 
	 *  Once the button is clicked, the data from JComboBox is gathered and written in string(table) format
	 *  Then data are written to the txt file and saved
	 */
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object year = yearList.getSelectedItem();
				Object month = monthList.getSelectedItem();
				Object day = dayList.getSelectedItem();
				Object hour = hourList.getSelectedItem();
				Object minute = minuteList.getSelectedItem();
				Object field = fieldList.getSelectedItem();
				Object type = typeList.getSelectedItem();
				String content =  year +"\t" + month + "\t " + day + "\t" +
						          hour + ":" + minute + "\t" + field + "\t\t" + type;
				
				int reserve = JOptionPane.showConfirmDialog(null, "Do you want to reserve another field?",
						"Another Reservation?", JOptionPane.YES_NO_CANCEL_OPTION);
				//if (reserve == JOptionPane.YES_OPTION)
				
				try {
					saveData(content);				//saveData function for writing content to .txt file
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
	/**
	 *  Listener for exit button
	 *  Once clicked, the frame will be hidden, the program will still be running
	 */
		 
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);			
			}
		});
			
		
	}

	/**
	 * Writing string to the file. Create a new file if not created yet. Then add a default tile 
	 * for the file in table format
	 * @param content = string of data saved from JComboBoxes 
	 * @throws Exception
	 */
	public static void saveData(String content) throws Exception{
		File file = new File("bin/ReservationData.txt");  // The directory for the file
		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
			// Default title for the file
			String title =  "Year" +"\t" + "Month" + "\t " + "Day" + "\t" +
			          "Time" + "\t" + "Field" + "\t\t" + "Field Type";
			BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file, true));
			PrintWriter out	= new PrintWriter(bufWriter, true);
			out.println(title);
			out.close();						//Always close the file
		}
		
		// Write reservation data this time to the table
		try{
		BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file, true));
		PrintWriter out	= new PrintWriter(bufWriter, true);
		out.println(content);
		out.close();
		
		}catch (IOException e){
			System.err.println(e);
		}
	
	
	
	}
	
	/**
	 *  The function that calls the layout and add it to the frome.
	 *  The Frame dimension is set by trial and error to be in the center of display.
	 *  Dimension vary from computer to computer
	 */
	public static void createAndShowGUI(){
		
		ReserveAFieldGUI frame = new ReserveAFieldGUI();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	//So that it can run in the background
		frame.setPreferredSize(new Dimension(888, 555));
		frame.setLocationRelativeTo(null);
		frame.addComponentsToPane(frame.getContentPane());
		
		frame.pack(); 				//Automatically resize JFrame
		frame.setVisible(true);
		
	}

	// TODO JOptionPane for submit button (ask for another reservation, yes and no)
	// TODO JOptionPane for exit (Confirmation)
	
	
}//endReserveAFieldGUI