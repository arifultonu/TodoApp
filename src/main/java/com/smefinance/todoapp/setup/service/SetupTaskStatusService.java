package com.smefinance.todoapp.setup.service;

import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.setup.entity.SetupTaskStatusEntity;

import java.util.List;


public interface SetupTaskStatusService {
    MessageResponse addTaskStatus(SetupTaskStatusEntity setupTaskStatusEntity);
    MessageResponse updateTaskStatus(SetupTaskStatusEntity setupTaskStatusEntity);
    List<SetupTaskStatusEntity> getAllTaskStatusList();
    MessageResponse deleteTaskStatus(Long id);

}
