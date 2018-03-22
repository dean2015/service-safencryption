package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.user.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.user.service.SafencryptClientProxy;
import cn.devcenter.framework.safencryption.core.util.AES;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 解密基于设备有关业务的响应
 */
@DecryptionType(value = 3)
@Service
public class DecryptionBasedClient implements DecryptionService {

    @Autowired
    private SafencryptClientProxy safencryptClientProxy;

    @Override
    public String decrypt(String data, String flag) {
        String identifier = safencryptClientProxy.getClientIdentifierWithToken(flag);
        return AES.decrypt(data, identifier);
    }

}

