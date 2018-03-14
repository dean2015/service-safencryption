package cn.devcenter.framework.safencryption.core.service.impl;

import cn.devcenter.framework.safencryption.core.annotation.EncryptionType;
import cn.devcenter.framework.safencryption.core.service.EncryptionService;
import cn.devcenter.framework.safencryption.core.service.SafencryptClientProxy;
import cn.devcenter.framework.safencryption.core.util.AES;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 加密基于设备有关业务的响应
 */
@EncryptionType(value = 3)
@Service
public class EncryptBasedClient implements EncryptionService {

    @Autowired
    private SafencryptClientProxy safencryptClientProxy;

    @Override
    public String encrypt(String content, String flag) {
        return AES.encrypt(content, safencryptClientProxy.getClientIdentifierWithToken(flag));
    }
}