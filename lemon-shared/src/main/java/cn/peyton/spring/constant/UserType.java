package cn.peyton.spring.constant;

import cn.peyton.spring.inf.IUser;

/**
 * <h3>用户类型 枚举 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:53
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public enum  UserType {

    /** 超级管理员 */
    ADMIN("f9f1d1e2-c1c2-4528-82b6-8363b0faed1f"),
    /** 员工 */
    EMPLOYEE("47b01ef4-9e37-4453-8b49-df63367ea895"),
    /** 供应商 */
    SUPPLIER("ac7b08e7-d672-4a8e-8264-c07cef713f02"),
    /** 顾客 */
    CUSTOMER("cad5df31-de9b-448e-a00f-0779ae873a7e"),

    ;


    /** 值*/
    private String value;

    /**
     * <h4>私有构造</h4>
     * @param value 值
     */
    private UserType(String value) {
        this.value = value;
    }

    /**
     * @return 获取用户类型值
     */
    public String getValue() {
        return value;
    }


    /**
     * <h4>获取用户类型的数值</h4>
     * @param userType 用户类型 枚举
     * @return 数字  用户类型 0 顾客; 1 供应商; 2 员工; 3 管理员; 默认 0
     */
    public static Integer getNumber(UserType userType) {
        return getNumber(userType.getValue());
    }

    /**
     * <h4>获取用户类型的数值</h4>
     * @param userCode 用户码
     * @return 数字  用户类型 0 顾客; 1 供应商; 2 员工; 3 管理员; 默认 0
     */
    public static Integer getNumber(String userCode) {
        if (UserType.ADMIN.getValue().equals(userCode)) {
            return IUser.ADMIN_TYPE_NUM;
        }else if (UserType.EMPLOYEE.getValue().equals(userCode)) {
            return IUser.EMPLOYEE_TYPE_NUM;
        }else if (UserType.SUPPLIER.getValue().equals(userCode)) {
            return IUser.SUPPLIER_TYPE_NUM;
        }else{
            return IUser.CUSTOMER_TYPE_NUM;
        }
    }

    // ============================================ private field ============================================ //


}
