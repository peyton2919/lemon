package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.mall.entity.DeletePicture;
import cn.peyton.spring.mall.service.DeletePictureService;
import cn.peyton.spring.mall.dao.DeletePictureMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>删除图片 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/10 10:25:15
 * @version 1.0.0
 * </pre>
*/
@Service("deletePictureService")
public class DeletePictureServiceImpl implements DeletePictureService {
	@Resource
	private DeletePictureMapper deletePictureMapper;

    @Override
    public void save(DeletePicture param) {
        deletePictureMapper.insert(param);
    }

    @Override
    public void batch(List<DeletePicture> deletePictures) {
        deletePictureMapper.batchInsert(deletePictures);
    }

    @Override
    public void update(DeletePicture param) {
        deletePictureMapper.updateByPrimaryKey(param);
    }

    @Override
    public void delete(Long id) {
        deletePictureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DeletePicture findById(Long id) {
        return deletePictureMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<DeletePicture> findByAll(PageQuery page) {
        int count = deletePictureMapper.count();
        PageResult<DeletePicture> result = new PageResult<>();
        if (count > 0) {
            result.setTotal(count);
            result.setData(deletePictureMapper.selectByAll(page));
        }
        return result;
    }

    @Override
    public PageResult<DeletePicture> findLikeByKeyword(String keyword, PageQuery page) {
        int count = deletePictureMapper.countLikeByKeyword(keyword);
        PageResult<DeletePicture> result = new PageResult<>();
        if (count > 0) {
            result.setTotal(count);
            result.setData(deletePictureMapper.selectLikeByKeyword(keyword,page));
        }
        return result;
    }
}
