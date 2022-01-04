package com.smefinance.todoapp.operation.comments.service;

import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.operation.comments.entity.CommentsEntity;

import java.util.List;


public interface CommentsService {
    MessageResponse addComment(CommentsEntity commentsEntity);
    List<CommentsEntity> getCommentsByTaskId(String taskId);
}
