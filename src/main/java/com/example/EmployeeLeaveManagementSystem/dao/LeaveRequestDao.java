package com.example.EmployeeLeaveManagementSystem.dao;

import com.example.EmployeeLeaveManagementSystem.dto.LeaveRequestDto;
import com.example.EmployeeLeaveManagementSystem.pojo.Employee;
import com.example.EmployeeLeaveManagementSystem.pojo.LeaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LeaveRequestDao {

    private final JdbcTemplate jdbcTemplate;

    public void save(LocalDate startDate, LocalDate endDate, String reason, Long employeeId) {
        String sql = "INSERT INTO leave_request (start_date, end_date, reason, employee_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, startDate, endDate, reason, employeeId);
    }

    public void update(LocalDate startDate, LocalDate endDate, String reason, LeaveRequest.Status status, Long employeeId, Long id) {
        String sql = "UPDATE leave_request SET start_date = ?, end_date = ?, reason = ?, status = ?, employee_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, startDate, endDate, reason, status.name(), employeeId, id);
    }

    public List<LeaveRequest> findAll() {
        String sql = "SELECT lr.id AS lr_id, lr.start_date, lr.end_date, lr.reason, lr.status FROM leave_request lr ORDER BY lr.id";
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> LeaveRequest.builder().id(rs.getLong("lr_id")).startDate(rs.getDate("start_date").toLocalDate()).endDate(rs.getDate("end_date").toLocalDate()).reason(rs.getString("reason")).status(LeaveRequest.Status.valueOf(rs.getString("status"))).build());
    }

    public LeaveRequest findLeaveRequest(Long id) {
        String sql = "SELECT lr.id AS lr_id, lr.start_date, lr.end_date, lr.reason, lr.status, lr.employee_id FROM leave_request lr WHERE lr.id = ?";
        return jdbcTemplate.query(sql, (ResultSet rs) -> rs.next() ? LeaveRequest.builder().id(rs.getLong("lr_id")).startDate(rs.getDate("start_date").toLocalDate()).endDate(rs.getDate("end_date").toLocalDate()).reason(rs.getString("reason")).status(LeaveRequest.Status.valueOf(rs.getString("status"))).employee(Employee.builder().id(rs.getLong("employee_id")).build()).build() : null, id);
    }

    public List<LeaveRequestDto> findPendingLeaveRequests() {
        String sql = "SELECT lr.id AS lr_id, lr.start_date, lr.end_date, lr.reason, lr.status, lr.employee_id, " +
                "e.id AS emp_id, e.name, e.email, e.designation, e.leave_balance " +
                "FROM leave_request lr " +
                "LEFT JOIN employee e ON lr.employee_id = e.id " +
                "WHERE lr.status = 'PENDING' " +
                "AND CURDATE() < lr.start_date " +
                "AND e.leave_balance > 0 " +
                "ORDER BY lr.start_date ";
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> LeaveRequestDto.builder().id(rs.getLong("lr_id")).startDate(rs.getDate("start_date").toLocalDate()).endDate(rs.getDate("end_date").toLocalDate()).reason(rs.getString("reason")).status(LeaveRequest.Status.valueOf(rs.getString("status"))).employeeId(rs.getLong("employee_id")).name(rs.getString("name")).email(rs.getString("email")).designation(rs.getString("designation")).leaveBalance(rs.getLong("leave_balance")).build());
    }

}
