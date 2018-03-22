package cn.devcenter.framework.safencryption.core.user.service.impl;

import cn.devcenter.framework.safencryption.core.user.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.user.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.user.service.SafencryptUserProxy;
import cn.devcenter.framework.safencryption.core.util.AES;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 解密基于用户有关业务的响应
 */
@Slf4j
@DecryptionType(value = 4)
@Service
public class DecryptionBasedUser implements DecryptionService {

    @Autowired
    private SafencryptUserProxy safencryptUserProxy;

    @Override
    public String decrypt(String data, String flag) {
        String utoken = safencryptUserProxy.getUserIdentifierWithToken(flag);
        return AES.decrypt(data, utoken);
    }
}
