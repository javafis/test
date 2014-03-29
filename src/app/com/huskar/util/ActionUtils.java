package com.huskar.util;
import javax.servlet.http.HttpServletRequest;
import com.huskar.entity.account.MemoryOperator;
/**
 * 
 *文件名称：ActionUtils.java
 *
 *文件标识：
 *
 *摘 要：
 *
 *
 *当前版本：1.0
 *
 *作 者：cst
 *
 *完成日期：2012-5-8
 *
 */
public class ActionUtils {
	/**
	 * 
	 * @param request
	 * @return
	 * @return MemoryOperator
	 * @throws
	 */
	public static MemoryOperator getCurrentOperator(HttpServletRequest request) {
		MemoryOperator memoryOperator = (MemoryOperator) request.getSession().getAttribute(Constants.OPERATOR_KEY);
		return memoryOperator;
	}

}
