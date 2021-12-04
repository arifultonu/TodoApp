package com.smefinance.todoapp.securityconfiguration.basicAuth;

import com.smefinance.todoapp.common.model.DBData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = DBData.CROSS_ORIGIN)
public class AuthenticationController {
//
//    @GetMapping(path = "/basicAuth")
//    public com.smefinance.todoapp.securityconfiguration.basicAuth.AuthenticationBean authenticationBean(){
//        return new com.smefinance.todoapp.securityconfiguration.basicAuth.AuthenticationBean("You are Authenticated!!! ");
//    }
}
