package com.smefinance.todoapp.common.model.procedure;

import com.smefinance.todoapp.common.model.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Optional;

@Service
@Slf4j
public class CbsDataMessageCreationPro {

    @Autowired
    private EntityManager oEntityManager;

    public Parameters dprContentUicheckPro(Parameters parameters) {
        StoredProcedureQuery storedProcedureQuery = oEntityManager.createStoredProcedureQuery("STSWIFT.DPK_SWTCOM_VALIDATION.DPR_CONTENT_UICHECK");
        storedProcedureQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);

        log.info("parameters.getMessageType(): "+parameters.getMessageType());
        log.info("parameters.getCbsField(): "+parameters.getCbsField());
        log.info("parameters.getCbsValue(): "+parameters.getCbsValue());

        storedProcedureQuery.setParameter(0, Optional.ofNullable(parameters.getMessageType()).orElse(""));
        storedProcedureQuery.setParameter(1, Optional.ofNullable(parameters.getCbsField()).orElse(""));
        storedProcedureQuery.setParameter(2, Optional.ofNullable(parameters.getCbsValue()).orElse(""));

        storedProcedureQuery.execute();
        Parameters returnObj = new Parameters();
        log.info("storedProcedureQueryOut.setSourceData: "+(String) storedProcedureQuery.getOutputParameterValue(3));
        log.info("storedProcedureQueryOut.setSourceFlag: "+(String) storedProcedureQuery.getOutputParameterValue(4));
        returnObj.setSourceData((String) storedProcedureQuery.getOutputParameterValue(3));
        returnObj.setSourceFlag((String) storedProcedureQuery.getOutputParameterValue(4));
        return returnObj;
    }

    public Parameters dprCat7DtlAppUiupdatePro(Parameters parameters) {
        StoredProcedureQuery storedProcedureQuery = oEntityManager.createStoredProcedureQuery("STSWIFT.DPK_TABDATA_UPDATE.DPR_CAT7DTL_APP_UIUPDATE");
        storedProcedureQuery.registerStoredProcedureParameter(0, String.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.INOUT);

        storedProcedureQuery.setParameter(0, Optional.ofNullable(parameters.getDocumentNo()).orElse(""));
        storedProcedureQuery.setParameter(1, Optional.ofNullable(parameters.getCbsField()).orElse(""));
        storedProcedureQuery.setParameter(2, Optional.ofNullable(parameters.getCbsValue()).orElse(""));

        storedProcedureQuery.execute();
        Parameters returnObj = new Parameters();
        returnObj.setReferenceId((String) storedProcedureQuery.getOutputParameterValue(0));
        returnObj.setCbsValue((String) storedProcedureQuery.getOutputParameterValue(2));
        return returnObj;
    }


}
