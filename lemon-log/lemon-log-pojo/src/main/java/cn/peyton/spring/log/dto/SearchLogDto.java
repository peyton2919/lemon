package cn.peyton.spring.log.dto;

import java.util.Date;

/**
 * <h3>日志 传递层 实体类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 11:07
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class SearchLogDto {


    /** 类型 [参考LogType接口里的值 ] */
    private Integer type;
    /** 之前片断 */
    private String beforeSeq;
    /** 之后片断 */
    private String afterSeq;
    /** 操作者 */
    private String operator;
    /** 开始时间 格式:[yyyy-MM-dd HH:mm:ss]  */
    private Date fromTime;
    /** 结束时间 格式:[yyyy-MM-dd HH:mm:ss] */
    private Date toTime;

    /**
     * @return 类型 [参考LogType接口里的值 ]
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type 类型 [参考LogType接口里的值 ]
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 之前片断
     */
    public String getBeforeSeq() {
        return beforeSeq;
    }

    /**
     * @param beforeSeq 之前片断
     */
    public void setBeforeSeq(String beforeSeq) {
        this.beforeSeq = beforeSeq;
    }

    /**
     * @return 之后片断
     */
    public String getAfterSeq() {
        return afterSeq;
    }

    /**
     * @param afterSeq 之后片断
     */
    public void setAfterSeq(String afterSeq) {
        this.afterSeq = afterSeq;
    }

    /**
     * @return 操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator 操作者
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return 开始时间 格式:[yyyy-MM-dd HH:mm:ss]
     */
    public Date getFromTime() {
        return fromTime;
    }

    /**
     * @param fromTime 开始时间 格式:[yyyy-MM-dd HH:mm:ss]
     */
    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * @return 结束时间 格式:[yyyy-MM-dd HH:mm:ss]
     */
    public Date getToTime() {
        return toTime;
    }

    /**
     * @param toTime 结束时间 格式:[yyyy-MM-dd HH:mm:ss]
     */
    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }
}
