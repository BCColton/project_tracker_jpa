package project_tracker_jpa.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project_tracker_jpa.entity.Employee;
import project_tracker_jpa.entity.House;
import project_tracker_jpa.entity.Project;
import project_tracker_jpa.service.ProjectService;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private HouseController houseController;
	
	@PostMapping("/add/name={name}&house={houseId}&budget={budget}&startDate={startDate}")
	public Project addProject(@PathVariable String name,
							  @PathVariable Long houseId,
							  @PathVariable Double budget,
							  @PathVariable Date startDate) {
		Project project = new Project();
		
		project.setName(name);
		project.setHouse(houseController.fetchHouseById(houseId));
		project.setStatus("In Planning");
		project.setBudget(budget);
		project.setBidValue(budget * 1.2);
		project.setAmountPaid(0.0);
		project.setStartDate(startDate);
		project.setEstimatedEndDate(Date.valueOf(startDate.toLocalDate().plusMonths(1)));
		project.setActualEndDate(Date.valueOf("9999-01-01"));
		
		return projectService.addProject(project);
	}
	
	
	@GetMapping
	public List<Project> fetchAllProject() {
		log.info("Retrieving all projects");
		List<Project> projects = projectService.fetchAllProjects();
		log.info("Projects retrieved");
		return projects;
		
	}
	
	@GetMapping("/{projectId}")
	public Project fetchProjectById(@PathVariable Long projectId) {
		log.info("Retrieving project with ID={}", projectId);
		return projectService.fetchProjectById(projectId);
	}
	
	@PutMapping("/{projectId}/name={value}")
	public Project updateProjectName(@PathVariable Long projectId, @PathVariable String value) {
		log.info("Updating project with ID={}", projectId);
		Project project = projectService.fetchProjectById(projectId);
		project.setName(value);
		return projectService.updateProject(project);		
	}
	
	@DeleteMapping("/{projectId}")
	public Map<String, Boolean> deleteProject(@PathVariable Long projectId) {
		log.info("Deleting project with ID={}");
		Project project = fetchProjectById(projectId);
		project.setHouse(new House()); //Decouples the project from it's house;
		project.setEmployees(new ArrayList<Employee>());; //Decouples the project from it's employees
		projectService.updateProject(project);
		return projectService.deleteProject(projectId);
	}

}
