package com.smefinance.todoapp.login.service;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.model.entity.SyRightsEntity;
import com.smefinance.todoapp.login.model.UsersEntity;
import com.smefinance.todoapp.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UsersEntity getUserInfoByUserId(Parameters parameters) {
        return loginRepository.gettUserInfo(parameters);
    }

    @Override
    public SyRightsEntity getUserBranchCodeByUserId(Parameters parameters) {
        return loginRepository.getUserBranchCode(parameters);
    }

//    @Override
//    public EdmsUserMasterEntity getByUserName(Parameters parameters) {
//        return oUserMasterJpaRepository.getByUserName(parameters);
//    }

}
