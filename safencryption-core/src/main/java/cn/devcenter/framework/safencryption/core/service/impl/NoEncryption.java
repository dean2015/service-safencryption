package cn.devcenter.framework.safencryption.core.service.impl;

import cn.devcenter.framework.safencryption.core.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.annotation.EncryptionType;
import cn.devcenter.framework.safencryption.core.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.service.EncryptionService;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;

@EncryptionType(value = 1)
@Service
public class NoEncryption implements EncryptionService {

    @Override
    public String encrypt(String content, String flag) {
        return content;
    }

}