package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.bo.BrandConvertBo;
import cn.peyton.spring.basis.dao.BrandMapper;
import cn.peyton.spring.basis.entity.Brand;
import cn.peyton.spring.basis.param.BrandParam;
import cn.peyton.spring.basis.service.BrandService;
import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.constant.Constants;
import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.file.FolderOperation;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.util.PathUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>品牌 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
@Service("brandService")
public class BrandServiceImpl implements BrandService {
	@Resource
	private BrandMapper brandMapper;

    @Override
    public void save(BrandParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(brandMapper, param.getId(), param.getName())) {
            FolderOperation.delFile(param.getCompletePath());
            throw new GlobalException("已有存在相同的品牌名称");
        }
        Brand info = param.convert();
        brandMapper.insertSelective(info);

    }

    @Override
    public void update(BrandParam param) {
        Validation.check(param);
        String tName = (String) RequestHolder.getCurrentRequest().getSession().getAttribute(Constants.SESSION_CURRENT_IMAGE.name());
        MultipartFile file = param.getImgFile();
        long length = file.getSize();
        //
        boolean tExist = exist(tName, param.getImgName(), file.getOriginalFilename(), length);

        if (DefaultExistRename.exist(brandMapper, param.getId(), param.getName())) {

            if (tExist) {
                FolderOperation.delFile(param.getCompletePath());
            }

            throw new GlobalException("已有存在相同的品牌名称");
        }
        Brand before = brandMapper.selectByPrimaryKey(param.getId());
        if (null == before) {
            if (tExist) {
                FolderOperation.delFile(param.getCompletePath());
            }
            throw new GlobalException("待更新的品牌不存在!");
        }
        Brand after = param.convert();
        brandMapper.updateByPrimaryKeySelective(after);
        if (tExist) {
            FolderOperation.delFile(PathUtil.getCompletePath(before.getBrandLogo(),RequestHolder.getCurrentRequest()));
        }
    }

    @Override
    public void delete(Integer id) {
        brandMapper.updateStatus(id, Status.DELETE.getCode());
    }

    @Override
    public BrandParam findById(Integer id) {
        return new BrandParam().compat(brandMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<BrandParam> findByAll(PageQuery page) {
        PageResult<BrandParam> params = new PageResult<>();
        int count = brandMapper.count();
        if (count > 0) {
            params.setTotal(count);
            params.setData(new BrandConvertBo().adapter(brandMapper.selectByAll(page)));
        }
        return params;
    }

    @Override
    public PageResult<BrandParam> findLikeByKeyword(String keyword, PageQuery page) {
        PageResult<BrandParam> params = new PageResult<>();
        int count = brandMapper.count();
        if (count > 0) {
            params.setTotal(count);
            params.setData(new BrandConvertBo().adapter(brandMapper.selectLikeByKeyword(keyword,page)));
        }
        return params;
    }

    @Override
    public List<BrandParam> findBySelect() {
        return new BrandConvertBo().adapter(brandMapper.selectBySelect());
    }

    @Override
    public void updateStatus(Integer id, Integer status) {
        brandMapper.updateStatus(id, status);
    }

    @Override
    public boolean exist(String sessionName, String displayName, String fileName,long length) {

        if (!sessionName.equals(displayName) && (length > 0 && !sessionName.equals(fileName))) {
            return true;
        }
        return false;
    }
}
