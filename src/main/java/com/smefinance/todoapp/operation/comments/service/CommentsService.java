package com.smefinance.todoapp.operation.comments.service;

import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.operation.comments.entity.CommentsEntity;


public interface CommentsService {
    MessageResponse addComment(CommentsEntity commentsEntity);
}
