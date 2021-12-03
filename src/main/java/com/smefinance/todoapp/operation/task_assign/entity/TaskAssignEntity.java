package com.smefinance.todoapp.operation.task_assign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task_create_assign")
public class TaskAssignEntity {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private int adminUserId;
    private int assignUserId;
    private int taskId;
    private String taskDetails;
    private Date assignDate;
    private Date dueDate;
    private int priorityId;
    private int taskStatusId;
}
