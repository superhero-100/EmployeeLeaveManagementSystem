package com.example.EmployeeLeaveManagementSystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements InitializingBean {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void afterPropertiesSet() {
        createTables();
    }

    private void createTables() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS employee (" +
                "    id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "    name VARCHAR(100) NOT NULL," +
                "    email VARCHAR(150) NOT NULL UNIQUE," +
                "    designation VARCHAR(100)," +
                "    leave_balance BIGINT DEFAULT 0" +
                ");");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS leave_request (" +
                "    id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "    start_date DATE NOT NULL," +
                "    end_date DATE NOT NULL," +
                "    reason TEXT," +
                "    status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING'," +
                "    employee_id BIGINT NOT NULL," +
                "    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE" +
                ");");
    }
}
