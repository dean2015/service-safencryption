package cn.devcenter.framework.safencryption.core.service.impl;

import cn.devcenter.framework.safencryption.core.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.exception.FlagInvalidException;
import cn.devcenter.framework.safencryption.core.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.util.JsonUtils;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 解密注册客户端的消息
 */
@DecryptionType(value = 2)
@Service
public class DecryptionSignUpClient implements DecryptionService {

    @Override
    public String decrypt(String data, String flag) {
        try {
            String identifier = RSAEncryptService.decryptJSRequest(flag, data);
            IdentifierGson identifierGson = new IdentifierGson(identifier);
            return identifierGson.toString();
        } catch (FlagInvalidException e) {
            return null;
        }
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

