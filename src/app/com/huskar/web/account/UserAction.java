package com.huskar.web.account;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.web.struts2.Struts2Utils;

import com.huskar.entity.account.MemoryOperator;
import com.huskar.entity.account.User;
import com.huskar.service.account.AccountManager;
import com.huskar.util.Constants;
import com.huskar.web.CrudActionSupport;


/**
 * 用户管理Action.
 */
//定义URL映射对应/account/user.action
@Namespace("/account")
public class UserAction extends CrudActionSupport<User>{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Autowired
	private AccountManager accountManager;
	
	@Action("listUser")
	public void listUser(){
		List<User> userList = accountManager.listUser();
		_jsonresult.put("list",userList);
		Struts2Utils.renderJson(userList);
	}
	
	@Action("userLogin")
	public String login(){
		MemoryOperator operator  = new MemoryOperator();
		User user = (User) accountManager.getUserByName(username);
		if(user ==  null){
			_jsonresult.put(_success,_false);
			_jsonresult.put(_errormsg,"不存在用户名");
		}else{
			if(!password.equals(user.getPassword())){
				_jsonresult.put(SUCCESS,_false);
				_jsonresult.put(_errormsg,"用户密码错误");
			}else{
				operator.setUserName(username);
				operator.setPassword(password);
				this.getSession().put(Constants.OPERATOR_KEY,operator);
				_jsonresult.put(Constants.OPERATOR_KEY,operator);
				_jsonresult.put(_success,_true);
			}
		}
		Struts2Utils.renderJson(_jsonresult);
		return null;
	}
	
	
	@Override
	public String list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String input() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
