package cn.devcenter.framework.safencryption.core.sign.service;

public interface SafencryptClientProxy {

    /**
     * 根据token获取客户端标识
     *
     * @param token 要获取的客户端的token令牌
     * @return 客户端标识字符串
     */
    String getClientIdentifierWithToken(String token);

}
