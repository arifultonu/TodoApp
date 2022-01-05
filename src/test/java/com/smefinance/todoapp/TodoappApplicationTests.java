package com.smefinance.todoapp;

import com.smefinance.todoapp.operation.comments.entity.CommentsEntity;
import com.smefinance.todoapp.operation.comments.repository.CommentsRepo;
import com.smefinance.todoapp.operation.comments.service.CommentsService;
import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import com.smefinance.todoapp.operation.task_assign.repository.TaskAssignRepo;
import com.smefinance.todoapp.setup.entity.SetupTaskStatusEntity;
import com.smefinance.todoapp.setup.entity.SetupUserEntity;
import com.smefinance.todoapp.setup.repository.SetupTaskStatusRepo;
import com.smefinance.todoapp.setup.repository.SetupUserRepo;
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
//@SpringBootTest
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
        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(36L).get();
        taskAssignEntity.setTaskStatusId("3");
        TaskAssignEntity taskAssignEntityUpdated = taskAssignRepo.save(taskAssignEntity);
        Assertions.assertThat(taskAssignEntityUpdated.getTaskStatusId()).isEqualTo("3");
    }


    //Delete Task By Id
    @Test
    @Order(6)
    @Rollback(value = false)
    public void deleteById() {
        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(22L).get();
        taskAssignRepo.deleteById(22L);
        TaskAssignEntity taskAssignEntity1 = null;
        Optional<TaskAssignEntity> optionalTaskAssignEntity = taskAssignRepo.findById(22L);
        if (optionalTaskAssignEntity.isPresent()) {
            taskAssignEntity1 = optionalTaskAssignEntity.get();
        }
        Assertions.assertThat(taskAssignEntity1).isNull();
    }

    //Get All Task By User Id
    @Test
    @Order(7)
    public void getAllTaskByAdminUserId() {
        List<TaskAssignEntity> taskAssignEntity = taskAssignRepo.findByAdminUserIdOrderByPriorityIdAsc("2");
        Assertions.assertThat(taskAssignEntity.size()).isGreaterThan(0);
    }


    //Update Task Status by Id
    @Test
    @Order(8)
    @Rollback(value = false)
    public void updateTaskById() {
        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(25L).get();
        taskAssignEntity.setTaskStatusId("2");
        TaskAssignEntity taskAssignEntityUpdated = taskAssignRepo.save(taskAssignEntity);
        Assertions.assertThat(taskAssignEntityUpdated.getTaskStatusId()).isEqualTo("2");
    }


////========Comments=======////

    @Autowired
    private CommentsRepo commentsRepo;
    @Autowired
    private CommentsService commentsService;

    // Add New Comment against a task
    @Test
    @Order(9)
    @Rollback(value = false)
    void saveComment() {
        CommentsEntity commentsEntity = CommentsEntity.builder()
                .taskId("2")
                .assignUserId("2")
                .comments("Test comment from unit test")
                .date("2022/01/12")
                .build();
        commentsService.addComment(commentsEntity);
        Assertions.assertThat(commentsEntity.getId()).isGreaterThan(0);
    }

    //Find all comments by Task Id
    @Test
    @Order(11)
    public void getAllCommentByTaskId() {
        List<CommentsEntity> commentsEntity = commentsService.getCommentsByTaskId("2");
        Assertions.assertThat(commentsEntity.size()).isGreaterThan(0);
    }

    //Delete Comment By Id
    @Test
    @Order(12)
    @Rollback(value = false)
    public void deleteCommentById() {
        CommentsEntity commentsEntity = commentsRepo.findById(2L).get();
        commentsService.deleteCommentByTaskId("2");
        CommentsEntity commentsEntity1 = null;
        Optional<CommentsEntity> optionalCommentsEntity1 = commentsRepo.findById(2L);
        if (optionalCommentsEntity1.isPresent()) {
            commentsEntity1 = optionalCommentsEntity1.get();
        }
        Assertions.assertThat(commentsEntity1).isNull();
    }


    ////=====Setup User====////
    @Autowired
    private SetupUserService setupUserService;
    @Autowired
    private SetupUserRepo setupUserRepo;

    // Add/Registration New User
    @Test
    @Order(13)
    @Rollback(value = false)
    void addUser() {
        SetupUserEntity setupUserEntity = SetupUserEntity.builder()
                .email("avaldas@gmail.com")
                .name("Avaldas Taylas")
                .password("123456")
                .username("avaldas")
                .role("Admin")
                .build();
        setupUserService.addUser(setupUserEntity);
        Assertions.assertThat(setupUserEntity.getId()).isGreaterThan(0);
    }


    //Find all User
    @Test
    @Order(14)
    public void getAllUser() {
        List<SetupUserEntity> setupUserEntitie = setupUserService.getAllUserList();
        Assertions.assertThat(setupUserEntitie.size()).isGreaterThan(0);
    }

    //Update User by Id
    @Test
    @Order(15)
    @Rollback(value = false)
    public void updateUserById() {
        SetupUserEntity setupUserEntity = setupUserRepo.findById(3L).get();
        setupUserEntity.setName("Mr. Avaldas Taylor");
        SetupUserEntity setupUserEntityUpdated = setupUserRepo.save(setupUserEntity);
        Assertions.assertThat(setupUserEntityUpdated.getName()).isEqualTo("Mr. Avaldas Taylor");
    }

    //Delete User By Id
    @Test
    @Order(16)
    @Rollback(value = false)
    public void deleteUserById() {
        SetupUserEntity setupUserEntity = setupUserRepo.findById(4L).get();
        setupUserService.deleteUser(4L);
        SetupUserEntity setupUserEntity1 = null;
        Optional<SetupUserEntity> optionalSetupUserEntity1 = setupUserRepo.findById(4L);
        if (optionalSetupUserEntity1.isPresent()) {
            setupUserEntity1 = optionalSetupUserEntity1.get();
        }
        Assertions.assertThat(setupUserEntity1).isNull();
    }


    ////=====Setup Task Status====////
    @Autowired
    private SetupTaskStatusService setupTaskStatusService;
    @Autowired
    private SetupTaskStatusRepo setupTaskStatusRepo;

    // Add New Task Status
    @Test
    @Order(13)
    @Rollback(value = false)
    void addTaskStatus() {
        SetupTaskStatusEntity setupTaskStatusEntity = SetupTaskStatusEntity.builder()
                .taskStatusName("Task Status Test")
                .build();
        setupTaskStatusService.addTaskStatus(setupTaskStatusEntity);
        Assertions.assertThat(setupTaskStatusEntity.getTaskStatusId()).isGreaterThan(0);
    }


    //Find all Task Status
    @Test
    @Order(14)
    public void getTaskStatusList() {
        List<SetupTaskStatusEntity> setupTaskStatusEntity = setupTaskStatusService.getAllTaskStatusList();
        Assertions.assertThat(setupTaskStatusEntity.size()).isGreaterThan(0);
    }

    //Update Task Status by Id
    @Test
    @Order(15)
    @Rollback(value = false)
    public void updateTaskStatusById() {
        SetupTaskStatusEntity setupTaskStatusEntity = setupTaskStatusRepo.findById(3L).get();
        setupTaskStatusEntity.setTaskStatusName("Update Task Status");
        SetupTaskStatusEntity setupTaskStatusEntityUpdated = setupTaskStatusRepo.save(setupTaskStatusEntity);
        Assertions.assertThat(setupTaskStatusEntityUpdated.getTaskStatusName()).isEqualTo("Update Task Status");
    }

    //Delete Task Status By Id
    @Test
    @Order(16)
    @Rollback(value = false)
    public void deleteTaskStatusById() {
        SetupTaskStatusEntity setupTaskStatusEntity = setupTaskStatusRepo.findById(4L).get();
        setupTaskStatusService.deleteTaskStatus(4L);
        SetupTaskStatusEntity setupTaskStatusEntity1 = null;
        Optional<SetupTaskStatusEntity> optionalSetupTaskStatusEntity1 = setupTaskStatusRepo.findById(4L);
        if (optionalSetupTaskStatusEntity1.isPresent()) {
            setupTaskStatusEntity1 = optionalSetupTaskStatusEntity1.get();
        }
        Assertions.assertThat(setupTaskStatusEntity1).isNull();
    }



}
