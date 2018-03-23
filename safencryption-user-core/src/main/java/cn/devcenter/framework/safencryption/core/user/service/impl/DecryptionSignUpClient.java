package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.user.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.user.service.RSADecryptService;
import cn.devcenter.framework.safencryption.core.util.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 解密注册客户端的消息
 */
@Service
@DecryptionType(value = 2)
public class DecryptionSignUpClient implements DecryptionService {

    @Autowired
    private RSADecryptService rsaDecryptService;

    @Override
    public String decrypt(String data, String flag) {
        String identifier = rsaDecryptService.decrypt(flag, data);
        if (StringUtils.isBlank(identifier)) {
            return null;
        }
        IdentifierGson identifierGson = new IdentifierGson(identifier);
        return identifierGson.toString();
    }

    @Data
    @AllArgsConstructor
    private class IdentifierGson {
        private String identifier;

        @Override
        public String toString() {
            if (StringUtils.isBlank(identifier)) {
                return identifier;
            }
            return JsonUtils.getGsonInstance().toJson(this);
        }
    }
}

