package cn.peyton.spring.tags.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>提交按钮实体类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:16
 * Version: 1.0.0
 * </pre>
 */
public class SubmitProperty extends BaseMouse {

	/** */
	private static final long serialVersionUID = 1L;
	
	/** 按钮提交 的地址：如：abc.action; */
	private Object action; 
	/** 验证;这里是指按钮提交时,是否要验证,用true和 false验证;*/
	private boolean validate; 
	/** ajax 方式; 这必需要要在struts下本配合才能使用;值有:'true'、'false',默认为false; */
	private boolean strutsAjax; 
	/** 图片按钮,图片位置;*/
	private Object submitSrc; 
	/** 图片按钮 宽度*/
	private Object submitSrcWidth; 
	/** 图片按钮 高度*/
	private Object submitSrcHeight; 
	/** 目标;这里指的是提交后目标要显示在哪里<br>
	 * (这里只能在submitStrutsAjax为true的情况下才有效);*/
	private Object targets; 

	
	/** 隐藏控件集合*/
	private List<HiddenProperty> hiddenLists;

	/** 构造函数 */
	public SubmitProperty(){
		if (hiddenLists == null) {hiddenLists = new ArrayList<HiddenProperty>();}	
	}
	
	/** 
	 * @return  按钮提交 的地址：如：abc.action;
	 */
	public Object getAction() {
		return action;
	}
	/** 
	 * @param action  按钮提交 的地址：如：abc.action;
	 */
	public void setAction(Object action) {
		this.action = action;
	}
	/** 
	 * @return 验证;这里是指按钮提交时,是否要验证;用abc.action表示提交abc.action要验证;
	 */
	public boolean getValidate() {
		return validate;
	}
	/** 
	 * @param validate 验证;这里是指按钮提交时,是否要验证;用abc.action表示提交abc.action要验证;
	 */
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	
	/** 
	 * @return  ajax 方式; 这必需要要在struts下本配合才能使用;值有:'true'、'false',默认为false; 
	 */
	public boolean getStrutsAjax() {
		return strutsAjax;
	}
	/** 
	 * @param strutsAjax  ajax 方式; 这必需要要在struts下本配合才能使用;值有:'true'、'false',默认为false; 
	 */
	public void setStrutsAjax(boolean strutsAjax) {
		this.strutsAjax = strutsAjax;
	}
	/** 
	 * @return 图片按钮,图片位置;
	 */ 
	public Object getSubmitSrc() {
		return submitSrc;
	}
	/** 
	 * @param submitSrc 图片按钮,图片位置;
	 */
	public void setSubmitSrc(Object submitSrc) {
		this.submitSrc = submitSrc;
	}
	/** 
	 * @return  图片按钮 宽度
	 */
	public Object getSubmitSrcWidth() {
		return submitSrcWidth;
	}
	/** 
	 * @param submitSrcWidth  图片按钮 宽度
	 */
	public void setSubmitSrcWidth(Object submitSrcWidth) {
		this.submitSrcWidth = submitSrcWidth;
	}
	/** 
	 *  @return  图片按钮 高度
	 */
	public Object getSubmitSrcHeight() {
		return submitSrcHeight;
	}
	/** 
	 * @param submitSrcHeight  图片按钮 高度
	 */
	public void setSubmitSrcHeight(Object submitSrcHeight) {
		this.submitSrcHeight = submitSrcHeight;
	}
	/** 
	 * @return 目标;这里指的是提交后目标要显示在哪里<br>
	 * (这里只能在submitStrutsAjax为true的情况下才有效);
	 */
	public Object getTargets() {
		return targets;
	}
	/** 
	 * @param targets 目标;这里指的是提交后目标要显示在哪里<br>
	 * (这里只能在submitStrutsAjax为true的情况下才有效);
	 */
	public void setTargets(Object targets) {
		this.targets = targets;
	}	
	/** 
	 * @return 隐藏控件集合
	 */
	public List<HiddenProperty> getHiddenLists() {
		return hiddenLists;
	}
	/** 
	 * @param hiddenLists  隐藏控件集合
	 */
	public void setHiddenLists(List<HiddenProperty> hiddenLists) {
		this.hiddenLists = hiddenLists;
	}
	
	
}
