package app;
/*
 * Deni Zmak
 * SE 300 - Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14 => Edited by Brandon Antosh on 11/21/14
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * @author Deni
 *SportsMenu class creates a JMenuBar instance and populates it with JBars and JMenuItems
	 * required by the application in the specific order. Also, it registers the listeners with JMenuItems
	 * and it is handling the events by overriding actionPerformed method and setting specific task(s)
	 * for each JMenuItem.
 */
public class SportsMenu extends JMenuBar implements ActionListener
{
	// data fields
	private JMenu sportsMenu = new JMenu ("Sports");
	private JMenu baseball = new JMenu ("Baseball");
	private JMenu softball = new JMenu ("Softball");
	private JMenu mensBasketball = new JMenu ("Men's Basketball");
	private JMenu womensBasketball = new JMenu ("Women's Basketball");
	private JMenu mensCrossCountry = new JMenu ("Men's Cross Country");
	private JMenu womensCrossCountry = new JMenu ("Women's Cross Country");
	private JMenu mensGolf = new JMenu ("Men's Golf");
	private JMenu womensGolf = new JMenu ("Women's Golf");
	private JMenu mensSoccer = new JMenu ("Men's Soccer");
	private JMenu womensSoccer = new JMenu ("Women's Soccer");
	private JMenu mensTennis = new JMenu ("Men's Tennis");
	private JMenu womensTennis = new JMenu ("Women's Tennis");
	private JMenu mensTrackField = new JMenu ("Men's Track & Field");
	private JMenu womensTrackField = new JMenu ("Women's Track & Field");
	private JMenu volleyball = new JMenu ("Volleyball");

	protected JMenuItem scheduleB = new JMenuItem ("Schedule");
	private JMenuItem scheduleS = new JMenuItem ("Schedule");
	private JMenuItem scheduleMB = new JMenuItem ("Schedule");
	private JMenuItem scheduleWB = new JMenuItem ("Schedule");
	private JMenuItem scheduleMCC = new JMenuItem ("Schedule");
	private JMenuItem scheduleWCC = new JMenuItem ("Schedule");
	private JMenuItem scheduleMG = new JMenuItem ("Schedule");
	private JMenuItem scheduleWG = new JMenuItem ("Schedule");
	private JMenuItem scheduleMS = new JMenuItem ("Schedule");
	private JMenuItem scheduleWS = new JMenuItem ("Schedule");
	private JMenuItem scheduleMT = new JMenuItem ("Schedule");
	private JMenuItem scheduleWT = new JMenuItem ("Schedule");
	private JMenuItem scheduleMTF = new JMenuItem ("Schedule");
	private JMenuItem scheduleWTF = new JMenuItem ("Schedule");
	private JMenuItem scheduleV = new JMenuItem ("Schedule");

	protected JMenuItem rosterB = new JMenuItem ("Roster");
	private JMenuItem rosterS = new JMenuItem ("Roster");
	private JMenuItem rosterMB = new JMenuItem ("Roster");
	private JMenuItem rosterWB = new JMenuItem ("Roster");
	private JMenuItem rosterMCC = new JMenuItem ("Roster");
	private JMenuItem rosterWCC = new JMenuItem ("Roster");
	private JMenuItem rosterMG = new JMenuItem ("Roster");
	private JMenuItem rosterWG = new JMenuItem ("Roster");
	private JMenuItem rosterMS = new JMenuItem ("Roster");
	private JMenuItem rosterWS = new JMenuItem ("Roster");
	private JMenuItem rosterMT = new JMenuItem ("Roster");
	private JMenuItem rosterWT = new JMenuItem ("Roster");
	private JMenuItem rosterMTF = new JMenuItem ("Roster");
	private JMenuItem rosterWTF = new JMenuItem ("Roster");
	private JMenuItem rosterV = new JMenuItem ("Roster");
	
	//B.A. update
	protected JMenuItem bioB = new JMenuItem ("Bio's");
	private JMenuItem bioS = new JMenuItem ("Bio's");
	private JMenuItem bioMB = new JMenuItem ("Bio's");
	private JMenuItem bioWB = new JMenuItem ("Bio's");
	private JMenuItem bioMCC = new JMenuItem ("Bio's");
	private JMenuItem bioWCC = new JMenuItem ("Bio's");
	private JMenuItem bioMG = new JMenuItem ("Bio's");
	private JMenuItem bioWG = new JMenuItem ("Bio's");
	private JMenuItem bioMS = new JMenuItem ("Bio's");
	private JMenuItem bioWS = new JMenuItem ("Bio's");
	private JMenuItem bioMT = new JMenuItem ("Bio's");
	private JMenuItem bioWT = new JMenuItem ("Bio's");
	private JMenuItem bioMTF = new JMenuItem ("Bio's");
	private JMenuItem bioWTF = new JMenuItem ("Bio's");
	private JMenuItem bioV = new JMenuItem ("Bio's");

	
	/**
	 * No-argument constructor. Creates a JMenuBar instance and populates it with JBars and JMenuItems
	 * required by the application.
	 */
	public SportsMenu()
	{

		sportsMenu.setToolTipText ("Click here to see all ERAU sports available");
		
		// add components to the panel and personalize
		baseball.add(scheduleB);
		baseball.add(rosterB);
		baseball.add(bioB);
		baseball.setFont (new Font ("Times New Roman", 17, 17));

		softball.add(scheduleS);
		softball.add(rosterS);
		softball.add(bioS);
		softball.setFont (new Font ("Times New Roman", 17, 17));

		mensBasketball.add(scheduleMB);
		mensBasketball.add(rosterMB);
		mensBasketball.add(bioMB);
		mensBasketball.setFont (new Font ("Times New Roman", 17, 17));

		womensBasketball.add(scheduleWB);
		womensBasketball.add(rosterWB);
		womensBasketball.add(bioWB);
		womensBasketball.setFont (new Font ("Times New Roman", 17, 17));

		mensCrossCountry.add(scheduleMCC);
		mensCrossCountry.add(rosterMCC);
		mensCrossCountry.add(bioMCC);
		mensCrossCountry.setFont (new Font ("Times New Roman", 17, 17));

		womensCrossCountry.add(scheduleWCC);
		womensCrossCountry.add(rosterWCC);
		womensCrossCountry.add(bioWCC);
		womensCrossCountry.setFont (new Font ("Times New Roman", 17, 17));

		mensGolf.add(scheduleMG);
		mensGolf.add(rosterMG);
		mensGolf.add(bioMG);
		mensGolf.setFont (new Font ("Times New Roman", 17, 17));

		womensGolf.add(scheduleWG);
		womensGolf.add(rosterWG);
		womensGolf.add(bioWG);
		womensGolf.setFont (new Font ("Times New Roman", 17, 17));

		mensSoccer.add(scheduleMS);
		mensSoccer.add(rosterMS);
		mensSoccer.add(bioMS);
		mensSoccer.setFont (new Font ("Times New Roman", 17, 17));

		womensSoccer.add(scheduleWS);
		womensSoccer.add(rosterWS);
		womensSoccer.add(bioWS);
		womensSoccer.setFont (new Font ("Times New Roman", 17, 17));

		mensTennis.add(scheduleMT);
		mensTennis.add(rosterMT);
		mensTennis.add(bioMT);
		mensTennis.setFont (new Font ("Times New Roman", 17, 17));

		womensTennis.add(scheduleWT);
		womensTennis.add(rosterWT);
		womensTennis.add(bioWT);
		womensTennis.setFont (new Font ("Times New Roman", 17, 17));

		mensTrackField.add(scheduleMTF);
		mensTrackField.add(rosterMTF);
		mensTrackField.add(bioMTF);
		mensTrackField.setFont (new Font ("Times New Roman", 17, 17));

		womensTrackField.add(scheduleWTF);
		womensTrackField.add(rosterWTF);
		womensTrackField.add(bioWTF);
		womensTrackField.setFont (new Font ("Times New Roman", 17, 17));

		volleyball.add(scheduleV);
		volleyball.add(rosterV);
		volleyball.add(bioV);
		volleyball.setFont (new Font ("Times New Roman", 17, 17));

		sportsMenu.add(baseball);
		sportsMenu.add(softball);
		sportsMenu.add(mensBasketball);
		sportsMenu.add(womensBasketball);
		sportsMenu.add(mensCrossCountry);
		sportsMenu.add(womensCrossCountry);
		sportsMenu.add(mensGolf);
		sportsMenu.add(womensGolf);
		sportsMenu.add(mensSoccer);
		sportsMenu.add(womensSoccer);
		sportsMenu.add(mensTennis);
		sportsMenu.add(womensTennis);
		sportsMenu.add(mensTrackField);
		sportsMenu.add(womensTrackField);
		sportsMenu.add(volleyball);
		sportsMenu.setFont (new Font ("Times New Roman", Font.ITALIC + Font.BOLD, 22));

		add (sportsMenu);

		// Register listener with the buttons (JMenuItems)
		scheduleB.addActionListener (this);
		scheduleS.addActionListener (this);
		scheduleMB.addActionListener (this);
		scheduleWB.addActionListener (this);
		scheduleMCC.addActionListener (this);
		scheduleWCC.addActionListener (this);
		scheduleMG.addActionListener (this);
		scheduleWG.addActionListener (this);
		scheduleMS.addActionListener (this);
		scheduleWS.addActionListener (this);
		scheduleMT.addActionListener (this);
		scheduleWT.addActionListener (this);
		scheduleMTF.addActionListener (this);
		scheduleWTF.addActionListener (this);
		scheduleV.addActionListener (this);
		
		rosterB.addActionListener (this);
		rosterS.addActionListener (this);
		rosterMB.addActionListener (this);
		rosterWB.addActionListener (this);
		rosterMCC.addActionListener (this);
		rosterWCC.addActionListener (this);
		rosterMG.addActionListener (this);
		rosterWG.addActionListener (this);
		rosterMS.addActionListener (this);
		rosterWS.addActionListener (this);
		rosterMT.addActionListener (this);
		rosterWT.addActionListener (this);
		rosterMTF.addActionListener (this);
		rosterWTF.addActionListener (this);
		rosterV.addActionListener (this);
		
		//B.A. update
		bioB.addActionListener (this);
		bioS.addActionListener (this);
		bioMB.addActionListener (this);
		bioWB.addActionListener (this);
		bioMCC.addActionListener (this);
		bioWCC.addActionListener (this);
		bioMG.addActionListener (this);
		bioWG.addActionListener (this);
		bioMS.addActionListener (this);
		bioWS.addActionListener (this);
		bioMT.addActionListener (this);
		bioWT.addActionListener (this);
		bioMTF.addActionListener (this);
		bioWTF.addActionListener (this);
		bioV.addActionListener (this);
	}
	
	// handle events by overriding actionPerformed method and setting specific task for each JMenuItem
		public void actionPerformed (ActionEvent e)
		{
			if (e.getSource() == scheduleB)
			{
				DisplayGUI frame = new DisplayGUI("scheduleB");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == scheduleS)
			{
				DisplayGUI frame = new DisplayGUI("scheduleS");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == scheduleMB)
			{
				DisplayGUI frame = new DisplayGUI("scheduleMB");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == scheduleWB)
			{
				DisplayGUI frame = new DisplayGUI("scheduleWB");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == scheduleMCC)
			{
				DisplayGUI frame = new DisplayGUI("scheduleMCC");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == scheduleWCC)
			{
				DisplayGUI frame = new DisplayGUI("scheduleWCC");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == scheduleMG)
			{
				DisplayGUI frame = new DisplayGUI("scheduleMG");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == scheduleWG)
			{
				DisplayGUI frame = new DisplayGUI("scheduleWG");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == scheduleMS)
			{
				DisplayGUI frame = new DisplayGUI("scheduleMS");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == scheduleWS)
			{
				DisplayGUI frame = new DisplayGUI("scheduleWS");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == scheduleMT)
			{
				DisplayGUI frame = new DisplayGUI("scheduleMT");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == scheduleWT)
			{
				DisplayGUI frame = new DisplayGUI("scheduleWT");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == scheduleMTF)
			{
				DisplayGUI frame = new DisplayGUI("scheduleMTF");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == scheduleWTF)
			{
				DisplayGUI frame = new DisplayGUI("scheduleWTF");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			else if (e.getSource() == scheduleV)
			{
				DisplayGUI frame = new DisplayGUI("scheduleV");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == rosterB)
			{
				DisplayGUI frame = new DisplayGUI("rosterB");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == rosterS)
			{
				DisplayGUI frame = new DisplayGUI("rosterS");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == rosterMB)
			{
				DisplayGUI frame = new DisplayGUI("rosterMB");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == rosterWB)
			{
				DisplayGUI frame = new DisplayGUI("rosterWB");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == rosterMCC)
			{
				DisplayGUI frame = new DisplayGUI("rosterMCC");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == rosterWCC)
			{
				DisplayGUI frame = new DisplayGUI("rosterWCC");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == rosterMG)
			{
				DisplayGUI frame = new DisplayGUI("rosterMG");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == rosterWG)
			{
				DisplayGUI frame = new DisplayGUI("rosterWG");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == rosterMS)
			{
				DisplayGUI frame = new DisplayGUI("rosterMS");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == rosterWS)
			{
				DisplayGUI frame = new DisplayGUI("rosterWS");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == rosterMT)
			{
				DisplayGUI frame = new DisplayGUI("rosterMT");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == rosterWT)
			{
				DisplayGUI frame = new DisplayGUI("rosterWT");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			if (e.getSource() == rosterMTF)
			{
				DisplayGUI frame = new DisplayGUI("rosterMTF");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}

			else if (e.getSource() == rosterWTF)
			{
				DisplayGUI frame = new DisplayGUI("rosterWTF");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			else if (e.getSource() == rosterV)
			{
				DisplayGUI frame = new DisplayGUI("rosterV");
				frame.setVisible (true);
				frame.setAlwaysOnTop(true);
			}
			
			//B.A. update
			if (e.getSource() == bioB)
			{
				DisplayGUI frame = new DisplayGUI("bioB");
				frame.setVisible (true);
			}

			else if (e.getSource() == bioS)
			{
				DisplayGUI frame = new DisplayGUI("bioS");
				frame.setVisible (true);
			}
			
			if (e.getSource() == bioMB)
			{
				DisplayGUI frame = new DisplayGUI("bioMB");
				frame.setVisible (true);
			}

			else if (e.getSource() == bioWB)
			{
				DisplayGUI frame = new DisplayGUI("bioWB");
				frame.setVisible (true);
			}
			
			if (e.getSource() == bioMCC)
			{
				DisplayGUI frame = new DisplayGUI("bioMCC");
				frame.setVisible (true);
			}

			else if (e.getSource() == bioWCC)
			{
				DisplayGUI frame = new DisplayGUI("bioWCC");
				frame.setVisible (true);
			}
			
			if (e.getSource() == bioMG)
			{
				DisplayGUI frame = new DisplayGUI("bioMG");
				frame.setVisible (true);
			}

			else if (e.getSource() == bioWG)
			{
				DisplayGUI frame = new DisplayGUI("bioWG");
				frame.setVisible (true);
			}
			
			if (e.getSource() == bioMS)
			{
				DisplayGUI frame = new DisplayGUI("bioMS");
				frame.setVisible (true);
			}

			else if (e.getSource() == bioWS)
			{
				DisplayGUI frame = new DisplayGUI("bioWS");
				frame.setVisible (true);
			}
			
			if (e.getSource() == bioMT)
			{
				DisplayGUI frame = new DisplayGUI("bioMT");
				frame.setVisible (true);
			}

			else if (e.getSource() == bioWT)
			{
				DisplayGUI frame = new DisplayGUI("bioWT");
				frame.setVisible (true);
			}
			
			if (e.getSource() == bioMTF)
			{
				DisplayGUI frame = new DisplayGUI("bioMTF");
				frame.setVisible (true);
			}

			else if (e.getSource() == bioWTF)
			{
				DisplayGUI frame = new DisplayGUI("bioWTF");
				frame.setVisible (true);
			}
			
			else if (e.getSource() == bioV)
			{
				DisplayGUI frame = new DisplayGUI("bioV");
				frame.setVisible (true);
			}
		}
}