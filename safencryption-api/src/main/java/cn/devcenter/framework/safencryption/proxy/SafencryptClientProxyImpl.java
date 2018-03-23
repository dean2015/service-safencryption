package cn.devcenter.framework.safencryption.proxy;

import cn.devcenter.framework.safencryption.core.client.bean.ClientInfo;
import cn.devcenter.framework.safencryption.core.client.service.SafencryptClientProxy;
import cn.devcenter.framework.safencryption.token.sdk.SafencryptionTokenService;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.token.AccessToken;
import cn.devcenter.model.token.ClientIdentity;
import cn.housecenter.dlfc.framework.web.core.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;

public class SafencryptClientProxyImpl implements SafencryptClientProxy {

    @Autowired
    private SafencryptionTokenService safencryptionTokenService;

    private static final Long DEFAULT_CTOKEN_EXPIRE_TIME_MILLIS = -1L;

    @Override
    public ExecutionResult<ClientInfo> addClient(ClientInfo clientInfo) {
        AccessToken accessToken = new AccessToken();
        ClientIdentity clientIdentity = new ClientIdentity();
        clientIdentity.setClientIdentifier(clientInfo.getIdentifier());
        accessToken.setClientIdentity(clientIdentity);
        accessToken.setToken(clientInfo.getCToken());
        accessToken.setExpiredPeriod(DEFAULT_CTOKEN_EXPIRE_TIME_MILLIS);
        AjaxResult<AccessToken> result = safencryptionTokenService.generateAccessToken(accessToken);
        if (result.successful()) {
            return ExecutionResult.newInstance(ClientInfo.class).success("Register token successfully", clientInfo);
        } else {
            return ExecutionResult.newInstance(ClientInfo.class).fail(result.getMessage());
        }
    }

}
