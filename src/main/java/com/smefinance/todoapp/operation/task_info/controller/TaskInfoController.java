package com.smefinance.todoapp.operation.task_info.controller;

import com.smefinance.todoapp.operation.task_info.entity.TaskInfoEntity;
import com.smefinance.todoapp.operation.task_info.service.TaskInfoService;
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
public class TaskInfoController {

    @Autowired
    private TaskInfoService taskInfoService;

    @PostMapping("/addTaskInfo")
    public TaskInfoEntity addTaskInfo(@RequestBody TaskInfoEntity taskInfoEntity) {
        return taskInfoService.saveTaskInfo(taskInfoEntity);
    }

    @PostMapping("/addAllTaskInfo")
    public List<TaskInfoEntity> addAllTaskInfo(@RequestBody List<TaskInfoEntity> taskInfoEntityes) {
        return taskInfoService.saveAllTaskInfo(taskInfoEntityes);
    }

    @GetMapping("/getAllTaskInfo")
    public List<TaskInfoEntity> findAllTaskInfo() {
        return taskInfoService.getTaskInfoList();
    }

    @GetMapping("/getTaskInfoById/{id}")
    public TaskInfoEntity findTaskInfoById(@PathVariable Long id) {
        return taskInfoService.getTaskInfoById(id);
    }

    @GetMapping("/getAllTaskInfoByUserId/{userId}")
    public List<TaskInfoEntity> findAllTaskInfoByUserId(Long userId) {
        return taskInfoService.getTaskInfoByUserId(userId);
    }

    @PutMapping("/updateTaskInfo")
    public TaskInfoEntity updateTaskInfo(@RequestBody TaskInfoEntity taskInfoEntity) {
        return taskInfoService.updateTaskInfo(taskInfoEntity);
    }

    //Delete Task Info By Task ID
    @DeleteMapping("/deleteTaskInfo/{taskId}")
    public String deleteTaskInfo(@PathVariable Long taskId) {
        return taskInfoService.deleteTaskInfo(taskId);
    }

    //Test API
    @GetMapping("/hello")
    public Collection<String> getHelloRestApi() {
        log.info("Hello Called!");
        return IntStream.range(0, 10)
                .mapToObj(i -> "Hello number " + i)
                .collect(Collectors.toList());
    }


}
