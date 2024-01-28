package project_tracker_jpa.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity  
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	@Column
	private String name;
	@Column
	private String status;
	@Column
	private Double budget;
	@Column
	private Date startDate;
	@Column
	private Date estimatedEndDate;
	@Column
	private Date actualEndDate;
	@Column
	private Double bidValue;
	@Column
	private Double amountPaid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "house_id", nullable = false)
	@JsonManagedReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private House house;
	
	@ManyToMany()
	@JoinTable(name = "employee_project",
		joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "projectId"),
		inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employeeId"))
	@JsonManagedReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> list) {
		this.employees = list;
	}
	
	
	
	
}
