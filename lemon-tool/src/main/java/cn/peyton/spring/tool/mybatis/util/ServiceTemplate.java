package cn.peyton.spring.tool.mybatis.util;

/**
 * <h3></h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.tool.mybatis.util.ServiceTemplate.java
 * CreateDate: 2018/8/10 9:40
 * Version: 1.0.0
 * </pre>
 */
public class ServiceTemplate extends BaseTemplate {


    public static void create(String objName,String path, String daoPackage, String servicePackage) {
        _path = existPath(path);
        createService(objName, servicePackage);
        createServiceImpl(objName, daoPackage, servicePackage);
    }

    /**
     * <h4>创建Service接口</h4>
     * @param objName 对象名
     * @param packageName mapper包路径
     * @return
     */
    public static String createService(String objName,String packageName) {
        sb = new StringBuffer();
        if (null != packageName) {
            sb.append("package " + packageName + ";\r\n");
        }
        createAnnotation("Service 接口");
        createServiceClass(objName);
        createFileContent(packageName, objName + "Service", "java");
        return sb.toString();
    }

    /**
     * <h4>创建Service实现类</h4>
     *
     * @param packageName mapper包路径
     * @return
     */
    public static String createServiceImpl(String objName ,String daoPackage,String packageName) {
        sb = new StringBuffer();
        if (null != packageName) {
            sb.append("package " + packageName + ".impl;\r\n");
        }
        sb.append("\r\n");
        sb.append("import " + packageName + "." + objName + "Service;\r\n");
        sb.append("import " + daoPackage + "." + objName + "Mapper;\r\n");
        sb.append("import org.springframework.stereotype.Service;\r\n");
        sb.append("import javax.annotation.Resource;\r\n\r\n");

        createAnnotation("Service 实现类");
        createServiceImplClass(objName);

        createFileContent(packageName + ".impl", objName + "ServiceImpl", "java");
        return sb.toString();
    }
    // ============================================== create Service method begin ============================================== //

    /**
     * <h4>创建Service接口</h4>
     * @param objName 对象名
     */
    private static void createServiceClass(String objName) {
        sb.append("public interface " + objName + "Service {\r\n\r\n");

        sb.append("}\r\n");
    }

    /**
     * <h4>创建Service接口</h4>
     */
    private static void createServiceImplClass(String objName) {
        String tempObjName = ConvertUtil.toFirstLowerCase(objName);
        sb.append("@Service(\"" + tempObjName + "Service\")\r\n");
        sb.append("public class " + objName + "ServiceImpl implements " + objName + "Service {\r\n");

        sb.append("\t@Resource\r\n");
        sb.append("\tprivate " + objName + "Mapper " + tempObjName + "Mapper;\r\n\r\n");
        sb.append("}\r\n");
    }
    // ============================================== create Service method end ============================================== //
}
