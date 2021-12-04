package com.smefinance.todoapp.common.service;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.model.entity.EdmsErrorTracingMsgEntity;
import com.smefinance.todoapp.common.model.entity.OcasmnErrorTracingMsgEntity;
import com.smefinance.todoapp.common.repository.EdmsErrorTracingMsgJpaRepository;
import com.smefinance.todoapp.common.repository.OcasmnErrorTracingMsgJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorTracingMsgServiceImpl implements ErrorTracingMsgService {

    @Autowired
    private OcasmnErrorTracingMsgJpaRepository oOcasmnErrorTracingMsgJpaRepository;

    @Autowired
    private EdmsErrorTracingMsgJpaRepository oEdmsErrorTracingMsgJpaRepository;

    @Override
    public OcasmnErrorTracingMsgEntity getOcasmnErrorMsg(Parameters pv) {
        return oOcasmnErrorTracingMsgJpaRepository.getErrorMsg(pv);
    }

    @Override
    public EdmsErrorTracingMsgEntity getErrorTracingMessage(Parameters pv) {
        List<Object[]> objList = oEdmsErrorTracingMsgJpaRepository.getErrorTracingMessage(pv);
        EdmsErrorTracingMsgEntity obj = new EdmsErrorTracingMsgEntity();
        objList.stream().forEach(arr -> {
            obj.setErrcod(String.valueOf(arr[0]));
            String msg = (String)arr[1];
            msg = msg.replace("<b>", "").replace("</b>", "");
            obj.setErrmsg(msg);
        });
        return obj;
    }
}
