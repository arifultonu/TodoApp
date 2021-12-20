package com.smefinance.todoapp.setup.repository;

import com.smefinance.todoapp.setup.entity.SetupUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetupUserRepo extends JpaRepository<SetupUserEntity, Long> {
}
