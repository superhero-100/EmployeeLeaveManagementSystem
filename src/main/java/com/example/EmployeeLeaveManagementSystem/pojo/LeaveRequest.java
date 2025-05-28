package com.example.EmployeeLeaveManagementSystem.pojo;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {

    private Long id;

    private Date startDate;

    private Date endDate;

    private String reason;

    @ToString.Exclude
    private Employee employee;

    private Status status;

    public enum Status {
        PENDING, APPROVED, REJECTED
    }

}