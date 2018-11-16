package cn.peyton.spring.util;

import cn.peyton.spring.log.LogUtil;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;

/**
 * <h3>Json对象互转</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:57
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class JsonMapper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    //变量初始化
    static{
        //config
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    }

    /**
     * <h4>Object 转 String</h4>
     * @param src 对象
     * @param <T>
     * @return 字符串
     */
    public static <T> String obj2String(T src) {
        if (src == null) {
            return null;
        }
        try {
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        } catch (Exception ex) {
            LogUtil.warn("对象转字符串异常, 异常信息:{}",ex);
            return  null;
        }
    }

    /**
     * <h4>String 转 Object</h4>
     * @param src 字符串
     * @param typeReference 类型
     * @param <T>
     * @return 对象
     */
    public static <T> T string2Obj(String src, TypeReference typeReference) {
        if (null == src || null == typeReference) {
            return  null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
        } catch (Exception ex) {
            LogUtil.warn("字符串转对象异常,字符串信息:{},转换类型信息:{},异常信息:{}",src,typeReference,ex);
            return  null;
        }
    }

}
