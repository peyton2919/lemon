package cn.peyton.spring.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h3></h3>
 * <p>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * Email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.util.Lists.java
 * Create: 2018-08-19 21:14
 * Version: 1.0.0
 * </pre>
 */
/**
 * <h3>List 工具集</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:58
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class Lists implements Serializable {

    /**
     * <h4>判断list集合是否为空或者list集合大小为0</h4>
     * @param list 集合
     * @param <E>
     * @return 为true时,list集合为空或大小为0
     */
    public static <E> boolean isEmpty(List<E> list){
        if (null == list || list.size() < 1) {
            return true;
        }
        return false;
    }

    /**
     * <h4>判断list集合是否为空或者list集合大小为0</h4>
     * @param list 集合
     * @param <E>
     * @return 为true时,list集合为空
     */
    public static <E> boolean isNull(List<E> list){
        if (null == list) {
            return true;
        }
        return false;
    }

    /**
     * <h4>创建ArrayList对象</h4>
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    /**
     * <h4>创建ArrayList list 为空时创建</h4>
     * @param list
     */
    public static <E> void createArrayList(List<E> list) {
        if (null == list) {
            list = new ArrayList<E>();
        }
    }


    /**
     * <h4>创建LinkedList对象</h4>
     * @param <E>
     * @return
     */
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<E>();
    }

    /**
     * <h4>创建LinkedList list 为空时创建</h4>
     * @param list
     */
    public static <E> void createLinkedList(List<E> list) {
        if (null == list) {
            list = new LinkedList<E>();
        }
    }


}
