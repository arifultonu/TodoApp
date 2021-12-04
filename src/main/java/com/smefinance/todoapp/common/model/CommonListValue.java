package com.smefinance.todoapp.common.model;

import lombok.Data;

@Data
public class CommonListValue {
    private String value;
    private String label;

    public CommonListValue(){
        
    }

    public CommonListValue(String value, String label){
        this.value = value;
        this.label = value + " - " + label;
    }
}
