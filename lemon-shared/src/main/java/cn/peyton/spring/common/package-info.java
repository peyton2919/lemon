/**
 * <h3>公共方法包</h3>
 * <h4>有以下几个类：</h4>
 * <pre>
 *     1. ApplicationContextHelper 类: 全局的ApplicationContext中获得Context上下文，
 *              可以用 popBean方法获取相应的对象
 *     2. Constants 类: 定义一些Redis缓存的Key
 *     3. HttpInterceptor 类: HTTP 拦截器, 用来清除 RequestHodler中的数据
 *     4. JsonData 类: 返回前台Json数据的封装
 *     5. RequestHolder 类: 用来存放当前 用户和Request对象
 *     6. SpringExceptionResolver 类: 全局异常类 , 配置一些全局规则
 * </pre>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * CreateDate: 2018/6/23 16:00
 * Version: 1.0.0
 * </pre>
 */
package cn.peyton.spring.common;