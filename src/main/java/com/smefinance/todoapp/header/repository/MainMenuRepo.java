package com.smefinance.todoapp.header.repository;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.header.entity.MainMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainMenuRepo extends JpaRepository<MainMenuEntity, Long> {

//    @Query(
//            "SELECT new com.era.eswift.header.entity.MainMenuEntity(" +
//            "v.nodeid, v.parentid, v.nodename, v.url) FROM MainMenuEntity v " +
//            "ORDER BY v.parentid, v.nodeid ")

    @Query(
            nativeQuery = true,
            value ="SELECT PROGNAME nodeid, PARENTNM parentid, PROGDESC nodename, MENU_URL url " +
            "FROM SYMENTRE " +
            "WHERE PROGNAME IN " +
            "(SELECT PROGNAME FROM SYRIGHTS " +
            "WHERE UPPER (USERCODE) = UPPER (:#{#parameters.userId}) " +
            "AND NVL (APPSTATS, 'N') = 'A') " +
            "START WITH PARENTNM = 0 " +
            "CONNECT BY PRIOR PROGNAME = PARENTNM " +
            "ORDER SIBLINGS BY MENUSLNO "
    )
    List<Object[]> getMainMenu(@Param("parameters") Parameters parameters);

    @Query(
            nativeQuery = true,
            value ="SELECT DISTINCT a.COMPCODE branchCode, " +
                    "(SELECT BRANCH_NAME " +
                    "FROM SM_SENDER_BANK " +
                    "WHERE SWIFT_BRANCH = a.COMPCODE) branchName " +
                    "FROM SYRIGHTS a " +
                    "WHERE USERCODE = :#{#parameters.userId}"

    )
    List<Object[]> getBranchList(@Param("parameters") Parameters parameters);



}
