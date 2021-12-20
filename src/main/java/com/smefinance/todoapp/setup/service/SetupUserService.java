package com.smefinance.todoapp.setup.service;

import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.setup.entity.SetupUserEntity;

import java.util.List;

public interface SetupUserService {
    MessageResponse addUser(SetupUserEntity setupUserEntity);
    MessageResponse updateUser(SetupUserEntity setupUserEntity);
    List<SetupUserEntity> updateAllUser(List<SetupUserEntity> setupUserEntity);
    List<SetupUserEntity> getAllUserList();
    MessageResponse deleteUser(Long id);
}
