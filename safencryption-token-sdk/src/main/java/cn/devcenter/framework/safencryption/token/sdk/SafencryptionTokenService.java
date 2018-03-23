package cn.devcenter.framework.safencryption.token.sdk;

import cn.devcenter.framework.safencryption.token.sdk.fallback.SafencryptionTokenServiceFallback;
import cn.devcenter.model.token.AccessToken;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import cn.housecenter.dlfc.framework.web.core.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "token-service", fallback = SafencryptionTokenServiceFallback.class)
@RequestMapping("/token")
public interface SafencryptionTokenService {

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    AjaxResult<AccessToken> generateAccessToken(@RequestBody AccessToken token);

}
