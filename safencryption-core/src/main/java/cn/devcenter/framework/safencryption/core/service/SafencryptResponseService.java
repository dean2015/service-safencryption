package cn.devcenter.framework.safencryption.core.service;

public interface SafencryptResponseService {

    String encryptResponse(String content, Integer type, String token);

}
