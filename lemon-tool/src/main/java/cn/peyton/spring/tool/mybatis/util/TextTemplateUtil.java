package cn.peyton.spring.tool.mybatis.util;

import cn.peyton.spring.tool.mybatis.db.DbHelper;
import cn.peyton.spring.tool.mybatis.entity.Column;
import cn.peyton.spring.tool.mybatis.entity.Table;

import java.util.List;

/**
 * <h3>文本模板 类</h3>
 * <pre>
 *     创建各种文本
 * </pre>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.util.TextTemplateUtil.java
 * CreateDate: 2018/8/7 12:11
 * Version: 1.0.0
 * </pre>
 * @author peyton
 */
@SuppressWarnings("ALL")
public class TextTemplateUtil {

    /**
     * <h4>创建单个</h4>
     * @param tableName         表名
     * @param removePrefix      去除前缀
     * @param path              绝对路径
     * @param mapperPackageName mapper包路径
     * @param entityPackageName entity包路径
     */
    public static void create(String tableName, String removePrefix, String path,
                              String mapperPackageName, String entityPackageName, boolean isAll) {
        Table table = DbHelper.getTableInfo(tableName);
        //设置对象名
        table.setObjectName(removePrefixTableName2ObjName(table.getTableName(), removePrefix));

        single(table , path, mapperPackageName, entityPackageName, isAll);
    }



    /**
     * <h4>创建多个[当前 库下所有表]</h4>
     * @param removePrefix      去除前缀
     * @param path              绝对路径
     * @param mapperPackageName mapper包路径
     * @param entityPackageName entity包路径
     */
    public static void create( String removePrefix, String path,
                              String mapperPackageName, String entityPackageName, boolean isAll) {
        List<Table> tables = DbHelper.getTableInfos();
        //设置对象名
        int size = tables.size();
        for (int i = 0; i < size; i++) {
            Table table = tables.get(i);
            table.setObjectName(removePrefixTableName2ObjName(table.getTableName(), removePrefix));
            single(table , path, mapperPackageName, entityPackageName, isAll);
        }
    }

    /**
     * <h4>创建单个 参数 传递类</h4>
     * @param tableName 表名
     * @param objName 对象名称
     * @param prefix 去除前缀
     * @param path  绝对 路径
     * @param packageName 包的地址
     */
    public static void createParam(String tableName ,String objName,String prefix, String path,String packageName) {
        Table table = DbHelper.getTableInfo(tableName);
        //设置对象名
        table.setObjectName(removePrefixTableName2ObjName(table.getTableName(), null));
        ModelTemplate.create(table,objName,prefix, path, packageName);
    }

    /**
     *
     * @param table 表名
     * @param path 输出路径
     * @param mapperPackageName mapper包名路径
     * @param entityPackageName entity包名路径
     * @param isAll true 输出service 与 controller
     */
    private static void single(Table table,String path, String mapperPackageName, String entityPackageName, boolean isAll) {
        ModelTemplate.create(table,null,null, path, entityPackageName);
        MapperTemplate.create(table,path,mapperPackageName,entityPackageName);

        //isAll 为true 时创建 Service 与 Controller
        if (isAll) {
            int tLocation = mapperPackageName.lastIndexOf(".");
            StringBuffer tSb = new StringBuffer(mapperPackageName);
            tSb.delete(tLocation + 1, mapperPackageName.length());
            String importPackagePrefix = tSb.toString();
            ServiceTemplate.create(table.getObjectName(),path,mapperPackageName,
                    importPackagePrefix + "service");
            ControllerTemplate.create(table.getObjectName(),path,importPackagePrefix,
                    importPackagePrefix + "controller");
        }
        StringBuffer stringBuffer = new StringBuffer(table.getObjectName() + " 生成相应 [modle,mapper,mapperxml");
        if (isAll) {
            stringBuffer.append("service,contrlloer");
        }
        stringBuffer.append("] 生成成功!");
        System.out.println(stringBuffer);
    }


    // ##################################>>>>>>>>>>  外部直接调用方法 <<<<<<<<<<################################## //

    /**
     * <h4>获取表</h4>
     * @param tableName 表名
     * @param removePrefix 去除前缀
     * @return
     */
    public static Table getTable(String tableName,String removePrefix) {
        Table table = DbHelper.getTableInfo(tableName);
        //设置对象名
        table.setObjectName(removePrefixTableName2ObjName(table.getTableName(), removePrefix));
        return table;
    }

    /**
     * <h3>获取数据库下的所有表名</h3>
     * @return
     */
    public static List<String> getTableNames() {
        return DbHelper.getTableNames();
    }

    /**
     * <h4>创建构造函数</h4>
     * @return
     */
    public static String createConstructor(String tableName, String objName) {
        Table table = DbHelper.getTableInfo(tableName);
        List<Column> columnList = table.getColumns();
        StringBuffer sb = new StringBuffer();
        int size = columnList.size();
        sb = new StringBuffer();

        sb.append("\t/**\r\n");
        sb.append("\t * <h4>构造函数</h4>\r\n");

        sb.append("\t */\r\n");
        sb.append("\tpublic " + objName + "(){}\r\n\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * <h4>构造函数</h4>\r\n");
        for (int i = 0; i < size; i++) {
            Column column = columnList.get(i);
            sb.append("\t * @param " + column.getFieldName() + " " + column.getRemarks() + "\r\n");
        }
        sb.append("\t */\r\n");
        sb.append("\tpublic " + objName + "(");
        for (int i = 0; i < size; i++) {
            Column column = columnList.get(i);
            sb.append(column.getFieldType() + " " + column.getFieldName());
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("){\r\n");
        for (int i = 0; i < size; i++) {
            Column column = columnList.get(i);
            sb.append("\t\tthis." + column.getFieldName() + " = " + column.getFieldName() + ";\r\n");
        }
        sb.append("\t}\r\n");
        return sb.toString();
    }

    /**
     * <h4>传参对象转换对象</h4>
     * @param tableName        表名
     * @param resultObjectName 转换后对象名
     * @return
     */
    public static String createConvert(String tableName, String resultObjectName) {

        return createConvert(tableName, resultObjectName, null, null);
    }

    /**
     * <h4>传参对象转换对象</h4>
     * @param tableName        表名
     * @param resultObjectName 转换后对象名
     * @param prefixResult 返回对象 要去除前缀的属性
     * @param prefixParam 参数对象 要去除前缀的属性
     * @return
     */
    public static String createConvert(String tableName, String resultObjectName,
                                       String  prefixResult,String prefixParam) {
        Table table = DbHelper.getTableInfo(tableName);
        List<Column> columnList = table.getColumns();
        StringBuffer sb = new StringBuffer();
        int size = columnList.size();
        String _ron = ConvertUtil.toFirstLowerCase(resultObjectName);

        sb.append("\t/**\r\n");
        sb.append("\t * <h4>对象转成" + resultObjectName + "对象<h4> \r\n");
        //标题注解
        createAnnotationTitel(columnList, sb, size);
        sb.append("\tpublic " + resultObjectName + " convert(){ \r\n");

        sb.append("\t\t" + resultObjectName + " " + _ron + " = new " + resultObjectName + "(); \r\n");
        createContent(prefixResult, prefixParam, columnList, sb, size, _ron,true);
        sb.append("\t\treturn " + _ron + ";\r\n");
        sb.append("\t} \r\n");
        return sb.toString();
    }

    /**
     *
     * @param prefixResult 返回对象 要去除前缀的属性
     * @param prefixParam 参数对象 要去除前缀的属性
     * @param columnList 对象集合
     * @param sb 拼装字符串
     * @param size 集合大小
     * @param _ron 对象名
     * @param exist true 为 convent ; false 为compat
     */
    private static void createContent(String prefixResult, String prefixParam, List<Column> columnList,
                                      StringBuffer sb, int size, String _ron,boolean exist) {
        for (int i = 0; i < size; i++) {
            Column column = columnList.get(i);
            String fieldName = column.getFieldName();
            String fieldResult = "";
            String fieldParam = "";
            if (null != prefixResult){
                int len = fieldName.indexOf(prefixResult);
                if (len > -1) {
                    fieldResult = fieldName.substring(len + prefixResult.length());
                    fieldResult = ConvertUtil.toFirstLowerCase(fieldResult);
                }else {
                    fieldResult = fieldName;
                }
            }else {
                fieldResult = fieldName;
            }

            if (null != prefixParam){
                int len = fieldName.indexOf(prefixParam);
                if (len > -1) {
                    fieldParam = fieldName.substring(len + prefixParam.length());
                    fieldParam = ConvertUtil.toFirstLowerCase(fieldParam);
                }else {
                    fieldParam = fieldName;
                }
            }else {
                fieldParam = fieldName;
            }
            sb.append("\t\t");
            String upperCaseField = ConvertUtil.convertFirst(fieldResult);
            if (exist) {
                sb.append(_ron + ".set" + upperCaseField + "(" + fieldParam + ");\r\n");
            }else {
                sb.append("this.set" + upperCaseField + "(");
                sb.append(_ron + ".get" + ConvertUtil.convertFirst(fieldParam) + "()");
                sb.append(");\r\n");
            }
        }
    }

    /**
     * <h4>对象转换传参对象</h4>
     * @param tableName        表名
     * @param resultObjectName 返回对象名
     * @param paramObjectName 参数对象名
     * @return
     */
    public static String createCompat(String tableName, String resultObjectName,String paramObjectName) {
        return createCompat(tableName,resultObjectName,null,paramObjectName,null);
    }

    /**
     * <h4>对象转换传参对象</h4>
     * @param tableName 表名
     * @param resultObjectName 返回对象名
     * @param prefixResult 返回对象 要去除前缀的属性
     * @param paramObjectName 参数对象名
     * @param prefixParam 参数对象 要去除前缀的属性
     * @return
     */
    public static String createCompat(String tableName, String resultObjectName,String  prefixResult,
                                      String paramObjectName,String prefixParam) {
        Table table = DbHelper.getTableInfo(tableName);
        List<Column> columnList = table.getColumns();
        StringBuffer sb = new StringBuffer();
        int size = columnList.size();
        String _ron = ConvertUtil.toFirstLowerCase(paramObjectName);
        sb.append("\t/**\r\n");
        sb.append("\t * <h4>" + paramObjectName + "对象转成" + resultObjectName + "对象<h4> \r\n");
        //标题注解
        createAnnotationTitel(columnList, sb, size);
        sb.append("\tpublic " + resultObjectName + " compat(" + paramObjectName + " " + _ron + "){ \r\n");
        sb.append("\t\tif(null == "+ _ron +"){\r\n");
        sb.append("\t\t\treturn new " + resultObjectName + "();\r\n");
        sb.append("\t\t}\r\n");

        createContent(prefixResult, prefixParam, columnList, sb, size, _ron,false);
        sb.append("\t\treturn this;\r\n");
        sb.append("\t} \r\n");
        return sb.toString();
    }


    // ##################################>>>>>>>>>>  外部直接调用方法 <<<<<<<<<<################################## //


    /**
     * <h4>移除前缀，并将表名转成对象名</h4>
     * <pre>
     *  1) . 如 removePrefix 为空时, 直接把首字母转换成大写，并把有下划线的去掉，下划线后的字母改成大写
     *      转换 样式: sys_user_info ==> SysUserInfo
     *  如 removePrefix 不为空时{比对多个可以用 ','分开如 'pu_,sys_...'},前部有相同则去除,否则 如（1）转换
     *      removePrefix = "pu_,sys_";
     *      转换 样式 sys_user_info ==> UserInfo [找到相同]
     *          样式 tb_user_info ==> TbUserInfo [找到相同]
     * </pre>
     * @param tableName
     * @param removePrefix
     * @return
     */
    private static String removePrefixTableName2ObjName(String tableName, String removePrefix) {
        if (null != removePrefix && removePrefix.length() > 0) {
            StringBuffer tSb = new StringBuffer(tableName);
            String[] splits = removePrefix.split(",");
            int length = splits.length;
            for (int i = 0; i < length; i++) {
                int tLength = splits[i].length();
                String tTemp = splits[i].toLowerCase();
                if (tSb.substring(0, tLength).toLowerCase().equals(tTemp)) {
                    return ConvertUtil.convertTableName2ObjName(tSb.substring(tLength));
                }
            }
        }
        return ConvertUtil.convertTableName2ObjName(tableName);
    }

    /**
     * <h4>标题注解</h4>
     * @param columnList
     * @param sb
     * @param size
     */
    private static void createAnnotationTitel(List<Column> columnList, StringBuffer sb, int size) {
        sb.append("\t * <pre>\r\n");
        sb.append("\t * \t 转换字段如下:\r\n");
        sb.append("\t * \t [");
        for (int i = 0; i < size; i++) {
            sb.append(columnList.get(i).getFieldName());
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]\r\n");
        sb.append("\t * </pre>\r\n");
        sb.append("\t */\r\n");
    }

}
