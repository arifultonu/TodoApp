package com.smefinance.todoapp.common.service;


import com.smefinance.todoapp.common.model.CommonListValue;

import java.util.List;


public interface PendingDocumentListService {

//    public List<SmCat7masEntity> getPendingDocuments(){
//        return pendingDocumentListRepo.findAll();
//    }

    List<CommonListValue> getPendingDocNoList();

}
