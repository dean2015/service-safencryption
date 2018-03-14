package cn.devcenter.framework.safencryption.core.service;

public interface EncryptionService {

    <T> T encrypt(String content, String flag);

}
