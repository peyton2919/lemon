package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.bo.FreightTypeBo;
import cn.peyton.spring.basis.dao.FreightTypeMapper;
import cn.peyton.spring.basis.entity.FreightType;
import cn.peyton.spring.basis.param.FreightTypeParam;
import cn.peyton.spring.basis.service.FreightTypeService;
import cn.peyton.spring.beans.ResultAdapter;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>货运类型 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/09 19:01:41
 * @version 1.0.0
 * </pre>
*/
@Service("freightTypeService")
public class FreightTypeServiceImpl implements FreightTypeService {
	@Resource
	private FreightTypeMapper freightTypeMapper;

    @Override
    public PageResult<FreightTypeParam> findLikeByKeywordAndPage(String keyword, PageQuery page) {
        int count = freightTypeMapper.countLikeByKeyword(keyword);
        if (count >0 ){
            return new PageResult<FreightTypeParam>(new FreightTypeBo().adapter(freightTypeMapper.selectLikeByKeyword(keyword, page)), count);
        }
        return new PageResult<FreightTypeParam>();
    }

    @Override
    public void save(FreightTypeParam param) {
        Validation.check(param);
        if (exist(param.getId(),param.getName())){
            throw new ParamException("有相同名称的货运类型");
        }
        FreightType freightType = param.convert();

        freightType.setFrtCreated(new Date());
        freightType.setFrtUpdated(new Date());
        freightTypeMapper.insertSelective(freightType);
    }

    @Override
    public void update(FreightTypeParam param) {
        Validation.check(param);
        if (exist(param.getId(),param.getName())){
            throw new ParamException("有相同名称的货运类型");
        }
        FreightType before = freightTypeMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的货运类型不存在!");
        FreightType after = param.convert();
        after.setFrtUpdated(new Date());
        freightTypeMapper.updateByPrimaryKey(after);

    }

    @Override
    public void delete(Integer id) {
        freightTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public FreightTypeParam findById(Integer id) {
        return new FreightTypeParam().compat(freightTypeMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<FreightTypeParam> findByAll(PageQuery page) {
        return ResultAdapter.adapt(freightTypeMapper, page, new FreightTypeBo());
    }

    /**
     * <h4>判断重名</h4>
     * @param id 编号
     * @param name 名称
     * @return 重名为true
     */
    private boolean exist(Integer id,String name) {
        return freightTypeMapper.countByName(id,name) > 0;
    }

}
