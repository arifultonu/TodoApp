package com.smefinance.todoapp.operation.task_assign.controller;

import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import com.smefinance.todoapp.operation.task_assign.service.TaskAssignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/todo")
@Slf4j
public class TaskAssignController {

    @Autowired
    private TaskAssignService taskAssignService;

    @PostMapping("/addTaskAssign")
    public TaskAssignEntity addTaskAssign(@RequestBody TaskAssignEntity taskAssignEntity) {
        return taskAssignService.saveTaskAssign(taskAssignEntity);
    }

    @PostMapping("/addAllTaskAssign")
    public List<TaskAssignEntity> addAllTaskAssign(@RequestBody List<TaskAssignEntity> taskAssignEntityes) {
        return taskAssignService.saveAllTaskAssign(taskAssignEntityes);
    }

    @GetMapping("/getAllTaskAssign")
    public List<TaskAssignEntity> findAllTaskAssign() {
        return taskAssignService.getTaskAssignList();
    }

    @GetMapping("/getTaskAssignById/{id}")
    public TaskAssignEntity findTaskAssignById(@PathVariable Long id) {
        return taskAssignService.getTaskAssignById(id);
    }

    //Get All Task By User Id
    @GetMapping("/getAllTaskAssignByAdminUserId/{adminUserId}")
    public List<TaskAssignEntity> findAllTaskAssignByAdminUserId(@PathVariable int adminUserId) {
        return taskAssignService.getTaskAssignByAdminUserId(adminUserId);
    }

    //Update Task Assign
    @PutMapping("/updateTaskAssign")
    public TaskAssignEntity updateTaskAssign(@RequestBody TaskAssignEntity taskAssignEntity) {
        return taskAssignService.updateTaskAssign(taskAssignEntity);
    }

    //Delete Task Assign By Task ID
    @DeleteMapping("/deleteTaskAssign/{id}")
    public String deleteTaskAssign(@PathVariable Long id) {
        return taskAssignService.deleteTaskAssign(id);
    }


}
