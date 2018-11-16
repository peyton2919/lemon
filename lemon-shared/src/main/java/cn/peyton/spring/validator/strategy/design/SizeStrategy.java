package cn.peyton.spring.validator.strategy.design;

import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.constraints.Size;
import cn.peyton.spring.validator.strategy.AbstractValidator;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注解的元素的大小必须在指定的范围内 策略类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:10
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class SizeStrategy extends AbstractValidator {

    @Override
    public void compare(Annotation annotation, String name, String type, Object value, Map<String, String> map) {
        Size size = (Size) annotation;
        message = size.message();
        long min = size.min();
        long max = size.max();
        if (CheckedUtil.isEmpty(value)) {
            if (existInt(type)) {
                map.put(name,"数据类型不正确");
                return;
            }
            try {
                Integer va = Integer.valueOf(value.toString());
                if (va < min || va > max) {
                    map.put(name, message);
                }

            } catch (Exception e) {
                map.put(name,"数据转换异常了!");
            }

        }
    }
}
