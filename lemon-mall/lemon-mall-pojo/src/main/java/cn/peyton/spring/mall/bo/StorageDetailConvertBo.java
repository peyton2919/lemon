package cn.peyton.spring.mall.bo;

import cn.peyton.spring.def.BaseConvertBo;
import cn.peyton.spring.mall.entity.StorageDetail;
import cn.peyton.spring.mall.param.StorageDetailParam;

/**
 * <h3>出入库明细 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.StorageDetailConvertBo.java
 * @createDate: 2018/10/14 15:54
 * @version: 1.0.0
 * </pre>
 */
public class StorageDetailConvertBo extends BaseConvertBo<StorageDetailParam,StorageDetail> {

    @Override
    public StorageDetailParam compat(StorageDetail info) {
        return new StorageDetailParam().compat(info);
    }
}
