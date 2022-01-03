package com.smefinance.todoapp.operation.task_assign.repository;

import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAssignRepo extends JpaRepository<TaskAssignEntity, Long> {
    List<TaskAssignEntity> findByAdminUserIdOrderByPriorityIdAsc(String adminUserId);
    List<TaskAssignEntity> findByAssignUserIdOrderByPriorityIdAsc(String assignUserId);

}
