package de.cbos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.cbos.dao.UserDAOImpl;
import de.cbos.model.User;

public class UserDAOImplTest {

	private UserDAOImpl daoImpl;
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Before
	public void setUp() throws Exception {
		daoImpl = new UserDAOImpl();
		Session session = sessionFactory.openSession();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		User user = new User();
		String userName = "TestUser";
		user.setUserName(userName);
		user.setPassword("test");
		user.setEnabled(true);
		getCurrentSession().save(user);

		daoImpl.addUser(user);

		User userGet = daoImpl.getUser(userName);
		List<User> userList = daoImpl.getUserList();

		for(User u : userList) {
			assert(u.equals(userGet));
		}
	}

}
