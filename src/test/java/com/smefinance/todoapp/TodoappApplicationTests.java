package com.smefinance.todoapp;

import com.smefinance.todoapp.operation.task_assign.entity.TaskAssignEntity;
import com.smefinance.todoapp.operation.task_assign.repository.TaskAssignRepo;
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

    @Test
    @Order(2)
    public void getTaskById() {
        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(15L).get();
        Assertions.assertThat(taskAssignEntity.getId()).isEqualTo(15L);
    }

    @Test
    @Order(3)
    public void getAllTaskByUserId() {
        List<TaskAssignEntity> taskAssignEntity = taskAssignRepo.findAll();
        Assertions.assertThat(taskAssignEntity.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
	@Rollback(value = false)
    public void updateTask() {
        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(36L).get();
        taskAssignEntity.setTaskStatusId("3");
        TaskAssignEntity taskAssignEntityUpdated = taskAssignRepo.save(taskAssignEntity);
        Assertions.assertThat(taskAssignEntityUpdated.getTaskStatusId()).isEqualTo("3");
    }


//    @Test
//	@Order(5)
//	@Rollback(value = false)
//    public void deleteTaskById() {
//        TaskAssignEntity taskAssignEntity = taskAssignRepo.findById(17L).get();
//        taskAssignRepo.delete(taskAssignEntity);
//        TaskAssignEntity taskAssignEntity1 = null;
//        Optional<TaskAssignEntity> optionalTaskAssignEntity = taskAssignRepo.findById(17L);
//        if (optionalTaskAssignEntity.isPresent()) {
//            taskAssignEntity1 = optionalTaskAssignEntity.get();
//        }
//        Assertions.assertThat(taskAssignEntity1).isNull();
//    }

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

//    @Autowired
//	private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//	private DataSource dataSource;


}
