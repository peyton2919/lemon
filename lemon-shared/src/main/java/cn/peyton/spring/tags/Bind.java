package cn.peyton.spring.tags;

import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
/**
 * <h3>springMVC控件绑定properties值</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:44
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class Bind extends TagSupport{

	/** @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** properties配置文件中的key */
	private String key;
	/** 数据源 properties配置所在位置,默认2个位置 "/conf/i18n.properties","/i18n.properties"  */
	private String data;
	/** 申明properties配置所在位置数组 */
	static String[] strs = {"/conf/i18n.properties","/i18n.properties"};
	static Properties properties;
	boolean _b;

	@Override
	public int doStartTag() throws JspException {
		if (null == properties) {
			if (null == data) {
				for (int i = 0; i < strs.length; i++) {
					try {
						Resource re = new ClassPathResource(strs[i]);
						properties= PropertiesLoaderUtils.loadProperties(re);
						_b = false;
						break;
					} catch (Exception e) {_b = true;}
				}
			}
		}
		return super.doStartTag();
	}
	
	
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = super.pageContext.getOut();
		try {
			if (_b) {out.print("");
			}else {
				String vString = properties.getProperty(key);
				out.print(vString != null ? vString : "" );
			}	
		} catch (Exception e) {e.printStackTrace();}
		
		return EVAL_PAGE;
	}

	/**
	 * <h4>properties配置文件中的key</h4>
	 * @return properties配置文件中的key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * <h4>properties配置文件中的key</h4>
	 * @param key properties配置文件中的key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * <h4>数据源 properties配置所在位置,默认2个位置 "/conf/i18n.properties","/i18n.properties" </h4>
	 * @return 数据源 properties配置所在位置,默认2个位置 "/conf/i18n.properties","/i18n.properties" 
	 */
	public String getData() {
		return data;
	}
	/**
	 * <h4>数据源 properties配置所在位置,默认2个位置 "/conf/i18n.properties","/i18n.properties" </h4>
	 * @param data 数据源 properties配置所在位置,默认2个位置 "/conf/i18n.properties","/i18n.properties" 
	 */
	public void setData(String data) {
		this.data = data;
	}

}
