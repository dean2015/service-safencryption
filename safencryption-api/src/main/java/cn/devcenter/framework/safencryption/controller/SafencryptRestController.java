package cn.devcenter.framework.safencryption.controller;

import cn.devcenter.framework.safencryption.core.client.bean.ClientInfo;
import cn.devcenter.framework.safencryption.core.client.service.RSAService;
import cn.devcenter.framework.safencryption.core.client.service.SafencryptClientProxy;
import cn.devcenter.framework.safencryption.core.client.service.impl.RSAServiceImpl;
import cn.devcenter.framework.safencryption.model.IdentifierDTO;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 不返回ajaxresult的api
 * 对应前台的加密解密功能
 */
@RestController
public class SafencryptRestController {

    @Autowired
    private SafencryptClientProxy safencryptClientProxy;

    @Autowired
    private RSAService rsaService;

    @RequestMapping(value = "/apply-public-key", method = RequestMethod.GET)
    public Object applyPublicKey() {
        return rsaService.generatePublicKey();
    }

    @RequestMapping(value = "/sign-up-client", method = RequestMethod.POST)
    public Object signUpClient(@Valid @RequestBody IdentifierDTO identifierDTO) {
        ClientInfo clientInfo = new ClientInfo(identifierDTO.getIdentifier());
        ExecutionResult<ClientInfo> result = safencryptClientProxy.addClient(clientInfo);
        if (result.isSuccessful()) {
            return result.getData();
        }
        return null;
    }

}
