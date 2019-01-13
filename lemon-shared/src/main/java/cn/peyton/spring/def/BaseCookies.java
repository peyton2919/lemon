package cn.peyton.spring.def;

import cn.peyton.spring.cipher.UnidirectionalCipherUtil;
import cn.peyton.spring.util.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h3> </h3>
 * <pre>
 * 名称加密方式用SHA单向加密;
 * 值 加密方式用Base64;
 * </pre>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/4 10:26
 * Version: 1.0.0
 * </pre>
 */
/**
 * <h3>对Cookie操作{加密}</h3>
 * <pre>
 *      名称加密方式用SHA单向加密;
 *      值 加密方式用Base64;
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:09
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class BaseCookies {

	private final static String COOKIE_PATH = "/";
	private final static String COOKIE_DOMAIN = "localhost";
	private final static int COOKIE_MAX_AGE = 5 * 30 * 60;
	
	
	/**
	 * <h4>添加Cookie</h4>
	 * @param response 响应对象
	 * @param name cookie名称
	 * @param value cookie值
	 */
	public static void addCookie(HttpServletResponse response ,String name,String value) {
		CookieUtil.addCookie(response, UnidirectionalCipherUtil.MD5(name),
				BaseCipher.encoderHMAC(value), COOKIE_MAX_AGE, COOKIE_PATH, COOKIE_DOMAIN);
	}
	/**
	 * <h4>删除Cookie</h4>
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param name cookie名称
	 */
	public static void delCookie(HttpServletRequest request , HttpServletResponse response , String name) {
		CookieUtil.delCookie(request, response, UnidirectionalCipherUtil.MD5(name), COOKIE_PATH);
	}
	/**
	 * <h4>获取Cookie</h4>
	 * @param request 请求对象
	 * @param name cookie名称
	 * @return 解密后的值
	 */
	public static String getCookie(HttpServletRequest request ,String name) {
		return BaseCipher.decoderHMAC(CookieUtil.getCookieByName(request, UnidirectionalCipherUtil.MD5(name)));
	}
}
