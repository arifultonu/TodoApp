package com.smefinance.todoapp.operation.task_info.repository;

import com.smefinance.todoapp.operation.task_info.entity.TaskInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskInfoRepo extends JpaRepository<TaskInfoEntity, Long> {
    List<TaskInfoEntity> findByUserId(Long userId);
}
