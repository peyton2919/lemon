package cn.peyton.spring.tags;

import cn.peyton.spring.tags.base.HtmlSupport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * <h3>Label 标签类</h3>
 * <pre>
 *     格式：
 *     名称：  test
 *     这里分为两部分前半部分:名称;后半部分:test;
 *     前半部分用label赋值;后半部分用value赋值;
 *     前半部分可以为空不做赋值;
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class Label extends HtmlSupport {

	/** */
	private static final long serialVersionUID = 1L;
	/** 规定元素唯一 id*/
	private Object identify;
	/**规定元素唯一 名称*/
	private Object name;
	/** 要显示的值(这里所用一般都是从数据库里得来的) */
	private Object value;
	/** 用于 左边 提示的标签 */
	private Object label;
	/** 样式可以是个集合,这里最多只能存放2个,多出的不做处理;
	 * <br>以','分隔开样式 如'xxx,xxx';
	 * <br>逗号前半部表示:label 部分css;逗号后半部表示：value部分css;
	 * <br>如果没有','就默认 label标签与value标签用同一个css;*/
	private Object cssClasses;
	/** 要显示的长度 默认长度6个字符(只有在string才有用)*/
	private Object displayLength;
	/**是否显示提示 true 与 false , 默认为false;*/
	private Object displayTitle;
	/**类型有四种：null 、string、stringChange、float与date默认为string 
	 * 其中如选择了stringChange必需要注意以下五点：
	 * 1)、 必需要与mapObject 配合使用;
	 * 2)、map格式为key_value形式: 1_红色,2_黑色,...等;
	 * 3)、value格式 为:1_111,2_222,...等;
	 * 4)、最后要输出的结果转换成:红色:111,黑色:222,...等*/
	private Object type;
	/**
	 * 分解位只能给两值0与1..;<br>
	 * 这个值只能在type='stringChange'时才有用;<br>
	 * 这里所定的是分解到最后成为两位的数组;<br>
	 * 数组格式如：Object[]{1_name1,2_name2...};<br>
	 * 如果是0就提取的是1,2..要显示，是1就提取name1,name2...要显示;
	 */
	private Object factorize;
	/**
	 * <h3>改变样式(与stringChange和factorize配合使用);</h3>
	 * <h4>这里有五个值:gainSingle、gainMultiple、replaceSingle、replaceMultiple、outsideSingle、outsideMultiple,默认为gainSingle;</h4>
	 * 
	 * 1、当值为gainSingle时表示获取单个,当前下标为factorize值的要显示值(用到factorize,map可以为空);<br>
	 * 		格式为:value="1_test",map为空;factorize=0时,显示"1";factorize=1,显示"test";<br>
	 * 
	 * 2、当值为gainMultiple时表示获取多个,当前下标为factorize值的要显示值(用到factorize,map可以为空);<br>
	 * 		格式为:value="1_test,2_test2..",map为空;factorize=0时,显示"1,2..";factorize=1,显示"test,test2..";<br>
	 * 
	 * 3、当值为replaceSingle时表示要替换单个,当前下标为factorize值(要配合map),然后显示出来(用到factorize和map);<br>
	 * 		格式为:value="1_test",map不能空;显示为通过key方法取值;<br>
	 * 		factorize=0时,显示"获取后的值_test";factorize=1时,显示"1_获取后的值";<br>
	 * 
	 * 4、当值为replaceMultiple时表示要替多个,换当前下标为factorize值(要配合map),然后显示出来(用到factorize和map);<br>
	 * 		格式为:value="1_test,2_test2..",map不能空;显示为通过key方法取值;<br>
	 * 		factorize=0时,显示"获取后的值_test,获取后的值_test..";factorize=1时,显示"1_获取后的值,2_获取后的值..";<br>
	 * 
	 * 5、当值为outsideSingle时表示value的值是单个要用map中的值替换,然后显示出来(用到map,factorize可以为空);<br>
	 * 		格式为:value="1",map不能空;显示为通过key方法取值;显示"获取后的值";<br>
	 * 
	 * 6、当值为outsideMultiple时表示value的值多个要用map中的值替换,然后显示出来(用到map,factorize可以为空);<br>
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
	/**格式化样式 ,这只对float(可以表示金额)与date(表示时间 )起作用;
	 * float:输出的样式可以 0.00表示格式两位小数位,$0.00表示多加$符号;
	 * date:输出样式可以 yyyy-MM-dd; */
	private Object formatStyle;
	
	/**要展示的对象集合 ;<br>
	 * mapObject格式为key_value形式:1_红色,2_黑色,...等; 表示 数字为对象的id,中文为对象里的名称<br>
	 * 必需配合value使用;value 格式 为:1_111,2_222,...等;这是所指的1表示mapObject里的key,这里的111代表一个数;<br>
	 * 用来转换,格式为：红色:111,黑色:222,...等*/
	private Object map;
	/** value 的点击事件*/
	private Object onclick;
	//*******************************内部私有方法************************************************
	/***/
	private Map<String , String> _map;
	/**是否显示title 默认为true */
	private boolean isTitle = true;
	/** value 值的长度 */
	private int length;
	/** 判断 css 是否是集合 */
	private boolean isCss;
	/** 分解位数 */
	private int _factorize = -1;
	/** 改变样式 */
	private String _changeStyle;
	/** 输入符号*/
	private String[] _inputSige;
	/** 输出符号*/
	private String[] _outputSige;
	
	public Label(){
		_map = new HashMap<String , String>();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		//判断类型为string
		if("string".equals(type)){
			gainDisplaylength();
			//判断类型为date
		}else if ("date".equals(type)) {
			//如果格式化样式formatStyle为空格式 就默认为yyyy-MM-dd
			if(formatStyle == null) formatStyle="yyyy-MM-dd";
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
				type="string"; //如出现异常就把类型type设置为string
			}
			//判断类型为小数
		}else if("float".equals(type)) {
			try {//就转换value
				Float.parseFloat(value.toString());
			} catch (Exception e) {
				type = "string";//如出现异常就把类型type设置为string
			}	//判断类型为字符转换
		}else if ("stringChange".equals(type)) {
			gainDisplaylength();
			gainFactorize(); //获取位数
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
		}
		else{//类型默认为string
			type="string";
		}//判断isDisplayTitle 是否要提示,true要提示,false不提示;
		if (!"true".equals(displayTitle)) {
			isTitle = false;
		}
		if (cssClasses != null) {
			isCss = (cssClasses.toString().indexOf(',') > 0)? true : false;
		}
		return super.doStartTag();
	}
	
	
	@Override
	public int doEndTag() throws JspException {
		//申明
		JspWriter out = super.pageContext.getOut();
		if (value != null) {//判断value不为空
			try {//不同的类型则进入相应的方法
				if("string".equals(type)){
					outString(out);
				} else if("date".equals(type)){
					outDate(out);
				}else if ("float".equals(type)) {
					outFloat(out);
				}else if ("stringChange".equals(type)) {
					outStringChange(out);
				}
			} catch (Exception e) {
				System.out.println("load LabelDisplayFormat Error!!!");
			}
		}
		return EVAL_PAGE;
	}

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
		
		out.println(createLabelMessage(identify, name, label, ((isCss) ? (cssClasses.toString().split(","))[0] : cssClasses)));
		if (value != null) {
			
			if ("outsideSingle".equals(_changeStyle)) {
				sb.append(_map.get(value));
			}else if ("outsideMultiple".equals(_changeStyle)) {
				_first = value.toString().split(_inputSige[0]);
				for (int i = 0; i < _first.length; i++) {
					sb.append(_map.get(_first[i]));sb.append(_outputSige[0]);
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
			
			if (displayLength == null) {length = -1;}
			out.println(createLabelMessage(identify, name, sb, 
					((isCss) ? (cssClasses.toString().split(","))[1] : cssClasses) , isTitle, onclick, length));
		}
		
	}
	
	/**
	 * float方法
	 * @param out JspWriter 对象
	 * @throws IOException 会抛IO异常
	 */
	private void outFloat(JspWriter out) throws IOException {
	
		out.println(createLabelMessage(identify, name, label, ((isCss) ? (cssClasses.toString().split(","))[0] : cssClasses)));
		out.println(createLabelMessage(identify, name, createFormatStyleFloat(formatStyle, value), 
				((isCss) ? (cssClasses.toString().split(","))[1] : cssClasses) , isTitle, onclick, -1));
	}
	
	/**
	 * stringChange方法
	 * @param out JspWriter 对象
	 * @throws IOException 会抛IO异常
	 */
	private void outString(JspWriter out) throws IOException {
		out.println(createLabelMessage(identify, name, label, ((isCss) ? (cssClasses.toString().split(","))[0] : cssClasses)));
		if (displayLength == null) {length = -1;}
		out.println(createLabelMessage(identify, name, value, 
				((isCss) ? (cssClasses.toString().split(","))[1] : cssClasses) , isTitle, onclick, length));
	}
	
	/**
	 * stringChange方法
	 * @param out JspWriter 对象
	 * @throws IOException 会抛IO异常
	 */
	private void outDate(JspWriter out) throws IOException {
		out.println(createLabelMessage(identify, name, label, ((isCss) ? (cssClasses.toString().split(","))[0] : cssClasses)));
		out.println(createLabelMessage(identify, name, createFormatStyleDate(formatStyle, value.toString()), 
				((isCss) ? (cssClasses.toString().split(","))[1] : cssClasses) , isTitle, onclick, -1));
		
	}
	
	
	
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
	private void gainDisplaylength(){
		try {//如果没设置长度就默认为6个字符
			length = Integer.valueOf((displayLength!=null)?displayLength.toString():"6");
		} catch (Exception e) {length = 6;}//如出现 异常，默认没有限制
	}
	
	
	//---------------------------------------------------set and get method-----------------------------------------------------
	/** @return 规定元素唯一 id */
	public Object getIdentify() {
		return identify;
	}
	/** @param identify 规定元素唯一 id 	 */
	public void setIdentify(Object identify) {
		this.identify = identify;
	}
	/** @return 规定元素唯一 名称 	 */
	public Object getName() {
		return name;
	}
	/** @param name 规定元素唯一 名称	 */
	public void setName(Object name) {
		this.name = name;
	}
	/** @return 要显示的值(这里所用一般都是从数据库里得来的)	 */
	public Object getValue() {
		return value;
	}
	/** @param value 要显示的值(这里所用一般都是从数据库里得来的) 	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/** @return 用于 左边 提示的标签	 */
	public Object getLabel() {
		return label;
	}
	/** @param label 用于 左边 提示的标签	 */
	public void setLabel(Object label) {
		this.label = label;
	}
	/**
	 * @return 样式可以是个集合,这里最多只能存放2个,多出的不做处理 ;
	 * <br>以','分隔开样式 如'xxx,xxx';
	 * <br>逗号前半部表示:label 部分css;逗号后半部表示：value部分css;
	 * <br>如果没有','就默认 label标签与value标签用同一个css;
	 */
	public Object getCssClasses() {
		return cssClasses;
	}
	/**
	 * @param cssClasses 样式可以是个集合,这里最多只能存放2个,多出的不做处理 ;
	 * <br>以','分隔开样式 如'xxx,xxx';
	 * <br>逗号前半部表示:label 部分css;逗号后半部表示：value部分css;
	 * <br>如果没有','就默认 label标签与value标签用同一个css;
	 */
	public void setCssClasses(Object cssClasses) {
		this.cssClasses = cssClasses;
	}
	/** @return 要显示的长度 默认长度6个字符(只有在string才有用) */
	public Object getDisplayLength() {
		return displayLength;
	}
	/** @param displayLength 要显示的长度 默认长度6个字符(只有在string才有用) */
	public void setDisplayLength(Object displayLength) {
		this.displayLength = displayLength;
	}
	/**  @return 是否显示提示 true 与 false  , 默认为false;	 */
	public Object getDisplayTitle() {
		return displayTitle;
	}
	/** @param displayTitle 是否显示提示 true 与 false  , 默认为false;	 */
	public void setDisplayTitle(Object displayTitle) {
		this.displayTitle = displayTitle;
	}
	/** @return 类型有四种：null 、string、stringChange、float与date默认为string 
	 * 其中如选择了stringChange必需要注意以下五点：
	 * 1)、 必需要与mapObject 配合使用;
	 * 2)、mapObject格式为key_value形式: 1_红色,2_黑色,...等;
	 * 3)、value格式 为:1_111,2_222,...等;
	 * 4)、最后要输出的结果转换成:红色:111,黑色:222,...等
	 */
	public Object getType() {
		return type;
	}
	/** @param type 类型有四种：null 、string、stringChange、float与date默认为string 
	 * 其中如选择了stringChange必需要注意以下五点：
	 * 1)、 必需要与mapObject 配合使用;
	 * 2)、mapObject格式为key_value形式: 1_红色,2_黑色,...等;
	 * 3)、value格式 为:1_111,2_222,...等;
	 * 4)、最后要输出的结果转换成:红色:111,黑色:222,...等
	 */
	public void setType(Object type) {
		this.type = type;
	}
	/** @return 格式化样式 ,这只对float(可以表示金额)与date(表示时间 )起作用;
	 * float:输出的样式可以 0.00表示格式两位小数位,$0.00表示多加$符号;
	 * date:输出样式可以 yyyy-MM-dd;
	 */
	public Object getFormatStyle() {
		return formatStyle;
	}
	/** @param formatStyle 格式化样式 ,这只对float(可以表示金额)与date(表示时间 )起作用;
	 * float:输出的样式可以 0.00表示格式两位小数位,$0.00表示多加$符号;
	 * date:输出样式可以 yyyy-MM-dd;
	 */
	public void setFormatStyle(Object formatStyle) {
		this.formatStyle = formatStyle;
	}
	/** @return 要展示的对象集合 ;<br>
	 * mapObject格式为key_value形式:1_红色,2_黑色,...等; 表示 数字为对象的id,中文为对象里的名称<br>
	 * 必需配合value使用;value 格式 为:1_111,2_222,...等;这是所指的1表示mapObject里的key,这里的111代表一个数;<br>
	 * 用来转换,格式为：红色:111,黑色:222,...等
	 */
	public Object getMap() {
		return map;
	}
	/** @param map 要展示的对象集合 ;<br>
	 * mapObject格式为key_value形式:1_红色,2_黑色,...等; 表示 数字为对象的id,中文为对象里的名称<br>
	 * 必需配合value使用;value 格式 为:1_111,2_222,...等;这是所指的1表示mapObject里的key,这里的111代表一个数;<br>
	 * 用来转换,格式为：红色:111,黑色:222,...等
	 */
	public void setMap(Object map) {
		this.map = map;
	}
	/** @return value 的点击事件	 */
	public Object getOnclick() {
		return onclick;
	}
	/** @param onclick value 的点击事件 	 */
	public void setOnclick(Object onclick) {
		this.onclick = onclick;
	}

	/**
	 * @return 分解位只能给两值0与1，不是这两个值 就不做处理;<br>
	 * 这个值只能在type='stringChange'时才有用;<br>
	 * 这里所定的是分解到最后成为两位的数组;<br>
	 * 数组格式如：Object[]{1_name1,2_name2...};<br>
	 * 如果是0就提取的是1,2..要显示，是1就提取name1,name2...要显示;
	 */
	public Object getFactorize() {
		return factorize;
	}

	/**
	 * @param factorize 分解位只能给两值0与1，不是这两个值 就不做处理;<br>
	 * 这个值只能在type='stringChange'时才有用;<br>
	 * 这里所定的是分解到最后成为两位的数组;<br>
	 * 数组格式如：Object[]{1_name1,2_name2...};<br>
	 * 如果是0就提取的是1,2..要显示，是1就提取name1,name2...要显示;
	 */
	public void setFactorize(Object factorize) {
		this.factorize = factorize;
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
