package cn.peyton.spring.usergroup.service.impl;

import cn.peyton.spring.def.DefaultExistRename;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.log.service.SysLogService;
import cn.peyton.spring.usergroup.bo.PostConvertBo;
import cn.peyton.spring.usergroup.dao.SysEmployeeMapper;
import cn.peyton.spring.usergroup.dao.SysPostMapper;
import cn.peyton.spring.usergroup.entity.SysPost;
import cn.peyton.spring.usergroup.param.PostParam;
import cn.peyton.spring.usergroup.service.SysPostService;
import cn.peyton.spring.usergroup.service.log.PostLog;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>职务 Service 实现类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 16:19
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Service("sysPostService")
public class SysPostServiceImpl implements SysPostService {

	@Resource
	private SysPostMapper sysPostMapper;
	@Resource
    private SysEmployeeMapper sysEmployeeMapper;
	@Resource
    private SysLogService sysLogService;
	@Resource
    private PostLog sysPostLog;


    @Override
    public void save(PostParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(sysPostMapper, param.getId(), param.getName())) {
            throw new ValidationException("存在相同名称的职务");
        }
        SysPost sysPost = param.convert();
        sysPostMapper.insertSelective(sysPost);
        //保存日志
        sysLogService.save(null,sysPost,sysPostLog);
    }

    @Override
    public void update(PostParam param) {
        Validation.check(param);
        if (DefaultExistRename.exist(sysPostMapper, param.getId(), param.getName())) {
            throw new ValidationException("存在相同名称的职务");
        }

        SysPost before = sysPostMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before, "待更新职务不存在");
        SysPost after = param.convert();
        sysPostMapper.updateByPrimaryKey(after);

        //日志
        sysLogService.save(before,after,sysPostLog);
    }

    @Override
    public void delete(Integer id) {
        if (sysEmployeeMapper.countByPostId(id) > 0) {
            throw new ValidationException("当前职务下面有用户,无法删除");
        }

        int result = sysPostMapper.deleteByPrimaryKey(id);
        if (result < 1){
            throw new ValidationException("删除职务不存在");
        }
    }

    @Override
    public PageResult<PostParam> findByAll() {
        List<PostParam> postList = new PostConvertBo().adapter(sysPostMapper.selectByAll());
        if (null != postList && postList.size() >0){
            return new PageResult<PostParam>(postList,postList.size());
        }
        return new PageResult<PostParam>();
    }

}
