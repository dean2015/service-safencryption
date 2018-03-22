package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.user.service.SafencryptRequestService;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * safencrypt的响应加密业务类
 */
@Slf4j
@Service
public class SafencryptRequestServiceImpl implements SafencryptRequestService {

    @Override
    public String decryptRequest(String content, Integer type, String token) {
        DecryptionService decryptionService = DecryptionServiceManager.get(type);
        if (decryptionService == null) {
            return content;
        }
        return decryptionService.decrypt(content, token);
    }
}
