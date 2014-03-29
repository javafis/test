package com.huskar.entity.account;
/**
 * 版本： @version
 */
public class MemoryOperator {
	private String userName;
	private String password;
	private String loginIP;
	private String funSetString;//权限列表
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public String getFunSetString() {
		return funSetString;
	}
	public void setFunSetString(String funSetString) {
		this.funSetString = funSetString;
	}
	
}
