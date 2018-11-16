package cn.peyton.spring.tags.base;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <h3>自定义标签 公共属性名 类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:22
 * Version: 1.0.0
 * </pre>
 * @author peyton
 */
public class AttributeSupport extends TagSupport {

	/** */
	public static final long serialVersionUID = 1L;
	/** 申明类型为字符串 */
	public final static String TYPE_STRING = "string";
	/** 申明类型为字符改变  */
	public final static String TYPE_STRINGCHANGE = "stringChange";
	/** 申明类型为时间  */
	public final static String TYPE_DATE = "date";
	/** 申明类型为数字  */
	public final static String TYPE_FLOAT = "float";
	/** 文本框 类型 text */
	public final static String INPUT_TYPE_TEXT = "text";
	/** 文本框 类型 checkbox */
	public final static String INPUT_TYPE_CHECKBOX = "checkbox";
	/** 文本框 类型 radio */
	public final static String INPUT_TYPE_RADIO = "radio";
	/** 文本框 类型 submit */
	public final static String INPUT_TYPE_SUBMIT = "submit";
	/** 文本框 类型 password */
	public final static String INPUT_TYPE_PASSWORD = "password";
	
	/** 格式化时间样式 'yyyy-MM-dd'*/
	public static final String FORMAT_STYLE_DATE = "yyyy-MM-dd";
	/** 格式化时间样式 'yyyy-MM-dd hh:mm:ss'*/
	public static final String FORMAT_STYLE_DATETIME = "yyyy-MM-dd hh:mm:ss";
	/** 格式代浮点样式 '0.00' */
	public static final String FORMAT_STYLE_FLOAT = "0.00";
	
	public AttributeSupport(){}

}
