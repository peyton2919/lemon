package cn.peyton.spring.usergroup.service.impl;

import cn.peyton.spring.cipher.Md5Util;
import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.log.service.SysLogService;
import cn.peyton.spring.usergroup.bo.EmployeeConvertBo;
import cn.peyton.spring.usergroup.dao.SysEmployeeMapper;
import cn.peyton.spring.usergroup.entity.SysEmployee;
import cn.peyton.spring.usergroup.param.EmployeeParam;
import cn.peyton.spring.usergroup.service.SysEmployeeService;
import cn.peyton.spring.usergroup.service.log.EmployeeLog;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.PasswordUtil;
import cn.peyton.spring.util.UniqueCodeUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <h3>员工 Service 实现类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 16:26
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Service("sysEmployeeService")
public class SysEmployeeServiceImpl implements SysEmployeeService {
	@Resource
	private SysEmployeeMapper sysEmployeeMapper;
	@Resource
    private SysLogService sysLogService;
	@Resource
    private EmployeeLog sysEmployeeLog;

    @Override
    public void save(EmployeeParam param) {
        Validation.check(param);

        if (DefaultExistRename.exist(sysEmployeeMapper, param.getId(), param.getLoginName())) {
            throw new GlobalException("登录名已被占用");
        }
        SysEmployee employee = param.convert();
        //设置加密串
        employee.setEmpEncrypt(UniqueCodeUtil.createRandomName());
        employee.setEmpLastIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        //密码
        String originPwd = PasswordUtil.randomPassword();
        originPwd = "12345678";
        //密码转换
        String encryptedPassword = Md5Util.encrypt(originPwd,employee.getEmpEncrypt());
        employee.setEmpPwd(encryptedPassword);
        sysEmployeeMapper.insertSelective(employee);
        sysLogService.save(null,employee,sysEmployeeLog);

    }

    @Override
    public void update(EmployeeParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(sysEmployeeMapper, param.getId(), param.getLoginName())) {
            throw new GlobalException("登录名已被占用");
        }
        SysEmployee before = sysEmployeeMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(param,"待更新员工不存在!");

        SysEmployee after = param.convert();
        after.setEmpUpdated(new Date());
        after.setEmpLastIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        sysEmployeeMapper.updateByPrimaryKeySelective(after);
        sysLogService.save(before,after,sysEmployeeLog);
    }

    @Override
    public void delete(Long id) {
        //sysEmployeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public EmployeeParam findByKeyword(String keyword) {
        return new EmployeeParam().compat(sysEmployeeMapper.selectByKeyword(keyword));
    }

    @Override
    public int updateStatus(Long id, int status) {
        return sysEmployeeMapper.updateStatus(id,status);
    }

    @Override
    public EmployeeParam findById(Long id) {
        return new EmployeeParam().compat(sysEmployeeMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<EmployeeParam> findByAllAndPage(PageQuery pageQuery) {
        int count = sysEmployeeMapper.count();
        if (count > 0){
            new PageResult<EmployeeParam>(
                    new EmployeeConvertBo().adapter(sysEmployeeMapper.selectByAllAndPage(pageQuery)),
                    count);
        }
        return new PageResult<EmployeeParam>();
    }

    @Override
    public List<EmployeeParam> findByAll() {
        return new EmployeeConvertBo().adapter(sysEmployeeMapper.selectByAll());
    }

    @Override
    public PageResult<EmployeeParam> findByDeptId(Integer deptId, PageQuery pageQuery) {
        Validation.check(pageQuery);
        int count = sysEmployeeMapper.countByDeptId(deptId);
        if (count > 0) {
            return new PageResult<EmployeeParam>(
                    new EmployeeConvertBo().adapter(sysEmployeeMapper.selectByDeptId(deptId,pageQuery)),
                    count);
        }
        return new PageResult<EmployeeParam>();
    }

    @Override
    public EmployeeParam directLogin(String loginName, String encryptPwd) {
        return new EmployeeParam().compat(sysEmployeeMapper.directLogin(loginName,encryptPwd));
    }
}
