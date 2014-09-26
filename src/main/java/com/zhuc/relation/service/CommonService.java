package com.zhuc.relation.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Optional;
import com.zhuc.relation.dao.AirLineDao;
import com.zhuc.relation.dao.UserDao;
import com.zhuc.relation.entity.AirLine;
import com.zhuc.relation.entity.AirLinePK;
import com.zhuc.relation.entity.User;

@Service("commonService")
@Transactional(rollbackFor = Exception.class)
public class CommonService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private AirLineDao airLineDao;

	public AirLine findAirLine(AirLinePK pk) {
		return airLineDao.findOne(pk);
	}

	public void saveAirLine(AirLine line) {
		airLineDao.save(line);
	}

	public void saveUser() throws Exception {
		userDao.jdbc();

		User u = new User("-2", -2);
		userDao.save(u);

		Optional<User> opUser = Optional.of(userDao.findOne(u.getId()));
		System.out.println(opUser.isPresent());

		//		throw new RuntimeException("RuntimeException"); //默认RuntimeException下事务会回滚
		//		throw new Exception("Exception"); //Exception下事务不会回滚, 需要rollbackFor=Exception.class
	}

	public void cascadeUser() {
		User u = new User("-4", new Random().nextInt(100));
		userDao.save(u);

		userDao.cascade(u.getId(), "ext4");
	}
}
