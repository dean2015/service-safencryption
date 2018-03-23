package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.annotation.EncryptionType;
import cn.devcenter.framework.safencryption.core.user.bean.SafencryptResponse;
import cn.devcenter.framework.safencryption.core.user.service.EncryptionService;
import cn.devcenter.framework.safencryption.core.user.service.SafencryptClientProxy;
import cn.devcenter.framework.safencryption.core.util.AES;
import org.springframework.stereotype.Service;
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
        String encryptData = AES.encrypt(content, safencryptClientProxy.getClientIdentifierWithToken(flag));
        return SafencryptResponse.newInstance(3, encryptData).toString();
    }
}