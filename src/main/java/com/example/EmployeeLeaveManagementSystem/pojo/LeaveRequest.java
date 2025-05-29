package com.example.EmployeeLeaveManagementSystem.pojo;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    @ToString.Exclude
    private Employee employee;

    private Status status;

    public enum Status {
        PENDING, APPROVED, REJECTED
    }

}