package com.smefinance.todoapp.common.service;

import com.smefinance.todoapp.common.model.CommonListValue;
import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.repository.AllSelectListRepo;
import com.smefinance.todoapp.common.service.AllSelectListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllSelectListServiceImpl implements AllSelectListService {

    @Autowired
    private AllSelectListRepo messageTypeListRepo;

    @Override
    public List<CommonListValue> getMessageTypeList() {
        List<Object[]> list = messageTypeListRepo.getMessageTypeListRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue((String) arr[0]);
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }

    @Override
    public List<CommonListValue> getMessageTypeListForMessageCreation() {
        List<Object[]> list = messageTypeListRepo.getMessageTypeListForMessageCreationRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue((String) arr[0]);
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }

    @Override
    public List<CommonListValue> getHubDataListRepo(Parameters parameters) {
        List<Object[]> list = messageTypeListRepo.getHubDataListRepo(parameters);
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue((String) arr[0]);
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }

    @Override
    public List<CommonListValue> getBranchDataListRepo(Parameters parameters) {
        List<Object[]> list = messageTypeListRepo.getBranchDataListRepo(parameters);
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue((String) arr[0]);
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }

    @Override
    public List<CommonListValue> getReceiverDataListRepo() {
        List<Object[]> list = messageTypeListRepo.getReceiverDataListRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue((String) arr[0]);
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }


    @Override
    public List<CommonListValue> getCurCodeDataListRepo() {
        List<Object[]> list = messageTypeListRepo.getCurCodeDataListRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue((String) arr[0]);
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }

    @Override
    public List<CommonListValue> getCodCodeDataListRepo() {
        List<Object[]> list = messageTypeListRepo.getCodCodeDataListRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue((String) arr[0]);
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }

    @Override
    public List<CommonListValue> getUserDataListRepo() {
        List<Object[]> list = messageTypeListRepo.getUserDataListRepo();
        List<CommonListValue> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            CommonListValue obj = new CommonListValue();
            obj.setValue((String) arr[0]);
            obj.setLabel((String) arr[1]);
            list1.add(obj);
        });
        return list1;
    }

//    @Override
//    public List<CommonListValue> getBranchDataListRepo(Parameters parameters) {
//        List<Object[]> list = messageTypeListRepo.getBranchDataListRepo(parameters);
//        List<CommonListValue> list1 = new ArrayList<>();
//        list.stream().forEach(arr -> {
//            CommonListValue obj = new CommonListValue();
//            obj.setValue((String) arr[0]);
//            obj.setLabel((String) arr[1]);
//            list1.add(obj);
//        });
//        return list1;
//    }


}
