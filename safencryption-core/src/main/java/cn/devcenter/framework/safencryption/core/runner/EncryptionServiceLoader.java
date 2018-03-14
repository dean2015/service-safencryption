package cn.devcenter.framework.safencryption.core.runner;

import cn.devcenter.framework.safencryption.core.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.annotation.EncryptionType;
import cn.devcenter.framework.safencryption.core.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.service.EncryptionService;
import cn.devcenter.framework.safencryption.core.service.impl.DecryptionServiceManager;
import cn.devcenter.framework.safencryption.core.service.impl.EncryptionServiceManager;
import cn.housecenter.dlfc.framework.boot.stereotype.Component;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

@Component
public class EncryptionServiceLoader implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, EncryptionService> beanMap = applicationContext.getBeansOfType(EncryptionService.class);
        beanMap.forEach((key, value) -> {
            EncryptionType encryptionType = value.getClass().getAnnotation(EncryptionType.class);
            if (encryptionType == null) {
                return;
            }
            EncryptionServiceManager.put(encryptionType.value(), value);
        });
    }
}
