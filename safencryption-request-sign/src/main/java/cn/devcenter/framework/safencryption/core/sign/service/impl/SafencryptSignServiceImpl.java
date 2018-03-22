package cn.devcenter.framework.safencryption.core.sign.service.impl;


import cn.devcenter.framework.safencryption.core.sign.service.SafencryptClientProxy;
import cn.devcenter.framework.safencryption.core.sign.service.SafencryptSignService;
import cn.devcenter.framework.safencryption.core.util.HMAC;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 签名业务
 */
@Slf4j
@Service
public class SafencryptSignServiceImpl implements SafencryptSignService {

    @Autowired
    private SafencryptClientProxy safencryptClientProxy;

    @Override
    public boolean checkSign(HttpServletRequest request) {
        String url = request.getRequestURI() + "?" + request.getQueryString();
        if (url.contains("sign=")) {
            url = url.substring(0, url.indexOf("sign=") - 1);
        } else {
            log.error("URL不包含签名部分:" + url);
            return false;
        }
        String identifier = safencryptClientProxy.getClientIdentifierWithToken(request.getParameter("flag"));
        if (StringUtils.isBlank(identifier)) {
            log.error("identifier is empty for url: " + url);
            return false;
        }
        log.debug("url [" + url + "] identifier [" + identifier + "] sign [" + request.getParameter("sign") + "]");
        String localSign = HMAC.hmacMD5(url, identifier);
        log.debug("identifier: [" + identifier + "] local-sign: [" + localSign + "]");
        return localSign.equals(request.getParameter("sign"));
    }

}
