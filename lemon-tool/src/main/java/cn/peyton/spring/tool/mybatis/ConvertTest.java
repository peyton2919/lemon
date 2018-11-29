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

        System.out.println(generation.createConvert("tb_collect", "Collect",null,"coll"));
        System.out.println(generation.createCompat("tb_collect", "CollectParam","coll",
                "Collect",""));

//        System.out.println(generation.createConvert("tb_attention", "Attention",null,"att"));
//        System.out.println(generation.createCompat("tb_attention", "AttentionParam","att",
//                "Attention",""));

//        System.out.println(generation.createConvert("sys_dept", "SysDept",null,""));
//        System.out.println(generation.createCompat("sys_dept", "DeptParam","",
//                "SysDept",null));

//        System.out.println(generation.createConvert("sys_employee", "SysEmployee",null,"emp"));
//        System.out.println(generation.createCompat("sys_employee", "EmployeeParam","emp",
//                "SysEmployee",""));

//        System.out.println(generation.createConvert("sys_admin", "SysAdmin",null,"admin"));
//        System.out.println(generation.createCompat("sys_admin", "AdminParam","admin",
//                "SysAdmin",""));

    }
}
