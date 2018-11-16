package cn.peyton.spring.tool.mybatis;

/**
 * <h3></h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.ConvertTest.java
 * CreateDate: 2018/8/13 12:05
 * Version: 1.0.0
 * </pre>
 * @author peyton
 */
public class ConvertTest {
    public static void main(String[] args) {
        Generation generation = new Generation(Generation.Join.DRIVER, Generation.Join.URL, Generation.Join.USRENAME, "hc2919");

        System.out.println(generation.createConvert("tb_customer_info", "CustomerInfo",null,"cus"));
        System.out.println(generation.createCompat("tb_customer_info", "CustomerParam","cus",
                "CustomerInfo",null));

//        System.out.println(generation.createConvert("tb_payment_mode", "PaymentMode",null,"pamo"));
//        System.out.println(generation.createCompat("tb_payment_mode", "PaymentModeParam","pamo",
//                "PaymentMode",null));

//        System.out.println(generation.createConvert("tb_customer_grade", "CustomerGrade",null,"cugr"));
//        System.out.println(generation.createCompat("tb_customer_grade", "CustomerGradeParam","cugr",
//                "CustomerGrade",null));

//        System.out.println(generation.createConvert("tb_region_info", "RegionInfo",null,"regi"));
//        System.out.println(generation.createCompat("tb_region_info", "RegionParam","regi",
//                "RegionInfo",null));

//        System.out.println(generation.createConvert("tb_supplier_info", "SupplierInfo",null,"sup"));
//        System.out.println(generation.createCompat("tb_supplier_info", "SupplierParam","sup",
//                "SupplierInfo",null));
//        System.out.println(generation.createConvert("tb_brand_info", "BrandInfo",null,"brand"));
//        System.out.println(generation.createCompat("tb_brand_info", "BrandParam","brand",
//                "BrandInfo",null));

//        System.out.println(generation.createConvert("tb_storage_info", "StorageInfo",null,"stor"));
//        System.out.println(generation.createCompat("tb_storage_info", "StorageParam","stor",
//                "StorageInfo",null));

//        System.out.println(generation.createConvert("tb_storage_detail", "StorageDetail",null,"stde"));
//        System.out.println(generation.createCompat("tb_storage_detail", "StorageDetailParam","stde",
//                "StorageDetail",null));

//        System.out.println(generation.createConvert("tb_inventory_info", "InventoryInfo",null,"inve"));
//        System.out.println(generation.createCompat("tb_inventory_info", "InventoryParam","inve",
//                "InventoryInfo",null));


    }
}
