package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.annotation.EncryptionType;
import cn.devcenter.framework.safencryption.core.user.bean.SafencryptResponse;
import cn.devcenter.framework.safencryption.core.user.service.EncryptionService;
import cn.devcenter.framework.safencryption.core.user.service.SafencryptUserProxy;
import cn.devcenter.framework.safencryption.core.util.AES;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 加密基于用户有关业务的响应
 */
@EncryptionType(value = 4)
@Service
public class EncryptBasedUser implements EncryptionService {

    @Autowired
    private SafencryptUserProxy safencryptUserProxy;

    @Override
    public String encrypt(String content, String flag) {
        String encryptData = AES.encrypt(content, safencryptUserProxy.getUserIdentifierWithToken(flag));
        return SafencryptResponse.newInstance(4, encryptData).toString();
    }
}
