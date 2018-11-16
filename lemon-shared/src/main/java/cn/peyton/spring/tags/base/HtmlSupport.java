package cn.peyton.spring.tags.base;

import cn.peyton.spring.tags.entity.Property;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <h3>创建 HTML代码 类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:21
 * Version: 1.0.0
 * </pre>
 * @author peyton
 */
@SuppressWarnings("ALL")
public class HtmlSupport extends AttributeSupport{
	
	/** */
	private static final long serialVersionUID = 1L;

	/** 构造函数 */
	public HtmlSupport(){}
	
	/**
	 * 创建控件Id 标识符
	 * @return 返回  字符(格式 为 id_12_3456_123_456_1样式);
	 */
	public String createID() {
		StringBuffer sb = createRandom();
		return sb.toString();
	}
	
	/**
	 * 创建控件Id 标识符
	 * @param _id 可以为null, 可以用任何英文 如：id、v;
	 * @return 返回 以id_.... 字符(格式 为 id_12_3456_123_456_1样式);
	 */
	public String createID(String _id) {
		StringBuffer sb = createRandom();
		return ((_id != null) ? (_id + "_" + sb) : ("id_" + sb));
	}
	
	/**
	 * 创建控件Id 标识符
	 * @param value 可以为null, 可以用任何英文 如：id、v;
	 * @param last 可以为null, 可以用任何英文 如：id、v;
	 * @return 返回 以id_.... 字符(格式 为 id_12_3456_123_456_1样式);
	 */
	public String createID(String value , String last) {
		StringBuffer sb = createRandom();
		StringBuffer _sb = new StringBuffer();
		_sb.append((value != null) ? (value + "_" + sb) : ("id_" + sb));
		_sb.append((last != null) ? ( "_" + last) : (""));
		return _sb.toString();
	}
	
	/**
	 * 创建控件name 标识符
	 * @param _name 可以为null, 可以用任何英文 如：name、va;
	 * @return 返回 以name_.... 字符(格式 为 name_12_3456_123_456_1样式);
	 */
	public String createName(Object _name) {
		StringBuffer sb = createRandom();
		return ((_name != null) ? (_name + "_" + sb) : ("name_" + sb));
	}
	
	/**
	 * 创建控件name 标识符
	 * @param value 可以为null, 可以用任何英文 如：name、va;
	 * @param last 可以为null, 可以用任何英文 如：name、va;
	 * @return 返回 以name_.... 字符(格式 为 name_12_3456_123_456_1样式);
	 */
	public String createName(String value , String last) {
		StringBuffer sb = createRandom();
		StringBuffer _sb = new StringBuffer();
		_sb.append((value != null) ? (value + "_" + sb) : ("name_" + sb));
		_sb.append((last != null) ? ( "_" + last) : (""));
		return _sb.toString();
	}
	/**
	 * 创建以时间为样的随机数
	 * @return 返回13位与4个'_'组成的随机数 样式为12_3456_123_456_2 样式 ,<br>下划线为不随机产生的
	 */
	public StringBuffer createRandom() {
		String s = System.currentTimeMillis() + "";
		Random rd = new Random();
		int _n = 0;
		StringBuffer sb= new StringBuffer();
		for (int i = 0 ; i < 2 ; i++) {
			_n = rd.nextInt((6));
			_n = (_n == 0 ) ? 1 : _n;
			sb.append(s.substring( i * 6, ( i * 6 ) + _n ) + "_");
			sb.append(s.substring(_n +i * 6, (i + 1) * 6) + "_");
		}
		return sb.append(s.substring(12, 13));
	}
	/**
	 * 创建以时间为样的随机数
	 * @param head 最前面的字符
	 * @param last 最后面的字符
	 * @return 返回13位与4个'_'组成的随机数 样式为head+12_3456_123_456_2+last 样式 ,<br>下划线为不随机产生的
	 */
	public StringBuffer createRandom(String head , String last) {
		String s = System.currentTimeMillis() + "";
		Random rd = new Random();
		int _n=0;
		StringBuffer sb= new StringBuffer();
		sb.append(head);
		for (int i = 0; i < 2; i++) {
			_n = rd.nextInt((6));
			_n = (_n == 0 ) ? 1 : _n;
			sb.append(s.substring(i*6, (i*6)+_n)+"_");
			sb.append(s.substring(_n +i *6, (i+1)*6) + "_");
		}
		sb.append(last);
		return sb.append(s.substring(12, 13));
	}
	/**
	 * 创建以时间为样的随机数
	 * @param head 最前面的字符
	 * @return 返回13位与4个'_'组成的随机数 样式为head+12_3456_123_456_2 样式 ,<br>下划线为不随机产生的
	 */
	public StringBuffer createRandom(String head) {
		String s = System.currentTimeMillis() + "";
		Random rd = new Random();
		int _n=0;
		StringBuffer sb= new StringBuffer();
		sb.append(head);
		for (int i = 0; i < 2; i++) {
			_n = rd.nextInt((6));
			_n = (_n == 0 ) ? 1 : _n;
			sb.append(s.substring((i * 6), (i * 6) + _n)+"_");
			sb.append(s.substring((_n + i * 6) , (i + 1) * 6) + "_");
		}
		return sb.append(s.substring(12, 13));
	}
	
	/**
	 * 创建 浮点 格式化样式
	 * @param formatStyle 可以为null,如果这里给的是null,则默认给的样式 为0.00
	 * @param value 要格式代的值
	 * @return 转换成功就返回相应的值,否则就返回null
	 */
	public StringBuffer createFormatStyleFloat(Object formatStyle , Object value) {
		StringBuffer _sb = new StringBuffer();
		if(formatStyle == null) formatStyle = FORMAT_STYLE_FLOAT;
		try {
			double _value= Double.parseDouble(value.toString());
			//小数格式化
			DecimalFormat fnum = new DecimalFormat(formatStyle.toString()); 
			_sb.append(fnum.format(_value));//赋值
		}catch(Exception e){}
		return _sb;
	}
	/**
	 * 创建 时间 格式化样式
	 * @param formatStyle 可以为null,如果这里给的是null,则默认给的样式 为'yyyy-MM-dd'
	 * @param value 要格式代的值
	 * @return 转换成功就返回相应的值,否则就返回null
	 */
	public StringBuffer createFormatStyleDate(Object formatStyle , String value){
		StringBuffer _sb = new StringBuffer();
		//判断formatStyle为空就默认格式为yyyy-MM-dd
		if(formatStyle == null) formatStyle = FORMAT_STYLE_DATE;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStyle.toString());
			if (value.length() >= 28) {
				@SuppressWarnings("deprecation")
				Date date = new Date(value);
				_sb.append(sdf.format(date));
			}else {
				_sb.append(sdf.format(sdf.parse(value)));
			}
			
		}catch(Exception e){}
		return _sb;
	}
	/**
	 * 分割字符串
	 * @param object 字符串
	 * @return 字符串数组
	 */
	public String[] split(Object object) {
		if (object != null) {
			int l =object.toString().lastIndexOf(",");
			String[] _s =object.toString().split(",");
			if (l == object.toString().length()-1) {
				String[] _ss = new String[_s.length+1];
				for (int i = 0; i < _s.length; i++) {
					_ss[i] = _s[i];
				}
				_ss[_ss.length-1] ="";
				return _ss;
			}
			return _s;
		}
		return null;
	}
	
	/**
	 * 分割字符串
	 * @param object 字符串
	 * @param sign 分割符
	 * @return 字符串数组
	 */
	public String[] split(Object object , String sign) {
		if (object != null) {
			int l =object.toString().lastIndexOf(",");
			String[] _s =object.toString().split(sign);
			if (l == object.toString().length()-1) {
				String[] _ss = new String[_s.length+1];
				for (int i = 0; i < _s.length; i++) {
					_ss[i] = _s[i];
				}
				_ss[_ss.length-1] ="";
				return _ss;
			}
			return _s;
		}
		return null;
	}
	
	/**
	 * 创建Label标签
	 * @param _id 元素Id
	 * @param _label  左边 提示的标签
	 * @param _css 样式
	 * @return 组合成HTML格式的标签
	 */
	public StringBuffer createLabelMessage(Object _id , Object _label , Object _css ){
		StringBuffer sb = new StringBuffer();
		if (_label != null) {
			sb.append("<label");
			sb.append((_id == null) ? " for=\"" + createID()+ "\" " :" for=\"" + _id + "\" ");
			sb.append((_css != null) ? " class=\"" + _css + "\"" : "");
			sb.append(">" + _label + "</label>");
		}
		return sb;
	}

    /**
     * 创建Label标签
     * @param _id 元素Id
     * @param _name 元素名称
     * @param _label  左边 提示的标签
     * @param _css 样式
     * @return 组合成HTML格式的标签
     */
    public StringBuffer createLabelMessage(Object _id , Object _name , Object _label , Object _css ){
        StringBuffer sb = new StringBuffer();
        if (_label != null) {
            sb.append("<label");
            sb.append((_id == null) ? " id=\"tid_" + createID()+ "\" " :" id=\"" + _id + "\" ");
            sb.append((_name == null) ? " name=\"tname_"+ createID() + "\" " : " name=\""+ _name + "\" ");
            sb.append((_css != null) ? " class=\"" + _css + "\"" : "");
            sb.append(">" + _label + "</label>");
        }
        return sb;
    }

	/**
	 * 创建Label的标签
	 * @param _id 元素Id
	 * @param _name 元素名称
	 * @param _value 显示的值(这里所用一般都是从数据库里得来的)
	 * @param _css 样式
	 * @param _isTitle 是否要显示title
	 * @param _onclick 元素的点击事件
	 * @param _length 要显示长度  用大于0来区分 是处理字符还是日期等,小于0表示是处理 float 与 date
	 * @return  组合成HTML格式的标签
	 */
	public StringBuffer createLabelMessage(Object _id , Object _name , Object _value , Object _css
				, boolean _isTitle , Object _onclick , int _length){
		StringBuffer sb = new StringBuffer();
		if (_value !=null) {
			sb.append("<label ");
			sb.append((_id == null) ? " id=\"tid_" + createID()+ "\" " :" id=\"" + _id + "\" ");
			sb.append((_name == null) ? " name=\"tname_"+ createID() + "\" " : " name=\""+ _name + "\" ");
			sb.append((_css != null) ? "class=\"" + _css + "\" " : "");
			sb.append((_isTitle) ? "title=\"" + _value + "\" " : "");
			sb.append((_onclick != null) ? "onclick=\"" + _onclick + "\" " : "");
			sb.append(">");
			sb.append((_value.toString().length() > _length && _length > 0) ? 
					_value.toString().substring(0, _length)+"..." : _value);
			sb.append("</label>");
		}
		return sb;
	}
	
	/**
	 * 添加属性
	 * @param property 属性名称
	 * @param value 属性值 
	 * @return 拼接成的HTML语句;如: color="red"
	 */
	public StringBuffer createPropertyMessage(String property , Object value) {
		return new StringBuffer().append((value != null )? (" " + property + "=\"" + value +"\""):"");
	}
	
	/**
	 * <h4>创建属性信息 用于创建ID、name等,生成的值为'前缀_当前时间long'</h4>
	 * @param property 属性名称
	 * @param value 属性值 
	 * @param prefix 前缀 
	 * @return 拼接成的HTML语句;如: color="red"
	 */
	public StringBuffer createPropertyMessage(String property ,Object value,String prefix) {
		return new StringBuffer().append((value != null )? (" " + property + "=\"" + value +"\""):
			" " + property + "=\"" + prefix +"_" + new Date().getTime() +"\"");
	}

	/**
	 * 添加属性
	 * @param _plists 属性名称与属性值的集合
	 * @return 拼接成的HTML语句;如: color="red";
	 */
	public StringBuffer createProperty(List<Property> _plists) {
		StringBuffer _sb = new StringBuffer();
		if (_plists != null) {
			for (int i = 0; i < _plists.size(); i++) {
				_sb.append(" " + _plists.get(i).getName() +"=\"" + _plists.get(i).getValue() + "\"");
			}
		}
		return _sb;
	}
	
	/**
	 * 创建input 标签
	 * @param _id 元素Id
	 * @param _name  元素名称
	 * @param _value 显示的值(这里所用一般都是从数据库里得来的)
	 * @param _type input类型,给null就默认text;
	 * @param _plists 其它元素名称、其它元素值集合
	 * @return  组合成HTML格式的标签
	 */
	public StringBuffer createTextMessage(Object _id , Object _name , Object _value , Object _type ,
				List<Property> _plists){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<input");
		sb.append((_type == null) ? " type=\"text\"" :" type=\""+ _type + "\" " );
		sb.append((_id == null) ? " id=\"t_tid_" + createID() + "\"" : " id=\"" + _id + "\" ");
		sb.append((_name == null) ? " name=\"t_tname_" + createID() + "\"" : " name=\"" + _name + "\"" );
		if (_plists != null) {
			for (int i = 0; i < _plists.size(); i++) {
				sb.append(" " + _plists.get(i).getName() +"=\"" + _plists.get(i).getValue() + "\"");
			}
		}
		sb.append((_value != null) ? " value=\"" + _value + "\"" : "");
		sb.append("></input>");
		
		return sb;
	}
	
	/**
	 * 创建input 标签
	 * @param _id 元素Id
	 * @param _name  元素名称
	 * @param _value 显示的值(这里所用一般都是从数据库里得来的)
	 * @param _type input类型,给null就默认text;
	 * @param parms 其它元素名称、其它元素值
	 * @param maxLength 用来设置文本框最大长度
	 * @return  组合成HTML格式的标签
	 */
	public StringBuffer createTextMessage(Object _id , Object _name , Object _value , Object _type ,
			StringBuffer parms , int maxLength){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<input");
		sb.append((_type == null) ? " type=\"text\"" :" type=\""+ _type + "\" " );
		sb.append((_id == null) ? " id=\"t_tid_" + createID() + "\"" : " id=\"" + _id + "\" ");
		sb.append((_name == null) ? " name=\"t_tname_" + createID() + "\"" : " name=\"" + _name + "\"" );
		sb.append((_value != null) ? " value=\"" + _value + "\"" : "");
		sb.append((parms != null) ?  parms : "");
		sb.append((maxLength > 0) ? " maxlength=\"" + maxLength + "\"" : "");
		sb.append("></input>");
		
		return sb;
	}
    /**
     * 创建select 标签
     * @param _map 集合
     * @param _id 元素Id
     * @param _name  元素名称
     * @param _value 下拉框选中的值
     * @param _css 下拉框样式
     * @return  组合成HTML格式的标签
     */
    public StringBuffer createSelectMessage(Map<String, String> _map,String _id, String _name, String _value, String _css) {
        boolean initData = false;
        if (null != _value && !"".equals(_value.trim())) {
            initData = true;
        }
        String[] spilts = null;
        boolean layer = false;
        if (_css != null && !"".equals(_css.trim())) {
            spilts = _css.split(" ");
            if (spilts.length > 1) {
                layer = true;
            }
        }
        int auto = 0;
        StringBuffer sb = new StringBuffer();
        if (layer) {
            sb.append("<div class=\"");
            sb.append(spilts[auto]);
            sb.append("\">");
            auto ++;
        }
        sb.append("<select");
        sb.append((_id == null) ? " id=\"" + createID() + "\"" : " id=\"" + _id + "\" ");
        if (layer) {
            int length = spilts.length;
            String temp = "";
            if (length > auto) {
                for (int i = auto; i < length; i++) {
                    temp += spilts[i] + " ";
                }
                sb.append(" class=\"" + temp + "\"");
            }
        }
        if (_css != null && !"".equals(_css.trim()) && !layer){
            sb.append(" class=\"" + spilts[0] + "\"");
        }
        sb.append((_name != null && !"".equals(_name.trim())) ? " name=\"" + _name + "\"" : "");
        sb.append(">");
        for (String key : _map.keySet()) {
            sb.append("<option value=\"" + key + "\"");
            if (initData){
                if (_value.trim().equals(key)) {
                    sb.append(" selected=\"selected\"");
                }
            }
            sb.append(">");
            sb.append(_map.get(key));
            sb.append("</option>");
        }
        sb.append("</select>");
        if (layer) {
            sb.append("</div>");
        }
        return sb;
    }
	
	/**
	 * 添加table标签
	 * @param content 内容
	 * @return 一个完整的表的HTML格式
	 */
	public StringBuffer createTable(String content) {
		return _createTable(content, null);
	}
	/**
	 * 添加table标签
	 * @param content 内容
	 * @param css 表格样式 
	 * @return 一个完整的表的HTML格式
	 */
	public StringBuffer createTable(String content , String css) {	
		return _createTable(content, css);
	}
	
	
	/**
	 * 添加 table TR标签
	 * @param content 内容
	 * @return 一组以TR的HTML格式
	 */
	public StringBuffer createTableTR(String content) {		
		return _createTableTR(content, null);
	}
	/**
	 * 添加 table TR标签
	 * @param content 内容
	 * @param css TR样式
	 * @return 一组以TR的HTML格式
	 */
	public StringBuffer createTableTR(String content , String css) {
		return _createTableTR(content, css);
	}
	
	/**
	 * 添加 table TD标签
	 * @param content 内容
	 * @return 一组以TD的HTML格式
	 */
	public StringBuffer createTableTD(String content) {
		return _createTableTD(content, null, -1 ,-1);
	}
	/**
	 * 添加 table TD标签
	 * @param content 内容
	 * @param css TD样式
	 * @return 一组以TD的HTML格式
	 */
	public StringBuffer createTableTD(String content , String css) {
		return _createTableTD(content, css, -1 ,-1);
	}

	/**
	 * 添加 table TD标签
	 * @param content 内容
	 * @param css TD样式
	 * @param colspan  TD列相跨数量,用0表示不设置;
	 * @param rowspan  TD行相跨数量,用0表示不设置;
	 * @return 一组以TD的HTML格式
	 */
	public StringBuffer createTableTD(String content , String css , int colspan , int rowspan) {
		return _createTableTD(content, css, colspan , rowspan);
	}

	/**
	 * 创建 隐藏 控件
	 * @param name 名称
	 * @param value 值
	 * @return HTML格式代码
	 */
	public StringBuffer createHidden(String name , String value){
		StringBuffer _sb = new StringBuffer();
		_sb.append("<input type=\"hidden\"");
		_sb.append(" name=\"" + name + "\"");
		_sb.append(" value=\"" + value + "\"");
		_sb.append(" id=\"" + name +"_" + createID() + "\" />");
		return _sb;
	}
	/**
	 * 创建 form 头部信息
	 * @param formId form编号 格式如:form_id_
	 * @param formName form名称 格式如:form_name_
	 * @param action action 名称
	 * @return HTML格式代码
	 */
	public StringBuffer createFormHeader(String formId , String formName , String action){
		StringBuffer _sb = new StringBuffer();
		_sb.append("<form");
		_sb.append(" id=\"" + formId +"\"");
		_sb.append(" name=\"" + formName +"\"");
		_sb.append(" action=\"" + action + "\"  method=\"post\">");
		return _sb;
	}
	/**
	 * 创建form 底部信息
	 * @return HTML格式代码
	 */
	public StringBuffer createFormBottom(){
		return new StringBuffer().append("</form>");
	}
	/**
	 * 创建 提交按钮 struts推动脚本
	 * @param submitId 提交按钮id
	 * @return HTML格式代码
	 */
	public StringBuffer createStrutsPushScript(String submitId) {
		return (new StringBuffer().append("<script language=\"JavaScript\" type=\"text/javascript\">djConfig.searchIds.push(\""
						+ submitId +"\");</script>"));
	}
	
	/**
	 * 添加table标签
	 * @param content 内容
	 * @param css 表格样式 
	 * @return 一个完整的表的HTML格式
	 */
	private StringBuffer _createTable (String content , String css) {
		StringBuffer _sb = new StringBuffer();
		_sb.append("<table");
		_sb.append(getClassCss(css));
		_sb.append(">");
		_sb.append(content);
		_sb.append("</table>");
		return _sb;
	}
	
	/**
	 * 添加 table TR标签
	 * @param content 内容
	 * @param css TR样式
	 * @return 一组以TR的HTML格式
	 */
	private StringBuffer _createTableTR(String content , String css) {
		StringBuffer _sb = new StringBuffer();
		_sb.append("<tr");
		_sb.append(getClassCss(css));
		_sb.append(">");
		_sb.append(content);
		_sb.append("</tr>");
		return _sb;
	}
	
	/**
	 * 添加 table TD标签
	 * @param content 内容
	 * @param css TD样式
	 * @param colspan  TD列相跨数量,用0表示不设置;
	 * @param rowspan  TD行相跨数量,用0表示不设置;
	 * @return 一组以TD的HTML格式
	 */
	private StringBuffer _createTableTD(String content , String css , int colspan , int rowspan) {
		StringBuffer _sb = new StringBuffer();
		_sb.append("<td");
		_sb.append(getClassCss(css));
		_sb.append((colspan > 0) ? " colspan=\"" + colspan + " \"" : "");
		_sb.append((rowspan >0) ? " rowspan=\"" + rowspan + " \"" : "");
		_sb.append(">");
		_sb.append(content);
		_sb.append("</td>");
		return _sb;
	}
	
	/**
	 * <h4>css私有样式</h4>
	 * @param css css样式
	 * @return 拼接好的css 格式" class='css' "
	 */
	private String getClassCss(String css) {
		return  ((css != null) ? " class=\"" + css + " \"" : "");
	}
}
