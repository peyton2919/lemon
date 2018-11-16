package cn.peyton.spring.validator.strategy.design;

import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.strategy.AbstractValidator;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注解的字符串的大小必须在指定的范围内 策略类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:07
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class LengthStrategy extends AbstractValidator {


    @Override
    public void compare(Annotation annotation, String name, String type, Object value, Map<String, String> map) {
        Length length = (Length) annotation;
        message = length.message();
        long min = length.min() < 0 ? 0: length.min();
        long max = length.max();
        if (CheckedUtil.isEmpty(value)) {
            long le = value.toString().trim().length();
            if (le < min || le > max) {
                map.put(name, message);
            }
        }
    }
}
