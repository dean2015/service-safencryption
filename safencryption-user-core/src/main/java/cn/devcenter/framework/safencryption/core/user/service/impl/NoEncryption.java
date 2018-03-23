package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.annotation.EncryptionType;
import cn.devcenter.framework.safencryption.core.user.service.EncryptionService;
import org.springframework.stereotype.Service;

@EncryptionType(value = 1)
@Service
public class NoEncryption implements EncryptionService {

    @Override
    public String encrypt(String content, String flag) {
        return content;
    }

}