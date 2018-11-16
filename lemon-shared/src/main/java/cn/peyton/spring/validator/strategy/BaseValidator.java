package cn.peyton.spring.validator.strategy;

import cn.peyton.spring.log.LogUtil;
import cn.peyton.spring.util.JsonMapper;
import cn.peyton.spring.util.Maps;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h3>验证 类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:11
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class BaseValidator {
    /** 验证工厂对象*/
    private ValidatorFactory factory = null;
    /** 判断有没有返回错误信息 有为true */
    public boolean ERROR = false;

    /**
     * <h4>私有构造函数</h4>
     */
    private BaseValidator(){}

    /**
     * <h4>获取 基础验证 对象</h4>
     * @return
     */
    public static BaseValidator getInstance() {
        return Internal.INSTANCE;
    }


    /**
     * <h4>验证全部错误</h4>
     * @param obj 对象
     * @return 全部错误信息
     */
    public Map<String,String> validate(Object obj) {
        ERROR = false;
        try {
            return  _validate(obj,false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            LogUtil.error("全部验证异常{}", JsonMapper.obj2String(obj));
        }
        return Maps.createLinkHashMap();
    }

    /**
     * <h4>验证单一错误</h4>
     * @param obj 对象
     * @return 单个错误信息
     */
    public Map<String,String> validateProperty(Object obj) {
        ERROR = false;
        try {
            return  _validate(obj,true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            LogUtil.error("单个验证异常{}", JsonMapper.obj2String(obj));
        }
        return Maps.createLinkHashMap();
    }

    /**
     * <h4>验证</h4>
     * @param obj 对象
     * @param single false表示对象全部字段, true表示单个字段[有一个错误信息就返回]
     * @return
     * @throws IllegalAccessException
     */
    private Map<String,String> _validate(Object obj, boolean single) throws IllegalAccessException {
        Map<String, String> map = new LinkedHashMap<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (factory == null) {
            factory = ValidatorFactory.getInstance();
        }
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            String type = field.getGenericType().toString();
            if (!map.isEmpty()&&single){break;}
            Object value = field.get(obj);
            Annotation[] annotations = field.getDeclaredAnnotations();

            //判断 注解类型
            for (Annotation annotation : annotations) {
                //调用工厂
                factory.valid(annotation ,name,type,value,map);
                if (!map.isEmpty()&&single){break;}
            }
        }
        if (!map.isEmpty()) {
            ERROR = true;
        }
        return map;
    }

    /**
     * <h3>内部类, 单例模式</h3>
     */
    private static class Internal{
        private static BaseValidator INSTANCE = new BaseValidator();
    }

}
