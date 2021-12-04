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
//@Table(name = "SM_CAT7DTL_APP", schema = DBData.STSWIFT_SCHEMA)
public class SmCat7dtlAppEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String referenceId;
    private String cbsField;
    private String cbsValue;
    private String cbsFlag;
    private String createBy;
    private String createDate;
    private String approveStatus;
}
