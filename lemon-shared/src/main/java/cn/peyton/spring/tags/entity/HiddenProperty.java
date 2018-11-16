package cn.peyton.spring.tags.entity;

import java.io.Serializable;

/**
 * <h3>隐藏控件 类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:17
 * Version: 1.0.0
 * </pre>
 */
public class HiddenProperty implements Serializable {

	/** */
	private static final long serialVersionUID = 1L;
	
	/** 隐藏控件名称 */
	private Object hiddenName;
	/** 隐藏控件值*/
	private Object hiddenValue;
	/** 隐藏控件所对应的action */
	private Object hiddenAction;
	
	public HiddenProperty(){}
	/**
	 * @return 隐藏控件名称
	 */
	public Object getHiddenName() {
		return hiddenName;
	}
	/**
	 * @param hiddenName 隐藏控件名称
	 */
	public void setHiddenName(Object hiddenName) {
		this.hiddenName = hiddenName;
	}
	/**
	 * @return 隐藏控件值
	 */
	public Object getHiddenValue() {
		return hiddenValue;
	}
	/**
	 * @param hiddenValue 隐藏控件值
	 */
	public void setHiddenValue(Object hiddenValue) {
		this.hiddenValue = hiddenValue;
	}
	/**
	 * @return  隐藏控件所对应的action
	 */
	public Object getHiddenAction() {
		return hiddenAction;
	}
	/**
	 * @param hiddenAction  隐藏控件所对应的action
	 */
	public void setHiddenAction(Object hiddenAction) {
		this.hiddenAction = hiddenAction;
	}

}
