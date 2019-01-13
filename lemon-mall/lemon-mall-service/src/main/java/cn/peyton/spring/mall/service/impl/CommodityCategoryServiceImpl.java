package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.mall.bo.CommodityCategoryConvertBo;
import cn.peyton.spring.mall.entity.CommodityCategory;
import cn.peyton.spring.mall.param.CommodityCategoryParam;
import cn.peyton.spring.mall.service.CommodityCategoryService;
import cn.peyton.spring.mall.dao.CommodityCategoryMapper;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.beans.ResultAdapter;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.LevelUtil;
import cn.peyton.spring.util.Lists;
import cn.peyton.spring.validator.Validation;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * <h3>商品类目 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/14 11:25:12
 * @version 1.0.0
 * </pre>
*/
@Service("commodityCategoryService")
public class CommodityCategoryServiceImpl implements CommodityCategoryService {
	@Resource
	private CommodityCategoryMapper commodityCategoryMapper;

    @Override
    public void save(CommodityCategoryParam param) {
        Validation.check(param);
        if (exist(param.getParentId(), param.getName(), param.getId())) {
            throw new GlobalException("同一级下已有存在相同名称商品类目!");
        }
        CommodityCategory commodityCategory = param.convert();
        commodityCategory.setCocaCreated(new Date());
        commodityCategory.setCocaUpdated(new Date());
        commodityCategory.setCocaLevel(LevelUtil.calculateLevelLong(getLevel(param.getParentId()), param.getParentId()));
        commodityCategoryMapper.insertSelective(commodityCategory);
    }

    @Override
    public void update(CommodityCategoryParam param) {
        Validation.check(param);
        if (param.getParentId().equals(param.getId())) {
            throw new ParamException("上级名称不能是自身!");
        }
        if (exist(param.getParentId(), param.getName(), param.getId())) {
            throw new GlobalException("同一级下已有存在相同名称商品类目!");
        }
        CommodityCategory before = commodityCategoryMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的商品栏目不存在!");
        if (exist(param.getParentId(), param.getName(), param.getId())) {
            throw new GlobalException("同一级下已有存在相同名称商品类目!");
        }
        CommodityCategory after = param.convert();
        after.setCocaUpdated(new Date());
        after.setCocaLevel(LevelUtil.calculateLevelLong(getLevel(param.getParentId()), param.getParentId()));
        updateWithChild(before,after);

    }

    @Override
    public void delete(Long id) {
        CommodityCategory commodityCategory = commodityCategoryMapper.selectByPrimaryKey(id);
        CheckedUtil.checkNoNull(commodityCategory,"待删除栏目不存在,无法删除!");
        if (commodityCategoryMapper.countByParentId(commodityCategory.getId()) > 0) {
            throw new ParamException("当前栏目下有子栏目,无法删除!");
        }
        //todo 判断商品中是否有类目
        commodityCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CommodityCategoryParam findById(Long id) {
        return new CommodityCategoryParam().compat(commodityCategoryMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<CommodityCategoryParam> findByAll(PageQuery page) {
        return ResultAdapter.adapt(commodityCategoryMapper,page,new CommodityCategoryConvertBo());
    }

    @Override
    public PageResult<CommodityCategoryParam> findLikeByKeyword(String keyword, PageQuery page) {

        return ResultAdapter.adapt(commodityCategoryMapper,keyword,page,new CommodityCategoryConvertBo());
    }

    @Override
    public List<CommodityCategoryParam> findBySelect() {

        return new CommodityCategoryConvertBo().adapter(commodityCategoryMapper.selectBySelect());
    }

    @Override
    public List<CommodityCategoryParam> tree() {
        List<CommodityCategory> commodityCategoryList = commodityCategoryMapper.selectBySelect();
        List<CommodityCategoryParam> paramList = Lists.newArrayList();
        for (CommodityCategory commodityCategory : commodityCategoryList) {
            paramList.add(new CommodityCategoryParam().compat(commodityCategory));
        }
        return commodityCategoryListToTree(paramList);
    }

    /**
     * ==================================================  private method ==================================================
     */
    /**
     * <h4>更新</h4>
     * @param before
     * @param after
     */
    @Transactional(rollbackFor = RuntimeException.class)
    protected void updateWithChild(CommodityCategory before, CommodityCategory after) {
        String newLevelPrefix = after.getCocaLevel();
        String oldLevelPrefix = before.getCocaLevel();
        if (!after.getCocaLevel().equals(before.getCocaLevel())) {
            List<CommodityCategory> commodityCategoryList = commodityCategoryMapper.selectChildCommodityCategoryListByLevel(
                    LevelUtil.calculateLevelLong(before.getCocaLevel(),before.getId()));
            if (CheckedUtil.isNotEmptyList(commodityCategoryList)) {
                for (CommodityCategory record : commodityCategoryList) {
                    String level = record.getCocaLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        record.setCocaLevel(level);
                    }
                }
                commodityCategoryMapper.batchUpdateLevel(commodityCategoryList);
            }
        }
        commodityCategoryMapper.updateByPrimaryKey(after);
    }

    /**
     * <h4>判断重名</h4>
     * @param parentId 父编号
     * @param name 名称
     * @param id 编号
     * @return 重名为true
     */
    private boolean exist(Long parentId,String name,Long id) {
        return commodityCategoryMapper.countByNameAndParentId(parentId, name, id) > 0;
    }

    /**
     * <h4>获取层次</h4>
     * @param cocaId 编号
     * @return
     */
    private String getLevel(Long cocaId) {
        CommodityCategory commodityCategory = commodityCategoryMapper.selectByPrimaryKey(cocaId);
        if (null == commodityCategory) {
            return null;
        }
        return commodityCategory.getCocaLevel();
    }

    /**
     * <h4>商品类目转树结构</h4>
     * @param paramList 商品类目集合
     * @return
     */
    private List<CommodityCategoryParam> commodityCategoryListToTree(List<CommodityCategoryParam> paramList) {

        if (!CheckedUtil.isNotEmptyList(paramList)) {
            return new ArrayList<CommodityCategoryParam>();
        }
        //level -> [dept1,dept2,...]  Map<String,List<Object>>
        Multimap<String,CommodityCategoryParam> levelMap = ArrayListMultimap.create();
        List<CommodityCategoryParam> rootList = new ArrayList<>();

        for (CommodityCategoryParam param : paramList) {
            levelMap.put(param.getLevel(), param);
            if (LevelUtil.ROOT.equals(param.getLevel())) {
                rootList.add(param);
            }
        }
        //按照seq 从小到大排序
        Collections.sort(rootList, seqComparator);

        //递归 生成树
        transformTree(paramList, LevelUtil.ROOT, levelMap);
        return rootList;
    }

    /**
     * <h4>递归转换生成部门树</h4>
     * @param levelList 部门传递实体类
     * @param level  层级
     * @param levelMap 每层部门下一级的集合
     */
    private void transformTree(List<CommodityCategoryParam> levelList, String level,
                               Multimap<String, CommodityCategoryParam> levelMap) {
        for (int i = 0; i < levelList.size(); i++) {
            //遍历该层的每个元素
            CommodityCategoryParam param = levelList.get(i);
            //处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevelLong(level, param.getId());
            //处理下一层
            List<CommodityCategoryParam> tempList = (List<CommodityCategoryParam>) levelMap.get(nextLevel);

            if (CollectionUtils.isNotEmpty(tempList)) {
                //排序
                Collections.sort(tempList,seqComparator);
                //设置下一层部门
                param.setCommodityCategoryList(tempList);
                //进入到下一层处理
                transformTree(tempList,nextLevel,levelMap);
            }
        }
    }

    /**
     * <h4>部门排序的比较器</h4>
     */
    private Comparator<CommodityCategoryParam> seqComparator = new Comparator<CommodityCategoryParam>(){
        @Override
        public int compare(CommodityCategoryParam param1, CommodityCategoryParam param2) {
            return param1.getSeq() - param2.getSeq();
        }
    };

}
