package cn.peyton.spring.mall.service.util;

import cn.peyton.spring.basis.param.ColorParam;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.mall.dto.StoragePageDto;
import cn.peyton.spring.mall.entity.StorageDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>出入库 工具类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.common.StorageUtil.java
 * @createDate: 2018/10/14 15:00
 * @version: 1.0.0
 * </pre>
 */
public final class StorageUtil {

    /**
     * <h4>出入库明细集合 转成字符串</h4>
     * @param storageDetails 出入库明细集合
     * @return 字符串
     */
    public static String convertList2Str(List<StorageDetail> storageDetails) {

        if (null != storageDetails && storageDetails.size() > 0) {
            StringBuilder sb = new StringBuilder();
            int size = storageDetails.size();
            for (int i = 0; i < size; i++) {
                StorageDetail param = storageDetails.get(i);
                sb.append(param.getColId());
                sb.append(":");
                sb.append(param.getStdeQuantity());
                sb.append(",");
            }
            return sb.substring(0, sb.length() - 1).toString();
        }
        return null;
    }

    /**
     * <h4>List集合 转成 Map 集合</h4>
     * @param storageDetails 出入库明细集合
     * @return map集合
     */
    public static Map<Integer,Integer> convertList2Map(List<StorageDetail> storageDetails) {
        Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        if (null != storageDetails && storageDetails.size() > 0) {
            int size = storageDetails.size();
            for (int i = 0; i < size; i++) {
                StorageDetail param = storageDetails.get(i);
                map.put(param.getColId(), param.getStdeQuantity());
            }
        }
        return map;
    }

    /**
     * <h4>List集合 转成 Map 集合</h4>
     * @param colorParams 颜色对象集合
     * @return key为颜色编号, value为颜色名称 的Map 集合
     */
    public static Map<Integer, String> conventList2Map(List<ColorParam> colorParams) {
        Map<Integer, String> map = new ConcurrentHashMap<Integer, String>();
        if (null != colorParams && colorParams.size() > 0) {
            int size = colorParams.size();
            for (int i = 0; i < size; i++) {
                ColorParam colorParam = colorParams.get(i);
                map.put(colorParam.getId(), colorParam.getName());
            }
        }
        return map;
    }

    /**
     * <h4>Map集合 转成 字符串</h4>
     * @param map Map集合
     * @return 字符串
     */
    public static String conventMap2Str(Map<Integer, Integer> map) {
        if (null != map) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                sb.append(",");
            }
            return sb.substring(0, sb.length() - 1).toString();
        }
        return null;
    }

    /**
     * <h4>字符串 转成 集合</h4>
     * @param detail 字符串
     * @return 集合
     */
    public static Map<Integer, Integer> conventStr2Map(String detail) {
        Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        if (null != detail && !"".equals(detail)){
            String[] firstSplits = detail.split(",");
            int length = firstSplits.length;
            for (int i = 0; i < length; i++) {
                String[] secondSplits = firstSplits[i].split(":");
                map.put(Integer.valueOf(secondSplits[0]), Integer.valueOf(secondSplits[1]));
            }
        }
        return map;
    }

    /**
     * <h4>字符串 转成 StoragePageDto对象集合</h4>
     * @param detail Inventory中detail字符串
     * @param colorMap 颜色对象Map 保存格式key:Id;value:name
     * @return StoragePageDto对象集合
     */
    public static List<StoragePageDto> conventStr2List(String detail, Map<Integer, String> colorMap) {
        List<StoragePageDto> storagePageDtos = new ArrayList<>();
        if (null != detail && !"".equals(detail) && null != colorMap) {
            String[] firstSplits = detail.split(",");
            int length = firstSplits.length;
            StoragePageDto dto = null;
            for (int i = 0; i < length; i++) {
                String[] secondSplits = firstSplits[i].split(":");
                String colorName = colorMap.get(secondSplits[0]);
                if (null == colorName) {
                    throw new ParamException("出库获取颜色列表时意外异常");
                }
                dto = new StoragePageDto();
                dto.setColId(Integer.parseInt(secondSplits[0]));
                dto.setColName(colorName);
                dto.setQuantity(0);
                dto.setInventoryQuantity(Integer.parseInt(secondSplits[1]));
                storagePageDtos.add(dto);
            }
        }
        return storagePageDtos;
    }
}
