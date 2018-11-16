package cn.peyton.spring.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * <h3>BigDecimal 工具类 . </h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.util.DecimalUtil.java
 * @createDate: 2018/10/11 11:09
 * @version: 1.0.0
 * </pre>
 */
public final class DecimalUtil {

    /**
     * <h4>数值转成字符串</h4>
     * @param decimal 数值 默认样式 : 0.00
     * @return
     */
    public static String format(BigDecimal decimal) {
        return format(decimal,null);
    }

    /**
     * <h4>数值转成字符串</h4>
     * @param decimal 数值
     * @param style 样式
     * @return
     */
    public static String format(BigDecimal decimal,String style) {
        if (null == decimal || "".equals(decimal)) {
            return null;
        }
        if (null == style || "".equals(style)) {
            style = Holder.style_0;
        }
        DecimalFormat df = new DecimalFormat();
        df.applyPattern(style);
        return df.format(decimal);
    }

    /**
     * <h4>货币格式化</h4>
     * @param decimal 数值
     * @return
     */
    public static String currency(BigDecimal decimal) {
        if (null == decimal || "".equals(decimal)) {
            return null;
        }
        //建立货币格式化引用
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(decimal);
    }

    /**
     * <h4>百分比格式化</h4>
     * @param decimal 数值
     * @return
     */
    public static String percent(BigDecimal decimal) {
        if (null == decimal || "".equals(decimal)) {
            return null;
        }
        //建立百分比格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();
//        percent.setMaximumFractionDigits(3); //百分比小数点最多3位
        return percent.format(decimal);
    }

    public interface Holder {
        /** 定义要显示的数字的格式（这种方式会四舍五入） */
        String style_0 = "0.00";
        /** 模式中的"#"表示如果该位存在字符，则显示字符，如果不存在，则不显示 */
        String style_1 = "##000.00";
        /** 模式中的"-"表示输出为负数，要放在最前面 */
        String style_2 = "-000.00";
        /** 模式中的","在数字中添加逗号，方便读数字  */
        String style_3 = "0,000.00#";
        /** 模式中的"%"表示乘以100并显示为百分数，要放在最后 */
        String style_4 = "0.00%";
    }


}
