package cn.peyton.spring.enums;

/**
 * <h3>管理员枚举</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: perm
 * PackageName: cn.peyton.spring.perm.enums.AdminStatus.java
 * CreateDate: 2018/7/10 11:04
 * Version: 1.0.0
 * </pre>
 */
public enum AdminStatus {
    /** 是管理员 */
    YES(1),
    /** 不是管理员 */
    NO(0),
    ;

   private AdminStatus(Integer code) {
        this.code = code;
    }
    private Integer code;

    public Integer getCode() {
        return code;
    }
}
