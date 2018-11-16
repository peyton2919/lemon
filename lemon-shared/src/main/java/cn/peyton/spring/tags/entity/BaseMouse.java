package cn.peyton.spring.tags.entity;

/**
 * <h3>基础元素 鼠标动作</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:19
 * Version: 1.0.0
 * </pre>
 */
public class BaseMouse extends BaseElement {

	/**	 */
	private static final long serialVersionUID = 1L;

	/**  点击事件*/
	private Object onclick;
	/**  点击事件*/
	private Object onmousedown; 
	/** 鼠标移动事件*/
	private Object onmousemove; 
	/** 鼠标离开事件*/
	private Object onmouseout; 
	/** 鼠标在上面事件*/
	private Object onmouseover; 
	/** 鼠标向上事件*/
	private Object onmouseup; 
	/** 鼠标选中事件*/
	private Object onselect; 
	
	/** 这里指的是值改变事件;*/
	private Object onchange;
	
	/** 这里指的是聚焦事件;*/
	private Object onfocus;
	
	/** 这里指的是键向下事件;*/
	private Object onkeydown;
	
	/** 这里指的是键向上事件;*/
	private Object onkeyup;
	
	/** 这里指的是键压事件;*/
	private Object onkeypress;
	
	/** 这里指的是模糊事件;*/
	private Object onblur;
	
	
	public BaseMouse(){}
	
	
	/** 
	 * @return 点击事件
	 */
	public Object getOnclick() {
		return onclick;
	}
	/** 
	 * @param onclick 点击事件
	 */
	public void setOnclick(Object onclick) {
		this.onclick = onclick;
	}
	/** 
	 * @return 鼠标点击事件
	 */
	public Object getOnmousedown() {
		return onmousedown;
	}
	/** 
	 * @param onmousedown 鼠标点击事件
	 */
	public void setOnmousedown(Object onmousedown) {
		this.onmousedown = onmousedown;
	}
	/** 
	 * @return  鼠标移动事件
	 */
	public Object getOnmousemove() {
		return onmousemove;
	}
	/** 
	 * @param onmousemove 鼠标移动事件
	 */
	public void setOnmousemove(Object onmousemove) {
		this.onmousemove = onmousemove;
	}
	/** 
	 * @return 鼠标离开事件
	 */
	public Object getOnmouseout() {
		return onmouseout;
	}
	/** 
	 * @param onmouseout 鼠标离开事件
	 */
	public void setOnmouseout(Object onmouseout) {
		this.onmouseout = onmouseout;
	}
	/** 
	 * @return  鼠标在上面事件
	 */
	public Object getOnmouseover() {
		return onmouseover;
	}
	/** 
	 * @param onmouseover 鼠标在上面事件
	 */
	public void setOnmouseover(Object onmouseover) {
		this.onmouseover = onmouseover;
	}
	/** 
	 * @return 鼠标向上事件
	 */
	public Object getOnmouseup() {
		return onmouseup;
	}
	/** 
	 * @param onmouseup 鼠标向上事件
	 */
	public void setOnmouseup(Object onmouseup) {
		this.onmouseup = onmouseup;
	}
	/** 
	 * @return  鼠标选中事件
	 */
	public Object getOnselect() {
		return onselect;
	}
	/** 
	 * @param onselect  鼠标选中事件
	 */
	public void setOnselect(Object onselect) {
		this.onselect = onselect;
	}

	/** @return 指的是值改变事件	 */
	public Object getOnchange() {
		return onchange;
	}

	/** @param onchange 指的是值改变事件	 */
	public void setOnchange(Object onchange) {
		this.onchange = onchange;
	}

	/** @return 指的是聚焦事件	 */
	public Object getOnfocus() {
		return onfocus;
	}

	/** @param onfocus 指的是聚焦事件	 */
	public void setOnfocus(Object onfocus) {
		this.onfocus = onfocus;
	}

	/** @return 指的是键向下事件	 */
	public Object getOnkeydown() {
		return onkeydown;
	}

	/** @param onkeydown 指的是键向下事件	 */
	public void setOnkeydown(Object onkeydown) {
		this.onkeydown = onkeydown;
	}

	/** @return 指的是键向上事件	 */
	public Object getOnkeyup() {
		return onkeyup;
	}

	/** @param onkeyup 指的是键向上事件	 */
	public void setOnkeyup(Object onkeyup) {
		this.onkeyup = onkeyup;
	}

	/** @return 指的是键压事件	 */
	public Object getOnkeypress() {
		return onkeypress;
	}

	/** @param onkeypress 指的是键压事件	 */
	public void setOnkeypress(Object onkeypress) {
		this.onkeypress = onkeypress;
	}

	/** @return 指的是模糊事件	 */
	public Object getOnblur() {
		return onblur;
	}

	/** @param onblur 指的是模糊事件	 */
	public void setOnblur(Object onblur) {
		this.onblur = onblur;
	}
	
	
}
