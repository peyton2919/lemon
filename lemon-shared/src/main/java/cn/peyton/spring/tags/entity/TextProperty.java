package cn.peyton.spring.tags.entity;

/**
 * <h3>文本框 控件属性</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:15
 * Version: 1.0.0
 * </pre>
 */
public class TextProperty extends BaseMouse {

	/***/
	private static final long serialVersionUID = 1L;
	/** label 控件对象*/
	private LabelProperty labelProperty;	
	/** text最大输入长度*/
	private Object textMaxLength;
	/** text类型radio,valid 默认text*/
	private Object textType;
	/** text格式化类型这里用三种：s表示字符串, d表示日期 , f表示小数; */
	private Object textFormatType;
	/** text格式化样式,这里只对textFormatType类型处理 */
	private Object textFormatStyle;
	
	/**构造函数*/
	public TextProperty(){
		if (labelProperty == null) {labelProperty = new LabelProperty();}
	}
	
	
	
	
	//------------------------------------------ set and get method ------------------------------------
	
	
	/**
	 * @return label 控件对象
	 */
	public LabelProperty getLabelProperty() {
		return labelProperty;
	}
	/**
	 * @param labelProperty label 控件对象
	 */
	public void setLabelProperty(LabelProperty labelProperty) {
		this.labelProperty = labelProperty;
	}

	/**
	 * @return text最大输入长度
	 */
	public Object getTextMaxLength() {
		return textMaxLength;
	}
	/**
	 * @param textMaxLength text最大输入长度
	 */
	public void setTextMaxLength(Object textMaxLength) {
		this.textMaxLength = textMaxLength;
	}
	/**
	 * @return  text类型radio,valid 默认text
	 */
	public Object getTextType() {
		return textType;
	}
	/**
	 * @param textType text类型radio,valid 默认text
	 */
	public void setTextType(Object textType) {
		this.textType = textType;
	}
	/**
	 * @return  text格式化样式,这里只对textFormatType类型处理 
	 */
	public Object getTextFormatStyle() {
		return textFormatStyle;
	}
	/**
	 * @param textFormatStyle text格式化样式,这里只对textFormatType类型处理 
	 */
	public void setTextFormatStyle(Object textFormatStyle) {
		this.textFormatStyle = textFormatStyle;
	}
	/** @return text格式化类型这里用三种：s表示字符串, d表示日期 , f表示小数;  */
	public Object getTextFormatType() {
		return textFormatType;
	}
	/** @param textFormatType  text格式化类型这里用三种：s表示字符串, d表示日期 , f表示小数; 	 */
	public void setTextFormatType(Object textFormatType) {
		this.textFormatType = textFormatType;
	}

}
