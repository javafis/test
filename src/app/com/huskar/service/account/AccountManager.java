package com.huskar.service.account;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.huskar.dao.account.UserDao;
import com.huskar.entity.account.User;

/**
 * 安全相关实体的管理类, 包括用户,角色,资源与授权类.
*/

@Component("_accountManager")
//默认将类中的所有函数纳入事务管理.
@Transactional
public class AccountManager {

	private static Logger logger = LoggerFactory.getLogger(AccountManager.class);

	@Autowired
	private UserDao userDao;
	
	public List listUser(){
		List userList = new ArrayList<User>();
		userList = userDao.getAll();
		return userList;
	}

	public User getUserByName(String userName) {
		User user  = userDao.findUnique("userName", userName);
		return user;
	}

}
