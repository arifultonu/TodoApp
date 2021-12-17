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
@Table(name = "task_status_setup")
public class SetupTaskStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long taskStatusId;

    private String taskStatusName;
}
