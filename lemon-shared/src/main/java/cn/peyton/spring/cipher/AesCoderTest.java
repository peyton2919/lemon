package cn.peyton.spring.cipher;

/**
 * <h3>对称加密算法测试用例 </h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 14:33
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AesCoderTest {
        
      public static void main(String args[])  
      {  
          try {  
             //初始化密钥   NYMRcfbXyW2fDMsed8SpUQ==  F4h9UjRZyu4fwKuzON5iRg==
             String secretKey= AesUtil.initKeyString();
        	 
             System.out.println("密钥为:"+secretKey);  
             System.out.println(secretKey.length());
             String s="我们的大中国<?xml version=\"1.0\"?><hibernate-mapping><class name=\"cn.peyton.web.wzbd.entity.PubAdmin\" table=\"pub_admin\" catalog=\"wanzibaidai\">";  
             //加密数据  
             byte[] encryptData= AesUtil.encrypt(s.getBytes(), secretKey);
             System.out.println(encryptData.length);
             //解密数据  
             byte[] data= AesUtil.decrypt(encryptData, secretKey);

             //比较  
             System.out.println(encryptData);  
             System.out.println(new String(data));  
       
             
          } catch (Exception e) {  
            // TODO Auto-generated catch block  [B@2c8d66b2 B@7dc36524
            e.printStackTrace();  //Du49W/hpkC9K+XBFoOmY5A==
        }  
      }  
}
