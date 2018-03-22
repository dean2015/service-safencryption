package cn.devcenter.framework.safencryption.core.user.service;


public interface DecryptionService {

    <T> T decrypt(String content, String flag);

}
