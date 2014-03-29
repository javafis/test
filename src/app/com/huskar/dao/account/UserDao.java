package com.huskar.dao.account;

import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

import com.huskar.entity.account.User;

/**
 * 用户对象的泛型DAO类.
*/
@Component
public class UserDao extends HibernateDao<User, Long> {
	
}
