package com.smefinance.todoapp.operation.task_assign.repository;

import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskAssignRepo extends JpaRepository<TaskAssignEntity, Long> {

    List<TaskAssignEntity> findByAdminUserId(int adminUserId);

}
