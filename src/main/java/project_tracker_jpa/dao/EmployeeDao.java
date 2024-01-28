package project_tracker_jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project_tracker_jpa.entity.Employee;

/**
 * @author Brian Colton
 */

public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
