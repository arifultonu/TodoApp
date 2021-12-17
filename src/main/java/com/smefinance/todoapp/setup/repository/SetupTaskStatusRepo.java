package com.smefinance.todoapp.setup.repository;

import com.smefinance.todoapp.setup.entity.SetupTaskStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetupTaskStatusRepo extends JpaRepository<SetupTaskStatusEntity, Long> {

}
