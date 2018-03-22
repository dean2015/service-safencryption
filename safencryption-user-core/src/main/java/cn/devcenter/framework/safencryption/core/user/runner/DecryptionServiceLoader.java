package cn.devcenter.framework.safencryption.core.user.runner;

import cn.devcenter.framework.safencryption.core.user.annotation.DecryptionType;
import cn.devcenter.framework.safencryption.core.user.service.DecryptionService;
import cn.devcenter.framework.safencryption.core.user.service.impl.DecryptionServiceManager;
import cn.housecenter.dlfc.framework.boot.stereotype.Component;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

@Component
public class DecryptionServiceLoader implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, DecryptionService> beanMap = applicationContext.getBeansOfType(DecryptionService.class);
        beanMap.forEach((key, value) -> {
            DecryptionType decryptionType = value.getClass().getAnnotation(DecryptionType.class);
            if (decryptionType == null) {
                return;
            }
            DecryptionServiceManager.put(decryptionType.value(), value);
        });
    }
}
