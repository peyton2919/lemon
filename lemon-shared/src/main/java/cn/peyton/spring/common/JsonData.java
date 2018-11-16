package cn.peyton.spring.common;

import cn.peyton.spring.constant.ResponseCode;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>服务端 响应 类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:47
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@SuppressWarnings("ALL")
/** 保证序列化json时，如果是null对象，key也会消失 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class JsonData<T> implements Serializable {

    /** 状态码 200成功, 其它 异常和失败  */
    private int status;
    private boolean ret = true;
    /** 消息  */
    private String msg;
    /**  成功时要返回的数据 */
    private T data;

    // ====================================== external method begin ====================================== //
    /**
     * <h4>判断是否成功</h4>
     * @return 成功true
     */
    @JsonIgnore //使之不在json序列化结果当中
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    /**
     * <h4>数据封装到Map</h4>
     * @return  Map<String,Object>对象
     */
    public Map<String,Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("ret",ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    /**
     * <h4>成功</h4>
     * @param <T> 申明泛型数据类型
     * @return JsonData对象
     */
    public static <T> JsonData<T> success() {
        return new JsonData<T>(ResponseCode.SUCCESS.getCode());
    }

    /**
     * <h4>成功</h4>
     * @param msg 消息
     * @param <T> 申明泛型数据类型
     * @return JsonData对象
     */
    public static <T> JsonData<T> success(String msg) {
        return new JsonData<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    /**
     * <h4>成功</h4>
     * @param data 成功时要返回的数据
     * @param <T> 申明泛型数据类型
     * @return JsonData对象
     */
    public static <T> JsonData<T> success(T data) {
        return new JsonData<>(ResponseCode.SUCCESS.getCode(), data);
    }

    /**
     * <h4>成功</h4>
     * @param msg 消息
     * @param data 成功时要返回的数据
     * @param <T> 申明泛型数据类型
     * @return JsonData对象
     */
    public static <T> JsonData<T> success(String msg, T data) {
        return new JsonData<>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    /**
     * <h4>错误</h4>
     * @param <T> 申明泛型数据类型
     * @return JsonData对象
     */
    public static <T> JsonData<T> error() {
        return new JsonData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMsg());
    }

    /**
     * <h4>错误</h4>
     * @param msg 消息
     * @param <T> 申明泛型数据类型
     * @return JsonData对象
     */
    public static <T> JsonData<T> error(String msg) {
        return new JsonData<T>(ResponseCode.ERROR.getCode(), msg);
    }

    /**
     * <h4>错误</h4>
     * @param code 状态码 200成功, 其它 异常和失败
     * @param msg 消息
     * @param <T> 申明泛型数据类型
     * @return JsonData对象
     */
    public static <T> JsonData<T> fail(int code,String msg) {
        return new JsonData<T>(code, msg);
    }
    // ====================================== external method end ====================================== //

    // ====================================== Get and Set begin ====================================== //

    /**
     * @return 状态码 200成功, 其它 异常和失败
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return 消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @return 成功时要返回的数据
     */
    public T getData() {
        return data;
    }

    public boolean isRet() {
        return ret;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

// ====================================== Get and Set end ====================================== //

    // ====================================== private constructor begin ====================================== //

    /**
     * <h4>私有构造函数</h4>
     * @param status 状态码 200成功, 其它 异常和失败
     */
    private JsonData(int status) {
        this.status = status;
    }

    /**
     * <h4>私有构造函数</h4>
     * @param status 状态码 200成功, 其它 异常和失败
     * @param msg 消息
     */
    private JsonData(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * <h4>私有构造函数</h4>
     * @param status 状态码 200成功, 其它 异常和失败
     * @param data 成功时要返回的数据
     */
    private JsonData(int status, T data) {
        this.status = status;
        this.data = data;
    }

    /**
     * <h4>私有构造函数</h4>
     * @param status 状态码 200成功, 其它 异常和失败
     * @param msg 消息
     * @param data 成功时要返回的数据
     */
    private JsonData(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;

    }
    // ====================================== private constructor end ====================================== //
}
