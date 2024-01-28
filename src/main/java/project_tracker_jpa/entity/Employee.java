package project_tracker_jpa.entity;

import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String Trade;
	@Column
	private Date dob;
	@Column
	private Double hourlyRate; 
	
	@ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	@JsonBackReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Project> projects;

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects; 
	}
	
	
	
}
