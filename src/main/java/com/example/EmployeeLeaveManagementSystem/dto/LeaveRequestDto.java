package com.example.EmployeeLeaveManagementSystem.dto;

import com.example.EmployeeLeaveManagementSystem.pojo.LeaveRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequestDto {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private LeaveRequest.Status status;

    private Long employeeId;

    private String name;

    private String email;

    private String designation;

    private Long leaveBalance;


    public enum Status {
        PENDING, APPROVED, REJECTED
    }

}
