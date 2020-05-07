package model;

import repository.DatabaseUtilityClass;
import java.sql.Connection;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob
 */
public class DatabaseUtilityClassTest
{
	
	public DatabaseUtilityClassTest()
	{
	}
	
	@BeforeClass
	public static void setUpClass()
	{
	}
	
	@Before
	public void setUp()
	{
	}

	/**
	 * Test of getConnection method, of class DatabaseUtilityClass.
	 */
	@Test
	public void testGetConnection()
	{
		System.out.println("getConnection");
		Connection result = DatabaseUtilityClass.getConnection();
		assertNotNull(result);
	}
	//TODO:dfkjghdf
}
