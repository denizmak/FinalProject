import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Required JUnit Testings (2 per member)
 * @author Fares Almuhanna
 */
public class JUnitTestingFares 
{
	@BeforeClass
	// This method is called only once at the beginning, each time JUnit is run.
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println ("setUpBeforeClass: Preparing to run unit tests...\n");
	}


	@AfterClass
	// This method is called only once at the end, each time JUnit is run.
	public static void tearDownAfterClass() throws Exception 
	{
		System.out.println("tearDownAfterClass: Exiting unit tests...\n");
	}


	@Before
	// This method is called right before each individual @Test method, but AFTER the class constructor is called.
	public void setUp() throws Exception 
	{
		System.out.println("setUp: Starting a test");
	}


	@After
	// This method is called right after each individual @Test method.
	public void tearDown() throws Exception 
	{
		System.out.println("tearDown: Test complete\n");
	}


	//------------------------------------------------------------------------------------------------------------------------
	//Testing AddToEmail constructor of SubscriptionPanel (Fares Almuhanna)
	@Test
	// TODO: Implement this unit test to verify that the Analyzer constructor works for a "regular" string argument
	public void testNormalConstruction() 
	{
		System.out.println ("Running normal constructor test (MenuPanel)...");
		
		try
		{
			SubscriptionPanel test = new SubscriptionPanel (); // pass in String
			test.addToBaseballEmail("123@KDD.com");
		} 

		catch (Exception e)
		{
			fail ("Expected Exception on call to MenuPanel (null)"); // fail the test
		}
	}


	@Test
	// TODO: Implement this unit test to verify that the Analyzer constructor works for an empty string argument
	public void testEmptyStringConstruction() 
	{
		System.out.println ("Running empty string constructor test (MenuPanel)...");
		String s = "";
		try 
		{
			SubscriptionPanel test = new SubscriptionPanel ();
			test.addToBaseballEmail(s); 			// pass in an empty string
		} 

		catch( Exception e) 
		{
			// should arrive here if the exception is properly thrown
			fail("Expected Exception on call to MenuPanel (null)"); // fail the test
		}
	}


	@Test
	// TODO: Implement this unit test to verify that the Analyzer constructor works for an empty string argument
	public void testNullStringConstruction() 
	{
		System.out.println ("Running null string constructor test (MenuPanel)...");
		
		String s = null;
		
		try 
		{
			SubscriptionPanel test = new SubscriptionPanel ();
			test.addToBaseballEmail(s); // pass in null string
		} 

		catch( Exception e) 
		{
			// should arrive here if the exception is properly thrown
			fail("Expected Exception on call to MenuPanel (null)"); // fail the test
		}
	}
	//------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------
		//Testing Send constructor (Fares Almuhanna)
	@Test
	// TODO: Implement this unit test to verify that the Analyzer constructor works for a "regular" string argument
	public void testNormalConstruction2() 
	{
		System.out.println ("Running normal constructor test (DisplayGUI)...");
		
		try
		{
			NotificationPanel test = new NotificationPanel ();
			test.send("faars@live.com", "SE", "testNormalConstruction2()"); // pass in strings
		} 

		catch (Exception e)
		{
			fail ("Expected Exception on call to MenuPanel (null)"); // fail the test
		}
	}


	@Test
	// TODO: Implement this unit test to verify that the Analyzer constructor works for an empty string argument
	public void testEmptyStringConstruction2() 
	{
		System.out.println ("Running empty string constructor test (DisplayGUI)...");
		
		String s = null;
		try 
		{
			NotificationPanel test = new NotificationPanel ();
			test.send(s,s,s);    // empty string 
		} 

		catch( Exception e) 
		{
			// should arrive here if the exception is properly thrown
			fail("Expected Exception on call to MenuPanel (null)"); // fail the test
		}
	}


	@Test
	// TODO: Implement this unit test to verify that the Analyzer constructor works for an empty string argument
	public void testNullStringConstruction2() 
	{
		System.out.println ("Running null string constructor test (DisplayGUI)...");
		
		String s = null;
		
		try 
		{
			NotificationPanel test = new NotificationPanel ();
			test.send(s,s,s); //pass in null string
		} 

		catch( Exception e) 
		{
			// should arrive here if the exception is properly thrown
			fail("Expected Exception on call to MenuPanel (null)"); // fail the test
		}
	}
	//------------------------------------------------------------------------------------------------------------------------
}