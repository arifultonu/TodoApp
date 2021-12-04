package com.smefinance.todoapp.common.service;

import com.smefinance.todoapp.common.model.CommonListValue;
import com.smefinance.todoapp.common.repository.PendingDocumentListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PendingDocumentListServiceImpl implements PendingDocumentListService{

    @Autowired
    PendingDocumentListRepo pendingDocumentListRepo;

    @Override
    public List<CommonListValue> getPendingDocNoList() {
        return pendingDocumentListRepo.getPendingDocNoList();
    }
}
