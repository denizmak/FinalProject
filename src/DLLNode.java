/*
 * Deni Zmak
 * SE 300 - Fall 2014
 * Final Project: ERAU Athletics Fan App
 * 11/18/14
 */

/**
 * DLLNode class defines a DLLNode. It creates a "container" in which the user is able to store the
 * object and updates references to previous and/or next nodes if they exist.
 * The class consists three constructors and two methods.
 */
public class DLLNode
{
	// class variables
	protected Object o;
	public DLLNode next;
	public DLLNode prev;
	protected User user;


	/**
	 * Default no-argument constructor
	 */
	public DLLNode()
	{
		next = prev = null;
	}



	/**Constructor that creates a new node and stores object in that node
	 * @param o - any object
	 */
	public DLLNode(Object o)
	{
		this.o = o;
		next = prev = null;
	}


	/**
	 * Constructor that creates a new node, stores an object in it, and updates the prev and next references
	 * @param o - any object
	 * @param prev - DLLNode
	 * @param next - DLLNode
	 */
	public DLLNode(Object o, DLLNode prev, DLLNode next)
	{
		this(o);
		this.prev = prev;
		this.next = next;
	}
}