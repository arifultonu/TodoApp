package com.smefinance.todoapp.setup.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "priority_setup")
public class SetupPriorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long priorityId;

    private String priorityName;

}
