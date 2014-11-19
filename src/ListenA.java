import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ListenA extends UserLoginA{
	private int count =0;
	private ReaderA checker = new ReaderA();
	private String logInCreds;
	private String textPW;
	private char usrPassWord [] ;
	private String nameUsr ;
	private JPanel submittion = new JPanel();
	private JButton submit =new JButton("Submit");
	private JPanel reset = new JPanel();
	protected static int  userNum =0;
	protected String [] logCreds  = new String[5];
	private String userLevel  = new String("admin"); // "" for normal user, "user" for student, "admin" for admin
	
	ListenA(){
		
		log.addActionListener(new ButtonListener());
		sign.addActionListener(new ButtonListener());
		passWrd.addMouseListener(new MouseAdapter());
		usrName.addMouseListener(new MouseAdapter());
		
		
	}

	//listener for buttons
	class ButtonListener implements ActionListener {

		@Override 
		public void actionPerformed(ActionEvent e) {
			
			 // log in button
			if(e.getSource()==log){
				checker.read();
				usrPassWord = passWrd.getPassword(); //retrieve pw
				 nameUsr = usrName.getText(); //retrieve user name
				 textPW = String.valueOf(usrPassWord); //convert pw to string
				 logInCreds = nameUsr.concat(" "+textPW) ; //contotate user name + pw
				// logInCreds = nameUsr.concat(" "+usrPassWord) ;
				 Arrays.fill(usrPassWord,'0'); //clear saved pw
				 
				 //check if admin
				 if (logInCreds.contains("jafers" +" " + textPW))
					 userLevel = "admin";
				
				 //check access
				if(checker.checkCode(logInCreds)){
					System.out.println("yes");
				}
				
				else {
					System.out.println("no");
				}				
			}		

				
			//remove login details from program
			logInCreds="";
			checker.clearAccessCodes();
			}
		}
	
	
	public String getUserLevel()
	{
		return userLevel;
	}
	
	
	// listener for password fields 
	class MouseAdapter implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			count++;
			passWrd.setEchoChar('*');
			//checker.read();
			
			//clear default fields
			if(passWrd.getPassword().length != 0 && count==1) {
				passWrd.setText(""); 
				usrName.setText(""); 
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}