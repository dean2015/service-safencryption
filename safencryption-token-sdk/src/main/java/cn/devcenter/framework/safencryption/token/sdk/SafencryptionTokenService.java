package cn.devcenter.framework.safencryption.token.sdk;

import cn.devcenter.model.token.AccessToken;
import cn.housecenter.dlfc.framework.web.core.AjaxResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "token-service")
@RequestMapping("/token")
public interface SafencryptionTokenService {

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    AjaxResult<Void> generateAccessToken(AccessToken token);
}
