package cn.devcenter.framework.safencryption.core.user.service;

public interface SafencryptResponseService {

    String encryptResponse(String content, Integer type, String token);

}
