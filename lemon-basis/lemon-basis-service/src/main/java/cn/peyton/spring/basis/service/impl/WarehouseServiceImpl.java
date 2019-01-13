package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.bo.WarehouseConvertBo;
import cn.peyton.spring.basis.dao.WarehouseMapper;
import cn.peyton.spring.basis.entity.Warehouse;
import cn.peyton.spring.basis.param.WarehouseParam;
import cn.peyton.spring.basis.service.WarehouseService;
import cn.peyton.spring.beans.ResultAdapter;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>仓库 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/11 14:34:57
 * @version 1.0.0
 * </pre>
*/
@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {
	@Resource
	private WarehouseMapper warehouseMapper;

    @Override
    public PageResult<WarehouseParam> findLikeByKeywordAndPage(String keyword, PageQuery page) {
        return ResultAdapter.adapt(warehouseMapper, keyword, page, new WarehouseConvertBo());
    }

    @Override
    public void save(WarehouseParam param) {
        Validation.check(param);
        if (exist(param.getId(),param.getName())){
            throw new ValidationException("仓库有相同名称");
        }
        Warehouse info = param.convert();
        warehouseMapper.insertSelective(info);
    }

    @Override
    public void update(WarehouseParam param) {
        Validation.check(param);
        if (exist(param.getId(),param.getName())){
            throw new ValidationException("仓库有相同名称");
        }
        Warehouse before = warehouseMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的仓库不存在!");
        Warehouse after = param.convert();
        warehouseMapper.updateByPrimaryKey(after);
    }

    @Override
    public void delete(Integer id) {
        warehouseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public WarehouseParam findById(Integer id) {
        return new WarehouseParam().compat(warehouseMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<WarehouseParam> findByAll(PageQuery page) {
        return ResultAdapter.adapt(warehouseMapper, page, new WarehouseConvertBo());
    }

    @Override
    public List<WarehouseParam> findBySelect() {
        return new WarehouseConvertBo().adapter(warehouseMapper.selectBySelect());
    }

    /**
     * <h4>判断重名</h4>
     * @param id 编号
     * @param name 名称
     * @return 重名为true
     */
    private boolean exist(Integer id,String name) {
        return warehouseMapper.countByName(id, name) > 0;
    }

}
