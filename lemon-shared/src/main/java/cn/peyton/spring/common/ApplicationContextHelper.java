package cn.peyton.spring.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <h3>获取上下文 帮助类</h3>
 * <pre>
 *     配置spring 管理
 *     <bean class="cn.peyton....common.ApplicationContextHelper" lazy-init="false"/>
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware{
    /**  全局上下文 */
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    /**
     * <h4>从全局ApplicationContext获取Bean</h4>
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T popBean(Class<T> clazz) {
        if (null == applicationContext) {
            return  null;
        }
        return applicationContext.getBean(clazz);
    }

    /**
     * <h4>从全局ApplicationContext获取Bean</h4>
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T popBean(String name, Class<T> clazz) {
        if (null == applicationContext) {
            return  null;
        }
        return applicationContext.getBean(name,clazz);
    }
}
