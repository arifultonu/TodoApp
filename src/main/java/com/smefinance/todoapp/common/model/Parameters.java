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



    private List arrayList = new ArrayList();

}
