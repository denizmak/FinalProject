/**
 * This class manages the SLList to produce a nice front-end to the user database.
 * 
 * @author Deni Zmak
 */

import java.io.*;

public class DatabaseManager
{

	DLList list = new DLList(); //You must create an instance of this


	/**
	 * Default constructor - creates a database with a list that is empty
	 */
	public DatabaseManager()
	{
		//Creates a new instance of the list
	}

	/**
	 * Advanced constructor - creates a database with a list of values from an input file
	 * @param file - the input file.
	 */
	public DatabaseManager(String file)
	{
		this();
		parseInputFile(file); //populates database with list of users
	}

	/**
	 * Parses the input file so that you can add all of items found in the list in alphabetical order by title.
	 */
	private void parseInputFile(String file)
	{
		//Create a file input stream
		User user;
		String instr;

		try 
		{
			//Create input reader
			BufferedReader in = new BufferedReader(new FileReader(file));
			while (in.ready())
			{
				instr = in.readLine();

				//Try to parse the movie using the appropriate movie constructor.  If it fails, an exception is caught
				try
				{
					user = new User(instr);

					////////////////////////////////////////////////////
					//Add code to insert m here into your list
					list.addUser(user);
					////////////////////////////////////////////////////

				} 

				catch (InvalidUserException e) 
				{
					System.out.println("Invalid muser string " + instr + " in file " + file);
				}
			}	
		}

		catch (IOException io) 
		{
			System.err.println("Error in Parsing file.");
			io.printStackTrace();	
		}
	}



	/**
	 * Provides console I/O to the program for user interaction.
	 */
	public void consoleIO()
	{

		//Prompts to the user
		System.out.println("Please Choose from the Following:");
		System.out.println("\t1. List Users Ascending");
		System.out.println("\t2. List Users Descending");
		System.out.println("\t3. Add User");
		System.out.println("\t4. Delete User");
		System.out.println("\t5. Print User Details");
		System.out.print(">> ");

		//Creates a buffer to read from the console.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//I/O code in a big try/catch to ensure no exceptions occur.
		try 
		{
			String choice = br.readLine();

			//Given the choice, call the appropriate function calls.
			if (choice.equals("1")) {
				//////////////////////////////////////////////////////
				//  Call list function that prints in ascending order
				list.printAscending();
				//////////////////////////////////////////////////////

			}

			else if (choice.equals("2")) 
			{
				//////////////////////////////////////////////////////
				//  Call list function that prints in descending order
				list.printDescending();
				//////////////////////////////////////////////////////				
			}


			else if (choice.equals("3")) 
			{
				System.out.print("Username >> ");
				String username = br.readLine();

				System.out.print("Password >> ");
				String password = br.readLine();

				System.out.print("User Level >> ");
				String userLevel = br.readLine();


				User newUser = new User (username, password, userLevel);
				System.out.print (newUser);

				//////////////////////////////////////////////////////
				//  Call list method to add item to the list
				//  in alphabetical order
				list.addUser(username, password, userLevel);
				//////////////////////////////////////////////////////
			}


			else if (choice.equals("4")) 
			{
				System.out.print("Username >> ");
				String username = br.readLine();

				//////////////////////////////////////////////////////
				//  Call list method to delete an item give movie
				//  title
				list.deleteByUsername(username);
				//////////////////////////////////////////////////////
			}

			else if (choice.equals("5"))
			{
				System.out.print("Username >> ");
				String title = br.readLine();

				//////////////////////////////////////////////////////
				//  Call list method to retrieve and print a movie
				//  given the title.  An appropriate "not found" message
				//  should be provided if it is not found in the list.
				list.getUser(title);
				//////////////////////////////////////////////////////
			}

			else 
			{
				System.out.println("Invalid Input:  Try again");
			}	
		} 
		catch (IOException e) 
		{
			System.out.println("Invalid Input:  Try again");
		}
	}

/*
	public static void main(String [] args)
	{

		//Create manager and have it populate with input file content.
		DatabaseManager dm = new DatabaseManager("bin/Users.txt");

		//Console runs in an infinite loop.
		while (true) 
		{
			dm.consoleIO();
		}
	}
	*/
}