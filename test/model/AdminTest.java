/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob
 */
public class AdminTest
{
	
	public AdminTest()
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
	 * Test of Login method, of class Admin.
	 */
	@Test
	public void testLogin() throws Exception
	{
		System.out.println("Login");
		String username = "Admin";
		String password = "Admin";
		Admin instance = new Admin();

		
		Admin result = instance.Login(username, password);
		assertNotNull(result);
	}

	/**
	 * Test of saveToDatabase method, of class Admin.
	 */
	@Test
	public void testSaveToDatabase() throws Exception
	{
		System.out.println("Login");
		String username = "Admin";
		String password = "Admin";
		Admin instance = new Admin();

		
		Admin result = instance.Login(username, password);
		System.out.println(result.getUsername());
		assertNotNull(result);
	}

	/**
	 * Test of update method, of class Admin.
	 */
	@Test
	public void testUpdate()
	{
		System.out.println("update");
		Admin instance = new Admin();
		Admin expResult = null;
		Admin result = instance.update();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of delete method, of class Admin.
	 */
	@Test
	public void testDelete()
	{
		System.out.println("delete");
		int userid = 0;
		Admin instance = new Admin();
		Admin expResult = null;
		Admin result = instance.delete(userid);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUserDetails method, of class Admin.
	 */
	@Test
	public void testGetUserDetails()
	{
		System.out.println("getUserDetails");
		int user_id = 0;
		Admin instance = new Admin();
		Admin expResult = null;
		Admin result = instance.getUserDetails(user_id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllUsers method, of class Admin.
	 */
	@Test
	public void testGetAllUsers()
	{
		System.out.println("getAllUsers");
		Admin instance = new Admin();
		ArrayList<Admin> expResult = null;
		ArrayList<Admin> result = instance.getAllUsers();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of updateUser method, of class Admin.
	 */
	@Test
	public void testUpdateUser()
	{
		System.out.println("updateUser");
		Admin instance = new Admin();
		Admin expResult = null;
		Admin result = instance.updateUser();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteUser method, of class Admin.
	 */
	@Test
	public void testDeleteUser()
	{
		System.out.println("deleteUser");
		int user_id = 0;
		Admin instance = new Admin();
		boolean expResult = false;
		boolean result = instance.deleteUser(user_id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUser_id method, of class Admin.
	 */
	@Test
	public void testGetUser_id()
	{
		System.out.println("getUser_id");
		Admin instance = new Admin();
		int expResult = 0;
		int result = instance.getUser_id();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setUser_id method, of class Admin.
	 */
	@Test
	public void testSetUser_id()
	{
		System.out.println("setUser_id");
		int user_id = 0;
		Admin instance = new Admin();
		instance.setUser_id(user_id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getF_name method, of class Admin.
	 */
	@Test
	public void testGetF_name()
	{
		System.out.println("getF_name");
		Admin instance = new Admin();
		String expResult = "";
		String result = instance.getF_name();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setF_name method, of class Admin.
	 */
	@Test
	public void testSetF_name()
	{
		System.out.println("setF_name");
		String f_name = "";
		Admin instance = new Admin();
		instance.setF_name(f_name);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getL_name method, of class Admin.
	 */
	@Test
	public void testGetL_name()
	{
		System.out.println("getL_name");
		Admin instance = new Admin();
		String expResult = "";
		String result = instance.getL_name();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setL_name method, of class Admin.
	 */
	@Test
	public void testSetL_name()
	{
		System.out.println("setL_name");
		String l_name = "";
		Admin instance = new Admin();
		instance.setL_name(l_name);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEmail method, of class Admin.
	 */
	@Test
	public void testGetEmail()
	{
		System.out.println("getEmail");
		Admin instance = new Admin();
		String expResult = "";
		String result = instance.getEmail();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setEmail method, of class Admin.
	 */
	@Test
	public void testSetEmail()
	{
		System.out.println("setEmail");
		String email = "";
		Admin instance = new Admin();
		instance.setEmail(email);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUsername method, of class Admin.
	 */
	@Test
	public void testGetUsername()
	{
		System.out.println("getUsername");
		Admin instance = new Admin();
		String expResult = "";
		String result = instance.getUsername();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setUsername method, of class Admin.
	 */
	@Test
	public void testSetUsername()
	{
		System.out.println("setUsername");
		String username = "";
		Admin instance = new Admin();
		instance.setUsername(username);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProfile_pic method, of class Admin.
	 */
	@Test
	public void testGetProfile_pic()
	{
		System.out.println("getProfile_pic");
		Admin instance = new Admin();
		String expResult = "";
		String result = instance.getProfile_pic();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProfile_pic method, of class Admin.
	 */
	@Test
	public void testSetProfile_pic()
	{
		System.out.println("setProfile_pic");
		String profile_pic = "";
		Admin instance = new Admin();
		instance.setProfile_pic(profile_pic);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPassword method, of class Admin.
	 */
	@Test
	public void testGetPassword()
	{
		System.out.println("getPassword");
		Admin instance = new Admin();
		String expResult = "";
		String result = instance.getPassword();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setPassword method, of class Admin.
	 */
	@Test
	public void testSetPassword()
	{
		System.out.println("setPassword");
		String password = "";
		Admin instance = new Admin();
		instance.setPassword(password);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getBio method, of class Admin.
	 */
	@Test
	public void testGetBio()
	{
		System.out.println("getBio");
		Admin instance = new Admin();
		String expResult = "";
		String result = instance.getBio();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setBio method, of class Admin.
	 */
	@Test
	public void testSetBio()
	{
		System.out.println("setBio");
		String bio = "";
		Admin instance = new Admin();
		instance.setBio(bio);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of updateDatabase method, of class Admin.
	 */
	@Test
	public void testUpdateDatabase()
	{
		System.out.println("updateDatabase");
		int UserID = 0;
		String f_name = "";
		String l_name = "";
		String email = "";
		String username = "";
		String profile_pic = "";
		String password = "";
		String bio = "";
		Admin instance = new Admin();
		Admin expResult = null;
		Admin result = instance.updateDatabase(UserID, f_name, l_name, email, username, profile_pic, password, bio);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
