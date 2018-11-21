package cn.peyton.spring.usergroup.service.impl;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.beans.ResultAdapter;
import cn.peyton.spring.cipher.Md5Util;
import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.usergroup.bo.CustomerBo;
import cn.peyton.spring.usergroup.dao.CustomerMapper;
import cn.peyton.spring.usergroup.entity.Customer;
import cn.peyton.spring.usergroup.param.CustomerParam;
import cn.peyton.spring.usergroup.service.CustomerService;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.UniqueCodeUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>客户 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {


	@Resource
	private CustomerMapper customerMapper;

    @Override
    public CustomerParam login(String loginName) {
        return new CustomerParam().compat(customerMapper.login(loginName));
    }

    @Override
    public int updateLoc(Long id) {
        return customerMapper.updateLoc(id);
    }

    @Override
    public CustomerParam existPwd(Long id, String pwd) {
        CustomerParam param = new CustomerParam().compat(customerMapper.existPwd(id));
        String encryptPwd = Md5Util.encrypt(pwd, param.getEncrypt());
        if (encryptPwd.equals(param.getPwd())) {
            return param;
        }
        return null;
    }

    @Override
    public void updatePwd(Long id, String pwd) {
        if (null != existPwd(id, pwd)) {
            customerMapper.updatePwd(id, pwd);
        } else {
            throw new ValidationException("更新密码出错了");
        }
    }

    @Override
    public void updateAvatar(Long id, String avatar) {
        customerMapper.updateAvatar(id, avatar);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        customerMapper.updateStatus(id, status);
    }

    @Override
    public void save(CustomerParam param) {
        Validation.check(param);
        if (!param.getPwd().equals(param.getConfirmPwd())) {
            throw new ValidationException("确认密码与密码不一致");
        }
        if (DefaultExistRename.exist(customerMapper, param.getId(), param.getLoginName())) {
            throw new ValidationException("已存在相同的登录名");
        }
        Customer info = param.convert();
        //设置加密串
        info.setCusEncrypt(UniqueCodeUtil.createRandomName());
        info.setCusLastIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));

        //密码转换
        String encryptedPassword = Md5Util.encrypt(param.getPwd(), info.getCusEncrypt());
        info.setCusPwd(encryptedPassword);
        info.setCusCreated(new Date());
        info.setCusUpdated(new Date());
        customerMapper.insertSelective(info);

    }

    @Override
    public void update(CustomerParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(customerMapper, param.getId(), param.getLoginName())) {
            throw new ValidationException("已存在相同的登录名");
        }
        Customer before = customerMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before, "待更新的客户不存在");
        Customer after = param.convert();
        after.setCusLastIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setCusUpdated(new Date());
        customerMapper.updateByPrimaryKey(after);

    }

    @Override
    public void delete(Long id) {
        customerMapper.updateStatus(id, Status.DELETE.getCode());
    }

    @Override
    public CustomerParam findById(Long id) {
        return new CustomerParam().compat(customerMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<CustomerParam> findByAll(PageQuery page) {
        return ResultAdapter.adapt(customerMapper,page,new CustomerBo());
    }

    @Override
    public PageResult<CustomerParam> findLikeByKeyword(String keyword, PageQuery page) {
        return ResultAdapter.adapt(customerMapper,keyword,page,new CustomerBo());
    }

}
