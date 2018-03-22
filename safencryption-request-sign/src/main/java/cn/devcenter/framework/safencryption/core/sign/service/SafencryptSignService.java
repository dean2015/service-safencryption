package cn.devcenter.framework.safencryption.core.sign.service;


import javax.servlet.http.HttpServletRequest;

/**
 * 签名业务
 */
public interface SafencryptSignService {

    boolean checkSign(HttpServletRequest request);

}
