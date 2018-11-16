package cn.peyton.spring.enums;

/**
 * <h3>状态 枚举类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:11
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public enum Status {

    NORMAL(1,"正常"),
    CONGEAL(0,"冻结"),
    DELETE(2,"删除"),
    APPLY_FOR(3,"申请"),
    AUDIT_IN_PROGRESS(4,"审核中"),
    WAIT(100,"等待"),
    STOP(101,"暂停"),
    START(102,"启动"),
    UPPER_SHELF(201,"上架"),
    LOWER_SHELF(202,"下架"),

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
    private Status(int code, String msg) {
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
