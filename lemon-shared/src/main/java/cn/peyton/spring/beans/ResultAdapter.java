package cn.peyton.spring.beans;

import cn.peyton.spring.def.BaseConvertBo;
import cn.peyton.spring.inf.IMapperAll;
import cn.peyton.spring.inf.IMapperLike;
import cn.peyton.spring.util.CheckedUtil;

import java.util.List;

/**
 * <h3>封装 返回对象适配器 类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.beans.ResultAdapter.java
 * @createDate: 2018/9/15 9:40
 * @version: 1.0.0
 * </pre>
 */
public final class ResultAdapter {

    public ResultAdapter() { }

    /**
     * <h4>查找 全部 对象集合的适配器</h4>
     * @param mapper 查找 全部对象Mapper接口
     * @param page 分页对象
     * @param baseConvertBo 实现基础BO对象
     * @param <T> 需要操作对象
     * @return PageResult对象
     */
    public static <T> PageResult<T> adapt(IMapperAll mapper, PageQuery page, BaseConvertBo baseConvertBo) {
        PageResult<T> result = new PageResult<T>();
        int count = mapper.count();
        if (count > 0) {
            result.setTotal(count);
            result.setData(baseConvertBo.adapter(mapper.selectByAll(page)));
        }
        return result;
    }

    /**
     * <h4>模糊查找全部对象集合的适配器</h4>
     * @param mapper 模糊查找全部对象Mapper接口
     * @param keyword 关键字
     * @param page 分页对象
     * @param baseConvertBo  实现基础BO对象
     * @param <T> 需要操作对象
     * @return PageResult对象
     */
    public static <T> PageResult<T> adapt(IMapperLike mapper, String keyword, PageQuery page, BaseConvertBo baseConvertBo) {
        PageResult<T> result = new PageResult<T>();
        int count = mapper.countLikeByKeyword(keyword);
        if (count > 0) {
            result.setTotal(count);
            result.setData(baseConvertBo.adapter(mapper.selectLikeByKeyword(keyword,page)));
        }
        return result;
    }

    /**
     * <h4>封装数据</h4>
     * @param data 对象集合
     * @param count 条数
     * @param <T> 需要操作对象
     * @return
     */
    public static <T> PageResult<T> adapt(List<T> data, Integer count) {
        PageResult<T> result = new PageResult<T>();
        if (CheckedUtil.isNotEmptyList(data)) {
            result.setData(data);
            result.setTotal(count);
        }
        return result;
    }


    /**
     * <h4>返回一个空的PageResult</h4>
     * @param <T> 需要操作对象
     * @return
     */
    public static <T>PageResult<T> empty() {
        return new PageResult<T>();
    }


}
