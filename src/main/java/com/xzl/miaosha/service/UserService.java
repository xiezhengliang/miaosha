package com.xzl.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xzl.miaosha.dao.UserDao;
import com.xzl.miaosha.domain.User;

/**
 * @author xiezhengliang
 * @date 2018年11月5日 下午4:34:14
 */
@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public User getById(int id) {
		return userDao.getById(id);
	}

	@Transactional
	public boolean tx() {
		User u1 = new User();
		u1.setId(2);
		u1.setName("abc");
		userDao.insert(u1);
		User u2 = new User();
		u2.setId(1);
		u2.setName("cba");
		userDao.insert(u2);

		return true;
	}
}
