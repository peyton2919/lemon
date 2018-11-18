package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.beans.ResultAdapter;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.permission.bo.CategoryBo;
import cn.peyton.spring.permission.dao.SysCategoryMapper;
import cn.peyton.spring.permission.entity.SysCategory;
import cn.peyton.spring.permission.param.CategoryParam;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.permission.service.SysCategoryService;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>栏目 Service 实现类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 14:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Service("sysCategoryService")
public class SysCategoryServiceImpl implements SysCategoryService {
	@Resource
	private SysCategoryMapper sysCategoryInfoMapper;

    @Override
    public void save(CategoryParam param) {
        Validation.check(param);
        if (exist(param.getId(), param.getParentId(), param.getType(),param.getName())) {
            throw new ParamException("已有相同的栏目名称!");
        }
        SysCategory info = param.convert();

        sysCategoryInfoMapper.insertSelective(info);
        //日志

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(CategoryParam param) {
        Validation.check(param);
        if (exist(param.getId(), param.getParentId(),param.getType(), param.getName())) {
            throw new ParamException("已有相同的栏目名称!");
        }
        SysCategory before = sysCategoryInfoMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"侍更新的栏目不存在!");
        SysCategory after = param.convert();
        if (after.getCateStatus() == 0) {
            sysCategoryInfoMapper.updateChildStatus(after.getId(), Status.CONGEAL.getCode());
        }
        sysCategoryInfoMapper.updateByPrimaryKey(after);
        //日志

    }

    @Override
    public void delete(Integer id) {
        //不用
    }

    @Override
    public CategoryParam findById(Integer id ) {
        return new CategoryParam().compat(sysCategoryInfoMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<CategoryParam> findByAllAndPage(PageQuery page) {
        return ResultAdapter.adapt(sysCategoryInfoMapper,page,new CategoryBo());
    }

    @Override
    public PageResult<CategoryParam> findByTypeAndPage(Integer type, PageQuery page) {
        PageResult<CategoryParam> result = new PageResult<>();
        int count = sysCategoryInfoMapper.countByType(type);
        if (count > 0){
            result.set(new CategoryBo().adapter(sysCategoryInfoMapper.selectByTypeAndAll(type, page)),count);
        }
        return result;
    }

    @Override
    public int updateStatus(Integer id, Integer status) {
        //需要批量更新
        int count = sysCategoryInfoMapper.countChild(id);
        if (count > 0) {
            throw new ParamException("栏目还有子类,不能删除!");
        }
        return sysCategoryInfoMapper.updateStatus(id,status);
    }

    @Override
    public PageResult<CategoryParam> findByType(Integer type) {
        PageResult<CategoryParam> result = new PageResult<>();
        int count = sysCategoryInfoMapper.countByType(type);
        if (count > 0) {
            result.set(new CategoryBo().adapter(sysCategoryInfoMapper.selectByType(type)),count);
        }
        return result;
    }

    @Override
    public List<CategoryParam> findByCategory(Integer type) {
        return new CategoryBo().adapter(sysCategoryInfoMapper.selectByType(type));
    }

    @Override
    public List<CategoryParam> findByParentId(Integer parentId,boolean isSelect) {
        return new CategoryBo().adapter(sysCategoryInfoMapper.selectByParentId(parentId,isSelect));
    }

    @Override
    public PageResult<CategoryParam> findSearchByLikeName(String name,Integer type, PageQuery page) {
        PageResult<CategoryParam> result = new PageResult<>();
        int count = sysCategoryInfoMapper.countSearchByLikeName(name,type);
        if (count > 0) {
            result.set(new CategoryBo().adapter(sysCategoryInfoMapper.selectSearchByLikeName(name,type,page)),count);
        }
        return result;
    }

    /**
     * <h4>判断重名</h4>
     * @param id 编号
     * @param pId 父编号
     * @param type 栏目类型
     * @param name 名称
     * @return 重名 true
     */
    private boolean exist(Integer id,Integer pId,Integer type,String name){
        return sysCategoryInfoMapper.countByName(id, pId,type , name) > 0;
    }
}
