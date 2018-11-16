package cn.peyton.spring.validator.demo;

import cn.peyton.spring.validator.Validation;

import java.util.Map;

/**
 * <h3>注解验证 Demo类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * Email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.validator.demo.Demo.java
 * CreateDate: 2018/8/20 8:52
 * Version: 1.0.0
 * </pre>
 */
public class Demo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setCreate("2005/02/30");
        person.setRemarks("1234567890123456");
        Map<String, String> map = Validation.valid(person);
        System.out.println(map.toString());
    }
}
