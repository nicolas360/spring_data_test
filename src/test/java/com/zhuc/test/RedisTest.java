package com.zhuc.test;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.alibaba.fastjson.JSON;
import com.zhuc.bicycle.RedisConstants;
import com.zhuc.redis.ElectricBicycle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class RedisTest {

	private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

	@Autowired
	private JedisPool jedisPool;

	@Test
	public void save() {
		Jedis jedis = jedisPool.getResource();
		try {
			ElectricBicycle eb = new ElectricBicycle();
			eb.setId(80l);
			eb.setDeviceNo("TEST123456");
			eb.setCarOwnerName("测试电动车");
			eb.setImsi("460024021037246");
			DateTime dt = new DateTime();
			eb.setServiceStartDate(dt.toDate());
			eb.setServiceEndDate(dt.yearOfCentury().addToCopy(4).toDate());
			eb.setSimNo("18402133508");
			eb.setMail("15921006788@139.com");
			eb.setTelephone("15921006788");

			logger.debug("爱上大声地");

//			jedis.set(eb.getDeviceNo() + RedisConstants.RELATION_SUFFIX, JSON.toJSONString(eb));

		} catch (Exception e) {
			logger.error("", e);
		} finally {
			jedisPool.returnResource(jedis);
		}

	}
}
