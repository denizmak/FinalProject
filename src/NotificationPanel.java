import javax.mail.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.mail.internet.*;
import javax.swing.*;


import java.awt.*;
import java.util.Properties;


public class NotificationPanel extends JFrame {

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final int SMTP_HOST_PORT = 465;
	private static final String SMTP_AUTH_USER = "BazingaSE@gmail.com";
	private static final String SMTP_AUTH_PWD  = "almuhanna3A";

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
	private JCheckBox allCheckBox = new JCheckBox();

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
	private JLabel all = new JLabel("All");
	private JLabel subjectLabel = new JLabel("Subject: ");
	private JLabel messageLabel = new JLabel("Message: ");

	private JTextField subjectTextField = new JTextField(56);

	private JTextArea messageText = new JTextArea(10,10);

	private JScrollPane scrollPane = new JScrollPane(messageText);;

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
		contentPanel16.add(allCheckBox);
		contentPanel16.add(all);

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

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< SET JFRAME PREFERENCES  
		setSize(760,483);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false); // cannot be resizable by mouse when run
		setVisible(true);


	}
	
	public void read() {
		try {
			File file = new File("test.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public void send(String email, String subject, String content) throws Exception{
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

	// Temprory main method

	public static void main(String[] args) throws Exception{

		new NotificationPanel () ;
		// new NotificationPanel().send();
	}




}