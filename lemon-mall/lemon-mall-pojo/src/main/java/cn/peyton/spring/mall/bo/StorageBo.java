package cn.peyton.spring.mall.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.mall.entity.Storage;
import cn.peyton.spring.mall.param.StorageParam;

/**
 * <h3>出入库 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.StorageBo.java
 * @createDate: 2018/10/14 11:57
 * @version: 1.0.0
 * </pre>
 */
public class StorageBo extends BaseBo<StorageParam, Storage> {

    @Override
    public StorageParam compat(Storage info) {
        return new StorageParam().compat(info);
    }
}
