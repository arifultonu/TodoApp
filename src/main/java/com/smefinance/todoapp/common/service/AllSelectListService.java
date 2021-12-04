package com.smefinance.todoapp.common.service;

import com.smefinance.todoapp.common.model.CommonListValue;
import com.smefinance.todoapp.common.model.Parameters;

import java.util.List;

public interface AllSelectListService {

    List<CommonListValue> getMessageTypeList();
    List<CommonListValue> getMessageTypeListForMessageCreation();
    List<CommonListValue> getHubDataListRepo(Parameters parameters);
    List<CommonListValue> getBranchDataListRepo(Parameters parameters);
    List<CommonListValue> getReceiverDataListRepo();
    List<CommonListValue> getCurCodeDataListRepo();
    List<CommonListValue> getCodCodeDataListRepo();
    List<CommonListValue> getUserDataListRepo();


}










//    public List<SmMtNameEntity> getSmMtNameEntityes() {
//        return messageTypeListRepo.findAll();
//    }

//
//    public SmMtNameEntity saveSmMtNameData(SmMtNameEntity smMtNameEntity) {
//        return messageTypeListRepo.save(smMtNameEntity);
//    }
//
//    public List<SmMtNameEntity> saveAllSmMtNameData(List<SmMtNameEntity> smMtNameEntityes) {
//        return messageTypeListRepo.saveAll(smMtNameEntityes);
//    }
//
//    public SmMtNameEntity getSmMtNameEntityById(Long id) {
//        return messageTypeListRepo.findById(id).orElse(null);
//    }
//
//    public SmMtNameEntity getSmMtNameEntityByMessageName(String messageName) {
//        return messageTypeListRepo.findByMessageName(messageName);
//    }
//
//    public String deleteSmMtNameEntity(Long id) {
//        messageTypeListRepo.deleteById(id);
//        return "SmMtName removed !! " + id;
//    }
//
//    public SmMtNameEntity updateSmMtNameEntity(SmMtNameEntity smMtNameEntity) {
//        SmMtNameEntity existingSmMtName = messageTypeListRepo.findById(smMtNameEntity.getId()).orElse(null);
//        existingSmMtName.setCategoryId(smMtNameEntity.getCategoryId());
//        existingSmMtName.setMessageName(smMtNameEntity.getMessageName());
//        existingSmMtName.setMessageType(smMtNameEntity.getMessageType());
//        return messageTypeListRepo.save(existingSmMtName);
//    }

