package com.smefinance.todoapp.common.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
//@Table(name="SYUSRMAS", schema = DBData.STSWIFT_SCHEMA)
public class SyUsrMasEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private String usercode;
    private String username;
    private String userpawd;
    private String paswdate;
    private String valdflag;
    private String statdate;
    private String divncode;
    private String emplcode;
    private String emplydob;
    private String usertype;
    private String grupcode;
    private String lastlogn;
    private String logincnt;
    private String invldcnt;
    private String startime;
    private String stoptime;
    private String telnumbr;
    private String address1;
    private String address2;
    private String address3;
    private String emailid1;
    private String emailid2;
    private String strtsusp;
    private String stopsusp;
    private String livelogn;
    private String maxmlogn;
    private String oprstamp;
    private String timstamp;
    private String migflg;
    private String supdat;
    private String supid1;
    private String chgflg;
    private String appflg;
    private String isgroup;
    private String idletime;
    private String userlevel;
    private String alwstelar;
    private String used_Ip_Addr;
    private String pwdexpdy;
    private String bank_Empcod;
    private String otpreq;
    private String onlusr;
    private String dept_Id;
    private String admin;

    public SyUsrMasEntity() {
    }

    public SyUsrMasEntity(String usercode, String username, String usertype, String grupcode, String emplcode) {
        this.usercode = usercode;
        this.username = username;
        this.usertype = usertype;
        this.grupcode = grupcode;
        this.emplcode = emplcode;
    }


}
