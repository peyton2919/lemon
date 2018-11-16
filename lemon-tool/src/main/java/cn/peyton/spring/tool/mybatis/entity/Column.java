package cn.peyton.spring.tool.mybatis.entity;

/**
 * <h3>列 对象 [数据库 --> 表 --> 列]</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.entity.Column.java
 * CreateDate: 2018/8/6 12:47
 * Version: 1.0.0
 * </pre>
 */
public class Column {
    /** 列名 */
    private String columnName;
    /** 列类型 */
    private String nameType;
    /** 列注释 */
    private String remarks;
    /** 列长度 */
    private int columnSize;
    /** 小数 */
    private int decimalDigits;
    /** 属性名称 */
    private String fieldName;
    /** 属性类型 */
    private String fieldType;
    /** 需要引入的包  */
    private StringBuffer improtPackage = new StringBuffer();

    /**
     * @return 列名
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * @param columnName 列名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * @return 列类型
     */
    public String getNameType() {
        if (null != nameType) {
            if (nameType.toUpperCase().equals("INT")) {
                return "INTEGER";
            } else if (nameType.toUpperCase().equals("TEXT")) {
                return "LONGVARCHAR";
            }else if (nameType.toUpperCase().equals("DATETIME")) {
                return "TIMESTAMP";
            }
        }
        return nameType;
    }

    /**
     * @param nameType 列类型
     */
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    /**
     * @return 列注释
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks 列注释
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return 列长度
     */
    public int getColumnSize() {
        return columnSize;
    }

    /**
     * @param columnSize 列长度
     */
    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    /**
     * @return 小数
     */
    public int getDecimalDigits() {
        return decimalDigits;
    }

    /**
     * @param decimalDigits 小数
     */
    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    /**
     * @return 属性名称
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     *
     * @param fieldName 属性名称
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return 属性类型
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * @param fieldType 属性类型
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * @return 需要引入的包
     */
    public StringBuffer getImprotPackage() {
        return improtPackage;
    }

    /**
     * @param improtPackage 需要引入的包
     */
    public void setImprotPackage(StringBuffer improtPackage) {
        this.improtPackage = improtPackage;
    }

    @Override
    public String toString() {
        return "Column{" +
                "columnName='" + columnName + '\'' +
                ", nameType='" + nameType + '\'' +
                ", remarks='" + remarks + '\'' +
                ", columnSize=" + columnSize +
                ", decimalDigits=" + decimalDigits +
                ", fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", improtPackage=" + improtPackage +
                '}';
    }
}
