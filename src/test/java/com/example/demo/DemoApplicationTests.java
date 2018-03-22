/**
 * @Author Falco Constantine
 * @Project Users list
 * @Version 1.0
 * @Date 2018.03.22
 *
 */
package com.example.demo;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UsersDao usersDao;

	//test for User list add/ipdate/delete functions
	@Test
	public void testNewUser() {
		User user = new User("testUser", "123", "test@gmail.com");
		usersDao.save(user);
		assertNotNull(user);
		assertEquals(user.getUsername(), "testUser");
		assertEquals(user.getPassword(), "123");
		assertEquals(user.getEmail(), "test@gmail.com");
	}

	@Test
	public void testUserUpdate() {
		User user = new User("testAdmin", "root", "admin@admin.com");
		assertNotNull(user);
		if (user.getUsername() == "testAdmin") {
			user = new User("testAdmin123", "root", "admin@admin.com");
			usersDao.save(user);
			assertNotNull(user);
			assertEquals(user.getUsername(), "testAdmin123");
		}
	}

	@Test
	public void testUserRemove() {
		User user = new User("test", "test", "test@gmail.com");
		assertNotNull(user);
		assertEquals(user.getUsername(), "test");
		if (user.getId() != null) {
			user = new User("", "", "");
			usersDao.save(user);
			assertNull(user);
			assertEquals(user.getUsername(), "");
		}
	}

}
