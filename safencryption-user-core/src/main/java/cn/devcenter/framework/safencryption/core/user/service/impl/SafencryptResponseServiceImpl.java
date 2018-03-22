package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.service.EncryptionService;
import cn.devcenter.framework.safencryption.core.user.service.SafencryptResponseService;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;

/**
 * safencrypt的响应加密业务类
 */
@Service
public class SafencryptResponseServiceImpl implements SafencryptResponseService {

    @Override
    public String encryptResponse(String content, Integer type, String token) {
        EncryptionService encryptionService = EncryptionServiceManager.get(type);
        if (encryptionService == null) {
            // type为1，不加密，不需要进行json嵌套
            return content;
        }
        return encryptionService.encrypt(content, token);
    }

}
