package cn.peyton.spring.constant;

/**
 * <h3>返回码 枚举 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:51
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public enum ResponseCode {
    /** 成功 */
    SUCCESS(200,"SUCCESS"),
    /** 错误 */
    ERROR(400,"ERROR"),
    /** 需要登录 */
    NEED_LOGIN(10,"NEED_LOGIN"),
    /** 非法参数 */
    ILLEGAL_ARGUMENT(402,"ILLEGAL_ARGUMENT"),

    ;

    /**
     * @return 信息码
     */
    public int getCode() {
        return code;
    }

    /**
     * @return 描述
     */
    public String getMsg() {
        return msg;
    }

    // ================================== private ================================== //
    private final int code;
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    // ================================== private ================================== //
}
