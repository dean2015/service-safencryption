package cn.devcenter.framework.safencryption.core.user.service.impl;



import cn.devcenter.framework.safencryption.core.user.service.EncryptionService;

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
