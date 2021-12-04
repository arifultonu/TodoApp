package com.smefinance.todoapp.header.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Table(name = "MAINMENU", schema = DBData.STSWIFT_SCHEMA)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainMenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nodeid;
    private String parentid;
    private String nodename;
    private String url;
    private String branchCode;
    private String branchName;

    public MainMenuEntity(String nodeid, String parentid, String nodename, String url){
        this.nodeid = nodeid;
        this.parentid = parentid;
        this.nodename = nodename;
        this.url = url;
    }

    public MainMenuEntity(String branchCode, String branchName) {
        this.branchCode = branchCode;
        this.branchName = branchName;
    }
}
