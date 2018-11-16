package cn.peyton.spring.enums;

/**
 * <h3>出入库状态 枚举</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.enums.StorageStatus.java
 * @createDate: 2018/10/16 12:21
 * @version: 1.0.0
 * </pre>
 */
public enum StorageStatus {
    /** 入库 */
    IN(0),
    /** 出库 */
    OUT(1),
    ;
    /** 标识码 */
    private Integer code;
    StorageStatus(int code){
        this.code = code;
    }
    /**
     * @return 标识码
     */
    public Integer getCode() {
        return code;
    }
}
