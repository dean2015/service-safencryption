package cn.devcenter.framework.safencryption.core.user.service;

public interface SafencryptRequestService {

    String decryptRequest(String content, Integer type, String token);
}
