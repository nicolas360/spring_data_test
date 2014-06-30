package com.zhuc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhuc.mongo.dao.CommandDao;
import com.zhuc.mongo.entity.Command;
import com.zhuc.relation.dao.UserDao;
import com.zhuc.relation.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class SpringTest {

	@Autowired
	private UserDao userDao;

	@Autowired
	private CommandDao commandDao;

	//	@Test
	public void t2() {
		commandDao.getMt().remove(new Query(), Command.class);

		Command c = new Command();
		c.setGserverId("5000001");
		c.setPlateNo("沪A213465");
		c.setSimcardNo("13467154545");
		c.setStatus(1);
		c.setUserName("15800466847");
		c.setContent("AT+GRVO=2,,,,0015$");
		commandDao.getMt().save(c);

		long count = commandDao.getMt().count(new Query(), Command.class);
		System.out.println(count);
	}

	@Test
	@Rollback(false)
	@Transactional(rollbackFor = Exception.class)
	public void t1() {
		User u = new User();
		u.setAge(25);
		u.setName("zhuc");

		//		userDao.save(u);

		//		System.out.println(userDao.count());
		//		System.out.println(HtmlUtils.htmlEscape("&"));
		//		System.out.println(HtmlUtils.htmlUnescape("&amp;"));
		//
		//		userDao.entityManager();
		userDao.jdbc();
		try {
			throw new Exception("123");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
