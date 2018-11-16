package cn.peyton.spring.validator;

import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.validator.strategy.BaseValidator;

import java.util.Map;

/**
 * <h3>外部 调用验证类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:13
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class Validation {

    private static BaseValidator validator = BaseValidator.getInstance();

    /**
     * <h4>验证对象全部错误</h4>
     * @param obj 对象
     */
    public static void check(Object obj) {
        Map<String, String> errors = validator.validate(obj);
        _ex(errors);
    }

    /**
     * <h4>验证对象全部错误</h4>
     * @param obj 对象
     * @return 错误集合
     */
    public static Map<String, String> valid(Object obj) {
        return validator.validate(obj);
    }

    /**
     * <h4>验证对象错误</h4>
     * @param obj 对象
     * @param single 为true时表示验证对象单一属性[遇到验证有错误时就返回,只返回一组错误或没有错误]
     */
    public static void check(Object obj,boolean single) {
        if (single){
            Map<String, String> errors = validator.validateProperty(obj);
            _ex(errors);
        }
        check(obj);
    }

    /**
     * <h4>验证对象错误</h4>
     * @param obj 对象
     * @param single 为true时表示验证对象单一属性[遇到验证有错误时就返回,只返回一组错误或没有错误]
     * @return 错误集合
     */
    public static Map<String, String> valid(Object obj, boolean single) {
        if (single) {
            return validator.validateProperty(obj);
        }
        return valid(obj);
    }

    private static void _ex(Map<String, String> errors) {

        if (validator.ERROR) {
            StringBuffer sb = new StringBuffer();
            for(String key : errors.keySet()){
                sb.append(errors.get(key) + "<br>");
            }
            throw new ValidationException(sb.toString());
        }
    }

}
