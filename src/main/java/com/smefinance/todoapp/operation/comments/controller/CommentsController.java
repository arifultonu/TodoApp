package com.smefinance.todoapp.operation.comments.controller;

import com.smefinance.todoapp.common.model.DBData;
import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.operation.comments.entity.CommentsEntity;
import com.smefinance.todoapp.operation.comments.service.CommentsService;
import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = DBData.CROSS_ORIGIN)
@Slf4j
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    //Save a Comments
    @PostMapping("/addComment")
    public MessageResponse addComment(@RequestBody CommentsEntity commentsEntity) {
        return commentsService.addComment(commentsEntity);
    }
}
