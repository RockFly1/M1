/**
 * 
 */
package com.chinvaventure.m.web.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinvaventure.m.emnus.DelFlag;
import com.chinvaventure.m.model.User;
import com.chinvaventure.m.service.UserService;
import com.chinvaventure.m.util.CookiesUtil;

/**
 * 登陆action
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/Login")
public class LoginAction {
	public static final String USER_SESSION = "user.session";
	private final Logger log = Logger.getLogger(LoginAction.class);
	
	@Autowired
	private UserService userService;

	// 自动登录
	@RequestMapping(value = "/autoLg")
	public String AutoLg(HttpServletRequest request) {
		CookiesUtil cookiesUtil = new CookiesUtil();
		if (cookiesUtil.getCookie(request, userService)) {
			return "x1/Index";
		} else {
			return "Login/Login";
		}
	}

	// 登陆
	@SuppressWarnings("unused")
	@RequestMapping(value = "/lg")
	public String LoginPage(HttpServletRequest request,
			HttpServletResponse response, @Param("userName") String userName,
			@Param("userPassword") String userPassword,
			@Param("rememberPwd") String rememberPwd) throws Exception {
		if (userName != null && !"".equals(userName) && userPassword != null
				&& !"".equals(userPassword)) {// 判断传值，查询用户信息
			User user = userService.selectByName(userName, userPassword);
			if (user != null && userPassword.equals(user.getUserPassword())) {
				CookiesUtil cookiesUtil = new CookiesUtil();
				if ("y".equals(rememberPwd)) {
					Cookie cookie = cookiesUtil.addCookie(user);
					response.addCookie(cookie);
				}
				// seesion.put(USER_SESSION, user);
				return "x1/Index";
			} else {// 错误返回登陆页面
				log.debug("------------用户名或密码错误！-----------------");
				request.setAttribute("error", "用户名或密码错误！");
				return "Login/Login";
			}
		} else {// 空值返回登陆页面
			log.debug("------------用户名空值-----------------");
			return "Login/Login";
		}

	}

	// 注册用户
	@RequestMapping(value = "/ru")
	public String RegisterUser(HttpServletRequest request,
			@Param("user") User user) {
		// 判断数据是否为空
		if (user.getUserName() != null) {
			// 删除标记
			user.setDelFlag(DelFlag.noDelete.getValue());
			// 插入接口
			userService.insertUser(user);
			log.debug("-----------------用户信息已写入！------------");
		}

		return "Login/Register";
	}

	// 忘记密码
	@RequestMapping(value = "/backPd")
	public String backPassword(HttpServletRequest request,
			@Param("userEamil") String userEamil,
			@Param("userName") String userName) {
		
		
		return null;
	}

}
