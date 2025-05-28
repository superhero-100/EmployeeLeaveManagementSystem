package com.example.EmployeeLeaveManagementSystem.dao;

import com.example.EmployeeLeaveManagementSystem.config.JdbcConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {JdbcConfig.class, EmployeeDao.class})
//@Transactional
//@Rollback
class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

//    @Test
//    void findAll() {
//        employeeDao.findAll().forEach(System.out::println);
//    }
//
//    @Test
//    void findEmployee() {
//        System.out.println(employeeDao.findEmployee(9l));
//    }

//    @Test
//    void findEmployeeWithLeaves() {
//        System.out.println(employeeDao.findEmployeeWithLeaves(9l));
//    }

//    @Test
//    void findAllWithLeaves() {
//        employeeDao.findAllWithLeaves().forEach(System.out::println);
//    }

//    @Test
//    @Order(1)
//    void save() {
//        employeeDao.save("Sahil", "sahil@gmail.com", "Java Trainee");
//        employeeDao.save("Raju", "raju@gmail.com", "JS Trainee");
//    }

//    @Test
//    @Order(2)
//    void update() {
//        employeeDao.update("Sahil", "sahil@gmail.com", "Java Trainee", 3l, 9l);
//        employeeDao.update("Raju", "raju@gmail.com", "JS Trainee", 2l, 10l);
//    }

}