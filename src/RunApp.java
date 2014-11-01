import javax.swing.JFrame;

/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */


public class RunApp extends HomePage
{
	public static void main(String[] args) 
	{
		// create a frame and set its properties 
		RunApp frame = new RunApp();

		frame.setSize (950, 630);
		frame.setLocationRelativeTo (null);
		frame.setResizable (false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle ("ERAU Eagles Fun Club Application");
		frame.setVisible (true);
	}
}