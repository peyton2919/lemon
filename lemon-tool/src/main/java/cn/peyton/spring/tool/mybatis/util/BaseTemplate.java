package cn.peyton.spring.tool.mybatis.util;

import cn.peyton.spring.tool.mybatis.entity.Table;
import cn.peyton.spring.tool.mybatis.file.FileUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h3></h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName lemon
 * @ackageName: cn.peyton.spring.tool.mybatis.util.BaseTemplate.java
 * @createDate: 2018/8/10 9:28
 * @version: 1.0.0
 * </pre>
 */
public abstract class BaseTemplate {
    /** 前缀 get */
    protected static final String PREFIX_GET = "get";
    /** 前缀 set */
    protected static final String PREFIX_SET = "set";
    /** 路径 */
    protected static String _path;
    /** 申明 可变换的字符串 */
    protected static StringBuffer sb ;

    protected static Table _table = new Table();


    /**
     * <h3>创建类部注释</h>
     * @param name 名称
     */
    protected static void createAnnotation(String name) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        sb.append("/**\r\n");
        sb.append(" * <h3> " + name + " .</h3>\r\n");
        sb.append(" * <pre>\r\n");
        sb.append(" * @author <a href=\"http://www.peyton.cn\">peyton</a>\r\n");
        sb.append(" * @email <a href=\"mailto:fz2919@tom.com\">fz2919@tom.com</a>\r\n");
        sb.append(" * @createDate " + dateFormat.format(new Date()) + "\r\n");
        sb.append(" * @version 1.0.0\r\n");
        sb.append(" * </pre>\r\n");
        sb.append("*/\r\n");
    }

    /**
     * <h4>创建文件</h4>
     * @param packageName 包名
     * @param fileName 文件名
     * @param ext 扩展名
     */
    protected static void createFileContent(String packageName, String fileName, String ext) {
        String tPath = packageName.replace(".", "/");
        tPath = FileUtil.changePath(_path) + tPath;
        tPath = FileUtil.changePath(tPath);
        FileUtil.createDirectory(tPath);
        FileUtil.createFile(tPath, fileName, ext, sb.toString());
    }

    /**
     * <h4>判断当前路径</h4>
     * @param path
     * @return
     */
    protected static String existPath(String path) {
        if(null == path || "".equals(path) || ".".equals(path)) {
            String  tPath = new File(BaseTemplate.class.getResource("/").getPath()).getAbsolutePath();
            String eq = "target\\";
            int location = tPath.lastIndexOf(eq);
            tPath = tPath.substring(0,location);
            String fixedPath = "src\\main\\java\\";
            return tPath + fixedPath;
        }
        return  path;
    }
}
