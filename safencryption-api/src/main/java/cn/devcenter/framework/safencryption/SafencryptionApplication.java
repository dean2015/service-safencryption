package cn.devcenter.framework.safencryption;

import cn.housecenter.dlfc.framework.starter.web.webcontainer.JettyContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@Slf4j
public class SafencryptionApplication extends JettyContainer {

    public static void main(String[] args) {
        SpringApplication.run(SafencryptionApplication.class, args);
        log.info("========== Safencryption service started ==========");
    }

}
