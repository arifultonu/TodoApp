package com.smefinance.todoapp.operation.comments.repository;

import com.smefinance.todoapp.operation.comments.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepo extends JpaRepository<CommentsEntity, Long> {
    List<CommentsEntity> findByTaskIdOrderByDateAsc(String taskId);
    List<CommentsEntity> deleteCommentByTaskId(String taskId);

}
