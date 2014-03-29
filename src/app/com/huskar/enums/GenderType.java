package com.huskar.enums;

/**
 * <p>title:</p>
 * <p>Description:</p>
 * <p>copyright:copyright (c)rdaschina 2007-2011</p>
 * <p>Company:rdaschina.com</p>
 * @time 2011-2-24:上午10:29:06
 * @author tonny.cao
 * @version 3.0
 */
public enum GenderType implements GeneralEnum{
	男(0),女(1);

	private int value;
	
	private GenderType(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public int toInt() {
		return value;
	}
	
	public static GenderType getGenderType(int v){
		switch(v){
			case 0 : return 男;
			case 1 : return 女;
			default:return null;
		}
	}
	
}

