package app;

/*
 * Deni Zmak
 * SE 300 Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 10/17/14
 */


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
		frame.setVisible (true);
	}
}