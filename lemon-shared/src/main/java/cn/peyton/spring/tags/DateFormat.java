package cn.peyton.spring.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import cn.peyton.spring.tags.base.DateSupport;
import cn.peyton.spring.tags.base.HtmlSupport;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * <h3>text 格式化时间标签</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class DateFormat extends HtmlSupport {

	/***/
	private static final long serialVersionUID = 1L;
	/** 时间text标签名称*/
	private String name;
	/** 时间text标签id*/
	private String id;
	/** 时间值,转换异常不输出 */
	private Object value;
	/** 时间text标签提示信息*/
	private Object title;
	/** 时间text 样式*/
	private Object cssClass;
	/** 输出时间格式样式 yyyy-MM-dd 为默认样式*/
	private String format;
	/** 时间text 样式*/
	private Object cssStyle;
	/** 输出控件样式: label(标签) 与  input(文本框) 这二种样式;默认input */
	private String outStyle;
	/** 左边提示标签*/
	private Object label;
	/** 提示标签 所在位置 有左边与右边 ,默认标签在左left与right*/
	private String labelPosition;
	/** 格式化后的时间 */
	private String formatDate;
	/** 是否可读true、false 或 readonly */
	private String readonly;
	/** 点击事件*/
	private String onclick;
	/** 是否需要 tr_td 格式 默认为true 表示需要*/
	private String isDisplayTrTd;
	//---内部私有变量
	/** cssClass、 cssStyle 为空时 为false */
	private boolean bo = false;
	/** 是否要TR TD */
	private boolean isTrTd = true;
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = super.pageContext.getOut();
		StringBuffer sb =new StringBuffer();
		StringBuffer sb1 =new StringBuffer();
		if(label !=null){
			sb.append((isTrTd) ? "<td>" : "");
			sb.append(label);
			if ("left".equals(labelPosition)) {	sb.append(" : ");			}
			sb.append((isTrTd) ? "</td>" : "");
		}
		//
		sb1.append((isTrTd) ? "<td>" : "");
		if ("input".equals(outStyle)) {	sb1.append("<input type='text'");
		}else { sb1.append("<label ");}
		
		if(bo){sb1.append(" class='" + cssClass + "'");
		}else if (cssClass != null) {sb1.append(" class='" + cssClass + "'");
		}else if (cssStyle != null) {sb1.append(" style='" + cssStyle + "'");}

		sb1.append(createPropertyMessage("id", id , "id"));
		sb1.append(createPropertyMessage("name", name, "n"));
		sb1.append(createPropertyMessage("value", formatDate));
		sb1.append(createPropertyMessage("title", title));
		sb1.append(createPropertyMessage("readonly", readonly));
		sb1.append(createPropertyMessage("onclick", onclick));
		
		if ("input".equals(outStyle)) {sb1.append("></input>");
		}else {sb1.append("></label>");}
		//
		sb.append((isTrTd) ? "</td>" : "");
		
		try {
			if (isTrTd) 
				out.println("<tr>");
			if ("left".equals(labelPosition)) {
				sb.append(sb1);
				out.print(sb);
			}else {
				sb1.append(sb);
				out.print(sb1);
			}
			if (isTrTd) 
				out.println("</tr>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	@Override
	public int doStartTag() throws JspException {
		if(format == null) format = "yyyy-MM-dd";
		try {
			SimpleDateFormat sdf =   new SimpleDateFormat(format);
			//Timestamp now = new Timestamp(value);//获取系统当前时间	
			//String str = sdf.format(now);
			if(value !=null){	
				if(value.toString().length() >21){
					@SuppressWarnings("deprecation")
					Date date =new Date(value.toString());
					formatDate = sdf.format(date);
				}else {
					formatDate = DateSupport.convertDateStrFormatStr(value.toString(), format);
				}
			}
		} catch (Exception e) {
			formatDate = null;
		}
		if(labelPosition == null) labelPosition ="left";
		if(cssClass!=null && cssStyle != null) bo = true;
		if("false".equals(isDisplayTrTd)) isTrTd = false;
		if(null == outStyle) outStyle = "input";
		return super.doStartTag();
	}
	/**--------------------------------------set与get方法---------------------------------------------*/
	/** @return 时间text标签名称 */
	public String getName() {
		return name;
	}
	/** @param name 时间text标签名称	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return 时间text标签id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id 时间text标签id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return 时间值,转换异常不输出 
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param value 时间值,转换异常不输出 
	 * @throws JspException
	 */
	public void setValue(Object value) throws JspException {
		if(value !=null){
			this.value = ExpressionEvaluatorManager.evaluate(
		            "value", value.toString(), Object.class, this, pageContext);
		}else {
			this.value = value;
		}
	}
	/** @return 时间text标签提示信息	 */
	public Object getTitle() {
		return title;
	}
	/** @param title 时间text标签提示信息	 
	 * @throws JspException */
	public void setTitle(Object title) throws JspException {
		if (title != null) {
			this.title = ExpressionEvaluatorManager.evaluate(
		            "title", title.toString(), Object.class, this, pageContext);
		}else {
			this.title = title;
		}
		
	}
	/** @return 时间text 样式*/
	public Object getCssClass() {
		return cssClass;
	}
	/** @param cssClass 时间text 样式	 */
	public void setCssClass(Object cssClass) {
		this.cssClass = cssClass;
	}	
	/** @return 输出时间格式样式 yyyy-MM-dd 为默认样式 	 */
	public String getFormat() {
		return format;
	}
	/** @param format 输出时间格式样式 yyyy-MM-dd 为默认样式 */
	public void setFormat(String format) {
		this.format = format;
	}
	/** @return 时间text 样式	 */
	public Object getCssStyle() {
		return cssStyle;
	}
	/** @param cssStyle 时间text 样式	 */
	public void setCssStyle(Object cssStyle) {
		this.cssStyle = cssStyle;
	}
	
	/**
	 * <h4>输出控件样式: label(标签) 与  input(文本框) 这二种样式;默认input</h4>
	 * @return
	 */
	public String getOutStyle() {
		return outStyle;
	}
	/**
	 * <h4>输出控件样式: label(标签) 与  input(文本框) 这二种样式;默认input</h4>
	 * @param outStyle
	 */
	public void setOutStyle(String outStyle) {
		this.outStyle = outStyle;
	}
	/** @return 左边提示标签	 */
	public Object getLabel() {
		return label;
	}
	/**
	 * @param label 左边提示标签
	 * @throws JspException
	 */
	public void setLabel(Object label) throws JspException {
		if (label != null) {
			this.label = ExpressionEvaluatorManager.evaluate(
		            "label", label.toString(), Object.class, this, pageContext);
		}else {
			this.label = label;
		}
		
	}
	/** @return 提示标签 所在位置 有左边与右边 ,默认标签在左left与right 	 */
	public String getLabelPosition() {
		return labelPosition;
	}
	/** @param labelPosition 提示标签 所在位置 有左边与右边 ,默认标签在左left与right */
	public void setLabelPosition(String labelPosition) {
		this.labelPosition = labelPosition;
	}
	/** @return 是否可读true、false 或 readonly	 */
	public String getReadonly() {
		return readonly;
	}
	/** @param readonly 是否可读true、false 或 readonly  */
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	/** @return 点击事件 */
	public String getOnclick() {
		return onclick;
	}
	/** @param onclick 点击事件 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	/** @return 是否需要 tr_td 格式 默认为true 表示需要 	 */
	public String getIsDisplayTrTd() {
		return isDisplayTrTd;
	}
	/** @param isDisplayTrTd 是否需要 tr_td 格式 默认为true 表示需要 */
	public void setIsDisplayTrTd(String isDisplayTrTd) {
		this.isDisplayTrTd = isDisplayTrTd;
	}

}
