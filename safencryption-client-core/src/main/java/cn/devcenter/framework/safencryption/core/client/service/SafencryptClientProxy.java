package cn.devcenter.framework.safencryption.core.client.service;


import cn.devcenter.framework.safencryption.core.client.bean.ClientInfo;
import cn.devcenter.model.result.ExecutionResult;

public interface SafencryptClientProxy {

    /**
     * 添加客户端的代理函数
     *
             * @param clientInfo 客户端信息对象
     */
    ExecutionResult<ClientInfo> addClient(ClientInfo clientInfo);


}
