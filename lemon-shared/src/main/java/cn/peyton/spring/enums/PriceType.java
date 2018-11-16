package cn.peyton.spring.enums;

/**
 * <h3>价格类型 枚举</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.enums.PriceType.java
 * @createDate: 2018/10/4 15:24
 * @version: 1.0.0
 * </pre>
 */
public enum PriceType {

    PRICE(1,"成本价"),
    RETAIL(2,"零售价"),
    WHOLESALE(3,"批发价"),

    ;


    /** 标识码 */
    private Integer code;
    /**  信息 */
    private String msg;

    /**
     * <h4>构造函数</h4>
     * @param code 标识码
     * @param msg 信息
     */
    private PriceType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
