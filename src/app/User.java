package app;

/*
 * Deni Zmak
 * SE 300 - Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 11/18/14
 */


/**
 * Defines a simple user class and provides required constructors, method to string, and getters for
 * username, password and userLevel .
 * @author Deni Zmak
 */
public class User
{
	//Class variables
	private String username;
	private String password;
	private String userLevel;
	
	
	/**
	 * No-argument constructor
	 */
	public User()
	{
		this.userLevel = "";
	}
	
	
	/**
	 * Default constructor with parameterized data
	 * @param username
	 * @param password
	 * @param userLevel
	 */
	public User (String username, String password, String userLevel)
	{
		this.username = username;
		this.password = password;
		this.userLevel = userLevel;
	}
	
	/**
	 * Parses a comma delimited string of user data (username, password, userLevel).
	 * @param iostring
	 */
	public User (String iostring) throws InvalidUserException
	{
		try
		{
			String [] data = iostring.split(",");
			if (data.length != 3)  throw new InvalidUserException();
			else 
			{
				username = data[0].trim();
				password = data[1].trim();
				userLevel = data[2].trim();
			}
			
		} catch(Exception e) {
			throw new InvalidUserException();
		}
	}
	
	/**
	 * @return a string representation of the movie object
	 */
	public String toString()
	{
		return username + ", " + password + ", " + userLevel + "\n";	
	}
	
	/**
	 * 	@return username
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * @return password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * @return userLevel
	 */
	public String getUserLevel()
	{
		return userLevel;
	}


	/**
	 * @param userLevel
	 */
	public void setUserLevel (String userLevel) 
	{
		this.userLevel = userLevel;
	}
}