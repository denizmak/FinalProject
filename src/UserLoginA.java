import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class UserLoginA extends JPanel{
	
	protected JButton sign = new JButton("SignUp");
	protected JButton log = new JButton("Login");
	protected JButton resetLog = new JButton("Forgot Login");
	protected JTextField usrName = new JTextField("   User Name   ");
	protected JPasswordField passWrd= new JPasswordField("   Password   ");
	 protected JPanel accessLogIn = new JPanel();
	protected JPanel accessSignUp = new JPanel();
	private JPanel wBorder = new JPanel();
	private JPanel nBorder = new JPanel();
	private JPanel sBorder = new JPanel();
	private JPanel eBorder = new JPanel();
	protected EagleImageA eagle = new EagleImageA();
	protected JTextPane text = new JTextPane();
	protected JPanel accessSwitch = new JPanel();
	
	protected JLabel lblFName  = new JLabel(" First Name :");
	protected JLabel lblLname = new JLabel(" Last name :");
	protected JLabel lblAddress = new JLabel(" Email Address :");
	protected JLabel lbIUserName = new JLabel(" User Name :");
	protected JPasswordField IbIPassWord = new JPasswordField(" Password");
    protected JTextField txtFName= new JTextField();
    protected JTextField txtLName= new JTextField();
    protected JTextField txtAddress= new JTextField();
    protected JTextField txtUserName = new JTextField();
	
	
	UserLoginA(){
		
		setLayout(new BorderLayout());
		
		/*
		StyledDocument doc = text.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		StyleConstants.setForeground(center, Color.red);

        try { doc.insertString(doc.getLength(), "_____________ Or _____________",center); }
        catch (BadLocationException e){}
		*/
		
       // accessSignUp.setLayout(new BorderLayout());
		add(accessSignUp, BorderLayout.SOUTH);
		add(accessLogIn, BorderLayout.NORTH);
		add(eagle, BorderLayout.CENTER);
		//accessSignUp.setLayout(new BoxLayout(accessSignUp,BoxLayout.Y_AXIS));
		
		passWrd.setEchoChar((char) 0);
		
		accessLogIn.add(usrName);
		accessLogIn.add(passWrd);
		accessLogIn.add(log);
		
		
		sign.setAlignmentX( Component.CENTER_ALIGNMENT);
		text.setAlignmentX( Component.CENTER_ALIGNMENT);
		

		
		add(eBorder, BorderLayout.EAST);
		add(wBorder, BorderLayout.WEST);
		
		wBorder.setBackground(Color.white);
		eBorder.setBackground(Color.white);
		sBorder.setBackground(Color.white);
		nBorder.setBackground(Color.white);
		
		accessLogIn.setBackground(Color.white);
			
		
		//set buttons color
		log.setBackground(Color.white);
		log.setForeground(Color.MAGENTA);
		log.setContentAreaFilled(false);
	    log.setOpaque(true);
		
	    sign.setBackground(Color.white);
		sign.setForeground(Color.MAGENTA);
		sign.setContentAreaFilled(false);
	    sign.setOpaque(true);
	    
	    resetLog.setBackground(Color.white);
	    resetLog.setForeground(Color.MAGENTA);
	    resetLog.setContentAreaFilled(false);
	    resetLog.setOpaque(true);
	
	}
}