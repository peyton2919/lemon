package cn.peyton.spring.validator.strategy.design;

import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.constraints.Pattern;
import cn.peyton.spring.validator.strategy.AbstractValidator;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注解的元素必须符合指定的正则表达式 策略类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:10
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class PatternStrategy extends AbstractValidator {

    @Override
    public void compare(Annotation annotation, String name, String type, Object value, Map<String, String> map) {
        Pattern pattern = (Pattern) annotation;
        message = pattern.message();
        String rule = pattern.regexp();
        if (CheckedUtil.isEmpty(value)) {
            if (regex(value.toString(), rule)) {
                map.put(name, message);
            }
        }

    }
}
