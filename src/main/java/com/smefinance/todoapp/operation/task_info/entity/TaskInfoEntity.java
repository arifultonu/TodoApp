package com.smefinance.todoapp.operation.task_info.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_task_info")
public class TaskInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String taskId;
    private String taskDetails;
    private String dueDate;
    private String createDate;
    private String taskStatus;
    private String comments;
    private String priorityId;
}
