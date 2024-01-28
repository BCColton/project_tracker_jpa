package project_tracker_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project_tracker_jpa.entity.Employee;
import project_tracker_jpa.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> fetchAllEmployee() {
		log.info("Retrieving all employees");
		List<Employee> employees = employeeService.fetchAllEmployees();
		log.info("Employees retrieved");
		return employees;
		
	}
	
	@GetMapping("/{employeeId}")
	public Employee fetchEmployeeById(@PathVariable Long employeeId) {
		log.info("Retrieving employee with ID={}", employeeId);
		return employeeService.fetchEmployeeById(employeeId);
	}
	
}
