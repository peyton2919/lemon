package cn.peyton.spring.tags.entity;

import java.io.Serializable;

/**
 * <h3>属性 类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:16
 * Version: 1.0.0
 * </pre>
 */
public class Property implements Serializable {

	/** */
	private static final long serialVersionUID = 1L;
	/** 参数 */
	private String para;
	/** 名称 */
	private String name;
	/** 值 */
	private String value;
	/** 备注*/
	private String remark;
	
	/** 构造函数 */
	public Property(){}
	/**
	 * 构造函数
	 * @param _name 名称
	 * @param _value 值 
	 */
	public Property(String _name , String _value){
		name = _name;
		value = _value;
	}
	/**
	 * 构造函数
	 * @param _name 参数
	 * @param _name 名称
	 * @param _value 值 
	 * @param _value 备注
	 */
	public Property(String _para , String _name , String _value ,String _remark ){
		para = _para;
		name = _name;
		value = _value;
		remark = _remark;
	}
	
	/**
	 * 
	 * @return 参数
	 */
	public String getPara() {
		return para;
	}
	/**
	 * 
	 * @param para 参数
	 */
	public void setPara(String para) {
		this.para = para;
	}
	/**
	 * 
	 * @return 名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return 值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 
	 * @param value 值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 
	 * @return 备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
