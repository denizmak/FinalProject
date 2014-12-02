import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;



/**
 * @author Fares Almuhanna
 *
 *	General Idea:		Subscription is a service that helps the user of this program to receive the latest news of ERAU sport
 *	Programming Idea:	This program is designed to let the user choose what type of sport he's interested to receive email/SMS of
 */
public class SubscriptionPanel extends JFrame implements ActionListener
{	

	private JPanel mainPanel = new JPanel(); // Act as JFrame [ this panel contains everything ] <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	private JPanel centerPanel = new JPanel();
	private JPanel receiveViaColoumn = new JPanel();
	private JPanel receiveViaColoumnBody = new JPanel();
	private JPanel receiveAboutColoumn = new JPanel();
	private JPanel receiveAboutColoumnBody = new JPanel();
	private JPanel southPanel = new JPanel();

	private JPanel smsPanel = new JPanel();
	private JPanel carriersPanel = new JPanel();
	private JPanel emailPanel = new JPanel();
	private JPanel badgesPanel = new JPanel();
	
	private JPanel numberFormatPanel = new JPanel();


	private JLabel subscriptionTitle = new JLabel("SUBSCRIPTION", JLabel.CENTER);
	private JLabel reseiveNotificationBy = new JLabel("Reseive Notification By", JLabel.CENTER);
	private JLabel sms = new JLabel(" SMS  ");
	private JLabel carriers = new JLabel("Carriers");
	private JLabel email = new JLabel("EMAIL");
	private JLabel badges = new JLabel("Badges");
	private JLabel receiveNewsOf = new JLabel("Reseive News of", JLabel.CENTER);
	private JLabel numberFormat = new JLabel("Number Format: \"123456789\"");

	private JLabel menSoccer = new JLabel("Soccer  |  Men");	
	private JLabel womenSoccer = new JLabel("Soccer  |  Women");
	private JLabel menTennis = new JLabel("Tennis  |  Men");
	private JLabel womenTennis = new JLabel("Tennis  |  Women");
	private JLabel baseball = new JLabel("Baseball");
	private JLabel softball = new JLabel("Softball");
	private JLabel menBasketball = new JLabel("Basketball  |  Men");
	private JLabel womenBasketball = new JLabel("Basketball  |  Women");
	private JLabel menCrossCountry = new JLabel("Cross Country  |  Men");
	private JLabel womenCrossCountry = new JLabel("Cross Country  |  Women");
	private JLabel menGolf = new JLabel("Golf  |  Men");
	private JLabel womenGolf = new JLabel("Golf  |  Women");
	private JLabel menTrackField = new JLabel("Track & Field  | Men");
	private JLabel womenTrackField = new JLabel("Track & Field  |  Women");
	private JLabel Volleyball = new JLabel("Volleyball");

	private JButton submit = new JButton ("Submit");
	private JButton exit = new JButton ("Exit");

	private JCheckBox smsCheckBox = new JCheckBox();
	private JCheckBox emailCheckBox = new JCheckBox();
	private JCheckBox badgesCheckBox = new JCheckBox();

	private JCheckBox menSoccerCheckBox = new JCheckBox(); // SOCCER
	private JCheckBox womenSoccerCheckBox = new JCheckBox();
	private JCheckBox menTennisCheckBox = new JCheckBox(); // TENNIS
	private JCheckBox womenTennisCheckBox = new JCheckBox();
	private JCheckBox baseballCheckBox = new JCheckBox(); // Baseball
	private JCheckBox softballCheckBox = new JCheckBox(); // Softball
	private JCheckBox menBasketballCheckBox = new JCheckBox(); // BasketBall
	private JCheckBox womenBasketballCheckBox = new JCheckBox();
	private JCheckBox menCrossCountryCheckBox = new JCheckBox(); // Cross Country
	private JCheckBox womenCrossCountryCheckBox = new JCheckBox();
	private JCheckBox menGolfCheckBox = new JCheckBox(); // Golf
	private JCheckBox womenGolfCheckBox = new JCheckBox();
	private JCheckBox menTrackFieldCheckBox = new JCheckBox(); // Track
	private JCheckBox womenTrackFieldCheckBox = new JCheckBox();
	private JCheckBox VolleyballCheckBox = new JCheckBox();

	private JTextField smsTextField = new JTextField(15);
	private JTextField emailTextField = new JTextField(15);

	final ImageIcon icon = new ImageIcon("data/happyIcon.png"); 
	private String[] carriersArray = { "AT&T", "SPRINT", "T-MOBILE", "Virgin Mobile", "Verizon", "Cingular", "Nextel" };
	private JComboBox carriersList = new JComboBox(carriersArray);
	private String changedSMS;
	private String att = "@txt.att.net";
	private String verizon = "@vtext.com";
	private String tmobile = "@tmomail.net";
	private String virginMobile = "@vmobl.com";
	private String cingular = "@cingularme.com";
	private String sprint = "@messaging.sprintpcs.com";
	private String nextel = "@messaging.nextel.com";


	// ***********************************************************************************************************************

	/**
	 * Default method that contains all panels needed to organize the interface with labels and buttons
	 */
	public SubscriptionPanel ()
	{
		add(mainPanel); // add the main panel into the JFrame <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(subscriptionTitle, BorderLayout.NORTH);
		subscriptionTitle.setFont (new Font ("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		centerPanel.setLayout(new GridLayout(1,2));
		// ***********************************************************************************************************************
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Receive Notification By
		centerPanel.add(receiveViaColoumn);
		receiveViaColoumn.setLayout(new BorderLayout(0,5));

		receiveViaColoumn.add(reseiveNotificationBy, BorderLayout.NORTH);
		receiveViaColoumn.add(receiveViaColoumnBody, BorderLayout.CENTER);

		receiveViaColoumnBody.setLayout(new GridLayout(10,1));

		receiveViaColoumnBody.add(smsPanel);
		smsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		smsPanel.add(smsCheckBox);
		smsPanel.add(sms);
		smsPanel.add(smsTextField);
		//
		receiveViaColoumnBody.add(numberFormatPanel);
		numberFormatPanel.add(numberFormat);
		numberFormat.setFont (new Font ("Times New Roman", Font.BOLD, 12));
		
		receiveViaColoumnBody.add(carriersPanel);
		carriersPanel.add(carriers);
		carriersPanel.add(carriersList);
		carriersList.addActionListener(this);


		//

		receiveViaColoumnBody.add(emailPanel);
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailPanel.add(emailCheckBox);
		emailPanel.add(email);
		emailPanel.add(emailTextField);

		receiveViaColoumnBody.add(badgesPanel);
		badgesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		badgesPanel.add(badgesCheckBox);
		badgesPanel.add(badges);
		badgesCheckBox.setSelected(true);

		smsCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		emailCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		badgesCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);

		// ***********************************************************************************************************************
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Receive Notification About
		centerPanel.add(receiveAboutColoumn);

		receiveAboutColoumn.setLayout(new BorderLayout(0,5));
		receiveAboutColoumn.add(receiveNewsOf, BorderLayout.NORTH);
		receiveAboutColoumn.add(receiveAboutColoumnBody, BorderLayout.CENTER);

		receiveAboutColoumnBody.setLayout(new GridLayout(15,2, 5, 5));

		receiveAboutColoumnBody.add(baseballCheckBox);//5
		receiveAboutColoumnBody.add(baseball);

		receiveAboutColoumnBody.add(menBasketballCheckBox);//7
		receiveAboutColoumnBody.add(menBasketball);

		receiveAboutColoumnBody.add(womenBasketballCheckBox);//8
		receiveAboutColoumnBody.add(womenBasketball);

		receiveAboutColoumnBody.add(menCrossCountryCheckBox);//9
		receiveAboutColoumnBody.add(menCrossCountry);

		receiveAboutColoumnBody.add(womenCrossCountryCheckBox);//10
		receiveAboutColoumnBody.add(womenCrossCountry);

		receiveAboutColoumnBody.add(menGolfCheckBox); //11
		receiveAboutColoumnBody.add(menGolf);

		receiveAboutColoumnBody.add(womenGolfCheckBox); //12
		receiveAboutColoumnBody.add(womenGolf);

		receiveAboutColoumnBody.add(menSoccerCheckBox); //1
		receiveAboutColoumnBody.add(menSoccer);	

		receiveAboutColoumnBody.add(womenSoccerCheckBox); //2 
		receiveAboutColoumnBody.add(womenSoccer);

		receiveAboutColoumnBody.add(softballCheckBox);//6
		receiveAboutColoumnBody.add(softball);

		receiveAboutColoumnBody.add(menTennisCheckBox); //3
		receiveAboutColoumnBody.add(menTennis);

		receiveAboutColoumnBody.add(womenTennisCheckBox);//4
		receiveAboutColoumnBody.add(womenTennis);


		receiveAboutColoumnBody.add(menTrackFieldCheckBox);//13
		receiveAboutColoumnBody.add(menTrackField);

		receiveAboutColoumnBody.add(womenTrackFieldCheckBox);//14
		receiveAboutColoumnBody.add(womenTrackField);

		receiveAboutColoumnBody.add(VolleyballCheckBox);//15
		receiveAboutColoumnBody.add(Volleyball);

		VolleyballCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		womenTrackFieldCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		menTrackFieldCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		womenGolfCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		menGolfCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		womenCrossCountryCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		menCrossCountryCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		womenBasketballCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		menBasketballCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		softballCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		baseballCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		womenTennisCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		menTennisCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		womenSoccerCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
		menSoccerCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);


		mainPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		southPanel.add(submit);
		southPanel.add(exit);
		exit.addActionListener(this);
		submit.addActionListener(this);


		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< SETTING PANELS BACKGROUND TO WHITE
		mainPanel.setBackground(Color.WHITE);
		centerPanel.setBackground(Color.WHITE);
		receiveViaColoumn.setBackground(Color.WHITE);
		receiveViaColoumnBody.setBackground(Color.WHITE);
		receiveAboutColoumn.setBackground(Color.WHITE);
		receiveAboutColoumnBody.setBackground(Color.WHITE);
		smsPanel.setBackground(Color.WHITE);
		emailPanel.setBackground(Color.WHITE);
		badgesPanel.setBackground(Color.WHITE);
		southPanel.setBackground(Color.WHITE);
		carriersPanel.setBackground(Color.WHITE);
		numberFormatPanel.setBackground(Color.WHITE);

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   								END

		setSize(650,483);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false); // cannot be resizable by mouse when run
		setVisible(true);


	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == exit)
		{
			setVisible(false);
		}
		if (e.getSource() == submit)
		{
			if (menSoccerCheckBox.isSelected() == true)  // <<<<< MEN SOCCER
			{
				if (emailCheckBox.isSelected() == true) // EMAIL
				{
					addToMenSoccerEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToMenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToMenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToMenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToMenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToMenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToMenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToMenSoccerEmail (changedSMS);
					}

				}
			}
			if (womenSoccerCheckBox.isSelected() == true) // <<<<<< WOMEN SOCCER 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenSoccerEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToWomenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToWomenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToWomenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToWomenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToWomenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToWomenSoccerEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToWomenSoccerEmail (changedSMS);
					}
				}
			}
			if (menTennisCheckBox.isSelected() == true) // <<<<<< WOMEN TENNIS 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToMenTennisEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToMenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToMenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToMenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToMenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToMenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToMenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToMenTennisEmail (changedSMS);
					}
				}
			}
			if (womenTennisCheckBox.isSelected() == true) // <<<<<< WOMEN TENNIS
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenTennisEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToWomenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToWomenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToWomenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToWomenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToWomenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToWomenTennisEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToWomenTennisEmail (changedSMS);
					}
				}
			}
			if (menBasketballCheckBox.isSelected() == true) // <<<<<< MEN BASKET 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToMenBasketballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToMenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToMenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToMenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToMenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToMenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToMenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToMenBasketballEmail (changedSMS);
					}
				}
			}
			////////////<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<///////////
			if (womenBasketballCheckBox.isSelected() == true) // <<<<<< WOMEN BASKET 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenBasketballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToWomenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToWomenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToWomenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToWomenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToWomenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToWomenBasketballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToWomenBasketballEmail (changedSMS);
					}				}
			}
			if (menCrossCountryCheckBox.isSelected() == true) // <<<<<< MEN C C 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToMenCrossCountryEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToMenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToMenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToMenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToMenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToMenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToMenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToMenCrossCountryEmail (changedSMS);
					}				}
			}
			if (womenCrossCountryCheckBox.isSelected() == true) // <<<<<< WOMEN C C 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenCrossCountryEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToWomenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToWomenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToWomenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToWomenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToWomenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToWomenCrossCountryEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToWomenCrossCountryEmail (changedSMS);
					}				}
			}
			if (menGolfCheckBox.isSelected() == true) // <<<<<< MEN Golf
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToMenGolfEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToMenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToMenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToMenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToMenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToMenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToMenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToMenGolfEmail (changedSMS);
					}				}
			}
			if (womenGolfCheckBox.isSelected() == true) // <<<<<< WOMEN Golf
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenGolfEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToWomenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToWomenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToWomenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToWomenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToWomenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToWomenGolfEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToWomenGolfEmail (changedSMS);
					}				}
			}
			if (menTrackFieldCheckBox.isSelected() == true) // <<<<<< MEN Track And Field 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToMenTrackFieldEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToMenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToMenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToMenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToMenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToMenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToMenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToMenTrackFieldEmail (changedSMS);
					}				}
			}
			if (womenTrackFieldCheckBox.isSelected() == true) // <<<<<< WOMEN Track And Field 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenTrackFieldEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToWomenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToWomenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToWomenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToWomenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToWomenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToWomenTrackFieldEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToWomenTrackFieldEmail (changedSMS);
					}				}
			}
			if (baseballCheckBox.isSelected() == true) // <<<<<< BASEBALL
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToBaseballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToBaseballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToBaseballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToBaseballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToBaseballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToBaseballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToBaseballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToBaseballEmail (changedSMS);
					}				}
			}
			if (softballCheckBox.isSelected() == true) // <<<<<< SOFTBALL
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToSoftballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToSoftballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToSoftballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToSoftballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToSoftballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToSoftballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToSoftballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToSoftballEmail (changedSMS);
					}				}
			}
			if (VolleyballCheckBox.isSelected() == true) // <<<<<< VolleyBALL
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToVolleyballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					if (carriersList.getSelectedItem().toString() == "AT&T")
					{
						changedSMS = smsTextField.getText() + att;
						// System.out.println(changedSMS);
						addToVolleyballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "SPRINT")
					{
						changedSMS = smsTextField.getText() + sprint;
						// System.out.println(changedSMS);
						addToVolleyballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "T-MOBILE")
					{
						changedSMS = smsTextField.getText() + tmobile;
						// System.out.println(changedSMS);
						addToVolleyballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Virgin Mobile")
					{
						changedSMS = smsTextField.getText() + virginMobile;
						// System.out.println(changedSMS);
						addToVolleyballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Verizon")
					{
						changedSMS = smsTextField.getText() + verizon;
						// System.out.println(changedSMS);
						addToVolleyballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Cingular")
					{
						changedSMS = smsTextField.getText() + cingular;
						// System.out.println(changedSMS);
						addToVolleyballEmail (changedSMS);
					}
					if (carriersList.getSelectedItem().toString() == "Nextel")
					{
						changedSMS = smsTextField.getText() + nextel;
						// System.out.println(changedSMS);
						addToVolleyballEmail (changedSMS);
					}				}
			}
			JOptionPane.showMessageDialog(null, "Thank you for subscribing to our newsletter, Your subscription is now completed. ", "Subscription Successful",JOptionPane.INFORMATION_MESSAGE, icon);

		}

	}


	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                MENS SOCCER     		1
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToMenSoccerEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/soccerm/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                 WOMENS SOCCER			2
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToWomenSoccerEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/soccerw/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                        MEN TENNIS 	3
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToMenTennisEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/tennism/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                    WOMEN TENNIS		4
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToWomenTennisEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/tennisw/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                              WOMEN BASKET				5
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToWomenBasketballEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/basketballw/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                 MEN BASKET		6
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToMenBasketballEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/basketballm/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                BASEBALL			7
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToBaseballEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/baseball/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 									VOLLEYBALL		8
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToVolleyballEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/volleyball/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 									SOFTBALL	9
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToSoftballEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/softball/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	//
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 										Women Golf		10
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToWomenGolfEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/golfw/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 										Men Golf		11
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToMenGolfEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/golfm/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 							Men Cross Country		12
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToMenCrossCountryEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/crosscountrym/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 							Women Cross Country		13
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToWomenCrossCountryEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/crosscountryw/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 									Women Track Field 14
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToWomenTrackFieldEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/trackw/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 							Men Track Field			15
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	/** This method will add the user's input ( phone number or email ) into the contact Database
	 * @param email is a input string [email/phone-number] to save it in the database
	 */
	public void addToMenTrackFieldEmail (String email)
	{
		if (email == null)
		{
			email = "";
		}
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("data/sub/trackm/email.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
}