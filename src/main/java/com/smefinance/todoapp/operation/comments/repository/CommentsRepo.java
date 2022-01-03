package com.smefinance.todoapp.operation.comments.repository;

import com.smefinance.todoapp.operation.comments.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo extends JpaRepository<CommentsEntity, Long> {

}
