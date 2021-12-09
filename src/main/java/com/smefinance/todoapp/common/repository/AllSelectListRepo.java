package com.smefinance.todoapp.common.repository;

import com.smefinance.todoapp.common.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AllSelectListRepo extends JpaRepository<UsersEntity, BigInteger> {
    @Query(
            nativeQuery = true,
            value = "SELECT `id`, `name` FROM users "
    )
    List<Object[]> getAllUserDataListRepo();

    @Query(
            nativeQuery = true,
            value = "SELECT `priority_id`, `priority_name` FROM priority_setup "
    )
    List<Object[]> getAllPriorityDataListRepo();


    @Query(
            nativeQuery = true,
            value = "SELECT `task_status_id`, `task_status_name` FROM task_status_setup "
    )
    List<Object[]> getAllStatusDataListRepo();

}
