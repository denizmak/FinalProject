/*
 * Deni Zmak
 * SE 300 - Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 11/18/14
 */

/**
 * DLList class contains methods that help add new User object to the list, delete object, get info of a 
 * specific object based on username, and print all objects alphabetically (ascending, descending).
 * @author Deni
 */
public class DLList 
{
	// class variables
	DLLNode head, tail;

	/**
	 * Default constructor that creates an empty instance of DLList class
	 */
	public DLList()
	{
		head = tail = null;
	}

	
	/**
	 * addToHead() method creates a new DLLNode in the beginning of the list and stores the object in it.
	 * Also, it updates the prev and next reference, as well as head reference (and tail reference if needed).
	 * @param o - any object
	 */
	public void addToHead(Object o)
	{
		// creates a new node and updates head, prev and next references
		head = new DLLNode(o, null, head);

		//update tail reference if the list contains only one item
		if (head.next == null)	tail = head;

		//normal case scenario
		else	(head.next).prev = head;		
	}


	/**
	 * addToTail() method creates a new DLLNode in the end of the list and stores the object in it. Also, 
	 * it updates the prev and next reference, as well as tail reference (and head reference if needed).
	 * @param o - any object
	 */ 
	public void addToTail (Object o) 
	{
		// creates a new node and updates tail, prev and next references
		tail = new DLLNode (o, tail, null);

		//update head reference if the list contains only one item
		if (tail.prev == null)	head = tail;

		//normal case scenario
		else	(tail.prev).next = tail;	
	}

	
	/**
	 * addUser() method enables program to add the user in the list. The method takes separate user 
	 * info as parameters and creates a user object and node in the method. Also, it updates the prev and 
	 * next reference, as well head and tail references if needed.
	 * @param username
	 * @param password
	 * @param userLevel
	 */
	public void addUser(String username, String password, String userLevel)
	{
		//method variables
		Object add = new User (username, password, userLevel);
		DLLNode  cur = head;

		//while the list is not empty or while the end is not reached
		while (cur != null)
		{	
			/*
			 * check if the value of the username to be inserted is smaller than the title referenced by the cur
			 * If the statement is true the code is executed
			 */
			if (username.compareTo(((User) cur.o).getUsername()) < 0)
			{
				// special case if inserting the title in the beginning of the list
				if (cur.prev == null) 
				{
					addToHead(add);
					return;
				}

				//normal case scenario (adding in the middle of the list). prev and cur references are updated
				else
				{
					DLLNode tmp = new DLLNode (add, cur.prev, cur);
					cur.prev = (cur.prev).next = tmp;
					return;
				}
			}

			//if the user with the same username already exist
			else if (username.compareTo(((User) cur.o).getUsername()) == 0)
			{
				System.out.println("The o already exists in the list");
				return;
			}

			//loop the the location to insert is found or till the end of the list is reached
			cur = cur.next;
		}

		// if the list is empty or if we reach the end of the list
		if (cur == null)	addToTail(add);
	}		

	
	/**
	 * addUser() method enables program to add the user on the list. The method takes o object as 
	 * parameter and creates the node in the method. Also, it updates the prev and next reference, as 
	 * well head and tail references if needed.
	 * @param user - object of a type User
	 */
	public void addUser(Object user)
	{
		//method variables
		String username = ((User) user).getUsername();
		String password = ((User) user).getPassword();
		String userLevel = ((User) user).getUserLevel();

		Object add = new User (username, password, userLevel);
		DLLNode  cur = head;


		//while the list is not empty or while the end is not reached
		while (cur != null)
		{
			/*
			 * check if the value of the username to be inserted is smaller than the user referenced 
			 * by the cur. If the statement is true the code is executed
			 */
			if (username.compareTo(((User) cur.o).getUsername()) < 0)
			{
				// special case if inserting the user in the beginning of the list
				if (cur.prev == null) 
				{
					addToHead(add);
					return;
				}

				//normal case scenario (adding in the middle of the list). prev and cur references are updated
				else
				{
					DLLNode tmp = new DLLNode (add, cur.prev, cur);
					cur.prev = (cur.prev).next = tmp;
					return;
				}
			}

			//if the user with the same username already exists
			else if (username.compareTo(((User) cur.o).getUsername()) == 0)
			{
				System.out.println("The o already exists in the list");
				return;
			}

			//loop the the location to insert is found or till the end of the list is reached
			cur = cur.next;
		}

		// if the list is empty or if we reach the end of the list
		if (cur == null)	addToTail (add);
	}

	
	
	/**
	 *deleteByUsername() method deletes the user with the username specified in the method parameter,
	 *if the user exists in the list. The method is case-sensitive.
	 * @param s - username of the user we want to delete
	 */
	public void deleteByUsername (String s)
	{
		// if the list is empty return
		if (head == null) return;

		DLLNode  cur=head;		

		//while the list is not empty or while the end is not reached
		while (cur != null)
		{
			//if the user with the specified username already exists
			if (((User) cur.o).getUsername().compareTo(s) == 0)
			{
				deleteNode (cur);
				return;
			}

			//loop the the location to insert is found or till the end of the list is reached
			cur = cur.next;			
		}

		//if the end is reached
		if (cur == null)	System.out.println ("'" + s + "' o was not found in the list!");
	}

	

	/**
	 *  deleteNode() method is the "addition" to the deleteByUsername method. This method deletes 
	 * the node which contains the user with the username specified in the deleteByUsername method, 
	 * and updates the prev and next references.
	 * @param cur
	 */
	private void deleteNode (DLLNode  cur)
	{
		if (cur == null) return;

		DLLNode  next = cur.next;
		DLLNode  prev = cur.prev;

		//If there is only one item in the list
		if (prev == null && next == null) 
		{
			head = tail = null;
		}

		//if deleting the first item
		else if (prev == null) 
		{
			head = cur.next;
			head.prev = null;
		}

		//if deleting the last item
		else if (next == null) 
		{
			tail = cur.prev;
			tail.next = null;
		}

		// normal case scenario
		else 
		{
			prev.next = cur.next;
			(cur.next).prev = prev;			
		}
	}


	/**
	 * * getObject() method prints out the user info if the username equals to the one specified as a 
	 *method parameter. The method is case-sensitive.
	 * @param username
	 */
	public void getUser(String username)
	{
		if (head == null) 
		{
			System.out.println("The o with the requested title does not exist in this list. The list is empty!");
			return;
		}

		DLLNode  cur = head;

		while(cur != null && ((User) cur.o).getUsername().compareTo(username) != 0) 
		{
			cur = cur.next;
		}

		if (cur == null)
		{
			System.out.println("The o with the requested title does not exist in this list.");
		}

		else System.out.println(cur.o);
	}

	
	/**
	 * * printAscending() method prints all the users in the list in alphabetical ascending order.
	 */
	public void printAscending() 
	{
		DLLNode  cur = head;

		while (cur != null) 
		{
			System.out.println(cur.o);
			cur = cur.next;
		}		
	}


	/**
	 *printDescending() method prints all the users in the list in alphabetical descending order.
	 */
	public void printDescending() 
	{
		DLLNode  cur = tail;

		while (cur != null) 
		{
			System.out.println(cur.o);
			cur = cur.prev;
		}
	}
}