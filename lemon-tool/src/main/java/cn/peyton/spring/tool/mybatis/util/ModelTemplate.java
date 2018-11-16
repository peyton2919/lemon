package cn.peyton.spring.tool.mybatis.util;

import cn.peyton.spring.tool.mybatis.entity.Column;
import cn.peyton.spring.tool.mybatis.entity.Table;

import java.util.List;

/**
 * <h3></h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.util.ModelTemplate.java
 * CreateDate: 2018/8/10 9:27
 * Version: 1.0.0
 * </pre>
 * @author peyton
 */
public class ModelTemplate extends BaseTemplate {

    /**
     *  <h3>创建实体类</h3>
     * @param table 表对象
     * @param objName 对象名称
     * @param prefix 去除前缀
     * @param path  绝对 路径
     * @param packageName 包的地址
     * @return
     */
    public static String create(Table table ,String objName,String prefix, String path, String packageName) {
        _table = table;
        _path = existPath(path);
        sb = new StringBuffer();
        if (null != packageName) {
            sb.append("package " + packageName + ";\r\n\r\n");
        }
        //TODO
        sb.append(table.getImportPackage());
        String explain = (prefix == null) ? "实体类": "参数 传递类[用来展示数据]类";
        createAnnotation(explain);
        createModelClass(objName,prefix);
        createFileContent(packageName, ((objName == null) ? table.getObjectName():objName), "java");
        return sb.toString();
    }


    // ================================================ create Model method begin ================================================ //


    /**
     * <h3>创建对象</h3>
     */
    private static void createModelClass(String objName,String prefix) {
        sb.append("public class " + ((objName == null) ? _table.getObjectName():objName) + "{\r\n");
        createModelContent(prefix);
        sb.append("}\r\n");
    }

    /**
     * <h3>创建内容</h3>
     * @return
     */
    private static void createModelContent(String prefix) {

        int size = _table.getColumns().size();
        List<Column> columnList = _table.getColumns();
        for (int i = 0; i < size; i++) {
            String fieldName = columnList.get(i).getFieldName();
            if (null != prefix) {
                fieldName = fieldName.replace(prefix, "");
                fieldName = ConvertUtil.toFirstLowerCase(fieldName);
            }
            sb.append("\t/** " + columnList.get(i).getRemarks() + "  */\r\n");
            sb.append("\tprivate " + columnList.get(i).getFieldType() + " " + fieldName + ";\r\n");
        }
        sb.append("\r\n");
        sb.append("\t//================================== Constructor =======================================//\r\n");
        sb.append("\r\n");
        sb.append("\t//================================== Method =======================================//\r\n");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t//================================== PREFIX_GET AND PREFIX_SET =======================================//\r\n");
        sb.append("\r\n");
        for (int i = 0; i < size; i++) {
            String fieldName = columnList.get(i).getFieldName();
            if (null != prefix) {
                fieldName = fieldName.replace(prefix, "");
                fieldName = ConvertUtil.toFirstLowerCase(fieldName);
            }
            String fieldType = columnList.get(i).getFieldType();
            String remarks =columnList.get(i).getRemarks();

            sb.append("\t/** \r\n");
            sb.append("\t * @param " +fieldName + " "+remarks+" \r\n");
            sb.append("\t */ \r\n");
            sb.append("\tpublic void " + PREFIX_SET + ConvertUtil.convertFirst(fieldName) + "(" +
                    fieldType + " " + fieldName + "){\r\n\t\tthis."+  fieldName + " = " + fieldName + ";\r\n\t}\r\n\r\n");

            sb.append("\t/** \r\n");
            sb.append("\t * @return " + remarks + " \r\n");
            sb.append("\t */ \r\n");
            sb.append("\tpublic " + fieldType + " " + PREFIX_GET + ConvertUtil.convertFirst(fieldName) + "(){\r\n" +
                    "\t\treturn "+  fieldName + ";\r\n\t}\r\n\r\n");
        }
    }
    // ================================================ create Model method end ================================================ //
}
