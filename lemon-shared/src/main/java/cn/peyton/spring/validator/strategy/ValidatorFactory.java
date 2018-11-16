package cn.peyton.spring.validator.strategy;

import cn.peyton.spring.validator.constraints.*;
import cn.peyton.spring.validator.strategy.design.*;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注释 验证 工厂类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:12
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@SuppressWarnings("SpellCheckingInspection")
public final class ValidatorFactory {
    /** 抽象 验证 对象 */
    private AbstractValidator comparer = null;

    /**
     * <4>私有构造函数</4>
     */
    private ValidatorFactory(){}

    /**
     * <h3>获取 ValidatorFactory 对象</h3>
     * @return
     */
    public static ValidatorFactory getInstance() {
        return Internal.INSTANCE;
    }

    /**
     * <h4>验证 注解</h4>
     * @param annotation 注解
     * @param name 名称
     * @param type 属性类型
     * @param value 值
     * @param map 错误信息 [LinkedHashMap]
     */
    public void valid(Annotation annotation, String name,
                      String type, Object value, Map<String, String> map){

        if (annotation instanceof AssertFalse){
            comparer = new AssertFalseStrategy();
        } else if (annotation instanceof AssertTrue) {
            comparer = new AssertTrueStrategy();
        } else if (annotation instanceof Date) {
            comparer = new DateStrategy();
        }else if (annotation instanceof Datetime) {
            comparer = new DatetimeStrategy();
        }else if (annotation instanceof DecimalMax) {
            comparer = new DecimalMaxStrategy();
        }else if (annotation instanceof DecimalMin) {
            comparer = new DecimalMinStrategy();
        }else if (annotation instanceof Email) {
            comparer = new EmailStrategy();
        }else if (annotation instanceof Future) {
            comparer = new FutureStrategy();
        }else if (annotation instanceof Past) {
            comparer = new PastStrategy();
        }else if (annotation instanceof Length) {
            comparer = new LengthStrategy();
        }else if (annotation instanceof Max) {
            comparer = new MaxStrategy();
        }else if (annotation instanceof Min) {
            comparer = new MinStrategy();
        }else if (annotation instanceof NotBlank) {
            comparer = new NotBlankStrategy();
        }else if (annotation instanceof NotNull) {
            comparer = new NotNullStrategy();
        }else if (annotation instanceof Null) {
            comparer = new NullStrategy();
        }else if (annotation instanceof Pattern) {
            comparer = new PatternStrategy();
        }else if (annotation instanceof Phone) {
            comparer = new PhoneStrategy();
        }else if (annotation instanceof Size) {
            comparer = new SizeStrategy();
        }else if (annotation instanceof Telephone) {
            comparer = new TelephoneStrategy();
        }else if (annotation instanceof Time) {
            comparer = new TimeStrategy();
        }
        if (null != comparer) {
            comparer.compare(annotation, name, type, value, map);
            comparer.message = "";
        }
    }

    /**
     * <h3>内部类[单例模式]</h3>
     */
    private static class Internal{
        private static final ValidatorFactory INSTANCE = new ValidatorFactory();
    }
}
