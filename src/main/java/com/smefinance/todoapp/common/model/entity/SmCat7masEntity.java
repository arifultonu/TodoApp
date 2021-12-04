package com.smefinance.todoapp.common.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "SM_CAT7MAS", schema = DBData.STSWIFT_SCHEMA)
public class SmCat7masEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String branchCode;
    private String messageType;
    private String documentNo;
    private String accountType;
    private String accountNumber;
    private String senderBic;
    private String recieverBic;
    private String customerCode;
    private String createBy;
    private String createDate;
    private String swiftDocnum;
    private String swiftStatus;
    private String macSwift;
    private String chkSwift;
    private String refSwift;
    private String updateBy;
    private String updateDate;

    public SmCat7masEntity(String documentNo, String accountNumber) {
        this.documentNo = documentNo;
        this.accountNumber = accountNumber;
    }
}
