package cn.peyton.spring.tool.mybatis.util;

import cn.peyton.spring.tool.mybatis.db.DbHelper;
import cn.peyton.spring.tool.mybatis.entity.Column;
import cn.peyton.spring.tool.mybatis.entity.Table;

import java.util.List;

/**
 * <h3></h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.util.MapperTemplate.java
 * CreateDate: 2018/8/10 9:34
 * Version: 1.0.0
 * </pre>
 */
public class MapperTemplate extends BaseTemplate {


    public static void create(Table table , String path, String mapperPackageName, String entityPackageName){
        _table = table;
        _path =existPath(path);
        createMapper(mapperPackageName,entityPackageName);
        createMapperXML(mapperPackageName, entityPackageName);
    }

    /**
     * <h4>创建Mapper接口</h4>
     * @param packageName mapper包路径
     * @return
     */
    private static String createMapper( String packageName, String entityPackageName) {
        sb = new StringBuffer();
        if (null != packageName) {
            sb.append("package " + packageName + ";\r\n\r\n");
        }
        sb.append("import " + entityPackageName + "." + _table.getObjectName() + ";\r\n\r\n");
        createAnnotation("Mapper 接口");
        createMapperClass();
        createFileContent(packageName, _table.getObjectName() + "Mapper", "java");
        return sb.toString();
    }

    /**
     * <h4>创建Mapper XML 文件</h4>
     *
     * @param mapperPackageName mapper包路径
     * @param entityPackageName entity包路径
     * @return
     */
    private static String createMapperXML(String mapperPackageName, String entityPackageName) {
        sb = new StringBuffer();
        createMapperXmlContent(mapperPackageName, entityPackageName);
        createFileContent(mapperPackageName, _table.getObjectName() + "Mapper", "xml");
        return sb.toString();
    }

    // ============================================== create Mapper method begin ============================================== //

    /**
     * <h4>创建Mapper接口</h4>
     */
    private static void createMapperClass(){
        sb.append("public interface " + _table.getObjectName() + "Mapper {\r\n");
        createMapperContent();
        sb.append("}\r\n");
    }

    /**
     * <h4>创建Mapper接口内容</h4>
     */
    private static void createMapperContent() {

        sb.append("\t/**\r\n");
        sb.append("\t * <h4>插入 对象</h4>\r\n");
        sb.append("\t * @param record 对象\r\n");
        sb.append("\t * @return 受影响的行数\r\n");
        sb.append("\t */\r\n");
        sb.append("\tint insert(" + _table.getObjectName() + " record);\r\n");
        sb.append("\r\n");

        sb.append("\t/**\r\n");
        sb.append("\t * <h4>插入 对象[根据属性是否有值 插入]</h4>\r\n");
        sb.append("\t * @param record 对象\r\n");
        sb.append("\t * @return 受影响的行数\r\n");
        sb.append("\t */\r\n");
        sb.append("\tint insertSelective(" + _table.getObjectName() + " record);\r\n");
        sb.append("\r\n");

        String typeName = "";
        List<Column> columnList = _table.getColumns();
        int size = columnList.size();
        for (int i = 0; i < size; i++) {
            String temp = columnList.get(i).getFieldName();
            if (_table.getPrimaryKeyName().equals(temp)) {
                typeName = columnList.get(i).getFieldType();
                break;
            }
        }
        sb.append("\t/**\r\n");
        sb.append("\t * <h4>根据 主键 删除 对象</h4>\r\n");
        sb.append("\t * @param id 主键\r\n");
        sb.append("\t * @return 受影响的行数\r\n");
        sb.append("\t */\r\n");
        sb.append("\tint deleteByPrimaryKey(" + typeName + " id);\r\n");
        sb.append("\r\n");

        sb.append("\t/**\r\n");
        sb.append("\t * <h4>更新 对象</h4>\r\n");
        sb.append("\t * @param record 对象\r\n");
        sb.append("\t * @return 受影响的行数\r\n");
        sb.append("\t */\r\n");
        sb.append("\tint updateByPrimaryKey(" + _table.getObjectName() + " record);\r\n");
        sb.append("\r\n");

        sb.append("\t/**\r\n");
        sb.append("\t * <h4>更新 对象[根据属性是否有值 更新]</h4>\r\n");
        sb.append("\t * @param record 对象\r\n");
        sb.append("\t * @return 受影响的行数\r\n");
        sb.append("\t */\r\n");
        sb.append("\tint updateByPrimaryKeySelective(" + _table.getObjectName() + " record);\r\n");
        sb.append("\r\n");

        sb.append("\t/**\r\n");
        sb.append("\t * <h4>根据 主键 查找 对象</h4>\r\n");
        sb.append("\t * @param id 主键\r\n");
        sb.append("\t * @return 对象\r\n");
        sb.append("\t */\r\n");
        sb.append("\t" + _table.getObjectName() + " selectByPrimaryKey(" + typeName + " id);\r\n");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t// ==================================== new create method ==================================== //\r\n");
        sb.append("\r\n");
        sb.append("\r\n");
    }
    // ============================================== create Mapper method end =============================================== //

    // ============================================= create Mapper xml method begin ============================================= //

    /**
     * <h4>创建Mapper XML 内容</h4>
     *
     * @param mapperPackageName mapper包路径
     * @param entityPackageName entity包路径
     */
    private static void createMapperXmlContent(String mapperPackageName, String entityPackageName) {

        String pkName = _table.getPrimaryKeyName();
        List<Column> columnList = _table.getColumns();
        int size = columnList.size();
        Column pkColumn = DbHelper.getPrimaryKeyColumn(columnList, pkName);

        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n");
        sb.append("<mapper namespace=\"" + mapperPackageName + "." + _table.getObjectName() + "Mapper\">\r\n");
        //=================================== create resultMap [BaseResultMap] ====================================//
        //resultMap
        sb.append("\t<resultMap id=\"BaseResultMap\" type=\"" + entityPackageName + "." + _table.getObjectName() + "\">\r\n");


        for (int i = 0; i < size; i++) {
            Column column = columnList.get(i);
            if (column.getColumnName().equals(pkName)) {
                sb.append("\t\t<id ");
            } else {
                sb.append("\t\t<result ");
            }
            sb.append("column=\"" + column.getColumnName() +
                    "\" property=\"" + column.getFieldName() +
                    "\" jdbcType=\"" + column.getNameType() + "\"/>\r\n");
        }
        sb.append("\t</resultMap>\r\n");
        sb.append("\r\n");

        //================================ create SQL [Base_Column_List] =======================================//
        sb.append("\t<sql id=\"Base_Column_List\">\r\n");
        sb.append("\t\t");
        for (int i = 0; i < size; i++) {
            sb.append(columnList.get(i).getColumnName());
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("\r\n");
        sb.append("\t</sql>\r\n");
        sb.append("\r\n");

        //====================================== create insert =================================//
        sb.append("\t<insert id=\"insert\" parameterType=\"" + entityPackageName + "." + _table.getObjectName() + "\"" +
                " keyProperty=\"" + _table.getPrimaryKeyName() + "\" useGeneratedKeys=\"true\">\r\n");
        sb.append("\t\tinsert into " + _table.getTableName() + "(");
        for (int i = 0; i < size; i++) {
            sb.append(columnList.get(i).getColumnName());
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append(")\r\n");
        sb.append("\t\tvalues (");
        for (int i = 0; i < size; i++) {
            sb.append("#{" + columnList.get(i).getFieldName() + "}");
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append(")\r\n");
        sb.append("\t</insert>\r\n");
        sb.append("\r\n");

        sb.append("\t<insert id=\"insertSelective\" parameterType=\"" + entityPackageName + "." + _table.getObjectName() + "\"" +
                " keyProperty=\"" + _table.getPrimaryKeyName() + "\" useGeneratedKeys=\"true\">\r\n");
        sb.append("\t\tinsert into " + _table.getTableName() + "\r\n");

        sb.append("\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\r\n");
        for (int i = 0; i < size; i++) {
            sb.append("\t\t\t<if test=\"" + columnList.get(i).getFieldName() + " != null\">\r\n");
            sb.append("\t\t\t\t" + columnList.get(i).getColumnName() + ",\r\n");
            sb.append("\t\t\t</if>\r\n");
        }
        sb.append("\t\t</trim>\r\n");
        sb.append("\t\t<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\r\n");
        for (int i = 0; i < size; i++) {
            sb.append("\t\t\t<if test=\"" + columnList.get(i).getFieldName() + " != null\">\r\n");
            sb.append("\t\t\t\t#{" + columnList.get(i).getFieldName() + "},\r\n");
            sb.append("\t\t\t</if>\r\n");
        }
        sb.append("\t\t</trim>\r\n");
        sb.append("\t</insert>\r\n");
        sb.append("\r\n");

        //================================== create delete =====================================//
        sb.append("\t<delete id=\"deleteByPrimaryKey\" parameterType=\"" + ConvertUtil.convertFieldTypePath(pkColumn.getNameType()) + "\">\r\n");
        sb.append("\t\tdelete from " + _table.getTableName() + "\r\n");
        sb.append("\t\twhere " + pkColumn.getColumnName() + " = #{" + pkColumn.getFieldName() + "}\r\n");
        sb.append("\t</delete>\r\n");
        sb.append("\r\n");

        //================================== create update =====================================//
        sb.append("\t<update id=\"updateByPrimaryKeySelective\" parameterType=\"" + entityPackageName + "." + _table.getObjectName() + "\">\r\n");
        sb.append("\t\tupdate " + _table.getTableName() + "\r\n");
        sb.append("\t\t<set>\r\n");
        String pkFiledName = null, pkFiledColumn = null;
        for (int i = 0; i < size; i++) {
            Column tColumn = columnList.get(i);
            if (tColumn.getColumnName().equals(pkName)) {
                pkFiledColumn = tColumn.getColumnName();
                pkFiledName = tColumn.getFieldName();
            } else {
                sb.append("\t\t\t<if test=\"" + tColumn.getFieldName() + " != null\">\r\n");
                sb.append("\t\t\t\t" + tColumn.getColumnName() + " = #{" + tColumn.getFieldName() + "},\r\n");
                sb.append("\t\t\t</if>\r\n");
            }
        }
        sb.append("\t\t</set>\r\n");
        sb.append("\t\twhere " + pkFiledColumn + " = #{" + pkFiledName + "}\r\n");
        sb.append("\t</update>\r\n");
        sb.append("\r\n");

        sb.append("\t<update id=\"updateByPrimaryKey\" parameterType=\"" + entityPackageName + "." + _table.getObjectName() + "\">\r\n");
        sb.append("\t\tupdate " + _table.getTableName() + "\r\n");
        sb.append("\t\tset \r\n");
        for (int i = 0; i < size; i++) {
            Column _tColumn = columnList.get(i);
            if (!_tColumn.getColumnName().equals(pkName)) {
                sb.append("\t\t\t" + _tColumn.getColumnName() + " = #{" + _tColumn.getFieldName() + "}");
                if (i != size - 1) {
                    sb.append(",");
                }
                sb.append("\r\n");
            }
        }
        sb.append("\t\twhere " + pkFiledColumn + " = #{" + pkFiledName + "}\r\n");
        sb.append("\t</update>\r\n");
        sb.append("\r\n");

        //================================== create select =====================================//
        //" + DbHelper.convertFieldTypePath(pkColumn.getNameType()) + "
        sb.append("\t<select id=\"selectByPrimaryKey\" resultMap=\"BaseResultMap\" " +
                "parameterType=\"" + ConvertUtil.convertFieldTypePath(pkColumn.getNameType()) + "\">\r\n");
        sb.append("\t\tselect\r\n");
        sb.append("\t\t<include refid=\"Base_Column_List\"/>\r\n");
        sb.append("\t\tfrom " + _table.getTableName() + "\r\n");
        sb.append("\t\twhere " + pkFiledColumn + " = #{" + pkFiledName + "}\r\n");
        sb.append("\t</select>\r\n");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t<!-- new create method   -->");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("</mapper>\r\n");
    }
    // ============================================== create Mapper xml method end ============================================== //

}
