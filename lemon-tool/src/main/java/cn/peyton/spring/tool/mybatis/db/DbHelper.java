package cn.peyton.spring.tool.mybatis.db;

import cn.peyton.spring.log.LogUtil;
import cn.peyton.spring.tool.mybatis.util.ConvertUtil;
import cn.peyton.spring.tool.mybatis.entity.Column;
import cn.peyton.spring.tool.mybatis.entity.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>操作数据库工具类 .</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.db.DbHelper.java
 * CreateDate: 2018/8/6 8:55
 * Version: 1.0.0
 * </pre>
 */
public final class DbHelper {
    /** 数据库驱动  */
    private static String DRIVER;
    /** 数据库链接地址 */
    private static String URL;
    /** 数据库用户名 */
    private static String USRENAME;
    /** 数据库密码 */
    private static String PASSWORD ;

    /**
     * <h4>构造函数</h4>
     */
    public DbHelper(){
        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * <h3>获取连接</h3>
     * @return
     */
    public static Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USRENAME, PASSWORD);
            LogUtil.debug("开始连接数据库!");
        } catch (SQLException e) {
            e.printStackTrace();
            LogUtil.debug("连接数据库异常!");
        }
        return conn;
    }

    /**
     * <h3>关闭连接</h3>
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
                LogUtil.debug("关闭连接数据库!");
            } catch (SQLException e) {
                e.printStackTrace();
                LogUtil.debug("关闭数据库异常!");
            }
        }
    }

    /**
     * <h3>关闭 ResultSet</h3>
     * @param resultSet
     */
    public static void closeResultSet(ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
                LogUtil.debug("正常关闭ResultSet!");
            } catch (SQLException e) {
                e.printStackTrace();
                LogUtil.debug("关闭ResultSet异常!");
            }
        }
    }

    /**
     * <h3>获取数据库下的所有表名</h3>
     * @return
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            //获取数据库的元数据
            DatabaseMetaData db = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = db.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogUtil.debug("获取表名集合异常【getTableNames】!");
        }finally {
            closeResultSet(rs);
            closeConnection(conn);
        }
        return tableNames;
    }

    /**
     * <h3>获取表信息集合</h3>
     * @return
     */
    public static List<Table> getTableInfos() {
        List<Table> tableList = new ArrayList<>();
        List<Column> columnList = null;
        Table table = null;
        Column column = null;
        DatabaseMetaData dbmd = null;
        List<String> tableNames = getTableNames();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            dbmd = conn.getMetaData();
            int size = tableNames.size();
            for (int i = 0; i < size; i++) {
                String tn = tableNames.get(i);
                rs = dbmd.getColumns(null, "%", tn , "%");
                table = new Table();
                table.setTableName(tn);
                columnList = new ArrayList<>();
                //调用方法
                readColumn(columnList, rs);
                table.setColumns(columnList);
                rs = dbmd.getPrimaryKeys(null, null, tn);
                while (rs.next()) {
                    table.setPrimaryKeyName(rs.getString(Table.Constants.COLUMNNAME));
                    break;
                }
                tableList.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogUtil.debug("获取表数据集合异常【getTableInfos】!");
        }finally {
            closeResultSet(rs);
            closeConnection(conn);
        }
        return tableList;
    }

    /**
     * <h4>获取单表信息</h4>
     * @param tableName 表名
     * @return
     */
    public static Table getTableInfo(String tableName) {
        Table table = null;
        Column column = null;
        DatabaseMetaData dbmd = null;
        List<Column> columnList = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            dbmd = conn.getMetaData();
            rs = dbmd.getColumns(null, "%", tableName, "%");
            table = new Table();
            table.setTableName(tableName);
            columnList = new ArrayList<>();
            //调用方法
            readColumn(columnList, rs);
            table.setColumns(columnList);
            rs = dbmd.getPrimaryKeys(null, null, tableName);
            while (rs.next()) {
                table.setPrimaryKeyName(rs.getString(Table.Constants.COLUMNNAME));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogUtil.debug("获取表数据异常【getTableInfo】!");
        }finally {
            closeResultSet(rs);
            closeConnection(conn);
        }
        return table;
    }

    /**
     * <h4>获取主键集合</h4>
     * @param tableName 表名
     * @return
     */
    public static List<String> getPrimaryKeyName(String tableName) {
        List<String> pks = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        DatabaseMetaData dbmd = null;

        try {
            dbmd = conn.getMetaData();
            rs = dbmd.getPrimaryKeys(null, null, tableName);
            while (rs.next()) {
                pks.add(rs.getString(Table.Constants.COLUMNNAME));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            LogUtil.debug("获取表主键名异常【getPrimaryKeyName】!");
        }finally {
            closeResultSet(rs);
            closeConnection(conn);
        }
        return pks;
    }

    /**
     * <h3>获取表的字段名</h3>
     * @param tableName 表名
     * @return
     */
    public static List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        //连接数据库
        Connection conn = getConnection();
        DatabaseMetaData dbmd = null;
        ResultSet rs = null;
        try {
            dbmd = conn.getMetaData();
            rs = dbmd.getColumns(null, "%", tableName, "%");
            while (rs.next()) {
                columnNames.add(rs.getString(Table.Constants.COLUMNNAME));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogUtil.debug("获取表列名 集合 异常【getColumnNames】!");
        }finally {
            closeResultSet(rs);
            closeConnection(conn);
        }
        return columnNames;
    }

    /**
     * <h3>获取表的类型</h3>
     * @param tableName 表名
     * @return
     */
    public static List<String> getColumnTypes(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //连接数据库
        Connection conn = getConnection();
        DatabaseMetaData dbmd = null;
        ResultSet rs = null;
        try {
            dbmd = conn.getMetaData();
            rs = dbmd.getColumns(null, "%", tableName, "%");
            while (rs.next()) {
                columnTypes.add(rs.getString(Table.Constants.TYPENAME));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogUtil.debug("获取表列类型 异常【getColumnTypes】!");
        }finally {
            closeResultSet(rs);
            closeConnection(conn);
        }
        return columnTypes;
    }

    /**
     * <h3>获取表的注释</h3>
     * @param tableName 表名
     * @return
     */
    public static List<String> getColumnComments(String tableName) {
        List<String> columnComments = new ArrayList<>();
        //连接数据库
        Connection conn = getConnection();
        DatabaseMetaData dbmd = null;
        ResultSet rs = null;
        try {
            dbmd = conn.getMetaData();
            rs = dbmd.getColumns(null, "%", tableName, "%");
            while (rs.next()) {
                columnComments.add(rs.getString(Table.Constants.REMARKS));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogUtil.debug("获取表列注释 异常【getColumnComments】!");
        }finally {
            closeResultSet(rs);
            closeConnection(conn);
        }
        return columnComments;
    }

    /**
     * <h3>获取主键 的列 数据</h3>
     * @param columnList 列集合
     * @param pkColumnName 列主键名
     * @return
     */
    public static Column getPrimaryKeyColumn(List<Column> columnList,String pkColumnName) {
        if (null != pkColumnName && null != columnList && columnList.size() > 0) {
            int size = columnList.size();
            for (int i = 0; i < size; i++) {
                if (pkColumnName.equals(columnList.get(i).getColumnName())) {
                    return columnList.get(i);
                }
            }
        }
        return new Column();
    }

    /**
     * <h4>读取列信息</h4>
     * @param columnList 列集合
     * @param rs
     * @throws SQLException
     */
    private static void readColumn(List<Column> columnList, ResultSet rs) throws SQLException {
        Column column;
        while (rs.next()) {
            column = new Column();
            //设置字段名称
            column.setColumnName(rs.getString(Table.Constants.COLUMNNAME));
            //设置字段类型
            column.setNameType(rs.getString(Table.Constants.TYPENAME));
            //设置字段注释
            column.setRemarks(rs.getString(Table.Constants.REMARKS));
            //设置属性类型和所需引用的包
            column.setFieldType(ConvertUtil.convertFieldType(column.getNameType(), column.getImprotPackage()));
            //设置属性名称
            column.setFieldName(ConvertUtil.convertColumnName2FieldName(column.getColumnName()));
            //设置字段长度
            column.setColumnSize(Integer.valueOf(rs.getString(Table.Constants.COLUMNSIZE)));
            //设置字段小数位
            column.setDecimalDigits(rs.getInt(Table.Constants.DECIMALDIGITS));
            columnList.add(column);
        }
    }

    // ========================================== set method ==================================================== //
    /**
     * @param DRIVER 数据库驱动
     */
    public static void setDRIVER(String DRIVER) {
        DbHelper.DRIVER = DRIVER;
    }

    /**
     * @param URL 数据库链接地址
     */
    public static void setURL(String URL) {
        DbHelper.URL = URL;
    }

    /**
     * @param USRENAME 数据库用户名
     */
    public static void setUSRENAME(String USRENAME) {
        DbHelper.USRENAME = USRENAME;
    }

    /**
     * @param PASSWORD 数据库密码
     */
    public static void setPASSWORD(String PASSWORD) {
        DbHelper.PASSWORD = PASSWORD;
    }
}
