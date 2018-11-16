package cn.peyton.spring.bootstarp;

/**
 * <h3>初始化网站入口</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:32
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class App {
    /** 需要初始化数据为true  */
    public static boolean isInit = true;

    /**
     * <h4>初始化数据{ 对象引用引到配置项中 }</h4>
     * @return
     */
    public static Configurator init() {
        Configurator configurator = Configurator.getInstance();
       return configurator;
    }

    /**
     * <h4>获取配置信息集合</h4>
     * @return
     */
    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }

    /**
     * <h4>获取对象</h4>
     * @param key 键
     * @param <T> 值
     * @return 泛型对象
     */
    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }
}
