package cn.devcenter.framework.safencryption.controller;

import cn.housecenter.dlfc.security.safencryption.api.model.IdentifierDTO;
import cn.housecenter.dlfc.security.safencryption.core.exception.FlagInvalidException;
import cn.housecenter.dlfc.security.safencryption.core.service.impl.SafencryptRestService;
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
    private SafencryptRestService safencryptRestService;

    @RequestMapping(value = "/apply-public-key", method = RequestMethod.GET)
    public Object applyPublicKey() {
        return safencryptRestService.applyPublicKey();
    }

    @RequestMapping(value = "/sign-up-client", method = RequestMethod.POST)
    public Object signUpClient(@Valid @RequestBody IdentifierDTO identifierDTO) throws FlagInvalidException {
        return safencryptRestService.signUpClient(identifierDTO.getIdentifier());
    }

}
