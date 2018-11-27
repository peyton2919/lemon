package cn.peyton.spring.lemon.util;

import cn.peyton.spring.cipher.SymmetricCipherUtil;

/**
 * <h3>Cookie 加密工具 类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.lemon.util.CookieEncryptUtil.java
 * @create date: 2018/11/27 15:36
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class CookieEncryptUtil {
    /** DES 加密 KEY */
    private final static String KEY = "d21a56bb707e4162b5dbd87667ff1276";

    /**
     * <h4>加密</h4>
     * @param content 内容
     * @return 加密后内容
     */
    public final static String encoder(String content) {
        return SymmetricCipherUtil.encoder(content,KEY, SymmetricCipherUtil.SymmetricCipher.DES);
    }

    /**
     * <h4>解密</h4>
     * @param content 加密内容
     * @return 解密后内容
     */
    public final static String decoder(String content) {
        return SymmetricCipherUtil.decoder(content, KEY, SymmetricCipherUtil.SymmetricCipher.DES);
    }
}
