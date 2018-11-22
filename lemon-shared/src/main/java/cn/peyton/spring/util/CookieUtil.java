package cn.peyton.spring.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * String getComment()返回cookie中注释,如果没有注释的话将返回空值.
 * String getDomain() 返回cookie中Cookie适用的域名. 
 * 		使用getDomain() 方法可以指示浏览器把Cookie返回给同 一域内的其他服务器,
 * 			而通常Cookie只返回给与发送它的服务器名字完全相同的服务器。注意域名必须以点开始（例如.baidu.com）
 * int getMaxAge() 返回Cookie过期之前的最大时间，以秒计算。
 * int getName()返回Cookie的名字。名字和值是我们始终关心的两个部分，笔者会在后面详细介绍 getName/setName。
 * String getPath()返回Cookie适用的路径。如果不指定路径，Cookie将返回给当前页面所在目录及其子目录下 的所有页面。
 * boolean getSecure() 如果浏览器通过安全协议发送cookies将返回true值，如果浏览器使用标准协议则返回false值。
 * String getUserType() 返回Cookie的值。笔者也将在后面详细介绍getValue/setValue。
 * int getVersion() 返回Cookie所遵从的协议版本。
 * void setComment(String purpose) 设置cookie中注释。
 * void setDomain(String pattern) 设置cookie中Cookie适用的域名
 * void setMaxAge(int expiry) 以秒计算，设置Cookie过期时间。
 * void setPath(String uri) 指定Cookie适用的路径。
 * void setSecure(boolean flag) 指出浏览器使用的安全协议，例如HTTPS或SSL。
 * void setValue(String newValue) cookie创建后设置一个新的值。
 * void setVersion(int v) 设置Cookie所遵从的协议版本。 
 */

/**
 * <h3>Cookie工具类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:54
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class CookieUtil {

	/**
	 * <h4>显示 Cookies</h4>
	 * @param request 请求
	 * @param response 响应
	 */
	public static void showCookies(HttpServletRequest request , HttpServletResponse response) {
        //获取一个cookie数组
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for(Cookie cookie :cookies) {
				System.out.println(cookie.getName() + "," + cookie.getValue());
			}
		}
	}

	/**
	 * <h4>设置cookie</h4>
	 * @param response 响应
	 * @param name cookie名称
	 * @param value	cookie值
	 * @param maxAge cookie生命周期 以秒为单位
	 * @param path cookie传递路径 '/'
	 * @param domain cookie域 'localhost'
	 */
	public static void addCookie(HttpServletResponse response, String name,String value,
			int maxAge,String path , String domain) {
		Cookie cookie = new Cookie(name, value);
        //30min
		cookie.setMaxAge(maxAge);
		cookie.setPath(path);
        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
        try {
            URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}
	
	/**
	 * <h4></h4>
	 * 注意一、修改、删除Cookie时，新建的Cookie除value、maxAge之外的所有属性,<br>
	 * 例如name、path、domain等，都要与原Cookie完全一样。<br>
	 * 否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。<br>
	 * @param request 请求
	 * @param response 响应
	 * @param name cookie名称
	 * @param value cookie值
	 */
	public static void editCookie(HttpServletRequest request,HttpServletResponse response,
			String name,String value) {
		Cookie[] cookies = request.getCookies();
		if(null != cookies) {
			for(Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					cookie.setValue(value);
					cookie.setPath("/");
					cookie.setMaxAge(30 * 60);
					response.addCookie(cookie);
					break;
				}
			}
		}
	}
	/**
	 * <h4>修改cookie</h4>
	 * 注意一、修改、删除Cookie时，新建的Cookie除value、maxAge之外的所有属性,<br>
	 * 例如name、path、domain等，都要与原Cookie完全一样。<br>
	 * 否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。<br>
	 * @param request 请求
	 * @param response 响应
	 * @param name cookie名称
	 * @param value	cookie值
	 * @param maxAge cookie生命周期 以秒为单位
	 * @param path cookie传递路径 '/'
	 * @param domain cookie域 'localhost'
	 */
	public static void editCookie(HttpServletRequest request,HttpServletResponse response,
			String name,String value,int maxAge,String path , String domain) {
		Cookie[] cookies = request.getCookies();
		if(null != cookies) {
			for(Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					cookie.setValue(value);
					cookie.setPath(path);
					cookie.setMaxAge(maxAge);
					cookie.setDomain(domain);
					response.addCookie(cookie);
					break;
				}
			}
		}
	}
	
	/**
	 * <h4>删除cookie</h4>
	 * @param request 请求
	 * @param response 响应
	 * @param name cookie名称
	 * @param path cookie传递路径 '/'
	 */
	public static void delCookie(HttpServletRequest request,HttpServletResponse response,String name,String path) {
		Cookie[] cookies = request.getCookies();
		if(null != cookies) {
			for(Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					cookie.setValue(null);
					cookie.setMaxAge(0);
					cookie.setPath(path);
					response.addCookie(cookie);
					break;
				}
			}
		}
	}
	
	/**
	 * <h4>根据名字获取cookie</h4>
	 * @param request 响应
	 * @param name cookie名字
	 * @return cookie
	 */
	public static Cookie getCookie(HttpServletRequest request ,String name) {
		Map<String, Cookie> cookieMap = readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			return cookieMap.get(name);
		}
		return null;
	}
	/**
	 * <h4>根据名字获取cookie</h4>
	 * @param request 响应
	 * @param name cookie名字
	 * @return cookie
	 */
	public static String getCookieByName(HttpServletRequest request ,String name) {
		Map<String, Cookie> cookieMap = readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			return cookieMap.get(name).getValue();
		}
		return null;
	}
	/**
	 * <h4>获取cookie集合(封装成Map,key为cookie的名字)</h4>
	 * @param request 请求
	 * @return Map集合
	 */
	public static Map<String , Cookie> getCookieByMap(HttpServletRequest request) {
		return readCookieMap(request);
	}
	
	
	/**
	 * <h4>数组的cookie转成Map型</h4>
	 * @param request 请求
	 * @return cookie Map 集合
	 */
	private static Map<String, Cookie> readCookieMap(HttpServletRequest request){
		Map<String, Cookie> cookieMap = new HashMap<>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for(Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
	
}
