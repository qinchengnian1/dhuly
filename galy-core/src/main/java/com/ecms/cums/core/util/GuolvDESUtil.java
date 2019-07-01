package com.ecms.cums.core.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;
import com.alibaba.fastjson.JSONObject;

public class GuolvDESUtil {
	private static final String ENCRYPT_TYPE_3DES = "DESede"; // 加密方式：3DES
	private static String CHARSET = "UTF-8";

	/**
	 * 加密字符串(先加密，再Base64编译)， 出错时，返回Null
	 *
	 * @param strIn 需加密的字符串
	 * @return 加密后的字符串
	 */
	public static String encrypt(String strIn, String strKey) {
		try {
			// 产生加密器
			Key key = KeyGenerator(strKey);
			Cipher encryptCipher = Cipher.getInstance(ENCRYPT_TYPE_3DES);
			encryptCipher.init(Cipher.ENCRYPT_MODE, key);
			// 先加密，再Base64编译
			byte[] byteEncrypt = encryptCipher.doFinal(strIn.getBytes(CHARSET));
			byte[] byteBase64 = Base64.encodeBase64(byteEncrypt);
			return new String(byteBase64, CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密字符串(先Base64反编译，再解密)， 出错时，返回Null
	 *
	 * @param strIn 需解密的字符串
	 * @return 解密后的字符串
	 */
	public static String decrypt(String strIn, String strKey) {
		try {
			// 产生解密器
			Key key = KeyGenerator(strKey);
			Cipher decryptCipher = Cipher.getInstance(ENCRYPT_TYPE_3DES);
			decryptCipher.init(Cipher.DECRYPT_MODE, key);
			// 先Base64反编译，再解密
			byte[] byteBase64 = Base64.decodeBase64(strIn.getBytes(CHARSET));
			byte[] byteDecrypt = decryptCipher.doFinal(byteBase64);
			return new String(byteDecrypt, CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * 生成密钥key对象
	 *
	 * @param keyStr 密钥字符串
	 * @return 密钥对象
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	private static Key KeyGenerator(String keyStr) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
		int KEY_LENGTH = DESedeKeySpec.DES_EDE_KEY_LEN;
		byte input[] = keyStr.getBytes(CHARSET);
		byte[] newKey = new byte[KEY_LENGTH];
		System.arraycopy(input, 0, newKey, 0, Math.min(input.length, KEY_LENGTH));
		DESedeKeySpec KeySpec = new DESedeKeySpec(newKey);
		SecretKeyFactory KeyFactory = SecretKeyFactory.getInstance(ENCRYPT_TYPE_3DES);
		return ((Key) (KeyFactory.generateSecret(((java.security.spec.KeySpec) (KeySpec)))));
	}

	public static void main(String[] args) throws Exception {
		String key = "s7dnh9r";
		JSONObject params = new JSONObject();
		params.put("rowNum", "100");
		String paramStr = params.toJSONString();
		// 加密
		String str1 = encrypt(paramStr, key);
		System.out.println(str1);
		// 解密
		String str2 = decrypt(str1, key);
		System.out.println(str2);

	  /*guolv_username = testgasq
		guolv_secret_key = s7dnh9r
		channelsource = 05
		server_name = www.cits.cn
		guolv_url = http://b2ctest.cits.com.cn/cits-json/api.html
      */












	}
}
