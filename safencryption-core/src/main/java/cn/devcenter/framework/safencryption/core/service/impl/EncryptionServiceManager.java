package cn.devcenter.framework.safencryption.core.service.impl;


import cn.devcenter.framework.safencryption.core.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.service.EncryptionService;

import java.util.HashMap;
import java.util.Map;

public class EncryptionServiceManager {

    private static final Map<Integer, EncryptionService> serviceMap = new HashMap<>();

    public static void put(Integer type, EncryptionService service) {
        serviceMap.put(type, service);
    }

    public static EncryptionService get(Integer type) {
        return serviceMap.get(type);
    }

}
