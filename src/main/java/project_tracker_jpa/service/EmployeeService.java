package project_tracker_jpa.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project_tracker_jpa.dao.EmployeeDao;
import project_tracker_jpa.entity.Employee;

/**
 * @author Brian Colton
 */

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> fetchAllEmployees() {
		return employeeDao.findAll();		
	}

	public Employee fetchEmployeeById(Long employeeId) {
		return findEmployeeById(employeeId);
	}

	private Employee findEmployeeById(Long employeeId) {
		return employeeDao.findById(employeeId)
				.orElseThrow(() -> new NoSuchElementException(
						"Employee with Id=" + employeeId + " was not found"));
	}

	@Transactional
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
		
	}
}
