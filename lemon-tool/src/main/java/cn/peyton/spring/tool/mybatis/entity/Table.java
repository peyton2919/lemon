package cn.peyton.spring.tool.mybatis.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>数据表对象</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.entity.Table.java
 * CreateDate: 2018/8/6 10:23
 * Version: 1.0.0
 * </pre>
 */
public class Table {
    /**  表名 */
    private String tableName;
    /**  对象名 */
    private String objectName;
    /**  列的集合 */
    private List<Column> columns;
    /** 主键名 */
    private String primaryKeyName;
    /** 需要引入的包  */
    private String importPackage;

    /**
     * @return 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return 对象名
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @param objectName 对象名
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
     * @return 列的集合
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * @param columns 列的集合
     */
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    /**
     * @return 主键名
     */
    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    /**
     * @param primaryKeyName 主键名
     */
    public void setPrimaryKeyName(String primaryKeyName) {
        this.primaryKeyName = primaryKeyName;
    }

    /**
     * @return 需要引入的包
     */
    public String getImportPackage() {
        if (null != columns && columns.size() > 0) {
            int size = columns.size();
            List<String> temps = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                temps.add(columns.get(i).getImprotPackage().toString());
            }
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size ; j++) {
                    if (temps.get(i).equals(temps.get(j))) {
                        temps.remove(j);
                        size = size - 1;
                    }
                }
            }
            size = temps.size();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sb.append(temps.get(i));
            }
            return sb.toString();
        }
        return importPackage;
    }

    /**
     * @param importPackage 需要引入的包
     */
    public void setImportPackage(String importPackage) {
        this.importPackage = importPackage;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", objectName='" + objectName + '\'' +
                ", columns=" + columns +
                ", primaryKeyName='" + primaryKeyName + '\'' +
                ", importPackage='" + importPackage + '\'' +
                '}';
    }

    /**
     * <h3>列获取字段</h3>
     * <pre>
     * Author: <a href="http://www.peyton.cn">peyton</a>
     * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
     * CreateDate: 2018/8/8 14:22
     * Version: 1.0.0
     * </pre>
     */
    public interface Constants{
        String COLUMNNAME = "COLUMN_NAME";
        String TYPENAME = "TYPE_NAME";
        String REMARKS = "REMARKS";
        String COLUMNSIZE = "COLUMN_SIZE";
        String DECIMALDIGITS = "DECIMAL_DIGITS";
    }

}
