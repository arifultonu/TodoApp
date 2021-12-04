package com.smefinance.todoapp.common.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "SYRIGHTS", schema = DBData.STSWIFT_SCHEMA)
public class SyRightsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String compcode;
    private String usercode;
    private String parentnm;
    private String progname;
    private String progdesc;
    private String modlcode;
    private String levlcode;
    private String menuslno;
    private String menuleaf;
    private String grupcode;
    private String addstats;
    private String modstats;
    private String delstats;
    private String enqstats;
    private String oprstamp;
    private String timstamp;
    private String appstats;
    private String apprvdate;
    private String apprvby;
    private String appflg;

    public SyRightsEntity(String compcode) {
        this.compcode = compcode;
    }
}
