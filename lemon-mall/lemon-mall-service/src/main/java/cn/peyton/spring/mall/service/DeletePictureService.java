package cn.peyton.spring.mall.service;

import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceLike;
import cn.peyton.spring.mall.entity.DeletePicture;

import java.util.List;

/**
 * <h3>删除图片 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/10 10:25:15
 * @version 1.0.0
 * </pre>
*/
public interface DeletePictureService extends IService<Long,DeletePicture,DeletePicture>,IServiceLike<DeletePicture> {
    /**
     * <h4>批量插入删除图片</h4>
     * @param deletePictures
     */
    void batch(List<DeletePicture> deletePictures);

}
