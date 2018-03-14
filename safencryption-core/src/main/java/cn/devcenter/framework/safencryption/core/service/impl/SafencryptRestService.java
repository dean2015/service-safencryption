package cn.devcenter.framework.safencryption.core.service.impl;


import cn.devcenter.framework.safencryption.core.bean.ClientInfo;
import cn.devcenter.framework.safencryption.core.bean.SafencryptPublicKey;
import cn.devcenter.framework.safencryption.core.exception.FlagInvalidException;
import cn.devcenter.framework.safencryption.core.service.SafencryptClientProxy;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SafencryptRestService {

    @Autowired
    private SafencryptClientProxy safencryptClientProxy;

    /**
     * 申请公钥
     *
     * @return 返回公钥
     */
    public SafencryptPublicKey applyPublicKey() {
        return RSAEncryptService.generatePublicKey();
    }

    /**
     * 注册客户端
     *
     * @param identifier 客戶端标识字符串
     * @return
     */
    public Object signUpClient(String identifier) throws FlagInvalidException {
        ClientInfo clientInfo = new ClientInfo(identifier);
        safencryptClientProxy.addClient(clientInfo);
        return clientInfo;
    }



}
