package cn.devcenter.framework.safencryption.core.service.impl;

import cn.devcenter.framework.safencryption.core.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.annotation.EncryptionType;
import cn.devcenter.framework.safencryption.core.service.EncryptionService;
import cn.devcenter.framework.safencryption.core.util.AES;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

/**
 * 加密注册客户端的响应
 * {"identifier":"xxx","ctoken":"xxx"}
 * 用identifier加密整个json
 */
@EncryptionType(value = 2)
@Service
public class EncryptSignUpClient implements EncryptionService {

    @Override
    public String encrypt(String content, String flag) {
        Map<String, String> map = new GsonBuilder().create().fromJson(content, new TypeToken<Map<String, String>>() {
        }.getType());
        return AES.encrypt(content, map.get("identifier"));
    }
}