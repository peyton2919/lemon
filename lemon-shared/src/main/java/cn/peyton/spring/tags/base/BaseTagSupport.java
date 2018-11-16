package cn.peyton.spring.tags.base;

/**
 * <h3>自定义 标签 类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:22
 * Version: 1.0.0
 * </pre>
 * @author peyton
 */
public class BaseTagSupport extends HtmlSupport {

	/**  */
	private static final long serialVersionUID = 1L;
	
	/** 这里指的是点击事件;*/
	private Object onclick;
	/** 这里指的是双击事件;*/
	private Object ondblclick;
	
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
	
	/** 这里指的是选中事件;*/
	private Object onselect;
	
	/** 这里是指文本框 鼠标事件*/	
	private Object onmousedown;
	
	/**这里是指文本框 鼠标事件*/
	private Object onmousemove;
	
	/**这里是指文本框 鼠标事件*/
	private Object onmouseout;
	
	/**这里是指文本框 鼠标事件*/
	private Object onmouseover;
	
	/**这里是指文本框 鼠标事件 */
	private Object onmouseup;
	/** 这里指的是文本框的可读状态集合默认是可读的,可设置为'true'不可读;<br>
	 * text控件所对应的值最好是相对应的;*/
	private Object readonly;
	
	/** 这里指的是文本框的提示集合,text控件所对应的值最好是相对应的; */
	private Object title;
	
	public BaseTagSupport(){}
	
	/**
	 *  13个on事件 和 title、readonly 赋值;<br>
	 * onclick、onchange、onfocus、onblur、onselect、<br>
	 * onmousedown、onmousemove、onmouseout、onmouseover、onmouseup、<br>
	 * onkeydown、onkeyup、onkeypress<br><br>
	 * 
	 * @return HTML格式 
	 */
	public StringBuffer assignment(){
		StringBuffer sb = new StringBuffer();
		if (!("".equals(getOnclick())&& getOnclick() == null)) sb.append(" onclick=\"" + getOnclick() + "\"");
		if (!("".equals(getOndblclick())&& getOndblclick() == null)) sb.append(" ondblclick=\"" + getOndblclick() + "\"");
		if (!("".equals(getOnchange())&& getOnchange() == null)) sb.append(" onchange=\"" + getOnchange() + "\"");		
		if (!("".equals(getOnfocus())&& getOnfocus() == null)) 	sb.append(" onfocus=\"" + getOnfocus() + "\"");
		if (!("".equals(getOnkeydown())&& getOnkeydown() == null)) 	sb.append(" onkeydown=\"" + getOnkeydown() + "\"");
		if (!("".equals(getOnkeyup())&& getOnkeyup() == null)) 	sb.append(" onkeyup=\"" + getOnkeyup() + "\"");
		if (!("".equals(getOnkeypress())&& getOnkeypress() == null)) 	sb.append(" onkeypress=\"" + getOnkeypress() + "\"");
		if (!("".equals(getOnblur())&& getOnblur() == null)) 	sb.append(" onblur=\"" + getOnblur() + "\"");
		if (!("".equals(getOnselect())&& getOnselect() == null)) 	sb.append(" onselect=\"" + getOnselect() + "\"");
		if (!("".equals(getOnmousedown())&& getOnmousedown() == null)) 	sb.append(" onmousedown=\"" + getOnmousedown() + "\"");
		if (!("".equals(getOnmousemove())&& getOnmousemove() == null)) 	sb.append(" onmousemove=\"" + getOnmousemove() + "\"");
		if (!("".equals(getOnmouseout())&& getOnmouseout() == null)) 	sb.append(" onmouseout=\"" + getOnmouseout() + "\"");
		if (!("".equals(getOnmouseover())&& getOnmouseover() == null)) 	sb.append(" onmouseover=\"" + getOnmouseover() + "\"");
		if (!("".equals(getOnmouseup())&& getOnmouseup() == null)) 	sb.append(" onmouseup=\"" + getOnmouseup() + "\"");
		if (!("".equals(getTitle())&& getTitle() == null)) 	sb.append(" title=\"" + getTitle() + "\"");
		if (!("".equals(getReadonly())&& getReadonly() == null)){
			if ("true".equals(getReadonly())) {sb.append(" readonly=\"" + getReadonly() + "\"");}	
		}
		return sb;
	}
	
	/** @return  指的是点击事件 */
	public Object getOnclick() {
		return onclick;
	}
	/** @param onclick 指的是点击事件	 */
	public void setOnclick(Object onclick) {
		this.onclick = onclick;
	}
	/** @return 指的是值改变事件 */
	public Object getOnchange() {
		return onchange;
	}
	/** @param onchange 指的是值改变事件	 */
	public void setOnchange(Object onchange) {
		this.onchange = onchange;
	}
	/** @return 指的是聚焦事件 */
	public Object getOnfocus() {
		return onfocus;
	}
	/** @param onfocus 指的是聚焦事件	 */
	public void setOnfocus(Object onfocus) {
		this.onfocus = onfocus;
	}
	/** @return 指的是键向下事件  */
	public Object getOnkeydown() {
		return onkeydown;
	}
	/** @param onkeydown 指的是键向下事件	 */
	public void setOnkeydown(Object onkeydown) {
		this.onkeydown = onkeydown;
	}
	/** @return 指的是键向上事件 */
	public Object getOnkeyup() {
		return onkeyup;
	}
	/** @param onkeyup 指的是键向上事件	 */
	public void setOnkeyup(Object onkeyup) {
		this.onkeyup = onkeyup;
	}
	/** @return 指的是键压事件 */
	public Object getOnkeypress() {
		return onkeypress;
	}
	/** @param onkeypress 指的是键压事件	 */
	public void setOnkeypress(Object onkeypress) {
		this.onkeypress = onkeypress;
	}
	/** @return 指的是模糊事件  */
	public Object getOnblur() {
		return onblur;
	}
	/** @param onblur 指的是模糊事件  */
	public void setOnblur(Object onblur) {
		this.onblur = onblur;
	}
	/** @return 指的是选中事件 */
	public Object getOnselect() {
		return onselect;
	}
	/** @param onselect 指的是选中事件	 */
	public void setOnselect(Object onselect) {
		this.onselect = onselect;
	}
	/** @return 指文本框 鼠标事件 */
	public Object getOnmousedown() {
		return onmousedown;
	}
	/** @param onmousedown 指文本框 鼠标事件	 */
	public void setOnmousedown(Object onmousedown) {
		this.onmousedown = onmousedown;
	}
	/** @return 指文本框 鼠标事件 */
	public Object getOnmousemove() {
		return onmousemove;
	}
	/** @param onmousemove 指文本框 鼠标事件	 */
	public void setOnmousemove(Object onmousemove) {
		this.onmousemove = onmousemove;
	}
	/** @return 文本框 鼠标事件 */
	public Object getOnmouseout() {
		return onmouseout;
	}
	/** @param onmouseout	文本框 鼠标事件 */
	public void setOnmouseout(Object onmouseout) {
		this.onmouseout = onmouseout;
	}
	/** @return 文本框 鼠标事件 */
	public Object getOnmouseover() {
		return onmouseover;
	}
	/** @param onmouseover	文本框 鼠标事件 */
	public void setOnmouseover(Object onmouseover) {
		this.onmouseover = onmouseover;
	}
	/** @return 文本框 鼠标事件 */
	public Object getOnmouseup() {
		return onmouseup;
	}
	/** @param onmouseup 文本框 鼠标事件	 */
	public void setOnmouseup(Object onmouseup) {
		this.onmouseup = onmouseup;
	}
	/** @return 这里指的是文本框的可读状态集合默认是可读的,可设置为'true'不可读;<br>
	 * text控件所对应的值最好是相对应的 */
	public Object getReadonly() {
		return readonly;
	}
	/** @param readonly 这里指的是文本框的可读状态集合默认是可读的,可设置为'true'不可读;<br>
	 * text控件所对应的值最好是相对应的
	 */
	public void setReadonly(Object readonly) {
		this.readonly = readonly;
	}
	/** @return 指的是文本框的提示集合,text控件所对应的值最好是相对应的 */
	public Object getTitle() {
		return title;
	}
	/** @param title 指的是文本框的提示集合,text控件所对应的值最好是相对应的 	 */
	public void setTitle(Object title) {
		this.title = title;
	}
	/** @return 指的是双击事件	 */
	public Object getOndblclick() {
		return ondblclick;
	}
	/** @param ondblclick 指的是双击事件 */
	public void setOndblclick(Object ondblclick) {
		this.ondblclick = ondblclick;
	}
}
