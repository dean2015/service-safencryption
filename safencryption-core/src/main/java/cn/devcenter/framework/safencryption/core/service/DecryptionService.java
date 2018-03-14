package cn.devcenter.framework.safencryption.core.service;


public interface DecryptionService {

    <T> T decrypt(String content, String flag);

}
