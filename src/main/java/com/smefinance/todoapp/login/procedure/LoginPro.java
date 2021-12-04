package com.smefinance.todoapp.login.procedure;

import com.smefinance.todoapp.common.model.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Optional;

@Service
@Slf4j
public class LoginPro {

    @Autowired
    private EntityManager oEntityManager;

    public Parameters signinPro(Parameters parameters){
        StoredProcedureQuery oStoredProcedureQuery = oEntityManager.createStoredProcedureQuery("checkAuthenticationTwo");
        oStoredProcedureQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
        oStoredProcedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        oStoredProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
        oStoredProcedureQuery.registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT);
        log.info("parameters.getUserId(): "+parameters.getUserId());
        log.info("parameters.getPassword(): "+parameters.getPassword());
        oStoredProcedureQuery.setParameter(0, Optional.ofNullable(parameters.getUserId()).orElse(""));
        oStoredProcedureQuery.setParameter(1, Optional.ofNullable(parameters.getPassword()).orElse(""));

        oStoredProcedureQuery.execute();
        parameters.setErrorMessage((String) oStoredProcedureQuery.getOutputParameterValue(2));
        parameters.setUserId(String.valueOf((Integer) oStoredProcedureQuery.getOutputParameterValue(3)));
        log.info("parameters.getUserId(): "+parameters.getUserId());
        log.info("parameters.getErrorMessage(): "+parameters.getErrorMessage());

        return parameters;
    }




}
