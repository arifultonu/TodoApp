package com.smefinance.todoapp.login.repository;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.model.entity.SyRightsEntity;
import com.smefinance.todoapp.common.model.entity.SyUsrMasEntity;
import com.smefinance.todoapp.login.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<SyUsrMasEntity, Long> {

    @Query("SELECT u.password FROM UsersEntity u WHERE u.userId = :userId")
    String findUserBySessionID(@Param("userId") String userId);

    @Query("SELECT u.username, u.userpawd FROM SyUsrMasEntity u WHERE u.usercode = :usercode")
    List<Object[]> getUser(@Param("usercode") String usercode);

    @Query("SELECT v.userName, v.userId, v.email " +
            "FROM UsersEntity v WHERE v.email = :#{#value.userId}"
    )
    UsersEntity gettUserInfo(@Param("value") Parameters value);

//    @Query("SELECT new com.era.eswift.common.model.entity.SyRightsEntity(v.compcode) " +
//            "FROM SyRightsEntity v WHERE v.usercode = :#{#value.userId}"
//    )

    @Query("SELECT DISTINCT v.compcode " +
            "FROM SyRightsEntity v WHERE v.usercode = :#{#value.userId}"
    )
    SyRightsEntity getUserBranchCode(@Param("value") Parameters value);


//    @Query(
//            nativeQuery = true,
//            value = "SELECT DISTINCT BRANCH_NAME brnname " +
//                    "FROM SM_SENDER_BANK " +
//                    "WHERE SWIFT_BRANCH = :#{#value.branchCode} "
//    )
//    SyRightsEntity getUserBranchName(@Param("value") Parameters value);


}
