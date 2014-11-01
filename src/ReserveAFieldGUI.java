 /**
 * @author kay
 * @version 1.0
 * @created 16-Oct-2014 6:31:26 PM
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

public class ReserveAFieldGUI extends JFrame{
		
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean LEFT_TO_RIGHT = false;
	
	public ReserveAFieldGUI(){
		super();
		setResizable(false);
	}

	public void addComponentsToPane(final Container pane){
		if(LEFT_TO_RIGHT){
			pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		if(shouldFill){
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		String[] yearString = {"2014", "2015", "2016"};
		String[] monthString = {"January", "February", "March", "April", "May", "June", "July", 
				                "August", "September", "October", "November", "December"};
		String[] dayString = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14",
			"15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		
		String[] hourString = {"08", "09","10","11","12","13","14","15","16","17","18","19","20","21","22"};
		
		String[] minuteString = {"00","15","30","45"};
		
		String[] fieldString = {"Soccer Field", "Multi-purpose Field", "Tennis Court", "Softball Court"};
		
		String[] typeString = {"Full Field", "Half Field"};
	
		JLabel date = new JLabel("Choose the date for your reservation:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(50,50,0,0);
		//c.ipadx = 5;
		pane.add(date,c);
		
		final JComboBox yearList = new JComboBox(yearString);
		yearList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1.0;
		pane.add(yearList, c);
		
		
		final JComboBox monthList = new JComboBox(monthString);
		monthList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1.0;
		pane.add(monthList, c);
		
		final JComboBox dayList = new JComboBox(dayString);
		dayList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		c.weightx = 1.0;
		pane.add(dayList, c);
		
		JLabel time = new JLabel("Choose the time for your reservation:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.insets = new Insets(60,50,0,0);
		c.gridx = 0;
		c.gridy = 1;
		pane.add(time,c);
		
		final JComboBox hourList = new JComboBox(hourString);
		hourList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1.0;
		pane.add(hourList, c);
		
		final JComboBox minuteList = new JComboBox(minuteString);
		minuteList.setSelectedIndex(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 1.0;
		pane.add(minuteList, c);
		
		JLabel chooseField = new JLabel("Choose the field you wish to reserve:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(chooseField,c);
		
		final JComboBox fieldList = new JComboBox(fieldString);
		fieldList.setSelectedIndex(0);
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1.0;
		pane.add(fieldList, c);
		
		JLabel typeField = new JLabel("Choose full field or half field:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(typeField,c);
		
		final JComboBox typeList = new JComboBox(typeString);
		typeList.setSelectedIndex(0);
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 1.0;
		pane.add(typeList, c);
		
		JButton approve = new JButton("Approve");
		//approve.setPreferredSize(new Dimension(2,2));
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx =  1;
		c.gridy = 4;
		pane.add(approve, c);
		
		JButton submit = new JButton("Submit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 4;
		pane.add(submit, c);
		
	    JButton exit = new JButton("Exit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 4;
		pane.add(exit, c);
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object year = yearList.getSelectedItem();
				Object month = monthList.getSelectedItem();
				Object day = dayList.getSelectedItem();
				Object hour = hourList.getSelectedItem();
				Object minute = minuteList.getSelectedItem();
				Object field = fieldList.getSelectedItem();
				Object type = typeList.getSelectedItem();
				String content = year +"," + month + "," + day + "," + hour + ":" + minute + ","
						+ field + "," + type + ".";
				
				try {
					saveData(content);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);;
			}
		});
			
		
	}

	public static void saveData(String content) throws Exception{
		File file = new File("/Data.reserveField.txt");
		
		// if file doesn't exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		
		try{
			BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file, true));
			PrintWriter out	= new PrintWriter(bufWriter, true);
			out.println(content);
			out.close();
			
		}catch (IOException e){
			System.err.println(e);
		}
	
	
	}
	
	public static void createAndShowGUI(){
		
		ReserveAFieldGUI frame = new ReserveAFieldGUI();
		frame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
		frame.setSize(new Dimension (888, 555));
		frame.setLocationRelativeTo(null);
		
		frame.addComponentsToPane(frame.getContentPane());
		
		frame.setVisible(true);
		
	}
}//endReserveAFieldGUI