import javax.mail.*;

import java.io.*;

import javax.mail.internet.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


/**
 * @author Fares Almuhanna
 *	General idea: Notification is the way the administrator can send mass email or sms to subscribers
 *	Programming idea: By using the database content already created by subscriptionPanel, this program can send mass email or sms for all subscribers based on type of sport
 */
public class NotificationPanel extends JFrame implements ActionListener {

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final int SMTP_HOST_PORT = 465;
	private static final String SMTP_AUTH_USER = "BazingaSE@gmail.com";
	private static final String SMTP_AUTH_PWD  = "shafagh3A";

	private JPanel mainPanel = new JPanel(); 
	private JPanel notificationTitlePanel = new JPanel();
	private JPanel sendToPanel = new JPanel();
	private JPanel sendToNorth = new JPanel();
	private JPanel sendToCenter = new JPanel();

	private JPanel subjectPanel = new JPanel();
	private JPanel messagePanel = new JPanel();
	private JPanel southPanel = new JPanel();

	private JPanel contentPanel1 = new JPanel();
	private JPanel contentPanel2 = new JPanel();
	private JPanel contentPanel3 = new JPanel();
	private JPanel contentPanel4 = new JPanel();
	private JPanel contentPanel5 = new JPanel();
	private JPanel contentPanel6 = new JPanel();
	private JPanel contentPanel7 = new JPanel();
	private JPanel contentPanel8 = new JPanel();
	private JPanel contentPanel9 = new JPanel();
	private JPanel contentPanel10 = new JPanel();
	private JPanel contentPanel11 = new JPanel();
	private JPanel contentPanel12 = new JPanel();
	private JPanel contentPanel13 = new JPanel();
	private JPanel contentPanel14 = new JPanel();
	private JPanel contentPanel15 = new JPanel();
	private JPanel contentPanel16 = new JPanel();

	private JButton send = new JButton ("Send");
	private JButton cancel = new JButton ("Cancel");

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
	//private JCheckBox allCheckBox = new JCheckBox();

	private JLabel notificationTitle = new JLabel("NOTIFICATION", JLabel.CENTER);
	private JLabel sendToLabel = new JLabel("Send To Subscribers Of");
	private JLabel menSoccer = new JLabel("Soccer | Men");	
	private JLabel womenSoccer = new JLabel("Soccer | Women");
	private JLabel menTennis = new JLabel("Tennis | Men");
	private JLabel womenTennis = new JLabel("Tennis | Women");
	private JLabel baseball = new JLabel("Baseball");
	private JLabel softball = new JLabel("Softball");
	private JLabel menBasketball = new JLabel("Basketball | Men");
	private JLabel womenBasketball = new JLabel("Basketball | Women");
	private JLabel menCrossCountry = new JLabel("Cross Country | Men");
	private JLabel womenCrossCountry = new JLabel("Cross Country | Women");
	private JLabel menGolf = new JLabel("Golf | Men");
	private JLabel womenGolf = new JLabel("Golf | Women");
	private JLabel menTrackField = new JLabel("Track & Field | Men");
	private JLabel womenTrackField = new JLabel("Track & Field | Women");
	private JLabel Volleyball = new JLabel("Volleyball");
	//private JLabel all = new JLabel("All");
	private JLabel subjectLabel = new JLabel("Subject: ");
	private JLabel messageLabel = new JLabel("Message: ");

	private JTextField subjectTextField = new JTextField(56);

	private JTextArea messageText = new JTextArea(10,10);

	private JScrollPane scrollPane = new JScrollPane(messageText);;
	final ImageIcon icon = new ImageIcon("data/happyIcon.png"); 

	/**
	 * 	 * Default method that contains all panels needed to organize the interface with labels and buttons

	 */
	public NotificationPanel () 
	{
		add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		notificationTitlePanel.setLayout(new FlowLayout());
		notificationTitlePanel.add(notificationTitle);
		mainPanel.add(notificationTitlePanel);
		notificationTitle.setFont (new Font ("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		mainPanel.add(sendToPanel);
		mainPanel.add(subjectPanel);
		mainPanel.add(messagePanel);
		mainPanel.add(scrollPane);
		mainPanel.add(southPanel);

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< START OF Send To Section 
		sendToPanel.setLayout(new BorderLayout());
		sendToPanel.add(sendToNorth, BorderLayout.NORTH);
		sendToNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		sendToNorth.add(sendToLabel);
		sendToLabel.setFont (new Font ("Times New Roman", Font.BOLD, 18));

		sendToPanel.add(sendToCenter, BorderLayout.CENTER);
		sendToCenter.setLayout(new GridLayout(4,5));
		sendToCenter.add(contentPanel1);
		sendToCenter.add(contentPanel2);
		sendToCenter.add(contentPanel3);
		sendToCenter.add(contentPanel4);
		sendToCenter.add(contentPanel5);
		sendToCenter.add(contentPanel6);
		sendToCenter.add(contentPanel7);
		sendToCenter.add(contentPanel8);
		sendToCenter.add(contentPanel9);
		sendToCenter.add(contentPanel10);
		sendToCenter.add(contentPanel11);
		sendToCenter.add(contentPanel12);
		sendToCenter.add(contentPanel13);
		sendToCenter.add(contentPanel14);
		sendToCenter.add(contentPanel15);
		sendToCenter.add(contentPanel16);

		contentPanel1.add(baseballCheckBox);//5
		contentPanel1.add(baseball);
		contentPanel2.add(menBasketballCheckBox);//7
		contentPanel2.add(menBasketball);
		contentPanel3.add(womenBasketballCheckBox);//8
		contentPanel3.add(womenBasketball);
		contentPanel4.add(menCrossCountryCheckBox);//9
		contentPanel4.add(menCrossCountry);
		contentPanel5.add(womenCrossCountryCheckBox);//10
		contentPanel5.add(womenCrossCountry);
		contentPanel6.add(menGolfCheckBox); //11
		contentPanel6.add(menGolf);
		contentPanel7.add(womenGolfCheckBox); //12
		contentPanel7.add(womenGolf);
		contentPanel8.add(menSoccerCheckBox); //1
		contentPanel8.add(menSoccer);
		contentPanel9.add(womenSoccerCheckBox); //2 
		contentPanel9.add(womenSoccer);
		contentPanel10.add(softballCheckBox);//6
		contentPanel10.add(softball);
		contentPanel11.add(menTennisCheckBox); //3
		contentPanel11.add(menTennis);
		contentPanel12.add(womenTennisCheckBox);//4
		contentPanel12.add(womenTennis);
		contentPanel13.add(menTrackFieldCheckBox);//13
		contentPanel13.add(menTrackField);
		contentPanel14.add(womenTrackFieldCheckBox);//14
		contentPanel14.add(womenTrackField);
		contentPanel15.add(VolleyballCheckBox);//15
		contentPanel15.add(Volleyball);
		//contentPanel16.add(allCheckBox);
		//contentPanel16.add(all);

		contentPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel6.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel7.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel8.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel9.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel10.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel11.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel12.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel13.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel14.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel15.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel16.setLayout(new FlowLayout(FlowLayout.LEFT));
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< END OF Send To Section 

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< START OF SUBJECT Section 
		subjectPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		subjectPanel.add(subjectLabel);
		subjectLabel.setFont (new Font ("Times New Roman", Font.BOLD, 16));
		subjectPanel.add(subjectTextField);
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< END OF SUBJECT Section 

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< START OF MESSAGE Section 

		messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		messagePanel.add(messageLabel);
		messageLabel.setFont (new Font ("Times New Roman", Font.BOLD, 16));
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< END OF MESSAGE Section 

		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		southPanel.add(send);
		southPanel.add(cancel);
		cancel.addActionListener(this);
		send.addActionListener(this);

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Set Background to WHite 
		mainPanel.setBackground(Color.WHITE);
		notificationTitlePanel.setBackground(Color.WHITE);
		sendToPanel.setBackground(Color.WHITE);
		sendToNorth.setBackground(Color.WHITE);
		sendToCenter.setBackground(Color.WHITE);
		subjectPanel.setBackground(Color.WHITE);
		messagePanel.setBackground(Color.WHITE);
		southPanel.setBackground(Color.WHITE);
		contentPanel1.setBackground(Color.WHITE);
		contentPanel2.setBackground(Color.WHITE);
		contentPanel3.setBackground(Color.WHITE);
		contentPanel4.setBackground(Color.WHITE);
		contentPanel5.setBackground(Color.WHITE);
		contentPanel6.setBackground(Color.WHITE);
		contentPanel7.setBackground(Color.WHITE);
		contentPanel8.setBackground(Color.WHITE);
		contentPanel9.setBackground(Color.WHITE);
		contentPanel10.setBackground(Color.WHITE);
		contentPanel11.setBackground(Color.WHITE);
		contentPanel12.setBackground(Color.WHITE);
		contentPanel13.setBackground(Color.WHITE);
		contentPanel14.setBackground(Color.WHITE);
		contentPanel15.setBackground(Color.WHITE);
		contentPanel16.setBackground(Color.WHITE);

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< SET JFRAME PREFERENCES  
		setSize(760,483);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // cannot be resizable by mouse when run
		setVisible(true);


	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * All Action Performed for all buttons, checkboxs, and textfields ... etc 
	 * 
	 */
	public void actionPerformed (ActionEvent e)
	{

		if (e.getSource() == cancel)
		{
			setVisible(false);
		}
		if (e.getSource() == send)
		{


			if (baseballCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/baseball/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (menBasketballCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/basketballm/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (womenBasketballCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/basketballw/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (menCrossCountryCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/crosscountrym/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (womenCrossCountryCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/crosscountryw/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (menGolfCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/golfm/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (womenGolfCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/golfw/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (menSoccerCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/soccerm/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (womenSoccerCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/soccerw/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (softballCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/softball/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (menTennisCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/tennism/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (womenTennisCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/tennisw/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (menTrackFieldCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/trackm/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (womenTrackFieldCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/trackw/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
			if (VolleyballCheckBox.isSelected() == true)  // <<<<< Baseball
			{
				//
				try {
					sendToEmail("data/sub/volleyball/email.txt", subjectTextField.getText(), messageText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}

			JOptionPane.showMessageDialog(null, "Notification has been sent to the subscribers. ", "Notification Successful",JOptionPane.INFORMATION_MESSAGE, icon);


		}
	}

	/**
	 * SendToEmail method check each line of txt file that has phone-numbers/emails and pass each line to "send" method, with param of subject and contect
	 * @param txtFile is a string of a file location.
	 * @param subject is the title of the mass message.
	 * @param content is the content of the mass message.
	 * @throws Exception
	 */
	public static  void sendToEmail(String txtFile, String subject, String content) throws Exception 
	{
		try {
			File file = new File(txtFile);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				send(line, subject, content);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * send method is the sending function used to send all emails and SMS.
	 * Send email with SMTPS - JAVA MAIL (GMAIL)
	 * Account used to send messages is "BazingaSE@gmail.com" 
	 * Reference : The concept of this method was taked from-> "http://www.rgagnon.com/javadetails/java-0570.html"
	 * 
	 * @param email is the receiver address whether its phone number or email
	 * @param subject is the title of the mass message.
	 * @param content is the content of the mass message.
	 * @throws Exception
	 */
	public static void send(String email, String subject, String content) throws Exception{
		Properties props = new Properties();

		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", SMTP_HOST_NAME);
		props.put("mail.smtps.auth", "true");
		// props.put("mail.smtps.quitwait", "false");

		Session mailSession = Session.getDefaultInstance(props);
		mailSession.setDebug(true);
		Transport transport = mailSession.getTransport();

		MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(subject);
		message.setContent(content, "text/plain");

		message.addRecipient(Message.RecipientType.TO,
				new InternetAddress(email));

		transport.connect
		(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

		transport.sendMessage(message,
				message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

}