package com.smefinance.todoapp.login.service;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.model.entity.SyRightsEntity;
import com.smefinance.todoapp.login.model.UsersEntity;

public interface LoginService {

//    SyUsrMasEntity getUserByUserIdAndPass(Parameters pv);
    UsersEntity getUserInfoByUserId(Parameters pv);
    SyRightsEntity getUserBranchCodeByUserId(Parameters pv);
}
