package cn.devcenter.framework.safencryption.core.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * AES加密相关
 *
 * @author 1iURI
 */
public class AES {

    private static final Logger LOGGER = LoggerFactory.getLogger(AES.class);

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param key     加密密码
     * @param md5Key  是否对key进行md5加密
     * @param iv      加密向量
     * @return 加密后的字节数据
     */
    public static byte[] encrypt(byte[] content, byte[] key, boolean md5Key, byte[] iv) {
        try {
            if (md5Key) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                key = md.digest(key);
            }
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/ISO10126Padding"); //"算法/模式/补码方式"
            IvParameterSpec ivps = new IvParameterSpec(iv);//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivps);
            return cipher.doFinal(content);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }


    public static byte[] decrypt(byte[] content, byte[] key, boolean md5Key, byte[] iv) {
        try {
            if (md5Key) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                key = md.digest(key);
            }
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/ISO10126Padding"); //"算法/模式/补码方式"
            IvParameterSpec ivps = new IvParameterSpec(iv);//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivps);
            return cipher.doFinal(content);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }

    public static String encrypt(String content, String key) {
        try {
            byte[] content_bytes = content.getBytes("UTF-8");
            byte[] key_bytes = key.getBytes("UTF-8");
            byte[] result_bytes = encrypt(content_bytes, key_bytes, false, key_bytes);
            return Base64.encodeBase64String(result_bytes);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("", e);
        }
        return null;
    }

    public static String decrypt(String content, String key) {
        try {
            content = content.replaceAll(" ", "");
            byte[] content_bytes = Base64.decodeBase64(content.getBytes("UTF-8"));
            byte[] key_bytes = key.getBytes("UTF-8");
            byte[] result_bytes = decrypt(content_bytes, key_bytes, false, key_bytes);
            if(null == result_bytes){
                return null;
            }
            return new String(result_bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("", e);
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }

}
