package cn.peyton.spring.def;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.BindingResult;

/**
 * <h3>action 基础验证类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:56
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class BaseValidate implements Serializable{

	/** */
	private static final long serialVersionUID = 1L;
	/** 添加 不为空 校验 提示信息*/
	public static String TIP_MESSAGE_REQUIRED = "不能为空？";
	/** 字符串 校验 提示信息*/
	public static String TIP_MESSAGE_ADD_REQUIRED_STRING = "";
	/** 整数 校验 提示信息*/
	public static String TIP_MESSAGE_ADD_INT = "";
	/** 浮点 校验 提示信息*/
	public static String TIP_MESSAGE_ADD_DOUBLE = "";
	/** 日期 校验 提示信息*/
	public static String TIP_MESSAGE_ADD_DATE = "";
	/** 邮件 校验 提示信息*/
	public static String TIP_MESSAGE_ADD_EMAIL = "";
	/** 网址 校验 提示信息*/
	public static String TIP_MESSAGE_ADD_URL = "";
	/** 字符串长度 校验 提示信息*/
	public static String TIP_MESSAGE_ADD_STRING_LENGTH = "";
	/** 重名 校验 提示信息*/
	public static String TIP_MESSAGE_ADD_RENAME = "已有相同名称?";
	/** 添加 字符串最大长度校验信息 */
	public static String TIP_MESSAGE_ADD_STRING_MAX_LENGTH  = "字符串长度太长?";
	/** 添加 字符串最小长度校验信息 */
	public static String TIP_MESSAGE_ADD_STRING_MIN_LENGTH  = "字符串长度太短?";
	
	/** 字符串 更新 不为空 校验 提示信息*/
	public static String TIP_MESSAGE_UPDATE_REQUIRED_STRING = "";
	/** 整数 更新 校验 提示信息*/
	public static String TIP_MESSAGE_UPDATE_INT = "";
	/** 浮点 更新 校验 提示信息*/
	public static String TIP_MESSAGE_UPDATE_DOUBLE = "";
	/** 日期 更新 校验 提示信息*/
	public static String TIP_MESSAGE_UPDATE_DATE = "";
	/** 邮件 更新 不为空 校验 提示信息*/
	public static String TIP_MESSAGE_UPDATE_EMAIL = "";
	/** 网址 更新 校验 提示信息*/
	public static String TIP_MESSAGE_UPDATE_URL = "";
	/** 字符串长度 更新 校验 提示信息*/
	public static String TIP_MESSAGE_UPDATE_STRING_LENGTH = "";
	/** 更新 重名 校验 提示信息*/
	public static String TIP_MESSAGE_UPDATE_RENAME = "已存在，无法更新？";
	/** 更新 字符串最大长度校验信息 */
	public static String TIP_MESSAGE_UPDATE_STRING_MAX_LENGTH  = "字符串长度太长?";
	/** 更新 字符串最小长度校验信息 */
	public static String TIP_MESSAGE_UPDATE_STRING_MIN_LENGTH  = "字符串长度太短?";
	
	/** 邮箱 验证 正则表达式<br>  样式 ：XYZZZ@XXX.YYY */
	public static final String REGX_SIMPLE_EMAIL  =  "^(^([a-z0-9A-Z]+[-|\\.]?)+"
					+ "[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$)$";
	
	/** 手机 验证 正则表达式<br>  样式 ：130(到139)12345678 <br>150(到159不含154)12345678<br> 180(到189)12345678 */
	public static final String REGX_SIMPLE_PHONE = "^((((13[0-9])|(15[^4,\\D])|(18[0-9]))+((\\d{8})|(\\d{8}\\s)))+)$";
	
	/** 电话 验证 正则表达式<br>  样式 ：1234567 12345678<br> 0001234567 0001245678 <br>00001234567 000012345678
	 * <BR> 000-1234567 000-12345678 <br>0000-1234567 0000-12345678 */
	public static final String REGX_SIMPLE_TEL = "^((((\\d{3,4})+[\\-\\s])|(\\d{0})|(\\d{3,4}))+(\\d{7,8}))$";
	
	/** 电话与手机 验证 正则表达式<br>  样式 ：1234567 12345678<br> 0001234567 0001245678 <br>00001234567 000012345678
	 * <BR> 000-1234567 000-12345678 <br>0000-1234567 0000-12345678<br>130(到139)12345678 
	 * <br>150(到159不含154)12345678<br> 180(到189)12345678   */
	public static final String REGX_SIMPLE_TEL_PHONE = "^(((((\\d{3,4})+[\\-\\s])|(\\d{0})|(\\d{3,4}))+"
					+ "(\\d{7,8}))|(((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}))$";
	
	/** 中文验证 正则表达式<br>  样式 ：2000/01/01 | 2000 01 01 | 2000-01-01 | <BR>
	 * 2000/01/01 12:00:00 | 2000 01 01 12:00:00 | 2000-01-01 12:00:00 */
	public static final String REGX_SIMPLE_DATE = "^((\\d{2}(([02468][048])|"
				+ "([13579][26]))[\\-\\/\\s]?((((0?[13578])|"
				+ "(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))"
				+ "|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))"
				+ "|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|"
				+ "(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|"
				+ "(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|"
				+ "(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|"
				+ "(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))"
				+ "(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
	
	/** 整数 验证 正则表达式<br>  样式 ： */
	public static final String REGX_SIMPLE_INT = "^(\\d+)$";
	/** 正负整数 验证 正则表达式<br>  样式 ： */
	public static final String REGX_SIMPLE_INT_ALL = "^(-)?[1-9][0-9]*$";
	
	/** QQ 验证 正则表达式<br>  样式 ：最少5位数字  */
	public static final String REGX_SIMPLE_QQ = "^((([1-9](\\d){4,14})|([1-9](\\d){4,14}\\s))+)$";
	
	/** 整数(0-100) 验证 正则表达式<br>  样式 ： */
	public static final String REGX_SIMPLE_INT_0_100 = "^((\\d{0,2})|([1][0][0]))$";
	
	/** 浮点小数(0-1)  验证 正则表达式 <br>  样式 ：*/
	public static final String REGX_SIMPLE_FLOAT_0_1 = "^(([0]+\\.+\\d+)|([1]+\\.+[0]+))$";
	
	/** 金钱小数(2)  验证 正则表达式 <br>  样式 ：*/
	public static final String REGX_SIMPLE_MONEY = "^([1-9][\\d]{0,7}|0)(\\.[\\d]{1,2})?$";
	
	
	/** 浮点小数  验证 正则表达式 <br>  样式 ：*/
	public static final String REGX_SIMPLE_DOUBLE = "^(\\d+\\.+\\d+)$";
	
	/** 浮点小数与 整数  验证 正则表达式 <br>  样式 ：*/
	public static final String REGX_SIMPLE_INT_DOUBLE = "^((\\d+\\.+\\d+)||(\\d+))$";
	
	/** 网址验证 正则表达式 <br>  样式 ：http://www.baidu.com <br> http://baidu.com  */
	public static final String REGX_SIMPLE_URL = "^(http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?)$";
	
	/** 中文验证 正则表达式<br>  样式 ： */
	public static final String REGX_SIMPLE_CHINESE = "^([\u4e00-\u9fa5]{0,})$";
	/** 身份证验证 正则表达式<br>  样式 ： */
	public static final String REGX_SIMPLE_IDENTITY = "^((\\d{15})|(\\d{18})|(\\d{17}(\\d|X|x)))$";
	
	/**
	 * <p style="color:red">正则校验</p>
	 * @param check 校验规则 (在本类中以REGX_开头的静态属性)
	 * @param valiField 要校验的字符
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean regx(String check , Object valiField ){
		try {
			Pattern p = Pattern.compile(check);
			Matcher m = p.matcher(valiField.toString());
			return (m.matches());
		} catch (Exception e) { }
		return false;
	}
	
	/**
	 * <p style="color:red">正则校验</p>
	 * 
	 * @param result springMVC错误返回绑定对象
	 * @param fieldName 要判断控件的name 如：对象.属性名 (object.objectName);
	 * @param errorCode 错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param valiField 要校验的字符
	 * @param check 校验规则 (在本类中以REGX_开头的静态属性)
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean validateRegx(BindingResult result , 
			String fieldName, String errorCode , Object valiField , String check){
		if(valiField != null){
			if(!(regx(check, valiField))){
				result.rejectValue(fieldName, errorCode);
				return false;
			}
		}
		return true;
	}
	/**
	 * <p style="color:red">正则校验(多个)</p>
	 * <p>fieldNames、valiFields、errorCodes、checks 四个数组对象 要相对应 </p>
	 * @param result springMVC错误返回绑定对象;
	 * @param fieldNames 要判断控件的name 如：对象.属性名 (object.objectName);
	 * @param errorCodes 错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param valiFields 要校验的字符
	 * @param checks 校验规则 (在本类中以REGX_开头的静态属性)
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean validateRegx(BindingResult result , 
			String[] fieldNames ,String[] errorCodes , Object[] valiFields , String[] checks){
		if(valiFields != null) {
            for (int i = 0; i < valiFields.length; i++) {
                if (valiFields[i] != null) {
                    if (!(regx(checks[i], valiFields[i]))) {
                        result.rejectValue(fieldNames[i], errorCodes[i]);
                        return false;
                    }
                }
            }
        }
		return true;
	}
	
	
	/**
	 * <p style="color:red">校验字符串长度</p>
	 * @param str 要校验的字符串
	 * @param maxLength 要校验的最大长度
	 * @return true 表示校验通过 (小于等于最大限制长度);<br> false 表示没校验通过(大于最大限制长度);
	 */
	public static boolean validateStringLength(String str , int maxLength){
		if(str !=null) {
            if (str.trim().length() <= maxLength) {
                return true;
            }
        }
		return false;
	}
	
	/**
	 * <p style="color:red">校验字符串长度 (多个)</p>
	 * <p>strs与maxLengths 要相对应 的数组</p>
	 * @param strs 要校验的字符串数组
	 * @param maxLengths 要校验的最大长度数组
	 * @return true 表示校验通过 (小于等于最大限制长度);<br> false 表示没校验通过(大于最大限制长度);
	 */
	public static boolean validateStringLength(String[] strs , int[] maxLengths){
		if(strs != null ) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null) {
                    if (strs[i].trim().length() <= maxLengths[i]) {
                        return true;
                    }
                }
            }
        }
		return false;
	}
	
	/**
	 * <p style="color:red">校验字符串长度(多个)</p>
	 * <p>strs、minLengths与maxLengths 要相对应 的数组</p>
	 * @param strs 要校验的字符串数组
	 * @param minLengths 要校验的最小长度数组
	 * @param maxLengths 要校验的最大长度数组
	 * @return true 表示校验通过 (小于等于最大限制长度、并且大于等于最小限制长长度);<br> 
	 * 			false 表示没校验通过(大于最大限制长度、或小于最小限制长长度);
	 */
	public static boolean validateStringLength(String[] strs , int[] minLengths , int[] maxLengths){
		if(strs != null ) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null) {
                    if (strs[i].trim().length() <= maxLengths[i] &&
                            strs[i].trim().length() >= minLengths[i]) {
                        return true;
                    }
                }
            }
        }
		return false;
	}
	
	/**
	 * <p style="color:red">校验字符串长度</p>
	 * @param str 要校验的字符串
	 * @param minLength 要校验的最小长度
	 * @param maxLength 要校验的最大长度
	 * @return true 表示校验通过 (小于等于最大限制长度、并且大于等于最小限制长长度);
	 * 			<br> false 表示没校验通过(大于最大限制长度、或小于最小限制长长度);
	 */
	public static boolean validateStringLength(String str , int minLength , int maxLength){
		if(str !=null) {
            if (str.trim().length() <= maxLength && str.trim().length() >= minLength) {
                return true;
            }
        }
		return false;
	}

	/**
	 * <p style="color:red"> 不为空验证 ; </p>
	 * 
	 * @param result springMVC错误返回绑定对象
	 * @param fieldName 要判断控件的name 如：对象.属性名 (object.objectName);
	 * @param errorCode 错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param object 要判断控件对象的对象属性 如：对象.getXxx(object.getObjctName);
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean validateRequired(BindingResult result , 
			String fieldName , String errorCode , Object object){
        //判断是否为空
		if("".equals(object) || object == null){
			result.rejectValue(fieldName, errorCode);
			return false;
		}
		return true;
		
	}

	/**
	 * <p style="color:red"> 不为空验证 (多个); </p>
	 * <p>fieldNames、errorCodes、objects 三个数组对象 要相对应 </p>
	 * 
	 * @param result springMVC错误返回绑定对象
	 * @param fieldNames 要判断控件的name数组  如：对象.属性名 (object.objectName);
	 * @param errorCodes 错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param objects 要判断控件对象的对象属性数组  如：对象.getXxx(object.getObjctName);
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean validateRequired(BindingResult result , 
			String[] fieldNames, String[] errorCodes , Object[] objects ){ 
		if(fieldNames!=null && objects != null && errorCodes != null ) {
            for (int i = 0; i < fieldNames.length; i++) {
                //判断是否为空
                if ("".equals(objects[i]) || objects[i] == null) {

                    result.rejectValue(fieldNames[i], errorCodes[i]);
                    return false;
                }
            }
        }
		return true;
	}
	
	/**
	 * <p style="color:red"> 不为空验证 ; <br>与控件最大长度验证(单个)</p>
	 * 
	 * @param  result springMVC错误返回绑定对象
	 * @param fieldName 要判断控件的name 如：对象.属性名 (object.objectName);
	 * @param errorCode 为空错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param errorCodeLength 长度错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param object 要判断控件对象的对象属性 如：对象.getXxx(object.getObjctName);
	 * @param maxLength 要判断控件最大长度 
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean validateRequired(BindingResult result , String fieldName , 
			String errorCode , String errorCodeLength , Object object , int maxLength){
        //判断是否为空
		if(null == object || "".equals(object)){
			result.rejectValue(fieldName, errorCode);
			return false;
            //对象不为空
		}else if(object != null ){
            //判断最大长度
			if(object.toString().length() > maxLength){
				result.rejectValue(fieldName, errorCodeLength);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p style="color:red"> 不为空验证 (多个);<br>与控件最大长度验证(多个)</p>
	 * <p>fieldNames、errorCodes 、errorCodeLengths 、objects、maxLengths 四个数组对象 要相对应 </p>
	 * 
	 * @param result springMVC错误返回绑定对象
	 * @param fieldNames 要判断控件的name数组  如：对象.属性名 (object.objectName);
	 * @param errorCodes 为空错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param errorCodeLengths 长度错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param objects 要判断控件对象的对象属性数组  如：对象.getXxx(object.getObjctName);
	 * @param maxLengths 要判断控件最大长度 数组
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean validateRequired(BindingResult result , String[] fieldNames , 
			String[] errorCodes, String[] errorCodeLengths ,Object[] objects  , int[] maxLengths){ 
		if(fieldNames!=null && objects != null && errorCodes != null && maxLengths != null ) {
            for (int i = 0; i < fieldNames.length; i++) {
                //判断是否为空
                if (null == objects[i] || "".equals(objects[i])) {
                    result.rejectValue(fieldNames[i], errorCodes[i]);
                    return false;
                    //对象不为null
                } else if (objects[i] != null) {
                    //判断最大长度
                    if (objects[i].toString().length() > maxLengths[i]) {
                        result.rejectValue(fieldNames[i], errorCodeLengths[i]);
                        return false;
                    }
                }
            }
        }
		return true;
	}
		
	/**
	 * <p style="color:red"> 不为空验证 ;<br>与控件最小长度验证(单个) <br>与控件最大长度验证(单个)</p>
	 * 
	 * @param result springMVC错误返回绑定对象;
	 * @param fieldName 要判断控件的name 如：对象.属性名 (object.objectName);
	 * @param errorCode 为空错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param errorCodeMin 最小长度错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param errorCodeMax 最大长度错误码,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param object 要判断控件对象的对象属性 如：对象.getXxx(object.getObjctName);
	 * @param minLength 要判断控件最小长度 
	 * @param maxLength 要判断控件最大长度 
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean validateRequired(BindingResult result , String fieldName , String errorCode ,
			String errorCodeMin , String errorCodeMax , Object object , int minLength , int maxLength){
        //判断是否为空
		if(null == object || "".equals(object)){
			result.rejectValue(fieldName, errorCode);
			return false;
            //对象不为null
		}else if(object != null ){
            //判断最大长度
			if(object.toString().length() > maxLength){
				result.rejectValue(fieldName, errorCodeMax);
				return false;
                //判断最小长度
			}else if(object.toString().length() < minLength){
				result.rejectValue(fieldName, errorCodeMin);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p style="color:red"> 不为空验证 (多个);<br>与控件最小长度验证(多个)<br>与控件最大长度验证(多个)</p>
	 * <p>要验证的action要继承 BaseOriginlAction基础类</p>
	 * <p>fieldNames、objects、tipNames、maxLengths 四个数组对象 要相对应 </p>
	 *
     * @param result springMVC错误返回绑定对象;
	 * @param fieldNames 要判断控件的name数组  如：对象.属性名 (object.objectName);
     * @param errorCodes 为空错误码集合,定义在i18n.properties上 格式 '出错名.类名.属性' {IsRename.public.name}
	 * @param objects 要判断控件对象的对象属性数组  如：对象.getXxx(object.getObjctName);
	 * @param minLengths 要判断控件最小长度 数组
	 * @param maxLengths 要判断控件最大长度 数组
	 * @return true 表示校验通过 ; false 表示没校验通过;
	 */
	public static boolean validateRequired(BindingResult result , String[] fieldNames , String[] errorCodes ,
			String[] errorCodeMins , String[] errorCodeMaxs , Object[] objects , 
			int[] minLengths , int[] maxLengths){ 
		if(fieldNames!=null && objects != null && maxLengths != null ){
			for (int i = 0; i < fieldNames.length; i++) {
                //判断是否为空
				if("".equals(objects[i])){
					result.rejectValue(fieldNames[i], errorCodes[i]);
					return false;
                    //对象不为null
				}else if(objects[i] != null ){
                    //判断最大长度
					if(objects[i].toString().length()>maxLengths[i]){
						result.rejectValue(fieldNames[i], errorCodeMaxs[i]);
						return false;
                        //判断最小长度
					}else if(objects[i].toString().length() < minLengths[i]){
						result.rejectValue(fieldNames[i], errorCodeMins[i]);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	public static void validateRequiredString(){}
	public static void validateInt(){}
	public static void validateDouble(){}
	public static void validateDate(){}
	public static void validateEmail(){}
	public static void validateUrl(){}
	public static void validateStringLength(){}

}
