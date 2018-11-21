package cn.peyton.spring.usergroup.service.impl;

import cn.peyton.spring.cipher.Md5Util;
import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.beans.ResultAdapter;
import cn.peyton.spring.usergroup.bo.SupplierBo;
import cn.peyton.spring.usergroup.dao.SupplierMapper;
import cn.peyton.spring.usergroup.entity.Supplier;
import cn.peyton.spring.usergroup.param.SupplierParam;
import cn.peyton.spring.usergroup.service.SupplierService;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.UniqueCodeUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <h3>供应商 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/17 10:58:54
 * @version 1.0.0
 * </pre>
*/
@Service("supplierInfoService")
public class SupplierServiceImpl implements SupplierService {
	@Resource
	private SupplierMapper supplierMapper;

    @Override
    public SupplierParam login(String loginName) {
        return new SupplierParam().compat(supplierMapper.login(loginName));
    }

    @Override
    public int updateLoc(Long id) {
        return supplierMapper.updateLoc(id);
    }

    @Override
    public SupplierParam existPwd(Long id, String pwd) {
        SupplierParam param = new SupplierParam().compat(supplierMapper.existPwd(id));
        String encryptPwd = Md5Util.encrypt(pwd, param.getEncrypt());
        if (encryptPwd.equals(param.getPwd())) {
            return param;
        }
        return null;
    }

    @Override
    public void updatePwd(Long id, String pwd) {
        if (null != existPwd(id, pwd)) {
            supplierMapper.updatePwd(id, pwd);
        } else {
            throw new ParamException("更新密码出错了");
        }
    }

    @Override
    public void updateWeb(Long id, String webSite, String webCode) {
        supplierMapper.updateWeb(id, webSite, webCode);
    }

    @Override
    public SupplierParam findByWeb(Long id) {
        return new SupplierParam().compat(supplierMapper.selectByWeb(id));
    }

    @Override
    public void updateAvatar(Long id, String avatar) {
        supplierMapper.updateAvatar(id, avatar);
    }

    @Override
    public void save(SupplierParam param) {
        Validation.check(param);
        if (param.getPwd().length() < 6) {
            throw new ValidationException("密码长度最小6位");
        }
        if (!param.getPwd().equals(param.getConfirmPwd())) {
            throw new ValidationException("确认密码与密码不一致");
        }
        if (DefaultExistRename.exist(supplierMapper, param.getId(), param.getLoginName())) {
            throw new ValidationException("已存在相同的供应商登录名");
        }
        Supplier info = param.convert();
        //设置加密串
        info.setSupEncrypt(UniqueCodeUtil.createRandomName());
        info.setSupLastIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));

        //密码转换
        String encryptedPassword = Md5Util.encrypt(param.getPwd(),info.getSupEncrypt());
        info.setSupPwd(encryptedPassword);
        info.setSupCreated(new Date());
        info.setSupUpdated(new Date());
        supplierMapper.insertSelective(info);
    }

    @Override
    public void update(SupplierParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(supplierMapper, param.getId(), param.getLoginName())) {
            throw new ParamException("已存在相同的供应商登录名");
        }
        Supplier before = supplierMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before,"待更新的供应商不存在");
        Supplier after = param.convert();
        after.setSupLastIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setSupUpdated(new Date());
        supplierMapper.updateByPrimaryKey(after);

    }

    @Override
    public void delete(Long id) {
        supplierMapper.updateStatus(id, Status.DELETE.getCode());
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        supplierMapper.updateStatus(id, status);
    }

    @Override
    public SupplierParam findById(Long id) {
        return new SupplierParam().compat(supplierMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<SupplierParam> findByAll(PageQuery page) {
        return ResultAdapter.adapt(
                supplierMapper,page,new SupplierBo()
        );
    }

    @Override
    public PageResult<SupplierParam> findLikeByKeyword(String keyword, PageQuery page) {
        return ResultAdapter.adapt(
                supplierMapper,keyword,page,new SupplierBo()
        );
    }

    @Override
    public List<SupplierParam> findBySelect() {
        return new SupplierBo().adapter(supplierMapper.selectBySelect());
    }

    @Override
    public boolean countByName(Long id, String name) {
        return supplierMapper.countByName(id,name) > 0;
    }
}
