import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import stringAnalyzer.Analyzer;

/**
 * Required JUnit Testings (2 per member)
 * @author Kay
 * Testing of 
 */

public class JUnuitTestingKay {

	@BeforeClass
	// This method is called only once at the beginning, each time JUnit is run.
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass: Preparing to run unit tests...\n");
	}

	@AfterClass
	// This method is called only once at the end, each time JUnit is run.
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass:Exiting unit tests...\n");
	}

	@Before
	// This method is called right before each individual @Test method,
	// but AFTER the class constructor is called.
	public void setUp() throws Exception {
		System.out.println("setUp:Starting a test\n");
	}

	@After
	// This method is called right after each individual @Test method.
	public void tearDown() throws Exception {
		System.out.println("tearDown:Test complete\n\n");
	}

	//Test saveData function in ReserveAFieldGUI constructor
	@Test
	public void testNullString() {
		try {
			ReserveAFieldGUI a = new ReserveAFieldGUI(); 
			a.saveData(null);				// pass in null string
			} 
		catch( Exception e) {
			// should arrive here if the exception is properly thrown
			return;
			}
		fail("Expected Exception on call to saveData(null)"); // fail the test
	}
	
	@Test
	// ----------------------------------------------------------------------------------
	//Implement this unit test to verify that the saveData function in ReserveAFieldGUI()
	//works for a "regular" string argument
	public void testNormalConstruction() {
		try {
			ReserveAFieldGUI a = new ReserveAFieldGUI(); 
			a.saveData("test string");				// pass in a string
			} 
		catch( Exception e) {
			fail("Expected Exception on call to saveData(test string)"); // fail the test
			return;
			}
			// passes the test
	}
	
	@Test
	public void testEmptyConstruction() {
		try {
			ReserveAFieldGUI a = new ReserveAFieldGUI(); 
			a.saveData("");				// pass in a string
			} 
		catch( Exception e) {
			fail("Expected Exception on call to saveData()"); // fail the test
			return;
			}
			// passes the test
	}
	
	@Test
	// ----------------------------------------------------------------------------------
	//Implement this unit test to verify that the deleteData function in MyReservationGUI
	//works for a "regular" string argument

	public void testNormalConstruction2() {
		try {
			MyReservationGUI a = new MyReservationGUI(); 
			a.deleteData("a", "b", 0);				// pass in strings and integer
			} 
		catch( Exception e) {
			fail("Expected Exception on call to deleteData()"); // fail the test
			return;
			}
			// passes the test
	}
	
	@Test
	public void testEmptyConstruction2() {
		try {
			MyReservationGUI a = new MyReservationGUI(); 
			a.deleteData("","", 1);				// pass in empty strings and an integer
			} 
		catch( Exception e) {
			fail("Expected Exception on call to deleteData()"); // fail the test
			return;
			}
			// passes the test
	}
}
