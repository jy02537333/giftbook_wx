package org.jeecgframework.core.util.base64;

import com.jeecg.controller.giftbook.ApiMD5TestCtrl;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HandlerRSAUtils {
	public static  String priKey;
	public static  String publicKey;
	public static  String priKeyLogin;
	public static  String publicKeyLogin;
	static{
		try {
			Properties pro = new Properties();
			InputStream is= ApiMD5TestCtrl.class.getClassLoader().getResourceAsStream("key.properties");
			//FileInputStream in = new FileInputStream("key.properties");
			pro.load(is);
			priKey=pro.get("privateKey").toString();
			publicKey=pro.get("publicKey").toString();
			priKeyLogin=pro.get("loginPrivateKey").toString();
			publicKeyLogin=pro.get("loginPublicKey").toString();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String encode(String str) throws Exception
	{
	        byte[] cipherData=RSAEncrypt.encryptByPublicKey(str.getBytes(),publicKey);
	        String token=Base64Utils.encode(cipherData);  
		return token;
	}
	public static byte[] encodeByte(String str) throws Exception
	{
	        byte[] cipherData=RSAEncrypt.encryptByPublicKey(str.getBytes(),publicKey);
		return cipherData;
	}
	
	
	public static String decryption(String str) throws Exception
	{
		str=StringEscapeUtils.unescapeJava(str);
		byte[] bytes=	Base64Utils.decode(str); 
	    byte[] res= RSAEncrypt.decryptByPrivateKey(bytes, priKey);
        String restr=new String(res);  
		return restr;
	}
	
	public static String encodeLogin(String str) throws Exception
	{
	        byte[] cipherData=RSAEncrypt.encryptByPublicKey(str.getBytes(),publicKeyLogin);
	        String token=Base64Utils.encode(cipherData);  
		return token;
	}
	
	
	public static String decryptionLogin(String str) throws Exception
	{
		str=StringEscapeUtils.unescapeJava(str);
		byte[] bytes=	Base64Utils.decode(str); 
	    byte[] res= RSAEncrypt.decryptByPrivateKey(bytes, priKeyLogin);
        String restr=new String(res);  
		return restr;
	}

	public static void main(String[] args) {
		try {
			String aaa=	HandlerRSAUtils.encode("{1:2}");
			String bbbb=	HandlerRSAUtils.decryption(aaa);

			BASE64Encoder encoder=new BASE64Encoder();
			 bbbb=	encoder.encode("123456".getBytes());
			System.out.println(bbbb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
