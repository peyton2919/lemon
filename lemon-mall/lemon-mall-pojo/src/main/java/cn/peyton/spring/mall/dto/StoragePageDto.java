package cn.peyton.spring.mall.dto;

/**
 * <h3>出入库页面 DTO 类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.dto.StoragePageDto.java
 * @createDate: 2018/10/15 13:57
 * @version: 1.0.0
 * </pre>
 */
public final class StoragePageDto {
    /** 编号 */
    private Integer id;
    /** 颜色编号 */
    private Integer colId;
    /** 颜色名称 */
    private String colName;
    /** 数量 */
    private Integer quantity;
    /**  库存数量 */
    private Integer inventoryQuantity;

    /**
     * @return 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 颜色编号
     */
    public Integer getColId() {
        return colId;
    }

    /**
     * @param colId 颜色编号
     */
    public void setColId(Integer colId) {
        this.colId = colId;
    }

    /**
     * @return 颜色名称
     */
    public String getColName() {
        return colName;
    }

    /**
     * @param colName 颜色名称
     */
    public void setColName(String colName) {
        this.colName = colName;
    }

    /**
     * @return 数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity 数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return 库存数量
     */
    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    /**
     * @param inventoryQuantity 库存数量
     */
    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
}
