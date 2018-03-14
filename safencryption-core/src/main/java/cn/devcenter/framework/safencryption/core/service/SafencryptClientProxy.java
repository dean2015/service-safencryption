package cn.devcenter.framework.safencryption.core.service;


import cn.devcenter.framework.safencryption.core.bean.ClientInfo;

public interface SafencryptClientProxy {

    /**
     * 添加客户端的代理函数
     *
             * @param clientInfo 客户端信息对象
     */
    void addClient(ClientInfo clientInfo);

    /**
     * 根据token获取客户端标识
     *
     * @param token 要获取的客户端的token令牌
     * @return 客户端标识字符串
     */
    String getClientIdentifierWithToken(String token);

}
