package com.example.EmployeeLeaveManagementSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private Long id;

    private String name;

    private String email;

    private String designation;

    private Long leaveBalance;

    private List<LeaveRequest> leaveRequests;

}
