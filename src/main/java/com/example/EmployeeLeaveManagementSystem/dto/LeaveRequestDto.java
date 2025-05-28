package com.example.EmployeeLeaveManagementSystem.dto;

import com.example.EmployeeLeaveManagementSystem.pojo.LeaveRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequestDto {

    private Long id;

    private Date startDate;

    private Date endDate;

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
