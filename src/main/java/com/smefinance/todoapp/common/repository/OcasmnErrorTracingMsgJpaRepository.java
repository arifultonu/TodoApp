package com.smefinance.todoapp.common.repository;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.model.entity.OcasmnErrorTracingMsgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OcasmnErrorTracingMsgJpaRepository extends JpaRepository<OcasmnErrorTracingMsgEntity, Long> {

    @Query(
            value = "SELECT new com.smefinance.todoapp.common.model.entity.OcasmnErrorTracingMsgEntity(v.errcod, v.errmsg) " +
                    "FROM OcasmnErrorTracingMsgEntity v " +
                    "WHERE v.userID = :#{#pv.userId} AND v.sessionID = :#{#pv.sessionId}"
    )
    OcasmnErrorTracingMsgEntity getErrorMsg(@Param("pv") Parameters pv);

}
