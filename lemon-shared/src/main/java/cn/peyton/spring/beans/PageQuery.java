package cn.peyton.spring.beans;

import cn.peyton.spring.validator.constraints.Min;

/**
 * <h3>分页查询 实体类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:26
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class PageQuery {
    /** 当前 页码 */
    @Min(value = 1,message = "当前页码不合法")
    private int pageNo = 1;
    /** 每页大小 */
    @Min(value = 1,message = "每页展示数量不合法")
    private int pageSize = 10;
    /**  偏移量 */
    private int offset;

    /**
     * @return 当前 页码
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo 当前 页码
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return 每页大小
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize 每页大小
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return 偏移量
     */
    public int getOffset() {
        return (pageNo -1) * pageSize;
    }

    /**
     * @param offset 偏移量
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
