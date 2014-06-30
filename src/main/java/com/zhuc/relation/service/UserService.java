package com.zhuc.relation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Optional;
import com.zhuc.relation.dao.UserDao;
import com.zhuc.relation.entity.User;

import java.util.Random;

@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserService {

	@Autowired
	private UserDao userDao;

	public void save() throws Exception {
		userDao.jdbc();

		User u = new User("-2", -2);
		userDao.save(u);

		Optional<User> opUser = Optional.of(userDao.findOne(u.getId()));
		System.out.println(opUser.isPresent());

		//		throw new RuntimeException("RuntimeException"); //默认RuntimeException下事务会回滚
		//		throw new Exception("Exception"); //Exception下事务不会回滚, 需要rollbackFor=Exception.class
	}

	public void cascade() {
		User u = new User("-4", new Random().nextInt(100));
		userDao.save(u);

		userDao.cascade(u.getId(), "ext4");
	}
}
