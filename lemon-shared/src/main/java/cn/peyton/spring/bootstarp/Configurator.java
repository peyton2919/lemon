package cn.peyton.spring.bootstarp;

import cn.peyton.spring.enums.ConfigKeys;
import cn.peyton.spring.exception.GlobalException;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>全局配置信息类{ 配置文件存储和获取}</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:32
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class Configurator {
    /**  存储信息数据结构 HashMap[线程安全map] */
    private static final ConcurrentHashMap<Object, Object> CONFIGS = new ConcurrentHashMap<>();

    /**
     * 配置信息加载已经完成
     */
    public final void configure(){
        App.isInit = false;
        //完成项目的初始化
        CONFIGS.put(ConfigKeys.CONFIG_READY, true);
    }

    // ===================================== get Configurator setting begin ===================================== //
    /**
     * 检查配置信息完整性
     * @param key  ConfigKeys 枚举
     * @param <T> 泛型对象
     * @return 泛型对象
     */
    @SuppressWarnings({"unchecked", "unused"})
    final <T> T getConfiguration(Object key) {
        checkedConfiguration();
        final Object value = CONFIGS.get(key);
        if (null == value) {
            throw new GlobalException("【Configurator】" + key.toString() + "是空值");
        }
        return (T) CONFIGS.get(key);
    }

    /**
     * 获取配置信息集合
     * @return 配置信息集合
     */
    final ConcurrentHashMap<Object ,Object> getConfigs() {
        return CONFIGS;
    }
    // ===================================== get Configurator setting end ===================================== //

    // =====================================  Configurator setting begin ===================================== //

    /**
     * <h4>网站配置信息</h4>
     * @param webConfig 主机名
     * @return Configurator对象
     */
    public final Configurator withWebConfig(String webConfig) {
        CONFIGS.put(ConfigKeys.WEB_CONFIG, webConfig);
        return this;
    }

    /**
     * 微信ID
     * @param appId
     * @return
     */
    public final Configurator withWeChatAppId(String appId) {
        CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID, appId);
        return this;
    }

    /**
     * 微信密码
     * @param appSecret
     * @return
     */
    public final Configurator withWeChatAppSecret(String appSecret) {
       CONFIGS.put(ConfigKeys.WE_CHAT_APP_SECRET, appSecret);
        return this;
    }

    // =====================================  Configurator setting end ===================================== //

    // ===================================== inner private method begin ===================================== //
    /**
     * 检查配置项是否完成
     */
    private void checkedConfiguration() {
        final boolean isReady = (boolean) CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new GlobalException("【Configurator】 配置信息加载还没完成");
        }
    }

    // ===================================== inner private method end ===================================== //

    //====================线程安全懒汉模式 { 静态内部类 } 开始 ==================================================== //
    /**
     * 单例模式
     * @return
     */
    public static Configurator getInstance() {
        return  Holder.INSTANCE;
    }

    /**
     * 构造函数
     */
    private Configurator() {
        CONFIGS.put(ConfigKeys.CONFIG_READY, false);//加载还未完成 { 刚开始}
    }

    //静态内部类
    private static class  Holder{
        private static final Configurator INSTANCE = new Configurator();
    }
    //====================线程安全懒汉模式 { 静态内部类 } 结束 ==================================================== //
}
