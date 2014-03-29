package com.huskar.enums;


/**
 * 
 * <p>title:</p>
 * <p>Description:</p>
 * <p>copyright:copyright (c)rdaschina 2007-2011</p>
 * <p>Company:rdaschina.com</p>
 * @time 2011-2-24:上午10:28:33
 * @author tonny.cao
 * @version 3.0
 */
//TODO 有一部份是从数据库里读出来的 这里有重复定义问题
public enum DistrictType implements GeneralEnum{
	西湖区(0),上城区(1),拱墅区(2),芦园(3),江干区(4),下城区(5),余杭区(6),萧山区(7),滨江区(8),下沙区(9),之江区(11),
	主城区(12),七城区(13),八城区(14);

	private int value;

	private DistrictType(int value) {
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
	
	public static DistrictType getDistrictType(int v){
		switch(v){

		case 0 :return 西湖区;
		case 1 :return 上城区;
		case 2 :return 拱墅区;
		case 4 :return 江干区;
		case 5 :return 下城区;
		case 6 :return 余杭区;
		case 7 :return 萧山区;
		case 8 :return 滨江区;
		case 9 :return 下沙区;
		case 11 :return 之江区;
		default: return null;
		}
	}
}
