package com.smefinance.todoapp.operation.task_assign.controller;

import com.smefinance.todoapp.common.model.DBData;
import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import com.smefinance.todoapp.operation.task_assign.service.TaskAssignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = DBData.CROSS_ORIGIN)
@Slf4j
public class TaskAssignController {

    @Autowired
    private TaskAssignService taskAssignService;

    //Done - param- {"":""}
    //Save a Task
    @PostMapping("/addTaskAssign2")
    public TaskAssignEntity addTaskAssign2(@RequestBody TaskAssignEntity taskAssignEntity) {
        return taskAssignService.saveTaskAssign2(taskAssignEntity);
    }

    //Done - param- {"":""}
    //Save a Task
    @PostMapping("/addTaskAssign")
    public MessageResponse addTaskAssign(@RequestBody TaskAssignEntity taskAssignEntity) {
        log.info("taskAssignEntity: "+taskAssignEntity);
        return taskAssignService.saveTaskAssign(taskAssignEntity);
    }



    //Done - param- [{"":""},{"":""}]
    //Save All Task As an array - multiple rows
    @PostMapping("/addAllTaskAssign")
    public List<TaskAssignEntity> addAllTaskAssign(@RequestBody List<TaskAssignEntity> taskAssignEntityes) {
        return taskAssignService.saveAllTaskAssign(taskAssignEntityes);
    }

    //Done- param-
    //get All Task //Done
    @GetMapping("/getAllTaskAssign")
    public List<TaskAssignEntity> findAllTaskAssign() {
        return taskAssignService.getTaskAssignList();
    }

    // Done- param id/serial- 14
   // get all Task by Id/Serial //Done
    @GetMapping("/getTaskAssignById/{id}")
    public TaskAssignEntity findTaskAssignById(@PathVariable Long id) {
        return taskAssignService.getTaskAssignById(id);
    }

    //Done- param-AdminUserId- 2
    //Get All Task By admin User Id
    @GetMapping("/getAllTaskByUserId/{adminUserId}")
    public  List<TaskAssignEntity> findAllTaskAssignByAdminUserId(@PathVariable String adminUserId) {
        return taskAssignService.getTaskAssignByAdminUserId(adminUserId);
    }


    //Done - param- [{"":""},{"":""}]
    //update All Task As an array - multiple rows
    @PutMapping("/updateAllTaskAssign")
    public List<TaskAssignEntity> updateAllTaskAssign(@RequestBody List<TaskAssignEntity> taskAssignEntityes) {
        return taskAssignService.saveAllTaskAssign(taskAssignEntityes);
    }


    //Done param-RequestBody- {"":""}
    //Update Task Assign
    @PutMapping("/updateTaskAssign")
    public MessageResponse updateTaskAssign(@RequestBody TaskAssignEntity taskAssignEntity) {
        log.info("updateTaskAssign: "+taskAssignEntity);
        return taskAssignService.updateTaskAssign(taskAssignEntity);
    }

    //Done - param -id/serial- 20
    //Delete Task Assign By Task ID
    @DeleteMapping("/deleteTaskById/{id}")
    public MessageResponse deleteTaskAssign(@PathVariable Long id) {
        return taskAssignService.deleteTaskAssign(id);
    }


}
