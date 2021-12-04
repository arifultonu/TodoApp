package com.smefinance.todoapp.common.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "SMMTNAME", schema = DBData.STSWIFT_SCHEMA)
public class SmMtNameEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String categoryId;
    private String messageType;
    private String messageName;
    private String messagePurpose;
    private String signed;
    private String maxLength;
    private String userGroup;
    private String valdato;
    private String createBy;
    private String createDate;
    private String updateBy;
    private String updateTime;
    private String mtExtension;

    public SmMtNameEntity(String messageType, String messageName) {
        this.messageType = messageType;
        this.messageName = messageName;
    }
}
