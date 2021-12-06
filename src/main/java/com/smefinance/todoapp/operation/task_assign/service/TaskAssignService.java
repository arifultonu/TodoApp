package com.smefinance.todoapp.operation.task_assign.service;

import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import com.smefinance.todoapp.operation.task_assign.repository.TaskAssignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignService {

    @Autowired
    private TaskAssignRepo taskAssignRepo;

    public TaskAssignEntity saveTaskAssign(TaskAssignEntity taskAssignEntity) {
        return taskAssignRepo.save(taskAssignEntity);
    }

    public List<TaskAssignEntity> saveAllTaskAssign(List<TaskAssignEntity> taskAssignEntityList) {
        return taskAssignRepo.saveAll(taskAssignEntityList);
    }

    public List<TaskAssignEntity> getTaskAssignList() {
        return taskAssignRepo.findAll();
    }

    //Get Task Assign by Id
    public TaskAssignEntity getTaskAssignById(Long id) {
        return taskAssignRepo.findById(id).orElse(null);
    }

    //Get All Task Assign
    public List<TaskAssignEntity> getTaskAssignByAdminUserId(String adminUserId) {
        return taskAssignRepo.findByAdminUserId(adminUserId);
    }

    //Delete Task
    public String deleteTaskAssign(Long id) {
        taskAssignRepo.deleteById(id);
        return "Task Deleted Successfully ID: " + id;
    }


    public TaskAssignEntity updateTaskAssign(TaskAssignEntity taskAssignEntity) {
        TaskAssignEntity existingTaskAssign = taskAssignRepo.findById(taskAssignEntity.getId()).orElse(null);
        existingTaskAssign.setAssignUserId(taskAssignEntity.getAssignUserId());
        existingTaskAssign.setAssignDate(taskAssignEntity.getAssignDate());
        existingTaskAssign.setDueDate(taskAssignEntity.getDueDate());
        existingTaskAssign.setPriorityId(taskAssignEntity.getPriorityId());
        existingTaskAssign.setTaskDetails(taskAssignEntity.getTaskDetails());
        existingTaskAssign.setTaskStatusId(taskAssignEntity.getTaskStatusId());
        return taskAssignRepo.save(existingTaskAssign);
    }

    }


