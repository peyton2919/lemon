package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.permission.dao.SysAclMapper;
import cn.peyton.spring.permission.dao.SysAclModuleMapper;
import cn.peyton.spring.permission.dto.AclDto;
import cn.peyton.spring.permission.dto.AclModuleLevelDto;
import cn.peyton.spring.permission.entity.SysAcl;
import cn.peyton.spring.permission.entity.SysAclModule;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.permission.service.SysCoreService;
import cn.peyton.spring.permission.service.SysTreeService;
import cn.peyton.spring.util.LevelUtil;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <h3>树结构 Service 实现类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-19 23:06
 * @version: 1.0.0
 * </pre>
 */
@Service("sysTreeService")
public class SysTreeServiceImpl implements SysTreeService{


    @Resource
    private SysAclModuleMapper aclModuleMapper;
    @Resource
    private SysCoreService sysCoreService;
    @Resource
    private SysAclMapper sysAclMapper;


    /**
     * <h4>权限模块树</h4>
     * @return
     */
    @Override
    public List<AclModuleLevelDto> aclModuleTree() {
        List<SysAclModule> aclModuleList = aclModuleMapper.selectAllAclModule();
        List<AclModuleLevelDto> dtoList = new ArrayList<>();
        for (SysAclModule aclModule : aclModuleList) {
            dtoList.add(AclModuleLevelDto.adapt(aclModule));
        }
        return aclModuleListToTree(dtoList);
    }

    /**
     * <h4>权限树</h4>
     * @param roleId 角色ID
     * @return
     */
    @Override
    public List<AclModuleLevelDto> roleTree(Integer roleId) {
        //1. 当前用户已分配的权限点
        List<SysAcl> userAclList = sysCoreService.getCurrentUserAclList();
        //2. 当前角色已分配的权限点
        List<SysAcl> roleAclList = sysCoreService.getRoleAclList(roleId);
        //当前系统所有权限点
        List<AclDto> aclDtoList = new ArrayList<>();

        Set<Integer> userAclIdSet = userAclList.stream().map(sysAcl -> sysAcl.getId()).collect(Collectors.toSet());
        Set<Integer> roleAclIdSet = roleAclList.stream().map(sysAcl ->sysAcl.getId()).collect(Collectors.toSet());

        List<SysAcl> allAclList = sysAclMapper.selectByAll();
        for (SysAcl acl : allAclList) {
            AclDto dto = AclDto.adapt(acl);
            if (userAclIdSet.contains(acl.getId())) {
                dto.setHasAcl(true);
            }
            if (roleAclIdSet.contains(acl.getId())) {
                dto.setChecked(true);
            }
            aclDtoList.add(dto);
        }
        return aclListToTree(aclDtoList);
    }

    @Override
    public List<AclModuleLevelDto> userAclTree(Integer userId) {
        List<SysAcl> userAclList = sysCoreService.getUserAclList(userId);
        List<AclDto> aclDtoList = new ArrayList<>();

        for (SysAcl acl : userAclList) {
            AclDto dto = AclDto.adapt(acl);
            dto.setHasAcl(true);
            dto.setChecked(true);
            aclDtoList.add(dto);
        }
        return aclListToTree(aclDtoList);
    }

    //  ===========================  \\\\\\\\\\\\<用户权限 树 开始>\\\\\\\\\\  ===========================


    //  ===========================  \\\\\\\\\\\\<用户权限 树 结束>\\\\\\\\\\  ===========================

    //  ===========================  \\\\\\\\\\\\<角色 树 开始>\\\\\\\\\\  ===========================

    /**
     * <h4>添加集合 到 树</h4>
     * @param aclDtoList
     * @return
     */
    private List<AclModuleLevelDto> aclListToTree( List<AclDto> aclDtoList) {
        if (CollectionUtils.isEmpty(aclDtoList)) {
            return new ArrayList<AclModuleLevelDto>();
        }
        List<AclModuleLevelDto> aclModuleLevelList = aclModuleTree();

        Multimap<Integer,AclDto> moduleIdAclMap = ArrayListMultimap.create();
        for (AclDto acl : aclDtoList) {
            if (Status.NORMAL.getCode().equals(acl.getStatus())) {
                moduleIdAclMap.put(acl.getAclModuleId(), acl);
            }
        }
        bindAclsWithOrder(aclModuleLevelList,moduleIdAclMap);
        return aclModuleLevelList;
    }

    /**
     * <h4>权限点 绑定到 权限树</h4>
     * @param aclModuleLevelList
     * @param moduleIdAclMap
     */
    private void bindAclsWithOrder(List<AclModuleLevelDto> aclModuleLevelList,
                                   Multimap<Integer,AclDto> moduleIdAclMap) {
        if (CollectionUtils.isEmpty(aclModuleLevelList)) {
            return;
        }
        for (AclModuleLevelDto dto : aclModuleLevelList) {
            List<AclDto> aclDtoList = (List<AclDto>) moduleIdAclMap.get(dto.getId());
            if (CollectionUtils.isNotEmpty(aclDtoList)) {
                Collections.sort(aclDtoList, aclSeqComparator);
                dto.setAclList(aclDtoList);
            }
            //递归 调用
            bindAclsWithOrder(dto.getAclModuleList(),moduleIdAclMap);
        }
    }


    /**
     * <h4>权限模块比较器</h4>
     */
    private Comparator<AclDto> aclSeqComparator = new Comparator<AclDto>() {
        @Override
        public int compare(AclDto acl1, AclDto acl2) {
            return acl1.getSeq() - acl2.getSeq();
        }
    };

    //  ===========================  \\\\\\\\\\\\<角色 树 结束>\\\\\\\\\\  ===========================

    //  ===========================  \\\\\\\\\\\\<aclModule 树 开始>\\\\\\\\\\  ===========================

    /**
     * <h4>权限模块集合 转成 树结构</h4>
     * @param dtoList 权限模块传递实体类
     * @return
     */
    private List<AclModuleLevelDto> aclModuleListToTree(List<AclModuleLevelDto> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return  new ArrayList<AclModuleLevelDto>();
        }

        //level -> [aclModule1,aclModule2,...] Map<String,List<Object>>
        Multimap<String,AclModuleLevelDto> levelAclModuletMap = ArrayListMultimap.create();
        List<AclModuleLevelDto> rootList = new ArrayList<>();

        for (AclModuleLevelDto dto : dtoList) {
            levelAclModuletMap.put(dto.getLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        }
        //排序 rootList
        Collections.sort(rootList, aclModuleSeqComparator);

        transformAclModuleTree(rootList,LevelUtil.ROOT,levelAclModuletMap);
        return rootList;
    }

    /**
     * <h4>递归转换生成权限模块树</h4>
     * @param dtoList AclModuleLevelDto对象
     * @param level 层级
     * @param levelAclModuletMap 每层权限模块下一级的集合
     */
    private void transformAclModuleTree(List<AclModuleLevelDto> dtoList, String level,
                                       Multimap<String, AclModuleLevelDto> levelAclModuletMap) {
        for(int i = 0; i < dtoList.size(); i++) {
            AclModuleLevelDto dto = dtoList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<AclModuleLevelDto> tempList = (List<AclModuleLevelDto>) levelAclModuletMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(tempList)) {
                Collections.sort(tempList, aclModuleSeqComparator);
                dto.setAclModuleList(tempList);
                //递归调用 transformAclModuleTree 方法
                transformAclModuleTree(tempList,nextLevel,levelAclModuletMap);
            }
        }
    }

    /**
     * <h4>权限模块比较器</h4>
     */
    private Comparator<AclModuleLevelDto> aclModuleSeqComparator = new Comparator<AclModuleLevelDto>() {
        @Override
        public int compare(AclModuleLevelDto aclModule1, AclModuleLevelDto aclModule2) {
            return aclModule1.getSeq() - aclModule2.getSeq();
        }
    };
    //  ===========================  \\\\\\\\\\\\<aclModule 树 结束>\\\\\\\\\\  ===========================


}
