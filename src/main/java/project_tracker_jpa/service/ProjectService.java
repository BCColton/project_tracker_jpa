package project_tracker_jpa.service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project_tracker_jpa.dao.ProjectDao;
import project_tracker_jpa.entity.Project;

/**
 * @author Brian Colton
 */

@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public List<Project> fetchAllProjects() {
		return projectDao.findAll();
	}

	public Project fetchProjectById(Long projectId) {
		return findProjectById(projectId);
	}

	private Project findProjectById(Long projectId) {
		return projectDao.findById(projectId)
				.orElseThrow(() -> new NoSuchElementException("Project with ID=" + projectId + " was not found"));
	}

	@Transactional
	public Map<String, Boolean> deleteProject(Long projectId) {		
		projectDao.deleteById(projectId);
		return Map.of("deleted", true);
	}

	@Transactional
	public Project updateProject(Project project) {
		return projectDao.save(project);
	}

	@Transactional
	public Project addProject(Project project) {
		return projectDao.save(project);
	}

}
