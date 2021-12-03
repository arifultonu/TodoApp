package com.smefinance.todoapp.operation.task_info.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_task_info")
public class TaskInfoEntity {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String userTaskInfo;
    private String userId;
    private String taskId;
    private String taskDetails;
    private String dueDate;
    private String createDate;
    private String taskStatus;
    private String comments;
}
