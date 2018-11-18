package cn.peyton.spring.log.entity;
/**
 * <h3>日志 扩展 实体类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 10:25
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class SysLogWithBLOBs extends SysLog {
    /**  */
    private String oldValue;
    /**  */
    private String newValue;

    //================================== Constructor =======================================//

    //================================== GET AND SET =======================================//

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue == null ? null : oldValue.trim();
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue == null ? null : newValue.trim();
    }
}