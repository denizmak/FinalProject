// Fares

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;
import java.util.*;
import java.lang.*;


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
	private JPanel emailPanel = new JPanel();
	private JPanel badgesPanel = new JPanel();


	private JLabel subscriptionTitle = new JLabel("SUBSCRIPTION", JLabel.CENTER);
	private JLabel reseiveNotificationBy = new JLabel("Reseive Notification By", JLabel.CENTER);
	private JLabel sms = new JLabel(" SMS  ");
	private JLabel email = new JLabel("EMAIL");
	private JLabel badges = new JLabel("Badges");
	private JLabel receiveNewsOf = new JLabel("Reseive News of", JLabel.CENTER);

	private JLabel menSoccer = new JLabel("Men's Soccer");	
	private JLabel womenSoccer = new JLabel("Women's Soccer");	
	private JLabel menTennis = new JLabel("Men's Tennis");
	private JLabel womenTennis = new JLabel("Women's Tennis");
	private JLabel baseball = new JLabel("Baseball");
	private JLabel softball = new JLabel("Softball");
	private JLabel menBasketball = new JLabel("Men's Basketball");
	private JLabel womenBasketball = new JLabel("Women's Basketball");
	private JLabel menCrossCountry = new JLabel("Men's Cross Country");
	private JLabel womenCrossCountry = new JLabel("Women's Cross Country");
	private JLabel menGolf = new JLabel("Men's Golf");
	private JLabel womenGolf = new JLabel("Women's Golf");
	private JLabel menTrackField = new JLabel("Men's Track&Field");
	private JLabel womenTrackField = new JLabel("Women's Track&Field");
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
	// ***********************************************************************************************************************
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
		// receiveViaColoumn.setSize(300, 100);
		// receiveViaColoumn.setSize(new Dimension(300,100));
		//receiveViaColoumn.setMaximumSize(new Dimension (300,100));

		receiveViaColoumn.add(reseiveNotificationBy, BorderLayout.NORTH);
		receiveViaColoumn.add(receiveViaColoumnBody, BorderLayout.CENTER);
		
		/*receiveViaColoumnBody.setLayout(new GridLayout(3,2));
		receiveViaColoumnBody.add(smsCheckBox);
		receiveViaColoumnBody.add(sms);
		receiveViaColoumnBody.add(smsTextField);
		receiveViaColoumnBody.add(emailCheckBox);
		receiveViaColoumnBody.add(email);
		receiveViaColoumnBody.add(emailTextField);
		receiveViaColoumnBody.add(badgesCheckBox);
		receiveViaColoumnBody.add(badges);*/
		
		receiveViaColoumnBody.setLayout(new GridLayout(10,1));
		receiveViaColoumnBody.add(smsPanel);
		smsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		smsPanel.add(smsCheckBox);
		smsPanel.add(sms);
		smsPanel.add(smsTextField);
		badgesPanel.add(badgesCheckBox);
		badgesPanel.add(badges);
		
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

		receiveAboutColoumnBody.add(menSoccerCheckBox); //1
		receiveAboutColoumnBody.add(menSoccer);	

		receiveAboutColoumnBody.add(womenSoccerCheckBox); //2 
		receiveAboutColoumnBody.add(womenSoccer);

		receiveAboutColoumnBody.add(menTennisCheckBox); //3
		receiveAboutColoumnBody.add(menTennis);

		receiveAboutColoumnBody.add(womenTennisCheckBox);//4
		receiveAboutColoumnBody.add(womenTennis);

		receiveAboutColoumnBody.add(baseballCheckBox);//5
		receiveAboutColoumnBody.add(baseball);

		receiveAboutColoumnBody.add(softballCheckBox);//6
		receiveAboutColoumnBody.add(softball);

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
	
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   								END

		setSize(618,483);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false); // cannot be resizable by mouse when run
		setVisible(true);


	}

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
					addToMenSoccerSMS (smsTextField.getText());
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
					addToWomenSoccerSMS (smsTextField.getText());
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
					addToMenTennisSMS (smsTextField.getText());
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
					addToWomenTennisSMS (smsTextField.getText());
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
					addToMenBasketballSMS (smsTextField.getText());
				}
			}
			if (womenBasketballCheckBox.isSelected() == true) // <<<<<< WOMEN BASKET 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenBasketballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToWomenBasketballSMS (smsTextField.getText());
				}
			}
			if (menCrossCountryCheckBox.isSelected() == true) // <<<<<< MEN C C 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToMenCrossCountryEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToMenCrossCountrySMS (smsTextField.getText());
				}
			}
			if (womenCrossCountryCheckBox.isSelected() == true) // <<<<<< WOMEN C C 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenCrossCountryEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToWomenCrossCountrySMS (smsTextField.getText());
				}
			}
			if (menGolfCheckBox.isSelected() == true) // <<<<<< MEN Golf
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToMenGolfEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToMenGolfSMS (smsTextField.getText());
				}
			}
			if (womenGolfCheckBox.isSelected() == true) // <<<<<< WOMEN Golf
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenGolfEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToWomenGolfSMS (smsTextField.getText());
				}
			}
			if (menTrackFieldCheckBox.isSelected() == true) // <<<<<< MEN Track And Field 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToMenTrackFieldEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToMenTrackFieldSMS (smsTextField.getText());
				}
			}
			if (womenTrackFieldCheckBox.isSelected() == true) // <<<<<< WOMEN Track And Field 
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToWomenTrackFieldEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToWomenTrackFieldSMS (smsTextField.getText());
				}
			}
			if (baseballCheckBox.isSelected() == true) // <<<<<< BASEBALL
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToBaseballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToBaseballSMS (smsTextField.getText());
				}
			}
			if (softballCheckBox.isSelected() == true) // <<<<<< SOFTBALL
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToSoftballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToSoftballSMS (smsTextField.getText());
				}
			}
			if (VolleyballCheckBox.isSelected() == true) // <<<<<< VolleyBALL
			{
				if (emailCheckBox.isSelected() == true) // EAMIL
				{
					addToVolleyballEmail (emailTextField.getText());
				}
				if (smsCheckBox.isSelected() == true) // SMS
				{
					addToVolleyballSMS (smsTextField.getText());
				}
			}
		}

	}


	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                MENS SOCCER     		1
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToMenSoccerEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/menSoccer.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToMenSoccerSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/menSoccer.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                 WOMENS SOCCER			2
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToWomenSoccerEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/womenSoccer.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToWomenSoccerSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/womenSoccer.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                        MEN TENNIS 	3
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToMenTennisEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/menTennis.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToMenTennisSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/menTennis.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                    WOMEN TENNIS		4
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToWomenTennisEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/womenTennis.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToWomenTennisSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/womenTennis.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                              WOMEN BASKET				5
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToWomenBasketballEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/womenBasketball.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToWomenBasketballSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/womenBasketball.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                 MEN BASKET		6
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToMenBasketballEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/menBasketball.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToMenBasketballSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/menBasketball.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                                BASEBALL			7
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToBaseballEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/baseball.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToBaseballSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/baseball.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 									VOLLEYBALL		8
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToVolleyballEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/volleyball.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToVolleyballSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/volleyball.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 									SOFTBALL	9
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToSoftballEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/softball.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToSoftballSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/softball.txt", true)));
			out.println(SMS);
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
	public void addToWomenGolfEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/womenGolf.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToWomenGolfSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/womenGolf.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 										Men Golf		11
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToMenGolfEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/menGolf.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToMenGolfSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/menGolf.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 							Men Cross Country		12
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToMenCrossCountryEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/menCrossCountry.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToMenCrossCountrySMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/menCrossCountry.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 							Women Cross Country		13
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToWomenCrossCountryEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/womenCrossCountry.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToWomenCrossCountrySMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/womenCrossCountry.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 									Women Track Field 14
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToWomenTrackFieldEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/womenTrackField.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToWomenTrackFieldSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/womenTrackField.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 							Men Track Field			15
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<EMAIL
	public void addToMenTrackFieldEmail (String email)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/EMAIL/menTrackField.txt", true)));
			out.println(email);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SMS
	public void addToMenTrackFieldSMS (String SMS)
	{
		try 
		{
			PrintWriter out = new PrintWriter (new BufferedWriter ( new FileWriter("Data/Subscription/SMS/menTrackField.txt", true)));
			out.println(SMS);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
}