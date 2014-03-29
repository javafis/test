package com.huskar.web;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.huskar.entity.account.MemoryOperator;
import com.huskar.util.ActionUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements Action{
	private static final long serialVersionUID = 1L;
	public static final String JSONRESULT = "jsonresult";
	public static final String JSONRLISTESULT = "resultlist";
	public static final String OPERATORKEY = "operator";
	public static final String SUCCESS = "success";//指令成功返回
	public static final String ERRORMSG = "errormsg";//错误信息
	public static final Boolean TRUE = true;//返回成功
	public static final Boolean FALSE = false;//返回失败
	public static final String TOTALCOUNT = "totalcount";//总记录数
	
	public Map<String,Object> resultmap = new HashMap<String,Object>(); 
	public List<Object> resultlist = new ArrayList<Object>();
	
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}

	public String getLoginIP(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getRemoteAddr();
	}
	public HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		return response;
	}
	
	public HttpSession getSession(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		return session;
	}
	
	public MemoryOperator getCurrentOperator(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return ActionUtils.getCurrentOperator(request);
	}
	
	public Map getServerApplication(){
		ActionContext context = ActionContext.getContext();
		return context.getApplication();
	} 

	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public String input() throws Exception {
		return INPUT;
	}
	
	
	public Long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}
	
	public String getRootPath(){
		 String base = ServletActionContext.getServletContext().getRealPath(File.separator);
		 return base;
	}
	
}
