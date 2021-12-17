package com.smefinance.todoapp.setup.controller;

import com.smefinance.todoapp.common.model.DBData;
import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.setup.entity.SetupTaskStatusEntity;
import com.smefinance.todoapp.setup.service.SetupTaskStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = DBData.CROSS_ORIGIN)
@Slf4j
public class SetupTaskStatusController {

    @Autowired
    private SetupTaskStatusService setupTaskStatusService;

    //Done - param- {"":""}
    //Save a TaskStatus
    @PostMapping("/addTaskStatus")
    public MessageResponse addPriority(@RequestBody SetupTaskStatusEntity setupTaskStatusEntity) {
        return setupTaskStatusService.addTaskStatus(setupTaskStatusEntity);
    }

    //Done- param-
    //get All Priority //Done
    @GetMapping("/getAllTaskStatus")
    public List<SetupTaskStatusEntity> findAllTaskStatus() {
        return setupTaskStatusService.getAllTaskStatusList();
    }

    //Done param-RequestBody- {"":""}
    //Update Priority
    @PutMapping("/updateTaskStatus")
    public MessageResponse updateTaskStatus(@RequestBody SetupTaskStatusEntity setupTaskStatusEntity) {
        return setupTaskStatusService.updateTaskStatus(setupTaskStatusEntity);
    }

    //Done -
    //Delete Task Status  By Task Status ID
    @DeleteMapping("/deleteTaskStatusById/{id}")
    public MessageResponse deleteTaskStatus(@PathVariable Long id) {
        return setupTaskStatusService.deleteTaskStatus(id);
    }


}
