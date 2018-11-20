package cn.peyton.spring.usergroup.service.impl;

import cn.peyton.spring.usergroup.dao.SysAdminMapper;
import cn.peyton.spring.usergroup.param.AdminParam;
import cn.peyton.spring.usergroup.service.SysAdminService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * <h3>管理员 Service 实现类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 16:11
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Service("sysAdminService")
public class SysAdminServiceImpl implements SysAdminService {
	@Resource
	private SysAdminMapper sysAdminMapper;

    @Override
    public AdminParam findByKeyword(String keyword) {
        return new AdminParam().compat(sysAdminMapper.selectByKeyword(keyword));
    }
}
