package cn.peyton.spring.enums;

/**
 * <h3>类型 枚举类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:11
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public enum  Type {

    MENU(1,"菜单"),
    BUTTON(2,"按钮"),
    OTHER(3,"其他"),
    ;
    /**
     * <h4>构造函数</h4>
     * @param code 标识码
     * @param msg 信息
     */
    private Type(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    /** 标识码 */
    private Integer code;
    /** 信息 */
    private String msg;

    /**
     * @return 标识码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @return 信息
     */
    public String getMsg() {
        return msg;
    }
}
