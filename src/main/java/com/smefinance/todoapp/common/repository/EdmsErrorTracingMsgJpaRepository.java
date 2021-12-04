package com.smefinance.todoapp.common.repository;


import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.model.entity.EdmsErrorTracingMsgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdmsErrorTracingMsgJpaRepository extends JpaRepository<EdmsErrorTracingMsgEntity, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT ERRCOD, ERRMSG " +
                    "FROM EDMS.ERR_TRACING_MSG " +
                    "WHERE COMP_CODE = :#{#value.companyCode} AND " +
                    "USERID = :#{#value.userId} AND " +
                    "SESSIONID = :#{#value.sessionId} " +
                    "AND SERNUM = (SELECT MAX (SERNUM) " +
                    "FROM EDMS.ERR_TRACING_MSG " +
                    "WHERE COMP_CODE = :#{#value.companyCode} AND " +
                    "USERID = :#{#value.userId} AND " +
                    "SESSIONID = :#{#value.sessionId})"
    )
    List<Object[]> getErrorTracingMessage(@Param("value") Parameters value);

}
