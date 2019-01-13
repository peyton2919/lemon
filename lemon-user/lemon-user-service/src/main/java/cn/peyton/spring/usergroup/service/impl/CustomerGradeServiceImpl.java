package cn.peyton.spring.usergroup.service.impl;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.usergroup.bo.CustomerGradeConvertBo;
import cn.peyton.spring.usergroup.dao.CustomerGradeMapper;
import cn.peyton.spring.usergroup.entity.CustomerGrade;
import cn.peyton.spring.usergroup.param.CustomerGradeParam;
import cn.peyton.spring.usergroup.service.CustomerGradeService;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>客户等级 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
@Service("customerGradeService")
public class CustomerGradeServiceImpl implements CustomerGradeService {
	@Resource
	private CustomerGradeMapper customerGradeMapper;

    @Override
    public void save(CustomerGradeParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(customerGradeMapper, param.getId(), param.getName())) {
            throw new ValidationException("已有相同的等级名称");
        }
        CustomerGrade customerGrade = param.convert();
        customerGradeMapper.insertSelective(customerGrade);
    }

    @Override
    public void update(CustomerGradeParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(customerGradeMapper, param.getId(), param.getName())) {
            throw new ValidationException("已有相同的等级名称");
        }
        CustomerGrade before = customerGradeMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的等级不存在");
        CustomerGrade after = param.convert();
        customerGradeMapper.updateByPrimaryKey(after);
    }

    @Override
    public void delete(Integer id) {
        //todo 1、判断客户对象是否有引用 、 再删除

    }

    @Override
    public CustomerGradeParam findById(Integer id) {
        return new CustomerGradeParam().compat(customerGradeMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<CustomerGradeParam> findByAll(PageQuery page) {
        PageResult<CustomerGradeParam> result = new PageResult<>();
        int count = customerGradeMapper.count();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new CustomerGradeConvertBo().adapter(customerGradeMapper.selectByAll(page)));
        }
        return result;
    }

    @Override
    public PageResult<CustomerGradeParam> findLikeByKeyword(String keyword, PageQuery page) {
        PageResult<CustomerGradeParam> result = new PageResult<>();
        int count = customerGradeMapper.countLikeByKeyword(keyword);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new CustomerGradeConvertBo().adapter(customerGradeMapper.selectLikeByKeyword(keyword,page)));
        }
        return result;
    }

    @Override
    public List<CustomerGradeParam> findBySelect() {
        return new CustomerGradeConvertBo().adapter(customerGradeMapper.selectBySelect());
    }
}
