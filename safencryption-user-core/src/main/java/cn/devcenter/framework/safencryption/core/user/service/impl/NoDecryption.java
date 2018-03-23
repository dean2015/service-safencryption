package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.user.service.DecryptionService;
import org.springframework.stereotype.Service;

@Service
@DecryptionType(value = 1)
public class NoDecryption implements DecryptionService {

    @Override
    public String decrypt(String content, String flag) {
        return content;
    }

}