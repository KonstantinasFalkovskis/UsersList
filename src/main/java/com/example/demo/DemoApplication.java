/**
 * @Author Falco Constantine
 * @Project Users list
 * @Version 1.0
 * @Date 2018.03.17
 *
 */
package com.example.demo;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private UsersDao usersDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//test data to input to virtual Jpa data base
	@Override
	public void run(String... args) throws Exception {
		usersDao.save(new User("Admin", "root", "admin@admin.com"));
		usersDao.save(new User("user1", "pass1", "user1@users.com"));
		usersDao.save(new User("user2", "pass2", "user2@users.com"));
		usersDao.save(new User("user3", "pass3", "user3@users.com"));
		usersDao.save(new User("user4", "pass4", "user4@users.com"));
		usersDao.save(new User("user5", "pass5", "user5@users.com"));
		usersDao.save(new User("user6", "pass6", "user6@users.com"));
		usersDao.save(new User("user7", "pass7", "user7@users.com"));
		usersDao.save(new User("user8", "pass8", "user8@users.com"));
		usersDao.save(new User("user9", "pass9", "user9@users.com"));
		usersDao.save(new User("user10", "pass10", "user10@users.com"));
	}
}
