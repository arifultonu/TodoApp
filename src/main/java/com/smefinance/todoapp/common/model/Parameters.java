package com.smefinance.todoapp.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameters {
    private String sernum;
    //private String companyCode;
    private String companyId;
    private String userId;
    private String sessionId;
    private String errorMessage;
    private String errorCode;
    private String customerId;
    //private String customerCode;
    private String customerName;
    private String applicationId;
    private String password;
    private String internalCardID;
    private String physicalAddressServer;
    private String physicalAddressClient;
    private String remoteIpAddress;
    private String lockFlag;
    private String lockTime;
    private String atempTime;


    // Params For CbsDataMessageCreation
    private String branchCode;
    private String messageType;
    private String messageTag;
    private String referenceId;

    private String cbsField;
    private String sourceData;
    private String sourceFlag;
    private String cbsValue;
    private String swiftValue;
    private String promts;
    private String documentNo;

    private String swiftStatus;
    private Number totalOutGoingMessage;
    private Number totalIncomingMessage;

    private String remarks;
    private String modifyBy;
    //    private String modifyDate;
    private String approveStatus;
    private Number noOfCbsFlag1;

    private String modAuthFlag;
    private String hubType;
    private String receiverCode;
    private String receiverExpansion;
    private String senderInstitution;
    private String senderExpansion;
    private String accountType;
    private String macSwift;
    private String chkSwift;
    private String refSwift;
    private String sysDate;
    //private String updateBy;
    private String accountNo;
    private String cbsFlag;
    private String message;

    private String branchType;
    private String senderBic;
    //    private String createBy;
//    private String createDate;
    private String swiftDocnum;
    private String accountNumber;
    private String msgInOut;
    private String receiverBic;
    private String messageReferenceNo;

    //User Id Creation
    private String userCode;
    private String userName;
    private String userPawd;
    private String paswDate;
    private String valdFlag;
    private String usrStatus;
    private String statusDate;
    private String divnCode;
    private String empCode;
    private String empDob;
    private String userType;
    private String userGrp;
    private String addRess1;
    private String tellNumber;
    private String starTime;
    private String stopTime;
    private String oprStamp;
    private String timStamp;
    private String emailId;
    private String statDate;


    private String passLength;
    private String passDiff;
    private String alphaChar;
    private String numChar;
    private String punctChar;
    private String upCaseChar;
    private String lowCaseChar;
    private String usrName;
    private String wordList;
    private String punctCharList;
    private String passExpDate;
    private String passNotifyDay;
    private String passExpMinDay;
    private String effDate;
    private String expDate;

    private String parentCode;
    private String menuCode;
    private String selectedUserId;

    private String chkunchk;
    private String branchName;

    private List arrayList = new ArrayList();

}
