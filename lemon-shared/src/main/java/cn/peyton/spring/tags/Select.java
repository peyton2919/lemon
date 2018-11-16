package cn.peyton.spring.tags;

import cn.peyton.spring.tags.base.BaseTagSupport;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>下拉框 类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:47
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class Select extends BaseTagSupport {
    /** 规定元素唯一 id*/
    private String identify;
    /** 这里是指label是展示在左边,label的值集合,这是必需要的值;*/
    private String label;
    /** 名称 */
    private String name;
    /** 这里是指label的样式;*/
    private String labelClass;
    /** 这里指的是下拉框选中的值; */
    private String value;
    /**  文本框 样式 */
    private String cssClass;
    /** 对象集合 */
    private Object map;
    /**  下拉框 值    */
    private String optionValue;
    /**  下拉框 名称    */
    private String optionName;

    // =================================================== 内部属性 =================================================== //
    private Map<String, String> maps = new LinkedHashMap<>();

    private String opValue = null;
    private String opName = null;
    private String contrlId;

   @Override
    public int doStartTag() throws JspException {
        if (null != map) {
            if (map instanceof Map<?,?>) {
                maps.putAll ((LinkedHashMap<String, String>) map);
            } else if (map instanceof List) {
                if (optionValue != null && !"".equals(optionValue.trim())
                        && optionName != null && !"".equals(optionName.trim())) {
                    List<?> lists = (List<?>) map;

                    int size = lists.size();
                    for (int i = 0; i < size; i++) {
                        Object obj = lists.get(i);
                        Class<?> clazz = obj.getClass();
                        Field[] fields = clazz.getDeclaredFields();
                        for (Field field : fields) {
                            field.setAccessible(true);
                            if (optionValue.equals(field.getName())) {
                                try {
                                    opValue = field.get(obj).toString();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            } else if (optionName.equals(field.getName())) {
                                try {
                                    opName = field.get(obj).toString();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (opValue != null && opName != null) {
                            maps.put(opValue, opName);
                            opValue = null;
                            opName =null;
                        }
                    }
                }
                //创建
                contrlId = createID();
            }
        }
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        if (!maps.isEmpty()) {
            JspWriter out = super.pageContext.getOut();
            try {
                out.println(createLabelMessage(contrlId,label,labelClass));
                out.println(createSelectMessage(maps,contrlId,name,value,cssClass));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doEndTag();
    }

    //========================================= set and get method ====================================

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabelClass() {
        return labelClass;
    }

    public void setLabelClass(String labelClass) {
        this.labelClass = labelClass;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public Object getMap() {
        return map;
    }

    public void setMap(Object map) {
        this.map = map;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
