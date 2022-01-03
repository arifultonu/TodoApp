package com.smefinance.todoapp.operation.comments.service;

import com.smefinance.todoapp.common.model.MessageResponse;
import com.smefinance.todoapp.operation.comments.entity.CommentsEntity;
import com.smefinance.todoapp.operation.comments.repository.CommentsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommentsRepo commentsRepo;

    @Override
    public MessageResponse addComment(CommentsEntity commentsEntity) {
        MessageResponse messageResponse = new MessageResponse();

        log.info("Assign User Id: "+commentsEntity.getAssignUserId());

        commentsRepo.save(commentsEntity);
        messageResponse.setResponseCode("1");
        messageResponse.setResponseMessage("Add Comment Successfully!");
        return messageResponse;
    }
}
