package com.smefinance.todoapp.setup.repository;

import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import com.smefinance.todoapp.setup.entity.SetupUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SetupUserRepo extends JpaRepository<SetupUserEntity, Long> {
//    @Query("select id, username, password from ")
//List<SetupUserEntity> getAllUserList(String username);
}
