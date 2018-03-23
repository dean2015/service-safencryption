package cn.devcenter.framework.safencryption.token.sdk.fallback;

import cn.devcenter.framework.safencryption.token.sdk.SafencryptionTokenService;
import cn.devcenter.model.token.AccessToken;
import cn.housecenter.dlfc.framework.web.core.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

@Slf4j
public class SafencryptionTokenServiceFallback implements SafencryptionTokenService {
    @Override
    public AjaxResult<AccessToken> generateAccessToken(AccessToken token) {
        log.warn("method [authenticate(id, secret)] is not available.");
        return AjaxResult.newInstance(AccessToken.class).fail("Token服务繁忙");
    }
}
