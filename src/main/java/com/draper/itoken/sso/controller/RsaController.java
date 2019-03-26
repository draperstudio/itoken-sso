package com.draper.itoken.sso.controller;

import com.draper.itoken.core.entity.dto.Response;
import com.draper.itoken.sso.service.RsaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author draper_hxy
 */
@Slf4j
@RestController
public class RsaController {

    @Autowired
    private RsaService rsaService;

    @RequestMapping(value = "/api/sso/key/public", method = RequestMethod.GET)
    public Response getRsaPublicKeyStr() {
        try {
            return new Response(200, "OK", rsaService.getPublicKeyStr());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            return Response.error();
        }
    }

    @RequestMapping(value = "/api/sso/key/private", method = RequestMethod.GET)
    public Response getRsaPrivateKeyStr() {
        try {
            return new Response(200, "OK", rsaService.getPrivateKeyStr());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            return Response.error();
        }
    }

}
