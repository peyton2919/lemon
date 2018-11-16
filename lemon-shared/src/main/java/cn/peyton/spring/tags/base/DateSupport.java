package cn.peyton.spring.tags.base;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <h3>时间类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/8/3 16:21
 * Version: 1.0.0
 * </pre>
 * @author peyton
 */
public class DateSupport implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	/** 格式化时间 样式 yyyy-MM-dd hh:mm:ss 年月日 时分秒*/
	public final static String DATE_FORMAT_ALL_0="yyyy-MM-dd hh:mm:ss";
	/** 格式化时间 样式 dd-MM-yyyy hh:mm:ss 日月年  时分秒*/
	public final static String DATE_FORMAT_ALL_1="dd-MM-yyyy hh:mm:ss";
	/** 格式化时间 样式 MM-dd-yyyy hh:mm:ss 月日年 时分秒*/
	public final static String DATE_FORMAT_ALL_2="MM-dd-yyyy hh:mm:ss";
	/** 格式化时间 样式 yyyy/MM/dd hh:mm:ss  年月日 时分秒 */
	public final static String DATE_FORMAT_ALL_3="yyyy/MM/dd hh:mm:ss";
	/** 格式化时间 样式 dd/MM/yyyy hh:mm:ss  日月年  时分秒*/
	public final static String DATE_FORMAT_ALL_4="dd/MM/yyyy hh:mm:ss";
	/** 格式化时间 样式 MM/dd/yyyy hh:mm:ss 月日年 时分秒*/
	public final static String DATE_FORMAT_ALL_5="MM/dd/yyyy hh:mm:ss";
	/** 格式化时间 样式 yyyyMMdd hh:mm:ss  年月日 时分秒*/
	public final static String DATE_FORMAT_ALL_6="yyyyMMdd hh:mm:ss";
	/** 格式化时间 样式 ddMMyyyy hh:mm:ss  日月年  时分秒*/
	public final static String DATE_FORMAT_ALL_7="ddMMyyyy hh:mm:ss";
	/** 格式化时间 样式 MMddyyyy hh:mm:ss 月日年 时分秒*/
	public final static String DATE_FORMAT_ALL_8="MMddyyyy hh:mm:ss";
	
	/** 格式化时间 样式 yyyy-MM-dd 年月日*/
	public final static String DATE_FORMAT_Y_M_D_0="yyyy-MM-dd";
	/** 格式化时间 样式 dd-MM-yyyy 日月年*/
	public final static String DATE_FORMAT_Y_M_D_1="dd-MM-yyyy";
	/** 格式化时间 样式 MM-dd-yyyy 月日年*/
	public final static String DATE_FORMAT_Y_M_D_2="MM-dd-yyyy";
	/** 格式化时间 样式 yyyy/MM/dd 年月日*/
	public final static String DATE_FORMAT_Y_M_D_3="yyyy/MM/dd";
	/** 格式化时间 样式 dd/MM/yyyy 日月年*/
	public final static String DATE_FORMAT_Y_M_D_4="dd/MM/yyyy";
	/** 格式化时间 样式 MM/dd/yyyy 月日年*/
	public final static String DATE_FORMAT_Y_M_D_5="MM/dd/yyyy";
	/** 格式化时间 样式 yyyyMMdd 年月日*/
	public final static String DATE_FORMAT_Y_M_D_6="yyyyMMdd";
	/** 格式化时间 样式 ddMMyyyy 日月年*/
	public final static String DATE_FORMAT_Y_M_D_7="ddMMyyyy";
	/** 格式化时间 样式 MMddyyyy 月日年*/
	public final static String DATE_FORMAT_Y_M_D_8="MMddyyyy";
	
	/** 格式化时间 样式 hh:mm:ss 时分秒*/
	public final static String DATE_FORMAT_H_M_S="hh:mm:ss";
	/** 格式化时间 样式 hhmmss 时分秒*/
	public final static String DATE_FORMAT_H_M_S_0="hhmmss";
	
	/** 
	 * 返回数值型 时间类型	 
	 * @author peyton_yu
	 * @version 1.0
	 * */
	public enum ReturnIntTimeType{
		/**  秒 */ SS ,
		/** 分钟 */ MM , 
		/** 小时*/ HH , 
		/** 天数*/ DAY ;
	}
	/**
	 * 返回字符型 时间类型	 
	 * @author peyton_yu
	 * @version 1.0
	 */
	public enum ReturnStringTimeType{
		/**
		 * 样式为：X天X时X分X秒
		 */
		STRING,
		/**
		 * 样式为：X_X_X_X 天时分秒
		 */
		D_H_M_S,
		/**
		 * 样式为：X_X_X 天时分
		 */
		D_H_M,
		/**
		 * 样式为: X_X 天时
		 */
		D_H,
		/**
		 * 样式为: X天
		 */
		DAY;
	}
	
	/**
	 * 计算两个时间的差
	 * @param date1 时间1 
	 * @param date2 时间2
	 * @param returnIntTimeType 返回 时间 类型，这里指的是天数、小时等
	 * @return 根据时间类型返回 相应的值（这里返回的是整数）
	 */
	public static int calcTime(Date date1 , Date date2 , ReturnIntTimeType returnIntTimeType) {
		long _cs = 0;
		if (date1.getTime() > date2.getTime()) {
			_cs=date1.getTime() -date2.getTime();
		}else{
			_cs = date2.getTime() - date1.getTime();
		}
		if (returnIntTimeType.equals(ReturnIntTimeType.SS)) {
			return (int) (_cs/1000);
		}else if (returnIntTimeType.equals(ReturnIntTimeType.MM)) {
			return (int) (_cs/(60*1000));
		}else if (returnIntTimeType.equals(ReturnIntTimeType.HH)) {
			return (int) (_cs/(60*60*1000));
		}else if (returnIntTimeType.equals(ReturnIntTimeType.DAY)) {
			return (int) (_cs/(24*60*60*1000));
		}
		return 0;
	}
	/**
	 * 计算两个时间的差
	 * @param date1 时间1 
	 * @param date2 时间2
	 * @param returnStringTimeType 返回 时间 类型，这里指的是天数、小时等,默认为空 (样式为：X天X时X分X秒)
	 * @return 根据时间类型返回 相应的值
	 */
	public static String calcTime(Date date1 , Date date2  , ReturnStringTimeType returnStringTimeType) {
		if (returnStringTimeType == null) {
			returnStringTimeType = ReturnStringTimeType.STRING;
		}
		long _cs = 0;
		if (date1.getTime() > date2.getTime()) {
			_cs=date1.getTime() -date2.getTime();
		}else {
			_cs = date2.getTime() - date1.getTime();
		}
		long _day , _hh , _mm , _ss;
		_day=_cs % (24 * 60 * 60 * 1000);
		_hh = _day % (60 * 60 * 1000);
		_mm = _hh % (60 * 1000);
		_ss = _mm % 1000;
		if (returnStringTimeType.equals(ReturnStringTimeType.STRING)) {
			return _day + "天" + _hh + "时" + _mm + "分" + _ss + "秒";
		}else if (returnStringTimeType.equals(ReturnStringTimeType.D_H_M_S)) {
			return _day + "_" + _hh + "_" + _mm + "_" + _ss;
		}else if (returnStringTimeType.equals(ReturnStringTimeType.D_H_M)) {
			return _day + "_" + _hh + "_" + _mm;
		}else if (returnStringTimeType.equals(ReturnStringTimeType.D_H)) {
			return _day + "_" + _hh;
		}else {
			return _day + "天"; 
		}
	}
	
	
	
	/**
	 * 获取当前时间
	 * @param curTimeFormat 要获取当前时间的样式，可以用DateSupport.DATE_FORMAT_ALL_0  ..等获取样式
	 * @param locale 当前时间所在的时区
	 * @return 返回当前时间，异常则返回 null
	 */
	public static Date getCurrentTime(String curTimeFormat , Locale locale){
		SimpleDateFormat sdf = new SimpleDateFormat(curTimeFormat, locale);
		String _string = sdf.format(new Date());
		try {
			return sdf.parse(_string);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 获取当前时间
	 * @param curTimeFormat 要获取当前时间的样式，可以用DateSupport.DATE_FORMAT_ALL_0  ..等获取样式
	 * @return 返回当前时间，异常则返回 null
	 */
	public static Date getCurrentTime(String curTimeFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(curTimeFormat, Locale.CHINA);
		String _string = sdf.format(new Date());
		try {
			return sdf.parse(_string);
		} catch (ParseException e) {
			return null;
		}
	}
	
	
	/**
	 * 比较时间在当前时间之前或相等
	 * @param compareDate 要比较的时间
	 * @return 要比较时间的比当前时间之前或等开当前时间  返回 true ,否则 false;
	 */
	public static boolean compareOfDateBefore(Date compareDate) {
		if (compareDate.getTime() > System.currentTimeMillis()) {	
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 比较时间的大小 
	 * @param d1 要比较的时间1;
	 * @param d2 要比较的时间2;
	 * @return d1大于等开d2 返回 true 否则 false;
	 */
	public static boolean compareOfTwoDateSize(Date d1 , Date d2){
		if (d1.getTime()>=d2.getTime()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 判断时间在某段时间之间
	 * @param compareDate 要判断的时间
	 * @param beginDate 某段时间的开始
	 * @param endDate 某段时间的结束
	 * @return 在某段时间之间（并与之相等） 返回 true 否则 false;
	 */
	public static boolean compareOfTwoDateBetween(Date compareDate , Date beginDate ,
			Date endDate) {
		long cd=compareDate.getTime();
		long bd=beginDate.getTime();
		long ed=endDate.getTime();
		if (cd >= bd && cd <= ed) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 是否是日期时间格式
	 * @param judgeObj 要判断的字符
	 * @param dateFormat 时间格式（可以用本类下的静态常量如：Date.DATE_FORMAT_Y_M_D_0）;
	 * @return 判断正确 返回 true , 否则 false;
	 */
	public static boolean isDate(Object judgeObj , Object dateFormat) {
		try {
			
			 DateFormat df = new SimpleDateFormat(dateFormat.toString());
			 df.parse(judgeObj.toString());
			 return true;
		} catch (Exception e) {
			return false;
		} 
		
	}
	/**
	 * 是否是日期时间格式
	 * @param judgeObj 要判断的字符
	 * @param dateFormats 时间格式数组（可以用本类下的静态常量如：Date.DATE_FORMAT_Y_M_D_0）;
	 * @return 判断正确 返回 true , 否则 false;
	 */
	public static boolean isDate(Object judgeObj , Object dateFormats[]) {
		boolean tReturn = false;
		for (int i = 0; i < dateFormats.length; i++) {
			try {
				DateFormat df = new SimpleDateFormat(dateFormats[i].toString());
				df.parse(judgeObj.toString());
				tReturn=true;
				break;
			} catch (Exception e) {	
			} 
		}
		return tReturn;		
	}
	/**
	 * 字符串转换成日期格式
	 * @param str 日期式的字符串如:2014-01-01 或 Sun Nov 08 13:55:11 CST 2015
	 * @return 日期(异常就返回当前日期)
	 */
	@SuppressWarnings("deprecation")
	public static Date convertDate(String str){
		if (str != null) {
			if (str.length() > 23) {
				return new Date(Date.parse(str));
			}
			else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				ParsePosition pos = new ParsePosition(0);
				return format.parse(str, pos);
			}
		}
		return null;
	}
	
	/**
	 * 字符串转换成日期格式
	 * @param str  日期式的字符串如:2014-01-01 或 Sun Nov 08 13:55:11 CST 2015
	 * @param formatStyle 日期格式化样式 必须与字符串样式 一样
	 * @return 日期 (异常就返回当前日期)
	 */
	@SuppressWarnings("deprecation")
	public static  Date convertDate(String str ,String formatStyle){
		if (formatStyle == null) {
			formatStyle = DATE_FORMAT_ALL_0;
		}
		if (str != null) {
			if (str.length() > 23) {
				return new Date(Date.parse(str));
			}
			else {
				SimpleDateFormat format = new SimpleDateFormat(formatStyle);
				ParsePosition pos = new ParsePosition(0);
				return format.parse(str, pos);
			}
		}
		return null;
	}
	/**
	 * 日期格式字符串转换成 有相应样式的字符串
	 * @param strDate  日期式的字符串如:2014-01-01
	 * @param formatStyle 日期格式化样式 必须与字符串样式 一样
	 * @return 有样式的字符串
	 */
	public static  String convertDateStrFormatStr(String strDate ,String formatStyle){
		if (formatStyle == null) {
			formatStyle = DATE_FORMAT_Y_M_D_0;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStyle);
		ParsePosition pos = new ParsePosition(0);
		Date date = format.parse(strDate, pos);
		return simpleDateFormat(formatStyle, date);
	}
	
	/**
	 * 获得当前时间 的小时
	 * @param date 当前时间 
	 * @return 当前小时
	 */
	public static String getHour(Date date) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(date);
	  return dateString.substring(11, 13);
	}
	/**
	 * 获得当前时间 的分钟
	 * @param date 当前时间
	 * @return 当前分钟
	 */
	public static String getMinutes(Date date) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(date);
		  return dateString.substring(14, 16);
	}
	 /**
	  * 两个时间之间的天数
	  * 
	  * @param date1
	  * @param date2
	  * @return
	  */
	 public static long getDays(String date1, String date2) {
		  if (date1 == null || date1.equals(""))
		   return 0;
		  if (date2 == null || date2.equals(""))
		   return 0;
		  // 转换为标准时间
		  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		  Date date = null;
		  Date mydate = null;
		  try {
		   date = myFormatter.parse(date1);
		   mydate = myFormatter.parse(date2);
		  } catch (Exception e) {
		  }
		  long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		  return day;
	 }
	/**
	 * 生成以当前时间 的文件 名
	 * @return 17位的数字
	 */
	public static String generateDateFileName(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new DateSupport());
	}
	/**
	 * 格式化时间
	 * @param format 格式化时间 样式 如：yyyy-MM-dd hh:mm:ss
	 * @return 数字型字字符串
	 */
	public static String simpleDateFormat(String format)
	{
		SimpleDateFormat sdf =   new SimpleDateFormat(format);
		return sdf.format(new DateSupport());
	}
	/**
	 * 格式化时间
	 * @param format 格式化时间 样式 如：yyyy-MM-dd hh:mm:ss
	 * @param date 格式化时间
	 * @return 数字型字字符串
	 */
	public static String simpleDateFormat(String format , Date date)
	{
		SimpleDateFormat sdf =   new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
}
