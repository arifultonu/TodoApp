package com.smefinance.todoapp.operation.task_assign.service;

import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import com.smefinance.todoapp.operation.task_assign.repository.TaskAssignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignServiceImpl implements TaskAssignService{

    @Autowired
    private TaskAssignRepo taskAssignRepo;

    @Override
    public List<TaskAssignEntity> saveAllTaskAssign(List<TaskAssignEntity> taskAssignEntityList) {
        return taskAssignRepo.saveAll(taskAssignEntityList);
    }
    @Override
    public List<TaskAssignEntity> getTaskAssignList() {
        return taskAssignRepo.findAll();
    }

    //Get Task by Id/Serial No
    @Override
    public TaskAssignEntity getTaskAssignById(Long id) {
        return taskAssignRepo.findById(id).orElse(null);
    }

    //Get All Task by User Id
    @Override
    public List<TaskAssignEntity> getTaskAssignByAdminUserId(String adminUserId) {
        return taskAssignRepo.findByAdminUserIdOrderByPriorityIdAsc(adminUserId);
    }

    //Get All Task by Assign User Id
    @Override
    public List<TaskAssignEntity> getTaskAssignByAssignUserId(String assignUserId) {
        return taskAssignRepo.findByAssignUserIdOrderByPriorityIdAsc(assignUserId);
    }
    @Override
    public MessageResponse saveTaskAssign(TaskAssignEntity taskAssignEntity) {
        MessageResponse messageResponse = new MessageResponse();
        taskAssignRepo.save(taskAssignEntity);
        messageResponse.setResponseCode("1");
        messageResponse.setResponseMessage("New Row Added Successfully");
        return messageResponse;
    }


    //Delete Task
    @Override
    public MessageResponse deleteTaskAssign(Long id) {
        MessageResponse messageResponse = new MessageResponse();
        taskAssignRepo.deleteById(id);
        messageResponse.setResponseCode("1");
        messageResponse.setResponseMessage("Task Deleted Successfully ID: " + id);
        return messageResponse;
//      return "Task Deleted Successfully ID: " + id;
    }

    @Override
    public MessageResponse updateTaskAssign(TaskAssignEntity taskAssignEntity) {
        MessageResponse messageResponse = new MessageResponse();
        TaskAssignEntity existingTaskAssign = taskAssignRepo.findById(taskAssignEntity.getId()).orElse(null);
        existingTaskAssign.setAssignUserId(taskAssignEntity.getAssignUserId());
        existingTaskAssign.setAssignDate(taskAssignEntity.getAssignDate());
        existingTaskAssign.setDueDate(taskAssignEntity.getDueDate());
        existingTaskAssign.setPriorityId(taskAssignEntity.getPriorityId());
        existingTaskAssign.setTaskDetails(taskAssignEntity.getTaskDetails());
        existingTaskAssign.setTaskStatusId(taskAssignEntity.getTaskStatusId());
        taskAssignRepo.save(existingTaskAssign);
        messageResponse.setResponseCode("1");
        messageResponse.setResponseMessage("Update Task Successfully ID: " + taskAssignEntity.getId());
        return messageResponse;


    }
    @Override
    public TaskAssignEntity updateTaskAssign2(TaskAssignEntity taskAssignEntity) {
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
