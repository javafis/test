var haveLogined = false;
function unameKeydown(el, e) {
	haveLogined = false;
	if (el.value == '请输入您的帐号') {
		el.style.color = '#000000';
		el.value = '';
		Ext.getDom('msgTip').innerHTML = '';
	}
	var key = window.event ? e.keyCode : e.which;
	if (key == 13) {
		if (el.value != '') {
			Ext.getDom('password').focus();
		}
		// 如果提供了事件对象，则这是一个非IE浏览器
		if (e && e.preventDefault) {
			// 阻止默认浏览器动作(W3C)
			e.preventDefault();
		} else {
			// IE中阻止函数器默认动作的方式
			window.event.returnValue = false;
			return false;
		}
		if (e && e.stopPropagation) {
			e.stopPropagation();
		} else {
			return false;
		}
	}
}

function unameBlur(el, e) {
	if (el.value == '') {
		el.value = '请输入您的帐号';
		el.style.color = '#979797';
	}
}

function passKeydown(el, e) {
	haveLogined = false;
	Ext.getDom('msgTip').innerHTML = '';
	var key = window.event ? e.keyCode : e.which;
	if (key == 13) {
		if (el.value != '') {
			Ext.getDom('valNumber').focus();
		}
		// 如果提供了事件对象，则这是一个非IE浏览器
		if (e && e.preventDefault) {
			// 阻止默认浏览器动作(W3C)
			e.preventDefault();
		} else {
			// IE中阻止函数器默认动作的方式
			window.event.returnValue = false;
			return false;
		}
		if (e && e.stopPropagation) {
			e.stopPropagation();
		} else {
			return false;
		}
	}
}


function valNumberKeydown(el, e) {
	haveLogined = false;
	Ext.getDom('msgTip').innerHTML = '';
	var key = window.event ? e.keyCode : e.which;
	if (key == 13) {
		if (el.value != '') {
			check();
		}
		// 如果提供了事件对象，则这是一个非IE浏览器
		if (e && e.preventDefault) {
			// 阻止默认浏览器动作(W3C)
			e.preventDefault();
		} else {
			// IE中阻止函数器默认动作的方式
			window.event.returnValue = false;
			return false;
		}
		if (e && e.stopPropagation) {
			e.stopPropagation();
		} else {
			return false;
		}
	}
}


function check() {
	if(haveLogined){
		return;
	}
	haveLogined = true;
	var uname = Ext.getDom('username');
	var pass = Ext.getDom('password');
	var code = Ext.getDom('valNumber');
	var check = true;
	//去掉验证码
	/*if (code.value == '') {
		code.focus();
		Ext.getDom('msgTip').innerHTML = '验证码不能为空';
		check = false;
	}*/
	if (uname.value == '请输入您的帐号' || uname.value == '') {
		uname.focus();
		Ext.getDom('msgTip').innerHTML = '用户名不能为空';
		check = false;
	}
	if (pass.value == '') {
		if (check) {
			pass.focus();
		}
		Ext.getDom('msgTip').innerHTML = '密码不能为空';
		check = false;
	}
	if (check) {
		/*Ext.getDom('loginbtn').disabled = true;*/
		Ext.fly('bdwrap').setOpacity(0, {
			duration : .35,
			easing : 'easeOut',
			callback : function() {
				Ext.getDom('loading-msg').innerHTML = '验证用户...';
				Ext.fly('loading-mask').show();
				Ext.fly('loading-mask').setOpacity(1, {
					duration : .35,
					easing : 'easeIn',
					callback : function() {
						Ext.Ajax.request({
							url : 'account/userLogin.action',
							form : 'loginForm',
							success : function(response, opts) {
								var rObj = Ext.decode(response.responseText);
								if (rObj.errormsg) {
									Ext.getDom('msgTip').innerHTML = rObj.errormsg;
									Ext.getDom('loading-msg').innerHTML = rObj.errormsg+ '...';
									haveLogined = false;
								} else {
									Ext.getDom('loading-msg').innerHTML = '登陆成功';
									// 设定Cookie值
									var gCookieExpDays = 0;
									function setCookie(name, value) {
										var argv = setCookie.arguments;
										var argc = setCookie.arguments.length;
										var expires = (argc > 2)? argv[2]: null;
										if (expires != null) {
											var LargeExpDate = new Date();
											LargeExpDate.setTime(LargeExpDate.getTime()+ (expires * 1000* 3600 * 24));
										}
										document.cookie = name
												+ "="
												+ escape(value)
												+ ((expires == null)? ""
														: ("; expires=" + LargeExpDate.toGMTString()));
									}
									var operator  = Ext.encode(rObj.operator);
									setCookie('b5m_operator',operator);
									//...
									//权限字符串
									//增加项
									window.location = 'index.html';
									Ext.getDom('msgTip').innerHTML = '';
								}
							},
							failure : function(response, opts) {
								Ext.getDom('msgTip').innerHTML = '连接服务器错误!';
								haveLogined = false;
							},
							callback : function() {
								Ext.getDom('loginbtn').disabled = false;
								showlogin();
							}
						});
					}
				});
			},
			scope : this
		});
	}
}
function showlogin() {
	Ext.fly('loading-mask').setOpacity(0, {
				duration : .35,
				easing : 'easeOut',
				callback : function() {
					Ext.fly('loading-mask').hide();
					Ext.getDom('loading-msg').innerHTML = '验证用户...';
					Ext.fly('bdwrap').setOpacity(1, {
								duration : .35,
								easing : 'easeOut',
								callback : function() {
								}
							});
				},
				scope : this
			});
};

Ext.onReady(function(){
	var bodyHeight = document.body.clientHeight; //网页可见区域高：
	var wrapTop = bodyHeight/2-125;
	document.getElementById("wrap").style.top = wrapTop+'px';
	document.body.onresize = function(){
		var bodyHeight = document.body.clientHeight; //网页可见区域高：
		var wrapTop = bodyHeight/2-125;
		document.getElementById("wrap").style.top = wrapTop+'px';
	};
	Ext.getDom('username').focus();
});
