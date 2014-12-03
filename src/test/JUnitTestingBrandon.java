import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Required JUnit Testings (2 per member)
 * @author Brandon
 */
public class JUnitTestingBrandon
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
	//Testing Hyperlink constructor (Brandon Antosh)
	@Test
	// TODO: Implement this unit test to verify that the Hyperlink constructor works for a "regular" string argument
	public void testNormalConstruction() 
	{
		System.out.println ("Running normal constructor test (Hyperlink)...");
		
		try
		{
			Hyperlink test = new Hyperlink ("test", "https://www.google.com/");
		} 

		catch (Exception e)
		{
			fail ("Expected Exception on call to Hyperlink (null)"); // fail the test
		}
	}
	
	@Test
	// TODO: Implement this unit test to verify that the Hyperlink constructor works for a empty string argument
	public void testEmptyStringConstruction() 
	{
		System.out.println ("Running empty string constructor test (Hyperlink)...");
		
		try
		{
			Hyperlink test = new Hyperlink ("", "");
		} 

		catch (Exception e)
		{
			fail ("Expected Exception on call to Hyperlink (null)"); // fail the test
		}
	}
	
	@Test
	// TODO: Implement this unit test to verify that the Hyperlink constructor works for a null string argument
	public void testNullConstruction() 
	{
		System.out.println ("Running null constructor test (Hyperlink)...");
		
		try
		{
			Hyperlink test = new Hyperlink (null, null);
		} 

		catch (Exception e)
		{
			fail ("Expected Exception on call to Hyperlink (null)"); // fail the test
		}
	}
	
	@Test
	// TODO: Implement this unit test to verify that the Hyperlink constructor works for no argument
	public void testNoImputConstruction() 
	{
		System.out.println ("Running null constructor test (Hyperlink)...");
		
		try
		{
			Hyperlink test = new Hyperlink ();
		} 

		catch (Exception e)
		{
			fail ("Expected Exception on call to Hyperlink (null)"); // fail the test
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	//Testing SportsMenu constructor (Brandon Antosh)
	@Test
	// TODO: Implement this unit test to verify that the Hyperlink constructor works for no argument
	public void testSportsMenuConstruction() 
	{
		System.out.println ("Running normal constructor test (Hyperlink)...");
		
		try
		{
			SportsMenu test = new SportsMenu ();
		} 

		catch (Exception e)
		{
			fail ("Expected Exception on call to SportsMenu (null)"); // fail the test
		}
	}
}
