/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.ecms.cums.core.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密工具类
 *
 * @author：junning.li
 * @since：2011-6-1 下午08:16:22
 * @version:
 */
public class AES {

	public static final String CHAR_ENCODING = "UTF-8";
	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	public static final String AES_ALGORITHM = "AES";
	public static final String DES_ALGORITHM = "DESede";// 3des加解密算法工具类;
	public static final String MD5_ALGORITHM = "MD5";
	public static final String SHA_ALGORITHM = "SHA";
	public static final String SEPERATOR = "$";

	/**
	 * 加密
	 *
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static byte[] encrypt(byte[] data, byte[] key) {
		if (key.length != 16) {
			throw new RuntimeException(
					"Invalid AES key length (must be 16 bytes)");
		}
		try {
			SecretKeySpec secretKey = new SecretKeySpec(key, AES_ALGORITHM);
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec seckey = new SecretKeySpec(enCodeFormat,
					AES_ALGORITHM);
			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);// 创建密码器
			cipher.init(Cipher.ENCRYPT_MODE, seckey);// 初始化
			byte[] result = cipher.doFinal(data);
			return result; // 加密
		} catch (Exception e) {
			throw new RuntimeException("encrypt fail!", e);
		}
	}

	/**
	 * 解密
	 *
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] data, byte[] key) {
		if (key.length != 16) {
			throw new RuntimeException(
					"Invalid AES key length (must be 16 bytes)");
		}
		try {
			SecretKeySpec secretKey = new SecretKeySpec(key, AES_ALGORITHM);
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec seckey = new SecretKeySpec(enCodeFormat,
					AES_ALGORITHM);
			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, seckey);// 初始化
			byte[] result = cipher.doFinal(data);
			return result; // 加密
		} catch (Exception e) {
			throw new RuntimeException("decrypt fail!", e);
		}
	}

	public static String encryptToBase64(String data, String key) {
		try {
			byte[] valueByte = encrypt(data.getBytes(CHAR_ENCODING),
					key.getBytes(CHAR_ENCODING));
			return new String(Base64.encode(valueByte));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("encrypt fail!", e);
		}

	}

	public static String decryptFromBase64(String data, String key) {
		try {
			byte[] originalData = Base64.decode(data.getBytes());
			byte[] valueByte = decrypt(originalData,
					key.getBytes(CHAR_ENCODING));
			return new String(valueByte, CHAR_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("decrypt fail!", e);
		}
	}

	public static String encryptWithKeyBase64(String data, String key) {
		try {
			byte[] valueByte = encrypt(data.getBytes(CHAR_ENCODING),
					Base64.decode(key.getBytes()));
			return new String(Base64.encode(valueByte));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("encrypt fail!", e);
		}
	}

	public static String decryptWithKeyBase64(String data, String key) {
		try {
			byte[] originalData = Base64.decode(data.getBytes());
			byte[] valueByte = decrypt(originalData,
					Base64.decode(key.getBytes()));
			return new String(valueByte, CHAR_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("decrypt fail!", e);
		}
	}

	public static byte[] genarateRandomKey() {
		KeyGenerator keygen = null;
		try {
			keygen = KeyGenerator.getInstance(AES_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(" genarateRandomKey fail!", e);
		}
		SecureRandom random = new SecureRandom();
		keygen.init(random);
		Key key = keygen.generateKey();
		return key.getEncoded();
	}

	public static String genarateRandomKeyWithBase64() {
		return new String(Base64.encode(genarateRandomKey()));
	}

	public static void main(String[] args) {
		// String key =
		// "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// StringBuffer bfBuffer = new StringBuffer();
		// for (int i = 0; i < 16; i++) {
		//
		// bfBuffer.append(key.charAt(RandomUtils.nextInt(62)));
		// }
		// System.out.println(bfBuffer);

		// AES.encryptToBase64("xxxx", bfBuffer.toString());
		//System.out.println(AES.decryptFromBase64("yn5jXBza6XzNLCOIYRa4RA==",
		//		"QPkSD3Z2cBEv58rZ"));
		System.out.println(AES.encryptToBase64("达闻","QPkSD3Z2cBEv58rZ"));
	}

}
