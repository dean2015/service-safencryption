package cn.devcenter.framework.safencryption.core.service;

public interface SafencryptRequestService {

    String decryptRequest(String content, Integer type, String token);
}
