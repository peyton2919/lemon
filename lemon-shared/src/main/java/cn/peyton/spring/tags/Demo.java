package cn.peyton.spring.tags;

import java.util.*;

/**
 * <h3>Demo 类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class Demo {
    public static void main(String[] args) throws Exception {
//        List<Person> strs = new ArrayList<>();
//        strs.add(new Person(1, "jsp"));
//        strs.add(new Person(2, "asp"));
//        strs.add(new Person(3, "php"));
//
//        Select select = new Select();
//        select.setMap(strs);
//        select.setOptionName("name");
//        select.setOptionValue("id");
//        select.doStartTag();

        Map<String, String> map = new HashMap<>();
        map.put("1", "aaa");
        map.put("2", "bbb");
        map.put("3", "ccc");
        System.out.println(createSelectMessage(map,null,"type","2","tes"));
    }

    public static StringBuffer createSelectMessage(Map<String, String> _map,String _id, String _name, String _value, String _css) {
        boolean initData = false;
        if (null != _value && !"".equals(_value.trim())) {
            initData = true;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("<select");
        sb.append((_id == null) ? " id=\"" + "1234" + "\"" : " id=\"" + _id + "\" ");
        sb.append(((_css != null && !"".equals(_css.trim())) ? " class=\"" + _css + "\"" : ""));
        sb.append((_name != null && !"".equals(_name.trim())) ? " name=\"" + _name + "\"" : "");
        sb.append(">");
        for (String key : _map.keySet()) {
            sb.append("<option value=\"" + key + "\"");
            if (initData){
                if (_value.trim().equals(key)) {
                    sb.append(" selected=\"selected\"");
                }
            }
            sb.append(">");

            sb.append(_map.get(key));
            sb.append("</option>");
        }

        sb.append("</select>");
        return sb;
    }

}
