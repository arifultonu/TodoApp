package com.smefinance.todoapp.common.service;

import com.smefinance.todoapp.common.model.CommonListValue;
import com.smefinance.todoapp.common.repository.AllSelectListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AllSelectListServiceImpl implements AllSelectListService {

    @Autowired
    AllSelectListRepo allSelectListRepo;

    @Override
    public List<CommonListValue> getAllUserDataListRepo() {
        List<Object[]> list = allSelectListRepo.getAllUserDataListRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue(toString().valueOf(arr[0]));
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }

    @Override
    public List<CommonListValue> getAllPriorityDataListRepo() {
        List<Object[]> list = allSelectListRepo.getAllPriorityDataListRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue(toString().valueOf(arr[0]));
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }


    @Override
    public List<CommonListValue> getAllStatusDataListRepo() {
        List<Object[]> list = allSelectListRepo.getAllStatusDataListRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue(toString().valueOf(arr[0]));
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }


}
