package com.zhuc.relation.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import com.google.common.collect.Lists;

public class UserDaoImpl implements UserDaoPlus {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private EntityManagerFactory emf;

	public void jdbc() {
		jdbcTemplate.update("insert into T_USER (name, age) values (?, ?)", new Object[] { "asd", 33 });

		List<Object[]> paramsList = Lists.newArrayList();
		paramsList.add(new Object[] { "zxc", 1 });
		paramsList.add(new Object[] { "xcv", 2 });
		paramsList.add(new Object[] { "cvb", 3 });

		jdbcTemplate.batchUpdate("insert into T_USER (name, age) values (?, ?)", paramsList);
	}

	@SuppressWarnings("unchecked")
	public void entityManager() {
		EntityManager em = emf.createEntityManager();

		//		EntityTransaction et = em.getTransaction();
		//		et.begin();
		try {
			//			Query query = em.createNativeQuery("insert into T_USER (name, age) values (?1, ?2)");
			//			query.setParameter(1, "bbb");
			//			query.setParameter(2, 10);
			//			query.executeUpdate();

			Query query2 = em.createNativeQuery("select name, age from T_USER t");
			List<Object[]> list = query2.getResultList();
			for (Object[] objects : list) {
				System.out.println(Arrays.toString(objects));
			}

			//			et.commit();
		} catch (Exception e) {
			logger.error("", e);

		} finally {
			EntityManagerFactoryUtils.closeEntityManager(em);
		}

	}

}
