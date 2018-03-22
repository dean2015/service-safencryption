package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.user.service.DecryptionService;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;

@DecryptionType(value = 1)
@Service
public class NoDecryption implements DecryptionService {

    @Override
    public String decrypt(String content, String flag) {
        return content;
    }

}