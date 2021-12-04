package com.smefinance.todoapp.common.repository;

import com.smefinance.todoapp.common.model.CommonListValue;
import com.smefinance.todoapp.common.model.entity.SmCat7masEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PendingDocumentListRepo extends JpaRepository<SmCat7masEntity, Long> {

    @Query(
            value = "SELECT new com.smefinance.todoapp.common.model.CommonListValue(v.documentNo, v.accountNumber) " +
                    "FROM SmCat7masEntity v "
                    //+ "WHERE v.compCode = :#{#parameters.companyCode} AND v.harcod = :#{#parameters.harCod} " +
                   // "ORDER BY v.sernum"
    )
    List<CommonListValue> getPendingDocNoList();

}
