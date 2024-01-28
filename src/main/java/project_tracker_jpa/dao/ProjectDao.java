package project_tracker_jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project_tracker_jpa.entity.Project;

/**
 * @author Brian Colton
 */

public interface ProjectDao extends JpaRepository<Project, Long> {
}
