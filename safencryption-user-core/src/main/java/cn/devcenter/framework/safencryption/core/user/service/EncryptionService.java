package cn.devcenter.framework.safencryption.core.user.service;

public interface EncryptionService {

    <T> T encrypt(String content, String flag);

}
