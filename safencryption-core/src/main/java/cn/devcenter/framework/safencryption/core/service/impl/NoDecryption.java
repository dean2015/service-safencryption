package cn.devcenter.framework.safencryption.core.service.impl;

import cn.devcenter.framework.safencryption.core.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.service.DecryptionService;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;

@DecryptionType(value = 1)
@Service
public class NoDecryption implements DecryptionService {

    @Override
    public String decrypt(String content, String flag) {
        return content;
    }

}