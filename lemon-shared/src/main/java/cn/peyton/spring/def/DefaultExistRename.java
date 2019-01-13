package cn.peyton.spring.def;

import cn.peyton.spring.inf.IMapperByRename;
import cn.peyton.spring.inf.IMapperMultiRename;

/**
 * <h3>判断重名 类</h3>
 * <pre>
 *     必须实现 IMapperByRename 接口
 * </pre>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.def.DefaultExistRename.java
 * @createDate: 2018/9/13 13:47
 * @version: 1.0.0
 * </pre>
 */
public final class DefaultExistRename {

    /**
     * <h4>判断重名</h4>
     * @param mapper 实现 Mapper重名 接口
     * @param id 主键
     * @param name 名称
     * @return 重名 为true
     */
    public static <K> boolean exist(IMapperByRename<K> mapper, K id, String name) {
        return mapper.countByName(id,name) > 0;
    }

    /**
     * <h4>判断重名</h4>
     * @param mapper 实现 Mapper重名 接口
     * @param id 主键
     * @param parentId 父主键
     * @param name 名称
     * @return 重名 为true
     */
    public static <K> boolean exist(IMapperMultiRename<K> mapper, K id, K parentId, String name) {
        return mapper.countMultiByName(id,parentId,name) > 0;
    }



}
