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



//        generation.create("tb_region_info","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

//        generation.createParam("tb_region_info","RegionParam","regi",
//                "f:/test/1","cn.peyton.spring.mall.param");

//        generation.create("tb_customer_grade","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

//        generation.createParam("tb_customer_grade","CustomerGrageParam","cugr",
//                "f:/test/1","cn.peyton.spring.mall.param");

//        generation.create("tb_payment_mode","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//
//        generation.createParam("tb_payment_mode","PaymentModeParam","pamo",
//                "f:/test/1","cn.peyton.spring.mall.param");

        generation.create("tb_customer_info","tb_,pub_", "f:/test/1",
                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

        generation.createParam("tb_customer_info","CustomerParam","cus",
                "f:/test/1","cn.peyton.spring.mall.param");

//        System.out.println(generation.createConstructor("tb_supplier_info","SupplierInfo"));
//
//        System.out.println(generation.createConvert("tb_supplier_info","SupplierInfo"));
        //创建单个
//        generation.create("pub_web_config","tb_,pub_", "f:/test/4",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
        //创建多个
//        generation.create("tb_,pub_", "f:/test/4",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

//        generation.create("sys_admin","tb_,pub_", "f:/test/4",
//                "cn.peyton.spring.permission.dao","cn.peyton.spring.permission.entity",true);
//        generation.create("sys_post","tb_,pub_", "f:/test/4",
//                "cn.peyton.spring.permission.dao","cn.peyton.spring.permission.entity",true);
//        generation.create("sys_employee","tb_,pub_", "f:/test/1",
//                        "cn.peyton.spring.permission.dao","cn.peyton.spring.permission.entity",true);
//generation.create("tb_freight_type","tb_,pub_", "f:/test/1",
//                        "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//        generation.create("tb_warehouse_info","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//        generation.create("tb_shipping_info","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);s
//        generation.create("tb_color_info","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//        generation.create("tb_origin_info","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//        generation.create("tb_brand_info","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//        generation.create("tb_commodity_sort","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//        generation.create("tb_commodity_category","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//        generation.create("tb_supplier_info","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

//        generation.create("tb_commodity_info","tb_,pub_", "f:/test/1",
//                                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

//        generation.createParam("tb_commodity_info","CommodityParam","com",
//                "f:/test/1","cn.peyton.spring.mall.param");

//        generation.create("tb_delete_picture","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

//        generation.create("tb_storage_info","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//
//        generation.create("tb_storage_detail","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);
//
//        generation.create("tb_inventory_info","tb_,pub_", "f:/test/1",
//                "cn.peyton.spring.mall.dao","cn.peyton.spring.mall.entity",true);

//        generation.createParam("tb_storage_info","StorageParam","stor",
//                "f:/test/1","cn.peyton.spring.mall.param");
//
//        generation.createParam("tb_storage_detail","StorageDetailParam","stde",
//                "f:/test/1","cn.peyton.spring.mall.param");
//
//        generation.createParam("tb_inventory_info","InventoryParam","inve",
//                "f:/test/1","cn.peyton.spring.mall.param");


    }


}
