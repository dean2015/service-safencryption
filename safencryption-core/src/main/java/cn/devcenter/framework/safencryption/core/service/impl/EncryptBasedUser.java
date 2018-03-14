package cn.devcenter.framework.safencryption.core.service.impl;

import cn.devcenter.framework.safencryption.core.annotation.EncryptionType;
import cn.devcenter.framework.safencryption.core.service.EncryptionService;
import cn.devcenter.framework.safencryption.core.service.SafencryptUserProxy;
import cn.devcenter.framework.safencryption.core.util.AES;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
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
        return AES.encrypt(content, safencryptUserProxy.getUserIdentifierWithToken(flag));
    }
}
