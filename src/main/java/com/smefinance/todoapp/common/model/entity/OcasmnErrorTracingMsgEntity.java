package com.smefinance.todoapp.common.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Table(name = "ERR_TRACING_MSG", schema = DBData.SBSTLBAS_SCHEMA)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcasmnErrorTracingMsgEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String userID = "";
    private String sessionID = "";
    private String errcod = "";
    private String errmsg = "";

    public OcasmnErrorTracingMsgEntity(String errcod, String errmsg){
        this.errcod = errcod;
        this.errmsg = errmsg;
    }
}
