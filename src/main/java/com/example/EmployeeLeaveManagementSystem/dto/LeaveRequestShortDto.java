package com.example.EmployeeLeaveManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequestShortDto {

    private Long empId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

}
