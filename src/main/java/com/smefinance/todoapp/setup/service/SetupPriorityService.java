package com.smefinance.todoapp.setup.service;

import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.setup.entity.SetupPriorityEntity;

import java.util.List;

public interface SetupPriorityService {

    MessageResponse addPriority(SetupPriorityEntity setupPriorityEntity);
    MessageResponse updatePriority(SetupPriorityEntity setupPriorityEntity);
    List<SetupPriorityEntity> updateAllPriority(List<SetupPriorityEntity> setupPriorityEntity);
    List<SetupPriorityEntity> getAllPriorityList();
    MessageResponse deletePriority(Long id);
}
