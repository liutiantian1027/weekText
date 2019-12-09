package com.liutiantian.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liutiantian.beans.User;
import com.ltt.utils.UserUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Redis.xml")
public class TestUser {
	
	@SuppressWarnings("rawtypes")
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	//使用jdk的序列化方式执行
	@Test
	public void UserTest() {
		long start = System.currentTimeMillis();
		for (int i = 1; i <= 50000; i++) {
			User user = new User();
			user.setId(i);
			user.setName(UserUtils.getName());
			user.setGender(UserUtils.getSex());
			user.setPhoneNum(UserUtils.getPhone());
			user.setEmail(UserUtils.getMail());
			user.setBirthday(UserUtils.getBirthday());
			redisTemplate.opsForValue().set("user"+i, user);
			System.out.println(user);
		}
		long end = System.currentTimeMillis();
		System.out.println("使用jdk的序列化方式");
		System.out.println("消耗了"+(end-start)+"的时间");
		System.out.println("生成了50000条数据");
	}
	//使用json的序列化方式执行
		@SuppressWarnings("unchecked")
		@Test
		public void UserJSon() {
			long start = System.currentTimeMillis();
			for (int i = 1; i <= 50000; i++) {
				User user = new User();
				user.setId(i);
				user.setName(UserUtils.getName());
				user.setGender(UserUtils.getSex());
				user.setPhoneNum(UserUtils.getPhone());
				user.setEmail(UserUtils.getMail());
				user.setBirthday(UserUtils.getBirthday());
				redisTemplate.opsForValue().set("user"+i, user);
			}
			long end = System.currentTimeMillis();
			System.out.println("使用json的序列化方式");
			System.out.println("消耗了"+(end-start)+"的时间");
			System.out.println("生成了50000条数据");
		}
		//使用hash的序列化方式执行
			@SuppressWarnings("unchecked")
			@Test
			public void UserHash() {
				long start = System.currentTimeMillis();
				for (int i = 1; i <= 50000; i++) {
					User user = new User();
					user.setId(i);
					user.setName(UserUtils.getName());
					user.setGender(UserUtils.getSex());
					user.setPhoneNum(UserUtils.getPhone());
					user.setEmail(UserUtils.getMail());
					user.setBirthday(UserUtils.getBirthday());
					redisTemplate.opsForHash().put("users"+i, "user"+i, user.toString());
				}
				long end = System.currentTimeMillis();
				System.out.println("使用hash的序列化方式");
				System.out.println("消耗了"+(end-start)+"的时间");
				System.out.println("生成了50000条数据");
			}

	public static void main(String[] args) {
		System.out.println(UserUtils.getSex());
	}
}
