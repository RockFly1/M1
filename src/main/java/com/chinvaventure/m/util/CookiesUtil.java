/**
 * 
 */
package com.chinvaventure.m.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinvaventure.m.model.User;
import com.chinvaventure.m.service.UserService;
import com.chinvaventure.m.service.impl.UserServiceImpl;
import com.chinvaventure.m.web.action.LoginAction;

/**
 * cookies工具类
 * 
 * cookies的 增加 删除 查询
 * 
 * @author rock
 *
 */
public class CookiesUtil {


	
	public static final String USER_COOKIES ="user.cookies";
	
	//添加一个cookie
	public Cookie addCookie(User user){
		Cookie cookie = new Cookie(USER_COOKIES, user.getUserName()+","
						+user.getUserPassword());
		System.out.println("---------添加cookie--------------");
		cookie.setMaxAge(60*60*24*14);//cookie保存时间
		return cookie;
	}
	//得到cookie
	public boolean getCookie(HttpServletRequest request ,UserService userService){
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies"+cookies);
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				System.out.println("cookie"+cookie.getName());
				if (CookiesUtil.USER_COOKIES.equals(cookie.getName())) {
					String value = cookie.getValue();
					if (StringUtils.isNotBlank(value)) {
						String[] split = value.split(",");
						String userName = split[0];
						String userPassWord = split[1];
						User user = userService.selectByName(userName,userPassWord);
						if (user!=null) {
							HttpSession session = request.getSession();
							session.setAttribute(LoginAction.USER_SESSION, user);
							return true;
						}
					}
				}
			}
		}
		
		return false;
		
	}
	
	//删除cookie
	public Cookie delCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (USER_COOKIES.equals(cookie.getName())) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					return cookie;
				}
			}
		}
		return null;
	}
}
