package cn.devcenter.framework.safencryption.core.bean;

import java.util.UUID;

public class ClientInfo {

    /**
     * 客户端标识
     */
    private String identifier;
    /**
     * 客户端令牌（token）
     */
    private String cToken;

    public ClientInfo(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getCToken() {
        if (cToken == null)
            cToken = UUID.randomUUID().toString().replace("-", "");
        return cToken;
    }
}
