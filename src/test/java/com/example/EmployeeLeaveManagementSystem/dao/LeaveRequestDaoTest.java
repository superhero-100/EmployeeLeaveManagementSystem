package com.example.EmployeeLeaveManagementSystem.dao;

import com.example.EmployeeLeaveManagementSystem.config.JdbcConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {JdbcConfig.class, LeaveRequestDao.class})
//@Transactional
//@Rollback
class LeaveRequestDaoTest {

    @Autowired
    private LeaveRequestDao leaveRequestDto;

    @Test
    void findPendingLeaveRequests() {
        System.out.println(leaveRequestDto.findPendingLeaveRequests());
    }

//    @Test
//    void findAll() {
//        System.out.println(leaveRequestDto.findAll());
//    }
//
//    @Test
//    void findLeaveRequest() {
//        System.out.println(leaveRequestDto.findLeaveRequest(1l));
//    }
//
//    @Test
//    void findPendingLeaveRequests() {
//        System.out.println(leaveRequestDto.findPendingLeaveRequests());
//    }

//    @Test
//    void save() {
//        leaveRequestDto.save(Date.valueOf("2025-06-01"),Date.valueOf("2025-06-05"),"Medical Leave",9l);
//        leaveRequestDto.save(Date.valueOf("2025-06-08"),Date.valueOf("2025-06-10"),"Medical Leave",9l);
//        leaveRequestDto.save(Date.valueOf("2025-06-01"),Date.valueOf("2025-06-05"),"Medical Leave",10l);
//    }
//
//    @Test
//    void update() {
//        leaveRequestDto.update(Date.valueOf("2025-06-01"),Date.valueOf("2025-06-05"),"Medical Leave", LeaveRequest.Status.APPROVED,9l,1l);
//        leaveRequestDto.update(Date.valueOf("2025-06-01"),Date.valueOf("2025-06-05"),"Medical Leave", LeaveRequest.Status.REJECTED,10l,3l);
//    }

}