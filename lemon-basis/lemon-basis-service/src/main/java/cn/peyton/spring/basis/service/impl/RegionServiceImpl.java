package cn.peyton.spring.basis.service.impl;

import cn.peyton.spring.basis.bo.RegionBo;
import cn.peyton.spring.basis.dao.RegionMapper;
import cn.peyton.spring.basis.entity.Region;
import cn.peyton.spring.basis.param.RegionParam;
import cn.peyton.spring.basis.service.RegionService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.LevelUtil;
import cn.peyton.spring.validator.Validation;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <h3>地区 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
@Service("regionService")
public class RegionServiceImpl implements RegionService {
	@Resource
	private RegionMapper regionMapper;

    /**
     * <h4>保存</h4>
     * @param param
     */
    @Override
    public void save(RegionParam param) {
        Validation.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一级下存在相同名称的地区名");
        }

        Region region = param.convert();
        region.setRegiLevel(LevelUtil.calculateLevelLong(getLevel(param.getParentId()),param.getParentId()));

        regionMapper.insertSelective(region);

        //日志操作
    }

    /**
     * <h4>更新</h4>
     * @param param
     */
    @Override
    public void update(RegionParam param) {
        Validation.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一级下存在相同名称的地区名");
        }
        Region before = regionMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新地区不存在");

        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一级下存在相同名称的地区名");
        }
        Region after = param.convert();
        after.setRegiLevel(LevelUtil.calculateLevelLong(getLevel(param.getParentId()),param.getParentId()));

        updateWithChild(before,after);
        //日志操作
    }

    @Override
    public void delete(Long orgiId) {
        Region info = regionMapper.selectByPrimaryKey(orgiId);
        CheckedUtil.checkNoNull(info,"待删除地区不存在,无法删除");
        if (regionMapper.countByParentId(orgiId) > 0) {
            throw new ParamException("当前地区下面有子地区,无法删除");
        }
      //todo 删除判断
        regionMapper.deleteByPrimaryKey(orgiId);
    }

    @Override
    public RegionParam findById(Long id) {
        return new RegionParam().compat(regionMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<RegionParam> findLikeByKeyword(String keyword, PageQuery page) {
        PageResult<RegionParam> result = new PageResult<>();
        int count = regionMapper.countLikeByKeyword(keyword);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new RegionBo().adapter(regionMapper.selectLikeByKeyword(keyword,page)));
        }
        return result;
    }

    @Override
    public PageResult<RegionParam> findByAll(PageQuery page) {
        PageResult<RegionParam> result = new PageResult<>();
        int count = regionMapper.count();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new RegionBo().adapter(regionMapper.selectByAll(page)));
        }
        return result;
    }

    @Override
    public List<RegionParam> findBySelect() {
        return new RegionBo().adapter(regionMapper.selectBySelect());
    }

    @Override
    public List<RegionParam> tree() {
        List<RegionParam> regionParamList = new RegionBo().adapter(regionMapper.selectByTree());
        return regionListToTree(regionParamList);
    }

    @Override
    public List<RegionParam> findByParentId(Long parentId) {
        return new RegionBo().adapter(regionMapper.selectByParentId(parentId));
    }

    // ======================================= Private Method ======================================= //
    /**
     * <h4>更新</h4>
     * @param before
     * @param after
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateWithChild(Region before, Region after) {
        String newLevelPrefix = after.getRegiLevel();
        String oldLevelPrefix = before.getRegiLevel();
        if (!after.getRegiLevel().equals(before.getRegiLevel())) {

            List<Region> regionList = regionMapper.getChildRegionListByLevel(
                    LevelUtil.calculateLevelLong(before.getRegiLevel(),before.getId()));
            if (CollectionUtils.isNotEmpty(regionList)) {
                for (Region info : regionList) {
                    String level = info.getRegiLevel();
                    if (level.indexOf(oldLevelPrefix) == 0){
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        info.setRegiLevel(level);
                    }
                }
                regionMapper.batchUpdateLevel(regionList);
            }
        }
        regionMapper.updateByPrimaryKey(after);
    }

    /**
     * <h4>判断同级地区名称是否重名</h4>
     * @param parentId
     * @param deptName
     * @param regiId
     * @return
     */
    private boolean checkExist(Long parentId, String deptName, Long regiId) {
        //
        return regionMapper.countByNameAndParentId(parentId,deptName,regiId) > 0;
    }

    /**
     * <h4></h4>
     * @param regiId
     * @return
     */
    private String getLevel(Long regiId) {
        Region region = regionMapper.selectByPrimaryKey(regiId);
        if (null == region){
            return null;
        }
        return region.getRegiLevel();
    }

    // =========================================================================================//

    /**
     * <h4>地区集合 转成树结构</h4>
     * @param regionParamList 地区集合
     * @return
     */
    private List<RegionParam> regionListToTree(List<RegionParam> regionParamList) {
        if (!CheckedUtil.isNotEmptyList(regionParamList)) {
            return new ArrayList<RegionParam>();
        }
        //level -> [regionParam1,regionParam2,...]  Map<String,List<Object>>
        Multimap<String,RegionParam> levelMap = ArrayListMultimap.create();
        List<RegionParam> rootList = new ArrayList<>();

        for (RegionParam param : regionParamList) {
            levelMap.put(param.getLevel(), param);
            if (LevelUtil.ROOT.equals(param.getLevel())) {
                rootList.add(param);
            }
        }
        //按照seq 从小到大排序
        Collections.sort(rootList, seqComparator);

        //递归 生成树
        transformTree(regionParamList, LevelUtil.ROOT, levelMap);
        return rootList;
    }

    /**
     * <h4>递归转换生成地区树</h4>
     * @param levelList 地区传递实体类
     * @param level  层级
     * @param levelMap 每层地区下一级的集合
     */
    private void transformTree(List<RegionParam> levelList, String level,
                               Multimap<String, RegionParam> levelMap) {
        for (int i = 0; i < levelList.size(); i++) {
            //遍历该层的每个元素
            RegionParam param = levelList.get(i);
            //处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevelLong(level, param.getId());
            //处理下一层
            List<RegionParam> tempList = (List<RegionParam>) levelMap.get(nextLevel);

            if (CollectionUtils.isNotEmpty(tempList)) {
                //排序
                Collections.sort(tempList,seqComparator);
                //设置下一层部门
                param.setRegionList(tempList);
                //进入到下一层处理
                transformTree(tempList,nextLevel,levelMap);
            }
        }
    }

    /**
     * <h4>地区排序的比较器</h4>
     */
    private Comparator<RegionParam> seqComparator = new Comparator<RegionParam>(){
        @Override
        public int compare(RegionParam param1, RegionParam param2) {
            return param1.getSeq() - param2.getSeq();
        }
    };

}
