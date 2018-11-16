package cn.peyton.spring.tags.entity;

import java.io.Serializable;

/**
 * <h3>基础元素 属性</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:19
 * Version: 1.0.0
 * </pre>
 */
public class BaseElement implements Serializable {

	/** */
	private static final long serialVersionUID = 1L;
	
	/** 元素 编号 */
	private Object id;
	/** 元素 名称 */
	private Object name;
	/** 元素 值 */
	private Object value;
	/** 元素 样式*/
	private Object cssClass;
	/** 可读状态,这里默认可读,不可读值为:readonly; */
	private Object readonly;
	/** 元素 提示*/
	private Object title;
	
	public BaseElement(){}
	
	/**
	 * @return  元素 编号
	 */
	public Object getId() {
		return id;
	}
	/**
	 * @param id  元素 编号
	 */
	public void setId(Object id) {
		this.id = id;
	}
	/**
	 * @return  元素 名称
	 */
	public Object getName() {
		return name;
	}
	/**
	 * @param name 元素  名称
	 */
	public void setName(Object name) {
		this.name = name;
	}
	/**
	 * @return 元素  值
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param value 元素  值
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/**
	 * @return 元素  样式
	 */
	public Object getCssClass() {
		return cssClass;
	}
	/**
	 * @param cssClass 元素 样式
	 */
	public void setCssClass(Object cssClass) {
		this.cssClass = cssClass;
	}
	/**
	 * @return 可读状态,这里默认可读,不可读值为:readonly;
	 */
	public Object getReadonly() {
		return readonly;
	}
	/**
	 * @param readonly 可读状态,这里默认可读,不可读值为:readonly;
	 */
	public void setReadonly(Object readonly) {
		this.readonly = readonly;
	}
	/**
	 * @return 元素 提示
	 */
	public Object getTitle() {
		return title;
	}
	/**
	 * @param title 元素 提示
	 */
	public void setTitle(Object title) {
		this.title = title;
	}
}
