package cn.devcenter.framework.safencryption.core.client.service;

import cn.devcenter.framework.safencryption.core.client.bean.SafencryptPublicKey;

public interface RSAService {

    /**
     * 生成一个公钥信息对象
     *
     * @return 公钥信息对象
     */
    SafencryptPublicKey generatePublicKey();

}