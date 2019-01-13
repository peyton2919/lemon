package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.Region;
import cn.peyton.spring.basis.param.RegionParam;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceLike;
import cn.peyton.spring.inf.IServiceBySelect;

import java.util.List;

/**
 * <h3>地区 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public interface RegionService extends IService<Long,RegionParam,Region>,
        IServiceLike<RegionParam>,IServiceBySelect<RegionParam>{

    /**
     * <h4>树结构</h4>
     * @return 地区对象集合
     */
    List<RegionParam> tree();

    /**
     * <h4>根据 父级编号 查找 地区对象集合</h4>
     * @param parentId 父级编号
     * @return 地区对象集合
     */
    List<RegionParam> findByParentId(Long parentId);

}
