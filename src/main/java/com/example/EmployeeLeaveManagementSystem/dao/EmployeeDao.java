package com.example.EmployeeLeaveManagementSystem.dao;

import com.example.EmployeeLeaveManagementSystem.pojo.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public void save(String name, String email, String designation) {
        String sql = "INSERT INTO employee (name, email, designation) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, email, designation);
    }

    public void update(String name, String email, String designation, Long leaveBalance, Long id) {
        String sql = "UPDATE employee SET name = ?, email = ?, designation = ?, leave_balance = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, email, designation, leaveBalance, id);
    }

    public List<Employee> findAll() {
        String sql = "SELECT e.id AS emp_id, e.name, e.email, e.designation, e.leave_balance FROM employee e ORDER BY e.id";
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> Employee.builder().id(rs.getLong("emp_id")).name(rs.getString("name")).email(rs.getString("email")).designation(rs.getString("designation")).leaveBalance(rs.getLong("leave_balance")).leaveRequests(new ArrayList<>()).build());
    }

    public Employee findEmployee(Long id) {
        String sql = "SELECT e.id AS emp_id, e.name, e.email, e.designation, e.leave_balance FROM employee e WHERE e.id = ?";
        return jdbcTemplate.query(sql, (ResultSet rs) -> rs.next() ? Employee.builder().id(rs.getLong("emp_id")).name(rs.getString("name")).email(rs.getString("email")).designation(rs.getString("designation")).leaveBalance(rs.getLong("leave_balance")).leaveRequests(new ArrayList<>()).build() : null, id);
    }



//    public List<Employee> findAllWithLeaves() {
//        String sql = "SELECT e.id AS emp_id, e.name, e.email, e.designation, e.leave_balance, " +
//                "lr.id AS lr_id, lr.start_date, lr.end_date, lr.reason, lr.status " +
//                "FROM employee e " +
//                "LEFT JOIN leave_request lr ON e.id = lr.employee_id " +
//                "ORDER BY e.id";
//        return jdbcTemplate.query(sql, (ResultSet rs) -> {
//            LinkedHashMap<Long, Employee> employeeLinkedHashMap = new LinkedHashMap<>();
//            while (rs.next()) {
//                Long empId = rs.getLong("emp_id");
//                employeeLinkedHashMap.putIfAbsent(empId, Employee.builder().id(empId).name(rs.getString("name")).email(rs.getString("email")).designation(rs.getString("designation")).leaveBalance(rs.getLong("leave_balance")).leaveRequests(new ArrayList<>()).build());
//                Long lrId = rs.getLong("lr_id");
//                if (lrId != 0) {
//                    Employee employee = employeeLinkedHashMap.get(empId);
//                    employee.getLeaveRequests().add(LeaveRequest.builder().id(lrId).startDate(rs.getDate("start_date")).endDate(rs.getDate("end_date")).reason(rs.getString("reason")).employee(employee).status(LeaveRequest.Status.valueOf(rs.getString("status"))).build());
//                }
//            }
//            return new ArrayList<>(employeeLinkedHashMap.values());
//        });
//    }
//
//    public Employee findEmployeeWithLeaves(Long id) {
//        String sql = "SELECT e.id AS emp_id, e.name, e.email, e.designation, e.leave_balance, " +
//                "lr.id AS lr_id, lr.start_date, lr.end_date, lr.reason, lr.status " +
//                "FROM employee e " +
//                "LEFT JOIN leave_request lr ON e.id = lr.employee_id " +
//                "WHERE e.id = ?";
//        return jdbcTemplate.query(sql, (ResultSet rs) -> {
//            Employee employee = null;
//            List<LeaveRequest> leaveRequests = new ArrayList<>();
//            while (rs.next()) {
//                if (employee == null) {
//                    employee = Employee.builder().id(rs.getLong("emp_id")).name(rs.getString("name")).email(rs.getString("email")).designation(rs.getString("designation")).leaveBalance(rs.getLong("leave_balance")).leaveRequests(leaveRequests).build();
//                }
//                Long lrId = rs.getLong("lr_id");
//                if (lrId != 0) {
//                    LeaveRequest leaveRequest = LeaveRequest.builder().id(lrId).startDate(rs.getDate("start_date")).endDate(rs.getDate("end_date")).reason(rs.getString("reason")).status(LeaveRequest.Status.valueOf(rs.getString("status"))).employee(employee).build();
//                    leaveRequests.add(leaveRequest);
//                }
//            }
//            return employee;
//        }, id);
//    }
}
