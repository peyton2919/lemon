package cn.peyton.spring.basis.service;

import cn.peyton.spring.basis.entity.Brand;
import cn.peyton.spring.basis.param.BrandParam;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceLike;
import cn.peyton.spring.inf.IServiceBySelect;
import cn.peyton.spring.inf.IServiceUpdateStatus;

/**
 * <h3>品牌 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
public interface BrandService extends IService<Integer,BrandParam,Brand>,
        IServiceBySelect<BrandParam>,IServiceLike<BrandParam>,IServiceUpdateStatus<Integer> {


    /**
     * <h4>名称条件判断</h4>
     * @param sessionName 保存在Session 中图片名称
     * @param displayName 图片显示在 input 中的名称
     * @param fileName MultipartFile 图片对象的名称
     * @param length MultipartFile 图片对象的长度
     * @return
     */
    boolean exist(String sessionName, String displayName, String fileName, long length);
}
