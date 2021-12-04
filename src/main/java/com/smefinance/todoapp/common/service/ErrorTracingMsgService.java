package com.smefinance.todoapp.common.service;

import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.common.model.entity.EdmsErrorTracingMsgEntity;
import com.smefinance.todoapp.common.model.entity.OcasmnErrorTracingMsgEntity;

public interface ErrorTracingMsgService {
    OcasmnErrorTracingMsgEntity getOcasmnErrorMsg(Parameters pv);
    EdmsErrorTracingMsgEntity getErrorTracingMessage(Parameters pv);
}
