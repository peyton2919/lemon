package cn.peyton.spring.validator.strategy.design;

import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.constraints.Email;
import cn.peyton.spring.validator.strategy.AbstractValidator;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注解的元素为 邮箱格式 策略 类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:07
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class EmailStrategy extends AbstractValidator {


    @Override
    public void compare(Annotation annotation, String name, String type, Object value, Map<String, String> map) {
        Email email = (Email) annotation;
        message = email.message();
        if (CheckedUtil.isEmpty(value)) {
            if (regex(value.toString(), Regulation.REGEX_EMAIL_ALL)) {
                map.put(name, message);
            }
        }
    }
}
