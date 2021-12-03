package com.smefinance.todoapp.operation.task_info.service;

import com.smefinance.todoapp.operation.task_info.entity.TaskInfoEntity;
import com.smefinance.todoapp.operation.task_info.repository.TaskInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskInfoService {

    @Autowired
    private TaskInfoRepo taskInfoRepo;

    public TaskInfoEntity saveTaskInfo(TaskInfoEntity taskInfoEntity) {
        return taskInfoRepo.save(taskInfoEntity);
    }

    public List<TaskInfoEntity> saveAllTaskInfo(List<TaskInfoEntity> taskInfoEntityList) {
        return taskInfoRepo.saveAll(taskInfoEntityList);
    }

    public List<TaskInfoEntity> getTaskInfoList() {
        return taskInfoRepo.findAll();
    }

    //Get Task Info by Id
    public TaskInfoEntity getTaskInfoById(Long id) {
        return taskInfoRepo.findById(id).orElse(null);
    }

    //Get All Task Info
    public List<TaskInfoEntity> getTaskInfoByUserId(Long userId) {
        return taskInfoRepo.findByUserId(userId);
    }

    //Delete Task
    public String deleteTaskInfo(Long taskId) {
        taskInfoRepo.deleteById(taskId);
        return "Task Deleted Successfully- " + taskId;
    }


    public TaskInfoEntity updateTaskInfo(TaskInfoEntity taskInfoEntity) {
        TaskInfoEntity existingTaskInfo = taskInfoRepo.findById(taskInfoEntity.getId()).orElse(null);
        existingTaskInfo.setComments(taskInfoEntity.getComments());
        existingTaskInfo.setTaskStatus(taskInfoEntity.getTaskStatus());
        return taskInfoRepo.save(existingTaskInfo);
    }

    }


