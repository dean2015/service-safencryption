package cn.devcenter.framework.safencryption.core.user.service.impl;


import cn.devcenter.framework.safencryption.core.user.service.RSADecryptService;
import cn.devcenter.framework.safencryption.core.util.ObjectUtils;
import cn.devcenter.framework.safencryption.core.util.RSA;
import cn.devcenter.model.stereotype.Service;
import cn.housecenter.dlfc.common.redis.Redis;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.security.KeyPair;

@Service
@Slf4j
public class RSADecryptServiceImpl implements RSADecryptService {

    @Override
    public String decrypt(String flag, String content) {
        if (StringUtils.isBlank(flag) || !Redis.contain(flag)) {
            return "";
        }
        KeyPair keyPair = (KeyPair) ObjectUtils.unserialize((byte[]) Redis.get(flag));
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
