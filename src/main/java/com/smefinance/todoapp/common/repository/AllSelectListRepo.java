package com.smefinance.todoapp.common.repository;


import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.model.entity.SmMtNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllSelectListRepo extends JpaRepository<SmMtNameEntity, Long> {
    @Query(
            nativeQuery = true,
            value = "SELECT '000', 'ALL' FROM DUAL " +
                    "UNION " +
                    "SELECT MESSAGE_TYPE, MESSAGE_TYPE || ' (' || MESSAGE_NAME || ')' " +
                    "FROM STSWIFT.SMMTNAME " +
                    "WHERE MESSAGE_TYPE LIKE '7%' " +
                    "ORDER BY 1 NULLS FIRST "
    )
    List<Object[]> getMessageTypeListRepo();

    @Query(
            nativeQuery = true,
            value = "SELECT '000', 'ALL' FROM DUAL " +
                    "UNION " +
                    "SELECT MESSAGE_TYPE, MESSAGE_TYPE || ' (' || MESSAGE_NAME || ')' " +
                    "FROM STSWIFT.SMMTNAME " +
                    "WHERE CBS_GENERATE = 'N' " +
                    "ORDER BY 1 NULLS FIRST "
    )
    List<Object[]> getMessageTypeListForMessageCreationRepo();


    @Query(
            nativeQuery = true,
            value = "SELECT HUB_CODE HUBCODE, HUB_CODE HUBDESC " +
                    "FROM SWHUBUSR A " +
                    "WHERE A.BRANCH_CODE =:#{#parameters.branchCode}  " +
                    "AND A.BRANCH_USER = :#{#parameters.userId}  "

    )
    List<Object[]> getHubDataListRepo(@Param("parameters") Parameters parameters);

    @Query(
            nativeQuery = true,
            value = "SELECT B.SOFCOD BRANCH, B.CODDES BRANCH_DESC " +
                    "FROM SM_CODMAS B " +
                    "WHERE B.HARCOD = :#{#parameters.hubType} "

    )
    List<Object[]> getBranchDataListRepo(@Param("parameters") Parameters parameters);

    @Query(
            nativeQuery = true,
            value = "SELECT A.CORRESPONDENT_ID VALFORDB, " +
                    "A.CORRESPONDENT_ID || '-' || A.CORRESPONDENT_NAME DISPLAY " +
                    "FROM SMBNKRMA A " +
                    " WHERE A.SENDING_STATUS = 'Enabled' "

    )
    List<Object[]> getReceiverDataListRepo();


    @Query(
            nativeQuery = true,
            value = "SELECT CURRENCY_CODE, CURRENCY_NAME, " +
                    "FROM SMCURRENCY A " +
                    "WHERE A.ACTIVE_FLAG = 'Y' "
    )
    List<Object[]> getCurCodeDataListRepo();

    @Query(
            nativeQuery = true,
            value = "SELECT CODE_NAME CODE, CODE_NAME, " +
                    "FROM SMVALCOD " +
                    "WHERE MESSAGE_TYPE=:#{#parameters.messageType} " +
                    "AND CODE_VALIDITY_ID=:#{#parameters.tag} "
    )
    List<Object[]> getCodCodeDataListRepo();

    @Query(
            nativeQuery = true,
            value = "SELECT a.USERCODE, a.USERNAME " +
                    "FROM SYUSRMAS a "

    )
    List<Object[]> getUserDataListRepo();


//++For Message Creation Pages ++//
    //   Cur---------
//    SELECT CURRENCY_CODE, CURRENCY_NAME
//    FROM SMCURRENCY A
//    WHERE A.ACTIVE_FLAG = 'Y'
//
//    Cod--------
//    SELECT CODE_NAME CODE,CODE_NAME
//    FROM SMVALCOD
//    WHERE MESSAGE_TYPE=:UIFILEDNAME
//    AND CODE_VALIDITY_ID=:UITAG

    //Bic ---
//Query Not Ready


}



