package com.example.EmployeeLeaveManagementSystem.controller;

import com.example.EmployeeLeaveManagementSystem.dao.EmployeeDao;
import com.example.EmployeeLeaveManagementSystem.dao.LeaveRequestDao;
import com.example.EmployeeLeaveManagementSystem.dto.EmployeeDto;
import com.example.EmployeeLeaveManagementSystem.dto.LeaveRequestDto;
import com.example.EmployeeLeaveManagementSystem.dto.LeaveRequestShortDto;
import com.example.EmployeeLeaveManagementSystem.pojo.Employee;
import com.example.EmployeeLeaveManagementSystem.pojo.LeaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final EmployeeDao employeeDao;
    private final LeaveRequestDao leaveRequestDao;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/employee/add")
    public String getAddEmployeePage(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "addEmployee";
    }

    @PostMapping("/employee/add")
    public String addEmployee(
            @Valid @ModelAttribute("employee") EmployeeDto employee,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "addEmployee";
        }
        employeeDao.save(employee.getName(), employee.getEmail(), employee.getDesignation(), employee.getLeaveBalance());
        return successPage("Employee Added Successfully.", model);
    }

    @GetMapping("/employee/list")
    public String listEmployeePage(Model model) {
        List<Employee> employees = employeeDao.findAll();
        model.addAttribute("employees", employees);
        return "listEmployees";
    }

    @GetMapping("/leaveBalance/add/{empId}")
    public String showAddLeaveForm(@PathVariable("empId") Long empId, Model model) {
        model.addAttribute("empId", empId);
        return "addLeaveBalance";
    }

    @PostMapping("/leaveBalance/add/{empId}")
    public String updateEmployeeLeaveBalance(@PathVariable("empId") Long empId, @RequestParam("leaveBalence") Long leaveBalence, Model model) {
        Employee employee = employeeDao.findEmployee(empId);
        employeeDao.update(employee.getName(), employee.getEmail(), employee.getDesignation(), (employee.getLeaveBalance() + leaveBalence), empId);
        return successPage("Leave Balance Added Successfully.", model);
    }

    @GetMapping("/leaveRequest/submit")
    public String leaveRequestPage(Model model) {
        List<Employee> employees = employeeDao.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("leaveRequest", new LeaveRequestShortDto());
        return "submitLeaveRequest";
    }

    @PostMapping("/leaveRequest/submit")
    public String submitLeaveRequest(
            @Valid @ModelAttribute("leaveRequest") LeaveRequestShortDto leaveRequest,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("employees", employeeDao.findAll());
            return "submitLeaveRequest";
        }
        leaveRequestDao.save(leaveRequest.getStartDate(), leaveRequest.getEndDate(), leaveRequest.getReason(), leaveRequest.getEmpId());
        return successPage("Leave Request Submitted Added Successfully.", model);
    }

    @GetMapping("/leaveRequest/list")
    public String listLeaveRequests(Model model) {
        List<LeaveRequestDto> requests = leaveRequestDao.findPendingLeaveRequests();
        model.addAttribute("leaveRequests", requests);
        return "viewLeaveRequests";
    }

    @GetMapping("/leaveRequest/approve/{id}")
    public String approveLeaveRequest(@PathVariable("id") Long id, Model model) {
        LeaveRequest leaveRequest = leaveRequestDao.findLeaveRequest(id);
        if (leaveRequest.getStatus() != LeaveRequest.Status.PENDING) {
            return errorPage("Action Performed Already.", model);
        }
        Employee employee = employeeDao.findEmployee(leaveRequest.getEmployee().getId());
        if (!(employee.getLeaveBalance() > 0)) {
            return errorPage("Employee Does Not Have Any Leave Balance.", model);
        }
        employeeDao.update(employee.getName(), employee.getEmail(), employee.getDesignation(), employee.getLeaveBalance() - 1, leaveRequest.getEmployee().getId());
        leaveRequestDao.update(leaveRequest.getStartDate(), leaveRequest.getEndDate(), leaveRequest.getReason(), LeaveRequest.Status.APPROVED, leaveRequest.getEmployee().getId(), leaveRequest.getId());
        return successPage("Leave Request Approved.", model);
    }

    @GetMapping("/leaveRequest/reject/{id}")
    public String rejectLeaveRequest(@PathVariable("id") Long id, Model model) {
        LeaveRequest leaveRequest = leaveRequestDao.findLeaveRequest(id);
        if (leaveRequest.getStatus() != LeaveRequest.Status.PENDING) {
            return errorPage("Action Performed Already.", model);
        }
        leaveRequestDao.update(leaveRequest.getStartDate(), leaveRequest.getEndDate(), leaveRequest.getReason(), LeaveRequest.Status.REJECTED, leaveRequest.getEmployee().getId(), leaveRequest.getId());
        return successPage("Leave Request Rejected.", model);
    }

    private String successPage(String message, Model model) {
        model.addAttribute("message", message);
        return "success";
    }

    private String errorPage(String error, Model model) {
        model.addAttribute("error", error);
        return "success";
    }

}
