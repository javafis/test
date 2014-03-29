package com.huskar.web;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.modules.orm.Page;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;

/**
 * Struts2中典型CRUD Action的抽象基类.
 * 
 * 主要定义了对Preparable,ModelDriven接口的使用,以及CRUD函数和返回值的命名.
 * 
 * @param <T>
 *            CRUDAction所管理的对象类型.
 */
@SuppressWarnings("serial")
public abstract class CrudActionSupport<T> extends ActionSupport implements ModelDriven<T>, Preparable {

	//中转页提示信息
	private String _message ="";
	//中转页目的
	private String _forwardURL ="";
	private int page;//当前页
	private int rows;//当前页大小
	private String sort;
	private String order;
    //用于统一存放ajax json result
	public HashMap<String,Object> _jsonresult = new HashMap<String,Object>();
	public static String _success = "success";
	public static String _errormsg = "errormsg";
	public static boolean _true = true;
	public static boolean _false = false;

	private Page pageParam = new Page();

	public Page getPageParam() {
		return pageParam;
	}

	public void setPageParam(Page pageParam) {
		this.pageParam = pageParam;
	}

	/** 进行增删改操作后,以redirect方式重新打开action默认页的result名. */
	public static final String RELOAD = "reload";

	protected Logger logger = LoggerFactory.getLogger(getClass());


	/**
	 * Action函数, 默认的action函数, 默认调用list()函数.
	 */
	@Override
	public String execute() throws Exception {
		return list();
	}

	// -- CRUD Action函数 --//
	/**
	 * Action函数,显示Entity列表界面. 建议return SUCCESS.
	 */
	public abstract String list() throws Exception;

	/**
	 * Action函数,显示新增或修改Entity界面. 建议return INPUT.
	 */
	@Override
	public abstract String input() throws Exception;

	/**
	 * Action函数,新增或修改Entity. 建议return RELOAD.
	 */
	public abstract String save() throws Exception;

	/**
	 * Action函数,删除Entity. 建议return RELOAD.
	 */
	public abstract String delete() throws Exception;

	// -- Preparable函数 --//
	/**
	 * 实现空的prepare()函数,屏蔽所有Action函数公共的二次绑定.
	 */
	public void prepare() throws Exception {
	}

	/**
	 * 在input()前执行二次绑定.
	 */
	public void prepareInput() throws Exception {
		prepareModel();
	}

	/**
	 * 在save()前执行二次绑定.
	 */
	public void prepareSave() throws Exception {
		prepareModel();
	}

	/**
	 * 等同于prepare()的内部函数,供prepardMethodName()函数调用.
	 */
	protected abstract void prepareModel() throws Exception;

	/**
	 * 取得自定义语言
	 */
	protected Locale getSessionLocale() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session == null) {
			return null;
		} else {
			Locale locale = (Locale) session
					.get(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE);
			if (locale == null) {
				locale = ServletActionContext.getRequest().getLocale();
				setSessionLocale(locale);
				return locale;
			} else {
				return locale;
			}
		}
	}

	protected void setSessionLocale(Locale locale) {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
	}
 
	public String get_message() {
		return _message;
	}

	public void set_message(String _message) {
		this._message = _message;
	}

	public String get_forwardURL() {
		return _forwardURL;
	}

	public void set_forwardURL(String _forwardURL) {
		this._forwardURL = _forwardURL;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		pageParam.setOrderBy(sort);
		this.sort = sort;
	}
	 public int getPage() {
			return page;
	}

	public void setPage(int page) {
		pageParam.setPageNo(page);
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		pageParam.setPageSize(rows);
		this.rows = rows;
	}
	
    public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		pageParam.setOrder(order);
		this.order = order;
	}
	
	public Map<String,Object> getSession(){
		return ActionContext.getContext().getSession();
	}
	
}
