package cn.peyton.spring.permission.service.adapter;

import cn.peyton.spring.permission.entity.SysCategory;
import cn.peyton.spring.permission.param.CategoryParam;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.Lists;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * <h3>栏目 适配器</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.permission.service.adapter.CategoryAdapter.java
 * @create date: 2018/11/18 16:27
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Component
public class CategoryAdapter {

    /**
     * <h4>栏目转换</h4>
     * @param infos 栏目集合对象
     * @return 显示栏目集合
     */
    public static LinkedList<CategoryParam> convert(List<CategoryParam> infos) {
        LinkedList categories = Lists.newLinkedList();
        if (CheckedUtil.isNotEmptyList(infos)) {
            for (CategoryParam info : infos) {
                if (info.getParentId() == 0) {
                    info.setChildren(recursion(info.getId(), infos));
                    categories.add(info);
                }
            }
        }
        return categories;
    }

    /**
     * <h4>查子栏目类</h4>
     * @param parentId
     * @param infos
     * @return
     */
    private static LinkedList<CategoryParam> recursion(Integer parentId,List<CategoryParam> infos) {
        LinkedList children = Lists.newLinkedList();
        for (CategoryParam info : infos) {
            if (info.getParentId().equals(parentId)) {
                children.add(info);
            }
        }
        return children;
    }
}
