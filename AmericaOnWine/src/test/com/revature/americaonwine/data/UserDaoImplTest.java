package com.revature.americaonwine.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoImplTest {
	
	static UserDao ud;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ud = new UserHibernate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertUser() {
		assert(true, ud.insertUser());
	}

	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserByUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserByEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelUserUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelUserInt() {
		fail("Not yet implemented");
	}

}
