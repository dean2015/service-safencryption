package cn.devcenter.framework.safencryption.core.user.service;

public interface SafencryptUserProxy {

    /**
     * 通过Token获取对应关联的UToken
     *
     * @param token 客户端的CToken
     * @return 该用户的对应UToken
     */
    String getUserIdentifierWithToken(String token);

}
