package cn.devcenter.framework.safencryption;

import cn.housecenter.dlfc.framework.starter.web.webcontainer.JettyContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@Slf4j
@EnableFeignClients(basePackages = {"cn.devcenter.framework.safencryption.token.sdk"})
public class SafencryptionApplication extends JettyContainer {

    public static void main(String[] args) {
        SpringApplication.run(SafencryptionApplication.class, args);
        log.info("========== Safencryption service started ==========");
    }

}
