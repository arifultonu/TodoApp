package com.smefinance.todoapp.setup.repository;

import com.smefinance.todoapp.setup.entity.SetupPriorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetupPriorityRepo extends JpaRepository<SetupPriorityEntity, Long> {

}
