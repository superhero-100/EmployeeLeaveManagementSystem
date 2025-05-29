package com.example.EmployeeLeaveManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @Min(value = 0, message = "Leave balance must be non-negative")
    private Long leaveBalance;

}
