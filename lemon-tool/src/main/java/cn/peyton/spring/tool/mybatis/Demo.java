package cn.peyton.spring.tool.mybatis;

import cn.peyton.spring.tool.mybatis.entity.Column;
import cn.peyton.spring.tool.mybatis.util.TextTemplateUtil;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>测试类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.Demo.java
 * CreateDate: 2018/8/7 12:42
 * Version: 1.0.0
 * </pre>
 */
public class Demo {
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/db_lemon?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false";
    public static String USRENAME = "root";
    public static String PASSWORD = "hc2919";

    public static void main(String[] args){
//        Generation generation = new Generation(Generation.Join.DRIVER, Generation.Join.URL, Generation.Join.USRENAME, "");
        Generation generation = new Generation(DRIVER, URL, USRENAME, PASSWORD);

//        generation.create("sys_dept","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.usergroup.dao","cn.peyton.spring.usergroup.entity",true);
//
//        generation.createParam("sys_dept","DeptParam","",
//                "f:/test/1","cn.peyton.spring.usergroup.param");

//        generation.create("sys_post","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.usergroup.dao","cn.peyton.spring.usergroup.entity",true);
//
//        generation.createParam("sys_Post","PostParam","",
//                "f:/test/1","cn.peyton.spring.usergroup.param");

//        generation.create("sys_employee","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.usergroup.dao","cn.peyton.spring.usergroup.entity",true);
//
//        generation.createParam("sys_employee","EmployeeParam","emp",
//                "f:/test/1","cn.peyton.spring.usergroup.param");

        generation.create("tb_attention","tb_,pub_", "f:/test/1",
                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

        generation.createParam("tb_attention","AttentionParam","att",
                "f:/test/1","cn.peyton.spring.mall.param");

        generation.create("tb_collect","tb_,pub_", "f:/test/1",
                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

        generation.createParam("tb_collect","CollectParam","coll",
                "f:/test/1","cn.peyton.spring.mall.param");



    }


}
