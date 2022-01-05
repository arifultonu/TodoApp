package com.smefinance.todoapp;

import com.smefinance.todoapp.operation.comments.entity.CommentsEntity;
import com.smefinance.todoapp.operation.comments.repository.CommentsRepo;
import com.smefinance.todoapp.operation.comments.service.CommentsService;
import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import com.smefinance.todoapp.operation.task_assign.repository.TaskAssignRepo;
import com.smefinance.todoapp.setup.entity.SetupPriorityEntity;
import com.smefinance.todoapp.setup.entity.SetupTaskStatusEntity;
import com.smefinance.todoapp.setup.entity.SetupUserEntity;
import com.smefinance.todoapp.setup.repository.SetupPriorityRepo;
import com.smefinance.todoapp.setup.repository.SetupTaskStatusRepo;
import com.smefinance.todoapp.setup.repository.SetupUserRepo;
import com.smefinance.todoapp.setup.service.SetupPriorityService;
import com.smefinance.todoapp.setup.service.SetupTaskStatusService;
import com.smefinance.todoapp.setup.service.SetupUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoappApplicationTests {

    @Autowired
    private TaskAssignRepo taskAssignRepo;

    ////========Task========////
    //Add New Task
    @Test
    @Order(1)
    @Rollback(value = false)
    void saveTask() {
        TaskAssignEntity taskAssignEntity = TaskAssignEntity.builder()
                .adminUserId("1")
                .assignUserId("2")
                .taskId(2)
                .taskDetails("Test Junit intrigation")
                .assignDate("10-12-2121")
                .dueDate("20-12-2121")
                .priorityId("1")
                .taskStatusId("1")
                .build();

        taskAssignRepo.save(taskAssignEntity);
        Assertions.assertThat(taskAssignEntity.getId()).isGreaterThan(0);
    }

    //Get Task by id
    @Test
    @Order(2)
    public void getTaskById() {
        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(15L).get();
        Assertions.assertThat(taskAssignEntity.getId()).isEqualTo(15L);
    }

    //Get Task by user id
    @Test
    @Order(3)
    public void getAllTaskByUserId() {
        List<TaskAssignEntity> taskAssignEntity = taskAssignRepo.findAll();
        Assertions.assertThat(taskAssignEntity.size()).isGreaterThan(0);
    }

    //Update Task
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateTask() {
        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(15L).get();
        taskAssignEntity.setTaskStatusId("3");
        TaskAssignEntity taskAssignEntityUpdated = taskAssignRepo.save(taskAssignEntity);
        Assertions.assertThat(taskAssignEntityUpdated.getTaskStatusId()).isEqualTo("3");
    }


    //Delete Task By Id
//    @Test
//    @Order(6)
//    @Rollback(value = false)
//    public void deleteById() {
//        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(15L).get();
//        taskAssignRepo.deleteById(15L);
//        TaskAssignEntity taskAssignEntity1 = null;
//        Optional<TaskAssignEntity> optionalTaskAssignEntity = taskAssignRepo.findById(15L);
//        if (optionalTaskAssignEntity.isPresent()) {
//            taskAssignEntity1 = optionalTaskAssignEntity.get();
//        }
//        Assertions.assertThat(taskAssignEntity1).isNull();
//    }

    //Get All Task By User Id
    @Test
    @Order(5)
    public void getAllTaskByAdminUserId() {
        List<TaskAssignEntity> taskAssignEntity = taskAssignRepo.findByAdminUserIdOrderByPriorityIdAsc("2");
        Assertions.assertThat(taskAssignEntity.size()).isGreaterThan(0);
    }


    //Update Task Status by Id
    @Test
    @Order(6)
    @Rollback(value = false)
    public void updateTaskById() {
        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(15L).get();
        taskAssignEntity.setTaskStatusId("2");
        TaskAssignEntity taskAssignEntityUpdated = taskAssignRepo.save(taskAssignEntity);
        Assertions.assertThat(taskAssignEntityUpdated.getTaskStatusId()).isEqualTo("2");
    }


////========Comments=======////

    @Autowired
    private CommentsRepo commentsRepo;


    // Add New Comment against a task
    @Test
    @Order(7)
    @Rollback(value = false)
    void saveComment() {
        CommentsEntity commentsEntity = CommentsEntity.builder()
                .taskId("2")
                .assignUserId("2")
                .comments("Test comment from unit test")
                .date("11-12-2022")
                .build();
        commentsRepo.save(commentsEntity);
        Assertions.assertThat(commentsEntity.getId()).isGreaterThan(0);
    }

    //Find all comments
    @Test
    @Order(8)
    public void getAllCommentByTaskId() {
        List<CommentsEntity> commentsEntity = commentsRepo.findAll();
        Assertions.assertThat(commentsEntity.size()).isGreaterThan(0);
    }

    //Find comments by Id
    @Test
    @Order(9)
    public void getCommentById() {
        CommentsEntity commentsEntity = commentsRepo.findById(94L).get();
        Assertions.assertThat(commentsEntity.getId()).isEqualTo(94L);
    }

    //Delete Comment By Id
    @Test
    @Order(10)
    @Rollback(value = false)
    public void deleteCommentById() {
        CommentsEntity commentsEntity = commentsRepo.findById(94L).get();
        commentsRepo.deleteById(94L);
        CommentsEntity commentsEntity1 = null;
        Optional<CommentsEntity> optionalCommentsEntity1 = commentsRepo.findById(94L);
        if (optionalCommentsEntity1.isPresent()) {
            commentsEntity1 = optionalCommentsEntity1.get();
        }
        Assertions.assertThat(commentsEntity1).isNull();
    }


    ////=====Setup User====////
    @Autowired
    private SetupUserRepo setupUserRepo;

    // Add/Registration New User
    //Email and User name must be unique
    @Test
    @Order(11)
    @Rollback(value = false)
    void addUser() {
        SetupUserEntity setupUserEntity = SetupUserEntity.builder()
                .email("avaldas3433@gmail.com")
                .name("Avaldas Taylas")
                .password("123456")
                .username("avaldas33")
                .role("Admin")
                .build();
        setupUserRepo.save(setupUserEntity);
        Assertions.assertThat(setupUserEntity.getId()).isGreaterThan(0);
    }


    //Find all User
    @Test
    @Order(12)
    public void getAllUser() {
        List<SetupUserEntity> setupUserEntitie = setupUserRepo.findAll();
        Assertions.assertThat(setupUserEntitie.size()).isGreaterThan(0);
    }

    //Update User by Id
    @Test
    @Order(13)
    @Rollback(value = false)
    public void updateUserById() {
        SetupUserEntity setupUserEntity = setupUserRepo.findById(103L).get();
        setupUserEntity.setName("Mr. Avaldas Taylor");
        SetupUserEntity setupUserEntityUpdated = setupUserRepo.save(setupUserEntity);
        Assertions.assertThat(setupUserEntityUpdated.getName()).isEqualTo("Mr. Avaldas Taylor");
    }

    //Delete User By Id
    @Test
    @Order(14)
    @Rollback(value = false)
    public void deleteUserById() {
        SetupUserEntity setupUserEntity = setupUserRepo.findById(103L).get();
        setupUserRepo.deleteById(103L);
        SetupUserEntity setupUserEntity1 = null;
        Optional<SetupUserEntity> optionalSetupUserEntity1 = setupUserRepo.findById(103L);
        if (optionalSetupUserEntity1.isPresent()) {
            setupUserEntity1 = optionalSetupUserEntity1.get();
        }
        Assertions.assertThat(setupUserEntity1).isNull();
    }


    ////=====Setup Task Status====////
    @Autowired
    private SetupTaskStatusRepo setupTaskStatusRepo;

    // Add New Task Status
    @Test
    @Order(15)
    @Rollback(value = false)
    void addTaskStatus() {
        SetupTaskStatusEntity setupTaskStatusEntity = SetupTaskStatusEntity.builder()
                .taskStatusName("Task Status Test")
                .build();
        setupTaskStatusRepo.save(setupTaskStatusEntity);
        Assertions.assertThat(setupTaskStatusEntity.getTaskStatusId()).isGreaterThan(0);
    }


    //Find all Task Status
    @Test
    @Order(16)
    public void getTaskStatusList() {
        List<SetupTaskStatusEntity> setupTaskStatusEntity = setupTaskStatusRepo.findAll();
        Assertions.assertThat(setupTaskStatusEntity.size()).isGreaterThan(0);
    }

    //Update Task Status by Id
    @Test
    @Order(17)
    @Rollback(value = false)
    public void updateTaskStatusById() {
        SetupTaskStatusEntity setupTaskStatusEntity = setupTaskStatusRepo.findById(7L).get();
        setupTaskStatusEntity.setTaskStatusName("Update Task Status");
        SetupTaskStatusEntity setupTaskStatusEntityUpdated = setupTaskStatusRepo.save(setupTaskStatusEntity);
        Assertions.assertThat(setupTaskStatusEntityUpdated.getTaskStatusName()).isEqualTo("Update Task Status");
    }

    //Delete Task Status By Id
    @Test
    @Order(18)
    @Rollback(value = false)
    public void deleteTaskStatusById() {
        SetupTaskStatusEntity setupTaskStatusEntity = setupTaskStatusRepo.findById(7L).get();
        setupTaskStatusRepo.deleteById(7L);
        SetupTaskStatusEntity setupTaskStatusEntity1 = null;
        Optional<SetupTaskStatusEntity> optionalSetupTaskStatusEntity1 = setupTaskStatusRepo.findById(7L);
        if (optionalSetupTaskStatusEntity1.isPresent()) {
            setupTaskStatusEntity1 = optionalSetupTaskStatusEntity1.get();
        }
        Assertions.assertThat(setupTaskStatusEntity1).isNull();
    }

    ////=====Setup Task Priority====////
    @Autowired
    private SetupPriorityRepo setupPriorityRepo;

    // Add New Task Priority
    @Test
    @Order(19)
    @Rollback(value = false)
    void addTaskPriority() {
        SetupPriorityEntity setupPriorityEntity = SetupPriorityEntity.builder()
                .priorityName("Priority Test")
                .build();
        setupPriorityRepo.save(setupPriorityEntity);
        Assertions.assertThat(setupPriorityEntity.getPriorityId()).isGreaterThan(0);
    }


    //Find all Task Priority
    @Test
    @Order(20)
    public void getTaskPriorityList() {
        List<SetupPriorityEntity> setupPriorityEntity = setupPriorityRepo.findAll();
        Assertions.assertThat(setupPriorityEntity.size()).isGreaterThan(0);
    }

    //Update Task Priority by Id
    @Test
    @Order(21)
    @Rollback(value = false)
    public void updatePriorityById() {
        SetupPriorityEntity setupPriorityEntity = setupPriorityRepo.findById(4L).get();
        setupPriorityEntity.setPriorityName("Update Task Status");
        SetupPriorityEntity setupPriorityEntityUpdated = setupPriorityRepo.save(setupPriorityEntity);
        Assertions.assertThat(setupPriorityEntityUpdated.getPriorityName()).isEqualTo("Update Task Status");
    }

    //Delete Task Status By Id
    @Test
    @Order(22)
    @Rollback(value = false)
    public void deletePriorityById() {
        SetupPriorityEntity setupPriorityEntity = setupPriorityRepo.findById(4L).get();
        setupPriorityRepo.deleteById(4L);
        SetupPriorityEntity setupPriorityEntity1 = null;
        Optional<SetupPriorityEntity> optionalSetupPriorityEntity1 = setupPriorityRepo.findById(4L);
        if (optionalSetupPriorityEntity1.isPresent()) {
            setupPriorityEntity1 = optionalSetupPriorityEntity1.get();
        }
        Assertions.assertThat(setupPriorityEntity1).isNull();
    }


}
