package cn.peyton.spring.tool.mybatis.util;

/**
 * <h3>数据类型转换工具类 .</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.util.ConvertUtil.java
 * Create: 2018-08-06 23:18
 * Version: 1.0.0
 * </pre>
 */
public class ConvertUtil {

    /**
     * <h3>一个字符转换大写字符</h3>
     * <pre>
     *     格式: 属性名 aaaBbbCcc 改成 AaaBbbCcc
     * </pre>
     * @param filed 属性名
     * @return
     */
    public static String convertFirst(String filed){
        if (null == filed){return  null;}

        StringBuffer sb = new StringBuffer(filed);
        String first = sb.substring(0, 1);
        sb.delete(0, 1);
        sb.insert(0, first.toUpperCase());
        first.toLowerCase();
        return sb.toString();
    }

    /**
     * <h3>一个字符转换小写字符</h3>
     * <pre>
     *     格式: 属性名 AaaBbbCcc 改成 aaaBbbCcc
     * </pre>
     * @param name 属性名
     * @return
     */
    public static String toFirstLowerCase(String name) {
        if (null == name){return  null;}

        StringBuffer sb = new StringBuffer(name);
        String first = sb.substring(0, 1);
        sb.delete(0, 1);
        sb.insert(0, first.toLowerCase());
        return sb.toString();
    }

    /**
     * <h3>表名转换成对象名,并把'_'去掉,并把拼接单词第一个字母改成大写</h3>
     * <pre>
     *     格式: 表名 aaa_bbb_ccc 改成 对象 AaaBbbCcc
     * </pre>
     * @param tableName 表名
     * @return
     */
    public static String convertTableName2ObjName(String tableName) {
        if (null == tableName){return  null;}

        StringBuffer sb = new StringBuffer(tableName);
        String first = sb.substring(0, 1);
        sb.delete(0, 1);
        sb.insert(0, first.toUpperCase());

        return getStringBuffer(sb).toString();//方法调用
    }

    /**
     * <h3>表的字段名转换成属性名</h3>
     * <pre>
     *     格式: 字段名 aaa_bbb_ccc 改成 属性名 aaaBbbCcc
     * </pre>
     * @param columnName
     * @return
     */
    public static String convertColumnName2FieldName(String columnName) {
        if (null == columnName){return  null;}
        StringBuffer sb = new StringBuffer(columnName);
        return getStringBuffer(sb).toString();
    }

    /**
     * <h3>转换对象属性类型</h3>
     *  <pre>
     *      数据库字段类型 转成 对象属性类型
     *  </pre>
     * @param columnType 字段类型
     * @param sbpackage 需要导入的包
     * @return
     */
    public static String convertFieldType(String columnType, StringBuffer sbpackage) {
        columnType = columnType.toLowerCase();
        if ("varchar".equals(columnType) ||
                "nvarchar".equals(columnType) ||
                "longvarchar".equals(columnType) ||
                "text".equals(columnType) ||
                "char".equals(columnType)){
            return "String";
        }else if ("datetime".equals(columnType) ||
                "date".equals(columnType) ||
                "timestamp".equals(columnType) ||
                "time".equals(columnType) ||
                "year".equals(columnType)) {
            if (null != sbpackage) {
                sbpackage.append("import java.util.Date;\r\n");
            }
            return "Date";
        } else if ("bit".equals(columnType) ||
                "int".equals(columnType) ||
                "integer".equals(columnType) ||
                "tinyint".equals(columnType) ||
                "smallint".equals(columnType)) {
            return "Integer";
        } else if ("float".equals(columnType)) {
            return "Float";
        }else if ("bigint".equals(columnType)) {
            return "Long";
        }else if ("float".equals(columnType)) {
            return "Float";
        } else if ("double".equals(columnType)) {
            return "Double";
        }else if ("decimal".equals(columnType)) {
            if (null != sbpackage) {
                sbpackage.append("import java.math.BigDecimal;\r\n");
            }
            return "BigDecimal";
        }
        return "ErrorType";
    }

    /**
     * <h4>数据库字段类型 转换 对象属性类型</h4>
     * <pre>
     *     用在Mapper.xml 文件中 参数类型[parameterType]
     * </pre>
     * @param columnType 数据库 字段 类型
     * @return 对象属性类型
     */
    public static String convertFieldTypePath(String columnType) {
        if ("INTEGER".equals(columnType)) {
            return "java.lang.Integer";
        } else if ("BIGINT".equals(columnType)) {
            return  "java.lang.Long";
        } else if ("String".equals(columnType)) {
            return "java.lang.String";
        }else {
            return "string";
        }
    }

    /**
     * <h3>获取字符</h3>
     * @param sb
     * @return
     */
    private static StringBuffer getStringBuffer(StringBuffer sb) {
        int size = sb.length() -1 ;
        int lastIndex = sb.lastIndexOf("_");
        if (size == lastIndex) {
            sb = sb.deleteCharAt(lastIndex);
        }
        size = sb.lastIndexOf("_");

        for (int i = 0; i < size; i++) {
            int location = sb.indexOf("_");
            if (location > 0) {
                String temp = sb.substring(location + 1, location + 2);
                sb.delete(location, location + 2);
                sb.insert(location, temp.toUpperCase());
                i = location;
            }
        }
        return sb;
    }
}
