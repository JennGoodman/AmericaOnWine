package com.revature.americaonwine.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.americaonwine.beans.Roles;
import com.revature.americaonwine.beans.User;

public class UserDaoImplTest {
	
	static UserDao ud;
	static User c1;
	static User r2;
	static User a3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Random r = new Random();
		ud = new UserHibernate();
		long l = r.nextLong();
		c1 = new User(100000, "testCustomer" + l, "", "testCustEmail" + l, Roles.numericalRepresentation(Roles.CUSTOMER), 1, 0);
		l = r.nextLong();
		r2 = new User(100001, "testRetailer" + l, "", "testRetailEmail" + l, Roles.numericalRepresentation(Roles.RETAILER), 1, 0);
		l = r.nextLong();
		a3 = new User(100002, "testAdmin" + l, "", "testAdminEmail" + l, Roles.numericalRepresentation(Roles.ADMIN), 1, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertUser() {
		assertEquals(true, ud.insertUser(c1));
		User u = ud.getUserByUsername(c1.getUsername());
		
		assertEquals(c1.getUsername(), u.getUsername());
		assertEquals(c1.getPassword(), u.getPassword());
		assertEquals(c1.getEmail(), u.getEmail());
		assertEquals(c1.getRole(), u.getRole());
		assertEquals(c1.getActive(), u.getActive());
		assertEquals(c1.getCancelled(), u.getCancelled());
		
		assertEquals(false, ud.insertUser(c1));
	}

	@Test
	public void testGetUser() {
		ud.insertUser(c1);
		User ubyUser = ud.getUserByUsername(c1.getUsername());
		User u = ud.getUser(ubyUser.getId());
		
		assertEquals(c1.getUsername(), u.getUsername());
		assertEquals(c1.getPassword(), u.getPassword());
		assertEquals(c1.getEmail(), u.getEmail());
		assertEquals(c1.getRole(), u.getRole());
		assertEquals(c1.getActive(), u.getActive());
		assertEquals(c1.getCancelled(), u.getCancelled());
	}

	@Test
	public void testGetUserByUsername() {
		ud.insertUser(c1);
		User u = ud.getUserByUsername(c1.getUsername());
		
		assertEquals(c1.getUsername(), u.getUsername());
		assertEquals(c1.getPassword(), u.getPassword());
		assertEquals(c1.getEmail(), u.getEmail());
		assertEquals(c1.getRole(), u.getRole());
		assertEquals(c1.getActive(), u.getActive());
		assertEquals(c1.getCancelled(), u.getCancelled());
	}

	@Test
	public void testGetUserByEmail() {
		ud.insertUser(c1);
		User u = ud.getUserByEmail(c1.getEmail());
		
		assertEquals(c1.getUsername(), u.getUsername());
		assertEquals(c1.getPassword(), u.getPassword());
		assertEquals(c1.getEmail(), u.getEmail());
		assertEquals(c1.getRole(), u.getRole());
		assertEquals(c1.getActive(), u.getActive());
		assertEquals(c1.getCancelled(), u.getCancelled());
	}

	@Test
	public void testGetAll() {
		assertEquals(true, ud.getAll() != null);
	}

	@Test
	public void testUpdateUser() {
		ud.insertUser(c1);
		c1.setActive(0);
		
		assertEquals(true, ud.updateUser(c1));
		User u = ud.getUserByEmail(c1.getEmail());
		
		assertEquals(c1.getUsername(), u.getUsername());
		assertEquals(c1.getPassword(), u.getPassword());
		assertEquals(c1.getEmail(), u.getEmail());
		assertEquals(c1.getRole(), u.getRole());
		assertEquals(c1.getActive(), u.getActive());
		assertEquals(c1.getCancelled(), u.getCancelled());
	}

	@Test
	public void testCancelUserUser() {
		ud.insertUser(c1);
		ud.cancelUser(c1);
		User u = ud.getUserByUsername(c1.getUsername());
		
		
		assertEquals(1, u.getCancelled());
	}

	@Test
	public void testCancelUserInt() {
		ud.insertUser(c1);
		ud.cancelUser(c1.getId());
		User u = ud.getUserByUsername(c1.getUsername());
		
		
		assertEquals(1, u.getCancelled());
	}

}
