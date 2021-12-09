package com.smefinance.todoapp.common.service;

import com.smefinance.todoapp.common.model.CommonListValue;

import java.util.List;

public interface AllSelectListService {
    List<CommonListValue> getAllUserDataListRepo();
    List<CommonListValue> getAllPriorityDataListRepo();
    List<CommonListValue> getAllStatusDataListRepo();

}
