package com.smefinance.todoapp.header.service;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.header.entity.MainMenuEntity;
import com.smefinance.todoapp.header.repository.MainMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainMenuServiceImpl implements MainMenuService{

@Autowired
    private MainMenuRepo mainMenuRepo;

//    @Override
//    public List<MainMenuEntity> getMainMenu(Parameters parameters) {
//        return mainMenuRepo.getMainMenu(parameters);
//    }

    @Override
    public List<MainMenuEntity> getMainMenu(Parameters parameters) {
        List<Object[]> list = mainMenuRepo.getMainMenu(parameters);
        List<MainMenuEntity> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            MainMenuEntity obj = new MainMenuEntity();
            obj.setNodeid((String) arr[0]);
            obj.setParentid((String) arr[1]);
            obj.setNodename((String) arr[2]);
            obj.setUrl((String) arr[3]);
            list1.add(obj);
        });
        return list1;
    }

// @Override
//    public List<MainMenuEntity> getBranchList(Parameters parameters) {
//        List<Object[]> list = mainMenuRepo.getBranchList(parameters);
//        List<MainMenuEntity> list1 = new ArrayList<>();
//        list.stream().forEach(arr -> {
//            MainMenuEntity obj = new MainMenuEntity();
//            obj.setBranchCode((String) arr[0]);
//            obj.setBranchName((String) arr[1]);
//            list1.add(obj);
//        });
//        return list1;
//    }

    @Override
    public List<MainMenuEntity> getBranchList(Parameters parameters) {
        List<Object[]> list = mainMenuRepo.getBranchList(parameters);
        List<MainMenuEntity> list1 = new ArrayList<>();
        list.stream().forEach(arr -> {
            parameters.setBranchName((String) arr[1]);
        });
        return list1;
    }

//    @Override
//    public List<DashboardEntity> getTotalNumberOfIncomingMessage(Parameters parameters) {
//        List<Object[]> list = dashboardRepo.getTotalNumberOfIncomingMessage(parameters);
//        List<DashboardEntity> list1 = new ArrayList<>();
//        list.stream().forEach(arr -> {
//            parameters.setTotalIncomingMessage((Number) arr[0]);
//        });
//        return list1;
//    }


}
