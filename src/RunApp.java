/*
 * Deni Zmak
 * See 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */

import javax.swing.JFrame;


public class RunApp
{
	/**Main method is used to run the application. It crates an instance of HomePage class and sets the 
	 * main frame properties.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// create a frame and set its properties 
		HomePage frame = new HomePage();

		frame.setSize (950, 630);
		frame.setLocationRelativeTo (null);
		frame.setResizable (false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle ("ERAU Eagles Fun Club Application");
		frame.setVisible (true);
	}
}