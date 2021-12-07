package com.smefinance.todoapp.operation.task_assign.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    private String adminUserId;
    private String assignUserId;
    private String taskId;
    private String taskDetails;
//    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date assignDate;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dueDate;

    private String priorityId;
    private String taskStatusId;
}
