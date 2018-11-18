package cn.peyton.spring.usergroup.service.impl;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.log.service.SysLogService;
import cn.peyton.spring.usergroup.dao.SysEmployeeMapper;
import cn.peyton.spring.usergroup.dto.DeptLevelDto;
import cn.peyton.spring.usergroup.entity.SysDept;
import cn.peyton.spring.usergroup.param.DeptParam;
import cn.peyton.spring.usergroup.service.SysEmployeeService;
import cn.peyton.spring.usergroup.service.log.DeptLog;
import cn.peyton.spring.usergroup.service.SysDeptService;
import cn.peyton.spring.usergroup.dao.SysDeptMapper;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.LevelUtil;
import cn.peyton.spring.validator.Validation;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * <h3>部门 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 09:15:49
 * @version 1.0.0
 * </pre>
*/
@Service("sysDeptService")
public class SysDeptServiceImpl implements SysDeptService {
	@Resource
	private SysDeptMapper sysDeptMapper;
    @Resource
    private SysLogService sysLogService;
    @Resource
    private SysEmployeeMapper sysEmployeeMapper;

    /**
     * <h4>保存</h4>
     * @param param
     */
    @Override
    public void save(DeptParam param) {
        Validation.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一级下存在相同名称的部门");
        }
        SysDept dept = param.convert();
        dept.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()));
        //当前 进程中获取
        dept.setOperator(RequestHolder.getCurrentUser().getUserName());
        dept.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        dept.setOperateTime(new Date());
        sysDeptMapper.insertSelective(dept);
        //日志操作
        sysLogService.save(null,dept,new DeptLog());
    }

    /**
     * <h4>更新</h4>
     * @param param
     */
    @Override
    public void update(DeptParam param) {
        Validation.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一级下存在相同名称的部门");
        }
        SysDept before = sysDeptMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新部门不存在");

        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一级下存在相同名称的部门");
        }
        SysDept after = param.convert();
        after.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()));
        after.setOperator(RequestHolder.getCurrentUser().getUserName());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        updateWithChild(before,after);
        //日志操作
        sysLogService.save(before,after,new DeptLog());
    }

    @Override
    public void delete(int deptId) {
        SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
        Preconditions.checkNotNull(dept, "待删除部门不存在，无法删除");
        if (sysDeptMapper.countByParentId(dept.getId()) > 0) {
            throw new ParamException("当前部门下面有子部门,无法删除");
        }
        //todo
//        if (sysUserMapper.countByDeptId(dept.getId()) > 0) {
////            throw new ParamException("当前部门下面有用户,无法删除");
////        }
        if (sysEmployeeMapper.countByDeptId(dept.getId()) > 0) {
            throw new ValidationException("当前部门下面有用户,无法删除");
        }
        sysDeptMapper.deleteByPrimaryKey(deptId);
    }

    /**
     * <h4>部门树</h4>
     * @return
     */
    @Override
    public List<DeptLevelDto> deptTree() {
        List<SysDept> deptList = sysDeptMapper.selectByAll();
        List<DeptLevelDto> dtoList = new ArrayList<>();
        for (SysDept dept : deptList) {
            DeptLevelDto dto = DeptLevelDto.adapt(dept);
            dtoList.add(dto);
        }
        return deptListToTree(dtoList);
    }

    // ======================================= Private Method ======================================= //
    /**
     * <h4>更新</h4>
     * @param before
     * @param after
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateWithChild(SysDept before, SysDept after) {
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if (!after.getLevel().equals(before.getLevel())) {
            List<SysDept> deptList = sysDeptMapper.selectChildDeptListByLevel(LevelUtil.calculateLevel(before.getLevel(),before.getId()));
            if (CollectionUtils.isNotEmpty(deptList)) {
                for (SysDept dept : deptList) {
                    String level = dept.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dept.setLevel(level);
                    }
                }
                sysDeptMapper.batchUpdateLevel(deptList);
            }
        }
        sysDeptMapper.updateByPrimaryKey(after);
    }

    /**
     * <h4>判断同级部门名称是否重名</h4>
     * @param parentId
     * @param deptName
     * @param deptId
     * @return
     */
    private boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        //
        return sysDeptMapper.countByNameAndParentId(parentId,deptName,deptId) > 0;
    }

    /**
     * <h4></h4>
     * @param deptId
     * @return
     */
    private String getLevel(Integer deptId) {
        SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
        if (dept == null) {
            return  null;
        }
        return dept.getLevel();
    }

    //  ===========================  \\\\\\\\\\\\<dept 树 开始>\\\\\\\\\\  ===========================

    /**
     * <h4>部门集合 转成 树结构</h4>
     * @param deptLevelList 部门传递实体类
     * @return
     */
    private List<DeptLevelDto> deptListToTree(List<DeptLevelDto> deptLevelList) {
        if (CollectionUtils.isEmpty(deptLevelList)) {
            return new ArrayList<DeptLevelDto>();
        }
        //level -> [dept1,dept2,...]  Map<String,List<Object>>
        Multimap<String,DeptLevelDto> levelDeptMap = ArrayListMultimap.create();
        List<DeptLevelDto> rootList = new ArrayList<>();

        for (DeptLevelDto dto : deptLevelList) {
            levelDeptMap.put(dto.getLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        }
        //按照seq 从小到大排序
        Collections.sort(rootList, deptSeqComparator);

        //递归 生成树
        transformDeptTree(deptLevelList, LevelUtil.ROOT, levelDeptMap);
        return rootList;
    }

    /**
     * <h4>递归转换生成部门树</h4>
     * @param deptLevelList 部门传递实体类
     * @param level  层级
     * @param levelDeptMap 每层部门下一级的集合
     */
    private void transformDeptTree(List<DeptLevelDto> deptLevelList, String level,
                                   Multimap<String, DeptLevelDto> levelDeptMap) {
        for (int i =0; i < deptLevelList.size();i++) {
            //遍历该层的每个元素
            DeptLevelDto deptLevelDto = deptLevelList.get(i);
            //处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevel(level, deptLevelDto.getId());
            //处理下一层
            List<DeptLevelDto> tempDeptList = (List<DeptLevelDto>) levelDeptMap.get(nextLevel);

            if (CollectionUtils.isNotEmpty(tempDeptList)) {
                //排序
                Collections.sort(tempDeptList,deptSeqComparator);
                //设置下一层部门
                deptLevelDto.setDeptList(tempDeptList);
                //进入到下一层处理
                transformDeptTree(tempDeptList,nextLevel,levelDeptMap);
            }
        }
    }

    /**
     * <h4>部门排序的比较器</h4>
     */
    private Comparator<DeptLevelDto> deptSeqComparator = new Comparator<DeptLevelDto>(){
        @Override
        public int compare(DeptLevelDto dto1, DeptLevelDto dto2) {
            return dto1.getSeq() - dto2.getSeq();
        }
    };
    //  ===========================  \\\\\\\\\\\\<dept 树 结束>\\\\\\\\\\  ===========================


}
