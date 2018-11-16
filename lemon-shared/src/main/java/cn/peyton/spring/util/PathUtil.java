package cn.peyton.spring.util;

import javax.servlet.http.HttpServletRequest;

/**
 * <h3>路径工具类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:00
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class PathUtil {

    /**
     * <h4>获取路径</h4>
     * @param location 位置名
     * @param request request对象
     * @return
     */
    public final static String getPath(String location, HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath(location);
    }

    /**
     * <h4>图片上传时的路径名称转换</h4>
     * @param location 图片保存的上级根目录名称
     * @param name 图片原始名称
     * @param dataPath 保存到数据库中的图片路径
     * @param completePath 完整的图片路径
     */
    public final static void convertPath(HttpServletRequest request,String location,String name,
                                         StringBuilder dataPath ,StringBuilder completePath) {
        if (null == name || null == dataPath || null == completePath) {
            return;
        }
        //获取扩展名
        String ext = NameUtil.getImageExtendName(name);
        //获取当前 完成路径
        String path = request.getSession(false).getServletContext().getRealPath(location);
        String uuidName = UUIDUtil.createUUID();
        dataPath.append(location);
        dataPath.append(uuidName + ext);
        //完整 路径
        completePath.append(path);
        completePath.append(uuidName + ext);
    }

    /**
     * <h4>获取完整文件路径</h4>
     * @param name 名称
     * @param request 请求对象
     * @return 完成路径
     */
    public final static String getCompletePath(String name, HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath(name);
    }
}
