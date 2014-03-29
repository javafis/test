package com.huskar.enums;

/**
 * 
 * <p>title:</p>
 * <p>Description:</p>
 * <p>copyright:copyright (c)rdaschina 2007-2011</p>
 * <p>Company:rdaschina.com</p>
 * @time 2011-3-7:下午02:00:06
 * @author tonny.cao
 * @version 3.0
 */
public enum UserType implements GeneralEnum{
	试用(0), 用户(1),特殊授权(2),管理员(3);

	private int value;

	private UserType(int value) {
		this.value = value;
	}

	public int toInt() {
		return value;
	}
	
	public int getValue(){
		return value;
	}
	
	public String getEnumName(){
		if (value==-1) return "";
		else return this.name();
	}
	
	public static UserType getUserType(int v){
		switch(v){
			case 0: return 试用;
			case 1: return 用户;
			case 2: return 特殊授权;
			case 3: return 管理员;
		default: return null;
		}
	}
}
