package cn.peyton.spring.tags;

import cn.peyton.spring.tags.base.BaseTagSupport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * <h3>文本控件 类</h3>
 * <pre>
 *     继承 TagSupport\HtmlSupport\BaseTagSupport;
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:48
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class Text extends BaseTagSupport {
	/** */
	private static final long serialVersionUID = 1L;
	
	
	// ========================================= ============ ====================================================
	/** 这里是指label是展示在左边,label的值集合,这是必需要的值;*/
	private Object label;
	
	/** 这里是指label的样式;*/
	private Object labelClass;
	
	/** 这里指的是文本框的name值,text控件所对应的值最好是相对应的;*/
	private Object name;
	
	/** 这里指的是文本框的值,text控件所对应的值最好是相对应的;*/
	private Object value;
	
	/**  文本框 样式 */
	private Object cssClass;
	
	/**
	 * 分解位只能给两值0、1..;与map同时有值时,factorize有优先使用,默认为0;<br>
	 * 这个值只能在type='stringChange'时才有用;<br>
	 * 这里所定的是分解到最后成为两位的数组;<br>
	 * 数组格式如：Object[]{1_name1,2_name2...};<br>
	 * 如果是0就提取的是1,2..要显示，是1就提取name1,name2...要显示;
	 */
	private Object factorize;
	/**
	 * 1、改变样式(与stringChange和factorize配合使用);<br>
	 * 2、 这里有五个值:gainSingle、gainMultiple、replaceSingle、replaceMultiple、outsideSingle、outsideMultiple,默认为gainSingle;<br>
	 * 3、当值为gainSingle时表示获取单个,当前下标为factorize值的要显示值(用到factorize,map可以为空);<br>
	 * 		格式为:value="1_test",map为空;factorize=0时,显示"1";factorize=1,显示"test";<br>
	 * 4、当值为gainMultiple时表示获取多个,当前下标为factorize值的要显示值(用到factorize,map可以为空);<br>
	 * 		格式为:value="1_test,2_test2..",map为空;factorize=0时,显示"1,2..";factorize=1,显示"test,test2..";<br>
	 * 5、当值为replaceSingle时表示要替换单个,当前下标为factorize值(要配合map),然后显示出来(用到factorize和map);<br>
	 * 		格式为:value="1_test",map不能空;显示为通过key方法取值;<br>
	 * 		factorize=0时,显示"获取后的值_test";factorize=1时,显示"1_获取后的值";<br>
	 * 6、当值为replaceMultiple时表示要替多个,换当前下标为factorize值(要配合map),然后显示出来(用到factorize和map);<br>
	 * 		格式为:value="1_test,2_test2..",map不能空;显示为通过key方法取值;<br>
	 * 		factorize=0时,显示"获取后的值_test,获取后的值_test..";factorize=1时,显示"1_获取后的值,2_获取后的值..";<br>
	 * 7、当值为outsideSingle时表示value的值是单个要用map中的值替换,然后显示出来(用到map,factorize可以为空);<br>
	 * 		格式为:value="1",map不能空;显示为通过key方法取值;显示"获取后的值";<br>
	 * 8、当值为outsideMultiple时表示value的值多个要用map中的值替换,然后显示出来(用到map,factorize可以为空);<br>
	 * 		格式为:value="1,2..",map不能空;显示为通过key方法取值;显示"获取后的值,获取后的值.."<br>
	 */
	private Object changeStyle;
	/**
	 * 输入符号(只做两次处理,默认为","和"_")  <br>
	 * 只在type="stringChange"并且changeStyle="replaceSingle、replaceMultiple、outsideMultiple"有用;<br>
	 * 要与outputSign相对应,否则就设置为默认","和"_"<br>
	 */
	private Object inputSign;
	/**
	 * 输出符号(只做两次处理,默认为","和"_")<br>
	 * 只在type="stringChange"并且changeStyle="replaceSingle、replaceMultiple、outsideMultiple"有用<br>
	 *  要与inputSign相对应,否则就设置为默认","和"_"<br>
	 */
	private Object outputSign;
	
	/** 这里指的是文本框的最大可输入字符集合,可以为空;<br>
	 * 格式如:'0_50,2_35' 0表示文本框输出的位置,50文本框最大输入长度;<br>
	 * text控件所对应的值最好是相对应的;*/
	private Object maxlength;
	
	/**这里指类型,有 string、stringChange、float与date默认为string ;*/
	private Object type;
	
	/** 这里是指文本框格式化样式集合,
	 * 这里只能输入时间('yyyy-MM-dd')和浮点('0.00')这两种,
	 * 输入时间与浮点 方式如:'d_yyyy-MM-dd,f_0.00'样式;*/
	private Object formatStyle;
	
	/**要展示的对象集合 ;<br>
	 * map格式为key_value形式:1_红色,2_黑色,...等; 表示 数字为对象的id,中文为对象里的名称<br>
	 * 必需配合value使用;value 格式 为:1_111,2_222,...等;这是所指的1表示map里的key,这里的111代表一个数;<br>
	 * 用来转换,格式为：红色:111,黑色:222,...等*/
	private Object map;
	
	// ================================== 内部 私有 方法 ==================================================
    /** 用在stringChange */
	private int _factorize = -1 ;
    /** 用在stringChange */
	private Map<String , String> _map ;
    /** 用在stringChange和string */
	private int _maxlength  = -1 ;
    /** 用date和float */
	private String _formatStyle;
    /** 通用 */
	private String _type ;
    /** 通用 */
	private String _name;
	private String _changeStyle;
	private String[] _inputSige;
	private String[] _outputSige;
	
	
	public Text(){}

	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		if (TYPE_FLOAT.equals(getType())) { _type = getType().toString();}
		else if (TYPE_DATE.equals(getType())) { _type = getType().toString();}
		else if (TYPE_STRINGCHANGE.equals(getType())) { _type = getType().toString();}
		else { _type = TYPE_STRING;}
		//设置name属性
		try {
			if (getName() != null && !"".equals(getName())) {_name = getName().toString();
			}else {_name = createID("tb");}
		} catch (Exception e) {_name = createID("tb");}
		
		if (_type.equals(TYPE_DATE)) {
			//如果格式化样式formatStyle为空格式 就默认为yyyy-MM-dd
			if(getFormatStyle() == null) {formatStyle = "yyyy-MM-dd";}
			try {//时间格式化转换
				SimpleDateFormat sdf = new SimpleDateFormat(formatStyle.toString());
				if (getValue().toString().length() >= 28) {
					@SuppressWarnings("deprecation")
					Date date = new Date(getValue().toString());
					sdf.format(date);
				}else {
					sdf.format(sdf.parse(getValue().toString()));
				}
			} catch (Exception e) {
                //如出现异常就把类型type设置为string
				_type = TYPE_STRING;
			}
		}else if (_type.equals(TYPE_FLOAT)) {
			try {
			    //就转换value
				Float.parseFloat(getValue().toString());
			} catch (Exception e) {
                //如出现异常就把类型type设置为string
				_type = TYPE_STRING;
			}
		}else if (_type.equals(TYPE_STRINGCHANGE)) {
            //获取长度
			gainMaxlength();
            //获取位数
			gainFactorize();
			try {
				_changeStyle = getChangeStyle().toString();
			} catch (Exception e) {
				_changeStyle = "gainSingle";
			}
			if ("replaceSingle".equals(_changeStyle) || "replaceMultiple".equals(_changeStyle)
					||"outsideSingle".equals(_changeStyle)||"outsideMultiple".equals(_changeStyle)) {
				if (getMap() != null) {_map = (Map<String, String>) map;}
				else{ _changeStyle = "gainSingle";}
				if ("replaceSingle".equals(_changeStyle)) {
					if (getInputSign()!=null) { _inputSige = new String[1];_inputSige[0] = getInputSign().toString();
					}else {_inputSige = new String[1];_inputSige[0] = "_";}
					if(getOutputSign() != null){ _outputSige = new String[1];_outputSige[0] = getOutputSign().toString();
					}else{_outputSige = new String[1]; _outputSige[0] = "_";}
				}else if ("replaceMultiple".equals(_changeStyle)) {
					if (getInputSign()!=null) { _inputSige =  getInputSign().toString().split(";");
					}else{_inputSige = new String[2]; _inputSige[0] = ","; _inputSige[1] = "_";}
					if(getOutputSign() != null){ _outputSige = getOutputSign().toString().split(";");
					}else{_outputSige = new String[2]; _outputSige[0] = ","; _outputSige[1] = "_";}
				}else if ("outsideMultiple".equals(_changeStyle)) {
					if (getInputSign()!=null) { _inputSige = new String[1];_inputSige[0] = getInputSign().toString();
					}else {_inputSige = new String[1];_inputSige[0] = ",";}
					if(getOutputSign() != null){ _outputSige = new String[1];_outputSige[0] = getOutputSign().toString();
					}else{_outputSige = new String[1]; _outputSige[0] = ",";}
				}
				
			}else if ("gainSingle".equals(_changeStyle)) {
				if (getInputSign()!=null) { _inputSige = new String[1];_inputSige[0] = getInputSign().toString();
				}else {_inputSige = new String[1];_inputSige[0] = ",";}
				if(getOutputSign() != null){ _outputSige = new String[1];_outputSige[0] = getOutputSign().toString();
				}else{_outputSige = new String[1]; _outputSige[0] = ",";}
			}else if ("gainMultiple".equals(_changeStyle)) {
				if (getInputSign()!=null) { _inputSige =  getInputSign().toString().split(";");	}
				else {_inputSige = new String[2]; _inputSige[0] = ","; _inputSige[1] = "_";	}
				if(getOutputSign() != null){ _outputSige = getOutputSign().toString().split(";");}
				else{_outputSige = new String[1]; _outputSige[0] = ",";}
				
			}
		}else {
            //获取长度
			gainMaxlength();
		}
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		//申明
		JspWriter out = super.pageContext.getOut();
		try {//不同的类型则进入相应的方法
			if(TYPE_STRING.equals(_type)){
				outString(out);
			} else if(TYPE_DATE.equals(_type)){
				outDate(out);
			}else if (TYPE_FLOAT.equals(_type)) {
				outFloat(out);
			}else if (TYPE_STRINGCHANGE.equals(_type)) {
				outStringChange(out);
			}
		} catch (Exception e) {
			System.out.println("load LabelDisplayFormat Error!!!");
		}
		
		return super.doEndTag();
	}

	// ========================================= ============ ====================================================
	
	
	/**
	 * stringChange方法
	 * @param out JspWriter 对象
	 * @throws IOException 会抛IO异常
	 */
	private void outStringChange(JspWriter out) throws IOException{
		String[] _first; //第一次拆解,value值;
		String[] _second;//第二次拆解,_firsts数组值;
		//创建临时对象sb
		StringBuffer sb = new StringBuffer();
		
		out.println(createLabelMessage(_name, _name, getLabel(), getLabelClass()));
		if (value != null) {			
			if ("outsideSingle".equals(_changeStyle)) {
				sb.append(_map.get(value.toString()));
			}else if ("outsideMultiple".equals(_changeStyle)) {
				_first = value.toString().split(_inputSige[0]);
				for (int i = 0; i < _first.length; i++) {
					sb.append(_map.get(_first[i]));
					if (i != _first.length -1) {
						sb.append(_outputSige[0]);
					}
				}
			}else if ("replaceSingle".equals(_changeStyle)) {
				_first = value.toString().split(_inputSige[0]);
				if (_first.length < _factorize) {_factorize = 0;}
				for (int i = 0; i < _first.length; i++) {
					if (i== _factorize) {sb.append(_map.get(_first[i]));
					}else {sb.append(_first[i]);}
				}
				
			}else if ("replaceMultiple".equals(_changeStyle)) {
				_first = value.toString().split(_inputSige[0]);
				for (int i = 0; i < _first.length; i++) {
					_second = _first[i].split(_inputSige[1]);
					if (_second.length < _factorize) { _factorize = 0;}
					for (int j = 0; j < _second.length; j++) {
						if (j== _factorize) {sb.append(_map.get(_second[j]));
						}else {sb.append(_second[j]);}
						if (j != _second.length -1) {sb.append(_outputSige[1]);}
					}
					if (i != _first.length -1) {sb.append(_outputSige[0]);}
				}
			}else if ("gainMultiple".equals(_changeStyle)) {
				_first = value.toString().split(_inputSige[0]);
				for (int i = 0; i < _first.length; i++) {
					_second = _first[i].split(_inputSige[1]);
					sb.append(_second[_factorize]);
					if (i != _first.length -1) {
						sb.append(_outputSige[0]);
					}
					
				}
			}else if ("gainSingle".equals(_changeStyle)) {
				_first = value.toString().split(_inputSige[0]);
				if (_factorize >= _first.length) {
					_factorize =0;
				}
				sb.append(_first[_factorize]);
			}
			out.println(createTextMessage(_name, _name, sb, INPUT_TYPE_TEXT, assignment(), _maxlength));
		}
	}
	
	/**
	 * float方法
	 * @param out JspWriter 对象
	 * @throws IOException 会抛IO异常
	 */
	private void outFloat(JspWriter out) throws IOException {
		out.println(createLabelMessage(_name, _name, getLabel(), getLabelClass()));
		out.println(createTextMessage(_name, _name, createFormatStyleFloat(_formatStyle, getValue()),
                INPUT_TYPE_TEXT, assignment(), _maxlength));
	}
	
	/**
	 * stringChange方法
	 * @param out JspWriter 对象
	 * @throws IOException 会抛IO异常
	 */
	private void outString(JspWriter out) throws IOException {
		out.println(createLabelMessage(_name, _name, getLabel(), getLabelClass()));
		out.println(createTextMessage(_name, _name, getValue(), INPUT_TYPE_TEXT, assignment(), _maxlength));
	}
	
	/**
	 * stringChange方法
	 * @param out JspWriter 对象
	 * @throws IOException 会抛IO异常
	 */
	private void outDate(JspWriter out) throws IOException {
		out.println(createLabelMessage(_name, _name, getLabel(), getLabelClass()));
		out.println(createTextMessage(_name, _name, createFormatStyleDate(formatStyle, value.toString()),
                INPUT_TYPE_TEXT, assignment(), _maxlength));
	}

	
	// ========================================= ============ ====================================================

	
	/**
	 * 获取分解位 小于0都默认为0;
	 */
	private void gainFactorize(){
		try {
			_factorize = Integer.parseInt(factorize.toString());
			if (_factorize < 0) {_factorize = 0;}
		} catch (Exception e) {_factorize = 0;}
	}
	
	/**
	 * 获取文本框 长度
	 */
	private void gainMaxlength(){
		try {//如果没设置长度就默认为6个字符
			_maxlength = Integer.valueOf((maxlength!=null)?maxlength.toString():"-1");
		} catch (Exception e) {
            //如出现 异常，默认没有限制
		    _maxlength = -1;
		}
	}
	
	
	//========================================= set and get method ====================================//

	/** @return  是指label是展示在左边,label的值集合,这是必需要的值; */
	public Object getLabel() {
		return label;
	}
	/** @param label 是指label是展示在左边,label的值集合,这是必需要的值; */
	public void setLabel(Object label) {
		this.label = label;
	}
	/** @return 是指label的样式; */
	public Object getLabelClass() {
		return labelClass;
	}
	/**
	 * @param labelClass 是指label的样式;
	 */
	public void setLabelClass(Object labelClass) {
		this.labelClass = labelClass;
	}
	/** @return 指的是文本框的name值,text控件所对应的值最好是相对应的; */
	public Object getName() {
		return name;
	}
	/**
	 * @param name 指的是文本框的name值,text控件所对应的值最好是相对应的;	 */
	public void setName(Object name) {
		this.name = name;
	}
	/** @return 指的是文本框的值,text控件所对应的值最好是相对应的; */
	public Object getValue() {
		return value;
	}
	/** @param value 指的是文本框的值,text控件所对应的值最好是相对应的;
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/** @return 文本框 样式  */
	public Object getCssClass() {
		return cssClass;
	}
	/** @param cssClass 文本框 样式 	 */
	public void setCssClass(Object cssClass) {
		this.cssClass = cssClass;
	}
	/** @return 分解位只能给两值0、1..;与map同时有值时,factorize有优先使用,默认为0;<br>
	 * 这个值只能在type='stringChange'时才有用;<br>
	 * 这里所定的是分解到最后成为两位的数组;<br>
	 * 数组格式如：Object[]{1_name1,2_name2...};<br>
	 * 如果是0就提取的是1,2..要显示，是1就提取name1,name2...要显示;
	 */
	public Object getFactorize() {
		return factorize;
	}
	/** 
	 * @param factorize 分解位只能给两值0、1..;与map同时有值时,factorize有优先使用,默认为0;<br>
	 * 这个值只能在type='stringChange'时才有用;<br>
	 * 这里所定的是分解到最后成为两位的数组;<br>
	 * 数组格式如：Object[]{1_name1,2_name2...};<br>
	 * 如果是0就提取的是1,2..要显示，是1就提取name1,name2...要显示;
	 */
	public void setFactorize(Object factorize) {
		this.factorize = factorize;
	}
	/** @return 这里指的是文本框的最大可输入字符集合,可以为空;<br>
	 * 格式如:'0_50,2_35' 0表示文本框输出的位置,50文本框最大输入长度;<br>
	 * text控件所对应的值最好是相对应的; */
	public Object getMaxlength() {
		return maxlength;
	}
	/** 
	 * @param maxlength 这里指的是文本框的最大可输入字符集合,可以为空;<br>
	 * 格式如:'0_50,2_35' 0表示文本框输出的位置,50文本框最大输入长度;<br>
	 * text控件所对应的值最好是相对应的;
	 */
	public void setMaxlength(Object maxlength) {
		this.maxlength = maxlength;
	}
	/** @return 指类型,有 string、stringChange、float与date默认为string ; */
	public Object getType() {
		return type;
	}
	/** @param type 指类型,有 string、stringChange、float与date默认为string ;	 */
	public void setType(Object type) {
		this.type = type;
	}
	/** @return 这里是指文本框格式化样式集合,
	 * 这里只能输入时间('yyyy-MM-dd')和浮点('0.00')这两种,
	 * 输入时间与浮点 方式如:'d_yyyy-MM-dd,f_0.00'样式; */
	public Object getFormatStyle() {
		return formatStyle;
	}
	/** @param formatStyle 这里是指文本框格式化样式集合,
	 * 这里只能输入时间('yyyy-MM-dd')和浮点('0.00')这两种,
	 * 输入时间与浮点 方式如:'d_yyyy-MM-dd,f_0.00'样式;
	 */
	public void setFormatStyle(Object formatStyle) {
		this.formatStyle = formatStyle;
	}
	/** 
	 * @return 要展示的对象集合 ;<br>
	 * map格式为key_value形式:1_红色,2_黑色,...等; 表示 数字为对象的id,中文为对象里的名称<br>
	 * 必需配合value使用;value 格式 为:1_111,2_222,...等;这是所指的1表示map里的key,这里的111代表一个数;<br>
	 * 用来转换,格式为：红色:111,黑色:222,...等
	 */
	public Object getMap() {
		return map;
	}
	/**
	 * @param map 要展示的对象集合 ;<br>
	 * map格式为key_value形式:1_红色,2_黑色,...等; 表示 数字为对象的id,中文为对象里的名称<br>
	 * 必需配合value使用;value 格式 为:1_111,2_222,...等;这是所指的1表示map里的key,这里的111代表一个数;<br>
	 * 用来转换,格式为：红色:111,黑色:222,...等
	 */
	public void setMap(Object map) {
		this.map = map;
	}
	/**
	 * @return 1、改变样式(与stringChange和factorize配合使用);<br>
	 * 2、 这里有五个值:gainSingle、gainMultiple、replaceSingle、replaceMultiple、outsideSingle、outsideMultiple,默认为gainSingle;<br>
	 * 3、当值为gainSingle时表示获取单个,当前下标为factorize值的要显示值(用到factorize,map可以为空);<br>
	 * 		格式为:value="1_test",map为空;factorize=0时,显示"1";factorize=1,显示"test";<br>
	 * 4、当值为gainMultiple时表示获取多个,当前下标为factorize值的要显示值(用到factorize,map可以为空);<br>
	 * 		格式为:value="1_test,2_test2..",map为空;factorize=0时,显示"1,2..";factorize=1,显示"test,test2..";<br>
	 * 5、当值为replaceSingle时表示要替换单个,当前下标为factorize值(要配合map),然后显示出来(用到factorize和map);<br>
	 * 		格式为:value="1_test",map不能空;显示为通过key方法取值;<br>
	 * 		factorize=0时,显示"获取后的值_test";factorize=1时,显示"1_获取后的值";<br>
	 * 6、当值为replaceMultiple时表示要替多个,换当前下标为factorize值(要配合map),然后显示出来(用到factorize和map);<br>
	 * 		格式为:value="1_test,2_test2..",map不能空;显示为通过key方法取值;<br>
	 * 		factorize=0时,显示"获取后的值_test,获取后的值_test..";factorize=1时,显示"1_获取后的值,2_获取后的值..";<br>
	 * 7、当值为outsideSingle时表示value的值是单个要用map中的值替换,然后显示出来(用到map,factorize可以为空);<br>
	 * 		格式为:value="1",map不能空;显示为通过key方法取值;显示"获取后的值";<br>
	 * 8、当值为outsideMultiple时表示value的值多个要用map中的值替换,然后显示出来(用到map,factorize可以为空);<br>
	 * 		格式为:value="1,2..",map不能空;显示为通过key方法取值;显示"获取后的值,获取后的值.."<br>
	 */
	public Object getChangeStyle() {
		return changeStyle;
	}
	/**
	 * @param changeStyle 1、改变样式(与stringChange和factorize配合使用);<br>
	 * 2、 这里有五个值:gainSingle、gainMultiple、replaceSingle、replaceMultiple、outsideSingle、outsideMultiple,默认为gainSingle;<br>
	 * 3、当值为gainSingle时表示获取单个,当前下标为factorize值的要显示值(用到factorize,map可以为空);<br>
	 * 		格式为:value="1_test",map为空;factorize=0时,显示"1";factorize=1,显示"test";<br>
	 * 4、当值为gainMultiple时表示获取多个,当前下标为factorize值的要显示值(用到factorize,map可以为空);<br>
	 * 		格式为:value="1_test,2_test2..",map为空;factorize=0时,显示"1,2..";factorize=1,显示"test,test2..";<br>
	 * 5、当值为replaceSingle时表示要替换单个,当前下标为factorize值(要配合map),然后显示出来(用到factorize和map);<br>
	 * 		格式为:value="1_test",map不能空;显示为通过key方法取值;<br>
	 * 		factorize=0时,显示"获取后的值_test";factorize=1时,显示"1_获取后的值";<br>
	 * 6、当值为replaceMultiple时表示要替多个,换当前下标为factorize值(要配合map),然后显示出来(用到factorize和map);<br>
	 * 		格式为:value="1_test,2_test2..",map不能空;显示为通过key方法取值;<br>
	 * 		factorize=0时,显示"获取后的值_test,获取后的值_test..";factorize=1时,显示"1_获取后的值,2_获取后的值..";<br>
	 * 7、当值为outsideSingle时表示value的值是单个要用map中的值替换,然后显示出来(用到map,factorize可以为空);<br>
	 * 		格式为:value="1",map不能空;显示为通过key方法取值;显示"获取后的值";<br>
	 * 8、当值为outsideMultiple时表示value的值多个要用map中的值替换,然后显示出来(用到map,factorize可以为空);<br>
	 * 		格式为:value="1,2..",map不能空;显示为通过key方法取值;显示"获取后的值,获取后的值.."<br>
	 */
	public void setChangeStyle(Object changeStyle) {
		this.changeStyle = changeStyle;
	}
	/** 
	 * @return 输入符号(只做两次处理,默认为","和"_")  <br>
	 * 只在type="stringChange"并且changeStyle="replaceSingle、replaceMultiple、outsideMultiple"有用;<br>
	 * 要与outputSign相对应,否则就设置为默认","和"_"<br>
	 */
	public Object getInputSign() {
		return inputSign;
	}
	/**
	 * @param inputSign 输入符号(只做两次处理,默认为","和"_")  <br>
	 * 只在type="stringChange"并且changeStyle="replaceSingle、replaceMultiple、outsideMultiple"有用;<br>
	 * 要与outputSign相对应,否则就设置为默认","和"_"<br>
	 */
	public void setInputSign(Object inputSign) {
		this.inputSign = inputSign;
	}
	/**
	 * @return 输出符号(只做两次处理,默认为","和"_")<br>
	 * 只在type="stringChange"并且changeStyle="replaceSingle、replaceMultiple、outsideMultiple"有用<br>
	 *  要与inputSign相对应,否则就设置为默认","和"_"<br>
	 */
	public Object getOutputSign() {
		return outputSign;
	}
	/**
	 * @param outputSign 输出符号(只做两次处理,默认为","和"_")<br>
	 * 只在type="stringChange"并且changeStyle="replaceSingle、replaceMultiple、outsideMultiple"有用<br>
	 *  要与inputSign相对应,否则就设置为默认","和"_"<br>
	 */
	public void setOutputSign(Object outputSign) {
		this.outputSign = outputSign;
	}

	

}
