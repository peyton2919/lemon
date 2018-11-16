package cn.peyton.spring.util;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h3>字符串 工具类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:02
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class StringUtil {

    private final static String CONNECTOR = ",";

    /**
     * <h4>字符串 转换成 Integer 集合</h4>
     *
     * @param str
     * @return
     */
    public static List<Integer> splitToListInt(String str) {
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        List<Integer> list = strList.stream().map(strItem -> Integer.parseInt(strItem)).collect(Collectors.toList());
        return list;
    }

    /**
     * <h4>字符串 转换成 Integer 集合</h4>
     *
     * @param str
     * @return
     */
    public static List<Long> splitToListLong(String str) {
        VerifyCodeUtil v;
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        List<Long> list = strList.stream().map(strItem -> Long.parseLong(strItem)).collect(Collectors.toList());
        return list;
    }

    /**
     * <h4>Ip 为0:0:0:0:0:0:0:1 转成 127.0.0.1</h4>
     *
     * @param ip
     * @return
     */
    public static String convertIp(String ip) {
        if (ip != null && !"".equals(ip.trim())) {
            if ("0:0:0:0:0:0:0:1".equals(ip.trim())) {
                return "127.0.0.1";
            }
        }
        return ip;
    }

    /**
     * <h4>字符串 转换成 String 集合</h4>
     * @param str  字符串
     * @return
     */
    public static List<String> splitToListString(String str) {
        if (null == str) {
            return null;
        }
        return Splitter.on(CONNECTOR).trimResults().omitEmptyStrings().splitToList(str);
    }

    /**
     * <h4>字符串 转换成 String 集合[图片集合]</h4>
     * @param str 字符串
     * @return
     */
    public static List<String> splitImagesStr2List(String str) {
        if (null == str) {
            return null;
        }
        String[] splits = str.split(",");

        int length = splits.length;
        if (length <= 2){return  null;}
        String prefix = splits[0];
        length = length - 1;
        String suffix = splits[length];
        List<String> results = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            String temp = prefix + splits[i] + suffix;
            results.add(temp);
        }
        return results;
    }

    /**
     * <h4>获取图片集合 最大数值</h4>
     * @param str
     * @return
     */
    public static Integer getImagesMaxValue(String str) {
        if (null == str) {
            return null;
        }
        String[] splits = str.split(",");
        int length = splits.length;
        if (length <= 2){return  0;}
        return Integer.parseInt(splits[length - 2]);
    }

    /**
     * <h4>字符串集合 转成字符串</h4>
     * @param lists 字符串集合
     * @return
     */
    public static String convertList2Str(List<String> lists) {
        int size = lists.size();
        if (null != lists && size > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(lists.get(i));
                if (i != size - 1) {
                    sb.append(CONNECTOR);
                }
            }
            return sb.toString();
        }
        return null;
    }
}
