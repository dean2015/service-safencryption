package cn.devcenter.framework.safencryption.core.service.impl;


import cn.devcenter.framework.safencryption.core.service.DecryptionService;

import java.util.HashMap;
import java.util.Map;

public class DecryptionServiceManager {

    private static final Map<Integer, DecryptionService> serviceMap = new HashMap<>();

    public static void put(Integer type, DecryptionService service) {
        serviceMap.put(type, service);
    }

    public static DecryptionService get(Integer type) {
        return serviceMap.get(type);
    }

}
