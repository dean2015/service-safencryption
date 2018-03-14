package cn.devcenter.framework.safencryption.core.service.impl;

import cn.devcenter.framework.safencryption.core.bean.SafencryptPublicKey;
import cn.devcenter.framework.safencryption.core.exception.FlagInvalidException;
import cn.devcenter.framework.safencryption.core.util.Const;
import cn.devcenter.framework.safencryption.core.util.ObjectUtils;
import cn.devcenter.framework.safencryption.core.util.RSA;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.security.KeyPair;

@Slf4j
public class RSAEncryptService {

    /**
     * 生成一个公钥信息对象
     *
     * @return 公钥信息对象
     */
    public static SafencryptPublicKey generatePublicKey() {
        // 创建一个非对称加密密钥对
        KeyPair keyPair = RSA.generateKeyPair();
        SafencryptPublicKey safencryptPublicKey = new SafencryptPublicKey(keyPair);
//        Redis.putET(Const.DEFAULT_REDIS, safencryptPublicKey.getFlag(), Const.KEYPAIR_TIMEOUT, ObjectUtils.serialize(keyPair));
        return safencryptPublicKey;
    }

    /**
     * 判断是否存在这个flag
     *
     * @param flag flag字符串
     * @return 是否存在这个flag的布尔值
     */
    public static boolean containFlag(String flag) {
//        return Redis.contain(flag);
        return true;
    }

    public static String decryptJSRequest(String flag, String content) throws FlagInvalidException {
        if (StringUtils.isBlank(flag) || !RSAEncryptService.containFlag(flag)) {
            throw new FlagInvalidException();
        }
//        KeyPair keyPair = (KeyPair) ObjectUtils.unserialize((byte[]) Redis.get(flag));
        KeyPair keyPair = null;
        try {
            content = content.replaceAll(" ", "");// 清除密文中的空格
            byte[] en_data = Hex.decodeHex(content.toCharArray());
            byte[] result_bytes = RSA.decrypt(keyPair.getPrivate(), en_data);
            return StringUtils.reverse(new String(result_bytes));
        } catch (Exception e) {
            log.error("", e);
        }
        return "";
    }
}